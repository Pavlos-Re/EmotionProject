package com.example.emotionproject

import android.Manifest
import android.os.Bundle
import android.os.Environment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import com.example.emotionproject.screens.MainScreen
import com.example.emotionproject.screens.NewViewModel
import com.example.emotionproject.ui.theme.EmotionProjectTheme
import com.example.jetnote.speech.AndroidAudioPlayer
import com.example.jetnote.speech.AndroidAudioRecorder
import java.io.File

class MainActivity : ComponentActivity() {

    private val recorder by lazy {
        AndroidAudioRecorder(applicationContext)
    }

    private val player by lazy {
        AndroidAudioPlayer(applicationContext)
    }

    private var audioFile: File? = null

    private val newViewModel: NewViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).absolutePath

        //val outputFile = File(downloadsDir, "audio.mp3")

        audioFile = File(downloadsDir, "audio.wav")
        //val noteViewModel: NoteViewModel by viewModels()

        ActivityCompat.requestPermissions(
            this,
            arrayOf(Manifest.permission.RECORD_AUDIO),
            0
        )
        enableEdgeToEdge()
        setContent {
            EmotionProjectTheme {
                   MainScreen(audioFile!!, player, recorder,newViewModel)
            }
        }

    }

}
