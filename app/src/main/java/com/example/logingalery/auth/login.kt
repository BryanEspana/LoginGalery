package com.example.logingalery.auth

import android.widget.CheckBox
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
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
    var checkedState by remember { mutableStateOf(false) }


    //Imagenes
    val VectorLogin = painterResource(id = R.drawable.login2)
    val logo = painterResource(id = R.drawable.logo)

    //Iconos
    val email = painterResource(id = R.drawable.baseline_mail_outline_24)
    val password = painterResource(id = R.drawable.baseline_lock_24)
    val iconSee = painterResource(id = R.drawable.eye_solid)
    val iconNotSee = painterResource(id = R.drawable.eye_slash_solid)
    val google = painterResource(id = R.drawable.google)
    val apple = painterResource(id = R.drawable.apple)
    //Texto fuerte
    val modifierTextBold = modifier.padding(start = 20.dp)
    //Fuentes
   //colores
    val backgroundColor = Color(0xFF181822)
    Surface (
        Modifier
            .fillMaxSize(),color = backgroundColor
    ) {
        Column(
            modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())) {
            Column (
                modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color = Color(0xFF020818)),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "LOGIN TO", modifier.align(Alignment.CenterHorizontally),
                    fontSize = 35.sp, color=Color.White, textAlign = TextAlign.Center, fontFamily = FontFamily.SansSerif

                )
                Text(text = "YOUR ACCOUNT", modifier.align(Alignment.CenterHorizontally),
                    fontSize = 35.sp, color=Color.White, textAlign = TextAlign.Center,
                )
            }
            Divider( color = Color(0xFF494949))
            Column (
                Modifier
                    .background(color = Color(0xFF181822))
                    .padding(vertical = 20.dp)
            ) {
                Text(text = "Enter your login information",
                    modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(vertical = 10.dp),
                        fontSize = 18.sp, color=Color(0xFF999999))
                OutlinedTextField(value = text, onValueChange = {
                        newValue ->
                    text = newValue
                },
                    modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    label = {Text(text = "Correo electrónico")},
                    leadingIcon = {
                        Icon(painter =email , contentDescription =null )
                    }
                )
                OutlinedTextField(value = text, onValueChange = {
                        newValue ->
                    text = newValue
                },
                    modifier
                        .fillMaxWidth()
                        .padding(20.dp), label = {Text(text = "Contraseña")},
                    leadingIcon = {
                        Icon(painter = password, contentDescription = null)
                    }
                    )
                Row (
                    modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Row (modifier.padding(start = 10.dp)){
                        Checkbox(checked = checkedState,
                            onCheckedChange ={isChecked -> checkedState = isChecked},)
                        Text(text = "Remember me",modifier.padding(top = 10.dp), color = Color(0xFF999999), )
                    }
                    Text(text = "Forgot password", modifier.padding(top = 10.dp, end = 20.dp), color = Color(0xFF999999))
                }

                Button(onClick = { /*TODO*/ },
                    modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    border = null,
                    shape = MaterialTheme.shapes.small,
                ) {
                    Text(text = "Ingresar")
                }

            }

            Row {
                Divider( color = Color(0xFF494949))
            }


            Row( modifier.align(Alignment.CenterHorizontally)) {
                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(70.dp)
                        .padding(10.dp)
                        .align(Alignment.CenterVertically),
                    colors = CardDefaults.cardColors(Color(0xFF1e222b))
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = google, // Cambia esto a tu recurso de imagen
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }

                Card(
                    modifier = Modifier
                        .width(150.dp)
                        .height(70.dp)
                        .padding(10.dp)
                        .align(Alignment.CenterVertically),
                    colors = CardDefaults.cardColors(Color(0xFF1e222b))
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = apple, // Cambia esto a tu recurso de imagen
                            contentDescription = null,
                            modifier = Modifier.size(25.dp)
                        )
                    }
                }


            }
            Column(
                modifier
                    .fillMaxHeight()
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 10.dp)

            ) {
                Text(text = "¿No tienes cuenta aun? Registrate ", modifier.align(Alignment.CenterHorizontally), color = Color.White)
            }
        }
    }

}