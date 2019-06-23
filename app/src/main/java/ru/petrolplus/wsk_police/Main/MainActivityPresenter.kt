package ru.petrolplus.wsk_police.Main

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.petrolplus.wsk_police.Main.model.Menu
import ru.petrolplus.wsk_police.common.adapters.RecyclerAdapterList

class MainActivityPresenter(val mainActivity: MainActivity) {

    var menu: Menu = Menu()

    fun createMenu(recyclerView: RecyclerView){

        recyclerView.layoutManager = LinearLayoutManager(mainActivity)
        recyclerView.adapter = RecyclerAdapterList(mainActivity, menu.menuItems())

    }
}