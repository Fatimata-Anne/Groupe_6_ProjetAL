package main;

import javax.xml.ws.Endpoint;
import server.SoapServer;


public class Main {

	public static void main(String[] args) {
		String wsName = "GestionUtilisateurs";
		String url= "http://localhost:1234/";
		Endpoint.publish(url, new SoapServer());
		System.out.println("Le service a �t� lanc� avec succ�s");
		System.out.println("Vous pouvez y acc�der � l'adresse: "+url+wsName+"?wsdl");

	}

}
