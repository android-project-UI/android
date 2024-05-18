package com.example.ui_presence_absence

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ui_presence_absence.Pages.ShowClass
import com.example.ui_presence_absence.Pages.ShowListOfClasses
import com.example.ui_presence_absence.ui.theme.Ui_presence_absenceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ui_presence_absenceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // MainPage()
                    ShowListOfClasses()
                   // ShowClass()
                }
            }
        }
    }
}