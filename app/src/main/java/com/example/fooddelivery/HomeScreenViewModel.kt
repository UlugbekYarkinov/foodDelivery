package com.example.fooddelivery

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class HomeScreenViewModel : ViewModel() {
    private val selectedIndex = mutableStateOf(0)

    fun updateSelectedIndex(index: Int) {
        selectedIndex.value = index
    }

    fun getSelectedIndex(): Int {
        return selectedIndex.value
    }

}