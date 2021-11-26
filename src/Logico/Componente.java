package Logico;

import java.io.Serializable;

public class Componente implements Serializable {
	
	protected String marca;
	protected double precioCompra;
	protected int cantidad;
	protected String numeroSerie;
	protected String modelo;
	protected double precioVenta;
	protected Proveedor proveedor;
	protected int stockMinimo;
	public Componente(String marca, double precioCompra, int cantidad, String numeroSerie, String modelo,
			double precioVenta, Proveedor proveedor) {
		super();
		this.marca = marca;
		this.precioCompra = precioCompra;
		this.cantidad = cantidad;
		this.numeroSerie = numeroSerie;
		this.modelo = modelo;
		this.precioVenta = precioVenta;
		this.proveedor = proveedor;
		stockMinimo=5;
	}
	public String toString()
	{
		String toString = marca + " - RD$ "+ precioVenta+"("+cantidad+")";
		return toString;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}
	public int getStockMinimo() {
		return stockMinimo;
	}
	
}
