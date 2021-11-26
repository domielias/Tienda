package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Componente;
import Logico.DiscoDuro;
import Logico.Motherboard;
import Logico.Procesador;
import Logico.Ram;
import Logico.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ListarProductos extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String selecte = ""; 

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ListarProductos dialog = new ListarProductos();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ListarProductos(int n) {
		try {
			Tienda.getInstance().cargarDatos();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		setBounds(100, 100, 700, 640);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
				model = new DefaultTableModel();
				


				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int index = table.getSelectedRow();
						if(index>=0){
//							btnDeshabilitar.setEnabled(true);
//							btnModificar.setEnabled(true);
							selecte = table.getValueAt(index, 0).toString();
						}
					}
				});
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("A\u00F1adir");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cerrar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		if(n==1) {
			loadMotherBoard();	
			setTitle("Listar Motherboard");
		}
		else if(n==2) {
			loadProcesador();
			setTitle("Listar Procesador");
		}
		else if(n==3) {
			loadMemoriaRam();
			setTitle("Listar Memoria Ram");
		}
		else if(n==4) {
			loadDiscoduro();
			setTitle("Listar Disco Duro");
		}
		else if(n==5) {
			loadKit();
			setTitle("Listar Kits");
		}
	}
	public void loadMotherBoard() {
		tablaMotherBoard();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof Motherboard) {
				//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Socket","Ram","Puerto"
				fila[0]=Tienda.getInstance().getComponentes().get(i).getNumeroSerie();
				fila[1]=Tienda.getInstance().getComponentes().get(i).getMarca();
				fila[2]=Tienda.getInstance().getComponentes().get(i).getModelo();
				fila[3]=Tienda.getInstance().getComponentes().get(i).getPrecioCompra();
				fila[4]=Tienda.getInstance().getComponentes().get(i).getPrecioVenta();
				fila[5]=Tienda.getInstance().getComponentes().get(i).getProveedor().getNombre();
				fila[6]=Tienda.getInstance().getComponentes().get(i).getCantidad();
				Motherboard mother= (Motherboard)Tienda.getInstance().getComponentes().get(i);
				fila[7]=mother.getSocket();
				fila[8]=mother.getRam();
				fila[9]=mother.getTipoHDD();
				model.addRow(fila);
			}
		}
	}
	public void loadProcesador() {
		tablaProcesador();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Socket","Velocidad"
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof Procesador) {
				fila[0]=Tienda.getInstance().getComponentes().get(i).getNumeroSerie();
				fila[1]=Tienda.getInstance().getComponentes().get(i).getMarca();
				fila[2]=Tienda.getInstance().getComponentes().get(i).getModelo();
				fila[3]=Tienda.getInstance().getComponentes().get(i).getPrecioCompra();
				fila[4]=Tienda.getInstance().getComponentes().get(i).getPrecioVenta();
				fila[5]=Tienda.getInstance().getComponentes().get(i).getProveedor().getNombre();
				fila[6]=Tienda.getInstance().getComponentes().get(i).getCantidad();
				Procesador proce= (Procesador) Tienda.getInstance().getComponentes().get(i);
				fila[7]=proce.getSocket();
				fila[8]=proce.getVelocidad();
				model.addRow(fila);
			}
		}
	}
	public void loadMemoriaRam() {
		tablaMemoriaRam();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof Ram) {
				fila[0]=Tienda.getInstance().getComponentes().get(i).getNumeroSerie();
				fila[1]=Tienda.getInstance().getComponentes().get(i).getMarca();
				fila[2]=Tienda.getInstance().getComponentes().get(i).getModelo();
				fila[3]=Tienda.getInstance().getComponentes().get(i).getPrecioCompra();
				fila[4]=Tienda.getInstance().getComponentes().get(i).getPrecioVenta();
				fila[5]=Tienda.getInstance().getComponentes().get(i).getProveedor().getNombre();
				fila[6]=Tienda.getInstance().getComponentes().get(i).getCantidad();
				//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Capacidad","Tipo de memoria"
				Ram ram=(Ram)Tienda.getInstance().getComponentes().get(i);
				fila[7]=ram.getMemoria();
				fila[8]=ram.getTipo();
				model.addRow(fila);
			}
		}
	}
	public void loadDiscoduro() {
		tablaDiscoDuro();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof DiscoDuro) {
				fila[0]=Tienda.getInstance().getComponentes().get(i).getNumeroSerie();
				fila[1]=Tienda.getInstance().getComponentes().get(i).getMarca();
				fila[2]=Tienda.getInstance().getComponentes().get(i).getModelo();
				fila[3]=Tienda.getInstance().getComponentes().get(i).getPrecioCompra();
				fila[4]=Tienda.getInstance().getComponentes().get(i).getPrecioVenta();
				fila[5]=Tienda.getInstance().getComponentes().get(i).getProveedor().getNombre();
				fila[6]=Tienda.getInstance().getComponentes().get(i).getCantidad();
				//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Capacidad","Tipo de conexíon"
				DiscoDuro disco= (DiscoDuro) Tienda.getInstance().getComponentes().get(i);
				fila[7]=disco.getCapacidad();
				fila[8]=disco.getConexion();
				model.addRow(fila);
			}
		}
		
	}
	private void loadKit() {
		tablaKit();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getKits().size(); i++) {
			fila[0]=Tienda.getInstance().getKits().get(i).getId();
			fila[1]=Tienda.getInstance().getKits().get(i).getNombre();
			fila[2]=Tienda.getInstance().getKits().get(i).getCantidad();
			fila[3]=Tienda.getInstance().getKits().get(i).getPrecioFinal();
			model.addRow(fila);
		}
	}
	private void tablaMotherBoard() {
		String[] columnNames = {"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Socket","Ram","Puerto"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void tablaProcesador() {
		String[] columnNames = {"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Socket","Velocidad"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void tablaMemoriaRam() {
		String[] columnNames = {"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Capacidad","Tipo de memoria"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void tablaDiscoDuro() {
		String[] columnNames = {"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Capacidad","Tipo de conexión"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void tablaKit() {
		String[] columnNames = {"Id","Nombre","Cantidad","Precio final"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	
}
