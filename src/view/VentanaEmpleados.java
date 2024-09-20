package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Usuario;

public class VentanaEmpleados extends JFrame{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		List<Usuario> datos;
		AbstractTableModel model;
		JLabel cabeceratabla;
		JTable tabla ;
		JScrollPane scrollPane ;
		JPanel panel;
		JButton modificar,actualizar,volver;
		int selectedrow;
		Color customColor ;
 		ImageIcon iconactu,iconmodi;
 		Font fontnegrita, newFont;
 		Image imgactu,imgmodi;
		static Controller ctlr;
		private MainWindow main;
		
		public VentanaEmpleados() {}
		
	    public VentanaEmpleados(Controller ctlr, MainWindow main) {
	    	this.ctlr = ctlr;
	    	this.main = main;
	        initComponents();
	    }
	    
	    private void initComponents() {
	    	
	    	setResizable(false);
	    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	    	setTitle("Tabla de Empleados");
	    	

	    	datos= ctlr.Usuarios();
	    	crearModeloTabla();
	    	
	    	panel= new JPanel();
	    	
	    	cabeceratabla= new JLabel("Elija el empleado que desea modificar");
	    	fontnegrita = cabeceratabla.getFont();
	    	newFont = new Font(fontnegrita.getName(), Font.BOLD, 20);
	    	cabeceratabla.setFont(newFont);
	    	
	    	modificar= new JButton("Modificar");
	    	actualizar= new JButton("Actualizar");
	    	volver= new JButton("Cerrar sesion");
	    	
	    	tabla= new JTable(model);
	        scrollPane = new JScrollPane(tabla);
	      
	        customColor=new Color(255, 255, 255); // Color rojo (R: 255, G: 0, B: 0)
	 		panel.setBackground(customColor);
	        
	 		
	 		actualizar.setBackground(customColor);
	 		modificar.setBackground( customColor);
	 		volver.setBackground( customColor);
	 		
	    	iconactu= new ImageIcon("logo/actualizar.png");
	 		imgactu = iconactu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
	 		
	 		iconmodi= new ImageIcon("logo/lapiz.png");
	 		imgmodi = iconmodi.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
	 		
	 		actualizar.setIcon(new ImageIcon(imgactu));
	 		modificar.setIcon(new ImageIcon(imgmodi));
	 		
	 		 volver.addActionListener((e)->{
	         	main.volver();
	         	this.dispose();
	         });
	 		 
	        modificar.addActionListener((e) -> {
	        	
	        	Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	        	// Calcular la posición del frame en el centro de la pantalla
	        	int posX = (pantalla.width - getWidth()) / 2;
	        	int posY = (pantalla.height - getHeight()) / 2;
	        	
	        	VentanaModi cv ;
	        	selectedrow=tabla.getSelectedRow();
	        	tabla.clearSelection();
	        	Usuario aux;
	        	if(selectedrow==-1) {
	        		cv = new VentanaModi(ctlr);
	        	}else {
	        		aux= datos.get(selectedrow);
	        		cv = new VentanaModi(ctlr,aux);
	        	}
	        	cv.setLocation(posX,posY);
	        	
			});
	        
	        actualizar.addActionListener((e) -> {
	        	      
	        	tabla.clearSelection();
	        	
	        	datos= ctlr.Usuarios();
	        	crearModeloTabla();
	        	((AbstractTableModel) model).fireTableDataChanged();
	        	
	        	tabla.revalidate();
	        	tabla.repaint();
	        	
	        });
	        
	        
			 GroupLayout layout = new GroupLayout(panel);
			 panel.setLayout(layout);
			    layout.setHorizontalGroup(
			        layout.createSequentialGroup()
			        .addGap(30)
	        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	        				.addComponent(cabeceratabla)
	        				.addComponent(scrollPane)
	        				.addGroup(layout.createSequentialGroup()
	        				.addComponent(modificar,125,125,125)
	        				.addGap(30)
	        				.addComponent(actualizar,125,125,125)
	        				.addGap(30)
	        				.addComponent(volver,125,125,125))
	        		)
	        		.addGap(30)
			  );
		    layout.setVerticalGroup(
			        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			        	
			        	.addGroup(layout.createSequentialGroup()
			        		.addGap(20)
			        		.addComponent(cabeceratabla)
			        		.addGap(10)
			        		.addComponent(scrollPane)
			        		.addGap(30)
			        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				        		.addComponent(modificar,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE)
				        		.addComponent(actualizar,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE)
			        			.addComponent(volver,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE))
			        		.addGap(20)
			        	)
			        	
			  );
	        
	        
	        panel.add(scrollPane);
	        panel.add(modificar);
	        
	    	setContentPane(panel);
	    	
	    	pack();
	        setVisible(true);
	    	
	    }
	    
	    private void crearModeloTabla() {
	    	
	    	 model = new AbstractTableModel() {
	             // Define las columnas de la tabla
	    		 String[] cabecera = { "DNI", "Nombre", "Puesto","Contraseña"};

	             // Implementa los métodos de TableModel
	             @Override
	             public int getRowCount() {
	                 return datos.size();
	             }

	             @Override
	             public int getColumnCount() {
	                 return cabecera.length;
	             }

	             @Override
	             public Object getValueAt(int rowIndex, int columnIndex) {
	                 switch (columnIndex) {
	                     case 0:
	                         return datos.get(rowIndex).getDNI();
	                     case 1:
	                         return datos.get(rowIndex).getNombre();
	                     case 2:
	                         return datos.get(rowIndex).getPuesto();
	                     case 3:
	                         return datos.get(rowIndex).getContraseña();
	                     default:
	                         return null;
	                 }
	             }

	             @Override
	             public String getColumnName(int column) {
	                 return cabecera[column];
	             }
	         };
	    }
}
