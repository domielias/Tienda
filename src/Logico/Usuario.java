package Logico;

import java.io.Serializable;

public abstract class Usuario extends Persona implements Serializable{

	protected String usuario;
	protected String clave;
	protected String id;
	protected boolean habilitado;
	protected boolean conexion;
	public Usuario(String nombre, String cedula, String direccion, String telefono, String usuario, String clave,
			String id) {
		super(nombre, cedula, direccion, telefono);
		this.usuario = usuario;
		this.clave = clave;
		this.id = id;
		habilitado=true;
		conexion=false;
	}
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String nombre) {
		this.usuario = nombre;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getId() {
		return id;
	}
	public boolean isHabilitado() {
		return habilitado;
	}
	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public boolean isConexion() {
		return conexion;
	}
	public void setConexion(boolean conexion) {
		this.conexion = conexion;
	}
	

}
