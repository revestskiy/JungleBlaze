package com.jungle.blazegames

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.* // Для Row, Column, Box и др.
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.ui.draw.paint
import com.jungle.blazegames.ui.theme.nujnoefont

@Composable
fun SettingsScreen(
    onBack: () -> Unit
) {
    // Переменные состояния для переключателей
    val isSoundOn = remember { mutableStateOf(Prefs.soundVolume != 0.0f) }
    val isMusicOn = remember { mutableStateOf(Prefs.musicVolume != 0.0f) }

    // Основной экран
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background2), // Задний фон
                contentScale = ContentScale.Crop
            )
    ) {
        // Верхняя кнопка home
        Image(
            painter = painterResource(id = R.drawable.menubutton), // Картинка кнопки home
            contentDescription = "Home Button",
            modifier = Modifier
                .padding(16.dp)
                .size(60.dp)
                .align(Alignment.TopStart)
                .clickable {
                    // Действие при нажатии кнопки home
                    onBack()
                }
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 40.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Заголовок MENU
            Text(
                text = "MENU",
                fontSize = 44.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Заголовок Sound
            Text(
                text = "SOUND",
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            // Переключатель звука
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = isSoundOn.value,
                    onCheckedChange = { isSoundOn.value = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Red,
                        uncheckedThumbColor = Color.White,
                        checkedTrackColor = yellow,
                        uncheckedTrackColor = Color.Gray
                    )
                )
            }

            // Заголовок Music
            Text(
                text = "MUSIC",
                fontSize = 24.sp,
                color = Color.White,
                fontFamily = nujnoefont
            )

            // Переключатель музыки
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(top = 8.dp, bottom = 24.dp)
            ) {
                Spacer(modifier = Modifier.width(8.dp))
                Switch(
                    checked = isMusicOn.value,
                    onCheckedChange = { isMusicOn.value = it },
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Red,
                        uncheckedThumbColor = Color.White,
                        checkedTrackColor = yellow,
                        uncheckedTrackColor = Color.Gray
                    )
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Кнопка Save
            Image(
                painter = painterResource(id = R.drawable.savebutton), // Картинка кнопки Save
                contentDescription = "Save Button",
                modifier = Modifier
                    .size(width = 200.dp, height = 60.dp)
                    .clickable {
                        // Действие при нажатии кнопки Save
                        if (isSoundOn.value) {
                            Prefs.soundVolume = 0.3f
                        } else {
                            Prefs.soundVolume = 0.0f
                        }
                        if (isMusicOn.value) {
                            Prefs.musicVolume = 0.5f
                        } else {
                            Prefs.musicVolume = 0.0f
                        }
                        SoundManager.setSoundVolume()
                        SoundManager.setMusicVolume()
                        onBack()
                    }
            )
        }
    }
}
