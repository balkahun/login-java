package app.user;

import lombok.*;
@Value public class user {

	    
	   private String username;
	private String salt;
	private String hashedPassword;

	public user(String username, String salt, String hashedPassword) {
		this.username = username;
		this.salt = salt;
		this.hashedPassword = hashedPassword;
		}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHashedPassword() {
		return hashedPassword;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public String toString(){
		   return "true";
	   }
}
