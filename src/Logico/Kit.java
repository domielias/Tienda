package Logico;

import java.io.Serializable;
import java.util.ArrayList;


public class Kit implements Serializable {

	private ArrayList<Componente> componentes;
	private final int descuento = 10;
	private String id;
	private String nombre;
	private double precioFinal;
	private int cantidad;
	public Kit(String id, String nombre,int cantidad) {
		super();
		componentes = new ArrayList<>();
		this.id = id;
		this.nombre = nombre;
		precioFinal=preciosfinal();
		this.cantidad=cantidad;
	}
	public String toString()
	{
		String toString = nombre + " - RD$ "+ preciosfinal() +"("+cantidad+")";
		return toString ;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public void insertarComponentes(Componente componentes) {
		this.componentes.add(componentes);
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecioFinal() {
		return preciosfinal();
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getDescuento() {
		return descuento;
	}
	//Metodos
	private double preciosfinal() {
		double total=0;
		for (int i = 0; i < componentes.size(); i++) {	
			total+=componentes.get(i).getPrecioVenta()-(componentes.get(i).getPrecioVenta()*0.10);
		}
		return total;
	}
    
}
