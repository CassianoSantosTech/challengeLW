package br.com.fiap.challengelw.database.repository

import android.content.Context
import br.com.fiap.challengelw.database.dao.CadastroDb
import br.com.fiap.challengelw.model.Cadastro

class CadastroRepository(context: Context) {
    private val db = CadastroDb.getCadastroDatabase(context).cadastroDao()

    fun salvar(cadastro: Cadastro): Long? {
        return db.salvar(cadastro)
    }

    fun atualizar(cadastro: Cadastro): Int {
        return db.atualizar(cadastro)
    }

    fun excluir(cadastro: Cadastro): Int {
        return db.excluir(cadastro)
    }

    fun listarCadastros(): List<Cadastro> {
        return db.listarCadastros()
    }

    fun buscarCadastroPeloId(id: Int): Cadastro {
        return db.buscarCadastroPeloId(id)
    }

    fun validarAcesso(email: String, senha: String): Int? {
        return db.validarAcesso(email, senha)
    }
}