package com.example.myapplication

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

/*
class StocksRepository {
    private val stocks = listOf(
        Stock("Apple", 150.00),
        Stock("Google", 200.00),
        Stock("Meta", 300.00)
    )

    fun getStocks(): List<Stock> {
        return stocks
    }
}
*/


class StocksRepository(private val context: Context) {
    fun getStocks(): List<Stock> {
        val inputStream = context.assets.open("stocks.json")
        val reader = InputStreamReader(inputStream)
        val stockListType = object : TypeToken<List<Stock>>() {}.type
        return Gson().fromJson(reader, stockListType)
       }
}

// Open the JSON file from the assets folder
// Create a reader for the InputStream
// Define the type for the list of stocks
// Use Gson to parse the JSON data into a list of Stock objects