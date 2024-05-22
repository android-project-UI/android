package com.example.ui_presence_absence.Pages

import android.graphics.Paint.Style
import android.provider.MediaStore.Audio.Radio
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ui_presence_absence.Destination
import com.example.ui_presence_absence.MainActivity
import com.example.ui_presence_absence.R

@Composable
fun ShowListOfClasses(navController: NavController) {

    //Constant variable
    val screenHeight = 740
    val screenWidth = 420
    val backIconRes = painterResource(id = R.drawable.back)
    val exitIconRes = painterResource(id = R.drawable.exit);
    val homeIconRes = painterResource(id = R.drawable.home);
    val settingIconRes = painterResource(id = R.drawable.settings);
    val font = Font(R.font.koodak)
    val numberOfClasses = 3
    val classDates = mapOf(
        1 to "زمان: شنبه 10-12, یکشنبه 8-10",
        2 to "زمان: دوشنبه 10-12, شنبه 8-10",
        3 to "زمان: چهارشنبه 10-12"
    )
    val lessonUnits = mapOf(1 to "3", 2 to "3", 3 to "2")
    val lessonNames = mapOf(1 to "ساختمان داده", 2 to "زبان تخصصی", 3 to "طراحی الگوریتم")

    Column(
        modifier = Modifier
            .width(screenWidth.dp)
            .height(screenHeight.dp)
    ) {
        //Header
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
                Icon(
                    painter = backIconRes,
                    contentDescription = "back icon",
                )
            }

            Text(
                text = "لیست کلاس ها", style = TextStyle(
                    fontFamily = FontFamily(font),
                    fontSize = 25.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Right,
                    color = Color(0xFFFFFFFF)
                )
            )
        }

        //Body
        Row(
            modifier = Modifier
                .height(680.dp)
                .width(screenWidth.dp)

        ) {
            Column(
                modifier = Modifier
                    .height(400.dp)
                    .width(screenWidth.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                for (i in 1..numberOfClasses) {
                    Button(
                        onClick = { navController.navigate(Destination.EachClass.route) },
                        modifier = Modifier
                            .border(
                                2.dp,
                                color = Color(0xFF000000),
                                shape = RoundedCornerShape(20.dp)
                            )
                            .width(380.dp)
                            .height(120.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onBackground,
                        ),
                    ) {
                        Row(
                            modifier = Modifier
                                .width(380.dp)
                                .height(120.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Column(
                                modifier = Modifier
                                    .width(68.dp)
                                    .height(68.dp)
                                    .background(
                                        color = Color(0xFFF5F5F5),
                                        shape = RoundedCornerShape(15.dp)
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = lessonUnits[i].toString(),
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight(400),
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(font),
                                        color = Color(0xFF000000)
                                    )
                                )
                                Text(
                                    text = "واحد",
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight(400),
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(font),
                                        color = Color(0xFF000000)
                                    )
                                )
                            }
                            Column(
                                modifier = Modifier
                                    .width(250.dp),
                                horizontalAlignment = Alignment.End,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = lessonNames[i].toString(),
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight(400),
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(font),
                                        color = Color(0xFF000000)
                                    )
                                )
                                Text(
                                    text = classDates[i].toString(),
                                    style = TextStyle(
                                        textAlign = TextAlign.Center,
                                        fontWeight = FontWeight(400),
                                        fontSize = 18.sp,
                                        fontFamily = FontFamily(font),
                                        color = Color(0xFF000000)
                                    )
                                )
                            }


                        }
                    }
                }

            }
        }

        //Footer
        Row(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(80.dp)
                .background(
                    MaterialTheme.colorScheme.primary, shape = RoundedCornerShape(
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                )
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                val activity: MainActivity = MainActivity()
                activity.finish()
                System.exit(0)
            }) {
                Icon(painter = exitIconRes, contentDescription = "Exit Icon")
            }
            Button(onClick = { navController.navigate(Destination.MainPage.route) }) {
                Icon(painter = homeIconRes, contentDescription = "Home Icon")
            }
            Button(onClick = { navController.navigate(Destination.Setting.route) }) {
                Icon(painter = settingIconRes, contentDescription = "Setting Icon")
            }
        }


    }

}