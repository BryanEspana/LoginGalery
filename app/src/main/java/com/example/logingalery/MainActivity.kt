package com.example.logingalery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.logingalery.auth.LoginPage
import com.example.logingalery.galery.GaleryPage
import com.example.logingalery.ui.theme.LoginGaleryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            LoginGaleryTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFEBEBEB)
                ) {
                    NavHost(navController, startDestination = "login") {
                        composable("login") { LoginPage(navController = navController) }
                        composable("gallery") {
                            GaleryPage(navController)
                        }
                    }                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}