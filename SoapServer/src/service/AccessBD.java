package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccessBD {
	protected Connection con=null;
    protected PreparedStatement st=null;
    protected ResultSet rs=null;
    
   public AccessBD()
   {
	   this.st = null;
	   this.rs = null;
	   try
       {
           Class.forName("com.mysql.jdbc.Driver");
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Actualite","root","");
          

       }
       catch(Exception ex)
       {
           System.out.println("!!!!"+ex.getMessage());
       }
   }
   
   public Connection getConnexion() {
		return con;
	}
}
