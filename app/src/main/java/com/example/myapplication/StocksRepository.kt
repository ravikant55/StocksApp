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

/*
* 	1.	TypeToken<List>(): This creates an anonymous subclass of TypeToken which represents a generic type. In this case, the type is List<Stock>. Stock is presumably a data class or a model class that represents a stock item.
	2.	object : TypeToken<List>() {}: This is an anonymous object expression that creates an instance of the TypeToken<List<Stock>> subclass.
	3.	type: The type property of TypeToken is used to get the Type instance that represents the generic type List<Stock>.
	4.	val stockListType: This declares a read-only variable stockListType that holds the Type object for List<Stock>.
* */

















