package br.com.fiap.challengelw.challengelw.screens

import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import br.com.fiap.challengelw.challengelw.components.EmailAppBar
import br.com.fiap.challengelw.challengelw.components.EmailList

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            EmailApp()
//        }
//    }
//}

//@Composable
//fun EmailApp() {
//    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = "inbox") {
//        composable("inbox") { InboxScreen(navController) }
//        composable("viewEmail") { ViewEmailScreen() }
//        composable("composeEmail") { ComposeEmailScreen() }
//    }
//}

@Composable
fun InboxScreen(navController: NavHostController) {
    Scaffold(
        topBar = { EmailAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { navController.navigate("composeEmail") }) {
                Icon(imageVector = ImageVector.vectorResource(id = br.com.fiap.challengelw.R.drawable.ic_baseline_menu_24), contentDescription = "Compose")
            }
        }
    ) { padding ->
        EmailList(navController, Modifier.padding(padding))
    }
}


//@Composable
//fun ViewEmailScreen() {
//    // Implementação da tela de visualização de e-mail
//}
//
//@Composable
//fun ComposeEmailScreen() {
//    // Implementação da tela de composição de e-mail
//}
