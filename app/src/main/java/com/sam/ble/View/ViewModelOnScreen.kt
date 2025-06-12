package com.sam.ble.View

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.sam.ble.R

class ViewModelOnScreen: ViewModel() {

    private val _currentImageRes = mutableStateOf(R.drawable.yellowsmall)
    val currentImageRes: State<Int> = _currentImageRes

    fun updateImage(color: Color) {
        _currentImageRes.value = when (color) {
            Color.Red -> R.drawable.redimage
            Color.Yellow -> R.drawable.yellowsmall
            Color(0xFFfe5689) -> R.drawable.pinkimage
            else -> R.drawable.yellowsmall
        }
    }
}