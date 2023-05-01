package com.example.fooddelivery.screens.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.google.firebase.database.FirebaseDatabase

class OrderViewModel : ViewModel() {
    private val orderList = mutableListOf<String>()
    private var userEmail = String()
    private var databaseInstance: FirebaseDatabase? = null

    fun addFoodId(foodLabel: String) {
        orderList.add(foodLabel)
        Log.d("OrderViewModel", "Order list state: $orderList")
    }

    fun getFoodLabelList(): MutableList<String> {
        Log.d("OrderViewModel", "Labels: $orderList")
        return orderList
    }

    fun clearList() {
        orderList.clear()
    }

    fun setUpUser(email: String) {
        userEmail = email
    }

    fun getUserEmail(): String {
        return userEmail
    }

    fun setUpDBInstance(dbInstance: FirebaseDatabase) {
        databaseInstance = dbInstance
    }

    fun getDBRef(): FirebaseDatabase? {
        return databaseInstance
    }
}