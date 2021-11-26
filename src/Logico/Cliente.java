package Logico;

import java.io.Serializable;

public class Cliente extends Persona implements Serializable{

	private String id;
	public Cliente(String id,String nombre, String cedula, String direccion, String telefono) {
		super(nombre, cedula, direccion, telefono);
		this.id=id;
	}
	public String getId() {
		return id;
	}
	
}
