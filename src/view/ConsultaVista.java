package view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.util.ArrayList;

import control.Controller;
import model.VisitaGuiada;
@SuppressWarnings("serial")
public class ConsultaVista extends JFrame{

	Controller ctrl; 
	ArrayList<VisitaGuiada> lista;
	
	JLabel titulo;
	JButton atras;
	JTable tabla;
	private Image imglogo;
	private ImageIcon iconlogo;
	
	private VisitasPrincipal ventana;

	public ConsultaVista(Controller ctrl, VisitasPrincipal ventana) {
		this.ctrl = ctrl;
		this.ventana = ventana;
		initComponents();
		lista = ctrl.consultarVisitas();
	}
	
	public void initComponents() {
	
	   JPanel panelConsulta = new JPanel(new BorderLayout());
	   setContentPane(panelConsulta);
		 
		        //Botón atras
	   atras = new JButton();
	   atras.setIcon(loadImage("logo/iconoAtras.png"));
	   atras.setBackground(Color.RED);
	   atras.setAlignmentX(Component.LEFT_ALIGNMENT);
	   atras.setAlignmentY(Component.TOP_ALIGNMENT);
	   atras.setSize(new Dimension(45,35));
	   atras.setToolTipText("Atrás");
	   atras.addActionListener((e) -> {
		   		setVisible(false);
		   		ventana.volver();
		        this.dispose();
		});
	    panelConsulta.add(atras);
	 
	    //Contenido (texto y tabla)
	    titulo = new JLabel();
	    titulo.setFont(new Font("Modern No. 20", 1, 24)); // NOI18N
	    titulo.setHorizontalAlignment(SwingConstants.CENTER);
	    titulo.setText("Visitas programadas");
	    titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
		       
		tabla = new JTable(new TablaDatos(ctrl));
		JScrollPane a = new JScrollPane(tabla);
		a.setPreferredSize(new Dimension(480, 300));

		JPanel panelContenido = new JPanel();
        panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
        panelContenido.add(Box.createRigidArea(new Dimension(0, 40)));
        panelContenido.add(titulo);
        panelContenido.add(Box.createRigidArea(new Dimension(0, 20)));
		panelContenido.add(a);
		panelContenido.add(Box.createRigidArea(new Dimension(0, 20)));
		panelContenido.setBackground(new Color(93, 193, 185));
		panelConsulta.add(panelContenido, BorderLayout.CENTER);
		panelConsulta.setBackground(new Color(93, 193, 185));

		panelConsulta.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.EAST);
		panelConsulta.add(Box.createRigidArea(new Dimension(20, 0)), BorderLayout.WEST);
		 
		iconlogo= new ImageIcon("logo/logo.png");
		imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		setIconImage(imglogo);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
		this.setResizable(false);
		setVisible(true);

		
	}
	
	//metodo para cargar las imagenes
    protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
    
}
