package Visual;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.text.MaskFormatter;

import com.sun.xml.internal.txw2.output.TXWResult;

import Logico.Administrador;
import Logico.Cliente;
import Logico.Proveedor;
import Logico.Tienda;
import Logico.Vendedor;
import sun.util.BuddhistCalendar;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Label;

public class Registrar extends JDialog {
	private JTextField txtNomProvedor;
	private JTextField txtNomCliente;
	private JTextField txtIdCliente;
	private JTextField txtidProveedor;
	private JTextField txtIdAdministrador;
	private JTextField txtNomAdministrador;
	private JTextField txtUsuarioAdministrador;
	private JPasswordField txtContrasenaAdministrador;
	private JTextField txtIdVendedor;
	private JTextField txtNomVendedor;
	private JTextField txtUsuarioVendedor;
	private JPasswordField txtContraVendedor;
	private JFormattedTextField txtCedulaProveedor;
	private JFormattedTextField txtTelefonoProveedor;
	private JFormattedTextField txtCedulaVendedor;
	private JPanel panelProveedor;
	private JTabbedPane RegistrarUsuarios;
	private JFormattedTextField txtTelefonoVendedor;
	private JFormattedTextField txtTelefonoCliente;
	private JPanel panelVendedor;
	private JFormattedTextField txtCedulaAdministrador;
	private JPanel panelAdministrador;
	private JPanel panelCliente;
	private JComboBox cbxComponentProveedor;
	private JFormattedTextField txtTelefonoAdministrador;
	private TextArea txtDireccionProveedor;
	private JFormattedTextField txtCedulaCliente;
	private TextArea txtDireccionCliente;
	private TextArea txtDireccionAdministrador;
	public Registrar(int n) {
	//	loadPanel(n);
		try {
			Tienda.getInstance().cargarDatos();
		} catch (ClassNotFoundException | IOException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		setTitle("Registrar");
		setBounds(100, 100, 732, 532);
		getContentPane().setLayout(new BorderLayout(0, 0));
		RegistrarUsuarios = new JTabbedPane(JTabbedPane.TOP);
		RegistrarUsuarios.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 15));
		getContentPane().add(RegistrarUsuarios);
		
		panelProveedor = new JPanel();
		//if(n==4) {
			RegistrarUsuarios.addTab("Proveedor", null, panelProveedor, null);
	//	}
		panelProveedor.setBackground(Color.decode("#4B5F83"));
		panelProveedor.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(194, 79, 54, 21);
		lblNewLabel.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProveedor.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cedula:");
		lblNewLabel_1.setBounds(194, 128, 46, 14);
		lblNewLabel_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProveedor.add(lblNewLabel_1);
		
		txtNomProvedor = new JTextField();
		txtNomProvedor.setBounds(303, 80, 221, 20);
		txtNomProvedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProveedor.add(txtNomProvedor);
		txtNomProvedor.setColumns(10);
		
		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setBounds(194, 224, 82, 14);
		lblDireccion.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProveedor.add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setBounds(194, 313, 82, 14);
		lblTelefono.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProveedor.add(lblTelefono);
		
