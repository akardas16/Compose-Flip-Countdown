package com.example.androiddevchallenge

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.flipclock.Flipper
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyTheme(darkTheme = true) {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val context = LocalContext.current
    Surface(color = Color(0xFF2D3E50)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(24.dp,Alignment.CenterVertically),
            modifier = Modifier.fillMaxSize()) {

            Flipper(modifier = Modifier, hour = 6, minute = 23, second = 12)

            Flipper(modifier = Modifier, hour = 9, minute = 12, second = 46,
                textColor = Color.Black, backgroundColor = Color.White)

            Flipper(modifier = Modifier, hour = 0, minute = 0, second = 12,
                textColor = Color.White, backgroundColor = Color(0xFF16A086), onFinished = {
                    Toast.makeText(context,"Finished",Toast.LENGTH_SHORT).show()
                })
        }
    }
}
