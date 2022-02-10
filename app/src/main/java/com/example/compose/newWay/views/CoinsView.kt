package com.example.compose.newWay.views

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.common.data.MockCoinList
import com.example.compose.common.model.Coin
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun Coins(
    coins: List<Coin>,
    changeIsCheckedAction: (id: String) -> Unit = {}
) {
    val padding = 8.dp
    LazyColumn(contentPadding = PaddingValues(all = padding)) {
        itemsIndexed(coins) { index, coin ->
            CoinView(coin = coin, changeIsCheckedAction = changeIsCheckedAction)

            if (index < coins.lastIndex) {
                Spacer(modifier = Modifier.height(padding))
            }
        }
    }
}

@Preview(
    name = "Coins",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = false,
)
@Composable
fun PreviewCoins() {
    ComposeTheme {
        Coins(MockCoinList)
    }
}