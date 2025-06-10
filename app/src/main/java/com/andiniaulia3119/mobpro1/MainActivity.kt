package com.andiniaulia3119.mobpro1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.andiniaulia3119.mobpro1.ui.screen.HomeScreen
import com.andiniaulia3119.mobpro1.ui.theme.DapurKuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DapurKuTheme {
                HomeScreen()
            }
        }
    }
}
