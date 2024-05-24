package com.example.ui_presence_absence.Pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.navigation.NavController
import com.example.ui_presence_absence.Destination
import com.example.ui_presence_absence.MainActivity
import com.example.ui_presence_absence.R
import com.example.ui_presence_absence.model.getLesson

@Preview
@Composable
fun history(navController: NavController, lessonId: String) {

    val screenWidth = 420
    val screenHeight = 740
    val bodyHeight = 680
    val font = Font(R.font.koodak)


    val lesson = getLesson(lessonId)
    val sessionName = lesson?.lessonName
    val numberOfStudents = lesson?.getNumberOfStudents()
    val allSessions = lesson?.getAllSessions()

    val sessionDateMap = mutableMapOf<Int, String>()
    val sessionStatisticsMap = mutableMapOf<Int, Int>()
    var counter = 1
    for(session in allSessions!!){
        sessionDateMap.put(counter, session.date)
        sessionStatisticsMap.put(counter, session.getNumberOfPresentStudents())
        counter++
    }


    Column(
        modifier = Modifier
            .width(screenWidth.dp)
            .height(screenHeight.dp)
    ) {


        // Header implementation
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
                text = "تاریخچه",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily(font),
                    fontWeight = FontWeight(200),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Right
                )
            )
        }

        // body initialization
        Column(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(bodyHeight.dp)
                .padding(10.dp)
        )
        {


            // class information
            Row(
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(100.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
                    .background(
                        color = Color(0xFFD9D9D9),
                        shape = RoundedCornerShape(15.dp)
                    ),
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
                            text = numberOfStudents.toString(),
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontFamily = FontFamily(font),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Center,
                            )
                        )
                        Text(
                            text = "اعضا",
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

                    sessionName?.let {
                        Text(
                            text = it, style = TextStyle(
                                fontSize = 25.sp,
                                fontFamily = FontFamily(font),
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                                textAlign = TextAlign.Right
                            )
                        )
                    }
                }
            }

            Column(
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(520.dp)
                    .padding(vertical = 10.dp, horizontal = 1.dp)
                    .border(1.dp, Color.Black, shape = RoundedCornerShape(15.dp))
                    .background(
                        color = MaterialTheme.colorScheme.background,
                        shape = RoundedCornerShape(15.dp)
                    )
                    .verticalScroll(rememberScrollState()),
            ) {

                for (i in 1..sessionStatisticsMap.size) {
                    Row(
                        modifier = Modifier
                            .width(390.dp)
                            .height(125.dp)
                            .padding(5.dp)
                            .background(
                                color = MaterialTheme.colorScheme.onBackground,
                                shape = RoundedCornerShape(20.dp)
                            ),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.End
                    ) {

                        Button(onClick = { /*TODO*/ },
                            modifier = Modifier.border(2.dp, color = Color(0xFF000000),
                                shape = RoundedCornerShape(20.dp))
                                .width(380.dp)
                                .height(120.dp),

                            shape = RoundedCornerShape(20.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = MaterialTheme.colorScheme.onBackground,)
                            ) {
                            Column(
                                modifier = Modifier
                                    .width(60.dp)
                                    .height(60.dp)
                                    .background(
                                        color = Color(0xFFF5F5F5),
                                        shape = RoundedCornerShape(15.dp)
                                    ),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {

                                Text(text = sessionStatisticsMap[i].toString(), style = TextStyle(
                                    fontSize = 20.sp,
                                    fontFamily = FontFamily(font),
                                    fontWeight = FontWeight(400),
                                    color = Color(0xFF000000),
                                    textAlign = TextAlign.Center
                                ))


                                Text(
                                    text = "حاضرین", style = TextStyle(
                                        fontSize = 12.sp,
                                        fontFamily = FontFamily(font),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center
                                    )
                                )
                            }

                            Column(
                                modifier = Modifier
                                    .width(310.dp)
                                    .padding(5.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    text = i.toString() + "جلسه ",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        fontFamily = FontFamily(font),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Right
                                    )
                                )

                                Text(
                                    text = "تاریخ: " + sessionDateMap[i],
                                    style = TextStyle(
                                        fontSize = 15.sp,
                                        fontFamily = FontFamily(font),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Right
                                    )
                                )
                            }

                        }
                    }
                }
            }
        }


        // Footer initialization
        Row(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(80.dp)
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

            Button(onClick = {
                val masterId = lesson?.master?.id
                val route = Destination.MainPage.createMasterId(masterId.toString())
                navController.navigate(route)}) {
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