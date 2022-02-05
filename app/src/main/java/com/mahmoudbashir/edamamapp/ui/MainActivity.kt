package com.mahmoudbashir.edamamapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mahmoudbashir.edamamapp.R
import com.mahmoudbashir.edamamapp.pojo.AnalysisResponseModel
import com.mahmoudbashir.edamamapp.viewModel.AnalysisViewModel
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val analysisVM by inject<AnalysisViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}