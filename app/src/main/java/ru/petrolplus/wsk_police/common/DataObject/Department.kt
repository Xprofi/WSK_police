package ru.petrolplus.wsk_police.common.DataObject

import com.google.android.gms.maps.model.LatLng

// объект департамента
data class Department(var id: String,
                      var address: String,
                      var name: String,
                      var boss: String,
                      var phone: String,
                      var email: String,
                      var description: String,
                      var coords: String)


// ответ с сервера
data class DepartmentAnswer(var data: List<Department>,
                         var success: Boolean,
                         var error: String)


