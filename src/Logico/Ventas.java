package Logico;

import java.io.Serializable;
import java.util.ArrayList;

public class Ventas implements Serializable{

	private ArrayList<Componente> componente;
	private ArrayList<Kit> kits;
	public Ventas() {
		super();
		componente= new ArrayList<>();
		kits= new ArrayList<>();
	}
	public ArrayList<Componente> getComponente() {
		return componente;
	}
	public void AgregarComponente(ArrayList<Componente> componentes) {
		this.componente=componentes;
	}
	public ArrayList<Kit> getKits() {
		return kits;
	}
	public void AgregarKits(ArrayList<Kit> kits) {
		this.kits=kits;
	}
	

}
