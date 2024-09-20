package tech.stonks.kmmsandbox.ui.page.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kmmsandbox.composeapp.generated.resources.Res
import kmmsandbox.composeapp.generated.resources.main_button_text
import kmmsandbox.composeapp.generated.resources.main_text
import kmmsandbox.composeapp.generated.resources.main_title
import org.jetbrains.compose.resources.stringResource
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.page.detail.DetailRoute

@Composable
fun MainPage(
    navigationController: NavigationController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(Res.string.main_title))
                }
            )
        }
    ) {
        Column (
            modifier = Modifier.padding(it).fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(Res.string.main_text),
            )
            for(i in 0..5) {
                Button(
                    onClick = {
                        navigationController.navigate(DetailRoute(i))
                    }
                ) {
                    Text(stringResource(Res.string.main_button_text, i))
                }
            }
        }
    }
}
