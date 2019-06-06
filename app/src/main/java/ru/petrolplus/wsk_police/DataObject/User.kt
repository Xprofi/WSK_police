package ru.petrolplus.wsk_police.DataObject

//Объект пользователя

data class User(var id: String,
                var login: String,
                var name: String,
                var token: String)