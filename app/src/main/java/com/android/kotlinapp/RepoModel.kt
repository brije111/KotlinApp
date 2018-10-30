package com.android.kotlinapp

import android.os.Handler


class RepoModel{

    fun refreshData(onDataReadyCallback: OnDataReadyCallback){
        Handler().postDelayed({onDataReadyCallback.onDataReady("new String")}, 2000)
    }

    interface OnDataReadyCallback{
        fun onDataReady(data:String)
    }

}