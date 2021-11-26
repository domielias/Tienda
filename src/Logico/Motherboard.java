package Logico;

import java.io.Serializable;
import java.util.ArrayList;


public class Motherboard extends Componente implements Serializable{

	private String socket;
	private String ram;
	private ArrayList<DiscoDuro> discoDuro;
	private String tipoHDD; 
	public Motherboard(String marca, double precioCompra, int cantidad, String numeroSerie, String modelo,
			double precioVenta, Proveedor proveedor,String socket, String ram, String tipoHDD) {
		super(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor);
		this.socket = socket;
		this.ram = ram;
		this.tipoHDD = tipoHDD;
		discoDuro = new ArrayList<>();
	}
	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public ArrayList<DiscoDuro> getDiscoDuro() {
		return discoDuro;
	}
	public void setDiscoDuro(ArrayList<DiscoDuro> discoDuro) {
		this.discoDuro = discoDuro;
	}
	public String getTipoHDD() {
		return tipoHDD;
	}
	public void setTipoHDD(String tipoHDD) {
		this.tipoHDD = tipoHDD;
	}

}
