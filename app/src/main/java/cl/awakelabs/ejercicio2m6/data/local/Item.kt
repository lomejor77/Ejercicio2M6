package cl.awakelabs.ejercicio2m6.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_items")
data class Item(val name: String, val price: Int, val qty: Int){
    @PrimaryKey(autoGenerate = true) var id: Long = 0
}