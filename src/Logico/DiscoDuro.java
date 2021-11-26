package Logico;

import java.io.Serializable;

public class DiscoDuro extends Componente implements Serializable{
	
	private double capacidad;
	private String conexion;	
	public DiscoDuro(String marca, double precioCompra, int cantidad, String numeroSerie, String modelo,
			double precioVenta, Proveedor proveedor,double capacidad,String conexion) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor);
		this.capacidad=capacidad;
		this.conexion=conexion;
	}
	public double getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public String getConexion() {
		return conexion;
	}
	public void setConexion(String conexion) {
		this.conexion = conexion;
	}
	

}
