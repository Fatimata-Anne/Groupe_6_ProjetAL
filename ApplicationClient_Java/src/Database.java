import java.sql.Connection;
import java.sql.DriverManager;


public class Database {
	 public Connection conn;
     
	    public void connexionBD(){
	         
	         
	        /*  Chargement de la Base de donn�es  */
	            try{
	                 
	                Class.forName("com.mysql.jdbc.Driver.");
	                 
	            } catch (Exception e) {
	                 
	                System.out.println(" Erreur de chargement de la Base de donn�es");
	                e.getMessage();
	                System.exit(0);
	                 
	            }
	         
	         
	            /*    Connexion de la Base de donn�es  */
	            try {
	                 
	                String url = "jdbc:mysql://localhost/actualite";
	                String user = "root";
	                String passwd ="";
	                conn = DriverManager.getConnection(url, user, passwd);
	                 
	            } catch (Exception e) {
	                System.out.println(" Erreur de Connexion � la Base de donn�es ");
	            }  
	             
	        }
	     
	            /*   */
	            public Connection getConnect(){
	                 
	                return conn;
	            }
	     
	             
	            /*   Deconnexion  */
	            public void Deconnexion(){
	             
	                try {
	                    conn.close();
	                     
	                } catch (Exception e) {
	                    System.out.println(" D�connexion Impossible ");
	                }
	            }
	         

}
