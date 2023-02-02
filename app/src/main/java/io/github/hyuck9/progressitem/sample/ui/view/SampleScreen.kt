package io.github.hyuck9.progressitem.sample.ui.view

import androidx.compose.foundation.background
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
            percent = progress
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = "테스트 입니다",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "테스트 입니다 zzzzzz",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
        }
        
        
        Spacer(modifier = Modifier.height(2.dp))

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

            Text(text = "$progress")

            Button(onClick = { if (progress < 100) progress++ }) {
                Text("+")
            }
        }
    }
}