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
                println("THE RESULT IS: ${result.test}")

//            val formBody = FormBody.Builder()
//                .add("test", postBody)
//                .build()
//
//            val request = Request.Builder()
//                .url("http://192.168.1.47:5000/test")
//                .post(formBody)
//                .build()

//            client.newCall(request).execute().use { response ->
//                if (!response.isSuccessful) throw IOException("Unexpected code $response")
//
//                println(response.body!!.string())
//            }
            } catch (e: Exception) {
                println("ERROR:  ${e.message}")
            }
        }
    }
}