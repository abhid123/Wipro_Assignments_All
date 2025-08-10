package com.model;

import java.util.HashMap;
import java.util.Map;

public class FlightService 
{
	Map<String, Integer> seats = new HashMap<>();
	
	public FlightService()
	{
		seats.put("FL123", 1);
	}
	
	public boolean isAvailable(String flightId)
	{
		boolean bflag = false;
		
		if(seats.getOrDefault(flightId, 0) > 0)
		{
			bflag = true;
		}
		
		return bflag;
	}
	
	public void seatReserved(String flightId)
	{
		if(isAvailable(flightId))
		{
			seats.put(flightId, seats.get(flightId)-1);
		}
	}
}
