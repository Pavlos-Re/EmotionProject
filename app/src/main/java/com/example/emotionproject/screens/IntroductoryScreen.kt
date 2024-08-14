package com.example.emotionproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IntroductoryScreen(
    modifier: Modifier,
    onChoiceTextButtonClicked: () -> Unit,
    onChoiceSpeechButtonClicked: () -> Unit
) {
    Column(
        modifier = modifier,
    ) {
        TopAppBar(title = { Text(text = "Greetings, please make a choice.") })

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { onChoiceTextButtonClicked() }) {
                Text(text = "Text Option")
            }
            Button(onClick = { onChoiceSpeechButtonClicked() }) {
                Text(text = "Speech Option")
            }
        }

    }

}
