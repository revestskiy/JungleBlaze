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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jungle.blazegames.ui.theme.nujnoefont

@Composable
fun WinScreen(
    isWin: Boolean = false,
    level: Int,
    score: Int,
    onHome: () -> Unit,
    onLevel: (Int) -> Unit
) {

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
            if (isWin) Image(
                painter = painterResource(id = R.drawable.winnadpis), // Ресурс изображения победы
                contentDescription = "Win",
                modifier = Modifier.size(420.dp, 240.dp) // Размер изображения
            ) else Text(
                text = "LOSE",
                fontSize = 43.sp,
                color = Color.White,
                fontFamily = nujnoefont,
                modifier = Modifier
                    .height(200.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp)) // Отступ между "WIN" и "Score"

            Text(
                text = "LEVEL $level",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = nujnoefont,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp))
            if (isWin) Text(
                text = "SCORE\n$score",
                fontSize = 28.sp,
                color = Color.White,
                fontFamily = nujnoefont,
                textAlign = TextAlign.Center
            ) else Text(
                text = "Time is out",
                fontSize = 32.sp,
                color = Color.White,
                fontFamily = nujnoefont,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp))// Отступ перед кнопками

            // Кнопки Next и Home внизу экрана
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = if (!isWin) R.drawable.tryagainbutton else R.drawable.nextbutton), // Ресурс кнопки Next
                    contentDescription = "Next",
                    modifier = Modifier
                        .size(230.dp, 60.dp)
                        .clickable {
                            if (isWin) {
                                onLevel(level+1)
                            } else {
                                onLevel(level)
                            }
                        }
                )

                Spacer(modifier = Modifier.height(20.dp)) // Отступ между кнопками Next и Home

                Image(
                    painter = painterResource(id = R.drawable.homebutton), // Ресурс кнопки Home
                    contentDescription = "Home",
                    modifier = Modifier
                        .size(230.dp, 60.dp)
                        .clickable {
                            onHome()
                        }
                )
            }
        }
    }
}