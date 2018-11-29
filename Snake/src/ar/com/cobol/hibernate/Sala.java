package ar.com.cobol.hibernate;
import java.util.ArrayList;
import java.util.List;

public class Sala {

	private int id;
	private String nombre;
	private boolean privada;
	private List<Usuario> usuarios;
	
	public Sala() {
		usuarios = new ArrayList<Usuario>();
	}
	
	public Sala(String nombre, boolean privada) {
		this.nombre = nombre;
		this.privada = privada;
		usuarios = new ArrayList<Usuario>();
	}
	
	public Sala(int id, String nombre, boolean privada) {
		this.id = id;
		this.nombre = nombre;
		this.privada = privada;
		usuarios = new ArrayList<Usuario>();
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isPrivada() {
		return privada;
	}
	public void setPrivada(boolean privada) {
		this.privada = privada;
	}
	
	public void agregarUsuario(Usuario user) {
		this.usuarios.add(user);
	}
	public List<Usuario> getUsuarios(){
		return usuarios;
	}
	public void eliminarUsuario(Usuario user){
		usuarios.remove(user);
	}
}