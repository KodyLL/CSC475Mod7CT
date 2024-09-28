package com.kluke.csc475mod7ct

import kotlin.math.round

class ConversionFormulas {
    fun FtoC(fromValue: Double): Double {
        val result = round(((fromValue - 32) * (5.0 / 9.0))*100)/100
        return result
    }
    fun CtoF(fromValue: Double): Double {
        val result = round(((fromValue * (9.0 / 5.0)) + 32)*100)/100
        return result
    }
    fun FtoK(fromValue: Double): Double {
        val result = round(((fromValue - 32) * (5.0 / 9.0) + 273.15)*100)/100
        return result
    }
    fun KtoF(fromValue: Double): Double {
        val result = round(((fromValue - 273.15) * (9.0 / 5.0) + 32)*100)/100
        return result
    }
    fun CtoK(fromValue: Double): Double {
        val result = round((fromValue + 273.15)*100)/100
        return result
    }
    fun KtoC(fromValue: Double): Double {
        val result = round((fromValue - 273.15)*100)/100
        return result
    }
}