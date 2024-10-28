package tech.stonks.kmmsandbox.ui.navigation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun NavigationParent(
    controller: NavigationController = rememberNavigationController(),
) {
    val currentAction by controller.navigationAction.collectAsState()
    AnimatedContent(
        targetState = currentAction,
        transitionSpec = {
            when(this.targetState) {
                is NavigationAction.Idle -> fadeIn() togetherWith fadeOut()
                is NavigationAction.Navigate -> navigateToAnimation()
                is NavigationAction.PopTo -> popToNavigation()
            }
        }
    ) { action ->
        action.route.Content(controller, action.route.args)
    }
}

private fun <S> AnimatedContentTransitionScope<S>.navigateToAnimation(): ContentTransform {
    return slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(300)
    ) togetherWith slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Left,
        animationSpec = tween(300)
    )
}

private fun <S> AnimatedContentTransitionScope<S>.popToNavigation(): ContentTransform {
    return slideIntoContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(300)
    ) togetherWith slideOutOfContainer(
        towards = AnimatedContentTransitionScope.SlideDirection.Right,
        animationSpec = tween(300)
    )
}
