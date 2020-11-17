package service;

public class GestionAuthentification extends AccessBD{
	
	public int add(Authentification authentification)
	{
		try 
		{
			int i = new GestionUtilisateurs().afficherUtilisateurs().size();
			this.st = this.getConnexion().prepareStatement("INSERT INTO users (email, password) VALUES (?,?)");
			this.st.setInt(1, i);
			this.st.setString(2, authentification.getEmail());
			this.st.setString(3, authentification.getPassword());
			
			return this.st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Authentification getAuthentification(Authentification authentification)
	{
		Authentification a = new Authentification();
		try {
			this.st = this.getConnexion().prepareStatement("SELECT * FROM users WHERE email = ? AND password = ?");
			this.st.setString(1, authentification.getEmail());
			this.st.setString(2, authentification.getPassword());
			this.rs = this.st.executeQuery();
			
			while(this.rs.next())
			{
				a.setEmail(this.rs.getString("login"));
				a.setPassword(this.rs.getString("mdp"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public int remove(int idUser)
	{
		try {
			this.st = this.getConnexion().prepareStatement("DELETE FROM users WHERE email = ?");
			this.st.setString(1, rs.getString("email"));
			return this.st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int update(Authentification authentification)
	{
		try {
			this.st = this.getConnexion().prepareStatement("UPDATE users SET email = ? , password = ? WHERE id = ?");
			this.st.setString(1, authentification.getEmail());
			this.st.setString(2, authentification.getPassword());
			this.st.setInt(3, authentification.getId());
			
			return this.st.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
