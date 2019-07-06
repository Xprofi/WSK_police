package ru.petrolplus.wsk_police.singIn


import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_sign_in.*
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.main.MainActivity
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


        signInPresenter?.checkSaveUserUser()



    }






    fun newCaptchaOnClick(){
        new_captcha_button.setOnClickListener {
            setImageCaptcha()
        }
    }


    fun captchaCheckButton(){
        captcha_check_button.setOnClickListener {
            signInPresenter?.let {
                if(it.checkCaptcha(captcha_edit.text.toString())){
                    if (check_remember_me.isChecked){
                        saveUser(login_edit.text.toString(),password_edit.text.toString())
                    }
                    startActivity(MainActivity())
                }else{
                   showMassage(this.resources.getString(R.string.captcha_uncorrected),TypeMessage.ERROR)
                }
            }

        }
    }


    fun logInButton(){
        log_in_button.setOnClickListener {
           // signInPresenter?.showCaptcha()
            signInPresenter?.login(login_edit.text.toString(),password_edit.text.toString())
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

    override fun onBackPressed() {
        //super.onBackPressed()
        if (login_button_layout.visibility == View.GONE){
            login_button_layout.visibility = View.VISIBLE
            captcha_layout.visibility = View.GONE
            login_edit.isEnabled = true
            password_edit.isEnabled = true
        }else{
            finish()
        }
    }





}
