package com.mahmoudbashir.edamamapp.retrofit

import com.mahmoudbashir.edamamapp.pojo.AnalysisResponseModel
import com.mahmoudbashir.edamamapp.utils.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiceInterface {

    @GET("api/nutrition-data?")
    suspend fun getAnalysisData(
        @Query("app_id")
        app_id:String = Constants.APP_ID,
        @Query("app_key")
        app_key:String = Constants.APP_KEY,
        @Query("nutrition-type")
        nutritiontype:String = "logging",
        @Query("ingr")
        ingr:String="rice",
    ):Response<AnalysisResponseModel>
}