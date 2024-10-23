package com.jungle.blazegames

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jungle.blazegames.ui.theme.nujnoefont
import kotlinx.coroutines.delay
import androidx.compose.material3.Text


@Composable
fun ResultScreen() {
    // Отложенное действие для перехода
    LaunchedEffect(Unit) {
        delay(2000)
        // Здесь можно добавить действия через 2 секунды (например, переход)
    }

    // Основной контейнер
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background2),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.Center // Центровка элементов
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Центровка по горизонтали
            verticalArrangement = Arrangement.Center, // Центрирование всех элементов
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp) // Отступы по краям
        ) {
            // "LEVEL 1" чуть выше "LOSE"
            Text(
                text = "LOSE",
                fontSize = 43.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            Spacer(modifier = Modifier.height(20.dp)) // Отступ между "LEVEL 1" и "LOSE"

            // "LOSE" по центру
            Text(
                text = "LEVEL 1",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            Spacer(modifier = Modifier.height(20.dp)) // Отступ между "LOSE" и "Time is out"

            // "Time is out" чуть ниже "LOSE"
            Text(
                text = "Time is out",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            Spacer(modifier = Modifier.height(50.dp)) // Отступ перед кнопками

            // Кнопки Try Again и Home внизу экрана
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tryagainbutton), // Ресурс кнопки Try Again
                    contentDescription = "Try Again",
                    modifier = Modifier
                        .size(230.dp, 60.dp)
                        .clickable {
                            // Действие при нажатии кнопки Try Again
                        }
                )

                Spacer(modifier = Modifier.height(20.dp)) // Отступ между кнопками Try Again и Home

                Image(
                    painter = painterResource(id = R.drawable.homebutton), // Ресурс кнопки Home
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(230.dp, 60.dp)
                        .clickable {
                            // Действие при нажатии кнопки Home
                        }
                )
            }
        }
    }
}



@Preview
@Composable
fun WinScreen() {
    // Отложенное действие для перехода
    LaunchedEffect(Unit) {
        delay(2000)
        // Здесь можно добавить действия через 2 секунды (например, переход)
    }

    // Основной контейнер
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background2),
                contentScale = ContentScale.Crop
            ),
        contentAlignment = Alignment.Center // Центровка элементов
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Центровка по горизонтали
            verticalArrangement = Arrangement.Center, // Центрирование всех элементов
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp) // Отступы по краям
        ) {
            // Заменяем текст LOSE на изображение winnadpis
            Image(
                painter = painterResource(id = R.drawable.winnadpis), // Ресурс изображения победы
                contentDescription = "Win",
                modifier = Modifier.size(420.dp, 240.dp) // Размер изображения
            )

            Spacer(modifier = Modifier.height(20.dp)) // Отступ между "WIN" и "Score"

            Text(
                text = "LEVEL 1",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            Spacer(modifier = Modifier.height(50.dp))
            Text(
                text = "Score 750",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            Spacer(modifier = Modifier.height(50.dp))// Отступ перед кнопками

            // Кнопки Next и Home внизу экрана
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.nextbutton), // Ресурс кнопки Next
                    contentDescription = "Next",
                    modifier = Modifier
                        .size(230.dp, 60.dp)
                        .clickable {
                            // Действие при нажатии кнопки Next
                        }
                )

                Spacer(modifier = Modifier.height(20.dp)) // Отступ между кнопками Next и Home

                Image(
                    painter = painterResource(id = R.drawable.homebutton), // Ресурс кнопки Home
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(230.dp, 60.dp)
                        .clickable {
                            // Действие при нажатии кнопки Home
                        }
                )
            }
        }
    }
}