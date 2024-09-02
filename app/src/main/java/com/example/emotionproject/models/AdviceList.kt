package com.example.emotionproject.models

import com.google.gson.annotations.SerializedName


data class AdviceList (

  @SerializedName("Title"  ) var Title  : String? = null,
  @SerializedName("Advice" ) var Advice : String? = null

)