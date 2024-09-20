package tech.stonks.kmmsandbox.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigationController(
    initialRoute: Route = Route(),
) {
    private var _routeStack = mutableListOf(initialRoute)
    private val _navigationAction = MutableStateFlow<NavigationAction>(NavigationAction.Idle(_routeStack.last()))
    val navigationAction: StateFlow<NavigationAction> = _navigationAction

    fun navigate(route: Route) {
        _routeStack += route
        _navigationAction.value = NavigationAction.Navigate(route)
    }

    fun navigateBack() {
        if (_routeStack.size > 1) {
            _routeStack = _routeStack.dropLast(1).toMutableList()
            _navigationAction.value = NavigationAction.PopTo(_routeStack.last())
        }
    }

    fun navigateBackUntil(predicate: (Route) -> Boolean) {
        val index = _routeStack.indexOfLast(predicate)
        if (index != -1) {
            _routeStack = _routeStack.take(index + 1).toMutableList()
            _navigationAction.value = NavigationAction.PopTo(_routeStack.last())
        }
    }

    fun replace(route: Route) {
        _routeStack = (_routeStack.dropLast(1) + route).toMutableList()
        _navigationAction.value = NavigationAction.Navigate(route)
    }

    fun replaceUntil(predicate: (Route) -> Boolean, route: Route) {
        val index = _routeStack.indexOfLast(predicate)
        if (index != -1) {
            _routeStack = (_routeStack.take(index + 1) + route).toMutableList()
            _navigationAction.value = NavigationAction.Navigate(route)
        }
    }
}

sealed class NavigationAction {
    abstract val route: Route
    data class Idle(override val route: Route) : NavigationAction()
    data class Navigate(override val route: Route) : NavigationAction()
    data class PopTo(override val route: Route) : NavigationAction()
}

open class Route(val args: Map<String, Any> = emptyMap()) {
    @Composable
    open fun Content(controller: NavigationController, args: Map<String, Any>) {
    }

    override fun toString(): String {
        return "${this::class.simpleName}(${args})"
    }
}

@Composable
fun rememberNavigationController(
    initialRoute: Route = Route(),
): NavigationController {
    return remember {
        NavigationController(initialRoute)
    }
}
