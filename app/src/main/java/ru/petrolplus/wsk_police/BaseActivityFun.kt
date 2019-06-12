package ru.petrolplus.wsk_police

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

open class BaseActivityFun: AppCompatActivity() {

    fun startActivity(activity: AppCompatActivity){
        val intent = Intent(this, activity ::class.java)
        startActivity(intent)
    }

}