package ru.petrolplus.wsk_police.departments

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.common.DataObject.DepartmentAnswer
import ru.petrolplus.wsk_police.utils.NetworkClient


class DepartmentsNetwork(val deportamentsPresenter: DepartamentPresenter) {

    fun departments(){
        NetworkClient.httpClient.department().enqueue(
            object: Callback<DepartmentAnswer> {

                override fun onResponse(call: Call<DepartmentAnswer>, response: Response<DepartmentAnswer>) {
                    if (response.isSuccessful){
                       if (response.body() != null){
                           deportamentsPresenter.addDeportmentToRecyclerView(response.body()?.data!!)
                       }else{
                           deportamentsPresenter.departments.showMassage( "Unknown Error", BaseActivityFun.TypeMessage.ERROR)
                       }

                    }else{
                        deportamentsPresenter.departments.showMassage("Code: ${response.code()}, Message: ${response.message()}",BaseActivityFun.TypeMessage.ERROR)
                    }

                    deportamentsPresenter.departments.processAlertClose()

                }

                override fun onFailure(call: Call<DepartmentAnswer>, t: Throwable) {
                    deportamentsPresenter.departments.showMassage(t.message ?: "Unknown Error", BaseActivityFun.TypeMessage.ERROR)
                    deportamentsPresenter.departments.processAlertClose()
                }



            }
        )
    }


}