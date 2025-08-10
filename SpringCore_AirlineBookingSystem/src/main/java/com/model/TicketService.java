package com.model;

public class TicketService 
{
	FlightService flightService;
	
	public void setFlightService(FlightService flightService) {
        this.flightService = flightService;
    }
	
	public String confirmBooking(String flightId, String userId) 
	{
        if(flightService.isAvailable(flightId)) 
        {
            flightService.seatReserved(flightId);
            return "Booking confirmed for " + userId + " on " + flightId;
        } 
        else 
        {
            return "Flight " + flightId + " is full";
        }
    }
}
