package com.example.dvibe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.WithConstraints
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.DensityAmbient
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import com.example.dvibe.data.eventdetails.EventServiceImpl
import com.example.dvibe.ui.eventdetails.EventDescription
import com.example.dvibe.ui.eventdetails.MusicBandCard
import com.example.dvibe.ui.eventdetails.OffersView
import com.example.dvibe.ui.eventdetails.ParticipantsView
import com.example.dvibe.ui.theme.DVibeTheme
import com.husseinala.neon.glide.ProvideGlideLoader

class MainActivity : AppCompatActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val glide = Glide.with(applicationContext)
        setContent {
            ProvideGlideLoader(requestManager = glide) {
                DVibeTheme {
                    Content()
                }
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
    WithConstraints {
        val boxHeight = with(DensityAmbient.current) { constraints.maxHeight.toDp() }
        val imageSrc = imageResource(R.drawable.header)

        ConstraintLayout(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background)
                .padding(16.dp)
        ) {

            val (image, card) = createRefs()

            Image(
                imageSrc,
                modifier = Modifier
                    .constrainAs(image) {}
                    .preferredHeight(200.dp)
                    .clip(shape = MaterialTheme.shapes.large),
                contentScale = ContentScale.Crop
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
    ScrollableColumn(
        modifier = Modifier
            .padding(16.dp)
    ) {
        EventDescription(
            data = eventDetails
        )

        if (eventDetails.participants.isNotEmpty()) {
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            ParticipantsView(eventDetails.participants)
        }

        if (eventDetails.musicBand != null) {
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            MusicBandCard(band = eventDetails.musicBand)
        }

        if (eventDetails.offers.isNotEmpty()) {
            Spacer(modifier = Modifier.preferredHeight(16.dp))
            OffersView(offers = eventDetails.offers)
        }
    }
}