		try {
			txtTelefonoProveedor = new JFormattedTextField(new MaskFormatter("###-###-####"));
			txtTelefonoProveedor.setBounds(303, 311, 117, 20);
			txtTelefonoProveedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		panelProveedor.add(txtTelefonoProveedor);
		
		cbxComponentProveedor = new JComboBox();
		cbxComponentProveedor.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "MotherBoard", "Procesador", "DiscoDuro", "MemoriaRam"}));
		cbxComponentProveedor.setBounds(303, 361, 109, 30);
		cbxComponentProveedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProveedor.add(cbxComponentProveedor);
		
		JLabel lblComponente = new JLabel("Componente:");
		lblComponente.setBounds(194, 368, 98, 14);
		lblComponente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProveedor.add(lblComponente);
		
		
		JLabel lblId_1 = new JLabel("Id:");
		lblId_1.setBounds(194, 22, 46, 14);
		lblId_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelProveedor.add(lblId_1);
		
		txtidProveedor = new JTextField();
		txtidProveedor.setEnabled(false);
		txtidProveedor.setText(Tienda.getInstance().asignarIdProveedor());
		txtidProveedor.setBounds(303, 20, 86, 20);
		txtidProveedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProveedor.add(txtidProveedor);
		txtidProveedor.setColumns(10);
		
		try {
			txtCedulaProveedor = new JFormattedTextField(new MaskFormatter("###-#######-#"));
			txtCedulaProveedor.setBounds(303, 126, 99, 20);
			txtCedulaProveedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelProveedor.add(txtCedulaProveedor);
		
		txtDireccionProveedor = new TextArea();
		txtDireccionProveedor.setBounds(303, 186, 221, 89);
		txtDireccionProveedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelProveedor.add(txtDireccionProveedor);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarProveedor();
			}
		});
		label.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_user-add_216490.png")));
		label.setBounds(489, 368, 71, 64);
		panelProveedor.add(label);
		
		JLabel label_1 = new JLabel((String) null);
		label_1.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_v-11_3162629 (1).png")));
		label_1.setBounds(597, 382, 63, 44);
		panelProveedor.add(label_1);
		
		
		panelCliente = new JPanel();
	//	if(n==3) {
			RegistrarUsuarios.addTab("Cliente", null, panelCliente, null);
		//}
		panelCliente.setBackground(Color.decode("#4B5F83"));
		panelCliente.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(210, 80, 75, 20);
		lblNewLabel_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelCliente.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Cedula:");
		lblNewLabel_3.setBounds(210, 135, 63, 20);
		lblNewLabel_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelCliente.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Direccion:");
		lblNewLabel_4.setBounds(210, 220, 80, 28);
		lblNewLabel_4.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelCliente.add(lblNewLabel_4);
		
		JLabel lblTelefono_1 = new JLabel("Telefono:");
		lblTelefono_1.setBounds(210, 330, 75, 28);
		lblTelefono_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelCliente.add(lblTelefono_1);
		
		txtNomCliente = new JTextField();
		txtNomCliente.setBounds(334, 81, 86, 20);
		txtNomCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelCliente.add(txtNomCliente);
		txtNomCliente.setColumns(10);
		
		try {
			txtCedulaCliente = new JFormattedTextField(new MaskFormatter("###-#######-#"));
			txtCedulaCliente.setBounds(334, 136, 86, 20);
			txtCedulaCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelCliente.add(txtCedulaCliente);
		
		try {
			txtTelefonoCliente = new JFormattedTextField(new MaskFormatter("###-###-####"));
			txtTelefonoCliente.setBounds(334, 335, 86, 20);
			txtTelefonoCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelCliente.add(txtTelefonoCliente);
		
		JLabel lblId = new JLabel("Id:");
		lblId.setBounds(210, 26, 46, 14);
		lblId.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelCliente.add(lblId);
		
		txtIdCliente = new JTextField();
		txtIdCliente.setText(Tienda.getInstance().asignarIdCliente());
		txtIdCliente.setEnabled(false);
		txtIdCliente.setBounds(334, 24, 86, 20);
		txtIdCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelCliente.add(txtIdCliente);
		txtIdCliente.setColumns(10);
		
		txtDireccionCliente = new TextArea();
		txtDireccionCliente.setBounds(334, 187, 204, 102);
		txtDireccionCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelCliente.add(txtDireccionCliente);
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarCliente();
			}
		});
		label_2.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_user-add_216490.png")));
		label_2.setBounds(503, 364, 75, 64);
		panelCliente.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_3.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_v-11_3162629 (1).png")));
		label_3.setBounds(607, 385, 57, 43);
		panelCliente.add(label_3);
		
		panelAdministrador = new JPanel();
		//Sirve para mostrar la ventana 
	//	if(n==1) {
			RegistrarUsuarios.addTab("Administrador", null, panelAdministrador, null);
	//	}
		panelAdministrador.setBackground(Color.decode("#4B5F83"));
		panelAdministrador.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Id:");
		lblNewLabel_5.setBounds(196, 42, 46, 14);
		lblNewLabel_5.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(lblNewLabel_5);
		
		txtIdAdministrador = new JTextField();
		txtIdAdministrador.setText(Tienda.getInstance().asignarIdUsuario());
		txtIdAdministrador.setEnabled(false);
		txtIdAdministrador.setBounds(338, 40, 106, 20);
		txtIdAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelAdministrador.add(txtIdAdministrador);
		txtIdAdministrador.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(196, 85, 59, 14);
		lblNombre.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(lblNombre);
		
		txtNomAdministrador = new JTextField();
		txtNomAdministrador.setBounds(338, 83, 86, 20);
		txtNomAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelAdministrador.add(txtNomAdministrador);
		txtNomAdministrador.setColumns(10);
		
		JLabel lblCedula = new JLabel("Cedula:");
		lblCedula.setBounds(196, 124, 72, 18);
		lblCedula.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(lblCedula);
		
		try {
			txtCedulaAdministrador = new JFormattedTextField(new MaskFormatter("###-#######-#"));
			txtCedulaAdministrador.setBounds(338, 124, 86, 20);
			txtCedulaAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelAdministrador.add(txtCedulaAdministrador);
		
		JLabel lblDireccion_1 = new JLabel("Direcci\u00F3n:");
		lblDireccion_1.setBounds(196, 201, 86, 20);
		lblDireccion_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(lblDireccion_1);
		
		JLabel lblNewLabel_6 = new JLabel("Telefono:");
		lblNewLabel_6.setBounds(196, 281, 72, 20);
		lblNewLabel_6.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(lblNewLabel_6);
		
		try {
			txtTelefonoAdministrador = new JFormattedTextField(new MaskFormatter("###-###-####"));
			txtTelefonoAdministrador.setBounds(338, 282, 86, 20);
			txtTelefonoAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelAdministrador.add(txtTelefonoAdministrador);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(196, 325, 79, 14);
		lblUsuario.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(lblUsuario);
		
		txtUsuarioAdministrador = new JTextField();
		txtUsuarioAdministrador.setBounds(338, 323, 86, 20);
		txtUsuarioAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelAdministrador.add(txtUsuarioAdministrador);
		txtUsuarioAdministrador.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(196, 371, 79, 14);
		lblContrasea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(lblContrasea);
		
		txtContrasenaAdministrador = new JPasswordField();
		txtContrasenaAdministrador.setBounds(338, 368, 86, 20);
		txtContrasenaAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelAdministrador.add(txtContrasenaAdministrador);
		
		txtDireccionAdministrador = new TextArea();
		txtDireccionAdministrador.setBounds(338, 165, 197, 97);
		panelAdministrador.add(txtDireccionAdministrador);
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarAdministrador();
			}
		});
		label_4.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_user-add_216490.png")));
		label_4.setBounds(492, 373, 86, 64);
		panelAdministrador.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_5.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_v-11_3162629 (1).png")));
		label_5.setBounds(588, 389, 71, 48);
		panelAdministrador.add(label_5);
		
		panelVendedor = new JPanel();
	//	if(n==2) {
			RegistrarUsuarios.addTab("Vendedor", null, panelVendedor, null);
	//	}
		panelVendedor.setBackground(Color.decode("#4B5F83"));
		panelVendedor.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Id:");
		lblNewLabel_7.setBounds(229, 26, 46, 20);
		panelVendedor.add(lblNewLabel_7);
		
		txtIdVendedor = new JTextField();
		txtIdVendedor.setText(Tienda.getInstance().asignarIdUsuario());
		txtIdVendedor.setEnabled(false);
		txtIdVendedor.setBounds(334, 26, 86, 20);
		panelVendedor.add(txtIdVendedor);
		txtIdVendedor.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Nombre:");
		lblNewLabel_8.setBounds(228, 72, 68, 17);
		lblNewLabel_8.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVendedor.add(lblNewLabel_8);
		
		txtNomVendedor = new JTextField();
		txtNomVendedor.setBounds(334, 70, 86, 20);
		panelVendedor.add(txtNomVendedor);
		txtNomVendedor.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Cedula:");
		lblNewLabel_9.setBounds(229, 111, 68, 17);
		lblNewLabel_9.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVendedor.add(lblNewLabel_9);
		
		try {
			txtCedulaVendedor = new JFormattedTextField(new MaskFormatter("###-#######-#"));
			txtCedulaVendedor.setBounds(334, 109, 99, 20);
			txtCedulaVendedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelVendedor.add(txtCedulaVendedor);
		
		JLabel lblNewLabel_10 = new JLabel("Direccion:");
		lblNewLabel_10.setBounds(229, 200, 61, 14);
		lblNewLabel_10.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVendedor.add(lblNewLabel_10);
		
		
		
		JLabel lblTelefono_2 = new JLabel("Telefono:");
		lblTelefono_2.setBounds(229, 290, 76, 20);
		lblTelefono_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVendedor.add(lblTelefono_2);
		
		try {
			txtTelefonoVendedor = new JFormattedTextField(new MaskFormatter("###-###-####"));
			txtTelefonoVendedor.setBounds(334, 287, 86, 20);
			txtTelefonoVendedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panelVendedor.add(txtTelefonoVendedor);
		
		JLabel lblNewLabel_11 = new JLabel("Usuario:");
		lblNewLabel_11.setBounds(229, 334, 76, 30);
		lblNewLabel_11.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVendedor.add(lblNewLabel_11);
		
		txtUsuarioVendedor = new JTextField();
		txtUsuarioVendedor.setBounds(334, 331, 86, 20);
		txtUsuarioVendedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		panelVendedor.add(txtUsuarioVendedor);
		txtUsuarioVendedor.setColumns(10);
		
		JLabel lblContrasea_1 = new JLabel("Contrase\u00F1a:");
		lblContrasea_1.setBounds(228, 375, 86, 17);
		lblContrasea_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		panelVendedor.add(lblContrasea_1);
		
		txtContraVendedor = new JPasswordField();
		txtContraVendedor.setBounds(334, 372, 86, 20);
		panelVendedor.add(txtContraVendedor);
		
		
		
		TextArea textArea = new TextArea();
		textArea.setBounds(332, 156, 198, 107);
		panelVendedor.add(textArea);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				guardarVendedor();
			}
		});
		label_6.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_user-add_216490.png")));
		label_6.setBounds(505, 375, 76, 64);
		panelVendedor.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_7.setIcon(new ImageIcon(Registrar.class.getResource("/img/iconfinder_v-11_3162629 (1).png")));
		label_7.setBounds(609, 386, 68, 53);
		panelVendedor.add(label_7);

	}
	private void guardarProveedor() {
		Proveedor proveedo=Tienda.getInstance().buscarProveedor(txtCedulaProveedor.getText());
		String componente = cbxComponentProveedor.getSelectedItem().toString();	
		if(proveedo==null) {
			String id= txtidProveedor.getText();
			String nombre= txtNomProvedor.getText();
			String cedula= txtCedulaProveedor.getText();
			String direccion= txtDireccionProveedor.getText();
			String telefono= txtTelefonoProveedor.getText();
			Proveedor prove= new Proveedor(id,nombre, cedula, direccion, telefono);
			prove.insertarComponente(componente);
			Tienda.getInstance().insertarProveedores(prove);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanProveedor();
			
		}
		else if (Tienda.getInstance().existeProveedorConComponente(proveedo,componente)==false && proveedo!=null) {
			proveedo.insertarComponente(componente);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanProveedor();
		}
		else if (proveedo!=null || Tienda.getInstance().existeProveedorConComponente(proveedo,componente)==true) {
			JOptionPane.showMessageDialog(null, "El Proveedor ya existe", "Operación Incompleta", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void guardarCliente() {
		Cliente client= Tienda.getInstance().buscarCliente(txtCedulaCliente.getText());
		if(client==null) {
			String id= txtIdCliente.getText();
			String nombre= txtNomCliente.getText();
			String cedula= txtCedulaCliente.getText();
			String direccion= txtDireccionCliente.getText();
			String telefono= txtTelefonoCliente.getText();
			Cliente cliente= new Cliente(id,nombre, cedula, direccion, telefono);
			Tienda.getInstance().insertarCliente(cliente);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanCliente();
		}
		else if(Tienda.getInstance().buscarCliente(txtCedulaCliente.getText())!=null) {
			JOptionPane.showMessageDialog(null, "Operación Incompleta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void guardarAdministrador() {
		if(!(Tienda.getInstance().buscarUsuario(txtCedulaAdministrador.getText()) instanceof Administrador)) {
			String id= txtIdAdministrador.getText();
			String nombre= txtNomAdministrador.getText();
			String cedula= txtCedulaAdministrador.getText();
			String direccion= txtDireccionAdministrador.getText();
			String telefono= txtTelefonoAdministrador.getText();
			String usuario= txtUsuarioAdministrador.getText();
			String contra= String.valueOf(txtContrasenaAdministrador.getPassword());
			Administrador admin= new Administrador(nombre, cedula, direccion, telefono, usuario, contra, id);
			Tienda.getInstance().insertarAdministrador(admin);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanAdministrador();
		}
		else if (Tienda.getInstance().buscarUsuario(txtCedulaAdministrador.getText()) instanceof Administrador) {
			JOptionPane.showMessageDialog(null, "Operación Incompleta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void guardarVendedor() {
		if(!(Tienda.getInstance().buscarUsuario(txtCedulaProveedor.getText()) instanceof Vendedor)) {
			String id= txtIdAdministrador.getText();
			String nombre= txtNomVendedor.getText();
			String cedula= txtCedulaVendedor.getText();
			String direccion= txtDireccionProveedor.getText();
			String telefono= txtTelefonoVendedor.getText();
			String usuario= txtUsuarioVendedor.getText();
			String contra= String.valueOf(txtContraVendedor.getPassword());
			Vendedor vende= new Vendedor(nombre, cedula, direccion, telefono, usuario, contra, id);
			Tienda.getInstance().insertarVendedor(vende);
			try {
				Tienda.getInstance().guardarDatos();
			} catch (ClassNotFoundException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Operacion Exitosa", "Informacion", JOptionPane.INFORMATION_MESSAGE);
			cleanVendedor();
		}
		else if ((Tienda.getInstance().buscarUsuario(txtCedulaProveedor.getText()) instanceof Vendedor)) {
			JOptionPane.showMessageDialog(null, "Operación Incompleta", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	private void cleanProveedor() {
		txtidProveedor.setText(Tienda.getInstance().asignarIdProveedor());
		txtNomProvedor.setText("");
		txtCedulaProveedor.setValue("");
		txtDireccionProveedor.setText("");
		txtTelefonoProveedor.setValue("");
		cbxComponentProveedor.setSelectedIndex(0);
	}
	private void cleanCliente() {
		txtIdCliente.setText(Tienda.getInstance().asignarIdCliente());
		txtNomCliente.setText("");
		txtCedulaCliente.setValue("");
		txtDireccionCliente.setText("");
		txtTelefonoCliente.setValue("");
	}
	private void cleanAdministrador() {
		txtIdAdministrador.setText(Tienda.getInstance().asignarIdUsuario());
		txtNomAdministrador.setText("");
		txtCedulaAdministrador.setValue("");
		txtDireccionAdministrador.setText("");
		txtTelefonoAdministrador.setValue("");
		txtUsuarioAdministrador.setText("");
		txtContrasenaAdministrador.setText("");
	}
	private void cleanVendedor() {
		txtIdVendedor.setText(Tienda.getInstance().asignarIdUsuario());
		txtNomVendedor.setText("");
		txtCedulaVendedor.setValue("");
		txtDireccionProveedor.setText("");
		txtTelefonoVendedor.setValue("");
		txtUsuarioVendedor.setText("");
		txtContraVendedor.setText("");
	}
//	private void loadPanel(int n) {
//		if(n==4) {
//			panelProveedor = new JPanel();
//			RegistrarUsuarios.addTab("Proveedor", null, panelProveedor, null);
//			panelProveedor.setBackground(Color.decode("#4B5F83"));
//			panelProveedor.setLayout(null);
//		}
//		else if(n==3) {
//			panelCliente = new JPanel();
//			RegistrarUsuarios.addTab("Cliente", null, panelCliente, null);
//			panelCliente.setBackground(Color.decode("#4B5F83"));
//			panelCliente.setLayout(null);
//		}
//		else if(n==2) {
//			panelVendedor = new JPanel();
//			RegistrarUsuarios.addTab("Vendedor", null, panelVendedor, null);
//			panelVendedor.setBackground(Color.decode("#4B5F83"));
//			panelVendedor.setLayout(null);
//		}
//		else if(n==1) {
//			panelAdministrador = new JPanel();
//			RegistrarUsuarios.addTab("Administrador", null, panelAdministrador, null);
//			panelAdministrador.setBackground(Color.decode("#4B5F83"));
//			panelAdministrador.setLayout(null);
//		}
	
//	}

}
