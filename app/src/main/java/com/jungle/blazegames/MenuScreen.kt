package com.jungle.blazegames

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jungle.blazegames.ui.theme.nujnoefont

@Preview
@Composable
fun MenuScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
                Text(
                    text = "MENU",
                    fontFamily = nujnoefont,
                    fontSize = 44.sp,
                    color = Color.White
                )

            Spacer(modifier = Modifier.height(44.dp))

            Image(
                painter = painterResource(id = R.drawable.playbutton),
                contentDescription = "Play Button",
                modifier = Modifier
                    .size(width = 230.dp, height = 60.dp)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.levelsbutton),
                contentDescription = "Levels Button",
                modifier = Modifier
                    .size(width = 230.dp, height = 60.dp)
                    .clickable {

                    }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.statsbutton),
                contentDescription = "Stats Button",
                modifier = Modifier
                    .size(width = 230.dp, height = 60.dp)
                    .clickable {

                    }
            )

            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.achivmentsbutton),
                contentDescription = "Achievements Button",
                modifier = Modifier
                    .size(width = 230.dp, height = 60.dp)
                    .clickable {

                    }
            )
            Spacer(modifier = Modifier.height(12.dp))

            Image(
                painter = painterResource(id = R.drawable.quitbutton),
                contentDescription = "Quit Button",
                modifier = Modifier
                    .size(width = 230.dp, height = 60.dp)
                    .clickable {

                    }
            )
        }
    }
}

