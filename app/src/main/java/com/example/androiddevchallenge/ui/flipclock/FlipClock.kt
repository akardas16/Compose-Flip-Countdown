package com.example.androiddevchallenge.ui.flipclock

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import kotlin.math.ceil

@Composable
fun FlipClock(
    seconds: Int,
    endMillis: Long,
    textColor: Color = Color.White,
    backgroundColor: Color = Color(0xFF202020)) {
    val animatedSeconds by animateFloatAsState(key = endMillis, targetValue = seconds.toFloat())

    val currentSeconds = ceil(animatedSeconds).toInt()
    val nextSeconds = currentSeconds - 1
    val factor = currentSeconds.toFloat() - animatedSeconds
    val currentParts = getTimeParts(currentSeconds)
    val nextParts = getTimeParts(nextSeconds)

    Row(verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp,Alignment.CenterHorizontally)) {

        Flaps(
            currentText = currentParts.hours.toString().padStart(2, '0'),
            nextText = nextParts.hours.toString().padStart(2, '0'),
            factor = if (currentParts.hours == nextParts.hours) 0F else factor,
            textColor, backgroundColor
        )

        Image(painter = painterResource(R.drawable.dots), contentDescription = "", modifier = Modifier.height(28.dp))


        Flaps(
            currentText = currentParts.minutes.toString().padStart(2, '0'),
            nextText = nextParts.minutes.toString().padStart(2, '0'),
            factor = if (currentParts.minutes == nextParts.minutes) 0F else factor,
            textColor, backgroundColor
        )

        Image(painter = painterResource(R.drawable.dots), contentDescription = "", modifier = Modifier.height(28.dp))


        Flaps(
            currentText = currentParts.seconds.toString().padStart(2, '0'),
            nextText = nextParts.seconds.toString().padStart(2, '0'),
            factor = if (currentParts.seconds == nextParts.seconds) 0F else factor,
            textColor, backgroundColor
        )
    }
}
