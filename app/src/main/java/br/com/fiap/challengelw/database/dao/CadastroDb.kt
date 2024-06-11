package br.com.fiap.challengelw.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.challengelw.model.Cadastro

@Database(entities = [Cadastro::class], version = 1)
abstract class CadastroDb: RoomDatabase() {
    abstract fun cadastroDao(): CadastroDao

    companion object {

        private lateinit var instance: CadastroDb

        fun getCadastroDatabase(context: Context): CadastroDb {
            if (!::instance.isInitialized) {
                instance = Room
                    .databaseBuilder(
                        context,
                        CadastroDb::class.java,
                        "cadastro_db"
                    )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}