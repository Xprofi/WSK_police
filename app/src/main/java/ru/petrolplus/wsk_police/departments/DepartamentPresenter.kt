package ru.petrolplus.wsk_police.departments

import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_departments.*
import ru.petrolplus.wsk_police.common.DataObject.Department
import ru.petrolplus.wsk_police.common.adapters.RecyclerAdapterDepartments

class DepartamentPresenter(val departments: Departments) {

    val deportamentsNetwork = DeportamentsNetwork(this)

    fun deportamentsRequest(){
        departments.processAlert(departments.resources.getString(ru.petrolplus.wsk_police.R.string.request))
        deportamentsNetwork.deportaments()
    }

    fun addDeportamentToRecyclerView(departmentsData: List<Department>){
        departments.recyclerDepartaments.layoutManager = LinearLayoutManager(departments)
        departments.recyclerDepartaments.adapter = RecyclerAdapterDepartments(departments, departmentsData)
    }


}