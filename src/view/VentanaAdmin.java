package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import control.Controller;

public class VentanaAdmin extends JFrame {

	static Controller ctrl;
	private JLabel mensaje;
	private JButton visitas;
	private JButton empleados;
	private JButton obras;
	private JButton volver;
	
	private Image imglogo;
	private ImageIcon iconlogo;
	
	
	private MainWindow main;
	
    public VentanaAdmin(Controller ctrl, MainWindow main) {
    	this.ctrl = ctrl;
    	this.main = main;
        initComponents();
    }
   
    private void initComponents() {

    	JPanel mainPanel = new JPanel(new BorderLayout());
 		mainPanel.setBackground(Color.WHITE);
 	    setContentPane(mainPanel);
 	    
 	   volver = new JButton();
       volver.setToolTipText("Cerrar sesion");
       volver.setIcon(new ImageIcon("logo/cerrarsesion.png"));
       volver.setBackground(new Color(79, 101, 112));
       volver.setAlignmentX(Component.LEFT_ALIGNMENT);
       volver.setAlignmentY(Component.TOP_ALIGNMENT);
       volver.setSize(new Dimension(60,60));
       volver.addActionListener((e)->{
       main.volver();
       this.dispose();
       });

       mainPanel.add(volver);
        
        //Titulo
        mensaje = new JLabel("Servicio de " + "administrador");
        mensaje.setFont(new Font("Modern No. 20", 1, 24)); // NOI18N
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(79, 101, 112));
        panelTitulo.add(mensaje);
        
        Icon visit = new ImageIcon("logo/visit.png");
        //Botones
        visitas = new JButton();
        visitas.setBackground(Color.WHITE);
        visitas.setFont(new Font("Modern No. 20", 1, 14)); // NOI18N
        visitas.setPreferredSize(new Dimension(300,50));  
        visitas.setIcon(visit);
        visitas.setText("        Visitas  Guiadas  ");
        visitas.addActionListener((e) -> {
			new VisitasPrincipal(ctrl, main, this);
			this.dispose();
		});
        JPanel panelC = new JPanel();
        panelC.add(visitas);
        panelC.setBackground(new Color(79, 101, 112));
        
        Icon empleado = new ImageIcon("logo/empleado.png");
        
        empleados = new JButton();
        empleados.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        empleados.setBackground(Color.WHITE);
        empleados.setPreferredSize(new Dimension(300,50));
        empleados.setIcon(empleado);
        empleados.setText("           Empleados           ");
        empleados.addActionListener((e) -> {
			new VentanaPrincipalEmpleados(ctrl, main, this);
			this.dispose();
		});
        JPanel panelM = new JPanel();
        panelM.add(empleados);
        panelM.setBackground(new Color(79, 101, 112));
        
        Icon obra = new ImageIcon("logo/obramuseo.png");
        
        obras = new JButton();
        obras.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        obras.setBackground(Color.WHITE);
        obras.setPreferredSize(new Dimension(300,50));
        obras.setIcon(obra);
        obras.setText("                 Obras                    ");
        obras.addActionListener((e) -> {
			new MainRestauracion(ctrl, main, this);
			this.dispose();
		});
        JPanel panelO = new JPanel();
        panelO.add(obras);
        panelO.setBackground(new Color(79, 101, 112));
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(new Color(79, 101, 112));
        panelBotones.add(panelC);
        panelBotones.add(panelM);
        panelBotones.add(panelO);
        
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setBackground(new Color(79, 101, 112));
        panelContenido.add(Box.createRigidArea(new Dimension(0, 60)));
        panelContenido.add(panelTitulo);
        panelContenido.add(panelBotones);
        mainPanel.add(panelContenido, BorderLayout.CENTER);

        iconlogo= new ImageIcon("logo/logo.png");
    	imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    	setIconImage(imglogo);
        
        this.setPreferredSize(new Dimension(500,500));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setResizable(false);
        setVisible(true);
    }
    
    public void volver() {
    	initComponents();
	}
}
