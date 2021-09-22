package com.example.demorecyclerviewmutipleviewtype.repository

import com.example.demorecyclerviewmutipleviewtype.model.Contact
import com.example.demorecyclerviewmutipleviewtype.model.Title

class ContactRepository {

    fun getData() = arrayListOf(
        Title("A"),
        Contact("Nguyen Van A", "1234566789"),
        Title("B"),
        Contact("Nguyen Van B", "1234566789"),
        Contact("Le Van B", "1234566789"),
        Title("C"),
        Contact("Nguyen Van C", "1234566789"),
        Contact("Le Van C", "1234566789"),
        Contact("Pham Van C", "1234566789"),
        Title("D"),
        Contact("Nguyen Van D", "1234566789"),
        Contact("Le Van D", "1234566789"),
        Contact("Pham Van D", "1234566789"),
        Contact("Do Van D", "1234566789"),
    )
}