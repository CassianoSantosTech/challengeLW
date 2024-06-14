package br.com.fiap.challengelw.challengelw.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import br.com.fiap.challengelw.R
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailAppBar() {
    TopAppBar(
        title = {
            TextField(
                value = TextFieldValue(""),
                onValueChange = {},
                placeholder = { Text("Search") },
                modifier = Modifier.fillMaxWidth()
            )
        },
        navigationIcon = {
            IconButton(onClick = { /* Open drawer */ }) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_menu_24), contentDescription = "Menu")
            }
        },
        actions = {
            IconButton(onClick = { /* Open profile */ }) {
                val painter = rememberImagePainter(
                    data = "https://via.placeholder.com/150",
                    builder = {
                        transformations(CircleCropTransformation())
                    }
                )
                Image(
                    painter = painter,
                    contentDescription = "User Profile",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }
        }
    )
}