package com.mahmoudbashir.edamamapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.mahmoudbashir.edamamapp.databinding.FragmentResultScreenBinding
import com.mahmoudbashir.edamamapp.pojo.AnalysisResponseModel


class ResultScreenFragment : Fragment() {

    lateinit var resultBinding:FragmentResultScreenBinding
    val args:ResultScreenFragmentArgs by navArgs()
    lateinit var analysisResult : AnalysisResponseModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
        analysisResult = args.analysisData
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        resultBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_result_screen, container, false)

        return resultBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpDataToViews()
    }

    //todo attaching data to views
    private fun setUpDataToViews() {


        val fat = if (analysisResult.totalDaily.FAT != null){ "${analysisResult.totalDaily.FAT!!.quantity.toString().substring(0,3)} ${analysisResult.totalDaily.FAT!!.unit}"} else "0 g"
        val fatQuantity = if (analysisResult.totalNutrients.FAT != null) {"${analysisResult.totalNutrients.FAT!!.quantity.toString().substring(0,3)} ${analysisResult.totalNutrients.FAT!!.unit}"} else "0 %"

        val saturatedQFat = if(analysisResult.totalNutrients.FASAT != null) {"${analysisResult.totalNutrients.FASAT!!.quantity.toString().substring(0,3)} ${analysisResult.totalNutrients.FASAT!!.unit}"} else "0 g"
        val saturatedDailyValue = if(analysisResult.totalDaily.FASAT != null) {"${analysisResult.totalDaily.FASAT!!.quantity.toString().substring(0,3)} ${analysisResult.totalDaily.FASAT!!.unit}"} else "0 %"

        val choleQ = if (analysisResult.totalNutrients.CHOLE != null) {"${analysisResult.totalNutrients.CHOLE!!.quantity} ${analysisResult.totalNutrients.CHOLE!!.unit}"} else "0 mg"
        val choleDailyValue = if (analysisResult.totalDaily.CHOLE != null) {"${analysisResult.totalDaily.CHOLE!!.quantity} ${analysisResult.totalDaily.CHOLE!!.unit}"} else "0 %"


        val sodiumQ = if (analysisResult.totalNutrients.NA != null) {"${analysisResult.totalNutrients.NA!!.quantity.toString().substring(0,3)} ${analysisResult.totalNutrients.NA!!.unit}"} else "0 g"
        val sodiumDailyValue = if (analysisResult.totalDaily.NA != null) {"${analysisResult.totalDaily.NA!!.quantity.toString().substring(0,3)} ${analysisResult.totalDaily.NA!!.unit}"} else "0 %"


        resultBinding.apply {

            txtCaloriesNo.text = analysisResult.calories.toString()

            txtFatDailyValue.text = fat
            txtFatQuantity.text = fatQuantity

            quantitySaturatedTxt.text= saturatedQFat
            txtSaturatedDailyValue.text = saturatedDailyValue

            quantityCholMgTxt.text = choleQ
            txtCholDailyValue.text = choleDailyValue

            quantitySodiumTxt.text = sodiumQ
            txtSodiumDailyValue.text = sodiumDailyValue
        }

    }

}