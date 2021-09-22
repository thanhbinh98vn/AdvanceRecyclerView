package com.example.demorecyclerviewmutipleviewtype.util

import androidx.recyclerview.widget.DiffUtil
import com.example.demorecyclerviewmutipleviewtype.model.Contact
import com.example.demorecyclerviewmutipleviewtype.model.RecyclerviewItem
import com.example.demorecyclerviewmutipleviewtype.model.Title

class ContactDiffUtils(
    private val oldData: List<RecyclerviewItem>,
    private val newData: List<RecyclerviewItem>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldData.size

    override fun getNewListSize() = newData.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldData[oldItemPosition]
        val newItem = newData[newItemPosition]

        return when (oldItem) {
            is Contact -> oldItem.phoneNumber == (newItem as Contact).phoneNumber
            is Title -> true
            else -> true
        }
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldData[oldItemPosition]
        val newItem = newData[newItemPosition]

        return when (oldItem) {
            is Contact -> oldItem.chosen == (newItem as Contact).chosen
            is Title -> true
            else -> true
        }
    }
}