package br.com.fiap.listadecompras.itemAdapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.listadecompras.R
import br.com.fiap.listadecompras.model.ItemModel

//um conjunto de classe que vai fazer a ponte dos meus dados e do layout para um RecyclerView
class ItemsAdapter : RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>() {

    private val items = mutableListOf<ItemModel>()

    fun addItem(newItem: ItemModel) {
        items.add(newItem)
        notifyDataSetChanged()
    }

    fun removeItem(item: ItemModel) {
        items.remove(item)
        notifyDataSetChanged()
    }

    //responsável por fazer a visualização
    //ViewGroup é responsável por visualizar o gurpo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //LayountInflater é para pegar os dados e inflair/insert no layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }


    override fun getItemCount(): Int = items.size
    //Bind = pegar um valor e colocar dentro do objeto
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }
    //classe R dá acesso aos recursos
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView = view.findViewById<TextView>(R.id.textViewItem)
        fun bind(item: ItemModel) {
            textView.text = item.name
        }
    }
}

