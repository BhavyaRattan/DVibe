package com.example.dvibe.ui.eventdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.example.dvibe.R
import com.example.dvibe.data.eventdetails.EventServiceImpl
import com.example.dvibe.model.eventdetails.MusicBand
import com.example.dvibe.ui.components.NetworkImage
import com.example.dvibe.ui.components.VerticalDivider

@Composable
fun MusicBandCard(band: MusicBand, modifier: Modifier = Modifier) {
    ConstraintLayout(
        modifier = modifier
            .background(
                color = MaterialTheme.colors.primaryVariant,
                shape = CutCornerShape(topStart = 32.dp, bottomEnd = 32.dp)
            )
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        val (
            logo, name, type, bookText, bookSubText,
            cost, costSubText, button, divider) = createRefs()

        val topBarrier = createBottomBarrier(logo, type)
        val verticalGuideline = createGuidelineFromStart(0.6f)

        NetworkImage(
            url = band.image,
            modifier = modifier.constrainAs(logo) {
                start.linkTo(parent.start, margin = 16.dp)
                top.linkTo(parent.top)
            }.size(50.dp),
        )

        Text(text = band.name,
            style = MaterialTheme.typography.subtitle2
                .copy(color = MaterialTheme.colors.primary),
            modifier = modifier.constrainAs(name) {
                start.linkTo(logo.end, margin = 8.dp)
                end.linkTo(button.start, margin = 8.dp)
                top.linkTo(logo.top)
                width = Dimension.fillToConstraints
            }
        )

        Text(text = band.type,
            style = MaterialTheme.typography.subtitle2
                .copy(color = MaterialTheme.colors.secondary),
            modifier = modifier.constrainAs(type) {
                start.linkTo(name.start)
                end.linkTo(button.start, margin = 8.dp)
                top.linkTo(name.bottom, margin = 4.dp)
                width = Dimension.fillToConstraints
            })

        Text(text = stringResource(id = R.string.band_title),
            style = MaterialTheme.typography.subtitle1
                .copy(color = MaterialTheme.colors.primary),
            modifier = modifier.constrainAs(bookText) {
                top.linkTo(topBarrier, margin = 16.dp)
                start.linkTo(logo.start)
                end.linkTo(verticalGuideline, margin = 16.dp)
                width = Dimension.fillToConstraints
            })

        Text(text = stringResource(id = R.string.band_subtitle),
            style = MaterialTheme.typography.caption
                .copy(color = MaterialTheme.colors.secondary),
            modifier = modifier.constrainAs(bookSubText) {
                start.linkTo(logo.start)
                top.linkTo(bookText.bottom)
                end.linkTo(verticalGuideline, margin = 16.dp)
                width = Dimension.fillToConstraints
            })

        VerticalDivider(
            color = Color.Black,
            modifier = modifier.constrainAs(divider) {
                top.linkTo(bookText.top)
                bottom.linkTo(parent.bottom)
                start.linkTo(verticalGuideline)
                height = Dimension.fillToConstraints
            })

        Text(text = band.amountString,
            style = MaterialTheme.typography.subtitle1
                .copy(color = MaterialTheme.colors.primary),
            modifier = modifier.constrainAs(cost) {
                top.linkTo(topBarrier, margin = 16.dp)
                start.linkTo(verticalGuideline, margin = 16.dp)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            })

        Text(text = stringResource(id = R.string.per_person),
            style = MaterialTheme.typography.caption
                .copy(color = MaterialTheme.colors.secondary),
            modifier = modifier.constrainAs(costSubText) {
                start.linkTo(verticalGuideline, margin = 16.dp)
                top.linkTo(cost.bottom)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            })

        IconButton(
            onClick = {},
            modifier = modifier
                .constrainAs(button) {
                    end.linkTo(parent.end)
                }
                .background(color = MaterialTheme.colors.secondary, shape = CircleShape)
                .size(30.dp)
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowForwardIos,
                modifier = modifier.size(12.dp),
                tint = MaterialTheme.colors.onSecondary,
                contentDescription = null
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MusicBandPreview() {
    MusicBandCard(
        band = EventServiceImpl().getEventDetails().musicBand!!,
        modifier = Modifier
    )
}