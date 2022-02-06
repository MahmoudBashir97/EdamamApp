package com.mahmoudbashir.edamamapp.pojo

import java.io.Serializable

data class AnalysisResponseModel(
    val calories: Int,
    val cautions: List<String>,
    val dietLabels: List<String>,
    val healthLabels: List<String>,
    val totalDaily: TotalDaily,
    val totalNutrients: TotalNutrients,
    val totalNutrientsKCal: TotalNutrientsKCal,
    val totalWeight: Int,
    val uri: String
):Serializable