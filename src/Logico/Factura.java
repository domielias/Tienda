package Logico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;


public class Factura implements Serializable{

	
	private double precioTotal;
	private Cliente cliente;
	private Vendedor vendedor;
	private ArrayList<Componente> compra;
	private ArrayList<Kit> compraK;
	private Date fecha;
	private String id;
	public Factura(double precioTotal, Cliente cliente, Vendedor vendedor, Date fecha, String id) {
		super();
		this.precioTotal = precioTotal;
		this.cliente = cliente;
		this.vendedor = vendedor;
		compra= new ArrayList<>();
		compraK= new ArrayList<>();
		this.fecha = fecha;
		this.id = id;
	}
	public double getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(double precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public ArrayList<Componente> getCompra() {
		return compra;
	}
	public void insertarCompra(ArrayList<Componente> compra) {
		this.compra=compra;
	}
	public ArrayList<Kit> getCompraK() {
		return compraK;
	}
	public void insertarCompraK(ArrayList<Kit> compraK) {
		this.compraK=compraK;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	
}
