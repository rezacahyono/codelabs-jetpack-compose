package com.rchyn.calculatetipapp

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.rchyn.calculatetipapp.ui.theme.CalculateTipAppTheme
import org.junit.Rule
import org.junit.Test

class CalculateTipUiTests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip_no_round_up() {
        composeTestRule.setContent {
            CalculateTipAppTheme {
                TipCalculateScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("20000")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        composeTestRule.onNodeWithText("Tip amount Rp4.000,00").assertExists()
    }

    @Test
    fun calculate_20_percent_tip_round_up(){
        composeTestRule.setContent {
            CalculateTipAppTheme {
                TipCalculateScreen()
            }
        }
        composeTestRule.onNodeWithText("Bill Amount").performTextInput("23456")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        composeTestRule.onNodeWithTag("round_up").performClick()
        composeTestRule.onNodeWithText("Tip amount Rp4.692,00").assertExists()
    }
}