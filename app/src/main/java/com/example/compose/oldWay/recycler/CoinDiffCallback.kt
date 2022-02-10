package com.example.compose.oldWay.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.compose.common.model.Coin

class CoinDiffCallback : DiffUtil.ItemCallback<Coin>() {
    override fun areItemsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Coin, newItem: Coin): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: Coin, newItem: Coin): Any? {
        return if (oldItem.isChecked != newItem.isChecked) {
            CoinItemPayload.CheckPayload(newItem)
        } else super.getChangePayload(oldItem, newItem)
    }
}

internal sealed class CoinItemPayload {
    data class CheckPayload(val coin: Coin)
}