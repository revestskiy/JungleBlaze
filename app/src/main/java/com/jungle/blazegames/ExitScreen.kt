package com.jungle.blazegames

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jungle.blazegames.ui.theme.nujnoefont


@Preview
@Composable
fun ExitScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painter = painterResource(id = R.drawable.background2),
                contentScale = ContentScale.Crop
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
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

                        }
                )
            }

            Spacer(modifier = Modifier.height(46.dp))


            Text(
                text = "EXIT",
                fontFamily = nujnoefont,
                fontSize = 55.sp,
                color = Color.White,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(78.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yesbutton),
                    contentDescription = "Yes Button",
                    modifier = Modifier
                        .size(170.dp, 70.dp)
                        .clickable {

                        }
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(id = R.drawable.nobutton),
                    contentDescription = "No Button",
                    modifier = Modifier
                        .size(170.dp, 70.dp)
                        .clickable {

                        }
                )
            }
        }
    }
}