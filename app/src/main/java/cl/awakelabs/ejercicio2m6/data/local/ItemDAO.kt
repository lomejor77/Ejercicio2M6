package cl.awakelabs.ejercicio2m6.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDAO {
    @Insert
    suspend fun insertItem(item: Item)
    @Query("SELECT * FROM tbl_items ORDER BY id ASC")
    fun getAllItems(): LiveData<List<Item>>

}