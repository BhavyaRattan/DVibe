package com.example.dvibe.ui.eventdetails

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ConstraintLayout
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.QueryBuilder
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.annotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.dvibe.R
import com.example.dvibe.data.eventdetails.EventServiceImpl
import com.example.dvibe.model.eventdetails.EventDetails
import com.example.dvibe.ui.components.DrawableText

@Composable
fun EventDescription(data: EventDetails, modifier: Modifier = Modifier) {
    ConstraintLayout(modifier.fillMaxWidth()) {

        val (time, date, name, location, description) = createRefs()

        DrawableText(
            modifier = modifier.constrainAs(time) {
                start.linkTo(parent.start)
                top.linkTo(parent.top)
            },
            text = data.time,
            drawablePadding = 8.dp,
            drawableStart = Icons.Outlined.QueryBuilder
        )

        DrawableText(
            modifier = modifier.constrainAs(date) {
                end.linkTo(parent.end)
                top.linkTo(parent.top)
            },
            text = data.date,
            drawablePadding = 8.dp,
            drawableStart = Icons.Outlined.CalendarToday
        )

        Text(
            modifier = modifier.constrainAs(name) {
                top.linkTo(time.bottom, margin = 16.dp)
                start.linkTo(parent.start)
            },
            text = data.name,
            style = MaterialTheme.typography.h5
        )
        DrawableText(
            modifier = modifier.constrainAs(location) {
                start.linkTo(parent.start)
                top.linkTo(name.bottom, margin = 4.dp)
            },
            text = data.location,
            style = MaterialTheme.typography.body2
                .copy(color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)),
            drawablePadding = 8.dp,
            drawableStart = Icons.Outlined.LocationOn
        )
        DescriptionText(
            description = data.description,
            modifier = modifier.constrainAs(description) {
                top.linkTo(location.bottom, margin = 16.dp)
            })
    }
}

@Composable
fun DescriptionText(description: String, modifier: Modifier = Modifier) {
    val isExpanded = remember { mutableStateOf(false) }
    val minTextChars = 100
    Text(
        modifier = modifier.clickable(
            onClick = { isExpanded.value = !isExpanded.value },
            indication = null
        ).animateContentSize(), textAlign = TextAlign.Start,
        text = annotatedString {
            withStyle(style = SpanStyle()) {
                if (isExpanded.value || description.length < minTextChars)
                    append(description)
                else
                    append(description.substring(0, minTextChars))
            }
            if (description.length > minTextChars) {
                append(stringResource(id = R.string.space))
                withStyle(
                    style = SpanStyle(
                        color = MaterialTheme.colors.secondary,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append(
                        if (isExpanded.value)
                            stringResource(id = R.string.read_less)
                        else
                            stringResource(id = R.string.read_more)
                    )
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun EventDescriptionPreview() {
    EventDescription(
        data = EventServiceImpl().getEventDetails(),
        modifier = Modifier
    )
}