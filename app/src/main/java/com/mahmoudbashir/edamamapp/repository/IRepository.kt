package com.mahmoudbashir.edamamapp.repository

import com.mahmoudbashir.edamamapp.pojo.AnalysisResponseModel
import retrofit2.Response

interface IRepository {

    suspend fun getAnalysisDataEdamam(queryIntgr:String):Response<AnalysisResponseModel>
}