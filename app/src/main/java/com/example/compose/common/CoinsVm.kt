package com.example.compose.common

import androidx.lifecycle.ViewModel
import com.example.compose.common.data.MockCoinList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CoinsVm : ViewModel() {
    private val coinsMutableStateFlow = MutableStateFlow(CoinsState(coins = MockCoinList))
    val coinsStateFlow: StateFlow<CoinsState> = coinsMutableStateFlow.asStateFlow()

    fun changeIsChecked(id: String) {
        val index = coinsMutableStateFlow.value.coins.indexOfFirst { it.id == id }
        val coin = coinsMutableStateFlow.value.coins[index]

        coinsMutableStateFlow.value = CoinsState(
            coinsMutableStateFlow.value.coins
                .toMutableList()
                .apply { set(index, coin.copy(isChecked = coin.isChecked.not())) }
        )
    }
}