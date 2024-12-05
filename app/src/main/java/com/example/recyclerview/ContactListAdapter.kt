package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

// Adptar entre data class e o item_list layout
class ContactListAdapter : ListAdapter<Contact, ContactListAdapter.ContactViewHolder>(ContactDiffUtils()) {

    // criar um view holder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return  ContactViewHolder(view)
    }

    // bind - atrelar o dado com a UI views
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    // view holder = view que segura os dados
    class ContactViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val nameC = view.findViewById<TextView>(R.id.nameContact)
        private val phoneC = view.findViewById<TextView>(R.id.numberContact)
        private val imageC = view.findViewById<ImageView>(R.id.imageContact)


        fun bind(contact: Contact) {
            nameC.text = contact.name
            phoneC.text = contact.contact
            imageC.setImageResource(contact.icon)
        }

    }

    // compara a diferenca qunado a lista é atualizada (ex: passa de 10 a 11, ajuda com o management de mesmoria etc)
    class ContactDiffUtils: DiffUtil.ItemCallback<Contact>() {

        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            // TODO("Not yet implemented")
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
           //  TODO("Not yet implemented")
            return oldItem.name == newItem.name

        }

    }


}