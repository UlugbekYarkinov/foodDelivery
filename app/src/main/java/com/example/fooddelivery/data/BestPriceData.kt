package com.example.fooddelivery.data

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BestPriceData(
    @DrawableRes val resId: Int,
    val title: String,
    val price: Double,
    val rate: Double,
    val description: String,
    val calorie: Double,
    val scheduleTime: Int,
    val ingredients: List<Int>
): Parcelable
