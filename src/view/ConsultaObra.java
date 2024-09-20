package view;
//package view;

import java.awt.*;
import javax.swing.*;

import control.Controller;

import java.util.ArrayList;

//import control.Controller;
//import model.VisitaGuiada;
public class ConsultaObra extends JFrame{

	Controller ctrl; 

	JLabel titulo;
	JButton atras;
	JTable tabla;
	private MainRestauracion main;
	private ImageIcon iconVolver, iconlogo;
	private Image imgVolver, imglogo;
	

	public ConsultaObra(Controller ctrl, MainRestauracion main) {
		this.main = main;
		this.ctrl = ctrl;
		initComponents();
	}
	
	public void initComponents() {
	
		JPanel panelConsulta = new JPanel();
		panelConsulta.setLayout(new BoxLayout(panelConsulta, BoxLayout.Y_AXIS));
 		setContentPane(panelConsulta);
 		
 		Color color = new Color(253, 221, 202 );
 		
        //Contenido (texto y tabla)
        titulo = new JLabel();
        titulo.setFont(new Font("Modern No. 20", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Obras");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
       
        InfoTableObras obrasTable = new InfoTableObras("Obras", new ObrasTableModel(ctrl));
		obrasTable.setPreferredSize(new Dimension(500, 250));
		obrasTable.setBackground(color);
		
		JButton volver= new JButton("Atrás");
		Color customColor=new Color(255, 255, 255); // Color rojo (R: 255, G: 0, B: 0)
        volver.addActionListener((e)->{
         	main.volver();
         	this.dispose();
         });
        JPanel panelBoton = new JPanel();
        panelBoton.setBackground(customColor);
        iconVolver= new ImageIcon("logo/atras.png");
  		imgVolver = iconVolver.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
  		volver.setIcon(new ImageIcon(imgVolver));
        panelBoton.add(volver);
		panelConsulta.add(titulo);
		panelConsulta.add(obrasTable);
		panelConsulta.add(panelBoton, BorderLayout.AFTER_LAST_LINE);
		panelConsulta.setBackground(color);

		iconlogo= new ImageIcon("logo/logo.png");
    	imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    	setIconImage(imglogo);
		
        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        this.setResizable(false);
		setVisible(true);
		
	}
	
	//metodo para cargar las imagenes
    protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
    
}

