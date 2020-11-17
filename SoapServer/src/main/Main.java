package main;

import javax.xml.ws.Endpoint;
import server.SoapServer;


public class Main {

	public static void main(String[] args) {
		String wsName = "GestionUtilisateurs";
		String url= "http://localhost:1234/";
		Endpoint.publish(url, new SoapServer());
		System.out.println("Le service a été lancé avec succès");
		System.out.println("Vous pouvez y accéder à l'adresse: "+url+wsName+"?wsdl");

	}

}
