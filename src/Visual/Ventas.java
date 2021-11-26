package Visual;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;

import Logico.Cliente;
import Logico.Componente;
import Logico.DiscoDuro;
import Logico.Factura;
import Logico.Kit;
import Logico.Motherboard;
import Logico.Procesador;
import Logico.Ram;
import Logico.Tienda;
import Logico.Vendedor;

import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class Ventas extends JDialog {
	private JComboBox cbxComponente;
	private Cliente cliente;
	private Vendedor vendedor;
	private DefaultListModel listaComponentes;
	private DefaultListModel listaComponentesDeseados;
	private JButton btnBuscarCliente;
	private JFormattedTextField txtCliente;
	private JList listComponentesDeseados;
	private JLabel lbCliente;
	private JList listComponentes;
	private JSpinner spnPrecioTotal;
	private JLabel lbVendedor;
	private JPanel panelVenta;
	private JSpinner spnCantidadComponentes;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventas dialog = new Ventas();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Ventas() {
		setTitle("Facturacion");
		setBounds(100, 100, 785, 667);
		getContentPane().setBackground(Color.decode("#4B5F83"));
		getContentPane().setLayout(null);
		try {
			Tienda.getInstance().cargarDatos();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		vendedorVenta();
		panelVenta = new JPanel();
		panelVenta.setVisible(false);
		panelVenta.setBounds(10, 102, 756, 521);
		panelVenta.setBackground(Color.decode("#4B5F83"));
		getContentPane().add(panelVenta);
		panelVenta.setLayout(null);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(116, 29, 46, 14);
		lblCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lblCliente);
		
		lbCliente = new JLabel("Ninguno");
		lbCliente.setBounds(172, 26, 68, 20);
		lbCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lbCliente);
		
		cbxComponente = new JComboBox();
		cbxComponente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cbxComponente.getSelectedIndex()==0) { //Ejemplo de como se pondra cuando seleccione el componente
					JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
					loadMotherboard();
				}
				if(cbxComponente.getSelectedIndex()==1) { 
					loadProcesador();
				}
				if(cbxComponente.getSelectedIndex()==2) { 
					loadMemoriaRam();
				}
				if(cbxComponente.getSelectedIndex()==3) { 
					loadDiscoDuro();
				}
				if(cbxComponente.getSelectedIndex()==4) { 
					loadKit();
				}
			}
		});
		cbxComponente.setModel(new DefaultComboBoxModel(new String[] {"Motherboard", "Procesador", "Memoria Ram", "Disco Duro", "Kits"}));
		cbxComponente.setBounds(66, 87, 115, 20);
		cbxComponente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelVenta.add(cbxComponente);
		
		JLabel lblSeleccioneElComponente = new JLabel("Seleccione el componente:");
		lblSeleccioneElComponente.setBounds(31, 70, 219, 14);
		lblSeleccioneElComponente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lblSeleccioneElComponente);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 118, 215, 206);
		panelVenta.add(scrollPane);

		listaComponentes= new DefaultListModel();
		listComponentes = new JList(listaComponentes);
		listComponentes.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		listComponentes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(listComponentes);
		
		JButton btnVender = new JButton("-------->");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String vender="vender";
				if(listComponentes.getSelectedValue() instanceof Kit) {
					venta(vender,null,(Kit)listComponentes.getSelectedValue());
				}
				else if(listComponentes.getSelectedValue() instanceof Componente) {
					venta(vender,(Componente)listComponentes.getSelectedValue(),null);
				}
			}
		});
		btnVender.setBounds(302, 180, 89, 23);
		panelVenta.add(btnVender);
		
		JButton btnDevolver = new JButton("<--------");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String devolver="devolver";
				if(listComponentes.getSelectedValue() instanceof Kit) {
					venta(devolver,null,(Kit)listComponentesDeseados.getSelectedValue());
				}
				else if(listComponentes.getSelectedValue() instanceof Componente) {
					venta(devolver,(Componente)listComponentesDeseados.getSelectedValue(),null);
				}
			}
		});
		btnDevolver.setBounds(302, 250, 89, 23);
		panelVenta.add(btnDevolver	);
		
		JLabel lblDevolver = new JLabel("Devolver");
		lblDevolver.setBounds(316, 236, 62, 14);
		lblDevolver.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lblDevolver);
		
		JLabel lblPasar = new JLabel("Pasar");
		lblPasar.setBounds(332, 165, 46, 14);
		lblPasar.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lblPasar);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(470, 118, 215, 206);
		panelVenta.add(scrollPane_1);
		
		listaComponentesDeseados= new DefaultListModel();
		listComponentesDeseados = new JList(listaComponentesDeseados);
		listComponentesDeseados.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		listComponentesDeseados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(listComponentesDeseados);
		
		JLabel lblCantidadDeComponentes = new JLabel("Cantidad:");
		lblCantidadDeComponentes.setBounds(547, 407, 81, 14);
		lblCantidadDeComponentes.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lblCantidadDeComponentes);
		
		JLabel lblPrecio = new JLabel("Precio Total:");
		lblPrecio.setBounds(547, 432, 88, 14);
		lblPrecio.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lblPrecio);
		
		JButton btnProcesarCompra = new JButton("Procesar Compra");
		btnProcesarCompra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult =JOptionPane.showConfirmDialog(null, "¿Esta seguro de haber completado la venta?", "Información",JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					actualizarTienda();
				}
				else if(dialogResult==JOptionPane.NO_OPTION) {
					return;
				}
			}
		});
		btnProcesarCompra.setBounds(525, 477, 115, 23);
		panelVenta.add(btnProcesarCompra);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult =JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar sin completar la venta?", "Información",JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					dispose();
				}
				else if(dialogResult==JOptionPane.NO_OPTION) {
					return;
				}
			}
		});
		btnCancelar.setBounds(653, 477, 81, 23);
		panelVenta.add(btnCancelar);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setBounds(483, 29, 68, 14);
		lblVendedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lblVendedor);
		
		lbVendedor = new JLabel("Ninguno");
		lbVendedor.setBounds(561, 29, 72, 14);
		lbVendedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVenta.add(lbVendedor);
		
		spnCantidadComponentes = new JSpinner();
		spnCantidadComponentes.setModel(new SpinnerNumberModel(new Integer(0), null, null, new Integer(1)));
		spnCantidadComponentes.setEnabled(false);
		spnCantidadComponentes.setBounds(643, 404, 81, 20);
		spnCantidadComponentes.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelVenta.add(spnCantidadComponentes);
		
		spnPrecioTotal = new JSpinner();
		spnPrecioTotal.setEnabled(false);
		spnPrecioTotal.setModel(new SpinnerNumberModel(new Double(0), null, null, new Double(1)));
		spnPrecioTotal.setBounds(643, 429, 81, 20);
		spnPrecioTotal.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelVenta.add(spnPrecioTotal);
		
		btnBuscarCliente = new JButton("Buscar");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cliente= Tienda.getInstance().buscarCliente(txtCliente.getText());
				if(cliente!=null) {
					lbCliente.setText(cliente.getNombre());
					lbVendedor.setText(vendedor.getNombre());
					loadMotherboard();
					panelVenta.setVisible(true);
				}
				else if (cliente==null) {
					int dialogResult =JOptionPane.showConfirmDialog(null, "No se encontro cliente, desea crearlo?", "Información",JOptionPane.YES_NO_OPTION);
					if(dialogResult==JOptionPane.YES_OPTION) {
						Registrar reg= new Registrar(3);
						reg.setModal(true);
						reg.setVisible(true);
					}
					else if(dialogResult==JOptionPane.NO_OPTION) {
						return;
					}

				}
			}
		});
		btnBuscarCliente.setBounds(249, 52, 89, 23);
		getContentPane().add(btnBuscarCliente);
		
		JLabel lblVentas = new JLabel("Facturación");
		lblVentas.setBounds(322, 11, 89, 24);
		lblVentas.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 16));
		getContentPane().add(lblVentas);
		
		try {
			txtCliente = new JFormattedTextField(new MaskFormatter("###-#######-#"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCliente.setBounds(132, 53, 89, 20);
		txtCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		getContentPane().add(txtCliente);

	}
	private void loadMotherboard() {
		listaComponentes.clear();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof Motherboard &&
			Tienda.getInstance().getComponentes().get(i).getCantidad()>Tienda.getInstance().getComponentes().get(i).getStockMinimo()) {
				listaComponentes.addElement(Tienda.getInstance().getComponentes().get(i));
			}
		}
	}
	private void loadProcesador() {
		listaComponentes.clear();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if (Tienda.getInstance().getComponentes().get(i) instanceof Procesador && 
			Tienda.getInstance().getComponentes().get(i).getCantidad()>Tienda.getInstance().getComponentes().get(i).getStockMinimo()) {
				listaComponentes.addElement(Tienda.getInstance().getComponentes().get(i));
			}
			
		}
	}
	private void loadMemoriaRam() {
		listaComponentes.clear();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if (Tienda.getInstance().getComponentes().get(i) instanceof Ram &&
			Tienda.getInstance().getComponentes().get(i).getCantidad()>Tienda.getInstance().getComponentes().get(i).getStockMinimo()) {
				listaComponentes.addElement(Tienda.getInstance().getComponentes().get(i));
			}
		}
	}
	private void loadDiscoDuro() {
		listaComponentes.clear();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof DiscoDuro && 
			Tienda.getInstance().getComponentes().get(i).getCantidad()>Tienda.getInstance().getComponentes().get(i).getStockMinimo()) {
				listaComponentes.addElement(Tienda.getInstance().getComponentes().get(i));
			}
		}
	}
	private void loadKit() {
		listaComponentes.clear();
		for (int i = 0; i < Tienda.getInstance().getKits().size(); i++) {
			//if(Tienda.getInstance().getKits().get(i).getCantidad()>
		//	Tienda.getInstance().getComponentes().get(i).getStockMinimo()) {
				listaComponentes.addElement(Tienda.getInstance().getKits().get(i));	
			//}
		}
	}
	private void vendedorVenta() {
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			if(Tienda.getInstance().getUsuarios().get(i) instanceof Vendedor && 
			Tienda.getInstance().getUsuarios().get(i).isConexion()==true) {
				vendedor=(Vendedor)Tienda.getInstance().getUsuarios().get(i);
			}
		}
	}
	private void venta(String accion,Componente compo, Kit kit) {
		if(accion=="vender" && compo!=null) {
			compo.setCantidad(compo.getCantidad()-1);
			if(listaComponentesDeseados.indexOf(compo)==-1) {
				listaComponentesDeseados.addElement(compo);
			}
			if(compo.getCantidad()<=compo.getStockMinimo()) {
				listaComponentes.removeElement(compo);
				int dialogResult =JOptionPane.showConfirmDialog(null, "Producto escaso, desea ordenar más de este producto?", "Información",JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					Ordenar ordenar= new Ordenar();
					ordenar.setVisible(true);
				}
				else if(dialogResult==JOptionPane.NO_OPTION) {
					return;
				}
			}
			actualizarPrecios();
			actualizarCantidad();
		}
		else if (accion=="vender" && kit!=null) {
			kit.setCantidad(kit.getCantidad()-1);
			if(listaComponentesDeseados.indexOf(kit)==-1) {
				listaComponentesDeseados.addElement(kit);
			}
			actualizarPrecios();
			actualizarCantidad();
		}
		else if(accion=="devolver" && compo!=null ) {
			if(listaComponentes.indexOf(compo)==-1) {
				compo.setCantidad(compo.getCantidad()+1);
				listaComponentes.addElement(compo);
			}
			listaComponentesDeseados.removeElement(compo);
			compo.setCantidad(compo.getCantidad()+1);

			/*if(compo.getCantidad()<=compo.getStockMinimo()) {
				listaComponentesDeseados.removeElement(compo);
			}*/
			actualizarPrecios();
			actualizarCantidad();
		}
		else if(accion=="devolver" && kit!=null) {
			if(listaComponentes.indexOf(kit)==-1) {
				compo.setCantidad(compo.getCantidad()+1);
				listaComponentes.addElement(kit);
			}
			listaComponentesDeseados.removeElement(kit);
//			compo.setCantidad(compo.getCantidad()+1); //Eror 
			actualizarPrecios();
			actualizarCantidad();
		}
	}
	private void venderCompo(Componente compo) {
		
	}
	private void venderKit(Kit kit) {
		
	}
	private void actualizarPrecios() {
		double precio=0.00;
		ArrayList<Componente> compo= new ArrayList<>();
		ArrayList<Kit> kit= new ArrayList<>();
		for (int i = 0; i < listaComponentesDeseados.size(); i++) {
			if(listaComponentesDeseados.get(i) instanceof Componente) {
				compo.add((Componente)listaComponentesDeseados.get(i));
				precio+=compo.get(i).getPrecioVenta();
			}
			else if (listaComponentesDeseados.get(i) instanceof Kit){
				kit.add((Kit)listaComponentesDeseados.get(i));
				precio+=kit.get(i).getPrecioFinal(); ///Error
			}
		}
		spnPrecioTotal.setValue(precio);
	}
	private void actualizarCantidad() {
		int cantidad=0;
		cantidad= listaComponentesDeseados.size();
		spnCantidadComponentes.setValue(cantidad);
	}
	private void actualizarTienda() {
		ArrayList<Kit> kit= new ArrayList<>();
		ArrayList<Componente> comp=new ArrayList<>();
		Logico.Ventas venta= new Logico.Ventas();
		for (int i = 0; i < listaComponentesDeseados.size(); i++) {
			if(listaComponentesDeseados.get(i) instanceof Componente) {
				for (int j = 0; j < Tienda.getInstance().getComponentes().size(); j++) {
					if(listaComponentesDeseados.get(i)== Tienda.getInstance().getComponentes().get(j)) {
						comp.add((Componente)listaComponentesDeseados.get(i));
						Tienda.getInstance().getComponentes().get(j).setCantidad(Tienda.getInstance().getComponentes().get(j).getCantidad()-1);
					}
				}
			}
			else if(listaComponentesDeseados.get(i) instanceof Kit){
				for (int j = 0; j < Tienda.getInstance().getKits().size(); j++) {
					if(listaComponentesDeseados.get(i)== Tienda.getInstance().getComponentes().get(j)) {
						kit.add((Kit)listaComponentesDeseados.get(i));
						Tienda.getInstance().getKits().get(j).setCantidad(Tienda.getInstance().getKits().get(j).getCantidad()-1);
					}
				}
			}
		}
		vendedor.incrementarVenta();
		venta.AgregarComponente(comp);
		venta.AgregarKits(kit);
		Date date= new Date();
		double precioTotal=(double)spnPrecioTotal.getValue();
		Factura factu= new Factura(precioTotal, cliente, vendedor,date, Tienda.getInstance().asignarFactura());
		factu.insertarCompra(comp);
		factu.insertarCompraK(kit);
		Tienda.getInstance().insertarFacturas(factu);
		Tienda.getInstance().insertarsVentas(venta);
		Tienda.getInstance().generarFactura(factu);
		try {
			Tienda.getInstance().guardarDatos();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		txtCliente.setValue("");
		panelVenta.setVisible(false);
		listaComponentesDeseados.removeAllElements();
		spnPrecioTotal.setValue(0);
		spnCantidadComponentes.setValue(0);
		cbxComponente.setSelectedIndex(0);
		lbCliente.setText("");
		
	}
}
