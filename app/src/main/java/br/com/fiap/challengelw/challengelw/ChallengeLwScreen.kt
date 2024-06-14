package br.com.fiap.challengelw.challengelw

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.fiap.challengelw.challengelw.screens.CadastroScreen
import br.com.fiap.challengelw.challengelw.screens.InboxScreen
import br.com.fiap.challengelw.challengelw.screens.LoginScreen

@Composable
fun ChallengeLwScreen() {
    val navController = rememberNavController();
    NavHost(navController = navController, startDestination = "cadastro" ) {
        composable(route = "cadastro") { CadastroScreen(navController) }
        composable(route = "login") { LoginScreen(navController) }
        composable(route = "inboxEmail") {
//            val id = it.arguments?.getInt("id")
            InboxScreen(navController)
        }
    }
}
