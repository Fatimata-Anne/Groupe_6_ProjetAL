package service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Authentification {
	private int id;
	private String email;
	private String password;
	
	public Authentification() {}
	
	public Authentification(int id,String email, String password) throws NoSuchAlgorithmException {
		this.id = id;
		this.email = email;
		this.setPassword(password);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws NoSuchAlgorithmException {
		this.password = getSecurePassword(getSHA1SecurePassword(password));
	}
	
	private String getSecurePassword(String passwordToHash) throws NoSuchAlgorithmException
    {
        String generatedPassword = null;
        MessageDigest md = MessageDigest.getInstance("MD5");
        //Add password bytes to digest
        md.update(passwordToHash.getBytes());
        //Get the hash's bytes
        byte[] bytes = md.digest();
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        generatedPassword = sb.toString();
        return generatedPassword;
    }
	
	
	private String getSHA1SecurePassword(String passwordToHash) throws NoSuchAlgorithmException
    {
        String generatedPassword = null;
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        //Add password bytes to digest
        md.update(passwordToHash.getBytes());
        //Get the hash's bytes
        byte[] bytes = md.digest();
        //Convert it to hexadecimal format
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++)
        {
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        //Get complete hashed password in hex format
        generatedPassword = sb.toString();
        return generatedPassword;
    }


}
