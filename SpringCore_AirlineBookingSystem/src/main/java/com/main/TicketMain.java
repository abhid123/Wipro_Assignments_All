package com.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model.TicketService;

public class TicketMain 
{
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("airline-context.xml");
		
		TicketService ticketService = (TicketService) context.getBean("ticketService");
		
		String str1 = ticketService.confirmBooking("FL123", "USER456");
		System.out.println(str1);
		
		String str2 = ticketService.confirmBooking("FL123", "USER456");
		System.out.println(str2);
	}
}
