package com.jungle.blazegames

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

val yellow = Color(0xFFE9A61A)

@Composable
fun LevelsScreen(onBack: () -> Unit, onLevel: (Int) -> Unit) {
    val pageCount = 3 // Количество страниц
    val levelsPerPage = 15 // Количество уровней на странице (5 x 3)
    val pagerState = rememberPagerState { pageCount }
    var level by remember { mutableIntStateOf(-1) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background2), // Задний фон
                contentScale = ContentScale.Crop
            ), // Темный зеленый фон
    ) {
        // Кнопка "Домой"
        IconButton(
            onClick = { onBack() },
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.menubutton),
                contentDescription = "Домой",
                tint = Color.Unspecified,
                modifier = Modifier
                    .size(60.dp)
            )
        }

        // Текст "Levels"
        Text(
            text = "LEVELS",
            fontSize = 36.sp,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        // Горизонтальный пейджинг для уровней
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
        ) { page ->
            // Размещаем 15 уровней на одной странице (5x3)
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (row in 0..2) { // 3 ряда
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        for (col in 0..4) { // 5 колонок
                            val levelNumber = page * levelsPerPage + (row * 5 + col + 1)
                            LevelButton(
                                selected = level == levelNumber,
                                levelNumber = levelNumber
                            ) {
                                level = levelNumber
                            }
                        }
                    }
                }
            }
        }

        // Индикаторы страниц
        HorizontalPagerIndicator(
            pagerState = pagerState,
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            activeColor = yellow,
            inactiveColor = Color.Gray
        )

        // Кнопка "GO"
        ImageButton(
            imageId = R.drawable.gobtn,
            onClick = {
                if (level != -1) {
                    onLevel(level)
                }
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
    }
}

@Composable
fun ImageButton(imageId: Int, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
        modifier = modifier
    ) {
        Image(painter = painterResource(id = imageId), contentDescription = null)
    }

}

@Composable
fun HorizontalPagerIndicator(
    pagerState: PagerState,
    modifier: Modifier,
    activeColor: Color,
    inactiveColor: Color
) {
    val scope = rememberCoroutineScope()
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        (0 until pagerState.pageCount).forEach { page ->
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .size(8.dp)
                    .background(
                        if (pagerState.currentPage == page) activeColor else inactiveColor,
                        CircleShape
                    )
                    .clickable {
                        scope.launch {
                            pagerState.animateScrollToPage(page)
                        }
                    }
            )
        }
    }
}

@Composable
fun LevelButton(selected: Boolean, levelNumber: Int, onClick: () -> Unit) {
    val backgroundColor = if (selected) yellow.copy(alpha = 0.5f) else Color.Transparent
    Button(
        onClick = {
            if (Prefs.isLevelAvailable(levelNumber)) {
                onClick()
            }
        },
        modifier = Modifier
            .padding(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor), // Оранжевый
        shape = CircleShape
    ) {
        Box(
            modifier = Modifier
                .size(60.dp)
                .paint(
                    painter = painterResource(id = R.drawable.button),
                    contentScale = ContentScale.Crop
                )
                .clip(CircleShape)
                .alpha(if (Prefs.isLevelAvailable(levelNumber)) 1f else 0.5f)
            ,
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = levelNumber.toString(),
                color = Color.White,
                fontSize = 17.sp,
                fontFamily = benzinBold
            )
        }
    }
}
