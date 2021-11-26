package Visual;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;

import Logico.DiscoDuro;
import Logico.Kit;
import Logico.Motherboard;
import Logico.Procesador;
import Logico.Proveedor;
import Logico.Ram;
import Logico.Tienda;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrarProductos extends JDialog {
	private JTextField txtSerialMotherboard;
	private JTextField txtMarcaMotherboard;
	private JTextField txtModeloMotherboard;
	private JTextField txtSocketMotherboard;
	private JTextField txtSerialProcesador;
	private JTextField txtMarcaProcesador;
	private JTextField txtModeloProcesador;
	private JTextField txtSocketProcesador;
	private JTextField txtSerialMemoriaRam;
	private JTextField txtMarcaMemoriaRam;
	private JTextField txtModeloMemoriaRam;
	private JTextField txtSerialDiscoDuro;
	private JComboBox cbxRamMotherboard;
	private JTextField txtMarcaDiscoDuro;
	private JTextField txtModeloDiscoDuro;
	private JSpinner spnPrecioVentaMotherboard;
	private JPanel panelMemoriaRam;
	private JPanel panelMotherBoard;
	private JComboBox cbxProveedorMotherboard;
	private JTabbedPane RegistrarProductos;
	private JButton btnRegistrarMotherboard;
	private JComboBox cbxPuertoAlmaMotherboard;
	private JPanel panelProcesador;
	private JButton btnCancelarMotherboard;
	private JSpinner spnPrecioCompraMotherboard;
	private JSpinner spnCapacidadDiscoDuro;
	private JButton btnRegistrarDiscoDuro;
	private JSpinner spnCapacidadMemoMemoriaRam;
	private JButton btnCancelarDiscoDuro;
	private JPanel panelDiscoDuro;
	private JComboBox cbxTipoMemoMemoriaRam;
	private JSpinner spnCantidadMemoriaRam;
	private JSpinner spnCantidadMotherboard;
	private JSpinner spnPrecioVentaDiscoDuro;
	private JSpinner spnCantidadProcesador;
	private JButton btnCancelarProcesador;
	private JComboBox cbxTipoConeDiscoDuro;
	private JButton btnCancelarMemoriaRam;
	private JComboBox cbxProveedorProcesador;
	private JSpinner spnPrecioCompraDiscoDuro;
	private JButton btnRegistrarMemoriaRam;
	private JComboBox cbxProveedorDiscoDuro;
	private JSpinner spnPrecioCompraMemoriaRam;
	private JSpinner spnPrecioVentaProcesador;
	private JSpinner spnCantidadDiscoDuro;
	private JComboBox cbxProveedorMemoriaRam;
	private JSpinner spnVelocidadProcesador;
	private JSpinner spnPrecioCompraProcesador;
	private ArrayList<Proveedor> listMotherboard;
	private ArrayList<Proveedor> listProcesador;
	private ArrayList<Proveedor> listMemoriaRam;
	private ArrayList<Proveedor> listDiscoDuro;
	private JSpinner spnPrecioVentaMemoriaRam;
	private JButton btnRegistrarProcesador;
	private JLabel lblId;
	private JTextField txtIdKit;
	private JLabel lblNombre;
	private JTextField txtNombreKit;
	private JLabel lblMotherboard;
	private JComboBox cbxMotherboardKit;
	private JLabel lblRam_1;
	private JComboBox cbxMemoriaRamKit;
	private JLabel lblProcesador;
	private JComboBox cbxProcesadorKit;
	private JLabel lblDiscoDuro;
	private JComboBox cbxDiscoDuroKit;
	private JLabel lblCantidad_3;
	private JSpinner spnCantidadKit;
	private JPanel panelKit;
	private JButton btnCrearKit;
	private JButton btnCancelar;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarProductos dialog = new RegistrarProductos();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the dialog.
	 */
	public RegistrarProductos(int n) {
		setTitle("Registrar Productos");
		setBounds(100, 100, 761, 493);
		RegistrarProductos = new JTabbedPane(JTabbedPane.TOP);
		getContentPane().add(RegistrarProductos, BorderLayout.CENTER);
		loadPaneles(n);
		try {
			Tienda.getInstance().cargarDatos();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		JLabel lblSerial = new JLabel("Serial:");
		lblSerial.setBounds(39, 45, 46, 14);
		lblSerial.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblSerial);
		
		txtSerialMotherboard = new JTextField();
		txtSerialMotherboard.setText(Tienda.getInstance().asignarSerial());
		txtSerialMotherboard.setEnabled(false);
		txtSerialMotherboard.setBounds(146, 43, 86, 20);
		txtSerialMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(txtSerialMotherboard);
		txtSerialMotherboard.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Marca:");
		lblNewLabel.setBounds(39, 91, 46, 14);
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblNewLabel);
		
		txtMarcaMotherboard = new JTextField();
		txtMarcaMotherboard.setBounds(146, 89, 86, 20);
		txtMarcaMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(txtMarcaMotherboard);
		txtMarcaMotherboard.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Modelo:");
		lblNewLabel_1.setBounds(39, 130, 67, 14);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblNewLabel_1);
		
		txtModeloMotherboard = new JTextField();
		txtModeloMotherboard.setBounds(146, 128, 86, 20);
		txtModeloMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(txtModeloMotherboard);
		txtModeloMotherboard.setColumns(10);
		
		JLabel lblPreciocompra = new JLabel("PrecioCompra:");
		lblPreciocompra.setBounds(39, 185, 97, 14);
		lblPreciocompra.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblPreciocompra);
		
		spnPrecioCompraMotherboard = new JSpinner();
		spnPrecioCompraMotherboard.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioCompraMotherboard.setBounds(146, 183, 67, 20);
		spnPrecioCompraMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(spnPrecioCompraMotherboard);
		
		JLabel lblPrecioventa = new JLabel("PrecioVenta:");
		lblPrecioventa.setBounds(39, 234, 91, 14);
		lblPrecioventa.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblPrecioventa);
		
		spnPrecioVentaMotherboard = new JSpinner();
		spnPrecioVentaMotherboard.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioVentaMotherboard.setBounds(146, 232, 67, 20);
		spnPrecioVentaMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(spnPrecioVentaMotherboard);
		
		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(39, 299, 67, 14);
		lblProveedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblProveedor);
		
		cbxProveedorMotherboard = new JComboBox();
		loadProveedorMotherboard();
		cbxProveedorMotherboard.setBounds(146, 296, 113, 23);
		cbxProveedorMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(cbxProveedorMotherboard);
		
		JLabel lblNewLabel_2 = new JLabel("Cantidad:");
		lblNewLabel_2.setBounds(39, 345, 67, 14);
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblNewLabel_2);
		
		spnCantidadMotherboard = new JSpinner();
		spnCantidadMotherboard.setModel(new SpinnerNumberModel(new Integer(10), new Integer(10), null, new Integer(1)));
		spnCantidadMotherboard.setBounds(146, 343, 67, 20);
		spnCantidadMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(spnCantidadMotherboard);
		
		JLabel lblSocket = new JLabel("Socket:");
		lblSocket.setBounds(352, 45, 46, 14);
		lblSocket.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblSocket);
		
		JLabel lblRam = new JLabel("Ram:");
		lblRam.setBounds(352, 91, 46, 14);
		lblRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblRam);
		
		JLabel lblPuertoDeAlmacenamiento = new JLabel("Puerto de almacenamiento:");
		lblPuertoDeAlmacenamiento.setBounds(312, 185, 188, 14);
		lblPuertoDeAlmacenamiento.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMotherBoard.add(lblPuertoDeAlmacenamiento);
		
		txtSocketMotherboard = new JTextField();
		txtSocketMotherboard.setBounds(408, 43, 101, 20);
		txtSocketMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(txtSocketMotherboard);
		txtSocketMotherboard.setColumns(10);
		
		cbxRamMotherboard = new JComboBox();
		cbxRamMotherboard.setModel(new DefaultComboBoxModel(new String[] {"<Seleccionar>", "DDR", "DDR2", "DDR3", "DDR3L", "DDR4"}));
		cbxRamMotherboard.setBounds(408, 88, 127, 20);
		cbxRamMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(cbxRamMotherboard);
		
		cbxPuertoAlmaMotherboard = new JComboBox();
		cbxPuertoAlmaMotherboard.setModel(new DefaultComboBoxModel(new String[] {"<Selecccionar>", "IDE", "SATA", "SATA II", "SATA III"}));
		cbxPuertoAlmaMotherboard.setBounds(516, 182, 127, 20);
		cbxPuertoAlmaMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMotherBoard.add(cbxPuertoAlmaMotherboard);
		
		btnRegistrarMotherboard = new JButton("Registrar");
		btnRegistrarMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarMotherboard();
			}
		});
		btnRegistrarMotherboard.setBounds(486, 341, 89, 23);
		panelMotherBoard.add(btnRegistrarMotherboard);
		
		btnCancelarMotherboard = new JButton("Cancelar");
		btnCancelarMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarMotherboard.setBounds(598, 341, 89, 23);
		panelMotherBoard.add(btnCancelarMotherboard);
		
		
		JLabel lblSerial_1 = new JLabel("Serial:");
		lblSerial_1.setBounds(41, 53, 46, 14);
		lblSerial_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblSerial_1);
		
		txtSerialProcesador = new JTextField();
		txtSerialProcesador.setText(Tienda.getInstance().asignarSerial());
		txtSerialProcesador.setEnabled(false);
		txtSerialProcesador.setBounds(140, 51, 118, 20);
		txtSerialProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(txtSerialProcesador);
		txtSerialProcesador.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(41, 100, 46, 14);
		lblMarca.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblMarca);
		
		txtMarcaProcesador = new JTextField();
		txtMarcaProcesador.setBounds(140, 98, 86, 20);
		txtMarcaProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(txtMarcaProcesador);
		txtMarcaProcesador.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setBounds(41, 147, 57, 14);
		lblModelo.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblModelo);
		
		txtModeloProcesador = new JTextField();
		txtModeloProcesador.setBounds(140, 145, 86, 20);
		txtModeloProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(txtModeloProcesador);
		txtModeloProcesador.setColumns(10);
		
		JLabel lblPreciocompra_1 = new JLabel("PrecioCompra:");
		lblPreciocompra_1.setBounds(41, 195, 91, 14);
		lblPreciocompra_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblPreciocompra_1);
		
		spnPrecioCompraProcesador = new JSpinner();
		spnPrecioCompraProcesador.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioCompraProcesador.setBounds(142, 193, 63, 20);
		spnPrecioCompraProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(spnPrecioCompraProcesador);
		
		JLabel lblPrecioventa_1 = new JLabel("PrecioVenta:");
		lblPrecioventa_1.setBounds(41, 234, 91, 17);
		lblPrecioventa_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblPrecioventa_1);
		
		spnPrecioVentaProcesador = new JSpinner();
		spnPrecioVentaProcesador.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioVentaProcesador.setBounds(142, 231, 63, 20);
		spnPrecioVentaProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(spnPrecioVentaProcesador);
		
		JLabel lblProveedor_1 = new JLabel("Proveedor:");
		lblProveedor_1.setBounds(41, 277, 75, 17);
		lblProveedor_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblProveedor_1);
		
		cbxProveedorProcesador = new JComboBox();
		loadProveedorProcesador();
		cbxProveedorProcesador.setBounds(142, 274, 96, 20);
		cbxProveedorProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(cbxProveedorProcesador);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(41, 331, 63, 14);
		lblCantidad.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblCantidad);
		
		spnCantidadProcesador = new JSpinner();
		spnCantidadProcesador.setModel(new SpinnerNumberModel(new Integer(10), new Integer(10), null, new Integer(1)));
		spnCantidadProcesador.setBounds(142, 329, 63, 20);
		spnCantidadProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(spnCantidadProcesador);
		
		JLabel lblSocket_1 = new JLabel("Socket:");
		lblSocket_1.setBounds(389, 39, 46, 14);
		lblSocket_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblSocket_1);
		
		JLabel lblNewLabel_3 = new JLabel("Velocidad:");
		lblNewLabel_3.setBounds(389, 100, 63, 14);
		lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblNewLabel_3);
		
		txtSocketProcesador = new JTextField();
		txtSocketProcesador.setBounds(442, 36, 86, 20);
		txtSocketProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProcesador.add(txtSocketProcesador);
		txtSocketProcesador.setColumns(10);
		
		JLabel lblGhetz = new JLabel("GHz");
		lblGhetz.setBounds(552, 100, 46, 14);
		lblGhetz.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProcesador.add(lblGhetz);
		
		btnRegistrarProcesador = new JButton("Registrar");
		btnRegistrarProcesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarProcesador();
			}
		});
		btnRegistrarProcesador.setBounds(455, 283, 89, 23);
		panelProcesador.add(btnRegistrarProcesador);
		
		btnCancelarProcesador = new JButton("Cancelar");
		btnCancelarProcesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarProcesador.setBounds(571, 283, 89, 23);
		panelProcesador.add(btnCancelarProcesador);
		
		spnVelocidadProcesador = new JSpinner();
		spnVelocidadProcesador.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnVelocidadProcesador.setBounds(462, 99, 75, 20);
		panelProcesador.add(spnVelocidadProcesador);
		
		JLabel lblSerial_2 = new JLabel("Serial:");
		lblSerial_2.setBounds(30, 51, 46, 14);
		lblSerial_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblSerial_2);
		
		txtSerialMemoriaRam = new JTextField();
		txtSerialMemoriaRam.setText(Tienda.getInstance().asignarSerial());
		txtSerialMemoriaRam.setEnabled(false);
		txtSerialMemoriaRam.setBounds(147, 49, 86, 20);
		txtSerialMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(txtSerialMemoriaRam);
		txtSerialMemoriaRam.setColumns(10);
		
		JLabel lblMarca_1 = new JLabel("Marca:");
		lblMarca_1.setBounds(30, 97, 46, 14);
		lblMarca_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblMarca_1);
		
		txtMarcaMemoriaRam = new JTextField();
		txtMarcaMemoriaRam.setBounds(147, 95, 86, 20);
		txtMarcaMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(txtMarcaMemoriaRam);
		txtMarcaMemoriaRam.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Modelo:");
		lblNewLabel_4.setBounds(30, 144, 67, 18);
		lblNewLabel_4.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblNewLabel_4);
		
		txtModeloMemoriaRam = new JTextField();
		txtModeloMemoriaRam.setBounds(147, 142, 86, 20);
		txtModeloMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(txtModeloMemoriaRam);
		txtModeloMemoriaRam.setColumns(10);
		
		JLabel lblPreciocompra_2 = new JLabel("PrecioCompra:");
		lblPreciocompra_2.setBounds(30, 187, 96, 17);
		lblPreciocompra_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblPreciocompra_2);
		
		JLabel lblPrecioventa_2 = new JLabel("PrecioVenta:");
		lblPrecioventa_2.setBounds(30, 236, 86, 14);
		lblPrecioventa_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblPrecioventa_2);
		
		spnPrecioCompraMemoriaRam = new JSpinner();
		spnPrecioCompraMemoriaRam.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioCompraMemoriaRam.setBounds(147, 184, 59, 20);
		spnPrecioCompraMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(spnPrecioCompraMemoriaRam);
		
		spnPrecioVentaMemoriaRam = new JSpinner();
		spnPrecioVentaMemoriaRam.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioVentaMemoriaRam.setBounds(147, 233, 59, 20);
		spnPrecioVentaMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(spnPrecioVentaMemoriaRam);
		
		JLabel lblProveedor_2 = new JLabel("Proveedor:");
		lblProveedor_2.setBounds(30, 278, 67, 14);
		lblProveedor_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblProveedor_2);
		
		JLabel lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setBounds(30, 328, 67, 14);
		lblCantidad_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblCantidad_1);
		
		cbxProveedorMemoriaRam = new JComboBox();
		loadProveedorMemoriaRam();
		cbxProveedorMemoriaRam.setBounds(117, 275, 106, 22);
		cbxProveedorMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(cbxProveedorMemoriaRam);
		
		spnCantidadMemoriaRam = new JSpinner();
		spnCantidadMemoriaRam.setModel(new SpinnerNumberModel(new Integer(10), new Integer(10), null, new Integer(1)));
		spnCantidadMemoriaRam.setBounds(117, 325, 59, 20);
		spnCantidadMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(spnCantidadMemoriaRam);
		
		JLabel lblNewLabel_5 = new JLabel("Capacidad de memoria:");
		lblNewLabel_5.setBounds(311, 51, 169, 14);
		lblNewLabel_5.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblNewLabel_5);
		
		spnCapacidadMemoMemoriaRam = new JSpinner();
		spnCapacidadMemoMemoriaRam.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnCapacidadMemoMemoriaRam.setBounds(480, 48, 86, 20);
		spnCapacidadMemoMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(spnCapacidadMemoMemoriaRam);
		
		JLabel lblGbz = new JLabel("GBz");
		lblGbz.setBounds(576, 51, 46, 14);
		lblGbz.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblGbz);
		
		JLabel lblTipoDeMemoria = new JLabel("Tipo de memoria:");
		lblTipoDeMemoria.setBounds(311, 97, 151, 14);
		lblTipoDeMemoria.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelMemoriaRam.add(lblTipoDeMemoria);
		
		cbxTipoMemoMemoriaRam = new JComboBox();
		cbxTipoMemoMemoriaRam.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "DDR", "DDR2", "DDR3", "DDR4"}));
		cbxTipoMemoMemoriaRam.setBounds(478, 95, 121, 20);
		cbxTipoMemoMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelMemoriaRam.add(cbxTipoMemoMemoriaRam);
		
		btnRegistrarMemoriaRam = new JButton("Registrar");
		btnRegistrarMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarMemoriaRam();
			}
		});
		btnRegistrarMemoriaRam.setBounds(449, 274, 89, 23);
		panelMemoriaRam.add(btnRegistrarMemoriaRam);
		
		btnCancelarMemoriaRam = new JButton("Cancelar");
		btnCancelarMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarMemoriaRam.setBounds(563, 274, 89, 23);
		panelMemoriaRam.add(btnCancelarMemoriaRam);
		
		JLabel lblSerial_3 = new JLabel("Serial:");
		lblSerial_3.setBounds(23, 44, 46, 14);
		lblSerial_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblSerial_3);
		
		txtSerialDiscoDuro = new JTextField();
		txtSerialDiscoDuro.setText(Tienda.getInstance().asignarSerial());
		txtSerialDiscoDuro.setEnabled(false);
		txtSerialDiscoDuro.setBounds(129, 42, 86, 20);
		txtSerialDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(txtSerialDiscoDuro);
		txtSerialDiscoDuro.setColumns(10);
		
		JLabel lblMarca_2 = new JLabel("Marca:");
		lblMarca_2.setBounds(23, 90, 46, 14);
		lblMarca_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblMarca_2);
		
		txtMarcaDiscoDuro = new JTextField();
		txtMarcaDiscoDuro.setBounds(129, 88, 86, 20);
		txtMarcaDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(txtMarcaDiscoDuro);
		txtMarcaDiscoDuro.setColumns(10);
		
		JLabel lblModelo_1 = new JLabel("Modelo:");
		lblModelo_1.setBounds(23, 136, 58, 18);
		lblModelo_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblModelo_1);
		
		txtModeloDiscoDuro = new JTextField();
		txtModeloDiscoDuro.setBounds(129, 134, 86, 20);
		txtModeloDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(txtModeloDiscoDuro);
		txtModeloDiscoDuro.setColumns(10);
		
		JLabel lblPreciocompra_3 = new JLabel("PrecioCompra:");
		lblPreciocompra_3.setBounds(23, 196, 96, 14);
		lblPreciocompra_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblPreciocompra_3);
		
		JLabel lblPrecioventa_3 = new JLabel("PrecioVenta:");
		lblPrecioventa_3.setBounds(23, 232, 79, 14);
		lblPrecioventa_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblPrecioventa_3);
		
		spnPrecioCompraDiscoDuro = new JSpinner();
		spnPrecioCompraDiscoDuro.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioCompraDiscoDuro.setBounds(129, 194, 68, 20);
		spnPrecioCompraDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(spnPrecioCompraDiscoDuro);
		
		spnPrecioVentaDiscoDuro = new JSpinner();
		spnPrecioVentaDiscoDuro.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnPrecioVentaDiscoDuro.setBounds(129, 230, 68, 20);
		spnPrecioVentaDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(spnPrecioVentaDiscoDuro);
		
		JLabel lblProveedor_3 = new JLabel("Proveedor:");
		lblProveedor_3.setBounds(23, 281, 79, 14);
		lblProveedor_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblProveedor_3);
		
		cbxProveedorDiscoDuro = new JComboBox();
		loadProveedorDiscoDuro();
		cbxProveedorDiscoDuro.setBounds(132, 278, 117, 20);
		cbxProveedorDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(cbxProveedorDiscoDuro);
		
		JLabel lblCantidad_2 = new JLabel("Cantidad:");
		lblCantidad_2.setBounds(23, 326, 58, 14);
		lblCantidad_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblCantidad_2);
		
		spnCantidadDiscoDuro = new JSpinner();
		spnCantidadDiscoDuro.setModel(new SpinnerNumberModel(new Integer(10), new Integer(1), null, new Integer(1)));
		spnCantidadDiscoDuro.setBounds(112, 323, 68, 20);
		spnCantidadDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(spnCantidadDiscoDuro);
		
		JLabel lblNewLabel_6 = new JLabel("Capacidad:");
		lblNewLabel_6.setBounds(300, 60, 68, 17);
		lblNewLabel_6.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblNewLabel_6);
		
		spnCapacidadDiscoDuro = new JSpinner();
		spnCapacidadDiscoDuro.setModel(new SpinnerNumberModel(new Double(1), new Double(1), null, new Double(1)));
		spnCapacidadDiscoDuro.setBounds(389, 57, 68, 20);
		spnCapacidadDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelDiscoDuro.add(spnCapacidadDiscoDuro);
		
		JLabel lblTipoDeConexin = new JLabel("Tipo de conexi\u00F3n:");
		lblTipoDeConexin.setBounds(300, 120, 107, 14);
		lblTipoDeConexin.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblTipoDeConexin);
		
		cbxTipoConeDiscoDuro = new JComboBox();
		cbxTipoConeDiscoDuro.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "IDE", "SATA", "SATA II", "SATA III"}));
		cbxTipoConeDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		cbxTipoConeDiscoDuro.setBounds(417, 117, 124, 20);
		panelDiscoDuro.add(cbxTipoConeDiscoDuro);
		
		btnRegistrarDiscoDuro = new JButton("Registrar");
		btnRegistrarDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarDiscoDuro();
			}
		});
		btnRegistrarDiscoDuro.setBounds(473, 295, 89, 23);
		panelDiscoDuro.add(btnRegistrarDiscoDuro);
		
		btnCancelarDiscoDuro = new JButton("Cancelar");
		btnCancelarDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelarDiscoDuro.setBounds(594, 295, 89, 23);
		panelDiscoDuro.add(btnCancelarDiscoDuro);
		
		JLabel lblGbz_1 = new JLabel("Gbz");
		lblGbz_1.setBounds(471, 60, 24, 14);
		lblGbz_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelDiscoDuro.add(lblGbz_1);
		
		lblId = new JLabel("ID:");
		lblId.setBounds(137, 56, 46, 14);
		lblId.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelKit.add(lblId);
		
		txtIdKit = new JTextField();
		txtIdKit.setText(Tienda.getInstance().asignarIdKit());
		txtIdKit.setEnabled(false);
		txtIdKit.setBounds(240, 54, 121, 20);
		txtIdKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelKit.add(txtIdKit);
		txtIdKit.setColumns(10);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(137, 102, 73, 18);
		lblNombre.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelKit.add(lblNombre);
		
		txtNombreKit = new JTextField();
		txtNombreKit.setBounds(240, 102, 121, 20);
		txtNombreKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelKit.add(txtNombreKit);
		txtNombreKit.setColumns(10);
		
		lblMotherboard = new JLabel("Motherboard:");
		lblMotherboard.setBounds(137, 152, 93, 18);
		lblMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelKit.add(lblMotherboard);
		
		cbxMotherboardKit = new JComboBox();
		loadKitMotherboard();
		cbxMotherboardKit.setBounds(240, 150, 121, 20);
		cbxMotherboardKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelKit.add(cbxMotherboardKit);
		
		lblRam_1 = new JLabel("RAM:");
		lblRam_1.setBounds(137, 203, 46, 14);
		lblRam_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelKit.add(lblRam_1);
		
		cbxMemoriaRamKit = new JComboBox();
		loadKitMemoriaRam();
		cbxMemoriaRamKit.setBounds(240, 201, 121, 20);
		cbxMemoriaRamKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelKit.add(cbxMemoriaRamKit);
		
		lblProcesador = new JLabel("Procesador:");
		lblProcesador.setBounds(137, 251, 73, 14);
		lblProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelKit.add(lblProcesador);
		
		cbxProcesadorKit = new JComboBox();
		loadKitProcesador();
		cbxProcesadorKit.setBounds(240, 248, 121, 20);
		cbxProcesadorKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelKit.add(cbxProcesadorKit);
		
		lblDiscoDuro = new JLabel("Disco Duro:");
		lblDiscoDuro.setBounds(137, 294, 73, 14);
		lblDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelKit.add(lblDiscoDuro);
		
		cbxDiscoDuroKit = new JComboBox();
		loadKitDiscoDuro();
		cbxDiscoDuroKit.setBounds(240, 291, 121, 20);
		cbxDiscoDuroKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelKit.add(cbxDiscoDuroKit);
		
		lblCantidad_3 = new JLabel("Cantidad:");
		lblCantidad_3.setBounds(137, 340, 64, 14);
		lblCantidad_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelKit.add(lblCantidad_3);
		
		spnCantidadKit = new JSpinner();
		spnCantidadKit.setModel(new SpinnerNumberModel(new Integer(5), new Integer(5), null, new Integer(1)));
		spnCantidadKit.setBounds(240, 338, 73, 20);
		spnCantidadKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelKit.add(spnCantidadKit);
		
		btnCrearKit = new JButton("Crear Kit");
		btnCrearKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarKit();
			}
		});
		btnCrearKit.setBounds(521, 361, 86, 23);
		panelKit.add(btnCrearKit);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(617, 361, 89, 23);
		panelKit.add(btnCancelar);
	}
	private void loadKitMotherboard() {
		cbxMotherboardKit.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof Motherboard) {
				cbxMotherboardKit.addItem(Tienda.getInstance().getComponentes().get(i));
			}
		}
	}
	private void loadKitProcesador() {
		cbxProcesadorKit.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof Procesador) {
				cbxProcesadorKit.addItem(Tienda.getInstance().getComponentes().get(i));
			}
		}
	}
	private void loadKitMemoriaRam() {
		cbxMemoriaRamKit.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof Ram) {
				cbxMemoriaRamKit.addItem(Tienda.getInstance().getComponentes().get(i));
			}
		}
	}
	private void loadKitDiscoDuro() {
		cbxDiscoDuroKit.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getComponentes().size(); i++) {
			if(Tienda.getInstance().getComponentes().get(i) instanceof DiscoDuro) {
				cbxDiscoDuroKit.addItem(Tienda.getInstance().getComponentes().get(i));
			}
		}
	}
	private void loadProveedorMotherboard() {
		cbxProveedorMotherboard.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
			for (int j = 0; j < Tienda.getInstance().getProveedores().get(i).getComponente().size(); j++) {
				if(Tienda.getInstance().getProveedores().get(i).getComponente().get(j).equalsIgnoreCase("MotherBoard")) {
					cbxProveedorMotherboard.addItem(Tienda.getInstance().getProveedores().get(i).getNombre());
					guardarProveedorMotherboard(Tienda.getInstance().getProveedores().get(i));

				}
					
			}
		}
	}
	private void loadProveedorProcesador() {
		cbxProveedorProcesador.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
			for (int j = 0; j < Tienda.getInstance().getProveedores().get(i).getComponente().size(); j++) {
				if(Tienda.getInstance().getProveedores().get(i).getComponente().get(j).equalsIgnoreCase("Procesador")) {
					cbxProveedorProcesador.addItem(Tienda.getInstance().getProveedores().get(i).getNombre());
					guardarProveedorProcesador(Tienda.getInstance().getProveedores().get(i));
				}
					
			}
		}
	}
	private void loadProveedorMemoriaRam() {
		cbxProveedorMemoriaRam.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
			for (int j = 0; j < Tienda.getInstance().getProveedores().get(i).getComponente().size(); j++) {
				if(Tienda.getInstance().getProveedores().get(i).getComponente().get(j).equalsIgnoreCase("MemoriaRam")) {
					cbxProveedorMemoriaRam.addItem(Tienda.getInstance().getProveedores().get(i).getNombre());
					guardarProveedorMemoriaRam(Tienda.getInstance().getProveedores().get(i));

				}
					
			}
		}
	}
	private void loadProveedorDiscoDuro() {
		cbxProveedorDiscoDuro.removeAllItems();
		for (int i = 0; i < Tienda.getInstance().getProveedores().size(); i++) {
			for (int j = 0; j < Tienda.getInstance().getProveedores().get(i).getComponente().size(); j++) {
				if(Tienda.getInstance().getProveedores().get(i).getComponente().get(j).equalsIgnoreCase("DiscoDuro")) {
					cbxProveedorDiscoDuro.addItem(Tienda.getInstance().getProveedores().get(i).getNombre());
					guardarProveedorDiscoDuro(Tienda.getInstance().getProveedores().get(i));

				}
			}
		}
	}
	private void guardarKit() {
		if(verificarComponente()) {
			String id= txtIdKit.getText();
			String nombre= txtNombreKit.getText();
			Motherboard mother=(Motherboard) cbxMotherboardKit.getSelectedItem();
			Procesador proce=(Procesador) cbxProcesadorKit.getSelectedItem();
			Ram memoria=(Ram) cbxMemoriaRamKit.getSelectedItem();
			DiscoDuro disco=(DiscoDuro) cbxDiscoDuroKit.getSelectedItem();
			int cantidad=(Integer) spnCantidadKit.getValue();
			Kit kit=new Kit(id, nombre, cantidad);
			kit.insertarComponentes(mother);
			kit.insertarComponentes(proce);
			kit.insertarComponentes(memoria);
			kit.insertarComponentes(disco);
			Tienda.getInstance().insertarKits(kit);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanKit();
		}
		else if(!verificarComponente()){
			
		}
	}
	private void guardarMotherboard() {
		//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Socket","Ram","Puerto"
		if(verificarComponente()) {
			String numeroSerie= txtSerialMotherboard.getText();
			String marca= txtMarcaMotherboard.getText();
			String modelo= txtModeloMotherboard.getText();
			double precioCompra=(double) spnPrecioCompraMotherboard.getValue();
			int cantidad=(Integer)spnCantidadMotherboard.getValue();
			double precioVenta=(double) spnPrecioVentaMotherboard.getValue();
			Proveedor proveedor= retornarProveedor(listMotherboard,cbxProveedorMotherboard.getSelectedIndex());
			String socket= txtSocketMotherboard.getText();
			String ram=(String) cbxRamMotherboard.getSelectedItem();
			String tipoHDD=(String) cbxPuertoAlmaMotherboard.getSelectedItem();
			Motherboard mother= new Motherboard(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor, socket, ram, tipoHDD);
			Tienda.getInstance().insertarComponentes(mother);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanMotherboard();
		}
		else if (!verificarComponente()) {
			
		}
	}
	private void guardarProcesador() {
		//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Socket","Velocidad"
		if(verificarComponente()) {
			String numeroSerie= txtSerialProcesador.getText();
			String marca= txtMarcaProcesador.getText();
			String modelo= txtModeloProcesador.getText();
			double precioCompra=(double) spnPrecioVentaProcesador.getValue();
			int cantidad=(Integer)spnCantidadProcesador.getValue();
			double precioVenta=(double) spnPrecioVentaProcesador.getValue();
			Proveedor proveedor= retornarProveedor(listProcesador,cbxProveedorProcesador.getSelectedIndex());
			double velocidad= (double) spnVelocidadProcesador.getValue();
			String socket= txtSocketProcesador.getText(); 
			Procesador proce= new Procesador(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor, socket, velocidad);
			Tienda.getInstance().insertarComponentes(proce);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanProcesador();
		}
		else if (!verificarComponente()) {
			
		}
	}
	private void guardarMemoriaRam() {
		//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Capacidad","Tipo de memoria"
		if(verificarComponente()) {
			String numeroSerie= txtSerialMemoriaRam.getText();
			String marca= txtMarcaMemoriaRam.getText();
			String modelo= txtModeloMemoriaRam.getText();
			double precioCompra=(double) spnPrecioVentaMemoriaRam.getValue();
			int cantidad=(Integer)spnCantidadMemoriaRam.getValue();
			double precioVenta=(double) spnPrecioVentaMemoriaRam.getValue();
			Proveedor proveedor= retornarProveedor(listMemoriaRam,cbxProveedorMemoriaRam.getSelectedIndex());
			double memoria= (double) spnCapacidadMemoMemoriaRam.getValue();
			String tipo=(String) cbxTipoMemoMemoriaRam.getSelectedItem();
			Ram ram= new Ram(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor, memoria, tipo);
			Tienda.getInstance().insertarComponentes(ram);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanMemoriaRam();
		}
		else if (!verificarComponente()) {
			
		}
	}
	private void guardarDiscoDuro() {
		//"Serial","Marca","Modelo","Precio Compra","Precio Venta","Proveedor","Cantidad","Capacidad","Tipo de conexíon"
		if(verificarComponente()) {
			String numeroSerie= txtSerialDiscoDuro.getText();
			String marca= txtMarcaDiscoDuro.getText();
			String modelo= txtModeloDiscoDuro.getText();
			double precioCompra=(double) spnPrecioVentaDiscoDuro.getValue();
			int cantidad=(Integer)spnCantidadDiscoDuro.getValue();
			double precioVenta=(double) spnPrecioVentaDiscoDuro.getValue();
			Proveedor proveedor= retornarProveedor(listDiscoDuro,cbxProveedorDiscoDuro.getSelectedIndex());
			double capacidad=(double) spnCapacidadDiscoDuro.getValue();
			String conexion= (String) cbxTipoConeDiscoDuro.getSelectedItem();
			DiscoDuro disco= new DiscoDuro(marca, precioCompra, cantidad, numeroSerie, modelo, precioVenta, proveedor, capacidad, conexion);
			Tienda.getInstance().insertarComponentes(disco);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanDiscoDuro();
		}
		else if (!verificarComponente()) {
			
		}
	}
	private void cleanMotherboard() {
		txtSerialMotherboard.setText(Tienda.getInstance().asignarSerial());
		txtMarcaMotherboard.setText("");
		txtModeloMotherboard.setText("");
		spnPrecioVentaMotherboard.setValue(1);
		spnCantidadMotherboard.setValue(10);
		spnPrecioCompraMotherboard.setValue(1);
		loadProveedorMotherboard();
		txtSocketMotherboard.setText("");
		cbxRamMotherboard.setSelectedIndex(0);
		cbxPuertoAlmaMotherboard.setSelectedIndex(0);
	}
	private void cleanProcesador() {
		txtSerialProcesador.setText(Tienda.getInstance().asignarSerial());
		txtMarcaProcesador.setText("");
		txtModeloProcesador.setText("");
		spnPrecioVentaProcesador.setValue(1);
		spnCantidadProcesador.setValue(10);
		spnPrecioCompraProcesador.setValue(1);
		loadProveedorProcesador();
		spnVelocidadProcesador.setValue(1);
		txtSocketProcesador.setText(""); 
	}
	private void cleanMemoriaRam() {
		txtSerialMemoriaRam.setText(Tienda.getInstance().asignarSerial());
		txtMarcaMemoriaRam.setText("");
		txtModeloMemoriaRam.setText("");
		spnPrecioVentaMemoriaRam.setValue(1);
		spnCantidadMemoriaRam.setValue(10);
		spnPrecioCompraMemoriaRam.setValue(1);
		loadProveedorMemoriaRam();
		spnCapacidadMemoMemoriaRam.setValue(1);
		cbxTipoMemoMemoriaRam.setSelectedIndex(0);
	}
	private void cleanDiscoDuro() {
		txtSerialMemoriaRam.setText(Tienda.getInstance().asignarSerial());
		txtMarcaMemoriaRam.setText("");
		txtModeloMemoriaRam.setText("");
		spnPrecioVentaMemoriaRam.setValue(1);
		spnCantidadMemoriaRam.setValue(10);
		spnPrecioCompraMemoriaRam.setValue(1);
		loadProveedorDiscoDuro();
		spnCapacidadDiscoDuro.setValue(1);
		cbxTipoConeDiscoDuro.setSelectedIndex(0);
	}
	private void cleanKit() {
		txtIdKit.setText("");
		txtNombreKit.setText("");
		spnCantidadKit.setValue(5);
		loadKitDiscoDuro();
		loadKitMemoriaRam();
		loadKitMotherboard();
		loadKitProcesador();
	}
	private boolean verificarComponente() {
		boolean completo=true;
		return completo;
	}
	private void guardarProveedorMotherboard(Proveedor prove) {
		listMotherboard = new ArrayList<>();
		listMotherboard.add(prove);
	}
	private void guardarProveedorProcesador(Proveedor prove) {
		listProcesador = new ArrayList<>();
		listProcesador.add(prove);
	}
	private void guardarProveedorMemoriaRam(Proveedor prove) {
		listMemoriaRam = new ArrayList<>();
		listMemoriaRam.add(prove);
	}
	private void guardarProveedorDiscoDuro(Proveedor prove) {
		listDiscoDuro = new ArrayList<>();
		listDiscoDuro.add(prove);
	}
	private Proveedor retornarProveedor(ArrayList<Proveedor> list,int i) {
		return list.get(i);
	}
	private void loadPaneles(int n) {
		//if(n==1) {
			panelMotherBoard = new JPanel();
			RegistrarProductos.addTab("Mother Board", null, panelMotherBoard, null);
			panelMotherBoard.setBackground(Color.decode("#4B5F83"));
			panelMotherBoard.setLayout(null);
	//	}
	//	else if (n==2) {
			panelProcesador = new JPanel();
			RegistrarProductos.addTab("Procesador", null, panelProcesador, null);
			panelProcesador.setBackground(Color.decode("#4B5F83"));
			panelProcesador.setLayout(null);
	//	}
	// if (n==3) {
			panelMemoriaRam = new JPanel();
			RegistrarProductos.addTab("Memoria Ram", null, panelMemoriaRam, null);
			RegistrarProductos.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
			panelMemoriaRam.setBackground(Color.decode("#4B5F83"));
			panelMemoriaRam.setLayout(null);
	//	}
	//	else if (n==4) {
			panelDiscoDuro = new JPanel();
			RegistrarProductos.addTab("Disco Duro", null, panelDiscoDuro, null);
			panelDiscoDuro.setBackground(Color.decode("#4B5F83"));
			panelDiscoDuro.setLayout(null);
	//	}
	//	else if (n==5) {
			panelKit = new JPanel();
			RegistrarProductos.addTab("Kit", null, panelKit, null);
			panelKit.setBackground(Color.decode("#4B5F83"));
			panelKit.setLayout(null);
	//	}
	}
}
