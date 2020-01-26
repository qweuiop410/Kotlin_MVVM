package com.jongmin.kotlin_mvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jongmin.kotlin_mvvm.Interface.LoginResultCallBacks

class LoginViewModelFactory(private val listener:LoginResultCallBacks):ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(listener) as T
    }
}