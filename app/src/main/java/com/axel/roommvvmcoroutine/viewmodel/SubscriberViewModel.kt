package com.axel.roommvvmcoroutine.viewmodel

import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.axel.roommvvmcoroutine.db.Subscriber
import com.axel.roommvvmcoroutine.db.SubscriberRepository
import kotlinx.coroutines.launch

class SubscriberViewModel(private val repository: SubscriberRepository) : ViewModel(), Observable {

    val subscribers         = repository.subscribers

    @Bindable
    var inputName           = MutableLiveData<String?>()

    @Bindable
    var inputEmail          = MutableLiveData<String?>()

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

        if (inputEmail.value != null && inputName.value != null){
            insert(
                Subscriber(0, inputName.value, inputEmail.value)
            )
        }
        inputEmail.value = null
        inputName.value  = null
    }

    fun updateSubscriber(){

        if (inputEmail.value != null && inputName.value != null){
            update(
                Subscriber(0, inputName.value, inputEmail.value)
            )
        }
        inputEmail.value = null
        inputName.value  = null
    }

    fun deleteSubscriber(){
        if (inputEmail.value != null && inputName.value != null){
            delete(
                Subscriber(0, inputName.value, inputEmail.value)
            )
        }
        inputEmail.value = null
        inputName.value  = null
    }

    fun deleteAllSubscribers(){
        if (inputEmail.value != null && inputName.value != null){
            deleteAll()
        }
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

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

}