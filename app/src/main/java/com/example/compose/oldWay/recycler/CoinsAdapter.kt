package com.example.compose.oldWay.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.compose.ui.res.dimensionResource
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.compose.R
import com.example.compose.common.model.Coin
import com.example.compose.databinding.ItemCoinBinding

class CoinsAdapter(
    context: Context,
    private val changeIsCheckedAction: (id: String) -> Unit
) : ListAdapter<Coin, CoinsAdapter.CoinViewHolder>(CoinDiffCallback()) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val binding = ItemCoinBinding.inflate(layoutInflater, parent, false)
        return CoinViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onBindViewHolder(
        holder: CoinViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun onViewRecycled(holder: CoinViewHolder) = holder.clear()

    inner class CoinViewHolder(
        val binding: ItemCoinBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(coin: Coin) {
            with(binding) {
                name.text = coin.name
                ticker.text = coin.ticker
                price.text = coin.price

                icon.setImageDrawable(
                    ContextCompat.getDrawable(
                        binding.root.context,
                        coin.iconRes
                    )
                )

                star.apply {
                    setImageDrawable(
                        ContextCompat.getDrawable(
                            binding.root.context,
                            if (coin.isChecked) R.drawable.ic_star else R.drawable.ic_star_outline
                        )
                    )
                    setOnClickListener {
                        val item = getItem(layoutPosition)
                        changeIsCheckedAction(item.id)
                    }
                }
            }
        }

        fun clear() {
            binding.star.setOnClickListener(null)
        }
    }
}