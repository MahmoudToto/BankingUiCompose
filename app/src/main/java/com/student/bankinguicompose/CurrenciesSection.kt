package com.student.bankinguicompose

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyPound
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.student.bankinguicompose.data.Currency
import com.student.bankinguicompose.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        name = "USD", buy = 23.35, sell = 23.25, icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "UER", buy = 13.35, sell = 13.25, icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN", buy = 28.35, sell = 28.25, icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "LE", buy = 66.35, sell = 66.25, icon = Icons.Rounded.CurrencyPound
    ),
    Currency(
        name = "USD", buy = 77.35, sell = 77.25, icon = Icons.Rounded.AttachMoney
    ),
    Currency(
        name = "UER", buy = 19.35, sell = 19.25, icon = Icons.Rounded.Euro
    ),
    Currency(
        name = "YEN", buy = 54.35, sell = 45.25, icon = Icons.Rounded.CurrencyYen
    ),
    Currency(
        name = "LE", buy = 56.35, sell = 56.25, icon = Icons.Rounded.CurrencyPound
    ),
)

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    ){



    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
            .background(MaterialTheme.colorScheme.inverseOnSurface)
            .animateContentSize()
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(modifier = Modifier
                .clip(CircleShape)
                .background(MaterialTheme.colorScheme.secondaryContainer)
                .clickable {
                    isVisible = !isVisible
                    iconState = if (isVisible) {
                        Icons.Rounded.KeyboardArrowUp
                    } else {
                        Icons.Rounded.KeyboardArrowDown
                    }
                }) {
                Icon(
                    modifier = Modifier.size(25.dp),
                    imageVector = iconState,
                    contentDescription = "Currencies",
                    tint = MaterialTheme.colorScheme.onSecondary
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Text(
                text = "Currencies",
                fontSize = 20.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(
            modifier = Modifier
                .heightIn(1.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondaryContainer)
        )
        if (isVisible) {
            BoxWithConstraints(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(MaterialTheme.colorScheme.background)
            ) {
                val boxWithConstraintsScope = this
                val width = boxWithConstraintsScope.maxWidth / 3

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal =  12.dp)
                ) {
                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier
                                .width(width),
                            text = "Currency",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                        Text(
                            modifier = Modifier
                                .width(width)
                            ,
                            text = "Buy",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                        Text(
                            modifier = Modifier
                                .width(width),
                            text = "Sell",
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp,
                            color = MaterialTheme.colorScheme.onBackground,
                            textAlign = TextAlign.End
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    LazyColumn {
                        items(currencies.size){ index ->
                            CurrenciesItem(
                                index = index,
                                width = width
                            )
                        }
                    }

                }

            }
        }
        }
    }
}

@Composable
fun CurrenciesItem(index: Int, width: Dp) {
    val currency = currencies[index]

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalAlignment = Alignment.CenterVertically
            )
     {
        Row (
            modifier = Modifier.width(width)
        ) {

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(2.dp))
                    .background(GreenStart)
                    .padding(4.dp)
            ) {
                Icon(
                    modifier = Modifier.size(18.dp),
                    imageVector = currency.icon,
                    contentDescription = currency.name,
                    tint = Color.White
                )
            }
            Text(
                modifier = Modifier
                    .padding(start = 8.dp),
                text = currency.name,
                fontWeight = FontWeight.SemiBold,
                fontSize = 18.sp,
                color = MaterialTheme.colorScheme.onBackground,

                )
        }
         Text(
             modifier = Modifier
                 .width(width)
                 .padding(start = 8.dp),
             text = "$ ${currency.buy}",
             fontWeight = FontWeight.SemiBold,
             fontSize = 16.sp,
             color = MaterialTheme.colorScheme.onBackground,
             textAlign = TextAlign.End
         )
         Text(
             modifier = Modifier
                 .width(width)
                 .padding(start = 8.dp),
             text = "$ ${currency.sell}",
             fontWeight = FontWeight.SemiBold,
             fontSize = 16.sp,
             color = MaterialTheme.colorScheme.onBackground,
             textAlign = TextAlign.End
         )
    }

}
