package ru.petrolplus.wsk_police.common.DataObject

//Объект пользователя

data class User(var id: String,
                var login: String,
                var name: String,
                var token: String)