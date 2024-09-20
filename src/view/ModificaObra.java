package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.json.JSONObject;

import control.Controller;
import model.Estado;



public class ModificaObra extends JFrame{
	
	Controller ctrl;
	JLabel mensaje;
	private DefaultComboBoxModel<String> _estadoModel;
	private MainRestauracion main;
	private ImageIcon iconVolver, iconAceptar, iconCancelar, iconlogo;
	private Image imgVolver, imgAceptar, imgcancelar, imglogo;

	public ModificaObra(Controller ctrl, MainRestauracion main) {
		this.main = main;
    	this.ctrl = ctrl;
        initComponents();
    }
   
    private void initComponents() {

    	JPanel panelAlta = new JPanel(new BorderLayout());
 		setContentPane(panelAlta);
 		
 		Color color = new Color(253, 221, 202 );
    	
 		//mensaje
 		 mensaje = new JLabel();
         mensaje.setFont(new Font("Modern No. 20", 1, 24)); // NOI18N
         mensaje.setHorizontalAlignment(SwingConstants.CENTER);
         mensaje.setText("Introduzca el id y los datos de la obra que quiere modificar");
         mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);
 		
 		//creamos los Label y TextFild
 		JPanel panel1 = new JPanel(new GridLayout());
 		JLabel id = new JLabel("Id");
 		JTextField tId = new JTextField();
 		tId.setMaximumSize(new Dimension(100,20));
 		JPanel panel0 = new JPanel(new GridLayout());
 		panel0.setBackground(color);
 		panel0.setPreferredSize(new Dimension(500, 30));
 		panel0.setMaximumSize(new Dimension(500, 30));
 		panel0.add(id);
 		panel0.add(tId);
 		
 		
 		JLabel titulo = new JLabel("Título");
 		JTextField tTitulo = new JTextField();
 		tTitulo.setMaximumSize(new Dimension(100,20));
 		panel1.setPreferredSize(new Dimension(500, 30));
 		panel1.setMaximumSize(new Dimension(500, 30));
 		panel1.add(titulo);
 		panel1.add(tTitulo);
 		//panel2
 		JPanel panel2 = new JPanel(new GridLayout());
 		JLabel autor = new JLabel("Autor");
 		JTextField tAutor = new JTextField();
 		panel2.setPreferredSize(new Dimension(500, 30));
 		panel2.setMaximumSize(new Dimension(500, 30));
 		panel2.add(autor);
 		panel2.add(tAutor);
 		//panel3
 		JPanel panel3 = new JPanel(new GridLayout());
 		
 		//PanelFechaLabel
 		
 		
 		JLabel fecha = new JLabel("Fecha (Fechas A.C: Numeros negativos)");
 		
 		
 		
 		//PanelFecha
 		
 		
 		JTextField tFecha = new JTextField();
 	
 		
 		//Panel3
 		panel3.setPreferredSize(new Dimension(500, 30));
 		panel3.setMaximumSize(new Dimension(500, 30));
 		panel3.add(fecha);
 		panel3.add(tFecha);
 		//panel4
 		JPanel panel4 = new JPanel(new GridLayout());
 		JLabel estado = new JLabel("Estado");
 		_estadoModel = new DefaultComboBoxModel<String>();
 		for(Estado e : Estado.values()) {
             
                _estadoModel.addElement(e.toString());
          
        }
 		JComboBox<String> tEstado = new JComboBox<String>(_estadoModel);
 		panel4.setPreferredSize(new Dimension(500, 30));
 		panel4.setMaximumSize(new Dimension(500, 30));
 		panel4.add(estado);
 		panel4.add(tEstado);
 		//panel5
 		JPanel panel5 = new JPanel(new GridLayout());
 		JButton ok = new JButton("Confirmar");
 		JButton cancel = new JButton("Cancelar");
 		ok.addActionListener((e) -> {
 			JSONObject data = new JSONObject();
 			String sId = tId.getText();
 			String sTitulo = tTitulo.getText();
 			String sAutor = tAutor.getText();
 			String sFecha = tFecha.getText();
 			String sEstado = (String)tEstado.getSelectedItem();
 			
 			data.put("id", sId);
 			data.put("titulo", sTitulo);
 			data.put("autor", sAutor);
 			data.put("fecha", sFecha);
 			data.put("estado", sEstado);
 			
 			if(ctrl.modificaObra(data)) {
 				JOptionPane.showMessageDialog(null, "La obra se ha modificado correctamente");
 				main.volver();
 	          	this.dispose();
 			}
 
 		});
 		
 		cancel.addActionListener((e) -> {
 			main.volver();
          	this.dispose();
 		});
 		panel5.setPreferredSize(new Dimension(500, 30));
 		panel5.setMaximumSize(new Dimension(500,30));
 		iconAceptar= new ImageIcon("logo/aceptar.png");
 		imgAceptar = iconAceptar.getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH); 
 		
 		iconCancelar= new ImageIcon("logo/cancelar.png");
 		imgcancelar = iconCancelar.getImage().getScaledInstance(17, 17, Image.SCALE_SMOOTH); 
 		ok.setIcon(new ImageIcon(imgAceptar));
 		cancel.setIcon(new ImageIcon(imgcancelar));
 		panel5.add(ok);
 		panel5.add(cancel);
 		
 		JButton volver= new JButton("Atrás");
         Color customColor=new Color(255, 255, 255); // Color rojo (R: 255, G: 0, B: 0)
         volver.setBackground( customColor);
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
 		
 		JPanel panelContenido = new JPanel();
 		panelContenido.setPreferredSize(new Dimension(900, 800));
 		panelContenido.setMaximumSize(new Dimension(900,800));
 		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));
 		panelContenido.add(panel0);
 		panelContenido.add(panel1);
 		panelContenido.add(panel2);
 		panelContenido.add(panel3);
 		panelContenido.add(panel4);
 		panelContenido.add(panel5);
 		panelContenido.setBackground(color);
 		
 		panel1.setBackground(color);
 		panel2.setBackground(color);
 		panel3.setBackground(color);
 		panel4.setBackground(color);
 		
 		
 		JPanel contentPanel = new JPanel();
 		contentPanel.setPreferredSize(new Dimension(700, 300));
 		contentPanel.setMaximumSize(new Dimension(700,300));
 		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
 		contentPanel.add(Box.createRigidArea(new Dimension(0, 60)));
 		contentPanel.add(mensaje);
 		contentPanel.add(Box.createRigidArea(new Dimension(0, 40)));
 		contentPanel.add(panelContenido);
 		contentPanel.setBackground(color);
		panelAlta.add(contentPanel, BorderLayout.CENTER);
		panelAlta.add(panelBoton, BorderLayout.AFTER_LAST_LINE);
 		
		iconlogo= new ImageIcon("logo/logo.png");
    	imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
    	setIconImage(imglogo);

		 pack();
	        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	       // setExtendedState(JFrame.MAXIMIZED_BOTH);
	        //setResizable(false);
	        setLocationRelativeTo(null);
			this.setResizable(false);
			setVisible(true);
    	
	
}
  //metodo para cargar las imagenes
    protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
	
}

