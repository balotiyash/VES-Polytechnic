package com.balotiyash.vespolytechnic

import android.annotation.SuppressLint
import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionResult
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
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
//                Text(
//                    text = "Yash"
//                )
                DashboardScroll()
            }
        }
    }
}

@SuppressLint("RememberReturnType")
@Composable
fun SplashScreen(navController: NavController) {
    val scale = remember {
        Animatable(0f)
    }
    val col = R.color.VESLightYellow
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
//        navController.popBackStack()
        navController.navigate("mainScreen")
    }
    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFD93D))
    ) {
        Image(
            painter = painterResource(id = R.drawable.ves_logo_c1),
            contentDescription = "SplashLogo",
            modifier = Modifier
                .scale(scale.value)
                .size(804.dp)
        )
        Loader()
        PrintText()
    }
}

@Composable
fun Loader() {
    val compositionResult: LottieCompositionResult =
        rememberLottieComposition(
        LottieCompositionSpec.Asset(
            "Circle.json"
        )
    )
    val progress by animateLottieCompositionAsState(
        compositionResult.value,
        isPlaying = true,
        iterations = 1,
        speed = 1.0f
    )
    LottieAnimation(compositionResult.value, progress)
}

@Composable
fun PrintText(modifier: Modifier = Modifier) {
    val fontFamily = FontFamily(
        Font(R.font.tenorsans_regular)
    )
    Text(
        text = "POLYTECHNIC",
        fontFamily = fontFamily,
        modifier = Modifier
            .padding(top = 500.dp),
        fontSize = 24.sp,
        color = Color(0xFF4F200D)
    )
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