package com.example.ui_presence_absence.Pages

import android.graphics.Paint.Style
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
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
import androidx.navigation.NavHostController
import com.example.ui_presence_absence.Destination
import com.example.ui_presence_absence.MainActivity
import com.example.ui_presence_absence.R
import com.example.ui_presence_absence.model.getLesson

@Composable
fun ShowClass(navController: NavController, lessonId: String) {

    //Constant variable
    val screenHeight = 740
    val screenWidth = 420
    val backIconRes = painterResource(id = R.drawable.back)
    val exitIconRes = painterResource(id = R.drawable.exit)
    val homeIconRes = painterResource(id = R.drawable.home)
    val settingIconRes = painterResource(id = R.drawable.settings)
    val font = Font(R.font.koodak)

    val lesson = getLesson(lessonId)

    val lessonName = lesson?.lessonName
    val lessonInfo = mapOf(1 to "جلسات", 2 to "دانشجو", 3 to "واحد")
    val lessonInfoNumbers = mapOf(1 to lesson?.getNumberOfSessions().toString(),
                                2 to lesson?.getNumberOfStudents().toString(),
                                3 to lesson?.lessonUnit.toString())


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
                text = "کلاس", style = TextStyle(
                    fontFamily = FontFamily(font),
                    fontSize = 25.sp,
                    fontWeight = FontWeight(400),
                    textAlign = TextAlign.Right,
                    color = MaterialTheme.colorScheme.onBackground
                )
            )
        }

        //body
        Row(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(220.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(220.dp)
                    .drawWithContent {
                        drawContent()
                        drawLine(
                            color = Color.Black,
                            start = Offset(0f, size.height),
                            end = Offset(size.width, size.height),
                            strokeWidth = 2f
                        )
                    },
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .width(screenWidth.dp)
                        .height(100.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    lessonName?.let {
                        Text(
                            text = it,
                            style = TextStyle(
                                textAlign = TextAlign.Center,
                                fontSize = 40.sp,
                                fontFamily = FontFamily(font),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000)
                            )
                        )
                    }
                }
                Row(
                    modifier = Modifier
                        .width(screenWidth.dp)
                        .height(120.dp)
                        .padding(15.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    for (i in 1..3) {
                        Column(
                            modifier = Modifier
                                .width(100.dp)
                                .height(80.dp)
                                .background(
                                    color = Color(0xFFF5F5F5),
                                    shape = RoundedCornerShape(10)
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = lessonInfoNumbers[i].toString(), style = TextStyle(
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(font),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000)
                                )
                            )
                            Text(
                                text = lessonInfo[i].toString(), style = TextStyle(
                                    textAlign = TextAlign.Center,
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(font),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000)
                                )
                            )
                        }
                    }

                }
            }
        }
        Row(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(460.dp)
        ) {
            Column(
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(482.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .width(screenWidth.dp)
                        .height(180.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate(Destination.HozorGhiab.route) },
                        modifier = Modifier
                            .height(180.dp)
                            .width(screenWidth.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text(
                            text = "حضور و غیاب", style = TextStyle(
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight(500),
                                fontSize = 30.sp,
                                fontFamily = FontFamily(font),
                                color = Color(0xFF000000)
                            )
                        )
                    }

                }
                Row(
                    modifier = Modifier
                        .width(screenWidth.dp)
                        .height(180.dp)
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate(Destination.History.route) },
                        modifier = Modifier
                            .height(180.dp)
                            .width(screenWidth.dp / 2 - 20.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text(
                            text = "تاریخچه", style = TextStyle(
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight(500),
                                fontSize = 30.sp,
                                fontFamily = FontFamily(font),
                                color = Color(0xFF000000)
                            )
                        )
                    }
                    Button(
                        onClick = {
                            val route = Destination.Participation.createLessonId(lessonId)
                            navController.navigate(route)
                        },
                        modifier = Modifier
                            .height(180.dp)
                            .width(screenWidth.dp / 2 - 20.dp),
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Text(
                            text = "مشارکت", style = TextStyle(
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight(500),
                                fontSize = 30.sp,
                                fontFamily = FontFamily(font),
                                color = Color(0xFF000000)
                            )
                        )
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
            Button(onClick = { navController.navigate(Destination.MainPage.route)}) {
                Icon(painter = homeIconRes, contentDescription = "Home Icon")
            }
            Button(onClick = { navController.navigate(Destination.Setting.route) }) {
                Icon(painter = settingIconRes, contentDescription = "Setting Icon")
            }
        }


    }

}