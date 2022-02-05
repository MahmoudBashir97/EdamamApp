package com.mahmoudbashir.edamamapp.koin

import com.mahmoudbashir.edamamapp.repository.Repository
import com.mahmoudbashir.edamamapp.retrofit.RetrofitInstance
import com.mahmoudbashir.edamamapp.viewModel.AnalysisViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val apiModule = module {

    single { RetrofitInstance() }
    single { Repository(get()) }

}

val mainViewModelModule = module {
    viewModel {
        AnalysisViewModel(androidApplication(),get())
    }
}