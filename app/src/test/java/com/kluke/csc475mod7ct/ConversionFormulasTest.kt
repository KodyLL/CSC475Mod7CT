package com.kluke.csc475mod7ct

import junit.framework.TestCase.assertEquals
import org.junit.Test

class ConversionFormulasTest {

    val conversionFormulas = ConversionFormulas()

    @Test
    fun ftoC() {
        val fromValue = 50.0
        assertEquals(10.00,conversionFormulas.FtoC(fromValue))
    }

    @Test
    fun ctoF() {
        val fromValue = 50.0
        assertEquals(122.00,conversionFormulas.CtoF(fromValue))
    }

    @Test
    fun ftoK() {
        val fromValue = 50.0
        assertEquals(283.15,conversionFormulas.FtoK(fromValue))
    }

    @Test
    fun ktoF() {
        val fromValue = 50.0
        assertEquals(-369.67,conversionFormulas.KtoF(fromValue))
    }

    @Test
    fun ctoK() {
        val fromValue = 50.0
        assertEquals(323.15,conversionFormulas.CtoK(fromValue))
    }

    @Test
    fun ktoC() {
        val fromValue = 50.0
        assertEquals(-223.15,conversionFormulas.KtoC(fromValue))
    }
}