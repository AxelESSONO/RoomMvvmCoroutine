package com.axel.roommvvmcoroutine.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.axel.roommvvmcoroutine.R
import com.axel.roommvvmcoroutine.databinding.ActivityMainBinding
import com.axel.roommvvmcoroutine.db.SubscriberDatabase
import com.axel.roommvvmcoroutine.db.SubscriberRepository
import com.axel.roommvvmcoroutine.viewmodel.SubscriberViewModel
import com.axel.roommvvmcoroutine.viewmodel.SubscriberViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var subscriberViewModel : SubscriberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding                     = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao                     = SubscriberDatabase.getInstance(application).subscriberDAO
        val repository              = SubscriberRepository(dao)
        val factory                 = SubscriberViewModelFactory(repository)
        subscriberViewModel         = ViewModelProvider(this, factory).get(SubscriberViewModel::class.java)
        binding.subscriberViewModel = subscriberViewModel
        binding.lifecycleOwner      = this
        initRecyclerView()

    }

    private fun displaySubscribers(){
        subscriberViewModel.subscribers.observe(this, Observer {
            Log.d("SUBSCRIBER", it.toString())
            binding.suscriberRecycler.adapter = SubscriberAdapter(it)
        })
    }

    private fun initRecyclerView(){
        binding.suscriberRecycler.layoutManager = LinearLayoutManager(
            applicationContext,
            LinearLayoutManager.VERTICAL,
            false
        )
        displaySubscribers()
    }

}