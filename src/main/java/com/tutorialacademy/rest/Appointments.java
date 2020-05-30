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

	 
	@Path("/appointments")
	public class Appointments {
	
		
		@GET
		//@Path("/{name}")
		//@Produces("text/html")
		public void getStartingPage(//@PathParam("name")String Name,
				                      @QueryParam("id")String Id,
				                      @QueryParam("name")String Name,
				                      @QueryParam("mobile")String Moblie,
				                      @QueryParam("email")String Email,
				                      @QueryParam("category")String Category,
				                      @QueryParam("description")String Description,
				                      @QueryParam("status")String Status       
				                      )
		{
			//return MobileNo+" "+Email+" "+Place+" "+Date+" "+Article;
			String query = " insert into appointments (id,name,mobile,email,category,description,status)"
			        + " values (?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement ps;
			ResultSet rs; 
			  
			  try
			  {
			  
				  ps=MyConnection.getConnection().prepareStatement(query);
			      //rs=ps.executeQuery();
				  ps.setString(1, Id);
				  ps.setString(2, Name);
				  ps.setString(3, Moblie);
				  ps.setString(4, Email);
				  ps.setString(5, Category);
				  ps.setString(6, Description);
				  ps.setString(7, Status);
				  
				  ps.execute();
			  
			  }
			  
			  catch(Exception e){ System.out.println("mnk1"); }	  
          //return "mnk";
		}
		
		@GET
		@Path("/update")
		@Produces("application/json")
		public JSONObject appointmentUpdate( @QueryParam("id")String Id )
		{
			JSONObject obj = new JSONObject();
			String query = " update appointments set status='no' where id = ? ";
			PreparedStatement ps;
			ResultSet rs; 
			
			try
			  {
			  
				  ps=MyConnection.getConnection().prepareStatement(query);
			      
				  ps.setString(1, Id);
				  ps.executeUpdate();
				  
				  obj.put("status","updated");
			  }
			  
			  catch(Exception e){ System.out.println(e); obj.put("status", "notUpdated"); }
			
			return obj;
		}
		
		
	}