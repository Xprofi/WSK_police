package ru.petrolplus.wsk_police.SingIn

import android.R
import android.graphics.Bitmap
import android.graphics.Color
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_sign_in.*
import ru.petrolplus.wsk_police.SingIn.model.CaptchaGenerator

class SignInPresenter(val sigInActivity: SingInActivity) {

    private val captchaGenerator: CaptchaGenerator =
        CaptchaGenerator.Builder()
            .captchaSize(4)
            .backGroundImageId(R.drawable.bottom_bar)
            .textSize(70F)
            .colorId(Color.BLUE)
            .build()


    private val signInNtwork: SignInNtwork = SignInNtwork(this)

    fun captchaImage(): Bitmap?{
       return captchaGenerator.generateCaptcha(sigInActivity)
    }


    fun checkCaptcha(value: String): Boolean{
        return captchaGenerator.checkCaptcha(value)
    }


    fun showCaptcha(){
        sigInActivity.captcha_layout.visibility = VISIBLE
        sigInActivity.login_button_layout.visibility = GONE
        sigInActivity.login_edit.isEnabled = false
        sigInActivity.password_edit.isEnabled = false
    }


    fun login(login: String, password: String){
        signInNtwork.login(login,password)
        sigInActivity.doingAlert(sigInActivity.resources.getString(ru.petrolplus.wsk_police.R.string.request))
    }

}