package com.example.dvibe.data.eventdetails

import com.example.dvibe.model.eventdetails.EventDetails
import com.example.dvibe.model.eventdetails.Participant
import com.example.dvibe.model.eventdetails.MusicBand
import com.example.dvibe.model.eventdetails.Offer

val participants = listOf(
    Participant("https://images.unsplash.com/photo-1438761681033-6461ffad8d80?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100"),
    Participant("https://images.unsplash.com/photo-1521132293557-5b908a59d1e1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100"),
    Participant("https://images.unsplash.com/photo-1520975764749-7397d17130a2?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100"),
    Participant("https://images.unsplash.com/photo-1534564533601-4d3e3d9fd229?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100"),
    Participant("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100"),
    Participant("https://images.unsplash.com/photo-1604325461406-f8050b828b9c?ixlib=rb-1.2.1&auto=format&fit=crop&w=100")
)

val musicBand = MusicBand(
    name = "Invincibles",
    type = "Rock/Pop/Jazz/Punk",
    image = "https://images.unsplash.com/photo-1598214012909-9b1874af3cfc?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=100",
    amount = 500
)

val offers = listOf(
    Offer(
        description = "Add 10 team members and get",
        offerText = "40% off",
        banner = "https://raw.githubusercontent.com/BhavyaRattan/DVibe/master/resources/offer_item_2.png",
        actionText = "Add To Team"
    ),
    Offer(
        description = "Invite and get",
        offerText = "10% per participant",
        banner = "https://raw.githubusercontent.com/BhavyaRattan/DVibe/master/resources/offer_item_1.png",
        actionText = "Invite Member"
    )
)

val christmasParty = EventDetails(
    time = "07.00 pm - 02.00 am",
    date = "25 Dec, 2020",
    name = "Fueled Fam Christmas Eve",
    location = "Noida, India",
    description = "The holidays are a time of good cheer, " +
            "especially when there’s good wine, whiskey and beer!!! " +
            "Please join us for a christmas cocktail party. " +
            "We Ho-Ho-Hope you would dress nice and bring in your spice!!!" +
            "See you there for a Merry Christmas at Imperfecto, GIP mall ,Noida.\n" +
            "Don't forget to RSVP so that we can add you to the list of participants",
    participants = participants,
    musicBand = musicBand,
    offers = offers,
    amount = 150,
    discount = 30
)
