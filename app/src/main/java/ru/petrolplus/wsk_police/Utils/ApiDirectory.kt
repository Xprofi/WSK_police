package ru.petrolplus.wsk_police.Utils

import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*
import ru.petrolplus.wsk_police.DataObject.*

interface ApiDirectory {

    @GET("/api/login/")
    abstract fun login(@Query("login") login: String,@Query("password") password: String): Call<Authorization>

    @GET("/api/department")
    abstract fun department(): Call<Department>

    @GET("/api/wanted")
    abstract fun wanted(): Call<Wanted>

    @GET("/api/criminal_case")
    abstract fun criminalCase(): Call<CriminalCase>

    @POST("/api/criminal_case")
    abstract fun sendCriminalCase(@Body criminalCase: CriminalCase): Call<CriminalCase>

    @GET("/api/evidence")
    abstract fun evidence(): Call<CriminalCase>

    @POST("/api/evidence")
    abstract fun sendEvidence(@Body criminalCase: CriminalCase): Call<CriminalCase>


    @Headers("Content-Type: form-data")
    @POST("/api/criminal_case_image")
    abstract fun sendCriminalCaseImage(@Query("criminal_case_id") id: Int,@Part image: MultipartBody.Part): Call<Unit>

    @Headers("Content-Type: form-data")
    @POST("/api/delete_criminal_case_image")
    abstract fun DeleteCriminalCaseImage(@Query("criminal_case_image_id") idImage: Int,@Query("criminal_case_image_id") idCriminalCase: Int): Call<Unit>


  /*  //pass it like this
    File file = new File("/storage/emulated/0/Download/Corrections 6.jpg");
    RequestBody requestFile =
    RequestBody.create(MediaType.parse("multipart/form-data"), file);

// MultipartBody.Part is used to send also the actual file name
    MultipartBody.Part body =
    MultipartBody.Part.createFormData("image", file.getName(), requestFile);

// add another part within the multipart request
    RequestBody fullName =
    RequestBody.create(MediaType.parse("multipart/form-data"), "Your Name");

    service.updateProfile(id, fullName, body, other);*/


    @GET("/api/lost")
    abstract fun lost(): Call<Lost>

}