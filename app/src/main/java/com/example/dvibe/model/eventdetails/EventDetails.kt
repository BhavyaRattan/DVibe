package com.example.dvibe.model.eventdetails

data class EventDetails(
    val time: String,
    val date: String,
    val name: String,
    val location: String,
    val description: String,
    val participants: List<Participant> = emptyList(),
    val musicBand: MusicBand?,
    val offers: List<Offer> = emptyList(),
    val amount: Long,
    val discount: Long
) {
    val payableString = "$${amount - discount}"
    val amountString = "$$amount"
}