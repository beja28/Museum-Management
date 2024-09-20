package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.List;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Usuario;

public class VentanaPrincipalEmpleados extends JFrame{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		private List<Usuario> datos;
		private AbstractTableModel model;
		private JLabel cabeceratabla;
		private JTable tabla ;
		private JScrollPane scrollPane ;
		private JPanel panel,paneltabla,panelcabecera;
		private JButton modificar,actualizar,cerrarsesion;
		private int selectedrow;
		private Color customColor ;
		private ImageIcon iconactu,iconmodi,iconcerrarsesion,iconlogo;
		private Font fontnegrita, newFont;
		private Image imgactu,imgmodi,imgcerrarsesion,imglogo;
		static Controller ctlr;
		private MainWindow main;
		private BoxLayout layoutmain;
		private JButton admin;
		private VentanaAdmin adm;
		
		public VentanaPrincipalEmpleados() {}
		
	    public VentanaPrincipalEmpleados(Controller ctlr, MainWindow main, VentanaAdmin admin) {
	    	VentanaPrincipalEmpleados.ctlr = ctlr;
	    	adm = admin;
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
	    	paneltabla= new JPanel();
	    	panelcabecera= new JPanel();
	    	
	    	cabeceratabla= new JLabel("<html> Funciones de la ventana: <br> - Si selecciona un empleado de la tabla puede darle de baja o modificarlo <br> - Si desea puede dar alta un nuevo empleado <br> - Se pueden actualizar los datos de la tabla </html>");
	    	fontnegrita = cabeceratabla.getFont();
	    	newFont = new Font(fontnegrita.getName(), Font.BOLD, 16);
	    	cabeceratabla.setFont(newFont);
	    	
	    	modificar= new JButton("Alta/Baja/Modificar");
	    	actualizar= new JButton("Actualizar Tabla");
	    	cerrarsesion= new JButton("Cerrar sesion");
	    	
	    	tabla= new JTable(model);
	        scrollPane = new JScrollPane(tabla);
	      
	        customColor=new Color(79, 101, 112);
	        panel.setBackground(customColor);
	 		paneltabla.setBackground(customColor);
	 		panelcabecera.setBackground(customColor);      
	 		
	 		actualizar.setBackground(Color.WHITE);
	 		modificar.setBackground(Color.WHITE);
	 		cerrarsesion.setBackground(Color.WHITE);
	 		
	 		admin = new JButton("Admin");
	        admin.setToolTipText("Volver a Servicios de Administrador");
	        admin.setBackground(Color.WHITE);
	        admin.setAlignmentX(Component.RIGHT_ALIGNMENT);
	        admin.setAlignmentY(Component.TOP_ALIGNMENT);
	        admin.setSize(new Dimension(60,60));
	        admin.addActionListener((e)->{
	 		       adm.volver();
	 		       this.dispose();
	        });
	 		
	 		iconlogo= new ImageIcon("logo/logo.png");
	 		imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	 		
	    	iconactu= new ImageIcon("logo/actualizar.png");
	 		imgactu = iconactu.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
	 		
	 		iconmodi= new ImageIcon("logo/lapiz.png");
	 		imgmodi = iconmodi.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
	 		
	 		iconcerrarsesion= new ImageIcon("logo/cerrarsesion.png");
	 		imgcerrarsesion = iconcerrarsesion.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
	 		
	 		setIconImage(imglogo);
	 		actualizar.setIcon(new ImageIcon(imgactu));
	 		modificar.setIcon(new ImageIcon(imgmodi));
	 		cerrarsesion.setIcon(new ImageIcon(imgcerrarsesion));
	 		
	 		 cerrarsesion.addActionListener((e)->{
	         	main.volver();
	         	this.dispose();
	         });
	 		 
	        modificar.addActionListener((e) -> {
	        	
	        	Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
	        	// Calcular la posición del frame en el centro de la pantalla
	        	int posX = (pantalla.width - getWidth()) / 2;
	        	int posY = (pantalla.height - getHeight()) / 2;
	        	
	        	VentanaCrudEmpleados cv ;
	        	selectedrow=tabla.getSelectedRow();
	        	tabla.clearSelection();
	        	Usuario aux;
	        	if(selectedrow==-1) {
	        		cv = new VentanaCrudEmpleados(ctlr);
	        	}else {
	        		aux= datos.get(selectedrow);
	        		cv = new VentanaCrudEmpleados(ctlr,aux);
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
	        
	        
			 GroupLayout layout = new GroupLayout(paneltabla);
			 paneltabla.setLayout(layout);
			    layout.setHorizontalGroup(
			        layout.createSequentialGroup()
			        .addGap(30)
	        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
	        				
	        				.addComponent(scrollPane)
	        				.addGroup(layout.createSequentialGroup()
	        				.addComponent(modificar,175,175,175)
	        				.addGap(30)
	        				.addComponent(actualizar,175,175,175)
	        				.addGap(30)
	        				.addComponent(cerrarsesion,150,150,150))
	        		)
	        		.addGap(30)
			  );
		    layout.setVerticalGroup(
			        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
			        	
			        	.addGroup(layout.createSequentialGroup()
			        		
			        		.addGap(20)
			        		.addComponent(scrollPane)
			        		.addGap(30)
			        		.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
				        		.addComponent(modificar,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE)
				        		.addComponent(actualizar,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE)
			        			.addComponent(cerrarsesion,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE))
			        		
			        	)
			        	
			  );
	        
	        
	        panelcabecera.add(cabeceratabla);
	       
	        panelcabecera.setBorder(new PanelBordeRedondeado(70,1,Color.BLACK, new Color(243, 212, 10)));
	        
	        layoutmain= new BoxLayout(panel, BoxLayout.Y_AXIS);
			panel.setLayout(layoutmain);
			panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 10));
	        panel.add(panelcabecera);
	        panel.add(paneltabla);
	    	setContentPane(panel);
	    	JPanel administr = new JPanel();
	    	administr.setBackground(customColor);
	    	panel.add(Box.createRigidArea(new Dimension(0,20)));
	    	administr.add(admin);
	    	panel.add(administr, BorderLayout.AFTER_LAST_LINE);
	    	setLocation(450,75);
			this.setResizable(false);
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
