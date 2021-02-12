package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import Models.AbsenceRecord;
import Models.Apprenant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;

public class Dao {
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_absence", "root","");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("erreur de connection");
		}
		return con;
	}
	public static Apprenant  getApprenant(int id) throws SQLException {
		
		
		String query ="SELECT * FROM user WHERE id=? ";
		Apprenant apprenant = new Apprenant(7,"nom", "email", 7);
		
		 try
		  {
		Connection con = Dao.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		if (rs.next()) {
			apprenant.setId(rs.getInt(1));
			apprenant.setnomuser(rs.getString(2));
			apprenant.setEmail(rs.getString(3));
			apprenant.setIdPromotion(rs.getInt(6));
		}
		else {
			System.out.println("no row returned");
		}
		return apprenant;
		  }
	  catch (SQLException se)
	  {
	    // log exception;
	    throw se;
	  }
		
		
	}
public static ObservableList<AbsenceRecord> getabsence(String string, String string2, int id) throws SQLException {
	
	ObservableList <AbsenceRecord> list = FXCollections.observableArrayList();
	AbsenceRecord ab =null;
	
	
	 try
	  { 
		 ResultSet abs = null;
		 String query = "SELECT *  FROM `presence` WHERE `id_apprenant` = ? AND (`Date_absence` BETWEEN ? AND ?)";
	Connection con = Dao.getConnection();
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, id);
	ps.setString(2,  string);
	ps.setString(3, string2);
	ResultSet rs= ps.executeQuery();
	while(rs.next()) {
		
		list.add(new AbsenceRecord(rs.getInt(1) ,rs.getString(6),rs.getDate(5)) );
		System.out.println(rs.getInt(1));
		System.out.println(rs.getInt(2));
		System.out.println(rs.getInt(3));
		System.out.println(rs.getDate(5));
		System.out.println(rs.getInt(6));
		
		
	}
	return list;
	  }
 catch (SQLException se)
 {
   // log exception;
   throw se;
 }
		
	}
}
