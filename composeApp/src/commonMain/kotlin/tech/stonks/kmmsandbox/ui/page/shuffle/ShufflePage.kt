package tech.stonks.kmmsandbox.ui.page.shuffle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import tech.stonks.kmmsandbox.ui.page.animations.components.ShuffleText

@Composable
fun ShufflePage() {
    val text1 = "Tom Marvolo Riddle"
    val text2 = "I am Lord Voldemort"
    var isChanged by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ShuffleText(if (isChanged) text2 else text1)
        Button(
            onClick = { isChanged = !isChanged },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Shuffle")
        }
    }
}
