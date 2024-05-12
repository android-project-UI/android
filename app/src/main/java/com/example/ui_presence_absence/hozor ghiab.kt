package com.example.ui_presence_absence

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
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
    val sessionNumber = 13
    val sessionDate = "تاریخ: " + "1402/9/2"

    val studentMap = mapOf("993623030" to "علیرضا کریمی",
        "993623031" to "محمد همدانی",
        "993623032" to "کیانا چکناواریان",
        "993623035" to "علی همدانی",
        "993623037" to "علی همدانی")



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
                    fontWeight = FontWeight(200),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Right)
            )
        }

        // body initialization
        Column(modifier = Modifier
            .width(screenWidth.dp)
            .height(bodyHeight.dp)
            .padding(10.dp))
        {

            // class information
            Row(
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(100.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
                    .background(color = Color(0xFFD9D9D9), shape = RoundedCornerShape(15.dp)),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column(
                    modifier = Modifier
                        .width(140.dp)
                        .padding(10.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
                            .background(
                                color = Color(0xFFF5F5F5),
                                shape = RoundedCornerShape(15.dp)
                            ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = sessionNumber.toString(),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(font),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        Text(
                            text = "جلسه",
                            style = TextStyle(
                                fontSize = 15.sp,
                                fontFamily = FontFamily(font),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                    }
                }

                Column(
                    modifier = Modifier
                        .width(250.dp)
                        .padding(10.dp),
                    horizontalAlignment = Alignment.End
                ) {

                    Text(
                        text = sessionName, style = TextStyle(
                            fontSize = 25.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Right
                        )
                    )

                    Text(
                        text = sessionDate, style = TextStyle(
                            fontSize = 18.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Right
                        )
                    )
                }
            }

            // student information
            Column(
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(400.dp)
                    .padding(vertical = 10.dp, horizontal = 1.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .verticalScroll(rememberScrollState()),
            ) {

                for (key in studentMap.keys) {
                    Row(
                        modifier = Modifier
                            .width(390.dp)
                            .height(80.dp)
                            .padding(5.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onBackground,
                                shape = RoundedCornerShape(10.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {

                        Column(
                            modifier = Modifier
                                .width(150.dp)
                                .padding(5.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = "${studentMap[key]}",
                                style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(font),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Right
                                )
                            )

                            Text(
                                text = "$key",
                                style = TextStyle(
                                    fontSize = 15.sp,
                                    fontFamily = FontFamily(font),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Right
                                )
                            )
                        }

                        Column(
                            modifier = Modifier
                                .width(60.dp)
                                .padding(5.dp)
                        ) {
                            val studentImage = painterResource(id = R.drawable.user)
                            Image(
                                painter = studentImage, contentDescription = "",
                                modifier = Modifier.size(56.dp)
                            )
                        }
                    }
                }
            }
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