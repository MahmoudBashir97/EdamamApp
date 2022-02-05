package com.mahmoudbashir.edamamapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.mahmoudbashir.edamamapp.pojo.AnalysisResponseModel
import com.mahmoudbashir.edamamapp.repository.Repository
import kotlinx.coroutines.launch

class AnalysisViewModel(val app:Application,val repo:Repository): AndroidViewModel(app) {

    val analysisResult : MutableLiveData<AnalysisResponseModel> = MutableLiveData()

    fun getAnalysis(queryIntgr:String) = viewModelScope.launch {
        repo.getAnalysisDataEdamam(queryIntgr).let {
            result ->
            if (result.isSuccessful){
                analysisResult.postValue(result.body())
            }
        }
    }
}