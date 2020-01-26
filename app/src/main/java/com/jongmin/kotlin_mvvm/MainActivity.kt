package com.jongmin.kotlin_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.jongmin.kotlin_mvvm.Interface.LoginResultCallBacks
import com.jongmin.kotlin_mvvm.databinding.ActivityMainBinding
import com.jongmin.kotlin_mvvm.viewmodel.LoginViewModel
import com.jongmin.kotlin_mvvm.viewmodel.LoginViewModelFactory
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(),LoginResultCallBacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(this,LoginViewModelFactory(this))
            .get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        Toasty.success(this,message,Toast.LENGTH_SHORT)
            .show()
    }

    override fun onError(message: String) {
        Toasty.error(this,message,Toast.LENGTH_SHORT)
            .show()
    }
}
