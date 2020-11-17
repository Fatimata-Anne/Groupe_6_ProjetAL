import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Authentification extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel login,mdp;
    JTextField login1;
    JPasswordField mdp1;
    JButton valider,annuler;
     
         
    public Authentification(){
         
        super();
        this.setTitle(" Application Java ");
        this.setSize(new Dimension(400,200));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
         
         
        login = new JLabel("Login");
        login1 = new JTextField();
         
        mdp = new JLabel("Mot de Passe");
        mdp1 = new JPasswordField();
         
        valider = new JButton("Valider ");
        annuler = new JButton(" Annuler");
         
         
        Container contenu = this.getContentPane();
        contenu.setLayout(null);
         
        contenu.add(login);
        login.setBounds(20, 20, 100, 20);
         
        contenu.add(login1);
        login1.setBounds(150, 20, 150, 20);
         
        contenu.add(mdp);
        mdp.setBounds(22, 55, 100, 20);
         
        contenu.add(mdp1);
        mdp1.setBounds(150, 55, 150, 20);
         
        contenu.add(valider);
        valider.setBounds(125,100 ,77 ,20 );
         
        contenu.add(annuler);
        annuler.setBounds(225, 100, 82, 20);
         
        valider.addActionListener(new ValiderListener());  
         
        this.setVisible(true);
     
    }
         
}
 
        class ValiderListener extends JFrame implements ActionListener{
         
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
	            ActionEvent a = null;
                    try {
                    	TraitementAuthentification ta = new TraitementAuthentification();
                        ta.actionPerformed(a);
                    } catch (Exception e2) {
                         
                    }
            }
             
        }

	

