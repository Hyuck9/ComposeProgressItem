package io.github.hyuck9.progressitem.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.hyuck9.progressitem.ProgressItem
import io.github.hyuck9.progressitem.sample.ui.theme.ProgressItemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProgressItemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        modifier = Modifier.fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        ProgressItem(
                            modifier = Modifier
                                .fillMaxWidth()
                                .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color(0xfff9f2ff)),
                            brush = Brush.horizontalGradient(
                                listOf(
                                    Color(0xff86f7fa),
                                    Color(0xff9b86fa)
                                )
                            ),
                            percent = 60f
                        ) {
                            Text(
                                text = "테스트 입니다",
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                        }

                        Row() {
                            Button(onClick = { /*TODO*/ }) {
                                Text("-")
                            }
                            Button(onClick = { /*TODO*/ }) {
                                Text("+")
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProgressItemTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true)
@Composable
fun ProgressItemPreview() {
    ProgressItemTheme {
        ProgressItem(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xfff9f2ff)),
            brush = Brush.horizontalGradient(listOf(Color(0xff86f7fa), Color(0xff9b86fa))),
            percent = 60f,
            content = @Composable {
                Text(
                    text = "테스트 입니다",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        )
    }
}