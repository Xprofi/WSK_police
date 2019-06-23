package ru.petrolplus.wsk_police.SingIn

import android.R
import android.graphics.Bitmap
import android.graphics.Color
import android.view.View.GONE
import android.view.View.VISIBLE
import de.adorsys.android.securestoragelibrary.SecurePreferences
import kotlinx.android.synthetic.main.activity_sign_in.*
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.SingIn.model.CaptchaGenerator

class SignInPresenter(val sigInActivity: SingInActivity) {

    private val captchaGenerator: CaptchaGenerator =
        CaptchaGenerator.Builder()
            .captchaSize(4)
            .backGroundImageId(R.drawable.bottom_bar)
            .textSize(70F)
            .colorId(Color.BLUE)
            .build()




    private val signInNtwork: SignInNetwork = SignInNetwork(this)

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


    fun login(login: String, password: String, autoSignIn: Boolean = false){
        signInNtwork.login(login,password,autoSignIn)
        sigInActivity.doingAlert(sigInActivity.resources.getString(ru.petrolplus.wsk_police.R.string.request))
    }


    fun checkSaveUserUser(){
        if (!SecurePreferences.getStringValue(sigInActivity, BaseActivityFun.SecurityKey.LOGIN.name,"").isNullOrEmpty()){
            login(SecurePreferences.getStringValue(sigInActivity, BaseActivityFun.SecurityKey.LOGIN.name,"") ?: "",
                SecurePreferences.getStringValue(sigInActivity, BaseActivityFun.SecurityKey.PASSWORD.name,"") ?: "", true)
        }else{
            sigInActivity.login_layout.visibility = VISIBLE
        }
    }

}