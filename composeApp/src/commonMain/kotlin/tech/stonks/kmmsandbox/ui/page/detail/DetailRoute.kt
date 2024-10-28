package tech.stonks.kmmsandbox.ui.page.detail

import androidx.compose.runtime.Composable
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.navigation.Route

private const val ARG_INDEX = "index"

data class DetailRoute(
    private val index: Int
): Route() {
    @Composable
    override fun Content(controller: NavigationController) {
        DetailPage(controller, index)
    }
}
