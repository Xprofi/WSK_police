package ru.petrolplus.wsk_police.SingIn


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import ru.petrolplus.wsk_police.R

class SingInActivity : AppCompatActivity() {

    var signInPresenter: SignInPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        signInPresenter =  SignInPresenter(this)


        setImageCaptcha()
        newCaptchaOnClick()

    }






    fun newCaptchaOnClick(){
        new_captcha_button.setOnClickListener {
            setImageCaptcha()
        }
    }


    private fun setImageCaptcha(){
        captcha_image.setImageBitmap(signInPresenter?.captchaImage())
    }



}
