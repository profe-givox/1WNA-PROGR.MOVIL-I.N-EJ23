package net.ivanvega.tiptime.TipUITests

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import net.ivanvega.tiptime.TipTimeScreen
import net.ivanvega.tiptime.ui.theme.TipTimeTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            TipTimeTheme {
                TipTimeScreen()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount")
            .performTextInput("10")
        composeTestRule.onNodeWithText("Tip (%)").performTextInput("20")
        val expectedTip = NumberFormat.getCurrencyInstance().format(2)

            composeTestRule.onNodeWithText("Tip amount: $expectedTip").assertExists(
            "No node with this text was found.")

    }
}