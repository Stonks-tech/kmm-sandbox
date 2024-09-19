package tech.stonks.kmmsandbox.ui.page.detail

import androidx.compose.runtime.Composable
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.navigation.Route

private const val ARG_INDEX = "index"

data class DetailRoute(val index: Int): Route(args = mapOf(ARG_INDEX to index)) {
    @Composable
    override fun Content(controller: NavigationController, args: Map<String, Any>) {
        DetailPage(controller, args[ARG_INDEX] as Int)
    }
}
