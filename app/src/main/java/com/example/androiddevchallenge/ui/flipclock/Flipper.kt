package com.example.androiddevchallenge.ui.flipclock

import android.os.SystemClock
import android.text.format.DateUtils
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.math.ceil
import kotlin.math.max

@Composable
fun Flipper(modifier: Modifier = Modifier,hour:Int,minute:Int,second:Int, textColor: Color = Color.White,
            backgroundColor: Color = Color(0xFF202020), onFinished:() ->Unit = {}) {
    var endTime by remember { mutableLongStateOf(SystemClock.uptimeMillis()) }
    var remainingSeconds by remember { mutableIntStateOf(0) }

    fun updateRemainingTime() {
        remainingSeconds = ceil(max(endTime - SystemClock.uptimeMillis(), 0L).toFloat() / 1000F).toInt()
    }

    fun addTime(millis: Long) {
        endTime = max(endTime, SystemClock.uptimeMillis()) + millis
        updateRemainingTime()
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.Main) {
            while (true) {
                updateRemainingTime()
                delay(100L)
            }
        }
    }

    LaunchedEffect(Unit) {
        val millis = (hour * DateUtils.HOUR_IN_MILLIS) + (minute * DateUtils.MINUTE_IN_MILLIS) + (second * DateUtils.SECOND_IN_MILLIS)
        addTime(millis)
    }

    LaunchedEffect(remainingSeconds) {
        if (remainingSeconds == 0){
            onFinished()
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        FlipClock(
            seconds = remainingSeconds,
            endMillis = endTime,
            textColor, backgroundColor
        )

    }
}
