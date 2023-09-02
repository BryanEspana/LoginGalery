package com.example.logingalery.galery

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.logingalery.R

@Composable
fun GaleryPage(){
    val backgroundColor = Color(0xFF181822)
    val imageTierra = painterResource(id = R.drawable.tierra2)

    //fotos
    Surface(
        Modifier
            .fillMaxSize(), color = backgroundColor
    ) {
        Column (Modifier.padding(start = 40.dp, end = 40.dp, top = 40.dp )) {
            Image(painter = imageTierra, contentDescription =null, modifier =
            Modifier
                .width(400.dp)
                .height(400.dp)
                .clip(RoundedCornerShape(15.dp)),
                contentScale = ContentScale.Crop )
            Card {
                Text(text = "TIERRA")
            }
        }
    }
}