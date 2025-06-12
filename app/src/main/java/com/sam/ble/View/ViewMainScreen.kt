package com.sam.ble.View

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun ViewMainScreen(){
    var turnOnBlub by remember { mutableStateOf(false)}
   if (turnOnBlub) {
       ViewScreenOn(onToggle = {
           turnOnBlub = false
       })
   } else {
       ViewHomeScreen(onToggle = {
           turnOnBlub = true
       })
   }
}