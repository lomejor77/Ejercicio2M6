package cl.awakelabs.ejercicio2m6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Item::class], version = 1)
abstract class ItemDB : RoomDatabase() {
    abstract fun getIemsDao(): ItemDAO

    companion object {
        @Volatile
        private var INSTANCE: ItemDB? = null

        fun getDatabase(context: Context): ItemDB {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDB::class.java,
                    "item_database"
                ).build()

                INSTANCE = instance
                return instance

            }
        }
    }


}

