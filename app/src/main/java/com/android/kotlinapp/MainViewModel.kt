package com.android.kotlinapp

import android.arch.lifecycle.ViewModel
import android.databinding.ObservableField

class MainViewModel : ViewModel(){
    var repoModel:RepoModel = RepoModel();
    val text = ObservableField("Old Data")
    val isLoading = ObservableField(false)
    var repositories = ArrayList<Repository>()

    /*var onDataReadyCallback = object:RepoModel.OnDataReadyCallback {
        override fun onDataReady(data: String) {
            isLoading.set(false);
            text.set(data)
        }
    }*/

    /*fun refresh(){
        isLoading.set(true)
        repoModel.refreshData(onDataReadyCallback)
    }*/

    fun loadRepositories(){
        isLoading.set(true)
        repoModel.getRepositories(object : RepoModel.OnRepositoryReadyCallback{
            override fun onDataReady(data: ArrayList<Repository>) {
                isLoading.set(false)
                repositories = data
            }
        })
    }
}