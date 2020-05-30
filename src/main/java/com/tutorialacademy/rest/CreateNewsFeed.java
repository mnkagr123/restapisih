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

		 
		@Path("/createnewsfeed")
		public class CreateNewsFeed {
		
			
			@GET
			//@Path("/{name}")
			//@Produces("text/html")
			public void getStartingPage(//@PathParam("name")String Name,
					
					                      @QueryParam("imageurl")String Imageurl,
					                      @QueryParam("description")String Description
					                      )
			{
				//return MobileNo+" "+Email+" "+Place+" "+Date+" "+Article;
				String query = " insert into news_feed (imageurl,description)"
				        + " values (?, ?)";
				
				PreparedStatement ps;
				ResultSet rs; 
				  
				  try
				  {
				  
					  ps=MyConnection.getConnection().prepareStatement(query);
				      //rs=ps.executeQuery();
					  ps.setString(1, Imageurl);
					  ps.setString(2, Description);
		 
					  ps.execute();
				  
				  }
				  
				  catch(Exception e){ System.out.println(e); }	  
	          //return "mnk";
			}	
}


