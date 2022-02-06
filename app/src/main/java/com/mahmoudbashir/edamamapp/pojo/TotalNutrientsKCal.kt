package com.mahmoudbashir.edamamapp.pojo

import java.io.Serializable

data class TotalNutrientsKCal(
    val CHOCDF_KCAL: CHOCDFKCAL,
    val ENERC_KCAL: ENERCKCALXX,
    val FAT_KCAL: FATKCAL,
    val PROCNT_KCAL: PROCNTKCAL
): Serializable