package ru.petrolplus.wsk_police.Main


import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.R


class MainActivity : BaseActivityFun() {
    private val mainActivityPresenter: MainActivityPresenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityPresenter.createMenu(main_menu)
    }






}
