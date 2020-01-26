package com.jongmin.kotlin_mvvm.Interface

interface LoginResultCallBacks {
    fun onSuccess(message:String)
    fun onError(message:String)
}