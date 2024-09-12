package com.example.emotionproject.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emotionproject.network.ServiceAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NewViewModel(): ViewModel() {

    var description = MutableStateFlow<String>(" ")
    var mainEmotion = MutableStateFlow<String>(" ")

    fun run() {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val postBody = description.value

                val result = ServiceAPI.retrofitService.sendText(postBody)
                println("THE RESULT IS: ${result.AdviceList.size}")
                mainEmotion.value = result.AdviceList[0].Advice.toString()
                println("THE RESULT IS: ${mainEmotion.value}")

                //make the back server to send the main emotion with the rest of the list of advices

            } catch (e: Exception) {
                println("ERROR:  ${e.message}")
            }
        }
    }

}