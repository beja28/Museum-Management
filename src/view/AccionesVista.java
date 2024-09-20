package view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import control.Controller;
import model.VisitaGuiada;

@SuppressWarnings("serial")
public class AccionesVista extends JFrame{
 

	Controller ctrl; 
	ArrayList<VisitaGuiada> lista;
	
	JLabel titulo;
	JComboBox<String> opciones;
	JButton atras;
	JLabel id, fecha, tematica, duracion;
	JComboBox<Integer> idCB;
	JTextField fechaTF, tematicaTF, duracionTF;
	JButton aceptar, reiniciar;
	private Image imglogo;
	private ImageIcon iconlogo;
	int accion = 0;
	int id_elimina;
	int id_crear;
	int id_modificar;
	int indice_elim;
	JPanel panelCentro, panelAcciones, panelTitulo;
	private VisitasPrincipal ventana;
	private int dur_aux;
	private String fech_aux;
	private String temat_aux;
	
	public AccionesVista(Controller ctrl, VisitasPrincipal ventana) {
		this.ctrl = ctrl;
		this.ventana = ventana;
		lista = ctrl.consultarVisitas();
		if(lista.size() > 0) {
			id_elimina = lista.get(0).getId();
		}
		idCB = new JComboBox<Integer>();
		initComponents();
	}
	
	public void initComponents() {
		
		panelAcciones = new JPanel(new BorderLayout());
 		setContentPane(panelAcciones);
 		panelAcciones.setBackground(new Color(93, 193, 185));
 		
        //Botón atras
 		atras = new JButton();
 		atras.setIcon(loadImage("logo/iconoAtras.png"));
 		atras.setBackground(Color.RED);
 		atras.setAlignmentX(Component.LEFT_ALIGNMENT);
 		atras.setAlignmentY(Component.TOP_ALIGNMENT);
 		atras.setSize(new Dimension(45,35));
 		atras.setToolTipText("Atrás");
 		atras.addActionListener((e) -> {
 			ventana.volver();
        	this.dispose();
		});
 		panelAcciones.add(atras);
        
        titulo = new JLabel();
        titulo.setFont(new Font("Modern No. 20", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("Elija que accion quiere realizar: ");
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        opciones = new JComboBox<String>();
        opciones.addItem("");
        opciones.addItem("Crear");
        opciones.addItem("Eliminar");
        opciones.addItem("Modificar");
        opciones.setPreferredSize(new Dimension(100, 30));

        JPanel panelO = new JPanel();
        panelO.add(opciones);
        panelO.setBackground(new Color(93, 193, 185));
        
        panelCentro = new JPanel();
        panelCentro.setLayout(new BoxLayout(panelCentro, BoxLayout.Y_AXIS));
        panelCentro.setBackground(new Color(93, 193, 185));
        
        panelTitulo = new JPanel();
        panelTitulo.setLayout(new BoxLayout(panelTitulo, BoxLayout.Y_AXIS));
        panelTitulo.setBackground(new Color(93, 193, 185));
        panelTitulo.add(titulo);
        panelTitulo.add(Box.createRigidArea(new Dimension(0, 20)));
        panelTitulo.add(panelO);
        
        panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
        panelCentro.add(panelTitulo);
        panelCentro.add(layoutInicio());
		
        opciones.addActionListener((e)->{
        	accion = opciones.getSelectedIndex();
        	
        	switch(accion) {
        	  case 0: //inicio
        		  panelCentro.removeAll();
        		  panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
        		  panelCentro.add(panelTitulo);
        		  panelCentro.add(layoutInicio());
        		  panelCentro.revalidate();
        		  panelAcciones.repaint();
        		  break;
        	  case 1: //crear una visita nueva
        		  panelCentro.removeAll();
        		  panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
        		  panelCentro.add(panelTitulo);
        		  panelCentro.add(layoutCrear());
        		  panelCentro.revalidate();
        		  panelAcciones.repaint();
        		  break;
        	  case 2: //eliminar una visita existente
        		  panelCentro.removeAll();
        		  panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
        		  panelCentro.add(panelTitulo);
        		  panelCentro.add(layoutEliminar());
        		  panelCentro.revalidate();
        		  panelAcciones.repaint();
        	    break;
        	  case 3: //modificar una visita existente
        		  panelCentro.removeAll();
        		  panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
        		  panelCentro.add(panelTitulo);
        		  panelCentro.add(layoutModificar());
        		  panelCentro.revalidate();
        		  panelAcciones.repaint();
          	    break;
        	  default:
  
        	}
        	
        });
        
        panelAcciones.add(panelCentro, BorderLayout.CENTER);
        
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
	
	private JPanel layoutInicio() {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 15));
		panel.setBackground(new Color(93, 193, 185));
		panel.setPreferredSize(new Dimension(450, 200));
		JLabel info = new JLabel("     Elija arriba que acción quiere realizar:");
		info.setAlignmentX(LEFT_ALIGNMENT);
		JLabel crear = new JLabel("<html>  - Crear: añada una nueva visita guiada indicando su fecha, temática y<P>"
				+ "<html>  duración en minutos (se asignará automaticamente un ID a la nueva visita)<P>");
		JLabel eliminar = new JLabel("<html>  - Eliminar: borre por completo una visita guiada ya existente indicando <P>"
				+ "<html> el ID correspondiente<P>");
		JLabel modificar = new JLabel("<html>  - Modificar: puede modificar los valores fecha, temática y/o duración <P>"
				+ "<html> en minutos de una visita guiada existente<P>");
		panel.add(info);
		panel.add(crear);
		panel.add(eliminar);
		panel.add(modificar);
		panel.setBorder(new PanelBordeRedondeado(70,1,Color.BLACK, Color.white));
		
		JPanel panelb = new JPanel();
		panelb.add(panel, Component.CENTER_ALIGNMENT);
		panelb.setBackground(new Color(93, 193, 185));
		
		return panelb;
	}
	
	private JPanel layoutCrear() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(93, 193, 185));
		int i = 1;
		while(ctrl.existeVisita(i)) i++;
		id_crear = i;
		id = new JLabel("El ID de la nueva visita será: " + i);
		JPanel p = new JPanel();
		p.setBackground(new Color(93, 193, 185));
		p.add(id);
		
