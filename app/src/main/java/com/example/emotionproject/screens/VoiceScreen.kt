package com.example.emotionproject.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetnote.speech.AndroidAudioPlayer
import com.example.jetnote.speech.AndroidAudioRecorder
import java.io.File

@Composable
fun VoiceScreen(
    modifier: Modifier,
    newViewModel: NewViewModel,
    recorder: AndroidAudioRecorder,
    player: AndroidAudioPlayer,
    audioFile: File?,
    onBackButtonClicked: () -> Unit,
) {


    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.padding(6.dp),
        ) {
            Button(onClick = {
                audioFile.also {
                    if (it != null) {
                        recorder.start(it)
                    }
                }
            }) {
                Text(text = "Start recording")
            }
            Button(onClick = {
                recorder.stop()
            }) {
                Text(text = "Stop recording")
            }
            Button(onClick = {
                player.playFile(audioFile ?: return@Button)
            }) {
                Text(text = "Start playing")
            }
            Button(onClick = {
                player.stop()
            }) {
                Text(text = "Stop playing")
            }

            Button(onClick = { onBackButtonClicked() }) {
                Text(text = "Back", Modifier.padding(10.dp))
            }

        }

    }

}
