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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.fiap.challengelw.R
import br.com.fiap.challengelw.challengelw.components.Header
import br.com.fiap.challengelw.database.repository.CadastroRepository
import br.com.fiap.challengelw.model.Cadastro
import retrofit2.http.Header

@Composable
fun CadastroScreen(navController: NavController) {
    val context = LocalContext.current
    val cadastroRepository = CadastroRepository(context)

    var login by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var loginConfirm by remember { mutableStateOf("") }
    var senhaConfirm by remember { mutableStateOf("") }

    var loginError by remember { mutableStateOf("") }
    var senhaError by remember { mutableStateOf("") }

    fun validarLogin() {
        loginError =
            if (login == loginConfirm) "" else "Os emails ou números de telefone não são iguais."
    }

    fun validarSenha() {
        senhaError = when {
            senha != senhaConfirm -> "As senhas não são iguais."
            !senha.contains(Regex("[A-Za-z]")) || !senha.contains(Regex("[0-9]")) || !senha.contains(
                Regex("[^A-Za-z0-9]")
            ) ->
                "A senha deve conter letras, números e um caractere especial."

            else -> ""
        }
    }

    fun limparCampos() {
        login = ""
        senha = ""
        loginConfirm = ""
        senhaConfirm = ""
    }

    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .background(colorResource(id = R.color.dark_blue_lw))
            .fillMaxHeight()
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 28.dp)
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
        }

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Cadastro",
            color = colorResource(id = R.color.white_lw),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = login,
            onValueChange = {
                login = it
                validarLogin()
            },
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
            modifier = Modifier
                .fillMaxWidth(0.8f),
            isError = loginError.isNotEmpty()
        )
        if (loginError.isNotEmpty()) {
            Text(
                text = loginError,
                color = colorResource(id = R.color.red_lw),
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = loginConfirm,
            onValueChange = {
                loginConfirm = it
                validarLogin()
            },
            label = {
                Text(
                    text = "Confirme seu email ou número de telefone",
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
            modifier = Modifier
                .fillMaxWidth(0.8f),
            isError = loginError.isNotEmpty()
        )
        if (loginError.isNotEmpty()) {
            Text(
                text = loginError,
                color = colorResource(id = R.color.red_lw),
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = senha,
            onValueChange = {
                senha = it
                validarSenha()
            },
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
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .fillMaxWidth(0.8f),
            isError = senhaError.isNotEmpty()
        )
        if (senhaError.isNotEmpty()) {
            Text(
                text = senhaError,
                color = colorResource(id = R.color.red_lw),
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        OutlinedTextField(
            value = senhaConfirm,
            onValueChange = {
                senhaConfirm = it
                validarSenha()
            },
            label = {
                Text(
                    text = "Confirme sua senha",
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
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .fillMaxWidth(0.8f),
            isError = senhaError.isNotEmpty()
        )
        if (senhaError.isNotEmpty()) {
            Text(
                text = senhaError,
                color = colorResource(id = R.color.red_lw),
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
                val cadastroObject = Cadastro(
                    login = login,
                    senha = senha,
                )

                val responseCadastro = cadastroRepository.salvar(cadastroObject)

                if (responseCadastro != null) {
                    Log.d("Entrou", "Validação deu certo")
                    Log.d("Resposta Cadastro", "Cadastro válido. ID do usuário: $responseCadastro")
                    limparCampos()
                    navController.navigate("login")
                } else {
                    Log.d("Quebrou", "Cadastro deu errado")
                }
            },
            colors = ButtonDefaults.buttonColors(colorResource(id = R.color.red_lw)),
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .width(234.dp),
            enabled = loginError.isEmpty() && senhaError.isEmpty() && login.isNotEmpty() && senha.isNotEmpty() && loginConfirm.isNotEmpty() && senhaConfirm.isNotEmpty()
        ) {
            Text(
                text = "Cadastrar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = colorResource(id = R.color.white_lw),
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 5.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        ClickableText(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = colorResource(id = R.color.white_lw))) {
                    append("Já tem uma conta? ")
                    withStyle(
                        style = SpanStyle(
                            color = colorResource(id = R.color.white_lw),
                            textDecoration = TextDecoration.Underline,
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("Clique aqui ")
                    }
                    append("e faça login.")
                }
            },
            onClick = {
                navController.navigate("login")
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
