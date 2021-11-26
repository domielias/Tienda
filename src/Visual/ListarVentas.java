package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Procesador;
import Logico.Tienda;
import Logico.Vendedor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarVentas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private Vendedor vendedor;
	private static DefaultTableModel model;
	private static Object[] fila;
	private String selecte = ""; 

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			ListarVentas dialog = new ListarVentas();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public ListarVentas() {
		setTitle("Listar Ventas");
		setBounds(100, 100, 492, 337);
		try {
			Tienda.getInstance().cargarDatos();
		} catch (ClassNotFoundException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		vendedorVenta();
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				table.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
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
				model= new DefaultTableModel();
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		loadVentas();
	}
	private void loadVentas() {
		tablaVentas();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		System.out.println(vendedor);
		System.out.println(vendedor.getUsuario());
		for (int i = 0; i < Tienda.getInstance().getFacturas().size(); i++) {
			if(Tienda.getInstance().getFacturas().get(i).getVendedor().equals(vendedor)) {
				if(Tienda.getInstance().getFacturas().get(i).getCompra()!=null) {
					for (int j = 0; j <= Tienda.getInstance().getFacturas().get(i).getCompra().size(); j++) {
						fila[0]=Tienda.getInstance().getFacturas().get(i).getId();
						fila[1]=Tienda.getInstance().getFacturas().get(i).getCliente().getNombre();
						//fila[2]=Tienda.getInstance().getFacturas().get(i).getCompra().get(j).toString();
						//fila[3]=Tienda.getInstance().getFacturas().get(i).getCompra().get(j).getPrecioVenta();
						Date fechaActual=Tienda.getInstance().getFacturas().get(i).getFecha();
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
					    String strDate = formatter.format(fechaActual);  
						fila[4]=strDate;
						fila[5]=Tienda.getInstance().getFacturas().get(i).getVendedor().getNombre();
						model.addRow(fila);
					}
				}
				if(Tienda.getInstance().getFacturas().get(i).getCompra()!=null) {
					for (int j = 0; j < Tienda.getInstance().getFacturas().get(i).getCompraK().size(); j++) {
						fila[0]=Tienda.getInstance().getFacturas().get(i).getId();
						fila[1]=Tienda.getInstance().getFacturas().get(i).getCliente().getNombre();
						fila[2]=Tienda.getInstance().getFacturas().get(i).getCompraK().get(j).getNombre();
						fila[3]=Tienda.getInstance().getFacturas().get(i).getCompraK().get(j).getPrecioFinal();
						Date fechaActual=Tienda.getInstance().getFacturas().get(i).getFecha();
						SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
					    String strDate = formatter.format(fechaActual);  
						fila[4]=strDate;
						fila[5]=Tienda.getInstance().getFacturas().get(i).getVendedor().getNombre();
						model.addRow(fila);
					}
				}
			}
		}
	}
	private void tablaVentas() {
		String[] columnNames = {"Id","Cliente","Componente","Precio Total","Fecha","Vendedor"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	
	private void vendedorVenta() {
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			if(Tienda.getInstance().getUsuarios().get(i) instanceof Vendedor && 
			Tienda.getInstance().getUsuarios().get(i).isConexion()==true) {
				vendedor=(Vendedor)Tienda.getInstance().getUsuarios().get(i);
			}
		}
	}
}
