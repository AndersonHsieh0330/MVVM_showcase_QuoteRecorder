package com.example.mvvm_showcase_quoterecorder.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_showcase_quoterecorder.R
import com.example.mvvm_showcase_quoterecorder.data.Quote
import com.example.mvvm_showcase_quoterecorder.databinding.ActivityQuotesBinding
import com.example.mvvm_showcase_quoterecorder.utilities.InjectorUtils
import org.w3c.dom.Text
import java.lang.StringBuilder

class QuotesActivity : AppCompatActivity() {

    private lateinit var binding:ActivityQuotesBinding

    //view elements
    private lateinit var quoteEditText:EditText
    private lateinit var authorEditText: EditText
    private lateinit var addQuoteBTN:Button
    private lateinit var quoteText:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
        //instantiate element
        quoteEditText = binding.editTextQuote
        authorEditText = binding.editTextAuthor
        addQuoteBTN = binding.buttonAddQuote
        quoteText = binding.textViewQuotes

        val factory = InjectorUtils.provideQuotesViewModelFactory()
        val viewModel = ViewModelProvider(this, factory)[QuotesViewModel::class.java]


        viewModel.getQuotes().observe(this, Observer {
            quotes -> val stringBuilder = StringBuilder()
            quotes.forEach{quote ->
                stringBuilder.append("$quote\n\n")
            }
            quoteText.text = stringBuilder.toString()
        })

        addQuoteBTN.setOnClickListener(View.OnClickListener {
            val quote = Quote(quoteEditText.text.toString(),authorEditText.text.toString())
            viewModel.addQuotes(quote)
            quoteEditText.setText("")
            authorEditText.setText("")
        })
    }
}