package com.example.androiddevchallenge.ui.flipclock

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

fun timerBackground(color: Color = Color(0xFF16A086)): ImageVector = ImageVector.Builder(
	name = "com.example.androiddevchallenge.ui.flipclock.getImg6",
	defaultWidth = 400.dp,
	defaultHeight = 356.dp,
	viewportWidth = 400f,
	viewportHeight = 356f
).apply {
	path(
		fill = SolidColor(color),
		fillAlpha = 1.0f,
		stroke = null,
		strokeAlpha = 1.0f,
		strokeLineWidth = 1.0f,
		strokeLineCap = StrokeCap.Butt,
		strokeLineJoin = StrokeJoin.Miter,
		strokeLineMiter = 1.0f,
		pathFillType = PathFillType.NonZero
	) {
		moveTo(0f, 36f)
		curveTo(00f, 16.11770f, 16.11780f, 00f, 360f, 00f)
		horizontalLineTo(364f)
		curveTo(383.8820f, 00f, 4000f, 16.11770f, 4000f, 360f)
		verticalLineTo(250f)
		horizontalLineTo(0f)
		verticalLineTo(36f)
		close()
	}
	path(
		fill = SolidColor(color),
		fillAlpha = 1.0f,
		stroke = null,
		strokeAlpha = 1.0f,
		strokeLineWidth = 1.0f,
		strokeLineCap = StrokeCap.Butt,
		strokeLineJoin = StrokeJoin.Miter,
		strokeLineMiter = 1.0f,
		pathFillType = PathFillType.NonZero
	) {
		moveTo(40f, 196f)
		horizontalLineTo(360f)
		verticalLineTo(356f)
		horizontalLineTo(40f)
		verticalLineTo(196f)
		close()
	}
}.build()
