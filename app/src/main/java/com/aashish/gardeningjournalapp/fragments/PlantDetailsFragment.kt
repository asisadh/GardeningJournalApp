package com.aashish.gardeningjournalapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.aashish.gardeningjournalapp.R

/**
 * A simple [Fragment] subclass.
 * Use the [PlantDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlantDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_plant_details, container, false)
    }
}