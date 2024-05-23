package com.example.ui_presence_absence

import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui_presence_absence.Pages.EditPage
import com.example.ui_presence_absence.Pages.MainPage
import com.example.ui_presence_absence.Pages.ShowClass
import com.example.ui_presence_absence.Pages.ShowListOfClasses
import com.example.ui_presence_absence.Pages.history
import com.example.ui_presence_absence.Pages.Participation
import com.example.ui_presence_absence.Pages.Setting
import com.example.ui_presence_absence.Pages.hozorGhiab
import com.example.ui_presence_absence.Pages.Welcome
import com.example.ui_presence_absence.model.Student
import com.example.ui_presence_absence.ui.theme.Ui_presence_absenceTheme


sealed class Destination(val route: String) {
    object MainPage : Destination("MainPage")
    object ListOfClasses : Destination("ListOfClasses")
    object EachClass : Destination("Class")
    object EditPage : Destination("EditPage")
    object History : Destination("History")
    object HozorGhiab : Destination("HozorGhiab")
    object Participation : Destination("Participation")
    object Setting : Destination("Setting")
    object Welcome : Destination("Welcome")
}

class MainActivity : ComponentActivity() {

    val s1 = Student("993623030", "امیر فیض", "user.png", 0.2)
    val s2 = Student("993623031", "کاظم هرندی", "user.png", 0.9)
    val s3 = Student("993623032", "محمد ایرانپور", "user.png", 0.95)
    val s4 = Student("993623033", "محدثه امیری", "user.png", 0.1)
    val s5 = Student("993623034", "تینا بازغی", "user.png", 0.8)
    val s6 = Student("993623035", "مریم امیرجلالی", "user.png", 0.8)
    val s7 = Student("993623036", "کیکاووس یاکیده", "user.png", 1.0)
    val s8 = Student("993623037", "ناصر طهماسب", "user.png", 1.0)
    val s9 = Student("993623038", "شهلا ناظریان", "user.png", 1.0)
    val s10 = Student("993623039", "کلنوش آصفی", "user.png", 0.45)
    val s11 = Student("993623040", "پیروز آشفته", "user.png", 0.6)
    val s12 = Student("993623041", "محمدعلی نجاح", "user.png", 1.0)
    val s13 = Student("993623042", "دیبا پورشانظری", "user.png", 1.0)
    val s14 = Student("993623043", "علی رهبر", "user.png", 1.0)
    val s15 = Student("993623044", "سوگل مشایخی", "user.png", 0.5)
    val s16 = Student("993623045", "علی وارسته", "user.png", 0.75)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ui_presence_absenceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                }
            }
        }
    }
}

@Composable
fun NavigationAppHost(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = Destination.Welcome.route,
        ) {
        composable(Destination.Welcome.route) { Welcome(navController) }
        composable(Destination.MainPage.route) { MainPage(navController) }
        composable(Destination.Participation.route) { Participation(navController) }
        composable(Destination.EachClass.route) { ShowClass(navController) }
        composable(Destination.History.route) { history(navController) }
        composable(Destination.EditPage.route) { EditPage(navController) }
        composable(Destination.HozorGhiab.route) { hozorGhiab(navController) }
        composable(Destination.ListOfClasses.route) { ShowListOfClasses(navController) }
        composable(Destination.Setting.route) { Setting(navController) }
    }
}