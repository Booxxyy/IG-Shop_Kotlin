package com.ig.igshop.ui.theme.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin
import com.microsoft.fluent.mobile.icons.R



@Composable
fun JetCircularRatingBar(
    rating: Int,
    modifier: Modifier = Modifier
) {
    val radius = 47

    Box(
        modifier = modifier.size((radius * 2 + 40).dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(
            modifier = Modifier.fillMaxSize()
        ) {
            val strokeWidth = 10.dp.toPx()
            val circleRadius = radius.dp.toPx() - strokeWidth / 2

            drawCircle(
                color = Color(0xFF8F9BA2),
                radius = circleRadius,
                center = center,
                style = Stroke(width = strokeWidth)
            )
        }

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            val starCount = 5
            val circleRadius = radius.dp - 4.dp

            for (i in 0 until starCount) {
                val angle = 2f * PI.toFloat() * i / starCount - PI.toFloat() / 2f
                val starX = circleRadius * cos(angle)
                val starY = circleRadius * sin(angle)

                val color = if (i < rating) Color.Yellow else Color(0xffdad2d2)

                Box(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .offset(
                            x = starX,
                            y = starY
                        )
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_fluent_star_24_filled),
                        contentDescription = "Star",
                        tint = color,
                        modifier = Modifier.size(26.dp)
                    )
                }
            }
        }

        Text(
            text = rating.toString(),
            color = Color.White,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview
@Composable
private fun JetCircularRatingBarPreview() {
    JetCircularRatingBar(
        rating = 3,
        modifier = Modifier
    )
}