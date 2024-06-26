package com.example.ui_presence_absence

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ui_presence_absence.Pages.EditPage
import com.example.ui_presence_absence.Pages.Login
import com.example.ui_presence_absence.Pages.MainPage
import com.example.ui_presence_absence.Pages.ShowClass
import com.example.ui_presence_absence.Pages.ShowListOfClasses
import com.example.ui_presence_absence.Pages.history
import com.example.ui_presence_absence.Pages.Participation
import com.example.ui_presence_absence.Pages.Setting
import com.example.ui_presence_absence.Pages.hozorGhiab
import com.example.ui_presence_absence.Pages.Welcome
import com.example.ui_presence_absence.model.createLesson
import com.example.ui_presence_absence.model.createMaster
import com.example.ui_presence_absence.model.createStudents
import com.example.ui_presence_absence.ui.theme.Ui_presence_absenceTheme


sealed class Destination(val route: String) {
    object MainPage : Destination("MainPage/{masterId}"){
        fun createMasterId(masterId: String) = "MainPage/$masterId"
    }
    object ListOfClasses : Destination("ListOfClasses/{masterId}"){
        fun createMasterId(masterId: String) = "ListOfClasses/$masterId"
    }
    object EachClass : Destination("Class/{lessonId}"){
        fun createLessonId(lessonId: String) = "Class/$lessonId"
    }
    object EditPage : Destination("EditPage/{lessonId}"){
        fun createLessonId(lessonId: String) = "EditPage/$lessonId"
    }
    object History : Destination("History/{lessonId}"){
        fun createLessonId(lessonId: String) = "History/$lessonId"
    }
    object HozorGhiab : Destination("HozorGhiab/{lessonId}"){
        fun createLessonId(lessonId: String) = "HozorGhiab/$lessonId"
    }
    object Participation : Destination("Participation/{lessonId}"){
        fun createLessonId(lessonId: String) = "Participation/$lessonId"
    }
    object Setting : Destination("Setting")
    object Welcome : Destination("Welcome")
    object Login: Destination("Login")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ui_presence_absenceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    createStudents()
                    createMaster()
                    createLesson()
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

        composable(Destination.MainPage.route) {navBackStackEntry ->
              val masterId = navBackStackEntry.arguments?.getString("masterId")
            masterId?.let { MainPage(navController = navController, masterId = it) }
        }

        composable(Destination.Participation.route) { navBackStackEntry ->
            val lessonId = navBackStackEntry.arguments?.getString("lessonId")
            lessonId?.let { Participation(navController = navController, lessonId = it) }
        }

        composable(Destination.EachClass.route) { navBackStackEntry ->
            val lessonId = navBackStackEntry.arguments?.getString("lessonId")
            lessonId?.let { ShowClass(navController = navController, lessonId = it) }}

        composable(Destination.History.route) { navBackStackEntry ->
            val lessonId = navBackStackEntry.arguments?.getString("lessonId")
            lessonId?.let { history(navController, it) }
        }
        composable(Destination.EditPage.route) { navBackStackEntry ->
            val lessonId = navBackStackEntry.arguments?.getString("lessonId")
            lessonId?.let { EditPage(navController = navController, lessonId = it) }
        }

        composable(Destination.HozorGhiab.route) { navBackStackEntry ->
            val lessonId = navBackStackEntry.arguments?.getString("lessonId")
            lessonId?.let { hozorGhiab(navController = navController, lessonId = it) }
        }

        composable(Destination.ListOfClasses.route) { navBackStackEntry ->
            val masterId = navBackStackEntry.arguments?.getString("masterId")
            masterId?.let { ShowListOfClasses(navController, masterId)}
        }

        composable(Destination.Setting.route) { Setting(navController) }
        composable(Destination.Login.route){ Login(navController)}
    }
}