package service;

public class Jeton {

	private int id;
	private String jeton;
	
	
	public Jeton() {}
	
	public Jeton(int id,String jeton)
	{
		this.id = id;
		this.jeton = jeton;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getJeton() {
		return jeton;
	}

	public void setJeton(String jeton) {
		this.jeton = jeton;
	}
}
