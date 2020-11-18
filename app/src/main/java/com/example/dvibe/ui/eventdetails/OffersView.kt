package com.example.dvibe.ui.eventdetails

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.dvibe.R
import com.example.dvibe.data.eventdetails.EventServiceImpl
import com.example.dvibe.model.eventdetails.Offer
import com.example.dvibe.ui.components.NetworkImage
import com.husseinala.neon.core.Transformation
import com.husseinala.neon.core.centerCrop

@ExperimentalAnimationApi
@Composable
fun OffersView(offers: List<Offer>, modifier: Modifier = Modifier) {
    val isExpandedState = remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.background,
                shape = MaterialTheme.shapes.medium
            )
            .padding(horizontal = 8.dp)
    ) {
        OffersHeader(
            updateState = { newState -> isExpandedState.value = newState },
            isExpanded = isExpandedState.value
        )
        offers.map {
            OffersItem(it, isExpandedState.value)
            if (isExpandedState.value) {
                Spacer(modifier = Modifier.size(8.dp))
            }
        }
    }
}

@Composable
fun OffersHeader(updateState: (Boolean) -> Unit, isExpanded: Boolean) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.offers_header),
            style = MaterialTheme.typography.h6
        )

        IconButton(onClick = { updateState(!isExpanded) }) {
            Icon(
                asset = Icons.Default.ArrowDropDown.copy(
                    defaultHeight = 36.dp,
                    defaultWidth = 36.dp
                ),
                tint = MaterialTheme.colors.secondary
            )
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun OffersItem(offer: Offer, visibility: Boolean) {
    AnimatedVisibility(
        visible = visibility,
        enter = expandVertically(),
        exit = shrinkVertically(
            animSpec = tween(
                durationMillis = 1000,
            )
        )
    ) {
        ConstraintLayout(
            modifier = Modifier
                .background(
                    color = MaterialTheme.colors.surface,
                    shape = MaterialTheme.shapes.large,
                )
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            val (text, image, button) = createRefs()

            Text(modifier = Modifier.constrainAs(text) {
                top.linkTo(parent.top)
                linkTo(start = parent.start, end = parent.end)
                width = Dimension.fillToConstraints
            }, style = MaterialTheme.typography.subtitle1, text = annotatedString {
                withStyle(style = SpanStyle(color = MaterialTheme.colors.primary)) {
                    append(offer.description)
                }

                withStyle(style = SpanStyle(color = MaterialTheme.colors.secondary)) {
                    append(" ${offer.offerText}")
                }
            })

            NetworkImage(
                url = offer.banner,
                transformation = Transformation.centerCrop(),
                modifier = Modifier.constrainAs(image) {
                    top.linkTo(parent.top, margin = 24.dp)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                },
                size = 80.dp
            )

            Button(onClick = {}, modifier = Modifier.constrainAs(button) {
                bottom.linkTo(parent.bottom)
                start.linkTo(parent.start)
            }, backgroundColor = MaterialTheme.colors.secondary) {
                Text(text = offer.actionText, maxLines = 1)
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun OffersViewPreview() {
    OffersView(offers = EventServiceImpl().getEventDetails().offers)
}