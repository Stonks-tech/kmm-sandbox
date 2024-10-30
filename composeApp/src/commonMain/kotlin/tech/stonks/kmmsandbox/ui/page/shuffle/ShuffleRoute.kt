package tech.stonks.kmmsandbox.ui.page.shuffle

import androidx.compose.runtime.Composable
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.navigation.Route

class ShuffleRoute : Route() {
    @Composable
    override fun Content(controller: NavigationController) {
        ShufflePage()
    }
}
