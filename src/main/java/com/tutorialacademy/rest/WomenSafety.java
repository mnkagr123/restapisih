package com.tutorialacademy.rest;


	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.util.Date;
	import javax.ws.rs.GET;
	import javax.ws.rs.Path;
	import javax.ws.rs.PathParam;
	import javax.ws.rs.Produces;
	import javax.ws.rs.QueryParam;
	import javax.ws.rs.core.Response;
	import org.json.simple.JSONArray;
	import org.json.simple.JSONObject;

		 
		@Path("/women_safety")
		public class WomenSafety {
		
			
			@GET
			//@Path("/{name}")
			//@Produces("text/html")
			public void getStartingPage(//@PathParam("name")String Name,
					                      @QueryParam("driver")String Driver,
					                      @QueryParam("cab")String Cab,
					                      @QueryParam("startingl")String Startingl,
					                      @QueryParam("dropl")String Dropl
					                      )
			{
				//return MobileNo+" "+Email+" "+Place+" "+Date+" "+Article;
				String query = " insert into women_safety (driver,cab,startingl,dropl)"
				        + " values (?, ?, ?, ?)";
				
				PreparedStatement ps;
				ResultSet rs; 
				  
				  try
				  {
				  
					  ps=MyConnection.getConnection().prepareStatement(query);
				      //rs=ps.executeQuery();
					  ps.setString(1, Driver);
					  ps.setString(2, Cab);
					  ps.setString(3, Startingl);
					  ps.setString(4, Dropl);
					  
					  ps.execute();
				  
				  }
				  
				  catch(Exception e){ System.out.println(e); }	  
	          //return "mnk";
			}	
}
