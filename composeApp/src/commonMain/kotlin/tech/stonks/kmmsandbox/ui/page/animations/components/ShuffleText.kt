@file:OptIn(ExperimentalFoundationApi::class)

package tech.stonks.kmmsandbox.ui.page.animations.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@Composable
fun ShuffleText(
    text: String,
) {
    val characters = remember(text) { text.toCharacterItems() }

    LazyRow {
        items(
            characters,
            key = { character -> character.key }
        ) { item ->
            Text(
                text = item.character.toString(),
                modifier = Modifier.animateItem(
                    placementSpec = tween(
                        durationMillis = 600
                    ),
                )
            )
        }
    }
}

private fun String.toCharacterItems(): List<CharacterItem> {
    val chars = this.toCharArray()
    val result = mutableListOf<CharacterItem>()
    for (i in chars.indices) {
        result.add(CharacterItem(chars[i], result.count { it.character.lowercase() == chars[i].lowercase() }))
    }
    return result
}

data class CharacterItem(
    val character: Char,
    val characterOccurrence: Int,
) {
    val key: String get() = "${character.lowercase()}$characterOccurrence"
}
