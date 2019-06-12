package ru.petrolplus.wsk_police.SingIn

import android.R
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
import android.opengl.Visibility
import android.view.View.GONE
import android.view.View.VISIBLE
import kotlinx.android.synthetic.main.activity_sign_in.*
import ru.petrolplus.wsk_police.SingIn.model.CaptchaGenerator

class SignInPresenter(private val singInActivity: SingInActivity) {

    private val captchaGenerator: CaptchaGenerator =
        CaptchaGenerator.Builder()
            .captchaSize(4)
            .backGroundImageId(R.drawable.bottom_bar)
            .textSize(70F)
            .colorId(Color.BLUE)
            .build()


    fun captchaImage(): Bitmap?{
       return captchaGenerator.generateCaptcha(singInActivity)
    }


    fun checkCaptcha(value: String): Boolean{
        return captchaGenerator.checkCaptcha(value)
    }


    fun showCaptcha(){
        singInActivity.captcha_layout.visibility = VISIBLE
        singInActivity.login_button_layout.visibility = GONE
    }

}