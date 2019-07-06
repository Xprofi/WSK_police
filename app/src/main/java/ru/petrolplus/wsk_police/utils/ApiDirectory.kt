package ru.petrolplus.wsk_police.utils

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import ru.petrolplus.wsk_police.common.DataObject.*

interface ApiDirectory {

    @GET("/api/login/")
    abstract fun login(@Query("login") login: String,@Query("password") password: String): Call<Authorization>

    @GET("/api/department")
    abstract fun department(): Call<DepartmentAnswer>

    @GET("/api/wanted")
    abstract fun wanted(): Call<Authorization>

    @GET("/api/criminal_case")
    abstract fun criminalCase(): Call<Authorization>

    @POST("/api/criminal_case")
    abstract fun sendCriminalCase(@Body criminalCase: CriminalCase): Call<CriminalCase>

    @GET("/api/evidence")
    abstract fun evidence(): Call<Authorization>

    @POST("/api/evidence")
    abstract fun sendEvidence(@Body criminalCase: CriminalCase): Call<CriminalCase>


    @Headers("Content-Type: form-data")
    @POST("/api/criminal_case_image")
    abstract fun sendCriminalCaseImage(@Query("criminal_case_id") id: Int,@Part image: MultipartBody.Part): Call<Unit>

    @Headers("Content-Type: form-data")
    @POST("/api/delete_criminal_case_image")
    abstract fun DeleteCriminalCaseImage(@Query("criminal_case_image_id") idImage: Int,@Query("criminal_case_image_id") idCriminalCase: Int): Call<Unit>





    @GET("/api/lost")
    abstract fun lost(): Call<Authorization>

}