package com.example.compose.oldWay

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.compose.common.CoinsVm
import com.example.compose.databinding.ActCoinsBinding
import com.example.compose.oldWay.recycler.CoinItemAnimator
import com.example.compose.oldWay.recycler.CoinsAdapter
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CoinsActivity : ComponentActivity() {
    private val vm: CoinsVm by viewModels()
    private lateinit var binding: ActCoinsBinding

    private val coinsAdapter: CoinsAdapter by lazy(LazyThreadSafetyMode.NONE) {
        CoinsAdapter(
            context = this,
            changeIsCheckedAction = { id -> vm.changeIsChecked(id) }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActCoinsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecycler()
        subscribeForStateUpdates()
    }

    private fun subscribeForStateUpdates() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                vm.coinsStateFlow.collect { coinsState ->
                    coinsAdapter.submitList(coinsState.coins)
                }
            }
        }
    }

    private fun initRecycler() {
        binding.recycler.apply {
            adapter = coinsAdapter
            itemAnimator = CoinItemAnimator()
        }
    }
}