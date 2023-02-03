package io.github.hyuck9.progressitem.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import io.github.hyuck9.progressitem.sample.ui.theme.ProgressItemTheme
import io.github.hyuck9.progressitem.sample.ui.view.SampleScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressItemTheme {
                // A surface container using the 'background' color from the theme
                SampleScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}