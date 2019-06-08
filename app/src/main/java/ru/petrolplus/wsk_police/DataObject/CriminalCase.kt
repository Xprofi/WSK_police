package ru.petrolplus.wsk_police.DataObject

import java.util.*

//Объекст для крименальных дел
data class CriminalCase(
    var id: Int,
    var category: String,
    var detective: String,
    var client: String,
    var number: String,
    var description: String,
    var create_date: Date,
    var images: Images
)