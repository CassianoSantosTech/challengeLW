package br.com.fiap.challengelw.challengelw.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challengelw.R
import br.com.fiap.challengelw.challengelw.components.Header
import br.com.fiap.challengelw.database.repository.CadastroRepository

@Composable
fun LoginScreen(navController: NavController) {
    val context = LocalContext.current
    val cadastroRepository = CadastroRepository(context)

    var login by remember() {
        mutableStateOf("")
    }

    var senha by remember() {
        mutableStateOf("")
    }

    var senhaVisible by remember {
        mutableStateOf(false)
    }


    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.dark_blue_lw))
            .fillMaxHeight()
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_lw),
            contentDescription = "Green Cycle",
            alignment = Alignment.Center,
            modifier = Modifier
                .width(296.dp)
                .height(108.dp)
                .clickable { /* Ação ao clicar na logo */ }
        )

        Spacer(modifier = Modifier.height(30.dp))

        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = {
                Text(
                    text = "Digite seu email ou número de telefone",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white_lw),
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(id = R.color.white_lw),
                focusedBorderColor = colorResource(id = R.color.white_lw),
                focusedTextColor = colorResource(id = R.color.white_lw),
                unfocusedTextColor = colorResource(id = R.color.white_lw),
            ),
            shape = RoundedCornerShape(20),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = { senha = it },
            label = {
                Text(
                    text = "Digite sua senha",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(id = R.color.white_lw),
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = colorResource(id = R.color.white_lw),
                focusedBorderColor = colorResource(id = R.color.white_lw),
                focusedTextColor = colorResource(id = R.color.white_lw),
                unfocusedTextColor = colorResource(id = R.color.white_lw),
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (senhaVisible) VisualTransformation.None else PasswordVisualTransformation(),
            trailingIcon = {
                val image = if (senhaVisible) Icons.Filled.Check else Icons.Filled.CheckCircle
                IconButton(onClick = { senhaVisible = !senhaVisible }) {
                    Icon(imageVector = image, contentDescription = null)
                }
            },            shape = RoundedCornerShape(20),
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                val responseAcesso = cadastroRepository.validarAcesso(login, senha)
                if (responseAcesso != null && responseAcesso != 0) {
                    Log.d("Entrou", "Validacao deu certo")
                    Log.d("Resposta Acesso", "Usuário válido. ID do usuário: $responseAcesso")
//                    navController.navigate("menu/$responseAcesso")
                } else {
                    Log.d("Quebrou", "Validacao deu errado")
                }
            },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.red_lw)),
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .width(234.dp),
        ) {
            Text(
                text = "Entrar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white_lw),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 3.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        ClickableText(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = colorResource(id = R.color.white_lw))) {
                    append("Não tem uma conta? ")
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.white_lw),
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Clique aqui ")
                    }
                    append("e faça seu cadastro.")
                }
            },
            onClick = {
                navController.navigate("cadastro")
            },
            modifier = Modifier.width(224.dp),
            style = TextStyle(
                fontSize = 16.sp,
                color = colorResource(id = R.color.white_lw),
                textAlign = TextAlign.Center
            )
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}