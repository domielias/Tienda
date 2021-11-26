package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Proveedor extends Persona implements Serializable{
	
	private String id;
	private ArrayList<String> componente;
	public Proveedor(String id,String nombre, String cedula, String direccion, String telefono) {
		super(nombre, cedula, direccion, telefono);
		this.id=id;
		componente= new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public ArrayList<String> getComponente() {
		return componente;
	}
	public void insertarComponente(String componente) {
		this.componente.add(componente);
	}
	

}
