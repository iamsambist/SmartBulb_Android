package com.sam.ble.View

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sam.ble.R
import com.sam.ble.ui.theme.BLETheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewHomeScreen(onToggle: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141414))
    ) {
        // Top Texts
        Column(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to",
                style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold),
                color = Color.White
            )
            Text(
                text = "SmartBulb",
                style = TextStyle(
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 2.sp // Adjust this value as needed
                ),
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Control your bulb effortlessly, enjoy vibrant colors.",
                style = MaterialTheme.typography.titleSmall,
                color = Color.White
            )
        }


        Image(
            painter = painterResource(id = R.drawable.yellowsmall),
            contentDescription = "Sample Image",
            modifier = Modifier.align(Alignment.Center)
                .scale(1.5f)
        )


        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { onToggle() },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(0.dp,0.dp,0.dp,30.dp),
                shape = RoundedCornerShape(6.dp)
                    ){
                 Text("Turn on")
            }
        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BLETheme {
       ViewHomeScreen(onToggle = {})
    }
}