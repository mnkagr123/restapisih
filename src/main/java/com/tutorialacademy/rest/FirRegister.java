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

	 
	@Path("/firRegister")
	public class FirRegister {
	
		
		@GET
		//@Path("/{name}")
		@Produces("application/json")
		public JSONObject getStartingPage(//@PathParam("name")String Name,
				                      @QueryParam("fir")String Fir,
				                      @QueryParam("name")String Name,
				                      @QueryParam("mobile")String Moblie,
				                      @QueryParam("email")String Email,
				                      @QueryParam("pol")String Pol,
				                      @QueryParam("article")String Article,       
				                      @QueryParam("identification")String Identification,       
				                      @QueryParam("description")String Description,
				                      @QueryParam("status")String Status
				                      )
		{
			
			JSONObject obj = new JSONObject();
			String key="status";
			//return MobileNo+" "+Email+" "+Place+" "+Date+" "+Article;
			String query = " insert into fir_registration (fir,name,mobile,email,pol,article,identification,description,status)"
			        + " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			String query1 = " select * from fir_registration where identification='"+Identification+"' ";
			
			PreparedStatement ps;
			ResultSet rs; 
			  
			  try
			  {
				  if(Fir==null)
				  {
					  ps=MyConnection.getConnection().prepareStatement(query1);
				      rs=ps.executeQuery();
				      if(rs.next())obj.put(key,"yes");
				      else obj.put(key,"no");
				  }
				  
				  else 
				  {
				     ps=MyConnection.getConnection().prepareStatement(query);
			         //rs=ps.executeQuery();
				     ps.setString(1, Fir);
				     ps.setString(2, Name);
				     ps.setString(3, Moblie);
				     ps.setString(4, Email);
				     ps.setString(5, Pol);
				     ps.setString(6, Article);
				     ps.setString(7, Identification);
				     ps.setString(8, Description);
				     ps.setString(9, Status);
					  
				     ps.execute();
				  }
			  
			  }
			  
			  catch(Exception e){ System.out.println("mnk1"); }	  
          return obj;
		}
		
		@GET
		@Path("/detail")
		@Produces("application/json")
		public JSONObject beatManagementUpdate( @QueryParam("fir")String Fir)
				                                
		{
			JSONObject obj = new JSONObject();
			String query = " select * from fir_registration where fir='"+Fir+"' ";
			PreparedStatement ps;
			ResultSet rs; 
			
				  
				  try
				  {
				  
					  ps=MyConnection.getConnection().prepareStatement(query);
				      rs=ps.executeQuery(); 
				  
				  if (rs.next())
				  {
					  //JSONObject obj = new JSONObject();
					  for (int i = 1; i <= 9; i++) 
					  { 
						  java.sql.ResultSetMetaData rsmd = rs.getMetaData();
						  String column_name = rsmd.getColumnName(i);
						  
						  String columnValue = rs.getString(i);
				          
						  obj.put(column_name, columnValue);
						 
						  //System.out.print(column+" "); 
				      }
					  //json.add(obj);
				  }
				
				  
				  }
				  catch(Exception e){ System.out.println("mnk1"); }
		return obj;		  
		}

		
	}