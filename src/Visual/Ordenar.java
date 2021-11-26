package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Componente;
import Logico.DiscoDuro;
import Logico.Motherboard;
import Logico.Ordenes;
import Logico.Procesador;
import Logico.Ram;
import Logico.Tienda;
import Logico.Vendedor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

public class Ordenar extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JComboBox cbxComponente;
	private JComboBox cbxComponentesTienda;
	private Vendedor vendedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ordenar dialog = new Ordenar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ordenar() {
		setBounds(100, 100, 433, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setBackground(Color.decode("#4B5F83"));


		contentPanel.setLayout(null);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spinner.setBounds(159, 174, 72, 20);
		contentPanel.add(spinner);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(29, 176, 47, 17);
		contentPanel.add(lblCantidad);
		
		JLabel lblOrdenarComponente = new JLabel("Ordenar Componente");
		lblOrdenarComponente.setBounds(139, 11, 128, 14);
		contentPanel.add(lblOrdenarComponente);
		
		cbxComponente = new JComboBox();
		cbxComponente.setModel(new DefaultComboBoxModel(new String[] {"Motherboard", "Procesador", "Memoria Ram", "Disco Duro"}));
		cbxComponente.setBounds(159, 70, 108, 20);
		contentPanel.add(cbxComponente);
		
		JLabel lblComponente = new JLabel("Componentes:");
		lblComponente.setBounds(29, 73, 90, 14);
		contentPanel.add(lblComponente);
		
		JLabel lblComponenteDeseado = new JLabel("Componente deseado:");
		lblComponenteDeseado.setBounds(28, 127, 128, 14);
		contentPanel.add(lblComponenteDeseado);
		
		cbxComponentesTienda = new JComboBox();
		cbxComponentesTienda.setBounds(159, 124, 108, 20);
		contentPanel.add(cbxComponentesTienda);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			buttonPane.setBackground(Color.decode("#4B5F83"));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Realizar Pedido");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						realizarOrden();
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
						int dialogResult =JOptionPane.showConfirmDialog(null, "¿Esta seguro de no ordenar componente?", "Información",JOptionPane.YES_NO_OPTION);
						if(dialogResult==JOptionPane.YES_OPTION) {
							dispose();
						}
						else if(dialogResult==JOptionPane.NO_OPTION) {
							return;
						}
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void loadComponente() {
		if(cbxComponente.getSelectedItem()=="Motherboard") {
			for(int i=0;i<Tienda.getInstance().getComponentes().size();i++) {
				if(Tienda.getInstance().getComponentes().get(i) instanceof Motherboard) {
					cbxComponentesTienda.addItem(Tienda.getInstance().getComponentes().get(i));
				}
			}
		
		}
		else if (cbxComponente.getSelectedItem()=="Procesador") {
			for(int i=0;i<Tienda.getInstance().getComponentes().size();i++) {
				if(Tienda.getInstance().getComponentes().get(i) instanceof Procesador) {
					cbxComponentesTienda.addItem(Tienda.getInstance().getComponentes().get(i));
				}
			}
		}
		else if (cbxComponente.getSelectedItem()=="Memoria Ram") {
			for(int i=0;i<Tienda.getInstance().getComponentes().size();i++) {
				if(Tienda.getInstance().getComponentes().get(i) instanceof Ram) {
					cbxComponentesTienda.addItem(Tienda.getInstance().getComponentes().get(i));
				}
			}
		}
		else if (cbxComponente.getSelectedItem()=="Disco Duro") {
			for(int i=0;i<Tienda.getInstance().getComponentes().size();i++) {
				if(Tienda.getInstance().getComponentes().get(i) instanceof DiscoDuro) {
					cbxComponentesTienda.addItem(Tienda.getInstance().getComponentes().get(i));
				}
			}
		}
	}
	private void realizarOrden() {
		Date fecha= new Date();
		Ordenes orden = new Ordenes((Componente)cbxComponentesTienda.getSelectedItem(),vendedor,fecha);
		Tienda.getInstance().insertarOrdenes(orden);
		try {
			Tienda.getInstance().guardarDatos();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Orden completada", "Correcto", JOptionPane.OK_OPTION);
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
