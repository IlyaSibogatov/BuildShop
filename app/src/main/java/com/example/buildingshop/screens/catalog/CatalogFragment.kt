package com.example.buildingshop.screens.catalog

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.buildingshop.R
import com.example.buildingshop.adapters.CatalogAdapter
import com.example.buildingshop.databinding.FragmentCatalogBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint
class CatalogFragment : Fragment(R.layout.fragment_catalog) {
    private lateinit var rvAdapter: CatalogAdapter
    private lateinit var controller: NavController
    private lateinit var binding: FragmentCatalogBinding

    lateinit var viewModel: CatalogViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCatalogBinding.bind(view)
        viewModel = ViewModelProvider(this)[CatalogViewModel::class.java]
        controller = findNavController()
        rvAdapter = CatalogAdapter { item ->
            val bundle = Bundle()
            bundle.putParcelable("catalogItem", item)
            controller.navigate(R.id.detailsFragment, bundle)
        }

        initViews()
        subscribeToData()
    }

    private fun initViews() {
        binding.apply {
            catalogRv.adapter = rvAdapter
        }
    }

    private fun subscribeToData() {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.uiState.collectLatest {
                rvAdapter.setList(it.list)
                binding.progressBar.isVisible = it.isLoading
            }
        }
    }
}