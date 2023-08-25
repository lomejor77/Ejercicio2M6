package cl.awakelabs.ejercicio2m6.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import cl.awakelabs.ejercicio2.databinding.ItemBinding
import cl.awakelabs.ejercicio2m6.data.local.Item

class ItemAdapter: RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    lateinit var binding: ItemBinding
    private val listItem = mutableListOf<Item>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        binding = ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemAdapter.ItemViewHolder, position: Int) {
        val item = listItem[position]
        holder.render(item)
    }

    fun setData(item: List<Item>) {
        this.listItem.clear()
        this.listItem.addAll(item)
        notifyDataSetChanged()
    }

    class ItemViewHolder(val view: ItemBinding): RecyclerView.ViewHolder(view.root) {
        fun render(item: Item){
            view.viewItem.text = item.name
            view.viewPrice.text = item.price.toString()
            view.viewQty.text = item.qty.toString()

            view.viewTotal.text = (item.price * item.qty).toString()

        }
    }
}