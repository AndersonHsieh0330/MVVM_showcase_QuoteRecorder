package com.example.mvvm_showcase_quoterecorder.ui.quotes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_showcase_quoterecorder.data.QuoteRepository

class QuotesViewModelFactory(private val quoteRepo:QuoteRepository):ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return QuotesViewModel(quoteRepo) as T
    }
}