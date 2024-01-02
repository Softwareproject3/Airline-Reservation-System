package Elements;

public class user {
	int id;
	String user_name, passwod;
	
	public user(int id, String user_name, String password){
		this.id = id;
		this.user_name = user_name;
		this.passwod = password;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPasswod() {
		return passwod;
	}

	public void setPasswod(String passwod) {
		this.passwod = passwod;
	}
	
	
}
