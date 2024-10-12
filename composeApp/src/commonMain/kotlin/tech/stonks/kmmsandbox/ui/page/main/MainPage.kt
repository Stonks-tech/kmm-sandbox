package tech.stonks.kmmsandbox.ui.page.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kmmsandbox.composeapp.generated.resources.Res
import kmmsandbox.composeapp.generated.resources.main_button_text
import kmmsandbox.composeapp.generated.resources.main_counter_text
import kmmsandbox.composeapp.generated.resources.main_menu_animations
import kmmsandbox.composeapp.generated.resources.main_menu_effects
import kmmsandbox.composeapp.generated.resources.main_menu_pager
import kmmsandbox.composeapp.generated.resources.main_menu_remember
import kmmsandbox.composeapp.generated.resources.main_menu_state
import kmmsandbox.composeapp.generated.resources.main_text
import kmmsandbox.composeapp.generated.resources.main_title
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.navigation.rememberNavigationController
import tech.stonks.kmmsandbox.ui.page.animations.AnimationsRoute
import tech.stonks.kmmsandbox.ui.page.detail.DetailRoute

@Composable
fun MainPage(
    navigationController: NavigationController
) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    var counter by remember { mutableStateOf(0) } // var counter: Int = 0


    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(Res.string.main_title))
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }
                        }
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerElevation = 0.dp,
        drawerBackgroundColor = Color.Transparent,
        drawerContent = {
            LazyColumn(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxHeight()
                    .width(300.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(color = Color.White)
                    .padding(8.dp)
            ) {
                item {
                    DrawerItem(
                        text = stringResource(Res.string.main_menu_state),
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    )
                    DrawerItem(
                        text = stringResource(Res.string.main_menu_effects),
                        onClick = {
                            scope.launch {
                                scaffoldState.drawerState.close()
                            }
                        }
                    )
                    DrawerItem(
                        text = stringResource(Res.string.main_menu_remember),
                        onClick = {
                            scope.launch {
                                counter++
                                scaffoldState.drawerState.close()
                            }
                        }
                    )
                    DrawerItem(
                        text = stringResource(Res.string.main_menu_animations),
                        onClick = {
                            scope.launch {
                                navigationController.navigate(AnimationsRoute())
                                scaffoldState.drawerState.close()
                            }
                        }
                    )
                }
            }
        }
    ) {
        Column(
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(
                    Res.string.main_counter_text,
                    counter.toString(),
                ),
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .padding(32.dp) //margin
                    .background(MaterialTheme.colors.surface)
                    .padding(8.dp) //padding
            )
            Text(
                stringResource(Res.string.main_text),
                modifier = Modifier
                    .weight(1f)
            )
            val itemList = (0..5).toList()
            LazyColumn {
                item {
                    Text("Some header")
                }
                items(itemList) { item ->
                    Button(
                        onClick = {
                            navigationController.navigate(DetailRoute(item))
                        }
                    ) {
                        Text(stringResource(Res.string.main_button_text, item))
                    }
                }
            }
        }
    }
}

@Composable
private fun DrawerItem(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(
                vertical = 12.dp,
                horizontal = 16.dp
            )
    ) {
        Text(
            text,
            style = MaterialTheme.typography.subtitle2
        )
    }
}
