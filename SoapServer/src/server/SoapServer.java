package server;

import java.security.NoSuchAlgorithmException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import service.*;
import utilisateurs.Utilisateurs;


@WebService
public class SoapServer {
	private GestionUtilisateurs GesUser = new GestionUtilisateurs();
	private GestionAuthentification GesAut = new GestionAuthentification();
	private GestionJetons GesJetons = new GestionJetons();
	
	@WebMethod
	public Jeton connect(@WebParam(name = "email") String email,@WebParam(name = "password") String password) throws NoSuchAlgorithmException
	{
		Jeton jeton = new Jeton();
		Authentification authentification = new Authentification();
		authentification.setEmail(email);
		authentification.setPassword(password);
		Authentification authenfie = GesAut.getAuthentification(authentification);
		if(authenfie.getId() != 0)
		{
			jeton.setJeton(new GenJeton().getJeton());
			jeton.setId(authenfie.getId());
			this.GesJetons.add(jeton);
		}
		
		return jeton;
	}
	
	@WebMethod
	public String revokeJeton(@WebParam(name = "jeton")String jeton)
	{
		Jeton jet = this.GesJetons.getByJeton(jeton);
		if( jet.getId() != 0)
		{
			int response = this.GesJetons.revoke(jeton); 
			if(response != 0)
			{
				return "Token supprimé avec succès";
			}
			return "Erreur lors de la suppression du token";
		}
		return "Votre token n'est pas valable";
	}
	
	@WebMethod
	public String addUser(@WebParam(name = "utilisateur")Utilisateurs user,@WebParam(name = "pseudoEtPassword")Authentification authentification,@WebParam(name = "jeton")String jeton)
	{
		Jeton jet = this.GesJetons.getByJeton(jeton);
		if( jet.getId() != 0)
		{
			int repAddU = this.GesUser.addUtilisateurs(user);
			
			int repaddAu = this.GesAut.add(authentification);
			System.out.println(repAddU+'_'+repAddU);
			if((repAddU != 0) && (repaddAu != 0))
			{
				return "Ajout effectué avec succès";
			}
			return "Erreur lors de l'ajout";
		}
		return "Vous n'êtes pas admin";
	}
	
	@WebMethod
	public String updateUser(@WebParam(name = "utilisateur")Utilisateurs user,@WebParam(name = "pseudoEtPassword")Authentification authentification,@WebParam(name = "jeton")String jeton)
	{
		Jeton jet = this.GesJetons.getByJeton(jeton);
		if( jet.getId() != 0)
		{
			int repAddU = this.GesUser.modifierUtilisateurs(user);
			int repaddAu = this.GesAut.update(authentification);
			if((repAddU != 0) && (repaddAu != 0))
			{
				return "Mise à jour effectué avec succès";
			}
			return "Erreur lors de la mise à jour";
		}
		return "Vous n'êtes pas admin";
	}
	
	@WebMethod
	public String removeUser(@WebParam(name = "id")int id,@WebParam(name = "jeton")String jeton)
	{
		Jeton jet = this.GesJetons.getByJeton(jeton);
		if( jet.getId() != 0)
		{
			int repAddU = this.GesUser.supprimerUtilisateurs(id);
			int repaddAu = this.GesAut.remove(id);
			if((repAddU != 0) && (repaddAu != 0))
			{
				return "Suppression effectué avec succès";
			}
			return "Erreur lors de la suppression";
		}
		return "Vous n'êtes pas admin";
	}
	
}

