package tech.stonks.kmmsandbox

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.navigation.NavigationParent
import tech.stonks.kmmsandbox.ui.navigation.rememberNavigationController
import tech.stonks.kmmsandbox.ui.page.main.MainRoute

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navigationController = rememberNavigationController(
            initialRoute = MainRoute()
        )
        NavigationParent(navigationController)
    }
}
