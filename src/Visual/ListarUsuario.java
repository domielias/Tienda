package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Administrador;
import Logico.Tienda;
import Logico.Vendedor;

import javax.swing.JLayeredPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ListarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JButton btnModificar;
	private JButton btnCancelar;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String selecte = ""; 
	private JButton btnDeshabilitar;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the dialog.
	 */
	public ListarUsuario(int n) {
		setBounds(100, 100, 627, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		try {
			Tienda.getInstance().cargarDatos();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		contentPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = table.getSelectedRow();
				if(index>=0){
					btnDeshabilitar.setEnabled(true);
					btnModificar.setEnabled(true);
					selecte = table.getValueAt(index, 0).toString();
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		model = new DefaultTableModel();
		scrollPane.setViewportView(table);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnDeshabilitar = new JButton("Deshabilitar");
				btnDeshabilitar.setEnabled(false);
				buttonPane.add(btnDeshabilitar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				btnCancelar = new JButton("Cancel");
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
		if(n==1) {
			loadAdministrador();
			setTitle("Listar Administradores");
		}
		else if (n==2) {
			loadVendedor();
			setTitle("Listar Vendedores");
		}
		else if (n==3) {
			loadCliente();
			setTitle("Listar Clientes");
		}
		else if(n==4) {
			loadProveedor();
			setTitle("Listar Proveedores");
		}
	}
	private void tablaAdministrador() {
		String[] columnNames = {"ID","Nombre","Cedula","Dirección","Telefono","Usuario"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void tablaVendedor() {
		String[] columnNames = {"ID","Nombre","Cedula","Dirección","Telefono","Usuario","Cant. Ventas"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void tablaCliente() {
		String[] columnNames = {"ID","Nombre","Cedula","Dirección","Telefono"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void tablaProveedor() {
		String[] columnNames = {"ID","Nombre","Cedula","Dirección","Telefono","Componente"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void loadAdministrador() {
		tablaAdministrador();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			if(Tienda.getInstance().getUsuarios().get(i) instanceof Administrador) {
				fila[0]= Tienda.getInstance().getUsuarios().get(i).getId();
				fila[1]=Tienda.getInstance().getUsuarios().get(i).getNombre();
				fila[2]=Tienda.getInstance().getUsuarios().get(i).getCedula();
				fila[3]=Tienda.getInstance().getUsuarios().get(i).getDireccion();
				fila[4]=Tienda.getInstance().getUsuarios().get(i).getTelefono();
				fila[5]=Tienda.getInstance().getUsuarios().get(i).getUsuario();
				model.addRow(fila);
			}
		}
	}
	private void loadVendedor() {
		tablaVendedor();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			if(Tienda.getInstance().getUsuarios().get(i) instanceof Vendedor) {
				fila[0]= Tienda.getInstance().getUsuarios().get(i).getId();
				fila[1]= Tienda.getInstance().getUsuarios().get(i).getNombre();
				fila[2]=Tienda.getInstance().getUsuarios().get(i).getCedula();
				fila[3]=Tienda.getInstance().getUsuarios().get(i).getDireccion();
				fila[4]=Tienda.getInstance().getUsuarios().get(i).getTelefono();
				fila[5]=Tienda.getInstance().getUsuarios().get(i).getUsuario();
				Vendedor vende=(Vendedor)Tienda.getInstance().getUsuarios().get(i);
				fila[6]=vende.getCantventas();
				model.addRow(fila);
			}
		}
	}
	private void loadCliente() {
		tablaCliente();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getClientes().size(); i++) {
			fila[0]=Tienda.getInstance().getClientes().get(i).getId();
			fila[1]=Tienda.getInstance().getClientes().get(i).getNombre();
			fila[2]=Tienda.getInstance().getClientes().get(i).getCedula();
			fila[3]=Tienda.getInstance().getClientes().get(i).getDireccion();
			fila[4]=Tienda.getInstance().getClientes().get(i).getTelefono();
			model.addRow(fila);
		}
	}
	private void loadProveedor() {
		tablaProveedor();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
			for (int j = 0; j < Tienda.getInstance().getProveedores().get(i).getComponente().size(); j++) {
				fila[0]=Tienda.getInstance().getProveedores().get(i).getId();
				fila[1]=Tienda.getInstance().getProveedores().get(i).getNombre();
				fila[2]=Tienda.getInstance().getProveedores().get(i).getCedula();
				fila[3]=Tienda.getInstance().getProveedores().get(i).getDireccion();
				fila[4]=Tienda.getInstance().getProveedores().get(i).getTelefono();
				fila[5]=Tienda.getInstance().getProveedores().get(i).getComponente().get(j);
				model.addRow(fila);
			}
		}
	}
}
