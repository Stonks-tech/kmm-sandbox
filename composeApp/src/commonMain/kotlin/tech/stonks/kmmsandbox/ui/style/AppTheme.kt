package tech.stonks.kmmsandbox.ui.style

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(
            surface = Color.Red,
            onSurface = Color.White
        ),
        typography = Typography(
            button = TextStyle(
                fontWeight = FontWeight.ExtraBold
            )
        )
    ) {
        content()
    }
}
