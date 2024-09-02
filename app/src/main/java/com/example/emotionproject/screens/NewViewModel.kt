package com.example.emotionproject.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.emotionproject.network.ServiceAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class NewViewModel(): ViewModel() {

    var description = MutableStateFlow<String>("")

    fun run() {
        viewModelScope.launch(Dispatchers.IO) {
            try {

                val postBody = description.value

                val result = ServiceAPI.retrofitService.sendText(postBody)
                println("THE RESULT IS: ${result.AdviceList[0].Title}")

            } catch (e: Exception) {
                println("ERROR:  ${e.message}")
            }
        }
    }

}