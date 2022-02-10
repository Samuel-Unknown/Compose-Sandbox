package com.example.compose.newWay

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.compose.common.CoinsVm
import com.example.compose.newWay.views.Coins
import com.example.compose.ui.theme.ComposeTheme

class NewWayCoinListActivity : ComponentActivity() {
    private val vm: CoinsVm by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { CoinsScreen(vm) }
    }
}

@Composable
fun CoinsScreen(vm: CoinsVm) {
    val state by vm.coinsStateFlow.collectAsState()

    ComposeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Coins(coins = state.coins) { id ->
                vm.changeIsChecked(id)
            }
        }
    }
}

@Preview(
    name = "Coins Screen",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = false,
)
@Composable
fun PreviewScreen() = CoinsScreen(CoinsVm())