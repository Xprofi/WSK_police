package ru.petrolplus.wsk_police.departments

import android.os.Bundle
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.R

class Departments : BaseActivityFun() {

    val departamentPresenter = DepartamentPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_departments)
        departamentPresenter.departmentsRequest()

    }
}
