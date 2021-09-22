package com.example.demorecyclerviewmutipleviewtype.presenter

import com.example.demorecyclerviewmutipleviewtype.model.RecyclerviewItem

interface IContactPresenter {
    fun getContact(): List<RecyclerviewItem>
    fun clickContact(position: Int)
}