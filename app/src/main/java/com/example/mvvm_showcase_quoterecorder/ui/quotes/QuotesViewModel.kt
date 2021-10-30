package com.example.mvvm_showcase_quoterecorder.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.mvvm_showcase_quoterecorder.data.Quote
import com.example.mvvm_showcase_quoterecorder.data.QuoteRepository


class QuotesViewModel(private val quoteRepo:QuoteRepository):ViewModel() {
    //all the data are kept here in the view model class
    //so if screen is rotated and activity is recreated in MainActivity, no data is changed
    //Note: ViewModel is created by ViewModelProvider, which takes cares of lifecycle events for us

    fun getQuotes() = quoteRepo.getQuote()

    fun addQuotes(quote: Quote) = quoteRepo.addQuote(quote)

}