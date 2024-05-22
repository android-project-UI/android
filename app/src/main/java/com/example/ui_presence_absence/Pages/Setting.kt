package com.example.ui_presence_absence.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import androidx.navigation.NavController
import com.example.ui_presence_absence.Destination
import com.example.ui_presence_absence.MainActivity
import com.example.ui_presence_absence.R

@Preview
@Composable
fun Setting(navController: NavController) {

    val screenWidth = 420
    val screenHeight = 740
    val bodyHeight = 680
    val font = Font(R.font.koodak)

    Column(
        modifier = Modifier
            .width(screenWidth.dp)
            .height(screenHeight.dp)
            .background(MaterialTheme.colorScheme.background)
    ) {


        Row(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(60.dp)
                .background(MaterialTheme.colorScheme.primary)
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,

            ) {


            Button(onClick = { navController.popBackStack() }) {
                val backRes = painterResource(id = R.drawable.back)
                Image(painter = backRes, contentDescription = "")

            }

            // Header title
            Text(
                text = "تنظیمات",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily(font),
                    fontWeight = FontWeight(200),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Right
                )
            )
        }


        Button(
            onClick = { /* todo */ },
            modifier = Modifier
                .width(380.dp)
                .height(120.dp)
                .padding(horizontal = 10.dp, vertical = 25.dp)
                .align(alignment = Alignment.CenterHorizontally),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "بازیابی رمز عبور",
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontFamily = FontFamily(font),
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onSecondary,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.padding(end = 16.dp) // Adjust padding as needed
                )
            }
        }
        Button(
            onClick = { /* todo */ },
            modifier = Modifier
                .width(380.dp)
                .height(70.dp)
                .padding(horizontal = 10.dp)
                .align(alignment = Alignment.CenterHorizontally),
            shape = RoundedCornerShape(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.secondary,
                contentColor = MaterialTheme.colorScheme.onSecondary
            )
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "ثبت اثر انگشت",
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontFamily = FontFamily(font),
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onSecondary,
                        textAlign = TextAlign.Start
                    ),
                    modifier = Modifier.padding(end = 16.dp) // Adjust padding as needed
                )
            }
        }

        Column(
            modifier = Modifier
                .width(420.dp)
                .height(200.dp)
                .padding(16.dp)
                .clip(shape = RoundedCornerShape(20.dp))  // Apply clipping first
                .background(MaterialTheme.colorScheme.secondary)  // Apply background after clipping
            ,

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                var switch1State by remember { mutableStateOf(false) }
                var switch2State by remember { mutableStateOf(false) }

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier.weight(1f)
                ) {
                    Switch(
                        checked = switch1State,
                        onCheckedChange = { switch1State = it },
                        modifier = Modifier.padding(8.dp)
                    )
                    Switch(
                        checked = switch2State,
                        onCheckedChange = { switch2State = it },
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                    horizontalAlignment = Alignment.End,
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "فعالسازی اثر انگشت",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onSecondary,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.padding(
                            end = 16.dp,
                            bottom = 30.dp
                        ) // Adjust padding as needed
                    )
                    Text(
                        text = "فعالسازی چهره",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onSecondary,
                            textAlign = TextAlign.Start
                        ),
                        modifier = Modifier.padding(end = 16.dp) // Adjust padding as needed
                    )
                }
            }
        }

// Footer initialization
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            Row(
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(80.dp)
                    .align(Alignment.BottomCenter)
                    .background(
                        MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(
                            topStart = 20.dp,
                            topEnd = 20.dp
                        )
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = {
                    val activity: MainActivity = MainActivity()
                    activity.finish()
                    System.exit(0)
                }) {
                    val exitRes = painterResource(id = R.drawable.exit)
                    Image(painter = exitRes, contentDescription = "")
                }

                Button(onClick = { navController.navigate(Destination.MainPage.route) }) {
                    val homeRes = painterResource(id = R.drawable.home)
                    Image(painter = homeRes, contentDescription = "")
                }

                Button(onClick = { navController.navigate(Destination.Setting.route) }) {
                    val settingsRes = painterResource(id = R.drawable.settings)
                    Image(painter = settingsRes, contentDescription = "")
                }
            }
        }
    }
}