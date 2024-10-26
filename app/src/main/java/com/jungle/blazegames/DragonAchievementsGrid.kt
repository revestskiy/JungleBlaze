package com.jungle.blazegames

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jungle.blazegames.ui.theme.nujnoefont

@Composable
fun DragonAchievementsGrid(
    onBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .paint(
                painter = painterResource(id = R.drawable.background2),
                contentScale = ContentScale.Crop
            )
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // Added scroll
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            contentAlignment = Alignment.TopStart
        ) {
            Image(
                painter = painterResource(id = R.drawable.menubutton),
                contentDescription = "Home Button",
                modifier = Modifier
                    .size(55.dp)
                    .clickable {
                        onBack()
                    }
            )
        }
        Text(
            text = "ACHIEVEMENTS",
            fontSize = 38.sp,
            color = Color.White,
            fontFamily = nujnoefont
        )

        Spacer(modifier = Modifier.height(40.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AchievementCard(drawableId = R.drawable.dragon_1, title = "Jungle Explorer")
            AchievementCard(drawableId = R.drawable.dragon_2, title = "Dragon Slayer")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Second row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AchievementCard(drawableId = R.drawable.dragon_3, title = "Keeper of the Flame")
            AchievementCard(drawableId = R.drawable.dragon_4, title = "Wild Tamer")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Third row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AchievementCard(drawableId = R.drawable.dragon_5, title = "Scale Collector")
            AchievementCard(drawableId = R.drawable.dragon_6, title = "King of the Canopy")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Fourth row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            AchievementCard(drawableId = R.drawable.dragon_7, title = "Dragon's Hoard")
            AchievementCard(drawableId = R.drawable.dragon_8, title = "Leafy Lurker")
        }
    }
}

@Composable
fun RowScope.AchievementCard(drawableId: Int, title: String) {
    Card(
        modifier = Modifier
            .weight(1f)
            .padding(8.dp),
        shape = androidx.compose.foundation.shape.RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(androidx.compose.ui.graphics.Color.Transparent) // Remove background color
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // Displaying the image
                Image(
                    painter = painterResource(id = drawableId),
                    contentDescription = title,
                    modifier = Modifier
                        .alpha(
                            if (Prefs.isAchievementUnlocked(title)) 1.0f else 0.5f
                        )
                    ,
                )

            }

            if (Prefs.isAchievementUnlocked(title)) Image(
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(8.dp)
                    .padding(bottom = 30.dp)
                    .size(24.dp)
            )
        }
    }
}
