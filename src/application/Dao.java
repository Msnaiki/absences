package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.sql.CallableStatement;

public class Dao {
	public static Connection getConnection(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/absent", "root","");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("erreur de connection");
		}
		return con;
	}
	public static Apprenant  getApprenant(String email) throws SQLException {
		
		
		String query ="SELECT * FROM apprenant WHERE emailuser=? ";
		Apprenant apprenant = new Apprenant(7,"nom", "email", 7);
		
		 try
		  {
		Connection con = Dao.getConnection();
		PreparedStatement ps=con.prepareStatement(query);
		ps.setString(1, email);
		ResultSet rs= ps.executeQuery();
		if (rs.next()) {
			apprenant.setId(rs.getInt(1));
			apprenant.setNom(rs.getString(2));
			apprenant.setEmail(rs.getString(3));
			apprenant.setPromotion(rs.getInt(5));
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
public static int getabsence(String string, String string2, int id) throws SQLException {
	 try
	  { 
		 int abs = 0;
		 String query = "SELECT count(*)  FROM `absences` WHERE `idapprenant` = ? AND (`dateabs` BETWEEN ? AND ?)";
	Connection con = Dao.getConnection();
	PreparedStatement ps=con.prepareStatement(query);
	ps.setInt(1, id);
	ps.setString(2,  string);
	ps.setString(3, string2);
	ResultSet rs= ps.executeQuery();
	if (rs.next()) {
		abs=rs.getInt(1);
		
	}

	return abs;
	  }
 catch (SQLException se)
 {
   // log exception;
   throw se;
 }
		
	}
}
