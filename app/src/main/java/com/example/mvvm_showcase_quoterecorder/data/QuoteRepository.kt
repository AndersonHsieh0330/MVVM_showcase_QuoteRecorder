package com.example.mvvm_showcase_quoterecorder.data

import androidx.lifecycle.LiveData

//singleton pattern
class QuoteRepository private constructor(private val quoteDao: FakeQuoteDao) {

    companion object{
        @Volatile
        private var instance: QuoteRepository? = null


        fun getInstance(quoteDao:FakeQuoteDao) = instance ?: QuoteRepository(quoteDao)
    }

    fun addQuote(quote:Quote){
        quoteDao.addQuote(quote)
    }

    fun getQuote():LiveData<List<Quote>>{
        return quoteDao.getQuotes()
    }
}