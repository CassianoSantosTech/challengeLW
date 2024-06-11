package br.com.fiap.challengelw.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_cadastro")
data class Cadastro(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    var login: String = "",
    var senha: String = "",
//    var nome: String = "",
//    var cnpj: String = "",
//    var telefone: String = "",
//    var cep: String = "",
//    var cidade: String = "",
//    var uf: String = "",
//    var bairro: String = "",
//    var rua: String = "",
//    var numeroEndereco: Int = 0,
//    var complemento: String = ""
)