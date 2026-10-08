package com.example.myapplication.screen

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun MenuScrean(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Box(
        modifier = modifier.fillMaxSize()
            .background(Color(0xFF2C4EC7))
            .padding(32.dp)
    ) {
        Text(
            text = "MENU",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )

        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    navController.navigate("perfil/nathan/21")
                },
                colors = ButtonDefaults.buttonColors(
                    Color.White
                )
            ) {
                Text(
                    text = "PERFIL",
                    fontSize = 20.sp,
                    color = Color.Blue
                )
            }

            Button(
                onClick = {
                    navController.navigate("pedidos?numeroPedido=4321")
                },
                colors = ButtonDefaults.buttonColors(
                    Color.White
                )
            ) {
                Text(
                    text = "PEDIDOS",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
            Button(
                onClick = {
                    navController.navigate("login")
                },
                colors = ButtonDefaults.buttonColors(
                    Color.White
                )
            ) {
                Text(
                    text = "SAIR",
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }
        }



    }
}