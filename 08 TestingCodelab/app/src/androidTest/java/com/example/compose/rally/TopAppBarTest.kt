package com.example.compose.rally

import androidx.compose.ui.test.hasParent
import androidx.compose.ui.test.hasStateDescription
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test

class TopAppBarTest {
    @get :Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { /* todo */ },
                currentScreen = RallyScreen.Accounts
            )
        }
        composeTestRule.onNode(
            hasText(RallyScreen.Accounts.name.uppercase()) and
                    hasParent(hasStateDescription(RallyScreen.Accounts.name)),
            useUnmergedTree = true
        ).assertExists()
    }
}