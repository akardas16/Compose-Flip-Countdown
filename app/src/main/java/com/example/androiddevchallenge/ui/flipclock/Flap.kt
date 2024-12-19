package com.example.androiddevchallenge.ui.flipclock

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val FLAP_WIDTH = 48.dp
private val FLAP_HEIGHT = 28.dp
private val TOP_FLAP_SHAPE = RoundedCornerShape(4.dp, 4.dp, 0.dp, 0.dp)
private val BOTTOM_FLAP_SHAPE = RoundedCornerShape(0.dp, 0.dp, 4.dp, 4.dp)

class TopShape : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        return Outline.Generic(
            // Draw your custom path here
            path = drawTicketPath(size = size)
        )
    }
}




fun drawTicketPath(size: Size): Path {

    val p = Path().apply {
        reset()
        addRoundRect(roundRect = RoundRect(left = 0f, top = size.height / 2,
            right = size.width, bottom = 0f,cornerRadius = CornerRadius(x = 32f, y = 32f)
        )
        )
        close()
    }

    val s = Path().apply {
        reset()

        addRoundRect(roundRect = RoundRect(left = 0f, top = size.height / 2,
            right = size.width, bottom = 0f,cornerRadius = CornerRadius(x = 32f, y = 32f)
        )
        )
        moveTo(x = 80f, y = 0f)
        lineTo(x = size.width - 80f, y = 0f)
        lineTo(x = size.width, y = 80f)

        lineTo(x = size.width, y = size.height - (size.height / 6))


        lineTo(x = size.width - (size.height / 6), y = size.height - (size.height / 6))
        lineTo(x = size.width - (size.height / 6), y = size.height)

        lineTo(x = (size.height / 6), y = size.height)

        lineTo(x = (size.height / 6), y = size.height - (size.height / 6))

        lineTo(x = 0f, y = size.height - (size.height / 6))
        //moveTo(x = 0f, y = size.height - 40f)
        lineTo(x = 0f, y =  80f)

        //lineTo(x = 0f, y = size.height)

        close()
    }

    return s.plus(p)

}

@Composable
fun Flap(
    text: String,
    position: FlapPosition,
    modifier: Modifier = Modifier,
    textColor: Color = Color.White,
    backgroundColor: Color = Color(0xFF202020)
) {

    Card(modifier = modifier.requiredSize(width = 48.dp, height = 23.dp), elevation = 0.dp, backgroundColor = Color.Transparent,
        shape = if (position == FlapPosition.TOP) RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp) else RoundedCornerShape(bottomEnd = 8.dp, bottomStart = 8.dp)){
        Image(imageVector = timerBackground(backgroundColor), contentDescription = "",
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if (position == FlapPosition.TOP) Modifier else Modifier.rotate(180f)
                ), contentScale = ContentScale.Crop)

        Text(
            text = text,
            fontWeight = FontWeight.Medium,
            color = textColor,
            fontSize = 34.sp, textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxSize()
                //.align(Alignment.CenterHorizontally)
                .requiredWidth(IntrinsicSize.Min)
                .requiredHeight(IntrinsicSize.Min)
                .run {
                    when (position) {
                        FlapPosition.TOP -> offset(y = FLAP_HEIGHT / 2)
                        FlapPosition.BOTTOM -> offset(y = FLAP_HEIGHT / -2)
                    }
                }
                .offset(y = if (position == FlapPosition.TOP) (-2).dp else 2.dp)

        )
    }
}

enum class FlapPosition {
    TOP, BOTTOM
}
