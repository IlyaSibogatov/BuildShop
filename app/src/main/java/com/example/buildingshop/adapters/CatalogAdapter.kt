package com.example.buildingshop.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.buildingshop.R
import com.example.buildingshop.databinding.ItemCatalogBinding
import com.example.buildingshop.remote.models.CatalogItem
import com.example.buildingshop.utils.Constants.IMAGE_PATH
import com.example.buildingshop.utils.setImageUrl

class CatalogAdapter(
    private var openDetails: ((item: CatalogItem) -> Unit)? = null
) : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    private var itemList: List<CatalogItem> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<CatalogItem>) {
        itemList = list
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemCatalogBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCatalogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.binding.apply {
            nameTv.text =  item.name
            priceTv.text = holder.itemView.resources.getString(R.string.price_label, item.price.toString())
            articleTv.text = holder.itemView.resources.getString(R.string.article_label, item.article.toString())

            itemImage.setImageUrl(IMAGE_PATH + item.image)

            holder.itemView.setOnClickListener {
                openDetails?.invoke(item)
            }
        }
    }

    override fun getItemCount(): Int = itemList.size
}