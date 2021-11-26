package Logico;

import java.io.Serializable;

public class Administrador extends Usuario implements Serializable{

	public Administrador(String nombre, String cedula, String direccion, String telefono, String nombre2, String clave,
			String id) {
		super(nombre, cedula, direccion, telefono, nombre2, clave, id);
		// TODO Auto-generated constructor stub
	}
}
