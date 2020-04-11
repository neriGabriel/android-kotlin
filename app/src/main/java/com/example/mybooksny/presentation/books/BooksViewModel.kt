package com.example.mybooksny.presentation.books

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.mybooksny.data.ApiService
import com.example.mybooksny.data.model.Book
import com.example.mybooksny.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData();

    fun getBooks() {
        ApiService.service.getBooks().enqueue(object : Callback<BookBodyResponse> {
            override fun onResponse(call: Call<BookBodyResponse>, response: Response<BookBodyResponse>) {
                if (response.isSuccessful) {
                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->
                        for (result in bookBodyResponse.bookResults) {
                            val book = Book(
                                    title = result.bookDetailResponses[0].title,
                                    author = result.bookDetailResponses[0].author,
                                    description = result.bookDetailResponses[0].description
                            )

                            books.add(book);
                        }
                    }

                    booksLiveData.value = books;
                }
            }

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }
        });
    }
}