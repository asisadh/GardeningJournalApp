package com.aashish.gardeningjournalapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aashish.gardeningjournalapp.R
import com.aashish.gardeningjournalapp.adapters.PlantAdapter
import com.aashish.gardeningjournalapp.model.Plant

/**
 * A simple [Fragment] subclass.
 * Use the [GardenLogFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GardenLogFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var plantAdapter: PlantAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_garden_log, container, false)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context, 2)
        plantAdapter = PlantAdapter(getPlantList())
        recyclerView.adapter = plantAdapter

        return view
    }

    private fun getPlantList(): List<Plant> {
        // Create a list of Plant objects
        return listOf(
            Plant("Rose", "Flower"),
            Plant("Bamboo", "Grass"),
            Plant("Lily", "Flower"),
            Plant("Fern", "Foliage"),
            Plant("Succulent", "Cactus"),
            Plant("Maple", "Tree"),
            Plant("Tulip", "Flower"),
            Plant("Cactus", "Cactus"),
            Plant("Daisy", "Flower"),
            Plant("Palm", "Tree")
        )
    }
}