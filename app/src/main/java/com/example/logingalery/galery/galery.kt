package com.example.logingalery.galery

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.logingalery.R
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll


sealed class MyImage {
    data class Static(val resId: Int) : MyImage()
    data class Animated(val resId: Int) : MyImage()
}


@Composable
fun GaleryPage( navController: NavController){
    //Colores
    val backgroundColor = Color(0xFF181822)

    //Iconos
    val logout = painterResource(id = R.drawable.baseline_logout_24)

    //Volver gif el sol
    val context = LocalContext.current
    val imageLoader = ImageLoader.Builder(context)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .build()
    //Lista de imagenes
    val images = listOf(
        MyImage.Animated(R.drawable.sun),
        MyImage.Static(R.drawable.tierra2),
        MyImage.Static(R.drawable.marte),
        MyImage.Static(R.drawable.saturno),
    )
    val descriptions = listOf(
        "El \"Sol\" es nuestra estrella más cercana, fuente esencial de energía y luz para el sistema solar.",
        "La majestuosa \"Tierra\" en todo su esplendor, mostrando su exuberante belleza desde las alturas cósmicas",
        "Marte, el \"Planeta Rojo\", es conocido por su terreno árido y sus icónicos cañones y montañas.",
        "\"Saturno\" es famoso por su impresionante sistema de anillos compuesto principalmente de partículas de hielo."
    )

    //Rastrear imagenes:
    var currentIndex by remember { mutableStateOf(0) }
    val currentImage = images[currentIndex]
    val currentDescription = descriptions[currentIndex]

    //Alerta de cerrar sesión:
    var showDialog by remember { mutableStateOf(false) }
    if (showDialog) {
        AlertDialog(
            onDismissRequest = {
                showDialog = false
            },
            title = {
                Text("Cerrar Sesión")
            },
            text = {
                Text("¿Desea cerrar sesión?")
            },
            confirmButton  = {
                Button(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Cancelar")
                }
                Button(
                    onClick = {
                        showDialog = false
                        navController.navigate("login")

                    }
                ) {
                    Text("Aceptar")
                }

            }
        )
    }
    //fotos
    Surface(
        Modifier
            .fillMaxSize(), color = backgroundColor
    ) {
        Column(Modifier.fillMaxSize().verticalScroll(rememberScrollState())) {
            Column(Modifier.padding(top = 10.dp)) {
                Surface ( color = Color(0xFF31343c), modifier = Modifier
                    .clip(RoundedCornerShape(topEnd = 15.dp, bottomEnd = 15.dp)),
                ) {
                    Box(Modifier.clickable {
                        showDialog = true
                    }) {
                        Row {
                            Image(painter = logout, contentDescription = null,
                                Modifier.padding(start = 10.dp, top = 10.dp),
                                colorFilter = ColorFilter.tint(Color.White) )
                            Text(text = "Log Out",
                                Modifier.padding(top = 10.dp, bottom = 10.dp, end = 10.dp, start = 5.dp),
                                color = Color.White,
                            )
                        }

                    }
                }
            }

            Column (Modifier.padding(start = 40.dp, end = 40.dp, top = 60.dp )) {

                when (currentImage) {
                    is MyImage.Static -> {
                        val painter = painterResource(id = currentImage.resId)
                        Image(
                            painter = painter,
                            contentDescription = null,
                            modifier = Modifier
                                .height(400.dp)
                                .clip(RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                    is MyImage.Animated -> {
                        Image(
                            painter = rememberAsyncImagePainter(R.drawable.sun, imageLoader),
                            contentDescription = null,
                            modifier = Modifier
                                .height(400.dp)
                                .clip(RoundedCornerShape(topEnd = 15.dp, topStart = 15.dp)),
                            contentScale = ContentScale.Crop
                        )
                    }
                }
                Surface ( color = Color(0xFF31343c), modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp)
                    .clip(RoundedCornerShape(bottomStart = 15.dp, bottomEnd = 15.dp)),
                ) {
                    Text(
                        text =currentDescription,
                        color = Color.White,
                        modifier = Modifier
                            .padding(10.dp)
                            .then(Modifier.graphicsLayer(scaleX = 0.8f, scaleY = 0.8f))
                    )
                }
                Row (Modifier.padding(10.dp).fillMaxWidth(), Arrangement.SpaceBetween){
                    Button(onClick = {
                        if (currentIndex > 0) {
                            currentIndex--
                        }
                    },
                        Modifier
                            .width(150.dp)
                            .padding(horizontal = 10.dp),
                        border = null,
                        shape = MaterialTheme.shapes.small,
                    ) {
                        Text(text = "Atras")
                    }
                    Button(onClick = {
                        if (currentIndex < images.size - 1) {
                            currentIndex++
                        }
                    },
                        Modifier
                            .width(150.dp)
                            .padding(horizontal = 10.dp),
                        border = null,
                        shape = MaterialTheme.shapes.small,
                    ) {
                        Text(text = "Siguiente")
                    }
                }
            }
        }
    }
}