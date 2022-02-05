package com.mahmoudbashir.edamamapp.repository

import com.mahmoudbashir.edamamapp.pojo.AnalysisResponseModel
import com.mahmoudbashir.edamamapp.retrofit.RetrofitInstance
import retrofit2.Response

class Repository(val retrofitInst : RetrofitInstance): IRepository {
    override suspend fun getAnalysisDataEdamam(queryIntgr: String): Response<AnalysisResponseModel> =
        retrofitInst.api.getAnalysisData(ingr = queryIntgr)
}