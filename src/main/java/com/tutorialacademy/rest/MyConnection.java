package com.tutorialacademy.rest;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KKR
 */
public class MyConnection {
    public static Connection getConnection(){
        Connection con = null;
        
        String username = "wcgswciqphrskw";
		String password = "e49a7d06a2ab33610a33f8f736083f1dd53a8c6e9b017c782ef13157b2599752";
		String dbUrl = "jdbc:postgresql://" + "ec2-54-217-204-34.eu-west-1.compute.amazonaws.com:5432"
				+ "/dbbi5l32ecg6dg?sslmode=require";
		
        
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }
}