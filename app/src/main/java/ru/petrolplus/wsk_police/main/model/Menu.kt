package ru.petrolplus.wsk_police.main.model

import ru.petrolplus.wsk_police.R
import ru.petrolplus.wsk_police.common.DataObject.ItemListObject
import ru.petrolplus.wsk_police.common.DataObject.MenuList

class Menu {

    fun menuItems(): List<ItemListObject>{
        var menuItems: MutableList<ItemListObject> = mutableListOf()

        menuItems.add(ItemListObject(MenuList.CRIMINAL_CASES.name(), R.drawable.criminal_cases, MenuList.CRIMINAL_CASES))
        menuItems.add(ItemListObject(MenuList.DEPARTMENTS.name(), R.drawable.departments, MenuList.DEPARTMENTS))
        menuItems.add(ItemListObject(MenuList.WANTED.name(), R.drawable.wanted, MenuList.WANTED))
        menuItems.add(ItemListObject(MenuList.DETECTIVES.name(), R.drawable.detectives, MenuList.DETECTIVES))
        menuItems.add(ItemListObject(MenuList.PHOTO_ROBOT.name(), R.drawable.photo_robot, MenuList.PHOTO_ROBOT))
        menuItems.add(ItemListObject(MenuList.ABOUT_US.name(), R.drawable.about_us, MenuList.ABOUT_US))
        menuItems.add(ItemListObject(MenuList.LOGOUT.name(), R.drawable.logout, MenuList.LOGOUT))


        return menuItems
    }

}