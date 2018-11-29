package ar.com.cobol.manager;

import java.util.ArrayList;
import java.util.List;

import ar.com.cobol.hibernate.*;

public class Manager {

	private List<Sala> salasPublicas;
	private List<Sala> salasPrivadas;
	private Integer cantSalasPublicas;
	private Integer cantSalasPrivadas;
	
	public Manager() {

		salasPublicas = new ArrayList<Sala>();
		salasPrivadas = new ArrayList<Sala>();
		cantSalasPrivadas = 0;
		cantSalasPublicas = 0;
	}
	
	public void logearse() {
		//METODO PARA MANEJAR EL LOGIN DE UN USUARIO EN EL MOMENTO QUE SE APRETE EL JBUTTON PARA LOGEARSE
		//DEBERIA DEVOLVERSER UN USUARIO NUEVO (SUPONGO) EL CUAL ES EL USUARIO ACTIVO
	}
	
	public void mostrarVentanaPrincipal() {
		//MOSTRAR LA VENTANA PRINCIPAL QUE SE MUESTRA AL INICIAR LA APLICACION
	}
	
	public void ingresarAUnaSalaPublica(Usuario user,String nameSala) {
		for(Sala sala : this.salasPublicas) {
			if(sala.getNombre().equals(nameSala)) {
				sala.agregarUsuario(user);
			}
		}
	}
	
	public void serEspectador(Usuario user, Sala sala) {
		user.serEspectador();
		sala.agregarUsuario(user);
	}
	
	public void crearSalaPublica(String nombre){
		
		Sala salaPublica = new Sala(cantSalasPublicas,nombre, false);
		salasPublicas.add(salaPublica);
		cantSalasPublicas ++;
	}
	
	
	public void crearSalaPrivada(String nombre) {
		
		Sala salaPrivada = new Sala(cantSalasPrivadas, nombre, true);
		salasPrivadas.add(salaPrivada);
		cantSalasPrivadas ++;
	}
	
	public List<Sala> mostrarSalasPublicas(){
		return salasPublicas;
	}
	
	public List<Sala> mostrarSalasPrivadas(){
		return salasPrivadas;
	}	
}