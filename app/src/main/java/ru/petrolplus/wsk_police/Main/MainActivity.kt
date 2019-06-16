package ru.petrolplus.wsk_police.Main


import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.constraintlayout.widget.ConstraintLayout
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.R




class MainActivity : BaseActivityFun() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar()

    }
}
