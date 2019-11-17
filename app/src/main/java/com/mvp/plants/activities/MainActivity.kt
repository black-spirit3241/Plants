package com.mvp.plants.activities

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.DisplayMetrics
import android.view.View
import android.view.animation.OvershootInterpolator
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.mvp.plants.R
import com.mvp.plants.data.vos.LoginUserVO
import com.mvp.plants.mvp.presenters.LoginPresenter
import com.mvp.plants.mvp.views.LoginView
import kotlinx.android.synthetic.main.activity_main.*

import kotlin.math.log

class MainActivity : BaseActivity() ,LoginView{

    private lateinit var mPresenter:LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpTransition()
        mPresenter= LoginPresenter()
        mPresenter.initPresenter(this)
        mPresenter.checkUser()

        btnLogin.setOnClickListener{
            onLoginClick(edtEmailId.text.toString(),edtPassword.text.toString())
        }
    }


    fun setUpTransition(){
        val displayMetrics=DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width=displayMetrics.widthPixels

        val loginAnimation=ObjectAnimator.ofFloat(tvLogin, View.ALPHA,0f,1f)
        val loginToContinue=ObjectAnimator.ofFloat(tvLoginContinue,View.ALPHA,0f,1f)
        val ivPlantAnimation=ObjectAnimator.ofFloat(ivLogin,View.ALPHA,0f,1f)


        val userInfoAnimation=ObjectAnimator.ofFloat(userInfoLayout,View.ALPHA,0f,1f)
        userInfoAnimation.interpolator=OvershootInterpolator()
        val userAnimation=ObjectAnimator.ofFloat(userInfoLayout,View.TRANSLATION_X,(width+userInfoLayout.width).toFloat(),0f)


        val btnLoginAnimation=ObjectAnimator.ofFloat(btnLogin,View.ALPHA,0f,1f)

        val loginButton = ObjectAnimator.ofFloat(
            btnLogin,
            View.TRANSLATION_X,
            (0 - width).toFloat(),
            0f
        )

        val firstAnimation=AnimatorSet().apply {
            play(loginAnimation).with(loginToContinue).with(ivPlantAnimation)
        }
//        firstAnimation.duration=500
//        firstAnimation.start()

        val info=AnimatorSet().apply {
            play(userAnimation).with(userInfoAnimation)
        }
//        info.duration=800
//        info.start()

        val buttonAnimation=AnimatorSet().apply {
            play(btnLoginAnimation).with(loginButton)
        }
//        buttonAnimation.duration=1000
//        buttonAnimation.start()


        val secondAnimation=AnimatorSet().apply {
            play(info).after(firstAnimation)
        }

        AnimatorSet().apply {
            play(firstAnimation).with(info).with(buttonAnimation)
            duration=1000L
            start()
        }
    }

    override fun onStart() {
        super.onStart()
        mPresenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        mPresenter.onResume()
    }

    override fun onStop() {
        super.onStop()
        mPresenter.onStop()
    }

    override fun onPause() {
        super.onPause()
        mPresenter.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    override fun navigateToPlantActivity() {
        startActivity(PlantListActivity.newPlantListIntent(applicationContext))
        finish()
    }

    override fun checkUser() {
        mPresenter.checkUser()
    }
    override fun onLoginClick(email: String, password: String) {
        if(checkValidation()){
            mPresenter.btnLoginClick(email,password)
        }
    }

    override fun showErrorMessage(message: String) {
        Snackbar.make(rootView,message,Snackbar.LENGTH_LONG).show()
    }

    override fun loginUser() {
        Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
        startActivity(PlantListActivity.newPlantListIntent(applicationContext))
        finish()
    }

     fun checkValidation() : Boolean{
         var valid=true
        if(TextUtils.isEmpty(edtEmailId.text.toString().trim())){
            edtEmailId.error="enter email"
            valid=false
        }
        if(TextUtils.isEmpty(edtPassword.text.toString().trim())) {
            edtPassword.error="enter password"
            valid=false
        }
         return valid
    }

}
