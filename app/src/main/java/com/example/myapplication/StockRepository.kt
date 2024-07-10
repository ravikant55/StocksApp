package com.example.myapplication

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.InputStreamReader

/*
class StockRepository {

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


class StockRepository(private val context: Context) {

    fun getStocks(): List<Stock> {
        // Open the JSON file from the assets folder
        val inputStream = context.assets.open("stocks.json")
        // Create a reader for the InputStream
        val reader = InputStreamReader(inputStream)
        // Define the type for the list of stocks
        val stockListType = object : TypeToken<List<Stock>>() {}.type
        // Use Gson to parse the JSON data into a list of Stock objects
        return Gson().fromJson(reader, stockListType)
    }
}