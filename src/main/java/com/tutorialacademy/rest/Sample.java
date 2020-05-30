package com.tutorialacademy.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/mnk")

public class Sample {
	
	@GET
	//@Path("/{name}")
	@Produces("text/html")
	public String getStartingPage()
	{
		return "mayank";
	}
	
  
}
