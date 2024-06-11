package br.com.fiap.challengelw.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.challengelw.model.Cadastro

@Dao
interface CadastroDao {
    @Insert
    fun salvar(cadastro: Cadastro): Long?

    @Delete
    fun excluir(cadastro: Cadastro): Int

    @Update
    fun atualizar(cadastro: Cadastro): Int

    @Query("SELECT * FROM tbl_cadastro WHERE id = :id")
    fun buscarCadastroPeloId(id: Int): Cadastro

    @Query("SELECT * FROM tbl_cadastro ORDER BY login ASC")
    fun listarCadastros(): List<Cadastro>

    @Query("SELECT id FROM tbl_cadastro WHERE login = :login AND senha = :senha LIMIT 1")
    fun validarAcesso(login: String, senha: String): Int?
}