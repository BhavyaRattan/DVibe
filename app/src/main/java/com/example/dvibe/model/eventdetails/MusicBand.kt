package com.example.dvibe.model.eventdetails

data class MusicBand(
    val name: String,
    val type: String,
    val image: String,
    val amount: Long
) {
    val amountString = "$$amount"
}