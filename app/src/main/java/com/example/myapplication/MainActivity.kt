package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.AnimationConstants
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.magnifier
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHost
import androidx.navigation.NavType
import androidx.navigation.Navigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.screen.LoginScrean
import com.example.myapplication.screen.MenuScrean
import com.example.myapplication.screen.PedidosScrean
import com.example.myapplication.screen.PerfilScrean
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "login",
                        exitTransition = {
                            slideOutOfContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween (1000)
                            )
                        },
                        enterTransition = {
                            slideIntoContainer(
                                towards = AnimatedContentTransitionScope.SlideDirection.Up,
                                animationSpec = tween(1000)
                            )
                        }

                    ){
                        composable(route = "login"){
                            LoginScrean(
                                modifier = Modifier.padding(innerPadding),
                                navController = navController)
                        }
                        composable(route = "menu"){
                            MenuScrean(modifier = Modifier.padding(innerPadding),
                                navController = navController)
                        }
                        composable(
                            route = "perfil/{nome}/{idade}",
                            arguments = listOf(
                                navArgument(name = "nome"){
                                    type = NavType.StringType
                                },
                                navArgument(name = "idade"){
                                    type = NavType.IntType
                                }
                            )
                        )
                        {

                            val nome = it.arguments?.getString("nome")
                            val idade = it.arguments?.getInt("idade")


                            PerfilScrean(modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                nome = nome!!,
                                idade = idade!!
                            )
                        }
                        composable(
                            route = "pedidos?numeroPedido={numeroPedido}",
                            arguments = listOf(
                                navArgument(name = "numeroPedido"){
                                    defaultValue = "sem pedido"
                                }
                            )
                        )
                        {
                            val numeroPedido = it.arguments?.getString("numeroPedido")
                            PedidosScrean(modifier = Modifier.padding(innerPadding),
                                navController = navController,
                                numeroPedido = numeroPedido!!)
                        }
                    }

                }
            }
        }
    }
}





