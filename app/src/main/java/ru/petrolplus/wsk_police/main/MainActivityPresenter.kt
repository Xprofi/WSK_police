package ru.petrolplus.wsk_police.main

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.petrolplus.wsk_police.main.model.Menu
import ru.petrolplus.wsk_police.common.adapters.RecyclerAdapterMainMenu

class MainActivityPresenter(val mainActivity: MainActivity) {

    var menu: Menu = Menu()

    fun createMenu(recyclerView: RecyclerView){

        recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        recyclerView.adapter = RecyclerAdapterMainMenu(mainActivity, menu.menuItems())

    }
}