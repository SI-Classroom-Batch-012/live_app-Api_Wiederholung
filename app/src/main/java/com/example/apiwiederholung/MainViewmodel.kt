package com.example.apiwiederholung

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.apiwiederholung.api.Repository
import kotlinx.coroutines.launch

class MainViewmodel: ViewModel() {


    val repository = Repository()


    val randomQuote = repository.quote

    fun getRandomQuote(){

        viewModelScope.launch {
            repository.getRandomQuote()
        }

    }

}