package com.android.kotlinapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.android.kotlinapp.databinding.RvItemRepositoryBinding

class RepositoryRecyclerViewAdapter(private var items:ArrayList<Repository>,
                                    private var listener:OnItemClickListener)
    :RecyclerView.Adapter<RepositoryRecyclerViewAdapter.ViewHolder>(){
    override fun getItemCount(): Int = items.size

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(p0.context)
        val binding = RvItemRepositoryBinding.inflate(layoutInflater, p0, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) = p0.bind(items.get(p1), listener)



    class ViewHolder(private var binding : RvItemRepositoryBinding)
        :RecyclerView.ViewHolder(binding.root){

        fun bind(repo : Repository, listener : OnItemClickListener?){
            binding.repository = repo
            if (listener!=null){
                binding.root.setOnClickListener { _ -> listener.onItemClicked(layoutPosition)}
            }
            binding.executePendingBindings()
        }

    }

    interface OnItemClickListener{
        fun onItemClicked(position : Int)
    }
}