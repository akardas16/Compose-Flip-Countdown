package com.example.androiddevchallenge.ui.flipclock

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Flaps(
    currentText: String, nextText: String, factor: Float, textColor: Color = Color.White,
    backgroundColor: Color = Color(0xFF202020),
) {
    var width by remember { mutableIntStateOf(0) }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.onSizeChanged {
        width = it.width
    }) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Box {
                Flap(
                    text = nextText,
                    position = FlapPosition.TOP,
                    textColor = textColor,
                    backgroundColor = backgroundColor
                )

                if (factor < 0.5F) {
                    val f = factor * 2F

                    Flap(
                        text = currentText,
                        position = FlapPosition.TOP,
                        modifier = Modifier.graphicsLayer(
                            rotationX = -90F * f,
                            transformOrigin = TransformOrigin(
                                pivotFractionX = 0.5F,
                                pivotFractionY = 1F
                            )
                        ),
                        textColor = textColor,
                        backgroundColor = backgroundColor
                    )
                }
            }

            Spacer(modifier = Modifier.requiredHeight(2.dp))


            Box {
                Flap(
                    text = currentText,
                    position = FlapPosition.BOTTOM,
                    textColor = textColor,
                    backgroundColor = backgroundColor
                )

                if (factor >= 0.5F) {
                    val f = (1F - factor) * 2F

                    Flap(
                        text = nextText,
                        position = FlapPosition.BOTTOM,
                        modifier = Modifier.graphicsLayer(
                            rotationX = 90F * f,
                            transformOrigin = TransformOrigin(
                                pivotFractionX = 0.5F,
                                pivotFractionY = 0F
                            )
                        ),
                        textColor = textColor,
                        backgroundColor = backgroundColor
                    )
                }
            }
        }
    }
}
