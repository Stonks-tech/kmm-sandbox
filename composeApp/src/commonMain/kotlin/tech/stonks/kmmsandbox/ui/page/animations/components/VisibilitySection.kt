package tech.stonks.kmmsandbox.ui.page.animations.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kmmsandbox.composeapp.generated.resources.Res
import kmmsandbox.composeapp.generated.resources.animations_visibility_change
import kmmsandbox.composeapp.generated.resources.animations_visibility_example
import org.jetbrains.compose.resources.stringResource

private const val DEFAULT_ANIMATION_DURATION = 700 //slightly longer for better visibility of the animation

@Composable
fun VisibilitySection() {
    var isVisible by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Button(
            onClick = { isVisible = !isVisible },
            content = {
                Text(
                    text = stringResource(Res.string.animations_visibility_change)
                )
            }
        )
        AnimatedVisibility(
            isVisible,
            enter = fadeIn(
                animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION)
            ),
            exit = fadeOut(
                animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION)
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(Res.string.animations_visibility_example),
                style = MaterialTheme.typography.body1,
                color = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(start = 8.dp)
            )
        }
        AnimatedVisibility(
            isVisible,
            enter = slideInHorizontally(
                animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION),
                //slide in from the right
                initialOffsetX = { width -> width }
            ) + fadeIn(
                animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION)
            ), // the animations can be combined
            exit = slideOutHorizontally(
                animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION),
                //slide to the right
                targetOffsetX = { width -> width },
            ) + fadeOut(
                animationSpec = tween(durationMillis = DEFAULT_ANIMATION_DURATION)
            ),
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = stringResource(Res.string.animations_visibility_example),
                style = MaterialTheme.typography.body1,
                color = Color.White,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Black)
                    .padding(start = 8.dp)
            )
        }
    }
}
