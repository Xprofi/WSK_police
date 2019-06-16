package ru.petrolplus.wsk_police


import android.app.Dialog
import android.content.Intent
import android.view.WindowManager
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import de.adorsys.android.securestoragelibrary.SecurePreferences
import kotlinx.android.synthetic.main.request_indicator.view.*








open class BaseActivityFun: AppCompatActivity() {

    lateinit var doingAlert: Dialog



    fun startActivity(activity: AppCompatActivity){
        val intent = Intent(this, activity ::class.java)
        startActivity(intent)
    }


    fun showMassage(message: String, typeMessage: TypeMessage){
        var snackbar: Snackbar =   Snackbar.make(window.decorView.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT)
        snackbar.setActionTextColor(ContextCompat.getColor(this,R.color.white))
        when(typeMessage){
            TypeMessage.ERROR ->{
                snackbar.view.setBackgroundColor(ContextCompat.getColor(this,R.color.ERROR_MESSAGE))
            }
            TypeMessage.DEFAULT ->{
                snackbar.view.setBackgroundColor(ContextCompat.getColor(this,R.color.DEFAULT_MESSAGE))
            }
            TypeMessage.GOOD ->{
                snackbar.view.setBackgroundColor(ContextCompat.getColor(this,R.color.GOOD_MESSAGE))
            }
        }

        snackbar.show()

    }


    fun doingAlert(message: String){
        val alert = AlertDialog.Builder(this)
        val view = layoutInflater
            .inflate(resources.getLayout(R.layout.request_indicator), null) as ConstraintLayout
        view.message_textView.text = message
        alert.setView(view)
        alert.setCancelable(false)
        doingAlert = alert.create()
        doingAlert.show()
    }


    fun doingAlertClose(){
       doingAlert.dismiss()
       doingAlert.cancel()
    }




    fun saveUser(login: String, password: String){
        SecurePreferences.setValue(this,SecurityKey.LOGIN.name,login)
        SecurePreferences.setValue(this,SecurityKey.PASSWORD.name,password)
    }


    fun logoutUser(){
        SecurePreferences.clearAllValues(this)
    }



     fun actionBar() {

         val layoutParams = Toolbar.LayoutParams( Toolbar.LayoutParams.MATCH_PARENT,  Toolbar.LayoutParams.MATCH_PARENT)


         val actionBar = supportActionBar
         actionBar!!.setDisplayShowHomeEnabled(false)
         actionBar.setDisplayShowCustomEnabled(true)
         actionBar.setDisplayShowTitleEnabled(false)
         val customView = layoutInflater.inflate(R.layout.app_bar, null)
         actionBar.setCustomView(customView, layoutParams)
         val parent = customView.parent as Toolbar
         parent.setPadding(0, 0, 0, 0)//for tab otherwise give space in tab
         parent.setContentInsetsAbsolute(0, 0)


    }



    enum class TypeMessage {
        ERROR,
        DEFAULT,
        GOOD
    }

    enum class SecurityKey{
        LOGIN,
        PASSWORD
    }




    fun lockUI(){
        this.window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }
    fun unLockUI(){
        this.window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
    }






}