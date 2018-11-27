package ar.com.cobol.hibernate;

public class Usuario {
	
	private int id;
	private String user;
	private String password;
	
	public Usuario() {
		
	}

	public Usuario(String user, String password) {
		this.user = user;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		Usuario user = (Usuario)obj;
		return this.id == user.id;
	}
	
}
