package com.example.mvvm_showcase_quoterecorder.data

//using "object" keyword in kotlin disallow object to have constructor
//thus we use "class" keyword and make the singleton pattern
class FakeDatabase private constructor() {
    //in production apps this should be a real database like firebase realtime, sqlite, etc.
    //database is a container for all the DAOs


    var quoteDao = FakeQuoteDao()
    companion object{
        @Volatile
        private var instance: FakeDatabase? = null

//different syntax with higher order functions
//        fun getInstance() =
//            instance ?: synchronized(this){
//                instance ?: FakeDatabase().also { instance = it }
//            }

        fun getInstance() = instance ?: FakeDatabase()

    }
}