package com.example.hogwartsdata.data.model

import com.google.gson.annotations.SerializedName

data class HouseModel (
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("houseColours") val houseColors: String,
    @SerializedName("founder") val founder: String,
    @SerializedName("animal") val animal: String,
    @SerializedName("element") val element: String,
    @SerializedName("ghost") val ghost: String,
    @SerializedName("commonRoom") val commonRoom: String,
    @SerializedName("heads") val heads: List<HeadModel>,
    @SerializedName("traits") val traits: List<TraitModel>
)