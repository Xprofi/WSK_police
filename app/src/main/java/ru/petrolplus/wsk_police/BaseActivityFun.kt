package ru.petrolplus.wsk_police

import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar

open class BaseActivityFun: AppCompatActivity() {

    fun startActivity(activity: AppCompatActivity){
        val intent = Intent(this, activity ::class.java)
        startActivity(intent)
    }


    fun showMassage(message: String, typeMessage: TypeMessage){
        var snackbar: Snackbar =   Snackbar.make(window.decorView.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG)
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


    enum class TypeMessage {
        ERROR,
        DEFAULT,
        GOOD
    }


}