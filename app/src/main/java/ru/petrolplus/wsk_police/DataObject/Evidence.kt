package ru.petrolplus.wsk_police.DataObject

// Объекст для улик
data class Evidence(
    var id: Int,
    var criminal_case_id: Int,
    var name: Int,
    var description: String
)