package tech.stonks.kmmsandbox

import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import tech.stonks.kmmsandbox.ui.navigation.NavigationParent
import tech.stonks.kmmsandbox.ui.navigation.rememberNavigationController
import tech.stonks.kmmsandbox.ui.page.main.MainRoute
import tech.stonks.kmmsandbox.ui.style.AppTheme

@Composable
@Preview
fun App() {
    AppTheme {
        val navigationController = rememberNavigationController(
            initialRoute = MainRoute()
        )
        NavigationParent(navigationController)
    }
}
