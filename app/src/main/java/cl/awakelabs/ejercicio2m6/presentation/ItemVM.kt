package cl.awakelabs.ejercicio2m6.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import cl.awakelabs.ejercicio2m6.Repository
import cl.awakelabs.ejercicio2m6.data.local.Item
import cl.awakelabs.ejercicio2m6.data.local.ItemDAO
import cl.awakelabs.ejercicio2m6.data.local.ItemDB
import kotlinx.coroutines.launch

class ItemVM(application: Application) : AndroidViewModel(application) {
    private val repository: Repository

    init {
        val dao = ItemDB.getDatabase(application).getIemsDao()
        repository = Repository(dao)
    }
    fun getAllItems(): LiveData<List<Item>> = repository.getItems()
    fun insertItems(name: String, price: Int, qty: Int) = viewModelScope.launch {
        val item = Item(name,price,qty)
        repository.insertItem(item)
    }
}