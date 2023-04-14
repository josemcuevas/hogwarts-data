package com.example.hogwartsdata.data.model

import com.google.gson.annotations.SerializedName

data class HeadModel (
    @SerializedName("id") val id: String,
    @SerializedName("firstName") val firstName: String,
    @SerializedName("lastName") val lastName: String,
)