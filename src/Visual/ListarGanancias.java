package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logico.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListarGanancias extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static DefaultTableModel model;
	private static Object[] fila;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListarGanancias dialog = new ListarGanancias();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListarGanancias() {
		setTitle("Listar Ganancias");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				scrollPane.setViewportView(table);
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				model = new DefaultTableModel();
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
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
		loadGanancias();
	}
	private void tablaGanancias() {
		String[] columnNames = {"ID","Componente","Precio Compra","Precio Venta","Cantidad","Ganancias Estimadas"};
		model.setColumnIdentifiers(columnNames);
		table.setModel(model);
	}
	private void loadGanancias() {
		tablaGanancias();
		model.setRowCount(0);
		fila= new Object[model.getColumnCount()];
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			fila[0]=Tienda.getInstance().getComponentes().get(i).getNumeroSerie();
			fila[1]=Tienda.getInstance().getComponentes().get(i).getMarca() +" "+ Tienda.getInstance().getComponentes().get(i).getModelo();
			fila[2]=Tienda.getInstance().getComponentes().get(i).getPrecioCompra();
			fila[3]=Tienda.getInstance().getComponentes().get(i).getPrecioVenta();
			fila[4]=Tienda.getInstance().getComponentes().get(i).getCantidad();
			fila[5]=Tienda.getInstance().getComponentes().get(i).getPrecioVenta()-Tienda.getInstance().getComponentes().get(i).getPrecioCompra();
			model.addRow(fila);
		}
		for (int i = 0; i < fila.length; i++) {
			
		}
	}

}
