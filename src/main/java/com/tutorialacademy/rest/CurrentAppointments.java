package com.tutorialacademy.rest;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.jdbc.ResultSetMetaData;

@Path("/current_appointments")
public class CurrentAppointments {

	@GET
	//@Path("/{name}")
	@Produces("application/json")
	public JSONObject getStartingPage() {//@PathParam("name") String Name) {

		  
		  
		
		  String query="select * from appointments where status='yes' "; 
		  PreparedStatement ps;
		  ResultSet rs; 
		  JSONArray json = new JSONArray();  
		  
		  try
		  {
		  
			  ps=MyConnection.getConnection().prepareStatement(query);
		      rs=ps.executeQuery(); 
		  
		  while (rs.next())
		  {
			  JSONObject obj = new JSONObject();
			  for (int i = 1; i <= 6; i++) 
			  { 
				  java.sql.ResultSetMetaData rsmd = rs.getMetaData();
				  String column_name = rsmd.getColumnName(i);
				  
				  String columnValue = rs.getString(i);
		          
				  obj.put(column_name, columnValue);
				 
				  //System.out.print(column+" "); 
		      }
			  json.add(obj);
		  }
		
		  
		  }
		  catch(Exception e){ System.out.println("mnk1"); }
		  
		  JSONObject obj1 = new JSONObject();
		  obj1.put("current_appointments", json);	 
		  return obj1 ;
	}

}
