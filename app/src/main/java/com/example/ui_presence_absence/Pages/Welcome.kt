package com.example.ui_presence_absence.Pages


import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
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
import com.example.ui_presence_absence.R
import kotlinx.coroutines.delay

@Preview
@Composable
fun Welcome(navController: NavController){

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
        "993623037" to "علی همدانی",
        "993623041" to "نیما حسینی")

    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }

    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(1500L)
        navController.navigate(Destination.MainPage.route)
    }


    Column(modifier = Modifier
        .width(screenWidth.dp)
        .height(screenHeight.dp),
        verticalArrangement = Arrangement.SpaceBetween) {

        
        
        Row(modifier = Modifier.width(screenWidth.dp).height(screenHeight.dp).scale(scale.value),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically) {
            
            Text(text = "سامانه حضور و غیاب",
                style = TextStyle(fontSize = 50.sp,
                    fontFamily = FontFamily(font),
                    fontWeight = FontWeight(400),
                    color = Color(0xFF141E46),
                    textAlign = TextAlign.Center))
            
        }
    }
}