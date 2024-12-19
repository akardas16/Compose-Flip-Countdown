package com.example.androiddevchallenge.ui.flipclock

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

@Composable
fun TestClass(){
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
        Column(verticalArrangement = Arrangement.spacedBy(2.dp), horizontalAlignment = Alignment.CenterHorizontally) {

            Card(modifier = Modifier.requiredSize(width = 48.dp, height = 23.dp), elevation = 0.dp,
                backgroundColor = Color.Transparent){
                Image(imageVector = timerBackground(), contentDescription = "",
                    modifier = Modifier.fillMaxSize(), contentScale = ContentScale.Crop)

                Text(
                    text = "24",
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontSize = 36.sp, textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                        .requiredWidth(IntrinsicSize.Min)
                        .requiredHeight(IntrinsicSize.Min)
                        .run {
                            offset(y = 28.dp / 2)
                        }
                        .offset(y = (-2).dp)
                    //.offset(x = 2.dp)
                )
            }

            Card(modifier = Modifier.requiredSize(width = 48.dp, height = 23.dp),
                backgroundColor = Color.Transparent,elevation = 0.dp){
                Image(imageVector = timerBackground(), contentDescription = "",
                    modifier = Modifier.fillMaxSize().rotate(180f), contentScale = ContentScale.Crop)

                Text(
                    text = "24",
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontSize = 36.sp, textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .align(Alignment.CenterHorizontally)
                        .requiredWidth(IntrinsicSize.Min)
                        .requiredHeight(IntrinsicSize.Min)
                        .run {
                            offset(y = 28.dp / -2)
                        }
                        .offset(y = (2).dp)
                    //.offset(y = (-2).dp)
                )
            }

        }
        Image(painter = painterResource(R.drawable.dots), contentDescription = "", modifier = Modifier.height(28.dp))
    }

}


@Composable
@Preview(showBackground = true)
fun TestClassPrev(){
    Column(modifier = Modifier.size(100.dp).background(Color(0xFF2D3E50)), horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        TestClass()
    }

}