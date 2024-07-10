import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.StockRepository
import com.example.myapplication.StockViewModel
import com.example.myapplication.StockViewModelFactory


/*
@Composable
fun StockScreen(stockViewModel: StockViewModel = viewModel(factory = StockViewModelFactory(
    StockRepository()
))) {
    val stockList by stockViewModel.stockFlow.collectAsState()
*/

/*
@Composable
fun StockScreen() {
    val context = LocalContext.current
    val stockViewModel: StockViewModel = viewModel(factory = StockViewModelFactory(context))
    val stockList by stockViewModel.stockFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        stockList.forEach { stock ->
            Text(
                text = "${stock.name}: $${String.format("%.2f", stock.price)}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStockScreen() {
    StockScreen()
}
*/


@Composable
fun stockScreen(){

}
