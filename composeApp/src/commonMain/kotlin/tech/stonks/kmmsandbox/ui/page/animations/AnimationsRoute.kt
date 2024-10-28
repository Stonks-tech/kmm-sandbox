package tech.stonks.kmmsandbox.ui.page.animations

import androidx.compose.runtime.Composable
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.navigation.Route


class AnimationsRoute : Route() {
    @Composable
    override fun Content(controller: NavigationController) {
        AnimationsPage(controller)
    }
}
