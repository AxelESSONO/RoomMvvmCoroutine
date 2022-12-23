package com.axel.roommvvmcoroutine.viewmodel

import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axel.roommvvmcoroutine.db.Subscriber
import com.axel.roommvvmcoroutine.db.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel() {

    val subscribers         = repository.subscribers

    @Bindable
    val inputName           = MutableLiveData<String?>()

    @Bindable
    val inputEmail          = MutableLiveData<String?>()

    @Bindable
    val insertButtonText    = MutableLiveData<String>()

    @Bindable
    val updateButtonText    = MutableLiveData<String>()

    @Bindable
    val deleteButtonText    = MutableLiveData<String>()

    @Bindable
    val deleteAllButtonText = MutableLiveData<String>()

    init {
        insertButtonText.value    = "Insert"
        updateButtonText.value    = "Update"
        deleteButtonText.value    = "Delete"
        deleteAllButtonText.value = "Delete All"
    }

    fun insertSubscriber(){
        insert(
            Subscriber(0, inputName.value!!, inputEmail.value!!)
        )
        inputEmail.value = null
        inputName.value  = null
    }

    fun updateSubscriber(){
        update(
            Subscriber(0, inputName.value!!, inputEmail.value!!)
        )
        inputEmail.value = null
        inputName.value  = null
    }

    fun deleteSubscriber(){
        delete(
            Subscriber(0, inputName.value!!, inputEmail.value!!)
        )
        inputEmail.value = null
        inputName.value  = null
    }

    fun deleteAllSubscribers(){
        deleteAll()
        inputEmail.value = null
        inputName.value  = null
    }

    private fun insert(subscriber: Subscriber) = viewModelScope.launch {
        repository.insert(subscriber)
    }

    private fun update(subscriber: Subscriber) = viewModelScope.launch {
        repository.update(subscriber)
    }

    private fun delete(subscriber: Subscriber) = viewModelScope.launch {
        repository.delete(subscriber)
    }

    private fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

}