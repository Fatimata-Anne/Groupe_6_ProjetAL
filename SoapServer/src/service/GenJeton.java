package service;

import java.util.ArrayList;

public class GenJeton {
	
	private static final String ALPHA_NUMERIC_STRING = "azertyuiopqsdfghjklmwxcvbn-_@ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private ArrayList<Jeton> Jetons;
	
	public GenJeton() {
		GestionJetons gesJeton = new GestionJetons();
		this.Jetons = gesJeton.getAll();
	}
	
	private boolean exist(String jet)
	{
		for(Jeton jeton : Jetons)
		{
			if(jeton.getJeton().equals(jet))
			{
				return true;
			}
		}
		return false;
	}

	private String randomAlphaNumeric() {

	StringBuilder builder = new StringBuilder();
	int count = (int) (Math.random()*(ALPHA_NUMERIC_STRING.length() - 10) + 1);

	while (count-- != 0) {

	int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

	builder.append(ALPHA_NUMERIC_STRING.charAt(character));

	}

	return builder.toString();

	}
	
	public String getJeton()
	{
		String jeton = "";
		do {
			jeton = this.randomAlphaNumeric();
		} while (exist(jeton));
		return jeton;
	}


}
