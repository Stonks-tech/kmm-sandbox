package tech.stonks.kmmsandbox.ui.page.animations.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
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
import kmmsandbox.composeapp.generated.resources.Res
import kmmsandbox.composeapp.generated.resources.animations_lazy_add
import org.jetbrains.compose.resources.stringResource
import kotlin.random.Random

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun LazySection() {
    val random = remember { Random(0) }
    var items by remember { mutableStateOf(listOf(100, 200, 300)) }
    Column {
        Button(
            onClick = {
                items = items + (random.nextInt(0, 1000))
            },
            content = {
                Text(text = stringResource(Res.string.animations_lazy_add))
            },
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(
                items,
                key = { item -> item },  // key is required for correct item animations, it should be unique for each item
            ) { item ->                 // so usually you will use something like `id` or `uuid` for this
                Surface(
                    onClick = {
                        items = items.filter { it != item }
                    },
                    color = Color.Red.copy(alpha = 0.5f),
                    content = {
                        Text(text = item.toString(), modifier = Modifier.padding(8.dp))
                    },
                    shape = CircleShape,
                    modifier = Modifier.animateItemPlacement()// this modifier automatically animates item placement
                )
            }
        }
    }
}
