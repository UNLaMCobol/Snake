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
