package com.example.compose.oldWay.recycler

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import com.example.compose.R

class CoinItemAnimator : DefaultItemAnimator() {

    override fun canReuseUpdatedViewHolder(
        viewHolder: RecyclerView.ViewHolder,
        payloads: MutableList<Any>
    ): Boolean = payloads.filterIsInstance<CoinItemPayload.CheckPayload>().isNotEmpty()

    override fun recordPreLayoutInformation(
        state: RecyclerView.State,
        viewHolder: RecyclerView.ViewHolder,
        changeFlags: Int,
        payloads: MutableList<Any>
    ): ItemHolderInfo {
        if (changeFlags == FLAG_CHANGED) {
            payloads.filterIsInstance<CoinItemPayload.CheckPayload>()
                .firstOrNull()
                ?.let { selectionPayload ->
                    return CoinItemHolderInfo(
                        if (selectionPayload.coin.isChecked)
                            UpdateAction.Check
                        else
                            UpdateAction.Uncheck
                    )
                }
        }

        return super.recordPreLayoutInformation(state, viewHolder, changeFlags, payloads)
    }

    override fun animateChange(
        oldHolder: RecyclerView.ViewHolder,
        newHolder: RecyclerView.ViewHolder,
        preInfo: ItemHolderInfo,
        postInfo: ItemHolderInfo
    ): Boolean {
        if (preInfo is CoinItemHolderInfo) {
            val holder = newHolder as CoinsAdapter.CoinViewHolder
            animateHolder(holder, preInfo.updateAction)

            return false
        }

        return super.animateChange(oldHolder, newHolder, preInfo, postInfo)
    }

    private fun animateHolder(
        holder: CoinsAdapter.CoinViewHolder,
        updateAction: UpdateAction
    ) {
        with(holder.binding) {
            when (updateAction) {
                is UpdateAction.Check -> {
                    star.setImageDrawable(
                        ContextCompat.getDrawable(
                            star.context,
                            R.drawable.ic_star
                        )
                    )
                }
                is UpdateAction.Uncheck -> {
                    star.setImageDrawable(
                        ContextCompat.getDrawable(
                            star.context,
                            R.drawable.ic_star_outline
                        )
                    )
                }
            }
        }
    }

    private data class CoinItemHolderInfo(val updateAction: UpdateAction) : ItemHolderInfo()

    private sealed class UpdateAction {
        object Check : UpdateAction()
        object Uncheck : UpdateAction()
    }
}