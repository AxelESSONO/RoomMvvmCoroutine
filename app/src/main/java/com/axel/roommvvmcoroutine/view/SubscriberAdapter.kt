package com.axel.roommvvmcoroutine.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.axel.roommvvmcoroutine.R
import com.axel.roommvvmcoroutine.databinding.SubscriberItemBinding
import com.axel.roommvvmcoroutine.db.Subscriber

class SubscriberAdapter(private val subscribers: List<Subscriber>) : RecyclerView.Adapter<SubscriberAdapter.SubscriberViewHolder>() {

    class SubscriberViewHolder(private val binding: SubscriberItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(subscriber: Subscriber){
            binding.subscriber = subscriber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubscriberViewHolder {
        return SubscriberViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.subscriber_item,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: SubscriberViewHolder, position: Int) {
        holder.bind(subscribers[position])
    }

    override fun getItemCount(): Int = subscribers.size
}