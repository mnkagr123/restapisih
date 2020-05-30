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

		 
		@Path("/report_incident")
		public class ReportIncident {
		
			
			@GET
			//@Path("/{name}")
			//@Produces("text/html")
			public void getStartingPage(//@PathParam("name")String Name,
					                      @QueryParam("id")String Id,
					                      @QueryParam("category")String Category,
					                      @QueryParam("poi")String Poi,
					                      @QueryParam("description")String Description
					                      )
			{
				
				
				//return MobileNo+" "+Email+" "+Place+" "+Date+" "+Article;
				String query = " insert into report_incident (id,category,poi,description)"
				        + " values (?, ?, ?, ?)";
				
				PreparedStatement ps;
				ResultSet rs; 
				  
				  try
				  {
				  
					  ps=MyConnection.getConnection().prepareStatement(query);
				      //rs=ps.executeQuery();
					  ps.setString(1, Id);
					  ps.setString(2, Category);
					  ps.setString(3, Poi);
					  ps.setString(4, Description);
					  
					  ps.execute();
				  
				  }
				  
				  catch(Exception e){ System.out.println(e); }	  
	          //return "mnk";
			}
}

