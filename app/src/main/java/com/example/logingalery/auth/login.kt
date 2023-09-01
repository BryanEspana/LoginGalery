package com.example.logingalery.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
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
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.core.content.res.FontResourcesParserCompat.FamilyResourceEntry
import com.example.logingalery.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginPage( modifier: Modifier = Modifier) {
    //Variables remmember
    var text by remember { mutableStateOf(TextFieldValue("")) }

    //Imagenes
    val VectorLogin = painterResource(id = R.drawable.login2)
    val logo = painterResource(id = R.drawable.logo)
    val google = painterResource(id = R.drawable.google)
    val facebook = painterResource(id = R.drawable.facebook_f)
    val twitter = painterResource(id = R.drawable.x_twitter)
    //Texto fuerte
    val modifierTextBold = modifier.padding(start = 20.dp)
    //Fuentes
   // val font = FontFamily(Font(R.font.lexend_mega))
    Surface (
        Modifier
            .fillMaxSize()
            .background(Color(0xFFf6f6f6)),
        color = Color(0xFF040b26)
    ) {
        Column( modifier.fillMaxWidth()) {
            Column (
                modifier
                    .padding(vertical = 50.dp)
                    .align(Alignment.CenterHorizontally)) {
                Text(text = "LOGIN TO", modifier.align(Alignment.CenterHorizontally),
                    fontSize = 35.sp, color=Color.White, textAlign = TextAlign.Center

                )
                Text(text = "YOUR ACCOUNT", modifier.align(Alignment.CenterHorizontally),
                    fontSize = 35.sp, color=Color.White, textAlign = TextAlign.Center,
                )
            }
            Column (
                Modifier.background(color = Color(0xFF08215e))
                    .padding(vertical = 20.dp)
            ) {
                Text(text = "Enter your login information",
                    modifier.align(Alignment.CenterHorizontally),
                    fontSize = 18.sp, color=Color(0xFF243156))
                OutlinedTextField(value = text, onValueChange = {},
                    modifier
                        .fillMaxWidth()
                        .padding(20.dp), label = {Text(text = "Correo electrónico")},
                )
                OutlinedTextField(value = text, onValueChange = {},
                    modifier
                        .fillMaxWidth()
                        .padding(20.dp), label = {Text(text = "Contraseña")})
                Button(onClick = { /*TODO*/ } ,
                    modifier
                        .fillMaxWidth()
                        .padding(20.dp)) {
                    Text(text = "Ingresar")
                }

            }

            Text(text = "- o inicia sesión con -",
                modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp))

            Row( modifier.align(Alignment.CenterHorizontally)) {
                Card(
                    modifier
                        .width(100.dp)
                        .height(40.dp)
                        .padding(horizontal = 10.dp)) {
                    Image(painter = google, contentDescription = null,
                        modifier
                            .width(25.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 5.dp))
                }
                Card (
                    modifier
                        .width(100.dp)
                        .height(40.dp)
                        .padding(horizontal = 10.dp)){
                    Image(painter = facebook, contentDescription = null,
                        modifier
                            .width(15.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 5.dp))
                }
                Card(
                    modifier
                        .width(100.dp)
                        .height(40.dp)
                        .padding(horizontal = 10.dp)) {
                    Image(painter = twitter, contentDescription = null,
                        modifier
                            .width(25.dp)
                            .align(Alignment.CenterHorizontally)
                            .padding(top = 5.dp))
                }

            }
            Column(
                modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterHorizontally)) {
                Text(text = "¿No tienes cuenta aun? Registrate ", modifier.align(Alignment.CenterHorizontally), color = Color.White)
            }
        }
    }

}