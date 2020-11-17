
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	 
	import javax.swing.JOptionPane;
	import javax.swing.JTextField;
	 
	/*  Traitement à faire   */
	 
	public class TraitementAuthentification implements ActionListener {
	 
	    public Database b = new Database();
	    public Connection conn;
	     
	    static JTextField login,passwd ;
	     
	    PreparedStatement statement = null;
	     
	    ResultSet resultat;
	     
	    public TraitementAuthentification(){
	         
	    }
	 
	 
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        String username = login.getText();
	        String password = passwd.getText();
	         
	        b.connexionBD();
	        conn = b.getConnect();
	            try{
	                statement = (PreparedStatement) conn.createStatement();
	                String sql = "Select email, password from users";
	                resultat = statement.executeQuery(sql);
	                 
	                if(resultat.next()){
	                     
	                    String motDePasse = resultat.getString(1);
	         
	                if(motDePasse.equals(password)){
	             
	                    JOptionPane.showMessageDialog(null,"Connexion réussie ! ","Success",JOptionPane.PLAIN_MESSAGE);
	                }else {
	                     
	                    JOptionPane.showMessageDialog(null,"Mot de passe incorrect ! ","Error",1);
	                }
	                }else {
	                     
	                    JOptionPane.showMessageDialog(null,"Login incorrect ! ","Error",1);
	                }
	 
	                    conn.close();
	         
	            }catch (SQLException e4) {
	             
	                System.out.println(e4.getMessage());
	            }
	        }
	     
	}


