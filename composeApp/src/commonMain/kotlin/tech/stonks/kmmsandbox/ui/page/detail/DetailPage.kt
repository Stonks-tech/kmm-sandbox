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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kmmsandbox.composeapp.generated.resources.Res
import kmmsandbox.composeapp.generated.resources.detail_text
import kmmsandbox.composeapp.generated.resources.detail_title
import org.jetbrains.compose.resources.stringResource
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
                    Text(stringResource(Res.string.detail_title))
                },
                navigationIcon = {
                    IconButton(onClick = { controller.navigateBack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(it).fillMaxSize()
        ) {
            Text(
                stringResource(Res.string.detail_text, index),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
