package com.rchyn.calculatetipapp

import org.junit.Assert.assertEquals
import org.junit.Test

class CalculateTipTests {

    @Test
    fun `Calculate 20 percent Tip no Round Up`() {
        val amount = 20000.0
        val tipPercent = 20.00
        val expectedTip = "Rp4.000,00"
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = false)
        assertEquals(expectedTip, actualTip)
    }


    @Test
    fun `Calculate 20 percent Tip Round Up`(){
        val amount = 23456.0
        val tipPercent = 20.00
        val expectedTip = "Rp4.692,00"
        val actualTip = calculateTip(amount = amount, tipPercent = tipPercent, roundUp = true)
        assertEquals(expectedTip, actualTip)
    }

}