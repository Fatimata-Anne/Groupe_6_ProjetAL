package service;

import java.util.ArrayList;


public class GestionJetons extends AccessBD{

	public int add(Jeton jeton)
	{
		try 
		{
			this.st = this.getConnexion().prepareStatement("INSERT INTO users.api_token (jeton) VALUES(?)");
			this.st.setString(1, jeton.getJeton());
			
			return this.st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return 0;
	}
	
	public ArrayList<Jeton> getAll()
	{
		ArrayList<Jeton> liste = new ArrayList<Jeton>();
		Jeton jeton;
		try 
		{
			this.st = this.getConnexion().prepareStatement("SELECT * FROM users");
			this.rs = this.st.executeQuery();
			
			while(this.rs.next())
			{
				jeton = new Jeton();
				jeton.setId(this.rs.getInt("id"));
				jeton.setJeton(this.rs.getString("jeton"));
				liste.add(jeton);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return liste;
	}
	
	public Jeton getByJeton(String jet)
	{
		Jeton jeton = new Jeton();
		try 
		{
			this.st = this.getConnexion().prepareStatement("SELECT * FROM users WHERE jeton = ?");
			this.st.setString(1, jet);
			this.rs = this.st.executeQuery();
			
			while(this.rs.next())
			{
				jeton.setId(this.rs.getInt("id"));
				jeton.setJeton(this.rs.getString("token"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jeton;
	}
	
	public int revoke(String jet)
	{
		try 
		{
			this.st = this.getConnexion().prepareStatement("DELETE FROM users WHERE token = ?");
			this.st.setString(1, jet);
			return this.st.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
