package com.balotiyash.vespolytechnic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun DashboardScroll() {
    val moonScrollSpeed = 0.08f
    val midBgScrollSpeed = 0.03f
    val imageHeight = (LocalConfiguration.current.screenWidthDp * (2f / 3f)).dp
    val laxyListState = rememberLazyListState()
    var moonOffset by remember {
        mutableStateOf(0f)
    }
    var midBgOffset by remember {
        mutableStateOf(0f)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(),
        state = laxyListState
    ) {
        items(10) {
            Text(
                text = "Sample item",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
        item {
            Box(
                modifier = Modifier
                    .clipToBounds()
                    .fillMaxWidth()
                    .height(imageHeight)
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                Color(0xFFf36b21),
                                Color(0xFFf9a521)
                            )
                        )
                    )
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_modified),
                    contentDescription = "VESP",
                    contentScale = ContentScale.FillWidth,
                    alignment = Alignment.BottomCenter,
                    modifier = Modifier
                        .matchParentSize()
                )
            }
        }
        items(20) {
            Text(
                text = "Sample item",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}