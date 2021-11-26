package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import Logico.Administrador;
import Logico.Tienda;
import Logico.Usuario;
import Logico.Vendedor;
import sun.util.BuddhistCalendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtname;
	private JPasswordField txtPass;
	private JButton btnAceptar;
	private boolean loggedin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tienda.getInstance().cargarDatos();
				}
				catch(Exception e){
					try {
						Tienda.getInstance().guardarDatos();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setTitle("Iniciar Sesión");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 442, 261);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#4B5F83"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		txtname = new JTextField();
		txtname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtname.setBounds(257, 60, 122, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 16));
		lblUsuario.setBounds(162, 59, 82, 19);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 16));
		lblContrasea.setBounds(162, 104, 107, 20);
		contentPane.add(lblContrasea);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(257, 105, 122, 20);
		contentPane.add(txtPass);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Login.class.getResource("/img/iconfinder_key_309058.png")));
		label.setBounds(21, 25, 129, 135);
		contentPane.add(label);
		
		JLabel Aceptar = new JLabel("");
		Aceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(existeCuenta()!=null) {
					System.out.println("Arly");
					Usuario user=null;
					if(existeCuenta() instanceof Administrador && existeCuenta().isHabilitado()==true) {
						//Escribir administrador y orientarlo a este
						user=existeCuenta(); //Marca el true de que el usuario se conecto
						user.setConexion(true);
						try {
							Tienda.getInstance().guardarDatos();
						} catch (ClassNotFoundException | IOException e1) {
						}
						System.out.println("re");
						Principal er= new Principal(1);
						er.setVisible(true);
						dispose();
					}
					else if (existeCuenta() instanceof Vendedor && existeCuenta().isHabilitado()==true ) {
						//Escribir ventana Vendedor aqui
						user=null;
						user=existeCuenta();
						user.setConexion(true);
						try {
							Tienda.getInstance().guardarDatos();
						} catch (ClassNotFoundException | IOException e1) {
						}
						System.out.println("so");
						Principal er= new Principal(2);
						er.setVisible(true);
						dispose();
						
					}
					else if(existeCuenta().isHabilitado()==false) {
						JOptionPane.showMessageDialog(null, "Usuario deshabilitado, comunicarse con el administrador", "Error", JOptionPane.ERROR_MESSAGE);
						clean();
					}
				}
				else if(existeCuenta()==null) {
					JOptionPane.showMessageDialog(null, "No existe", "Error", JOptionPane.ERROR_MESSAGE);
					clean();
				}
			}
		});
		Aceptar.setIcon(new ImageIcon(Login.class.getResource("/img/iconfinder_login_account_enter_door_3005767.png")));
		Aceptar.setBounds(255, 167, 45, 44);
		contentPane.add(Aceptar);
		
		JLabel Cancelar = new JLabel("");
		Cancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		Cancelar.setIcon(new ImageIcon(Login.class.getResource("/img/iconfinder_v-11_3162629 (1).png")));
		Cancelar.setBounds(331, 167, 45, 44);
		contentPane.add(Cancelar);
	}
	
	public Usuario existeCuenta() {
		Usuario usuario= null;
		for (int i = 0; i < Tienda.getInstance().getUsuarios().size(); i++) {
			//String myPass=String.valueOf(txtPass.getPassword()); ---Se puede utilizar para convertir array to string
			String pass= new String(txtPass.getPassword());
			if(txtname.getText().equalsIgnoreCase(Tienda.getInstance().getUsuarios().get(i).getUsuario()) && pass.equalsIgnoreCase(Tienda.getInstance().getUsuarios().get(i).getClave()) )
			{
				usuario= Tienda.getInstance().getUsuarios().get(i);
			}
		}
		return usuario;
	}
	public void clean() {
		txtname.setText("");
		txtPass.setText("");
	}
}