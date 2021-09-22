package com.example.demorecyclerviewmutipleviewtype.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerviewmutipleviewtype.R
import com.example.demorecyclerviewmutipleviewtype.model.Contact
import com.example.demorecyclerviewmutipleviewtype.model.RecyclerviewItem
import com.example.demorecyclerviewmutipleviewtype.model.Title
import com.example.demorecyclerviewmutipleviewtype.util.AnimationUtil
import com.example.demorecyclerviewmutipleviewtype.util.ContactDiffUtils

class ItemContactAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val CONTACT_ITEM = 1
        const val TITLE_ITEM = 2
    }
    var items: ArrayList<RecyclerviewItem> = arrayListOf()
    var itemViewOnClickListener: ((Int) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        return if (items[position] is Contact)
            CONTACT_ITEM
        else
            TITLE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            CONTACT_ITEM -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_contact,parent,false)
                ContactViewHolder(itemView, itemViewOnClickListener)
            }
            TITLE_ITEM -> {
                val itemView = LayoutInflater.from(parent.context).inflate(R.layout.adapter_item_contact_title,parent,false)
                TitleViewHolder(itemView)
            }
            else -> {
                throw Exception("Unexpected view type")
            }
        }
    }

    class ContactViewHolder(itemView: View, itemViewOnClickListener: ((Int) -> Unit)?= null) :
        RecyclerView.ViewHolder(itemView) {
        private val cvContact:CardView = itemView.findViewById(R.id.cvContact)
        private val tvName: TextView = itemView.findViewById(R.id.tvName)
        private val tvPhone: TextView = itemView.findViewById(R.id.tvPhone)
        private val clExtra: ConstraintLayout = itemView.findViewById(R.id.clExtra)

        init {
            cvContact.setOnClickListener {
                itemViewOnClickListener?.invoke(adapterPosition)
            }
        }

        fun bind(contact: Contact){
            tvName.text = contact.name
            if(contact.chosen){
                tvPhone.text = contact.phoneNumber
                AnimationUtil.expand(clExtra)
            }else{
                clExtra.visibility = View.GONE
            }
        }
    }

    class TitleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        fun bind(title: Title){
            tvTitle.text = title.titleName
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ContactViewHolder -> {
                holder.bind(items[position] as Contact)
            }
            is TitleViewHolder -> {
                holder.bind(items[position] as Title)
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setData(newData: List<RecyclerviewItem>) {
        val diffResult = DiffUtil.calculateDiff(
            ContactDiffUtils(
                items.toList(),
                newData
            )
        )
        diffResult.dispatchUpdatesTo(this)
        items.clear()
        items.addAll(newData)
    }
}