		fecha = new JLabel("Introduzca la fecha de la visita: ");
		fechaTF = new JTextField();
		fechaTF.setPreferredSize(new Dimension(200, 30));
		JPanel f = new JPanel();
		f.setBackground(new Color(93, 193, 185));
		f.add(fecha);
		f.add(fechaTF);
		
		tematica = new JLabel("Introduzca la tematica de la visita: ");
		tematicaTF = new JTextField();
		tematicaTF.setPreferredSize(new Dimension(200, 30));
		JPanel t = new JPanel();
		t.setBackground(new Color(93, 193, 185));
		t.add(tematica);
		t.add(tematicaTF);
		
		duracion = new JLabel("Introduzca la duración de la visita: ");
		duracionTF = new JTextField();
		duracionTF.setPreferredSize(new Dimension(200, 30));
		JPanel d = new JPanel();
		d.setBackground(new Color(93, 193, 185));
		d.add(duracion);
		d.add(duracionTF);
		
		panel.add(p);
		panel.add(f);
		panel.add(t);
		panel.add(d);
		panel.add(layoutBotones());
		return panel;
	}
	
	private JPanel layoutEliminar() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(93, 193, 185));
		
		id = new JLabel("Elija el ID de la visita a eliminar: ");
		idCB = new JComboBox<Integer>();
		for(VisitaGuiada ids : lista)
			idCB.addItem(ids.getId());
		
		JPanel i = new JPanel();
		i.setBackground(new Color(93, 193, 185));
		i.add(id);
		i.add(idCB);
		
		fecha = new JLabel("La fecha de la visita elegida es : ");
		JLabel fecha_elim = new JLabel();
		fecha_elim.setPreferredSize(new Dimension(200, 30));
		if(lista.size() > 0) {
			fecha_elim.setText(lista.get(0).getFecha());
			}
		JPanel f = new JPanel();
		f.setBackground(new Color(93, 193, 185));
		f.add(fecha);
		f.add(fecha_elim);
		
		tematica = new JLabel("La temática de la visita elegida es : ");
		JLabel tem_elim = new JLabel();
		tem_elim.setPreferredSize(new Dimension(200, 30));
		if(lista.size() > 0) {
			tem_elim.setText(lista.get(0).getTematica());
			}
		JPanel t = new JPanel();
		t.setBackground(new Color(93, 193, 185));
		t.add(tematica);
		t.add(tem_elim);

		duracion = new JLabel("La duración de la visita elegida es : ");
		JLabel dur_elim = new JLabel();
		dur_elim.setPreferredSize(new Dimension(200, 30));
		if(lista.size() > 0) {
			dur_elim.setText("" + lista.get(0).getDuracion());
			}
		JPanel d = new JPanel();
		d.setBackground(new Color(93, 193, 185));
		d.add(duracion);
		d.add(dur_elim);
		
		idCB.addActionListener((e) -> {
			id_elimina = (int) idCB.getSelectedItem();
			indice_elim = idCB.getSelectedIndex();
			for(VisitaGuiada visitas : lista) {
				if(visitas.getId() == id_elimina) {
					fecha_elim.setText(visitas.getFecha());
					tem_elim.setText(visitas.getTematica());
					dur_elim.setText("" + visitas.getDuracion());
					
				}
			}
		});
		
		
		panel.add(i);
		panel.add(f);
		panel.add(t);
		panel.add(d);
		panel.add(layoutBotones());
		
		return panel;
	}
	
	private JPanel layoutModificar() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setBackground(new Color(93, 193, 185));
		
		id = new JLabel("Elija el ID de la visita a modificar: ");
		idCB = new JComboBox<Integer>();
		for(VisitaGuiada ids : lista)
			idCB.addItem(ids.getId());
		if(lista.size() > 0){
			id_modificar = lista.get(0).getId();
			dur_aux = lista.get(0).getDuracion();
			fech_aux = lista.get(0).getFecha();
			temat_aux = lista.get(0).getTematica();
		}
		idCB.addActionListener((e) -> {
			id_modificar = (int) idCB.getSelectedItem();
			for(VisitaGuiada visitas : lista) {
				if(visitas.getId() == id_modificar) {
					String fecha_aux = visitas.getFecha();
					fech_aux = visitas.getFecha(); 
					String tematica_aux = visitas.getTematica();
					temat_aux = visitas.getTematica(); ;
					int duracion_aux = visitas.getDuracion();
					dur_aux = visitas.getDuracion(); ;
					fechaTF.setText(fecha_aux);
					tematicaTF.setText(tematica_aux);
					duracionTF.setText("" + duracion_aux);
					
				}
			}
		});
		JPanel i = new JPanel();
		i.setBackground(new Color(93, 193, 185));
		i.add(id);
		i.add(idCB);
		
		fecha = new JLabel("Introduzca la nueva fecha de la visita: ");
		fechaTF = new JTextField();
		fechaTF.setPreferredSize(new Dimension(200, 30));
		if(lista.size() > 0) {
		fechaTF.setText(lista.get(0).getFecha());
		}
		JPanel f = new JPanel();
		f.setBackground(new Color(93, 193, 185));
		f.add(fecha);
		f.add(fechaTF);
		
		tematica = new JLabel("Introduzca la nueva tematica de la visita: ");
		tematicaTF = new JTextField();
		tematicaTF.setPreferredSize(new Dimension(200, 30));
		if(lista.size() > 0) {
			tematicaTF.setText(lista.get(0).getTematica());
			}
		JPanel t = new JPanel();
		t.setBackground(new Color(93, 193, 185));
		t.add(tematica);
		t.add(tematicaTF);
		
		duracion = new JLabel("Introduzca la nueva duración de la visita: ");
		duracionTF = new JTextField();
		duracionTF.setPreferredSize(new Dimension(200, 30));
		if(lista.size() > 0) {
			duracionTF.setText("" + lista.get(0).getDuracion());
			}
		
		JPanel d = new JPanel();
		d.setBackground(new Color(93, 193, 185));
		d.add(duracion);
		d.add(duracionTF);
		
		panel.add(i);
		panel.add(f);
		panel.add(t);
		panel.add(d);
		panel.add(layoutBotones());
		return panel;
	}
	
	private JPanel layoutBotones() {
		aceptar = new JButton("Aceptar");
		aceptar.setBackground(Color.WHITE);
		aceptar.addActionListener((e)->{
			switch(accion) {     	  		
      	  		case 1:
					if(fechaTF.getText().equals("") || duracionTF.getText().equals("") || tematicaTF.getText().equals("")) {
						Utils.showErrorMsg("No se han rellenado todos los campos necesarios para realizar la operacion");
					} else {
						try {
						if(Integer.parseInt(duracionTF.getText()) <= 0) {
							Utils.showErrorMsg("La duracion debe ser un valor numérico positivo");
						}
						else {
						ctrl.crearVisita(new VisitaGuiada(id_crear, fechaTF.getText(), Integer.parseInt(duracionTF.getText()), tematicaTF.getText()));
						JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
						update();
						opciones.setSelectedIndex(0);
						panelCentro.removeAll();
						panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
	        		    panelCentro.add(panelTitulo);
	        		    panelCentro.add(layoutInicio());
	        		    panelCentro.revalidate();
	        		    panelAcciones.repaint();
						}
						} catch(NumberFormatException a) {
							Utils.showErrorMsg("La duracion debe ser un valor numérico natural");
						}
					}
					break;
      	  		case 2:
      	  			if(lista.size() > 0) {
	      	  			ctrl.eliminarVisita(id_elimina);
	    				JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
	    				update();
	    				opciones.setSelectedIndex(0);
	    				panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
	    				panelCentro.removeAll();
	            	    panelCentro.add(panelTitulo);
	                    panelCentro.add(layoutInicio());
	            	    panelCentro.revalidate();
	            	    panelAcciones.repaint();
      	  			} else {
      	  				Utils.showErrorMsg("No hay visitas que eliminar");
      	  			}
					
					break;
      	  		case 3:
      	  			if(lista.size() > 0) {
						if(fechaTF.getText().equals("") && duracionTF.getText().equals("") && tematicaTF.getText().equals("")) {
							Utils.showErrorMsg("No se ha rellenado ningun campo para realizar su modificacion");
						}
						else {
							try {
								if(!duracionTF.getText().equals("") && Integer.parseInt(duracionTF.getText()) <= 0) {
									Utils.showErrorMsg("La duracion debe ser un valor numérico positivo");
								}
								else {
								if(duracionTF.getText().equals("")) {
									ctrl.modificarVisita(new VisitaGuiada(id_modificar, fechaTF.getText(), -1, tematicaTF.getText()));
								}
								else {
									ctrl.modificarVisita(new VisitaGuiada(id_modificar, fechaTF.getText(), Integer.parseInt(duracionTF.getText()), tematicaTF.getText()));
								}
								JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
								update();
								opciones.setSelectedIndex(0);
								panelCentro.removeAll();
								panelCentro.add(Box.createRigidArea(new Dimension(0, 40)));
			        		    panelCentro.add(panelTitulo);
			        		    panelCentro.add(layoutInicio());
			        		    panelCentro.revalidate();
			        		    panelAcciones.repaint();
								}
								} catch(NumberFormatException a) {
									Utils.showErrorMsg("La duracion debe ser un valor numérico natural");
								}
						}
      	  			} else {
      	  				Utils.showErrorMsg("No hay visitas que modificar");
      	  			}
					break;
				default:
			}
			
		});
		
		reiniciar = new JButton("Reiniciar");
		reiniciar.setBackground(Color.white);
		reiniciar.addActionListener((e)->{
			reiniciar(accion);
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(93, 193, 185));
		panel.add(aceptar);
		if(accion != 2 ) {
		panel.add(Box.createRigidArea(new Dimension(40, 0)));
		panel.add(reiniciar);
		}
		
		return panel;
	}
	
	//metodo para cargar las imagenes
    protected ImageIcon loadImage(String path) {
		return new ImageIcon(Toolkit.getDefaultToolkit().createImage(path));
	}
    
    private void reiniciar(int indice) {
    	if(indice == 1) {
        	fechaTF.setText("");
    		duracionTF.setText("");
    		tematicaTF.setText("");
    	} else {
    		fechaTF.setText(fech_aux);
    		duracionTF.setText("" + dur_aux);
    		tematicaTF.setText(temat_aux);
    	}
    }
  
    private void update() {
    	lista = ctrl.consultarVisitas();
    	idCB.removeAll();
    	if(lista.size() > 0) {
    		id_elimina = lista.get(0).getId();
    	}
    }
}

