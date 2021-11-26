package Logico;

import java.io.Serializable;

public class Procesador extends Componente implements Serializable{

	private String socket;
	private double velocidad;
	public Procesador(String marca, double precioCompra, int cantidad, String numeroSerie, String modelo,
			double precioVenta, Proveedor proveedor,String socket, double velocidad) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor);
		this.socket=socket;
		this.velocidad=velocidad;
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	

}
