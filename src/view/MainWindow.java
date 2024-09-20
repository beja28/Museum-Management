package view;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.*;


import control.Controller;
import model.Usuario;

public class MainWindow extends JFrame {
	
	private Controller _ctrl;
	
	private JLabel logo;
    private JLabel usuarioLabel;
    private JTextField usuario;
    private JLabel contrasenaLabel;
    private JPasswordField contrasena;
    private JButton InicioSesion;
	private Image imglogo;
	private ImageIcon iconlogo;
    
    private List<Usuario> Usuarios;
    

	public MainWindow(Controller controlador) {
		super();
		_ctrl = controlador;
		Usuarios = _ctrl.Usuarios();
		initGUI();
	}
	private void initGUI() {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		setSize(500, 500);
		setLocationRelativeTo(null);
		
		iconlogo= new ImageIcon("logo/logo.png");
 		imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
 		setIconImage(imglogo);

		mainPanel.setBackground(Color.white);
		
		setContentPane(mainPanel);
		
		logo = new JLabel(new ImageIcon("logo/logoGemus.png"));
		logo.setSize(50, 50);
        usuarioLabel = new JLabel("Usuario:");
        usuario = new JTextField(20);
        usuario.setBackground(Color.LIGHT_GRAY);
        contrasenaLabel = new JLabel("Contraseña:");
        contrasena = new JPasswordField(20);
        contrasena.setBackground(Color.LIGHT_GRAY);
        InicioSesion = new JButton("Iniciar sesión");
        InicioSesion.addActionListener((e) -> {
        	Usuarios = _ctrl.Usuarios();
	        boolean encontrado = false;
	        boolean conIncorrecta = false;
	        	String nombre = usuario.getText();
	        	char[] password = contrasena.getPassword();
	        	int j = 0;
	        	int i = 0;
	        	while( i < Usuarios.size()) {
	        		if (nombre.equals(Usuarios.get(i).getNombre())) {
	        			char[] contra = Usuarios.get(i).getContraseña().toCharArray();
	        			while (j < password.length && password[j] == contra[j] && password.length == contra.length) {
		        			j++;
		        		}
	        			if (j == password.length&& j!=0) {
		        			if (Usuarios.get(i).getPuesto().equals("Administrador")) {
		        					new VentanaAdmin(_ctrl,this);
		        					encontrado = true;
		        				
		        				}else if (Usuarios.get(i).getPuesto().equals("Guía")) {
		        					new VisitasPrincipal(_ctrl, this, null);
		        					encontrado = true;
		        				}else if (Usuarios.get(i).getPuesto().equals("Restaurador")) {
		        					new MainRestauracion(_ctrl, this, null);
		        					encontrado = true;
		        			}
	        			}else {
	        				conIncorrecta=true;
        					JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
        				}
	        		}
	        		i++;
	        	}
	        	if (!encontrado) {
	        		if (!conIncorrecta) 
	        		JOptionPane.showMessageDialog(this, "Usuario y/o contraseña incorrectos");
	        	}else {
	    			this.dispose();
	        	}
			});

        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(Color.white);

        panelLogo.add(logo);
        
        mainPanel.add(Box.createRigidArea(new Dimension(0, 50)));
        mainPanel.add(panelLogo);
        
        JPanel panelUS = new JPanel();
        //panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panelUS.add(usuarioLabel);
        panelUS.setAlignmentX(Component.CENTER_ALIGNMENT);
        panelUS.add(usuario);
     
        panelUS.setBackground(Color.white);
        
        
        JPanel panelCONT = new JPanel();
        
        panelCONT.setBackground(Color.white);

        panelCONT.add(contrasenaLabel);
        panelCONT.add(contrasena);
        
        JPanel panel = new JPanel();
        
        panel.setBackground(Color.white);
        
        JPanel panelIni = new JPanel();
        panelIni.setBackground(Color.white);
        panelIni.add(InicioSesion);
        
        panel.add(panelUS);
        panel.add(panelCONT);
        
        
        mainPanel.add(panel);
        mainPanel.add(panelIni);

        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
        setVisible(true);
	}
	
	public void volver() {
		initGUI();
	}
}