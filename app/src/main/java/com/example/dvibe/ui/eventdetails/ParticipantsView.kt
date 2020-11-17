package com.example.dvibe.ui.eventdetails

import androidx.compose.foundation.Text
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.example.dvibe.R
import com.example.dvibe.data.eventdetails.EventServiceImpl
import com.example.dvibe.model.eventdetails.Participant
import com.example.dvibe.ui.components.NetworkImage
import com.example.dvibe.ui.eventdetails.Constants.IMAGE_SIZE
import com.example.dvibe.ui.eventdetails.Constants.OVERLAP_WIDTH
import com.example.dvibe.ui.eventdetails.Constants.PARTICIPANTS_TO_SHOW

object Constants {
    val IMAGE_SIZE = 40.dp
    val OVERLAP_WIDTH = 10.dp
    const val PARTICIPANTS_TO_SHOW = 4
}

@Composable
fun ParticipantsView(participants: List<Participant>, modifier: Modifier = Modifier) {

    Box(modifier = modifier) {
        participants.take(PARTICIPANTS_TO_SHOW)
            .forEachIndexed { index, participant ->
                NetworkImage(
                    url = participant.image,
                    size = IMAGE_SIZE,
                    modifier = modifier
                        .width(IMAGE_SIZE.times(index + 1))
                        .height(IMAGE_SIZE)
                        .padding(
                            start =
                            IMAGE_SIZE.times(index) - OVERLAP_WIDTH.times(index)
                        )
                )
            }

        if (participants.size > PARTICIPANTS_TO_SHOW) {
            MoreParticipants(
                count = participants.size - PARTICIPANTS_TO_SHOW,
                modifier = modifier
            )
        }
    }
}

@Composable
fun MoreParticipants(count: Int, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = modifier
                .width(
                    IMAGE_SIZE.times(PARTICIPANTS_TO_SHOW + 1)
                            - OVERLAP_WIDTH.times(PARTICIPANTS_TO_SHOW - 1)
                )
                .height(IMAGE_SIZE)
                .padding(
                    start =
                    IMAGE_SIZE.times(PARTICIPANTS_TO_SHOW) - OVERLAP_WIDTH.times(
                        PARTICIPANTS_TO_SHOW - 1
                    )
                )
                .background(
                    color = MaterialTheme.colors.secondary,
                    shape = CircleShape
                )
        ) {
            Text(
                text = "+ $count",
                modifier = modifier.align(Alignment.Center),
                style = MaterialTheme.typography.caption
                    .copy(color = MaterialTheme.colors.onSecondary)
            )
        }

        Text(
            text = stringResource(id = R.string.participants),
            modifier = modifier.padding(start = 8.dp),
            style = MaterialTheme.typography.subtitle2
                .copy(color = MaterialTheme.colors.secondary)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ParticipantsPreview() {
    ParticipantsView(
        participants = EventServiceImpl().getEventDetails().participants,
        modifier = Modifier
    )
}