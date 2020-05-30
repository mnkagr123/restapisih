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

		 
		@Path("/noc_form")
		public class NocForm {
		
			
			@GET
			//@Path("/{name}")
			//@Produces("text/html")
			public void getStartingPage(//@PathParam("name")String Name,
					                      @QueryParam("name")String Name,
                                          @QueryParam("mobile")String Mobile,
                                          @QueryParam("address")String Address,
					                      @QueryParam("aadhar")String Aadhar
					                      )
			{
				//return MobileNo+" "+Email+" "+Place+" "+Date+" "+Article;
				String query = " insert into noc_form (name,mobile,address,aadhar)"
				        + " values (?, ?, ?, ?)";
				
				PreparedStatement ps;
				ResultSet rs; 
				  
				  try
				  {
				  
					  ps=MyConnection.getConnection().prepareStatement(query);
				      //rs=ps.executeQuery();
					  ps.setString(1, Name);
					  ps.setString(2, Mobile);
					  ps.setString(3, Address);
					  ps.setString(4, Aadhar);
					  
					  ps.execute();
				  
				  }
				  
				  catch(Exception e){ System.out.println(e); }	  
	          //return "mnk";
			}	
}

	

