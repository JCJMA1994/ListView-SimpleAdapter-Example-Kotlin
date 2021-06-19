package com.example.listviewsimpleadapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import android.widget.Toast
import kotlin.collections.HashMap

class MainActivity : AppCompatActivity() {

    private val titleArray = arrayOf("Name", "Sex", "Age", "Location", "Email")
    private val descArray = arrayOf("Jerry", "Male", "43", "Singapore", "webmaster@dev2qa.com")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.simpleAdapterListView()
    }

    private fun simpleAdapterListView() {

        val dataListArray = ArrayList<HashMap<String, Any>>()
        val length = titleArray.size

        for (i in 0 until length){
            val item = HashMap<String, Any>()
            item["title"] = titleArray[i]
            item["description"] = descArray[i]

            dataListArray.add(item)
        }
        val listViewExample = findViewById<ListView>(R.id.listViewExample)

        val simpleAdapter = SimpleAdapter(this, dataListArray, android.R.layout.simple_list_item_2,
            arrayOf("title", "description"), intArrayOf(android.R.id.text1,android.R.id.text2))
        listViewExample.adapter = simpleAdapter

        listViewExample.setOnItemClickListener {
                parent, _, position, _ ->
            Toast.makeText(this, "You chose " + parent.getItemAtPosition(position).toString(),Toast.LENGTH_SHORT).show()
        }
    }

}