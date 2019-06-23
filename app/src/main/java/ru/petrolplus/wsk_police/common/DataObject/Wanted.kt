package ru.petrolplus.wsk_police.common.DataObject

//Объект розыск

data class Wanted(
    var id:Int,
    var status: String,
    var firstName: String,
    var lastName: String,
    var lastLocation: String,
    var nickNames: String,
    var description: String,
    var photo: String
)