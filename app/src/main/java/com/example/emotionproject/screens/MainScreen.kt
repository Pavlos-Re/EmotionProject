package com.example.emotionproject.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.emotionproject.R
import com.example.jetnote.speech.AndroidAudioPlayer
import com.example.jetnote.speech.AndroidAudioRecorder
import java.io.File

enum class EmotionProjectScreen(@StringRes val title: Int) {
    Start(title = R.string.main_screen),
    Text(title = R.string.text_option),
    Speech(title = R.string.speech_option)
}

@Composable
fun MainScreen(
    audioFile: File,
    player: AndroidAudioPlayer,
    recorder: AndroidAudioRecorder,
    newViewModel: NewViewModel,
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = EmotionProjectScreen.Start.name,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(route = EmotionProjectScreen.Start.name) {
            IntroductoryScreen(modifier = Modifier.fillMaxSize(),
                onChoiceTextButtonClicked = { navController.navigate(EmotionProjectScreen.Text.name)},
                onChoiceSpeechButtonClicked = { navController.navigate(EmotionProjectScreen.Speech.name)})
        }
        composable(route = EmotionProjectScreen.Text.name) {
            TextScreen(modifier = Modifier.fillMaxSize(), newViewModel,onBackButtonClicked = {
                navController.navigate(EmotionProjectScreen.Start.name)
            })
        }
        composable(route = EmotionProjectScreen.Speech.name) {
            VoiceScreen(modifier = Modifier.fillMaxSize(), newViewModel, recorder, player, audioFile, onBackButtonClicked = {
                navController.navigate(EmotionProjectScreen.Start.name)
            })
        }
    }

}
