package com.ig.igshop.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun JetSpecificationCard(
    specifications: List<String>,
    ratings: List<Int>, // Добавляем список рейтингов
    modifier: Modifier = Modifier
) {
    // Проверяем, что количество спецификаций и рейтингов совпадает
    require(specifications.size == ratings.size) {
        "Количество спецификаций и рейтингов должно совпадать"
    }

    Box(
        modifier = Modifier
            .size(width = 350.dp, height = 170.dp)
            .background(
                color = Color(0xFF2E4552).copy(0.5f),
                shape = RoundedCornerShape(
                    topStart = 70.dp,
                    topEnd = 70.dp,
                    bottomEnd = 40.dp,
                    bottomStart = 40.dp
                )
            )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.Center)
        ) {
            Text(
                text = "Спецификации",
                color = Color(0xFFA4A8B3),
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(12.dp)
            )
            Box(
                modifier = Modifier
                    .size(width = 320.dp, height = 170.dp)
                    .background(
                        color = Color(0xFF2E4552),
                        shape = RoundedCornerShape(
                            topStart = 65.dp,
                            topEnd = 65.dp,
                            bottomEnd = 20.dp,
                            bottomStart = 20.dp
                        )
                    )
            ) {
                // Добавляем Row с тремя Column
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    specifications.take(3).forEachIndexed { index, spec ->
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 8.dp)
                        ) {
                            Text(
                                text = spec,
                                color = Color(0xFFA4A8B3),
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(bottom = 10.dp)
                            )
                            JetCircularRatingBar(
                                rating = ratings[index],
                                modifier = Modifier.scale(0.6f)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun JetSpecificationCardPreview() {
    JetSpecificationCard(
        specifications = listOf(
            "Скорость",
            "Корпус",
            "Щиты"
        ),
        ratings = listOf(4, 3, 5), // Добавляем рейтинги
        modifier = Modifier
    )
}