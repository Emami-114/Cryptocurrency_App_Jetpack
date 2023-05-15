package com.example.cryptocurrency_app_jetpack.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cryptocurrency_app_jetpack.presentation.coin_detail.CoinDetailScreen
import com.example.cryptocurrency_app_jetpack.presentation.coin_list.CoinListScreen
import com.example.cryptocurrency_app_jetpack.presentation.coin_list.CoinListViewModel
import com.example.cryptocurrency_app_jetpack.presentation.ui.theme.Cryptocurrency_App_JetpackTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Cryptocurrency_App_JetpackTheme {
                val viewMode: CoinListViewModel = hiltViewModel()

                Log.d("MYTAG", viewMode.state.value.coins.toString())
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = Screen.CoinListScreen.route) {
                        composable(route = Screen.CoinListScreen.route) {
                            CoinListScreen(navController = navController)
                        }
                        composable(route = Screen.CoinDetailScreen.route + "/{coinId}") {
                            CoinDetailScreen()
                        }
                    }

                }
            }
        }
    }
}

