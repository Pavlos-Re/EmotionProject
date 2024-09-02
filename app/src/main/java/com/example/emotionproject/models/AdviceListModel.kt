package com.example.emotionproject.models

import com.google.gson.annotations.SerializedName

data class AdviceListModel (

  @SerializedName("AdviceList" ) var AdviceList : ArrayList<AdviceList> = arrayListOf()

)