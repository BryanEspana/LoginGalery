package com.example.logingalery.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.logingalery.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage( modifier: Modifier = Modifier) {
    //Variables remmember
    var text by remember { mutableStateOf(TextFieldValue("")) }

    //Imagenes
    val VectorLogin = painterResource(id = R.drawable.login2)

    //Texto fuerte
    val modifierTextBold = modifier.padding(start = 20.dp)

    Surface (
        Modifier
            .fillMaxSize()
            .background(Color(0xFF1F1A30)),
        color = Color(0xFF1F1A30)
    ) {
        Column( modifier.fillMaxWidth()) {
            Image(painter = VectorLogin, contentDescription =null,
                modifier
                    .width(230.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 50.dp)
            )
            Text(text = "Login", color = Color.White, modifier = modifierTextBold, fontSize = 30.sp)
        }
    }

}