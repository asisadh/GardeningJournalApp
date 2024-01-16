package com.aashish.gardeningjournalapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aashish.gardeningjournalapp.R
import com.aashish.gardeningjournalapp.ui.adapters.PlantAdapter
import com.aashish.gardeningjournalapp.domain.dto.PlantDTO
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModel
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton

/**
 * A simple [Fragment] subclass.
 * Use the [GardenLogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GardenLogFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var plantViewModel: PlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_garden_log, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)

        val viewModelFactory = PlantViewModelFactory(requireActivity().application)
        plantViewModel = ViewModelProvider(this, viewModelFactory)[PlantViewModel::class.java]

        plantAdapter = PlantAdapter(::showDetailPage)
        recyclerView.adapter = plantAdapter

        plantViewModel.getAllPlants.observe(viewLifecycleOwner) { plants ->
            plants?.let {
                updateRecyclerViewOnUIThread(it)
            }
        }

        val fab = view.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            val directions = GardenLogFragmentDirections.actionGardenLogFragmentToAddPlantFragment()
            findNavController().navigate(directions)
        }

        (activity as? AppCompatActivity)?.supportActionBar?.title = "Garden Logs"

        return view
    }

    private fun showDetailPage(id: Int){
        val directions = GardenLogFragmentDirections.actionGardenLogFragmentToPlantDetailsFragment(id)
        findNavController().navigate(directions)
    }

    private fun updateRecyclerViewOnUIThread(updatedList: List<PlantDTO>) {
        activity?.runOnUiThread {
            plantAdapter.setPlants(updatedList)
        }
    }
}