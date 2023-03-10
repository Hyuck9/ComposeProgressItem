package io.github.hyuck9.progressitem.sample.ui.view

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.hyuck9.progressitem.ProgressItem
import io.github.hyuck9.progressitem.sample.ui.view.component.SampleControl
import kotlin.math.roundToInt

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SampleScreen(
    modifier: Modifier = Modifier
) {

    var progress by remember { mutableStateOf(60f) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        ProgressItem(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xfff9f2ff))
                .combinedClickable(
                    onClick = { Log.i("TEST", "onClick!") },
                    onLongClick = { Log.i("TEST", "onLongClick!") },
                    onDoubleClick = { Log.i("TEST", "onDoubleClick!") }
                ),
            brush = Brush.horizontalGradient(
                listOf(
                    Color(0xff86f7fa),
                    Color(0xff9b86fa)
                )
            ),
            percent = progress,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "????????? ?????????",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "????????? ????????? zzzzzz",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }

        ProgressItem(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xfff9f2ff)),
            color = Color.Red.copy(0.5f),
            percent = progress,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "????????? ?????????",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "????????? ????????? zzzzzz",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }

        ProgressItem(
            modifier = Modifier
                .padding(vertical = 16.dp)
                .clickable { Log.i("TEST", "onClick!") }
                .fillMaxWidth()
                .shadow(elevation = 3.dp, shape = RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(Color(0xfff9f2ff)),
            progressModifier = Modifier.background(Color.Green.copy(0.5f)),
            percent = progress,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "????????? ?????????",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "????????? ????????? zzzzzz",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }

        
        Spacer(modifier = Modifier.height(10.dp))

        SampleControl("Progress Slider") {
            Slider(
                modifier = Modifier.padding(horizontal = 10.dp),
                value = progress / 100,
                onValueChange = {
                    progress = it * 100
                }
            )
        }

        SampleControl("Progress Point") {
            Button(onClick = { if (progress > 0) progress-- }) {
                Text("-")
            }

            Text(text = "${progress.roundToInt()}")

            Button(onClick = { if (progress < 100) progress++ }) {
                Text("+")
            }
        }
    }
}