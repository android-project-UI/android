package com.example.ui_presence_absence.Pages

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.example.ui_presence_absence.model.getMaster
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

@Composable
fun Login(navController: NavController) {

    val screenWidth = 420
    val screenHeight = 740
    val bodyHeight = 680
    val font = Font(R.font.koodak)
    val pageSubject = "ورود"

    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var masterId by remember { mutableStateOf("") }

    val mContext = LocalContext.current

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
            Button(onClick = { navController.popBackStack() }) {}

            // Header title
            Text(
                text = pageSubject,
                style = TextStyle(
                    fontSize = 25.sp,
                    fontFamily = FontFamily(font),
                    fontWeight = FontWeight(200),
                    color = Color(0xFFFFFFFF),
                    textAlign = TextAlign.Right
                )
            )
        }

        // Body initialization
        Column(
            modifier = Modifier
                .width(screenWidth.dp)
                .height(bodyHeight.dp)
                .padding(20.dp)
        ) {
            Box() {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text("نام کاربری", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(font),
                        fontWeight = FontWeight(200),
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Right
                    )) },
                    modifier = Modifier
                        .width(screenWidth.dp)
                        .height(70.dp),
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box() {
                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("رمز عبور", style = TextStyle(
                        fontSize = 20.sp,
                        fontFamily = FontFamily(font),
                        fontWeight = FontWeight(200),
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Right
                    )) },
                    modifier = Modifier
                        .width(screenWidth.dp)
                        .height(70.dp),
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    CoroutineScope(Dispatchers.IO).launch {
                        val response = sendLoginRequest(username, password)
                        withContext(Dispatchers.Main) {
                            if (response == 200) {
                                val master = getMaster(username)
                                if (master != null) {
                                    masterId = master.id
                                    val route = Destination.MainPage.createMasterId(masterId.toString())
                                    navController.navigate(route)
                                } else {
                                    ShowNotFoundToast(mContext)
                                }
                            } else {
                                ShowLoginFailedToast(mContext)
                            }
                        }
                    }
                },
                modifier = Modifier
                    .width(screenWidth.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    contentColor = MaterialTheme.colorScheme.onSecondary
                )
            ) {
                Text(
                    text = "اعمال", style = TextStyle(
                        fontSize = 28.sp,
                        fontFamily = FontFamily(font),
                        fontWeight = FontWeight(400),
                        color = MaterialTheme.colorScheme.onSecondary,
                        textAlign = TextAlign.Center
                    )
                )
            }

            Spacer(modifier = Modifier.height(20.dp))
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

            Button(onClick = {}) {
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

suspend fun sendLoginRequest(username: String, password: String): Int {
    val client = HttpClient(CIO)
    return try {
        val response: HttpResponse = client.post("http://192.168.1.136:8099/login") {
            contentType(ContentType.Application.Json)
            setBody(mapOf("username" to username, "password" to password))
        }
        response.status.value
    } catch (e: Exception) {
        0 // Return 0 or some error code to indicate failure
    } finally {
        client.close()
    }
}

fun ShowNotFoundToast(context: Context) {
    Toast.makeText(context, "کاربر یافت نشد", Toast.LENGTH_LONG).show()
}

fun ShowLoginFailedToast(context: Context) {
    Toast.makeText(context, "ورود ناموفق بود", Toast.LENGTH_LONG).show()
}