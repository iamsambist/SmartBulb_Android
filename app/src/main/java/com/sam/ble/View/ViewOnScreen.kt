package com.sam.ble.View

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sam.ble.ui.theme.BLETheme
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ViewScreenOn(viewModel: ViewModelOnScreen = viewModel(), onToggle: () -> Unit){
    val currentImageRes by viewModel.currentImageRes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF292927))
            .padding(16.dp)
    ) {
        GlowingBulbImage(imageRes = currentImageRes)


        Button(onClick = { onToggle() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(0.dp,0.dp,0.dp,30.dp),
            shape = RoundedCornerShape(6.dp)
        ){
            Text("Turn off")
        }

        Spacer(modifier = Modifier.weight(1f)) // Pushes bottom content to the bottom
        Text("Colors", color = Color.White, modifier = Modifier
            .padding(20.dp,0.dp,0.dp, 10.dp),style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Medium))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val colors = listOf(Color.Red, Color.Yellow, Color(0xFFfe5689))
            colors.forEachIndexed { index, color ->
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(color)
                        .clickable { viewModel.updateImage(color) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ViewOnScreenPreview() {
    BLETheme {
       ViewScreenOn(onToggle = {})
    }
}

@Composable
fun GlowingBulbImage(@DrawableRes imageRes: Int) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(0.8f)
    ) {

        Box(
            modifier = Modifier
                .size(300.dp)
                .graphicsLayer {
                    alpha = 0.6f
                    shadowElevation = 16f
                    shape = CircleShape
                    clip = false
                }
                .background(
                    brush = Brush.radialGradient(
                        colors = listOf(Color.White.copy(alpha = 0.7f), Color.Transparent),
                        center = Offset.Unspecified,
                        radius = 300f
                    ),
                    shape = CircleShape
                )
        )

        // Actual image
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Glowing Bulb",
            modifier = Modifier
                .scale(1.5f),

        contentScale = ContentScale.Fit
        )
    }
}
