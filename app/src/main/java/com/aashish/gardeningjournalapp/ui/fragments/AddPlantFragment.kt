package com.aashish.gardeningjournalapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.aashish.gardeningjournalapp.R
import com.aashish.gardeningjournalapp.databinding.FragmentAddPlantBinding
import com.aashish.gardeningjournalapp.domain.dto.PlantDTO
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModel
import com.aashish.gardeningjournalapp.ui.viewModel.PlantViewModelFactory

class AddPlantFragment : Fragment() {
    private lateinit var binding: FragmentAddPlantBinding
    private lateinit var viewModel: PlantViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_add_plant, container, false)
        binding = FragmentAddPlantBinding.bind(view)

        val viewModelFactory = PlantViewModelFactory(requireActivity().application)
        viewModel = ViewModelProvider(this, viewModelFactory)[PlantViewModel::class.java]

        return binding.root
    }

    // Deprecated
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.buttonSave.setOnClickListener {
            val name = binding.editTextPlantName.text.toString()
            val type = binding.editTextPlantType.text.toString()
            val waterFrequency = binding.editTextWaterFrequency.text.toString()
            val date = binding.editTextPlantDate.text.toString()

            if(name.isEmpty() || type.isEmpty() || waterFrequency.isEmpty() || date.isEmpty()){
                Toast.makeText(context, "All fields are required", Toast.LENGTH_LONG).show()
            }else {
                val plant = PlantDTO(
                    id = null,
                    name = name,
                    type = type,
                    wateringFrequency = waterFrequency.toInt(),
                    plantDate = date
                )
                viewModel.insertPlant(plant)
                onSuccess()
            }
        }
    }

    private fun onSuccess(){
        binding.editTextPlantName.text.clear()
        binding.editTextPlantType.text.clear()
        binding.editTextWaterFrequency.text.clear()
        binding.editTextPlantDate.text.clear()
        Toast.makeText(context, "Plant Saved", Toast.LENGTH_SHORT).show()
    }
}