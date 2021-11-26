package Logico;

import java.io.Serializable;

public class Vendedor extends Usuario implements Serializable{

	private int cantventas;

	public Vendedor(String nombre, String cedula, String direccion, String telefono, String nombre2, String clave,
			String id) {
		super(nombre, cedula, direccion, telefono, nombre2, clave, id);
		cantventas=0;
	}
	public int getCantventas() {
		return cantventas;
	}
	public void incrementarVenta()
	{
		cantventas++;
	}

}
