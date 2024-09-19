package tech.stonks.kmmsandbox.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class NavigationController(
    initialRoute: Route = Route(),
) {
    private var _routeStack = mutableListOf(initialRoute)
    private val _currentRoute = MutableStateFlow(_routeStack.last())
    val currentRoute: StateFlow<Route> = _currentRoute

    fun navigate(route: Route) {
        _routeStack += route
        _currentRoute.value = route
    }

    fun navigateBack() {
        if (_routeStack.size > 1) {
            _routeStack = _routeStack.dropLast(1).toMutableList()
            _currentRoute.value = _routeStack.last()
        }
    }

    fun navigateBackUntil(predicate: (Route) -> Boolean) {
        val index = _routeStack.indexOfLast(predicate)
        if (index != -1) {
            _routeStack = _routeStack.take(index + 1).toMutableList()
            _currentRoute.value = _routeStack.last()
        }
    }

    fun replace(route: Route) {
        _routeStack = (_routeStack.dropLast(1) + route).toMutableList()
        _currentRoute.value = route
    }

    fun replaceUntil(predicate: (Route) -> Boolean, route: Route) {
        val index = _routeStack.indexOfLast(predicate)
        if (index != -1) {
            _routeStack = (_routeStack.take(index + 1) + route).toMutableList()
            _currentRoute.value = route
        }
    }
}

open class Route(val args: Map<String, Any> = emptyMap()) {
    @Composable
    open fun Content(controller: NavigationController, args: Map<String, Any>) {
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
