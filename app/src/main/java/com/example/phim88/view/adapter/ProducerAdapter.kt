package com.example.phim88.view.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.phim88.R
import com.example.phim88.base.BaseRecyclerAdapter
import com.example.phim88.data.dto.ProductionCompany
import com.example.phim88.databinding.ItemProducerBinding

/**
 * Created by Admin on 3/13/2023.
 * @author vup1912@gmail.com
 */
class ProducerAdapter : BaseRecyclerAdapter<ProductionCompany, ItemProducerBinding>(object :
    DiffUtil.ItemCallback<ProductionCompany>() {
    override fun areItemsTheSame(oldItem: ProductionCompany, newItem: ProductionCompany): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: ProductionCompany,
        newItem: ProductionCompany
    ): Boolean = oldItem == newItem
}) {
    override fun getLayoutRes(viewType: Int): Int = R.layout.item_producer
}