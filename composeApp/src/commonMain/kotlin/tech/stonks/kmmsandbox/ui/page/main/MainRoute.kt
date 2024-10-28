package tech.stonks.kmmsandbox.ui.page.main

import androidx.compose.runtime.Composable
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.navigation.Route

class MainRoute : Route() {
    @Composable
    override fun Content(controller: NavigationController) {
        MainPage(controller)
    }
}
