package Logico;

import java.io.Serializable;

public class Ram extends Componente implements Serializable{

	private double memoria;
	private String tipo;
	public Ram(String marca, double precioCompra, int cantidad, String numeroSerie, String modelo, double precioVenta,
			Proveedor proveedor,double memoria,String tipo) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor);
		this.memoria = memoria;
		this.tipo = tipo;
	}
	public double getMemoria() {
		return memoria;
	}
	public void setMemoria(double memoria) {
		this.memoria = memoria;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
