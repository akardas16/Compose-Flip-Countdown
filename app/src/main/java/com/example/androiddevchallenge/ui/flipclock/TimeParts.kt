package com.example.androiddevchallenge.ui.flipclock

fun getTimeParts(seconds: Int): TimeParts {
    val partHours = seconds / 60 / 60
    val partMinutes = (seconds - partHours * 60 * 60) / 60
    val partSeconds = seconds - partHours * 60 * 60 - partMinutes * 60

    return TimeParts(
        hours = partHours,
        minutes = partMinutes,
        seconds = partSeconds
    )
}

class TimeParts(
    val hours: Int,
    val minutes: Int,
    val seconds: Int
)
