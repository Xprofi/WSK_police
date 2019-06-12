package ru.petrolplus.wsk_police.SingIn


import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_in.*
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.Main.MainActivity
import ru.petrolplus.wsk_police.R

class SingInActivity : BaseActivityFun() {

    var signInPresenter: SignInPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        //инициальзируем призентер
        signInPresenter =  SignInPresenter(this)


        setImageCaptcha()
        newCaptchaOnClick()
        captchaCheckButton()
        logInButton()
        guestButton()

    }






    fun newCaptchaOnClick(){
        new_captcha_button.setOnClickListener {
            setImageCaptcha()
        }
    }


    fun captchaCheckButton(){
        captcha_check_button.setOnClickListener {
            Toast.makeText(this,signInPresenter?.checkCaptcha(captcha_edit.text.toString()).toString(),Toast.LENGTH_LONG).show()

        }
    }


    fun logInButton(){
        log_in_button.setOnClickListener {
            signInPresenter?.showCaptcha()
        }
    }

    fun guestButton(){
        guest_button.setOnClickListener {
            startActivity(MainActivity())
        }
    }


    private fun setImageCaptcha(){
        captcha_image.setImageBitmap(signInPresenter?.captchaImage())
    }





}
