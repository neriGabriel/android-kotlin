package com.example.mybooksny.presentation.books

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.mybooksny.data.model.Book

class BooksViewModel: ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData();

    fun getBooks() {
        booksLiveData.value = createFakeBooks();
    }

    fun createFakeBooks(): List<Book> {
        return listOf(
            Book("Title", "Author 1"),
            Book("Title 2", "Author 2"),
            Book("Title 3", "Author 3"),
            Book("Title 4", "Author 4"),
            Book("Title 5", "Author 5")
        )
    }
}