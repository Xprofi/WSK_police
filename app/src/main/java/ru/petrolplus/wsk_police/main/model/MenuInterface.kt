package ru.petrolplus.wsk_police.main.model

import ru.petrolplus.wsk_police.common.DataObject.ItemListObject

interface MenuInterface {

    fun onItemClickMenu(itemListObject: ItemListObject)
}