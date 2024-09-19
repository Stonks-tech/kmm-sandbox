package tech.stonks.kmmsandbox.ui.page.detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import tech.stonks.kmmsandbox.ui.navigation.NavigationController

@Composable
fun DetailPage(
    controller: NavigationController,
    index: Int
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Detail Page")
                },
                navigationIcon = {
                    IconButton(onClick = { controller.navigateBack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(it).fillMaxSize()
        ) {
            Text(
                "Hello from detail page [$index]!",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
