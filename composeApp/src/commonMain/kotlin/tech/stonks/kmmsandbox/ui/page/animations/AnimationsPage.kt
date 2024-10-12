package tech.stonks.kmmsandbox.ui.page.animations

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kmmsandbox.composeapp.generated.resources.Res
import kmmsandbox.composeapp.generated.resources.animations_label_content
import kmmsandbox.composeapp.generated.resources.animations_label_lazy
import kmmsandbox.composeapp.generated.resources.animations_label_state
import kmmsandbox.composeapp.generated.resources.animations_label_visibility
import org.jetbrains.compose.resources.stringResource
import tech.stonks.kmmsandbox.ui.navigation.NavigationController
import tech.stonks.kmmsandbox.ui.page.animations.components.ContentSection
import tech.stonks.kmmsandbox.ui.page.animations.components.LazySection
import tech.stonks.kmmsandbox.ui.page.animations.components.StateSection
import tech.stonks.kmmsandbox.ui.page.animations.components.VisibilitySection


@Composable
fun AnimationsPage(controller: NavigationController) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(
            vertical = 8.dp,
            horizontal = 16.dp
        )
    ) {
        Label(
            text = stringResource(Res.string.animations_label_visibility)
        )
        VisibilitySection()

        Label(
            text = stringResource(Res.string.animations_label_content)
        )
        ContentSection()

        Label(
            text = stringResource(Res.string.animations_label_lazy)
        )
        LazySection()

        Label(
            text = stringResource(Res.string.animations_label_state)
        )
        StateSection()
    }
}


@Composable
private fun Label(
    text: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = text,
        modifier = modifier.padding(top = 16.dp),
        style = MaterialTheme.typography.subtitle1.copy(
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
    )
}
