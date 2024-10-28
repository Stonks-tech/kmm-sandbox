package tech.stonks.kmmsandbox.ui.page.animations.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StateSection() {
    var isToggled by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        if (isToggled) Color.Green else Color.Red
    )
    val padding by animateDpAsState( //there is more such functions, for animating float, rect, offset etc.
        if (isToggled) 16.dp else 8.dp
    )
    Surface(
        onClick = {
            isToggled = !isToggled
        },
        color = backgroundColor,
        content = {
            Text(text = "Is Toggled: $isToggled", modifier = Modifier.padding(padding))
        },
        shape = CircleShape,
        modifier = Modifier
    )
}
