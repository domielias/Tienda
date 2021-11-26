package Logico;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;






public class Tienda implements Serializable{

	private ArrayList<Componente> componentes;
	private ArrayList<Cliente> clientes;
	private ArrayList<Factura> facturas;
	private ArrayList<Kit> kits;
	private ArrayList<Usuario> usuarios;
	private ArrayList<Proveedor> proveedores;
	private ArrayList<Ventas> ventas;
	private static ArrayList<Meses> meses;
	private static Meses mesActual;	
	private String nombre;
	private static Tienda tienda;
	private ArrayList<Ordenes> ordenes;
	private Tienda() {
		super();
		ventas= new ArrayList<Ventas>();
		componentes = new ArrayList<Componente>();
		clientes = new ArrayList<Cliente>();
		facturas = new ArrayList<Factura>();
		usuarios = new ArrayList<Usuario>();
		kits = new ArrayList<Kit>();
		proveedores = new ArrayList<Proveedor>();
		meses = new ArrayList<Meses>();
		mesActual = new Meses();
		ordenes= new ArrayList<Ordenes>();

		// Funciones Extra
		mesActual.setMes(tiempoActual());
		insertarNombre("DY-Computer's");
		Administrador defecto = new Administrador("default", "default", "default", "default", "admin", "admin", asignarIdUsuario());
		insertarAdministrador(defecto);
		Vendedor vendedor= new Vendedor("default", "default", "default", "default", "vende", "vende", asignarIdUsuario());
		insertarVendedor(vendedor);
	}
	public static Tienda getInstance() {
		if (tienda != null) {
			if (tiempoActual() != mesActual.getMes()) {
				Meses miMes = new Meses();
				miMes.setMes(tiempoActual());
				meses.add(miMes);
				mesActual.setMes(tiempoActual());
			}
		}

		if (tienda == null) {
			tienda = new Tienda();
		}
		return tienda;
	}
	public void insertarAdministrador(Administrador admin) {
		usuarios.add(admin);
	}
	public void insertarsVentas(Ventas ventas) {
		this.ventas.add(ventas);
	}
	public void insertarVendedor(Vendedor vendedor) {
		usuarios.add(vendedor);
	}
	public void insertarComponentes(Componente componentes) {
		this.componentes.add(componentes);
	}
	public void insertarCliente(Cliente clientes) {
		this.clientes.add(clientes);
	}
	public void insertarFacturas(Factura facturas) {
		this.facturas.add(facturas);
	}
	public void insertarKits(Kit kits) {
		this.kits.add(kits);
	}
	public void insertarProveedores(Proveedor proveedores) {
		this.proveedores.add(proveedores);
	}
	public void insertarOrdenes(Ordenes ordenes) {
		this.ordenes.add(ordenes);
	}
	public ArrayList<Ordenes> getOrdenes() {
		return ordenes;
	}
	public static void setMeses(ArrayList<Meses> meses) {
		Tienda.meses = meses;
	}
	public static void setMesActual(Meses mesActual) {
		Tienda.mesActual = mesActual;
	}
	public void insertarNombre(String nombre) {
		this.nombre = nombre;
	}
	public static void setTienda(Tienda tienda) {
		Tienda.tienda = tienda;
	}
	public ArrayList<Componente> getComponentes() {
		return componentes;
	}
	public ArrayList<Ventas> getVentas() {
		return ventas;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public ArrayList<Factura> getFacturas() {
		return facturas;
	}
	public ArrayList<Kit> getKits() {
		return kits;
	}
	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}
	public ArrayList<Proveedor> getProveedores() {
		return proveedores;
	}
	public static ArrayList<Meses> getMeses() {
		return meses;
	}
	public static Meses getMesActual() {
		return mesActual;
	}
	public String getNombre() {
		return nombre;
	}
	public static Tienda getTienda() {
		return tienda;
	}
	//Metodos
	public String asignarIdCliente() {

		String idConCeros = String.format("%06d", (clientes.size() + 1));

		return idConCeros;

	}
	public String asignarIdUsuario() {

		String idConCeros = String.format("%04d", (usuarios.size() + 1));

		return idConCeros;

	}
	public String asignarIdProveedor() {

		String idConCeros = String.format("%04d", (proveedores.size() + 1));

		return idConCeros;

	}
	public String asignarFactura() {
		Date fechaActual= new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");  
	    String strDate = formatter.format(fechaActual);  
		String idConCeros = strDate+facturas.size()+1;
		return idConCeros;

	}

