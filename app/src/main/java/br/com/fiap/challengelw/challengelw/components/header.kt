package br.com.fiap.challengelw.challengelw.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Header(
    onMenuClicked: () -> Unit,
    onNotificationsClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 0.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Logo
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = br.com.fiap.challengelw.R.drawable.logo_lw),
                contentDescription = "Green Cycle",
                modifier = Modifier
                    .size(112.dp)
                    .clickable { /* Ação ao clicar na logo */ }
                    .padding(start = 16.dp)
            )
        }

        // Ícones à direita
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Ícone do menu hamburguer
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .clickable(onClick = onMenuClicked)
            )

            // Ícone de notificações
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notificações",
                tint = Color.White,
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 16.dp)
                    .clickable(onClick = onNotificationsClicked)
            )
        }
    }
}

//@Preview
//@Composable
//fun PreviewHeader() {
//    Header(
//        onMenuClicked = {},
//        onNotificationsClicked = {}
//    )
//}
