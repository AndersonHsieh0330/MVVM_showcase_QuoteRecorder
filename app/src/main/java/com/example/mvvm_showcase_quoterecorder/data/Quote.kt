package com.example.mvvm_showcase_quoterecorder.data

class Quote(val quoteText:String , val author:String) {


    override fun toString(): String {
        return "$quoteText - $author"
    }
}