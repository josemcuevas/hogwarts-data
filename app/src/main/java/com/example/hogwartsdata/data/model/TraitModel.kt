package com.example.hogwartsdata.data.model

import com.google.gson.annotations.SerializedName

data class TraitModel (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String
)