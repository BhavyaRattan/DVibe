package com.example.dvibe.data.eventdetails

import com.example.dvibe.model.eventdetails.EventDetails

class EventServiceImpl : EventService {
    override fun getEventDetails(): EventDetails {
        return christmasParty
    }
}