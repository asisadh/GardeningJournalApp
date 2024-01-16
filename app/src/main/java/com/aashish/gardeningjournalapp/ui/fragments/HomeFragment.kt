package com.aashish.gardeningjournalapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.InvalidationTracker
import com.aashish.gardeningjournalapp.R
import com.aashish.gardeningjournalapp.databinding.FragmentHomeBinding
import com.aashish.gardeningjournalapp.domain.dto.PlantDTO
import com.aashish.gardeningjournalapp.ui.adapters.PlantAdapter
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModel
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModelFactory

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter
    private lateinit var plantViewModel: PlantViewModel
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        binding = FragmentHomeBinding.bind(view)

        binding.gardenLog.setOnClickListener {
            val directions = HomeFragmentDirections.actionHomeFragmentToGardenLogFragment()
            findNavController().navigate(directions)
        }

        (activity as? AppCompatActivity)?.supportActionBar?.title = "Home"

        recyclerView = binding.recyclerView
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


        return binding.root
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