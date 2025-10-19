package com.cashdemo.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cashdemo.app.ui.screens.LoginScreen
import com.cashdemo.app.ui.screens.HomeScreen
import com.cashdemo.app.ui.screens.SendMoneyScreen
import com.cashdemo.app.ui.screens.TransactionHistoryScreen
import com.cashdemo.app.ui.theme.CashDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CashDemoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "login"
                    ) {
                        composable("login") {
                            LoginScreen(navController)
                        }
                        composable("home") {
                            HomeScreen(navController)
                        }
                        composable("send_money") {
                            SendMoneyScreen(navController)
                        }
                        composable("transaction_history") {
                            TransactionHistoryScreen(navController)
                        }
                    }
                }
            }
        }
    }
}

