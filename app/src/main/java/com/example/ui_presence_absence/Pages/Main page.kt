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
import androidx.navigation.NavController
import com.example.ui_presence_absence.Destination
import com.example.ui_presence_absence.MainActivity
import com.example.ui_presence_absence.R
import com.example.ui_presence_absence.model.getMaster

@Preview
@Composable
fun MainPage(navController: NavController, masterId: String) {

    val master = getMaster(masterId)

    val proffessorName = master?.name
    val groupName = "گروه " + master?.group
    val profId = master?.id

    val screenWidth = 420
    val screenHeight = 740
    val font = Font(R.font.koodak)


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


            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = Color(0xFFFFFFFFF)
                )
            ) {

                val infoIconRes = painterResource(id = R.drawable.info)
                Image(painter = infoIconRes, contentDescription = "")

            }

            // Header title
            Text(
                text = "سامانه حضور و غیاب",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily(font),
                    fontWeight = FontWeight(400),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Right
                )
            )
        }


        // body initialization
        Row(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(300.dp)
        )
        {

            Column(
                modifier = Modifier
                    .width(220.dp)
                    .height(300.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {

                proffessorName?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Right,
                        )
                    )
                }


                groupName?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Right
                        )
                    )
                }


                profId?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.Right,
                        )
                    )
                }


            }

            Column(
                modifier = Modifier
                    .width(190.dp)
                    .height(300.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                val imageRes = painterResource(id = R.drawable.user)
                Image(
                    painter = imageRes, contentDescription = "",
                    modifier = Modifier
                        .width(140.dp)
                        .height(140.dp)
                        .border(2.dp, MaterialTheme.colorScheme.background, CircleShape)
                )

            }
        }

        Row(
            modifier = Modifier
                .width(420.dp)
                .height(380.dp)
                .background(MaterialTheme.colorScheme.background),
        ) {

            Column(
                modifier = Modifier
                    .width(210.dp)
                    .height(283.5.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {

                Button(
                    onClick = { navController.navigate(Destination.ListOfClasses.route) },
                    modifier = Modifier
                        .width(190.dp)
                        .height(250.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        text = "کلاسها", style = TextStyle(
                            fontSize = 28.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onSecondary,
                            textAlign = TextAlign.Center
                        )
                    )
                }

            }

            Column(
                modifier = Modifier
                    .width(210.dp)
                    .height(283.5.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(170.dp)
                        .height(130.dp)
                        .padding(horizontal = 0.dp, vertical = 5.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        text = "برنامه هفتگی", style = TextStyle(
                            fontSize = 25.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onSecondary,
                            textAlign = TextAlign.Center
                        )
                    )
                }

                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .width(170.dp)
                        .height(130.dp)
                        .padding(horizontal = 0.dp, vertical = 5.dp),
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.secondary,
                        contentColor = MaterialTheme.colorScheme.onSecondary
                    )
                ) {
                    Text(
                        text = "جلسات", style = TextStyle(
                            fontSize = 25.sp,
                            fontFamily = FontFamily(font),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onSecondary,
                            textAlign = TextAlign.Center
                        )
                    )
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