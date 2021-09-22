package com.example.demorecyclerviewmutipleviewtype.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demorecyclerviewmutipleviewtype.R
import com.example.demorecyclerviewmutipleviewtype.adapter.ItemContactAdapter
import com.example.demorecyclerviewmutipleviewtype.model.RecyclerviewItem
import com.example.demorecyclerviewmutipleviewtype.presenter.ContactPresenter

class ContactsFragment : Fragment(),IContactView {
    private val contactPresenter = ContactPresenter(this)
    private lateinit var rcvContact : RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contacts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initAction()
    }

    private fun initView(view: View) {
        rcvContact = view.findViewById(R.id.rcvContact)
    }

    private fun initAction() {
        val itemContactAdapter = ItemContactAdapter()
        itemContactAdapter.itemViewOnClickListener = {
            contactPresenter.clickContact(it)
        }
        itemContactAdapter.items = contactPresenter.getContact() as ArrayList<RecyclerviewItem>
        rcvContact.adapter = itemContactAdapter
        rcvContact.layoutManager = LinearLayoutManager(context)
        rcvContact.setHasFixedSize(true)
    }

    override fun getContactsRefresh(news: List<RecyclerviewItem>) {
        (rcvContact.adapter as ItemContactAdapter).setData(news)
    }
}