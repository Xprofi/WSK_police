package ru.petrolplus.wsk_police.SingIn

import retrofit2.Call
import retrofit2.Callback
import ru.petrolplus.wsk_police.BaseActivityFun
import ru.petrolplus.wsk_police.DataObject.Authorization
import ru.petrolplus.wsk_police.Utils.NetworkClient

class SignInNtwork(var signInPresenter: SignInPresenter) {

    val ntworkClient: NetworkClient = NetworkClient()


    fun login(login: String, password: String, signInPresenter: SignInPresenter) {
        ntworkClient.httpClient().login(login, password).enqueue(
            object : Callback<Authorization> {

                override fun onResponse(call: Call<Authorization>, response: retrofit2.Response<Authorization>) {
                    if (response.isSuccessful) {
                        signInPresenter.showCaptcha()
                    }else{
                        signInPresenter.sigInActivity.showMassage("Code: ${response.code()}, Message: ${response.message()}",BaseActivityFun.TypeMessage.ERROR)
                    }
                    signInPresenter.sigInActivity.doingAlertClose()

                }


                override fun onFailure(call: Call<Authorization>, t: Throwable) {
                    signInPresenter.sigInActivity.showMassage(t.message ?: "Unknown Error",BaseActivityFun.TypeMessage.ERROR)
                }
            }
        )

    }

}


