package ru.petrolplus.wsk_police.SingIn

import android.R
import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
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

}