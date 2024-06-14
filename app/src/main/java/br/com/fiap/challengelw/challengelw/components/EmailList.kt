package br.com.fiap.challengelw.challengelw.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController

@Composable
fun EmailList(navController: NavHostController, modifier: Modifier = Modifier) {
    val emails = remember {
        listOf(
            Email("Alice", "Hello!", "This is a test email from Alice."),
            Email("Bob", "Meeting", "Don't forget our meeting tomorrow."),
            Email("Charlie", "Lunch?", "Would you like to have lunch together?")
        )
    }

    LazyColumn(modifier = modifier) {
        items(emails) { email ->
            EmailItem(email, onClick = { navController.navigate("viewEmail") })
        }
    }
}