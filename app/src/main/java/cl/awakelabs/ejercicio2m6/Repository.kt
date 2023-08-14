package cl.awakelabs.ejercicio2m6

import androidx.lifecycle.LiveData
import cl.awakelabs.ejercicio2m6.data.local.Item
import cl.awakelabs.ejercicio2m6.data.local.ItemDAO

class Repository(private val itemDAO: ItemDAO) {
    suspend fun insertItem(item: Item) {
        itemDAO.insertItem(item)
    }

    fun getItems(): LiveData<List<Item>>{
        return itemDAO.getAllItems()
    }
}