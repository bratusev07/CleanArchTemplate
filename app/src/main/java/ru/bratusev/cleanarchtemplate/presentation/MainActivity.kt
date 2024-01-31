package ru.bratusev.cleanarchtemplate.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.bratusev.cleanarchtemplate.R

class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataTextView = findViewById<TextView>(R.id.dataTextView)
        val dataEditText = findViewById<EditText>(R.id.dataEditText)
        val loadButton = findViewById<Button>(R.id.loadData)
        val saveButton = findViewById<Button>(R.id.saveData)

        vm.resultLive.observe(this) {
            dataTextView.text = it
        }

        loadButton.setOnClickListener {
            vm.loadData()
        }

        saveButton.setOnClickListener {
            val data = dataEditText.text.toString()
            vm.saveData(data)
        }
    }
}