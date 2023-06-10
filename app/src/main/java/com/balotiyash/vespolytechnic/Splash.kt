package com.balotiyash.vespolytechnic

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.balotiyash.vespolytechnic.ui.theme.VESPolytechnicTheme
import kotlinx.coroutines.delay

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splashScreen") {
        composable("splashScreen") {
            SplashScreen(navController = navController)
        }
        composable("mainScreen") {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Yash"
                )
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        androidx.compose.animation.core.Animatable(0f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.4f,
            animationSpec = tween(
                durationMillis = 1000,
                easing = {
                    OvershootInterpolator(2f).getInterpolation(it)
                }
            )
        )
        delay(3500L)
        navController.navigate("mainScreen")
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ves_logo_circle),
            contentDescription = "SplashLogo",
            modifier = Modifier.scale(scale.value)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Splash"
)
@Composable
fun SplashPreview() {
    VESPolytechnicTheme {
        Navigation()
    }
}
