package com.example.mvvm_showcase_quoterecorder.utilities

import com.example.mvvm_showcase_quoterecorder.data.FakeDatabase
import com.example.mvvm_showcase_quoterecorder.data.QuoteRepository
import com.example.mvvm_showcase_quoterecorder.ui.quotes.QuotesViewModelFactory

//no parameters needed to be passed into this constructor thus we use "object" keyword
object InjectorUtils {
    //use for dependency injection and provide dummy data for testing

    fun provideQuotesViewModelFactory():QuotesViewModelFactory{
        val quoteRepo = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepo)
    }

}