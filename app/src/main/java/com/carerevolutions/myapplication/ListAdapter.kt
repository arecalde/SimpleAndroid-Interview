package com.carerevolutions.myapplication

import android.content.Context
import android.graphics.Typeface
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.carerevolutions.myapplication.databinding.ListRowBinding

class MyViewHolder(private val binding: ListRowBinding, private val lifecycleOwner: LifecycleOwner) : RecyclerView.ViewHolder(binding.getRoot()) {

    fun bind(item: CountrySubdivision) {
        binding.lifecycleOwner = lifecycleOwner
        binding.item = item
        binding.executePendingBindings()
    }
}

class ListAdapter(private val items: List<CountrySubdivision>, private val lifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        val itemBinding = DataBindingUtil.inflate<ListRowBinding>(
            LayoutInflater.from(parent.context),
            R.layout.list_row,
            parent,
            false
        )
        return MyViewHolder(itemBinding, lifecycleOwner)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item: CountrySubdivision = items[position]
        holder.bind(item)
    }

    override fun getItemCount() = items.size
}