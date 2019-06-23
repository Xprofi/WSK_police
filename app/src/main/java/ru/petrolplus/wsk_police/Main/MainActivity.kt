package ru.petrolplus.wsk_police.Main


import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.Main.model.MenuInterface
import ru.petrolplus.wsk_police.R
import ru.petrolplus.wsk_police.common.DataObject.ItemListObject
import ru.petrolplus.wsk_police.common.DataObject.MenuList


class MainActivity : BaseActivityFun(), MenuInterface {
    private val mainActivityPresenter: MainActivityPresenter = MainActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainActivityPresenter.createMenu(main_menu)
    }


    override fun onItemClickMenu(itemListObject: ItemListObject) {
        when (itemListObject.typeItem){
            MenuList.CRIMINAL_CASES -> logoutUser()
            MenuList.DEPARTMENTS -> logoutUser()
            MenuList.WANTED -> logoutUser()
            MenuList.DETECTIVES -> logoutUser()
            MenuList.PHOTO_ROBOT -> logoutUser()
            MenuList.LOGOUT -> logoutUser()
        }

    }


}
