package com.example.dvibe.data.eventdetails

import com.example.dvibe.model.eventdetails.EventDetails

interface EventService {
    fun getEventDetails(): EventDetails
}