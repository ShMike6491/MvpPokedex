package my.mvppokemon.repository.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PokemonEntity::class], version = 1, exportSchema = false)
abstract class DataBase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDAO

    companion object {
        private const val DATABASE_NAME = "local_db"

        @Volatile
        private var INSTANCE: DataBase? = null;

        fun getDatabase(context: Context): DataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(context, DataBase::class.java, DATABASE_NAME)
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}