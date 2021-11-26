package Logico;

import java.io.Serializable;
import java.util.ArrayList;


public class Meses implements Serializable{

	private ArrayList<Ventas> ventas;
	private String Mes;
	private int cantRam;
	private int cantMotherboard;
	private int cantCPU;
	private int cantHDD;
	private int cantKits;
	public Meses() {
		super();
		ventas= new ArrayList<>();
		cantRam=0;
		cantMotherboard=0;
		cantCPU=0;
		cantHDD=0;
		cantKits=0;
	}
	public ArrayList<Ventas> getVentas() {
		return ventas;
	}
	public void setVentas(ArrayList<Ventas> ventas) {
		this.ventas = ventas;
	}
	public String getMes() {
		return Mes;
	}
	public void setMes(String mes) {
		Mes = mes;
	}
	public int getCantRam() {
		return cantRam;
	}
	public void setCantRam(int cantRam) {
		this.cantRam = cantRam;
	}
	public int getCantMotherboard() {
		return cantMotherboard;
	}
	public void setCantMotherboard(int cantMotherboard) {
		this.cantMotherboard = cantMotherboard;
	}
	public int getCantCPU() {
		return cantCPU;
	}
	public void setCantCPU(int cantCPU) {
		this.cantCPU = cantCPU;
	}
	public int getCantHDD() {
		return cantHDD;
	}
	public void setCantHDD(int cantHDD) {
		this.cantHDD = cantHDD;
	}
	public int getCantKits() {
		return cantKits;
	}
	public void setCantKits(int cantKits) {
		this.cantKits = cantKits;
	}
	//Metodos
	public void insertarVentas(Ventas ventas)
	{
		this.ventas.add(ventas);
		for(int i = 0; i< ventas.getComponente().size() ;i++)
		{
			if(ventas.getComponente().get(i) instanceof Ram)
			{
				cantRam++;
			}			
			if(ventas.getComponente().get(i) instanceof Motherboard)
			{
				cantMotherboard++;
			}
			if(ventas.getComponente().get(i) instanceof Procesador)
			{
				cantCPU++;
			}
			if(ventas.getComponente().get(i) instanceof DiscoDuro)
			{
				cantHDD++;
			}
		}
		for(int i = 0; i< ventas.getKits().size() ;i++)
		{
			cantKits++;
			//Ya que los kits incluyen obligatoriamente todos estos componentes
			cantRam++;
			cantMotherboard++;
			cantCPU++;
			cantHDD++;
		}
	}
}
