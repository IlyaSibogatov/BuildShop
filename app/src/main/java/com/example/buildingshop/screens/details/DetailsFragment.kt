package com.example.buildingshop.screens.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.buildingshop.R
import com.example.buildingshop.databinding.FragmentDetailsBinding
import com.example.buildingshop.remote.models.CatalogItem
import com.example.buildingshop.utils.Constants.IMAGE_PATH
import com.example.buildingshop.utils.setImageUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment(R.layout.fragment_details) {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var product: CatalogItem
    lateinit var viewModel: DetailsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDetailsBinding.bind(view)
        viewModel = ViewModelProvider(this)[DetailsViewModel::class.java]
        binding.apply {
            product = arguments?.getParcelable<CatalogItem>("catalogItem") as CatalogItem
        }

        initViews()
    }

    private fun initViews() {
        binding.apply {
            itemImage.setImageUrl(IMAGE_PATH + product.image)
            nameTv.text = product.name
            priceTv.text = resources.getString(R.string.price_label, product.price.toString())
            articleTv.text = resources.getString(R.string.article_label, product.article.toString())
        }
    }
}