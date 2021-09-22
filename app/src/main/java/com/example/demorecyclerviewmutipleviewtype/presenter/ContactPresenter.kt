package com.example.demorecyclerviewmutipleviewtype.presenter

import com.example.demorecyclerviewmutipleviewtype.model.Contact
import com.example.demorecyclerviewmutipleviewtype.model.RecyclerviewItem
import com.example.demorecyclerviewmutipleviewtype.repository.ContactRepository
import com.example.demorecyclerviewmutipleviewtype.view.fragment.IContactView

class ContactPresenter(private val view: IContactView): IContactPresenter {
    private val contacts = ContactRepository().getData()

    override fun getContact(): List<RecyclerviewItem> {
        return contacts
    }

    override fun clickContact(position: Int) {

        ArrayList(contacts).also{ newContacts ->
            newContacts.mapIndexed { index, recyclerviewItem ->
                if(recyclerviewItem is Contact && index == position){
                    newContacts[index] = recyclerviewItem.copy(chosen = !recyclerviewItem.chosen)
                }
            }
            view.getContactsRefresh(newContacts)
        }
    }
}