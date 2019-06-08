package ru.petrolplus.wsk_police.DataObject

//  Объект с потеряшками

data class Lost(
    var id: Int,
    var title: String,
    var name: String,
    var phone: String,
    var description: String,
    var reward: String,
    var images: Images
)