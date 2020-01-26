package com.jongmin.kotlin_mvvm.viewmodel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.jongmin.kotlin_mvvm.Interface.LoginResultCallBacks
import com.jongmin.kotlin_mvvm.model.User

class LoginViewModel(private val listener:LoginResultCallBacks):ViewModel() {
    private val user:User

    init {
        this.user = User("","")
    }

    //Cerate function to set Email after user finish enter text
    val emailTextWatcher:TextWatcher
        get() = object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                user.setEmail(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }

    //Cerate function to set Password after user finish enter text
    val passwordTextWatcher:TextWatcher
        get() = object :TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                user.setPassword(p0.toString())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        }

    //Create function to process Login button clicked
    fun onLoginclicked(v: View){
        if(user.isDataValid)
            listener.onSuccess("Login Success")
        else
            listener.onError("Login Error")
    }

}