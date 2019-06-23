package ru.petrolplus.wsk_police.common.DataObject

// объект ответа авторизации
data class Authorization(var data: User,
                         var success: Boolean,
                         var error: String)