package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

import Logico.DiscoDuro;
import Logico.Kit;
import Logico.Motherboard;
import Logico.Procesador;
import Logico.Ram;
import Logico.Tienda;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Graficos extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			Graficos dialog = new Graficos();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public Graficos(int n) {
		if(n==0) {
			cargarMayoresProductosVendidos();
		}
		else if(n>0) {
			cargarVentaporMarca(n);
			
		}
		try {
			Tienda.getInstance().cargarDatos();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(100, 100, 893, 615);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(Color.decode("#4B5F83"));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			{
				
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
	}
	  private void cargarMayoresProductosVendidos() {
			JPanel MayoresProductosVendidos = new JPanel();
			MayoresProductosVendidos.setBounds(56, 39, 785, 484);
			contentPanel.add(MayoresProductosVendidos);
		  // Fuente de Datos
		  	ArrayList<String> lista= buscarMasVendidos();
	        DefaultPieDataset data = new DefaultPieDataset();
	        data.setValue("Motherboard",Integer.parseInt(lista.get(0)));
	        data.setValue("Procesador",	Integer.parseInt(lista.get(1)));
	        data.setValue("Memoria Ram", Integer.parseInt(lista.get(2)));
	        data.setValue("Disco Duro", Integer.parseInt(lista.get(3)));
	        data.setValue("Kit", Integer.parseInt(lista.get(4)));
	 
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createPieChart3D("Mayores Productos Vendidos", data, true, true, false); 
	        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot(); 
	        pieplot3d.setDepthFactor(0.5); 
	        pieplot3d.setStartAngle(290D); 
	        pieplot3d.setDirection(Rotation.CLOCKWISE); 
	        pieplot3d.setForegroundAlpha(0.5F); 
	 
	        // Crear el Panel del Grafico con ChartPanel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        MayoresProductosVendidos.add(chartPanel);
	  }
	  private ArrayList<String> buscarMasVendidos(){
		  ArrayList<String> lista= new ArrayList<>();
		  Integer mother=0,proce=0,memoria=0,disco=0,kit=0;
		  //0 motherboard,1 procesador,2 memoria ram,3 disco duro,4 kit
		  for (int i = 0; i < Tienda.getInstance().getVentas().size(); i++) {
			  for (int j = 0; j < Tienda.getInstance().getVentas().get(i).getComponente().size(); j++) {
				if(Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof Motherboard) {
					System.out.println("Mother");
					mother++;
					}
				else if(Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof Procesador) {
					System.out.println("Proce");
					proce++;
					}
				else if (Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof Ram) {
					System.out.println("Ram");
					memoria++;
					}
				else if (Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof DiscoDuro) {
					System.out.println("Disco");
					disco++;
					}
			  	}
			  	for (int j = 0; j < Tienda.getInstance().getVentas().get(i).getKits().size(); j++) {
				  System.out.println("Kit");
				  kit++;
			  	}			
			}
		  lista.add(String.valueOf(mother));
		  lista.add(String.valueOf(proce));
		  lista.add(String.valueOf(memoria));
		  lista.add(String.valueOf(disco));
		  lista.add(String.valueOf(kit));	
		  return lista;
	  }
	  private void cargarVentaporMarca(int n) {
		  	JPanel VentaporMarca = new JPanel();
			VentaporMarca.setBounds(56, 39, 785, 484);
			contentPanel.add(VentaporMarca);
		  // Fuente de Datos
		  	ArrayList<String> marca= new ArrayList<>(); 
	        DefaultPieDataset data = new DefaultPieDataset();
	        for (int i = 0; i < Tienda.getInstance().getVentas().size(); i++) {
				for (int j = 0; j < Tienda.getInstance().getVentas().get(i).getComponente().size(); j++) {
					if(n==1 && Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof Motherboard) {
						marca.add(Tienda.getInstance().getVentas().get(i).getComponente().get(j).getMarca());
					}
					else if(n==2 && Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof Procesador) {
						marca.add(Tienda.getInstance().getVentas().get(i).getComponente().get(j).getMarca());
					}
					else if (n==3 && Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof Ram) {
						marca.add(Tienda.getInstance().getVentas().get(i).getComponente().get(j).getMarca());
					}
					else if (n==4 && Tienda.getInstance().getVentas().get(i).getComponente().get(j) instanceof DiscoDuro) {
						marca.add(Tienda.getInstance().getVentas().get(i).getComponente().get(j).getMarca());
					}								
				}
			}
	        for (int i = 0; i < Tienda.getInstance().getVentas().size(); i++) {
				for (int j = 0; j < Tienda.getInstance().getVentas().get(i).getKits().size(); j++) {
					if(n==5 && Tienda.getInstance().getVentas().get(i).getKits().get(j) instanceof Kit) {
						marca.add(Tienda.getInstance().getVentas().get(i).getKits().get(j).getNombre());
					}
				}
	        }
	        for (int i = 0; i < marca.size(); i++) {
				data.setValue(marca.get(i), retornarCantidad(marca, marca.get(i)));
			}
	        // Creando el Grafico
	        JFreeChart chart = ChartFactory.createPieChart3D("Venta por Marca", data, true, true, false); 
	        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot(); 
	        pieplot3d.setDepthFactor(0.5); 
	        pieplot3d.setStartAngle(290D); 
	        pieplot3d.setDirection(Rotation.CLOCKWISE); 
	        pieplot3d.setForegroundAlpha(0.5F); 
	 
	        // Crear el Panel del Grafico con ChartPanel
	        ChartPanel chartPanel = new ChartPanel(chart);
	        VentaporMarca.add(chartPanel);
	  }
	  private int retornarCantidad(ArrayList<String> arreglo,String marca) {
		  int n=0;
		  for (int i = 0; i < arreglo.size(); i++) {
			  if(arreglo.get(i).equalsIgnoreCase(marca)) {
				  n++;
			  }
		  }
		  return n;
	  }
}
