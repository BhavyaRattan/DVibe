package com.example.dvibe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.constraintlayout.compose.atLeast
import com.example.dvibe.data.eventdetails.EventServiceImpl
import com.example.dvibe.ui.eventdetails.EventDescription
import com.example.dvibe.ui.eventdetails.MusicBandCard
import com.example.dvibe.ui.eventdetails.OffersView
import com.example.dvibe.ui.eventdetails.ParticipantsView
import com.example.dvibe.ui.theme.DVibeTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DVibeTheme {
                Content()
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DVibeTheme {
        Content()
    }
}

@ExperimentalAnimationApi
@Composable
fun Content() {
    BoxWithConstraints {
        val boxHeight = maxHeight
        val imageSrc = painterResource(id = R.drawable.header)

        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(16.dp)
        ) {

            val (image, card) = createRefs()

            Image(
                painter = imageSrc,
                modifier = Modifier
                    .constrainAs(image) {}
                    .height(200.dp)
                    .clip(shape = MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )

            Card(
                elevation = 4.dp,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .constrainAs(card) {
                        bottom.linkTo(parent.bottom)
                        linkTo(start = parent.start, end = parent.end)
                        height = Dimension.preferredWrapContent
                            .atLeast(boxHeight - 250.dp)
                        width = Dimension.fillToConstraints
                    }
            ) {
                EventDetailsContent()
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun EventDetailsContent() {
    val eventDetails = EventServiceImpl().getEventDetails()
    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        EventDescription(
            data = eventDetails
        )

        if (eventDetails.participants.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            ParticipantsView(eventDetails.participants)
        }

        if (eventDetails.musicBand != null) {
            Spacer(modifier = Modifier.height(16.dp))
            MusicBandCard(band = eventDetails.musicBand)
        }

        if (eventDetails.offers.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            OffersView(offers = eventDetails.offers)
        }
    }
}