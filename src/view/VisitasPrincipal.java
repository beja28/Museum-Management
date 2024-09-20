package view;

import java.awt.*;
import javax.swing.*;

import control.Controller;


@SuppressWarnings("serial")
public class VisitasPrincipal extends JFrame {
	
	static Controller ctrl;
	private JLabel mensaje;
	private JButton consulta;
	private JButton modifica;
	private JButton volver;
	private JButton admin;
	private VentanaAdmin adm;
	
	private Image imglogo;
	private ImageIcon iconlogo;
	
	
	private MainWindow main;
	
    public VisitasPrincipal(Controller ctrl, MainWindow main, VentanaAdmin adm) {
    	VisitasPrincipal.ctrl = ctrl;
    	this.main = main;
    	this.adm = adm;
        initComponents();
    }
   
    private void initComponents() {

    	JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(new Color(253, 221, 202));
 	    setContentPane(mainPanel);
 	    
 	   volver = new JButton();
       volver.setToolTipText("Cerrar sesion");
       volver.setIcon(new ImageIcon("logo/cerrarsesion.png"));
       volver.setBackground(new Color(93, 193, 185));
       volver.setAlignmentX(Component.LEFT_ALIGNMENT);
       volver.setAlignmentY(Component.TOP_ALIGNMENT);
       volver.setSize(new Dimension(60,60));
       volver.addActionListener((e)->{
		       main.volver();
		       this.dispose();
       });
       
       admin = new JButton("Admin");
       admin.setToolTipText("Volver a Servicios de Administrador");
       admin.setBackground(Color.white);
       admin.setAlignmentX(Component.RIGHT_ALIGNMENT);
       admin.setAlignmentY(Component.TOP_ALIGNMENT);
       admin.setSize(new Dimension(60,60));
       admin.addActionListener((e)->{
		       adm.volver();
		       this.dispose();
       });

       mainPanel.add(volver);
       if(adm != null) {
       mainPanel.add(admin, BorderLayout.AFTER_LAST_LINE);
       }
        //Titulo
        mensaje = new JLabel("<html> ¡Bienvenido al servicio de<P>" + "<html>visitas guiadas del museo!<P>");
        mensaje.setFont(new Font("Modern No. 20", 1, 24)); // NOI18N
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
        JPanel panelTitulo = new JPanel();
        panelTitulo.setBackground(new Color(93, 193, 185));
        panelTitulo.add(mensaje);
        
        Icon lupa = new ImageIcon("logo/lupa.png");
        //Botones
        consulta = new JButton("Consultar las visitas programadas");
        consulta.setFont(new Font("Modern No. 20", 1, 14)); // NOI18N
        consulta.setPreferredSize(new Dimension(300,50));   
        consulta.setBackground(Color.white);
        consulta.setIcon(lupa);
        consulta.addActionListener((e) -> {
			new ConsultaVista(ctrl, this);
			this.dispose();
		});
        JPanel panelC = new JPanel();
        panelC.add(consulta);
        panelC.setBackground(new Color(93, 193, 185));
        
        Icon checklist = new ImageIcon("logo/checklist.png");
        
        modifica = new JButton("Otras acciones");
        modifica.setFont(new java.awt.Font("Modern No. 20", 1, 14)); // NOI18N
        modifica.setBackground(Color.white);
        modifica.setPreferredSize(new Dimension(300,50));
        modifica.setIcon(checklist);
        modifica.addActionListener((e) -> {
			new AccionesVista(ctrl, this);
			this.dispose();
		});
        JPanel panelM = new JPanel();
        panelM.add(modifica);
        panelM.setBackground(new Color(93, 193, 185));
        
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
        panelBotones.setBackground(new Color(253, 221, 202));
        panelBotones.add(panelC);
        panelBotones.add(panelM);
        
        JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.setBackground(new Color(93, 193, 185));
        panelContenido.add(Box.createRigidArea(new Dimension(0, 60)));
        panelContenido.add(panelTitulo);
        panelContenido.add(panelBotones);
        mainPanel.add(panelContenido, BorderLayout.CENTER);

        iconlogo= new ImageIcon("logo/logo.png");
    	imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    	setIconImage(imglogo);
        
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(new Color(93, 193, 185));
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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

        