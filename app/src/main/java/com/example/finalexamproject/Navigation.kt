package com.example.finalexam.Navigate

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.finalexam.screen.HomeScreen
import com.example.finalexam.screen.OrderDetailScreen
import com.example.finalexam.screen.OrdersScreen
import com.example.finalexam.screen.ProfileScreen
import com.example.finalexamproject.LoginScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(navController = navController)
        }
        composable("home") {
            HomeScreen(navController = navController)
        }
        composable("orders") {
            OrdersScreen(navController = navController)
        }
        composable(
            route = "orderDetail/{orderId}",
            arguments = listOf(navArgument("orderId") { type = NavType.IntType })
        ) {
            val orderId = it.arguments?.getInt("orderId") ?: 1
            OrderDetailScreen(orderId = orderId, navController = navController)
        }
        composable("profile") {
            ProfileScreen(navController = navController)
        }
    }
}