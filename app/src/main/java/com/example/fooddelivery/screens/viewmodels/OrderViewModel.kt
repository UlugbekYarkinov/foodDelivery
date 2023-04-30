package com.example.fooddelivery.screens.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel

class OrderViewModel : ViewModel() {
    private val orderList = mutableListOf<String>()

    fun addFoodId(foodLabel: String) {
        orderList.add(foodLabel)
        Log.d("OrderViewModel", "Order list state: $orderList")
    }

    fun getFoodLabelList(): MutableList<String> {
        Log.d("OrderViewModel", "Labels: $orderList")
        return orderList
    }
}