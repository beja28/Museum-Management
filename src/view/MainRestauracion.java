package view;
//package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import control.Controller;



//import control.Controller;


public class MainRestauracion extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private Controller ctrl;
	private MainWindow main;
	private VentanaAdmin admin;
	private JLabel mensaje;
	private JLabel icono;
	private JButton consultaObra;
	private JButton modificaObra;
	private JButton altaObra;
	private JButton bajaObra;
	private JButton volver;
	private JButton botonAdmin;
	private ImageIcon iconConsulta,iconmodi,iconcerrarsesion,iconbajaObra, iconaltaObra;
	private Image imgConsulta,imgmodi,imgcerrarsesion,imgbajaObra, imgaltaObra;
	
    public MainRestauracion(Controller ctrl, MainWindow main, VentanaAdmin admin) {
    	this.main = main;
    	this.ctrl = ctrl;
    	this.admin = admin;
        initComponents();
    }
   
    private void initComponents() {

    	Color color = new Color(253, 221, 202 );
    	JPanel mainPanel = new JPanel(new BorderLayout());
    	//mainPanel.setBackground(Color.black);
 		setContentPane(mainPanel);
 		
        //Titulo
        icono = new JLabel();
        icono.setIcon(loadImage("logo/iconoObras.png"));
		JPanel panelLogo = new JPanel(new BorderLayout());
		panelLogo.add(icono, BorderLayout.CENTER);
		panelLogo.setPreferredSize(new Dimension(750, 275));
		panelLogo.setBackground(color);
		
		
		//icono.setAlignmentX(Component.CENTER_ALIGNMENT);
        //icono.setPreferredSize(new Dimension(200,300));
        
        volver= new JButton("Cerrar sesion");
        Color customColor=new Color(255, 255, 255); // Color rojo (R: 255, G: 0, B: 0)
        volver.setBackground( customColor);
        volver.addActionListener((e)->{
         	main.volver();
         	this.dispose();
         });
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(customColor);
        iconcerrarsesion= new ImageIcon("logo/cerrarsesion.png");
 		imgcerrarsesion = iconcerrarsesion.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
 		volver.setIcon(new ImageIcon(imgcerrarsesion));
        panelBoton.add(volver);
        
        botonAdmin = new JButton("Admin");
        botonAdmin.setToolTipText("Volver a Servicios de Administrador");
        botonAdmin.setAlignmentX(Component.RIGHT_ALIGNMENT);
        botonAdmin.setAlignmentY(Component.TOP_ALIGNMENT);
        botonAdmin.setSize(new Dimension(60,60));
        botonAdmin.setBackground(color.white);
        botonAdmin.addActionListener((e)->{
		       admin.volver();
		       this.dispose();
        });
        
        if(admin != null) {
        	panelBoton.add(botonAdmin);
        }
        
        mensaje = new JLabel();
        mensaje.setFont(new Font("Modern No. 20", 1, 24)); // NOI18N
        mensaje.setHorizontalAlignment(SwingConstants.CENTER);
        mensaje.setText("SERVICIO DE ADMINISTRACION DE OBRAS DEL MUSEO");
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JPanel panelTitulo = new JPanel();
      // panelTitulo.setPreferredSize(new Dimension(100, 120));
       // panelTitulo.setMaximumSize(new Dimension(100, 120));
        panelTitulo.setBackground(color);
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.Y_AXIS));
        panelTitulo.add(Box.createRigidArea(new Dimension(0, 50)));
        panelTitulo.add(mensaje);
        //panelTitulo.add(Box.createRigidArea(new Dimension(0, 50)));
        icono.setPreferredSize(new Dimension(300,200));
        icono.setHorizontalAlignment(SwingConstants.CENTER);
        //panelTitulo.add(icono);

        panelTitulo.add(panelLogo);
        mainPanel.add(panelTitulo, BorderLayout .NORTH);
        //mainPanel.add(icono,BorderLayout.CENTER);
        
        //Botones
        altaObra = new JButton();
        altaObra.setFont(new Font("Modern No. 20", 1, 14)); // NOI18N
        altaObra.setText("Alta Obra");
        altaObra.setBorder(BorderFactory.createLineBorder(null));
        altaObra.setPreferredSize(new Dimension(150,50));
        altaObra.addActionListener((e) -> {
			AltaObra ao = new AltaObra(ctrl, this);
			this.dispose();
		});
        
        bajaObra = new JButton();
        bajaObra.setFont(new Font("Modern No. 20", 1, 14)); // NOI18N
        bajaObra.setText("Baja obra");
        bajaObra.setBorder(BorderFactory.createLineBorder(null));
        bajaObra.setPreferredSize(new Dimension(150,50));
        bajaObra.addActionListener((e) -> {
        	String id = JOptionPane.showInputDialog(null, "Introduce el ID de la obra a eliminar",
        			"Dar de baja una obra", JOptionPane.PLAIN_MESSAGE);
        	if(ctrl.bajaObra(id)) {
        		JOptionPane.showMessageDialog(null, "La obra se ha eliminado correctamente");
        	}
        	else if(!ctrl.bajaObra(id) && id!=null) {
        		
        		JOptionPane.showMessageDialog(null, "El ID introducido no existe", "ERROR", JOptionPane.ERROR_MESSAGE);
        	}
        	
		});
        
        
        
        consultaObra = new JButton();
        consultaObra.setFont(new Font("Modern No. 20", 1, 14)); // NOI18N
        consultaObra.setText("Consultar obras");
        consultaObra.setBorder(BorderFactory.createLineBorder(null));
        consultaObra.setPreferredSize(new Dimension(150,50));
        consultaObra.addActionListener((e) -> {
			ConsultaObra co = new ConsultaObra(ctrl, this);
			this.dispose();
		});

        modificaObra = new JButton();
        modificaObra.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        modificaObra.setText("Modificar obra");
        modificaObra.setBorder(BorderFactory.createLineBorder(null));
        modificaObra.setPreferredSize(new Dimension(150,50));
        modificaObra.addActionListener((e) -> {
        	ModificaObra mo = new ModificaObra(ctrl, this);
        	this.dispose();
        	});
        
        
        
        iconaltaObra= new ImageIcon("logo/darAlta.png");
 		imgaltaObra = iconaltaObra.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
        
        iconbajaObra= new ImageIcon("logo/bajaObra.png");
 		imgbajaObra = iconbajaObra.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
 		
        
        iconConsulta= new ImageIcon("logo/lupa.png");
 		imgConsulta = iconConsulta.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
 		
 		iconmodi= new ImageIcon("logo/lapiz.png");
 		imgmodi = iconmodi.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
 		
 		
 		
 		
 	
 		altaObra.setIcon(new ImageIcon(imgaltaObra));
 		bajaObra.setIcon(new ImageIcon(imgbajaObra));
 		consultaObra.setIcon(new ImageIcon(imgConsulta));
 		modificaObra.setIcon(new ImageIcon(imgmodi) );
 		
        
        
        FlowLayout layoutBotones = new FlowLayout();
        layoutBotones.setHgap(30);
        layoutBotones.setVgap(100);
        JPanel panelBotones = new JPanel(layoutBotones);
        panelBotones.setPreferredSize(new Dimension(750, 155));
        panelBotones.setBackground(color);
        panelBotones.add(altaObra);
        panelBotones.add(bajaObra);
        panelBotones.add(consultaObra);
        panelBotones.add(modificaObra);
        mainPanel.add(panelBotones, BorderLayout.CENTER);
        mainPanel.add(panelBoton, BorderLayout.AFTER_LAST_LINE);
        
        ImageIcon iconlogo = new ImageIcon("logo/logo.png");
    	Image imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    	setIconImage(imglogo);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
       // setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
		this.setResizable(false);
        setVisible(true);
    }
    
    public void volver() {
    	initComponents();
	}
    
    //metodo para cargar las imagenes
    protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
}

        