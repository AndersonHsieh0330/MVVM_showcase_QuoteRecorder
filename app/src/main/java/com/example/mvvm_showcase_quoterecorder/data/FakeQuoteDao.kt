package com.example.mvvm_showcase_quoterecorder.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    //in production, DAO is an interface defining all allowed action
    //which can happen to a table in a database

    private val quoteList = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>()

    init {
        quotes.value = quoteList
    }

    fun addQuote(quote: Quote){

        //add new quote to the list
        quoteList.add(quote)

        //update MutableLiveData with new list
        //this action will trigger all related observer
        quotes.value = quoteList
    }


    //fun getQuotes() = quotes as LiveData<List<Quote>>
    fun getQuotes():LiveData<List<Quote>>{

        //return "quotes" as LiveData so it can't be modified outside of this DAO
        return quotes
    }
}