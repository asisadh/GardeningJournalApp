package com.aashish.gardeningjournalapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.aashish.gardeningjournalapp.R
import com.aashish.gardeningjournalapp.Utils
import com.aashish.gardeningjournalapp.databinding.FragmentPlantDetailsBinding
import com.aashish.gardeningjournalapp.domain.dto.PlantDTO
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModel
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModelFactory
import kotlinx.coroutines.launch

class PlantDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentPlantDetailsBinding
    private lateinit var viewModel: PlantViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_plant_details, container, false)
        binding = FragmentPlantDetailsBinding.bind(view)

        val viewModelFactory = PlantViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory)[PlantViewModel::class.java]

        val plantId = arguments?.getInt("id")

//        plantId?.let {
//            launch {
//                val plant = viewModel.getPlant(plantId)
//                withContext(Dispatchers.Main){
//                    setupDetailPage(plant)
//                }
//            }
//        }

        launch {
            plantId?.let {
                viewModel.getPlant(plantId).observe(viewLifecycleOwner, ::setupDetailPage)
            }
        }
        return binding.root
    }

    private fun setupDetailPage(currentPlant: PlantDTO?){
        binding.plantNameTextView.text = currentPlant?.name
        binding.typeOfPlantTextView.text = currentPlant?.type
        binding.waterFrequencyTextView.text = "Water Frequency: ${currentPlant?.wateringFrequency}"
        binding.plantingDateTextView.text = currentPlant?.plantDate
        binding.backgroundImageView.setImageResource(Utils.mapIdToImageName(currentPlant?.id ?: 0))

        (activity as? AppCompatActivity)?.supportActionBar?.title = currentPlant?.name ?: "Detail"
    }
}