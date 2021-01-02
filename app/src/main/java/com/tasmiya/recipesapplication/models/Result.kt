package com.tasmiya.recipesapplication.models


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Result(
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("title")
    val title: String
): Parcelable