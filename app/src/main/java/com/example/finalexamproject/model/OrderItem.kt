package com.example.finalexam.Model

import com.google.gson.annotations.SerializedName

data class OrderItem(
    @SerializedName("id"         ) val id          : Int,
    @SerializedName("title"      ) val title       : String,
    @SerializedName("description") val description : String,
    @SerializedName("price"      ) val price       : Double
)