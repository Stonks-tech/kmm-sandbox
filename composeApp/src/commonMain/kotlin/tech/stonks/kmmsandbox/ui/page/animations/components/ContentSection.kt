package tech.stonks.kmmsandbox.ui.page.animations.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kmmsandbox.composeapp.generated.resources.Res
import kmmsandbox.composeapp.generated.resources.animations_content_error
import kmmsandbox.composeapp.generated.resources.animations_content_expand
import kmmsandbox.composeapp.generated.resources.animations_content_information
import kmmsandbox.composeapp.generated.resources.animations_content_loading
import org.jetbrains.compose.resources.stringResource


@Composable
fun ContentSection() {
    var isExpanded by remember { mutableStateOf(false) }
    var state by remember { mutableStateOf<ContentState>(ContentState.Loading) }

    Column {
        Button(
            onClick = { isExpanded = true },
            content = {
                Text(
                    text = stringResource(Res.string.animations_content_expand)
                )
            }
        )
        StateSelection(
            isExpanded = isExpanded,
            onStateChange = { state = it },
            onDismissRequest = { isExpanded = false }
        )


        AnimatedContent(
            targetState = state, //currently selected state
            contentKey = {
                state::class.simpleName
            },
            transitionSpec = { //animation definition

                val direction = if (initialState.index > targetState.index)//imitate ViewPager behaviour
                    AnimatedContentTransitionScope.SlideDirection.Right
                else
                    AnimatedContentTransitionScope.SlideDirection.Left

                slideIntoContainer(
                    towards = direction
                ) togetherWith slideOutOfContainer(
                    towards = direction
                )
            }
        ) { currentState -> //the state that needs to be built (not always the same as `state`,
            // you might have multiple states displayed in the same time, during animation.
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
            ) {
                when (currentState) {
                    ContentState.Loading -> LoadingStateContent()

                    is ContentState.Information -> InformationStateContent(currentState.text)

                    is ContentState.Error -> ErrorStateContent(currentState.text)
                }
            }
        }
    }
}

@Composable
private fun ErrorStateContent(text: String) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Black)
    ) {
        Text(
            text = text,
            color = Color.Red,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun InformationStateContent(text: String) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color.Green)
    ) {
        Text(
            text = text,
            color = Color.Black,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun LoadingStateContent() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            modifier = Modifier.align(Alignment.Center)
        )
    }
}

@Composable
private fun StateSelection(
    isExpanded: Boolean,
    onStateChange: (ContentState) -> Unit,
    onDismissRequest: () -> Unit,
) {
    DropdownMenu(
        expanded = isExpanded,
        onDismissRequest = onDismissRequest,
        content = {
            Column {
                DropdownMenuItem(
                    onClick = {
                        onStateChange(ContentState.Loading)
                        onDismissRequest()
                    },
                    content = {
                        Text(
                            text = stringResource(Res.string.animations_content_loading)
                        )
                    }
                )
                DropdownMenuItem(
                    onClick = {
                        onStateChange(ContentState.Information("Information content"))
                        onDismissRequest()
                    },
                    content = {
                        Text(
                            text = stringResource(Res.string.animations_content_information)
                        )
                    }
                )
                DropdownMenuItem(
                    onClick = {
                        onStateChange(ContentState.Error("There was an error"))
                        onDismissRequest()
                    },
                    content = {
                        Text(
                            text = stringResource(Res.string.animations_content_error)
                        )
                    }
                )
            }
        }
    )
}

sealed class ContentState(val index: Int) {
    //the index is used to determine the order of the states, to properly animate
    object Loading : ContentState(0)
    data class Information(val text: String) : ContentState(1)
    data class Error(val text: String) : ContentState(2)
}
