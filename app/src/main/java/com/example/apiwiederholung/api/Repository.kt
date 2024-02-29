package com.example.apiwiederholung.api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiwiederholung.api.model.Quote

class Repository {

    private val _quote = MutableLiveData<Quote>()
    val quote: LiveData<Quote>
        get() = _quote

    suspend fun getRandomQuote(){

        val randomQuote = api.service.getRandomQuote().first()
        _quote.value = randomQuote

    }


}