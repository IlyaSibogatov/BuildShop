package com.example.buildingshop.screens.main

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.buildingshop.R
import com.example.buildingshop.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var controller: NavController
    private lateinit var binding: FragmentMainBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        controller = findNavController()
        binding = FragmentMainBinding.bind(view)
        binding.apply {
            toCatalogBtn.setOnClickListener {
                controller.navigate(R.id.catalogList)
            }
        }
    }
}