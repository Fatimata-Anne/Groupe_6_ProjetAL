package service;
import java.util.ArrayList;
import javax.jws.WebService;
import utilisateurs.Utilisateurs;
@WebService
public class GestionUtilisateurs extends AccessBD{
	
    
   public GestionUtilisateurs(){}
   
   public int addUtilisateurs(Utilisateurs p)
   {
	   try
	   {
		   st= con.prepareStatement("insert into users(id,name,email,password) values(?,?,?)");
		   st.setInt(1,p.getId());
           st.setString(2,p.getName());
           st.setString(3,p.getEmail());
           st.setString(4,p.getPassword());
           st.executeUpdate();
            
	   }
	   catch(Exception ex)
       {
           System.out.println("!!!!"+ex.getMessage());
       }
	   return 0;
   }
   public int modifierUtilisateurs(Utilisateurs p)
   {
	   try
	   {
		   st= con.prepareStatement("update users set name=? , email=? ,password=? where id=? ");
		   st.setString(1,p.getName());
           st.setString(2,p.getEmail());
           st.setString(3,p.getPassword());
           st.setInt(4,p.getId());
           st.executeUpdate();
            
	   }
	   catch(Exception ex)
       {
           System.out.println("!!!!"+ex.getMessage());
       }
	   return 0;
   }
   
   public int supprimerUtilisateurs(int id)
   {

	   try
	   {
		   st= con.prepareStatement("delete from users where id=?");
           st.setInt(1,id);
           st.executeUpdate();
            
	   }
	   catch(Exception ex)
       {
           System.out.println("!!!!"+ex.getMessage());
       }
	   return 0;
  
   }
   

 
   public ArrayList<Utilisateurs> afficherUtilisateurs()
   {
	   ArrayList <Utilisateurs> liste= new ArrayList <Utilisateurs>();
	   try
	   {
		   st =con.prepareStatement("select * from users");
           rs=st.executeQuery();
           while(rs.next())
           {
            int id=rs.getInt("id");
            String name=rs.getString("name");
            String email=rs.getString("email");
            String password=rs.getString("password");
            Utilisateurs p = new Utilisateurs(id,name,email,password);
            liste.add(p);
            }
          
	   }
	   catch(Exception ex)
       {
           System.out.println("!!!!"+ex.getMessage());
       }
	   return liste;
   }
   
   public boolean authentification (String login, String pwd){
       try{
         ArrayList<Utilisateurs> List = afficherUtilisateurs();
         for(Utilisateurs Liste : List){
         if(login.equals(Liste.getEmail()) && pwd.equals(Liste.getPassword())){
             return true;
         }
         }
         }  
         catch(Exception ex){
             System.out.println("authentification echoue "+ex.getMessage());
         }
       return false;
  }
}
