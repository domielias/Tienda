package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logico.Administrador;
import Logico.Tienda;
import Logico.Vendedor;

import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Vendedor vendedor;
	private JMenu mnAdministrador;
	private JMenu mnVendedor;
	private Administrador admin;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Principal frame = new Principal();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Principal(int n) {
		setTitle("Tienda");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 562);
		vendedorVenta();
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		// if (n==1) {
			mnAdministrador = new JMenu("Administrador");
			mnAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
			menuBar.add(mnAdministrador);
		//}
		JMenu mnAdministradores = new JMenu("Administradores");
		mnAdministrador.add(mnAdministradores);
		mnAdministradores.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmRegistrarAdministrador = new JMenuItem("Registrar Administrador");
		mntmRegistrarAdministrador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar reg= new Registrar(1);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnAdministradores.add(mntmRegistrarAdministrador);
		mntmRegistrarAdministrador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmListarAdministradores = new JMenuItem("Listar Administradores");
		mntmListarAdministradores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuario list= new ListarUsuario(1);
				list.setModal(true);
				list.setVisible(true);
			}
		});
		mnAdministradores.add(mntmListarAdministradores);
		mntmListarAdministradores.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnNewMenu = new JMenu("Vendedores");
		
		mnAdministrador.add(mnNewMenu);
		mnNewMenu.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmRegistrarVendedor = new JMenuItem("Registrar Vendedor");
		mntmRegistrarVendedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar reg= new Registrar(2);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnNewMenu.add(mntmRegistrarVendedor);
		mntmRegistrarVendedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmListarVendedores = new JMenuItem("Listar Vendedores");
		mntmListarVendedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuario listar= new ListarUsuario(2);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnNewMenu.add(mntmListarVendedores);
		mntmListarVendedores.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnProveedores = new JMenu("Proveedores");
		mnAdministrador.add(mnProveedores);
		mnProveedores.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmRegistrarProveedor = new JMenuItem("Registrar Proveedor");
		mntmRegistrarProveedor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Registrar reg= new Registrar(4);
			reg.setModal(true);
			reg.setVisible(true);
			}
		});
		mnProveedores.add(mntmRegistrarProveedor);
		mntmRegistrarProveedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmListarProveedores = new JMenuItem("Listar Proveedores");
		mntmListarProveedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuario listar= new ListarUsuario(4);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnProveedores.add(mntmListarProveedores);
		mntmListarProveedores.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnClientes = new JMenu("Clientes");
		mnAdministrador.add(mnClientes);
		mnClientes.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmListarClientes = new JMenuItem("Listar Clientes");
		mntmListarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarUsuario lista= new ListarUsuario(3);
				lista.setModal(true);
				lista.setVisible(true);
			}
		});
		mnClientes.add(mntmListarClientes);
		mntmListarClientes.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnProductos = new JMenu("Productos");
		mnAdministrador.add(mnProductos);
		mnProductos.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnRegistrar = new JMenu("Registrar");
		mnProductos.add(mnRegistrar);
		
		JMenuItem mntmMotherboard_1 = new JMenuItem("MotherBoard");
		mntmMotherboard_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProductos reg= new RegistrarProductos(1);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnRegistrar.add(mntmMotherboard_1);
		
		JMenuItem mntmProcesador_1 = new JMenuItem("Procesador");
		mntmProcesador_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProductos reg= new RegistrarProductos(2);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnRegistrar.add(mntmProcesador_1);
		
		JMenuItem mntmMemoriaRam_1 = new JMenuItem("Memoria Ram");
		mntmMemoriaRam_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProductos reg= new RegistrarProductos(3);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnRegistrar.add(mntmMemoriaRam_1);
		
		JMenuItem mntmDiscoDuro_1 = new JMenuItem("Disco Duro");
		mntmDiscoDuro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProductos reg= new RegistrarProductos(4);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnRegistrar.add(mntmDiscoDuro_1);
		
		JMenuItem mntmKit_1 = new JMenuItem("Kit");
		mntmKit_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrarProductos reg= new RegistrarProductos(5);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mnRegistrar.add(mntmKit_1);
		
		JMenu mnListar = new JMenu("Listar");
		mnProductos.add(mnListar);
		mnListar.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmMotherboard = new JMenuItem("Motherboard");
		mntmMotherboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProductos lista= new ListarProductos(1);
				lista.setModal(true);
				lista.setVisible(true);
			}
		});
		mnListar.add(mntmMotherboard);
		mntmMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmProcesador = new JMenuItem("Procesador");
		mntmProcesador.setIcon(new ImageIcon(Principal.class.getResource("/img/iconfinder_processor__computer__microchip__cpu__chip__device__frequency_2317836.png")));
		mntmProcesador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProductos listar= new ListarProductos(2);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnListar.add(mntmProcesador);
		mntmProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmMemoriaRam = new JMenuItem("Memoria Ram");
		mntmMemoriaRam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProductos listar= new ListarProductos(3);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnListar.add(mntmMemoriaRam);
		mntmMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmDiscoDuro = new JMenuItem("Disco Duro");
		mntmDiscoDuro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProductos listar = new ListarProductos(4);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnListar.add(mntmDiscoDuro);
		mntmDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmKit = new JMenuItem("Kit");
		mntmKit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarProductos listar = new ListarProductos(5);
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnListar.add(mntmKit);
		mntmKit.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnEstadisticas = new JMenu("Estadisticas");
		mnAdministrador.add(mnEstadisticas);
		mnEstadisticas.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnMotherboard = new JMenu("Motherboard");
		mnEstadisticas.add(mnMotherboard);
		mnMotherboard.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmVentasPorMarca = new JMenuItem("Ventas por Marca");
		mntmVentasPorMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graficos grafi= new Graficos(1);
				grafi.setModal(true);
				grafi.setVisible(true);
			}
		});
		mnMotherboard.add(mntmVentasPorMarca);
		mntmVentasPorMarca.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnProcesador = new JMenu("Procesador");
		mnEstadisticas.add(mnProcesador);
		mnProcesador.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmVentasPorMarca_1 = new JMenuItem("Ventas por Marca");
		mntmVentasPorMarca_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graficos grafi= new Graficos(2);
				grafi.setModal(true);
				grafi.setVisible(true);
			}
		});
		mnProcesador.add(mntmVentasPorMarca_1);
		mntmVentasPorMarca_1.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnMemoriaRam = new JMenu("Memoria Ram");
		mnEstadisticas.add(mnMemoriaRam);
		mnMemoriaRam.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmVentasPorMarca_2 = new JMenuItem("Ventas por Marca");
		mntmVentasPorMarca_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graficos grafi= new Graficos(3);
				grafi.setModal(true);
				grafi.setVisible(true);
			}
		});
		mnMemoriaRam.add(mntmVentasPorMarca_2);
		mntmVentasPorMarca_2.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnDiscoDuro = new JMenu("Disco Duro");
		mnEstadisticas.add(mnDiscoDuro);
		mnDiscoDuro.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmVentasPorMarca_3 = new JMenuItem("Ventas por Marca");
		mntmVentasPorMarca_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graficos grafi= new Graficos(4);
				grafi.setModal(true);
				grafi.setVisible(true);
			}
		});
		mnDiscoDuro.add(mntmVentasPorMarca_3);
		mntmVentasPorMarca_3.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnKits = new JMenu("Kits");
		mnEstadisticas.add(mnKits);
		mnKits.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmVentasPorCombos = new JMenuItem("Ventas por Combos");
		mntmVentasPorCombos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graficos grafi= new Graficos(5);
				grafi.setModal(true);
				grafi.setVisible(true);
			}
		});
		mnKits.add(mntmVentasPorCombos);
		mntmVentasPorCombos.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnVentas = new JMenu("Ventas");
		mnEstadisticas.add(mnVentas);
		
		JMenuItem mntmMayores = new JMenuItem("Mayores Productos Vendidos");
		mntmMayores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Graficos grafi= new Graficos(0);
				grafi.setModal(true);
				grafi.setVisible(true);
			}
		});
		mnVentas.add(mntmMayores);
		
		JMenuItem mntmGananciasEstimadasTotales = new JMenuItem("Ganancias Estimadas Totales");
		mntmGananciasEstimadasTotales.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarGanancias listar= new ListarGanancias();
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		mnVentas.add(mntmGananciasEstimadasTotales);
		
		//	if(n==2) {
				mnVendedor = new JMenu("Vendedor");
			menuBar.add(mnVendedor); 
			mnVendedor.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
	//	}
		JMenuItem mntmVenta = new JMenuItem("Realizar Facturación");
		mntmVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventas venta= new Ventas();
				venta.setModal(true);
				venta.setVisible(true);
			}
		});
		mnVendedor.add(mntmVenta);
		mntmVenta.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenuItem mntmListarVentasRealizadas = new JMenuItem("Listar Ventas Realizadas");
		mntmListarVentasRealizadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListarVentas listar= new ListarVentas();
				listar.setModal(true);
				listar.setVisible(true);
			}
		});
		
		JMenuItem mntmRegistrarCliente = new JMenuItem("Registrar Cliente");
		mntmRegistrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registrar reg= new Registrar(3);
				reg.setModal(true);
				reg.setVisible(true);
			}
		});
		mntmRegistrarCliente.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		mnVendedor.add(mntmRegistrarCliente);
		mnVendedor.add(mntmListarVentasRealizadas);
		mntmListarVentasRealizadas.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		
		JMenu mnUsuario = new JMenu("Usuario");
		menuBar.add(mnUsuario);
		mnUsuario.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 14));
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mntmCerrarSesin.setIcon(new ImageIcon(Principal.class.getResource("/img/iconfinder_v-11_3162629 (3).png")));
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int dialogResult =JOptionPane.showConfirmDialog(null, "¿Esta seguro de cerrar la sesión?", "Información",JOptionPane.YES_NO_OPTION);
				if(dialogResult==JOptionPane.YES_OPTION) {
					if(vendedor!=null) {
						vendedor.setConexion(false);
					}
					else if(admin!=null) {
						admin.setConexion(false);
					}
					try {
						Tienda.getInstance().guardarDatos();
					} catch (ClassNotFoundException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
					Login logi= new Login();
					logi.setVisible(true);
				}
				else if(dialogResult==JOptionPane.NO_OPTION) {
					return;
				}
			}
		});
		mnUsuario.add(mntmCerrarSesin);
		mntmCerrarSesin.setFont(new Font("Microsoft PhagsPa", Font.PLAIN, 13));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.decode("#4B5F83"));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(176, 102, 251, 291);
		label.setIcon(new ImageIcon(Principal.class.getResource("/img/iconfinder_shop_2639918.png")));
		contentPane.add(label);
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
