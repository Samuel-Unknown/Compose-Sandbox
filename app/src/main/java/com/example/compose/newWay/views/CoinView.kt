package com.example.compose.newWay.views

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.common.data.MockCoinList
import com.example.compose.common.model.Coin
import com.example.compose.ui.theme.ComposeTheme

@Composable
fun CoinView(
    coin: Coin,
    changeIsCheckedAction: (id: String) -> Unit = {}
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        elevation = 2.dp
    ) {
        Row(modifier = Modifier.padding(all = 8.dp)) {
            Image(
                painter = painterResource(coin.iconRes),
                contentDescription = "Coin logo",
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box(modifier = Modifier.fillMaxWidth()) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    Text(
                        text = coin.name,
                        color = MaterialTheme.colors.secondaryVariant,
                        style = MaterialTheme.typography.h6
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Text(
                            text = coin.ticker,
                            style = MaterialTheme.typography.body2
                        )

                        Spacer(modifier = Modifier.width(8.dp))

                        Text(
                            text = coin.price,
                            style = MaterialTheme.typography.body1
                        )
                    }
                }

                Image(
                    painter = painterResource(
                        if (coin.isChecked) R.drawable.ic_star else R.drawable.ic_star_outline
                    ),
                    contentDescription = "Add to favorites",
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colors.primary),
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.CenterEnd)
                        .clickable { changeIsCheckedAction(coin.id) }
                )
            }
        }
    }
}

@Preview(
    name = "Coin [Light mode]",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
    showBackground = false,
)
@Preview(
    name = "Coin [Night mode]",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = false,
)
@Composable
fun PreviewCoinView() {
    ComposeTheme {
        CoinView(MockCoinList.first())
    }
}