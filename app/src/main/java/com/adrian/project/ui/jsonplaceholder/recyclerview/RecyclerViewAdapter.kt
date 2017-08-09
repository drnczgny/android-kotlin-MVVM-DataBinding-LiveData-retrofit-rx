package com.adrian.project.ui.jsonplaceholder.recyclerview

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.adrian.project.base.ListItemViewModel

/**
 * Created by cadri on 2017. 08. 06..
 */

class RecyclerViewAdapter<T : ListItemViewModel> : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var items: List<T> = ArrayList()
        get() = field
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var variableId: Int = 0

    var itemLayout: Int = 0

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.getContext())
        val dataBinding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, itemLayout, parent, false)
        return BindingViewHolder<T>(dataBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder as BindingViewHolder<T>
        val itemViewModel = items[position]
        holder.bind(itemViewModel as T, variableId)
    }

    inner class BindingViewHolder<T : ListItemViewModel>(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listItemViewModel: T, variableId: Int) {
            binding.setVariable(variableId, listItemViewModel)
            binding.executePendingBindings()
        }
    }

}