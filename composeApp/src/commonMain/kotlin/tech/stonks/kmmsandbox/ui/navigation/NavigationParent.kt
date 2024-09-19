package tech.stonks.kmmsandbox.ui.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun NavigationParent(
    controller: NavigationController = rememberNavigationController(),
) {
    val currentRoute by controller.currentRoute.collectAsState()
        //todo add BackHandler
    AnimatedContent(
        targetState = currentRoute
    ) { state ->
        currentRoute.Content(controller, currentRoute.args)
    }
}
