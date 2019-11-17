package com.mvp.plants.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    protected  fun showMessage(message : String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}