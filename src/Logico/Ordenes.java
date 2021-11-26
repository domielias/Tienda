package Logico;

import java.util.ArrayList;
import java.util.Date;

public class Ordenes {

	private Componente componentes;
	private Date fecha;
	private Vendedor vendedor;
	
	public Ordenes(Componente componentes,Vendedor vendedor,Date fecha) {
		super();
		this.componentes=componentes;
		this.vendedor=vendedor;
		this.fecha = fecha;
	}
	public Componente getComponentes() {
		return componentes;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setComponentes(Componente componentes) {
		this.componentes = componentes;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	
	

}
