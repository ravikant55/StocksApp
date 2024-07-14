package com.example.myapplication

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.random.Random

class StocksViewModel(repository: StocksRepository) : ViewModel() {

    private val _stockFlow = MutableStateFlow(repository.getStocks())
    val stockFlow: StateFlow<List<Stock>> get() = _stockFlow

    init {
        viewModelScope.launch {
                while (true) {
                val stocks = _stockFlow.value.toMutableList()
                stocks.forEachIndexed { index, stock ->
                    val newPrice = stock.price * (1 + (0.01 * Random.nextInt(-5, 6)))
                    stocks[index] = stock.copy(price = newPrice)

                    /*Update one stock at a time*/
//                    _stockFlow.value = stocks.toList() // Update the flow
//                    delay(2500)
                }
                /*Update all stock at a time*/
                _stockFlow.value = stocks.toList() // Update the flow
                delay(2500)
            }
        }
    }
}

/*
@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StocksViewModel::class.java)) {
            return StocksViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}*/


/*for json*/

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StocksViewModel::class.java)) {
            val repository = StocksRepository(context)  //added for json
            return StocksViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



