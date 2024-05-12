package com.example.ui_presence_absence

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun hozorGhiab(){

    val screenWidth = 420
    val screenHeight =  740
    val bodyHeight = 680
    val font = Font(R.font.koodak)


    val sessionName = "ساختمان های داده"
    val sessionNumber = 7
    val sessionDate = "9/10/1402"



    Column(modifier = Modifier
        .width(screenWidth.dp)
        .height(screenHeight.dp)) {


        // Header implementation
        Row(modifier = Modifier
            .width(screenWidth.dp)
            .height(60.dp)
            .background(MaterialTheme.colorScheme.primary)
            .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ){


            Button(onClick = { /*TODO*/ }) {
                val backRes = painterResource(id = R.drawable.back)
                Image(painter = backRes, contentDescription = "")

            }

            // Header title
            Text(text = "حضور و غیاب",
                style = TextStyle(fontSize = 25.sp,
                    fontFamily = FontFamily(font),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Right)
            )
        }

        // body initialization
        Column(modifier = Modifier
            .width(screenWidth.dp)
            .height(bodyHeight.dp))
        {
        }


        // Footer initialization
        Row(modifier = Modifier
            .width(screenWidth.dp)
            .height(80.dp)
            .background(
                MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp
                )
            ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically) {

            Button(onClick = { /*TODO*/ }) {
                val exitRes = painterResource(id = R.drawable.exit)
                Image(painter = exitRes, contentDescription = "")
            }

            Button(onClick = { /*TODO*/ }) {
                val homeRes = painterResource(id = R.drawable.home)
                Image(painter = homeRes, contentDescription = "")
            }

            Button(onClick = { /*TODO*/ }) {
                val settingsRes = painterResource(id = R.drawable.settings)
                Image(painter = settingsRes, contentDescription = "")
            }
        }
    }
}