	public String asignarSerial() {

		String idConCeros = String.format("%010d", (componentes.size() + 1));

		return idConCeros;

	}

	public String asignarIdKit() {

		String idConCeros = String.format("%04d", (kits.size() + 1));

		return idConCeros;

	}
	public void guardarDatos() throws IOException, ClassNotFoundException {

		String url = urlEjecutable();

		new File(url).mkdir();

		FileOutputStream foTienda = new FileOutputStream(url + "//MisDatos.dat");
		ObjectOutputStream oosTienda = new ObjectOutputStream(foTienda);

		oosTienda.writeObject(tienda);

		foTienda.close();

	}

	public void cargarDatos() throws IOException, ClassNotFoundException {

		String url = urlEjecutable();

		FileInputStream fiTienda = new FileInputStream(url + "//MisDatos.dat");
		ObjectInputStream oisTienda = new ObjectInputStream(fiTienda);

		tienda = (Tienda) oisTienda.readObject();
		fiTienda.close();

	}

	public String urlEjecutable() {

		// Crea el String del link hacia el folder "Tienda" en 'Mis Documentos'
		String url = new JFileChooser().getFileSystemView().getDefaultDirectory().toString() + "//Tiendas";

		return url;

	}
	public static String tiempoActual() {
		Date date = new Date();
		LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		int month = localDate.getMonthValue();
		int year = localDate.getYear();

		String tiempoActual = new String(month + "-" + year);

		return tiempoActual;
	}
	public int indexCliente(String cedula) {
		boolean encontrado = false;
		int i = 0;
		while (!encontrado && i < clientes.size()) {
			if (clientes.get(i).getCedula().equals(cedula)) {
				encontrado = true;
			}
			i++;
		}
		return i;
	}
	public int calcRam() {
		int cant = 0;
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Ram)
				cant += componentes.get(i).getCantidad();
		}
		return cant;
	}
	public int calcMotherBoard() {
		int cant = 0;
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Motherboard)
				cant += componentes.get(i).getCantidad();
		}
		return cant;
	}
	public int calcCPU() {
		int cant = 0;
		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof Procesador)
				cant += componentes.get(i).getCantidad();
		}

		return cant;

	}
	public int calcHDD() {

		int cant = 0;

		for (int i = 0; i < componentes.size(); i++) {
			if (componentes.get(i) instanceof DiscoDuro)
				cant += componentes.get(i).getCantidad();
		}

		return cant;
	}
	public int calcKits() {
		int cant = 0;

		for (int i = 0; i < kits.size(); i++) {
			cant += kits.get(i).getCantidad();
		}

		return cant;
	}
	public int indexUsuario(String id) {

		int index = 0;
		boolean encontrado = false;
		while (!encontrado && index < usuarios.size()) {
			if (usuarios.get(index).getId().equalsIgnoreCase(id)) {
				return index;
			}
			index++;
		}

		return -1;

	}
	public Cliente buscarCliente(String selecte) {
		Cliente client=null;
		for (int i = 0; i < Tienda.getInstance().getClientes().size(); i++) {
			if(Tienda.getInstance().getClientes().get(i).getCedula().equalsIgnoreCase(selecte)) {
				client=Tienda.getInstance().getClientes().get(i);
			}
		}
		return client;
	}
	public Usuario buscarUsuario(String cedula) {
		Usuario user=null;
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			if(Tienda.getInstance().getUsuarios().get(i).getCedula().equalsIgnoreCase(cedula)) {
				user=Tienda.getInstance().getUsuarios().get(i);
			}
		}
		return user;
	}
	public Proveedor buscarProveedor(String cedula) {
		Proveedor prove=null;
		for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
			if(Tienda.getInstance().getProveedores().get(i).getCedula().equalsIgnoreCase(cedula)) {
				prove=Tienda.getInstance().getProveedores().get(i);
			}
		}
		return prove;
	}
	public boolean existeProveedorConComponente(Proveedor prove,String componente) {
		boolean existe=false;
		for (int i = 0; i < prove.getComponente().size(); i++) {
			if(prove.getComponente().get(i).equalsIgnoreCase(componente)) {
				existe=true;
			}
		}
		return existe;
	}
	public void generarFactura(Factura factura) {
//		File archivo= new File(Tienda.getInstance().urlEjecutable()+"//MisDatos.dat");
//		FileInputStream re;
//		try {
//			re = new FileInputStream(archivo);
//			ObjectInputStream read = new ObjectInputStream(re);
//			factura= (Factura) read.readObject();
//			read.close();
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Date fechaActual=factura.getFecha();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	    String strDate = formatter.format(fechaActual);  
		System.out.println("Problema");
		File arch= new File(Tienda.getInstance().urlEjecutable()+"//"+factura.getId()+".txt");
		FileWriter escribir;
		try {
			escribir= new FileWriter(arch);
			BufferedWriter escribiendo= new BufferedWriter(escribir);
			escribiendo.write("\t"+"Tienda"+Tienda.getInstance().getNombre());
			escribiendo.newLine();
			escribiendo.write("Factura #: "+factura.getId());
			escribiendo.newLine();
			escribiendo.newLine();
			escribiendo.write("Cliente:");
			escribiendo.write("\t"+factura.getCliente().getNombre());
			escribiendo.newLine();
			escribiendo.write("Vendedor:");
			escribiendo.write("\t"+factura.getVendedor().getNombre());
			escribiendo.newLine();
			escribiendo.newLine();
			escribiendo.write("Cantidad de componentes: "+String.valueOf((factura.getCompra().size()+cantidadKit(factura.getCompraK()))));
			escribiendo.newLine();
			escribiendo.newLine();
			escribiendo.write("Cantidad");
			escribiendo.write("\tMarca");
			escribiendo.write("\tmodelo");
			escribiendo.write("\tPrecio");
			escribiendo.newLine();
			int cantidad=0;
			for (int i = 0; i < factura.getCompra().size(); i++) {
				escribiendo.write(String.valueOf(factura.getCompra().get(i).getCantidad()));
				escribiendo.write("\t"+factura.getCompra().get(i).getMarca());
				escribiendo.write("\t"+factura.getCompra().get(i).getModelo());
				escribiendo.write("\t"+String.valueOf(factura.getCompra().get(i).getPrecioVenta()));
				escribiendo.newLine();
				cantidad+=factura.getCompra().get(i).getCantidad();
			}
			for(int i=0;i<cantidadKit(factura.getCompraK());i++) {
				for (int j = 0; j < factura.getCompraK().get(i).getComponentes().size(); j++) {
					escribiendo.write(String.valueOf(factura.getCompraK().get(i).getComponentes().get(i).getCantidad()));
					escribiendo.write("\t"+factura.getCompraK().get(i).getComponentes().get(i).getMarca());
					escribiendo.write("\t"+factura.getCompraK().get(i).getComponentes().get(i).getModelo());
					escribiendo.write("\t"+String.valueOf(factura.getCompraK().get(i).getComponentes().get(i).getPrecioCompra()));
					escribiendo.newLine();
					cantidad+=factura.getCompraK().get(i).getCantidad();
				}
			}
			escribiendo.newLine();
			escribiendo.write("Precio Total: "+String.valueOf(factura.getPrecioTotal()));
			escribiendo.newLine();
			escribiendo.newLine();
			escribiendo.write("En "+Tienda.getInstance().getNombre()+"le deseamos un Feliz Año nuevo");
			escribiendo.close();
			escribir.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public int cantidadKit(ArrayList<Kit> kits) {
		int ind=0;
		int cant=0;
		while(ind<kits.size()) {
			cant=kits.get(ind).getComponentes().size();
			ind++;
		}
		return cant;
	}

}
