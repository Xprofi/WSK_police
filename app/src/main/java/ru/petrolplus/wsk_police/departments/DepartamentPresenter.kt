package ru.petrolplus.wsk_police.departments

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_departments.*
import ru.petrolplus.wsk_police.common.DataObject.Department
import ru.petrolplus.wsk_police.common.adapters.RecyclerAdapterDepartments

class DepartamentPresenter(val departments: Departments) {

    val deportamentsNetwork = DepartmentsNetwork(this)

    fun departmentsRequest(){
        departments.processAlert(departments.resources.getString(ru.petrolplus.wsk_police.R.string.request))
        deportamentsNetwork.departments()
    }

    fun addDeportmentToRecyclerView(departmentsData: List<Department>){
        departments.recyclerDepartaments.layoutManager = LinearLayoutManager(departments)
        departments.recyclerDepartaments.adapter = RecyclerAdapterDepartments(departments, departmentsData)
    }


}