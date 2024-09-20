package view;


import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import control.Controller;
import model.Usuario;

public class VentanaCrudEmpleados extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Controller ctlr;
	private JPanel paneldatos,paneleleccion,panel,instrucciones,auxPanelInstrucBoton,instructexto,auxPanelOpciones;
	private GroupLayout layout,layoutelec;
	private BoxLayout layoutmain,layoutinstruc,layoutinstruc2; 
	private JLabel nombre,dni,puesto,contraseña,confircontrase,dniinvalido,alta,baja,modificar,seleccionopcion;
	private JLabel campoobligatorio1,campoobligatorio2,campoobligatorio3,campoobligatorio4,campoobligatorio5;
	private JTextField nombretxt,dnitxt,contraseñatxt,confircontrasetxt;
	private JButton aceptar,mostrar1,mostrar2;
	private JButton cancelar,cancelar2;
	private JComboBox<String> eleccion,puestotxt;
	private Usuario usuario;
	private int bajarespuesta;
	private Font fontCursiva, fontNegrita ;
	private Color colorblanco;
	private Image imglogo,imgcancelar, imgaceptar,imgmostrar,imgocultar;
	private ImageIcon iconlogo,iconcancelar,iconaceptar,iconmostrar,iconocultar;

	public VentanaCrudEmpleados() {}
	
	public VentanaCrudEmpleados(Controller ctlr) {
		this.ctlr = ctlr;
        initComponents();
        
	}
	
    public VentanaCrudEmpleados(Controller ctlr,Usuario usuario) {
    	this.ctlr = ctlr;
    	this.usuario=usuario;
        initComponents();
    }

	private void initComponents() {
		
		
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Modificacion de Empleados");
		
		
		paneldatos = new JPanel();
		paneldatos.setBackground(new Color(255, 148, 172));
		paneleleccion= new JPanel();
		panel=new JPanel();
		instrucciones= new JPanel();
		auxPanelInstrucBoton= new JPanel();
		auxPanelOpciones= new JPanel();
		paneleleccion= new MyPanel(new Color(253, 216, 7),new Color(105, 7, 161), new Color(6, 25, 34),"Opciones",15);
		instructexto= new MyPanel(new Color(253, 216, 7),new Color(105, 7, 161), new Color(6, 25, 34),"Informacion de las opciones",15);

		nombre= new JLabel("Nombre");
		dni= new JLabel("Dni");
		puesto= new JLabel("Puesto");
        contraseña= new JLabel("Contraseña");
        confircontrase= new JLabel("Confirmar contraseña");
        dniinvalido= new JLabel("El Dni no existe");
        seleccionopcion= new JLabel("Seleccione una opcion:");
        campoobligatorio1= new JLabel("*El Dni no tiene el formato correcto*");
        campoobligatorio2= new JLabel("*Campo obligatorio*");
        campoobligatorio3= new JLabel("*Campo obligatorio*");
        campoobligatorio4= new JLabel("*Campo obligatorio*");
        campoobligatorio5= new JLabel("*Campo obligatorio*");
        
        fontCursiva = new Font(dniinvalido.getFont().getName(), Font.ITALIC, dniinvalido.getFont().getSize());
        fontNegrita = new Font(seleccionopcion.getFont().getName(), Font.BOLD, 13);
        colorblanco=new Color(255, 255, 255);
        
        controlcamposfont(dniinvalido);
        controlcamposfont(campoobligatorio1);
        controlcamposfont(campoobligatorio2);
        controlcamposfont(campoobligatorio3);
        controlcamposfont(campoobligatorio4);
        controlcamposfont(campoobligatorio5);
        seleccionopcion.setFont(fontNegrita);
     
        nombretxt= new JTextField();
		dnitxt= new JTextField();
		contraseñatxt= new JPasswordField();
		confircontrasetxt = new JPasswordField();
		
		
		aceptar= new JButton("Aceptar");
		cancelar= new JButton("Cancelar");
		cancelar2= new JButton("Cancelar");
		mostrar1= new JButton();
		mostrar2= new JButton();
		
		iconlogo= new ImageIcon("logo/logo.png");
 		imglogo = iconlogo.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
		iconaceptar= new ImageIcon("logo/aceptar.png");
 		imgaceptar = iconaceptar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
 		
 		iconcancelar= new ImageIcon("logo/cancelar.png");
 		imgcancelar = iconcancelar.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH); 
 		
 		iconmostrar= new ImageIcon("logo/Mostrar.png");
 		imgmostrar = iconmostrar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
 		
 		iconocultar= new ImageIcon("logo/ocultar.png");
 		imgocultar = iconocultar.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		
 		setIconImage(imglogo);
 		aceptar.setIcon(new ImageIcon(imgaceptar));
 		cancelar.setIcon(new ImageIcon(imgcancelar));
 		cancelar2.setIcon(new ImageIcon(imgcancelar));
 		mostrar1.setIcon(new ImageIcon(imgmostrar));
 		mostrar2.setIcon(new ImageIcon(imgmostrar));
 		
		panel.setBackground(new Color(79, 101, 112));
		paneldatos.setBackground(new Color(79, 101, 112));
		paneleleccion.setBackground(new Color(79, 101, 112));
		instrucciones.setBackground(new Color(79, 101, 112));
		auxPanelInstrucBoton.setBackground(new Color(79, 101, 112));
		auxPanelOpciones.setBackground(new Color(79, 101, 112));
		aceptar.setBackground(colorblanco);
        cancelar.setBackground(colorblanco);
        cancelar2.setBackground(colorblanco);
        mostrar1.setBackground(colorblanco);
        mostrar2.setBackground(colorblanco);
        
		eleccion=new JComboBox<String>();
		puestotxt= new JComboBox<String>();
		
		eleccion.addItem("");
		eleccion.addItem("Alta");
		eleccion.addItem("Baja");
		eleccion.addItem("Modificacion");
		
		
		puestotxt.addItem("");
		puestotxt.addItem("Administrador");
		puestotxt.addItem("Guía");
		puestotxt.addItem("Restaurador");
		
		
		eleccion.setBackground(colorblanco);
		puestotxt.setBackground(colorblanco);
		
		nombretxt.setPreferredSize(new Dimension(200, 30));
		dnitxt.setPreferredSize(new Dimension(200, 30));
		puestotxt.setPreferredSize(new Dimension(200, 30));
		contraseñatxt.setPreferredSize(new Dimension(200, 30));
		confircontrasetxt.setPreferredSize(new Dimension(200, 30));
		
		
		
		nombre.setSize(100, 20);
		dni.setSize(100, 20);
		puesto.setSize(100, 20);
		contraseña.setSize(100, 20);
		confircontrase.setSize(100, 20);
		eleccion.setSize(40, 20);
		aceptar.setSize(150, 40);
		cancelar.setSize(150,40);
		cancelar2.setSize(150,40);
		
		eleccion.addActionListener((e) -> {
			String aux= (String) eleccion.getSelectedItem();
			
			if(aux=="") {
				configuracionInstrucciones();
			}
			if(aux=="Alta") {
				configuracionAlta();
			}
			else if(aux=="Baja") {
				if(usuario==null) {
					Utils.showErrorMsg("No seleccionaste ningun empleado de la tabla");
					if(paneldatos.isVisible())
						eleccion.setSelectedIndex(1);
					else
						eleccion.setSelectedIndex(0);
				}else {
					configuracionBaja();
				}
				
			}
			else if(aux=="Modificacion") {
				if(usuario==null) {
					Utils.showErrorMsg("No seleccionaste ningun empleado de la tabla");
					if(paneldatos.isVisible())
						eleccion.setSelectedIndex(1);
					else
						eleccion.setSelectedIndex(0);
				}else {
					configuracionModificacion();
				}
			}
			paneldatos.revalidate();
			pack();
			
		});
		mostrar1.addActionListener((e) -> {
		        if (((JPasswordField) contraseñatxt).getEchoChar() != 0) {
		        	 ((JPasswordField) contraseñatxt).setEchoChar((char) 0);
		        	
		        	 mostrar1.setIcon(new ImageIcon(imgocultar));
		        } else {
		        	((JPasswordField) contraseñatxt).setEchoChar('•');
		        	 mostrar1.setIcon(new ImageIcon(imgmostrar));
		        }
		    
		});
		mostrar2.addActionListener((e) -> {
	        if (((JPasswordField) confircontrasetxt).getEchoChar() != 0) {
	        	 ((JPasswordField) confircontrasetxt).setEchoChar((char) 0);
	        	 mostrar2.setIcon(new ImageIcon(imgocultar));
	        } else {
	        	((JPasswordField) confircontrasetxt).setEchoChar('•');
	        	
	        	 mostrar2.setIcon(new ImageIcon(imgmostrar));
	        }
	    
	});
		
		aceptar.addActionListener((e) -> {
			
			
			String aux= (String) eleccion.getSelectedItem();
			Usuario usuario_aux;
			if(aux=="Alta") {
				
				usuario_aux= new  Usuario(nombretxt.getText(),dnitxt.getText(),(String) puestotxt.getSelectedItem(),contraseñatxt.getText());
				if(dnitxt.getText().equalsIgnoreCase("")) {
					Utils.showErrorMsg("No ha introducido ningun DNI");
				}else {
					if(validarDNI(dnitxt.getText())) {
						campoobligatorio1.setVisible(false);	
					}else {
						campoobligatorio1.setVisible(true);	
					}
					if(nombretxt .getText().equalsIgnoreCase("")) {
					campoobligatorio2.setVisible(true);	
					}else {
						campoobligatorio2.setVisible(false);	
					}
					if(contraseñatxt.getText().equalsIgnoreCase("")) {
					campoobligatorio4.setVisible(true);	
					}else {
						campoobligatorio4.setVisible(false);	
					}
					if(confircontrasetxt.getText().equalsIgnoreCase("")) {
						campoobligatorio5.setVisible(true);	
						}else {
							campoobligatorio5.setVisible(false);	
					}
					if(puestotxt.getSelectedIndex()==0) {
					campoobligatorio3.setVisible(true);	
					}else {
						campoobligatorio3.setVisible(false);	
					}
					if(campoobligatorio1.isVisible()==false&&campoobligatorio2.isVisible()==false&&campoobligatorio3.isVisible()==false&&campoobligatorio4.isVisible()==false&&campoobligatorio5.isVisible()==false) {
						if(contraseñatxt.getText().equals(confircontrasetxt.getText())) {
							if(ctlr.buscarNombreUsuario(usuario_aux.getNombre())){
								Utils.showErrorMsg("El nombre de usuario ya existe");
							}else {
								if(ctlr.altaUsuario(usuario_aux)) {
									
										JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
										this.dispose();
									
								}else {
									Utils.showErrorMsg("Este usuario ya existe");
								}
							}
						}
						else {
							Utils.showErrorMsg("Las contraseñas no coinciden");
						}
						
					}
				}
			}
			else if(aux=="Baja") {
				if(dnitxt.getText().equalsIgnoreCase("")) {
					Utils.showErrorMsg("No ha seleccionado ningun DNI");
				}else {
					if(dniinvalido.isVisible()==false) {
						bajarespuesta = JOptionPane.showConfirmDialog(null, "¿Está seguro de que desea continuar?", "Confirmación", JOptionPane.YES_NO_OPTION);
						if (bajarespuesta == JOptionPane.YES_OPTION) {
						    
							ctlr.bajaUsuario(dnitxt.getText());
							JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
							this.dispose();
						}
					}
					else {
						Utils.showErrorMsg("El dni seleccionado no corresponde con el de ningun usuario");
					}
				}
			}
			else if(aux=="Modificacion") {
				usuario_aux= new  Usuario(nombretxt.getText(),dnitxt.getText(),(String) puestotxt.getSelectedItem(),contraseñatxt.getText());
				if(dnitxt.getText().equalsIgnoreCase("")) {
					Utils.showErrorMsg("No ha seleccionado ningun DNI");
				}else{
					if(nombretxt .getText().equalsIgnoreCase("")) {
					campoobligatorio2.setVisible(true);	
					}else {
						campoobligatorio2.setVisible(false);	
					}
					if(contraseñatxt.getText().equalsIgnoreCase("")) {
					campoobligatorio4.setVisible(true);	
					}else {
						campoobligatorio4.setVisible(false);	
					}
					if(puestotxt.getSelectedIndex()==0) {
					campoobligatorio3.setVisible(true);	
					}else {
						campoobligatorio3.setVisible(false);	
					}
					if(campoobligatorio2.isVisible()==false&&campoobligatorio3.isVisible()==false&&campoobligatorio4.isVisible()==false) {
						
						if(dniinvalido.isVisible()==false) {
							if(ctlr.buscarNombreUsuario(usuario_aux.getNombre())){
								Utils.showErrorMsg("El nombre de usuario ya existe");
							}else {
							ctlr.modificarUsuario(usuario_aux);
							JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
							
							this.dispose();
							}
						}
						else {
							Utils.showErrorMsg("El dni seleccionado no corresponde con el de ningun usuario");
						}
					}
				}
			}
			
			pack();
		});
		 cancelar.addActionListener((e) -> {
			 this.dispose();
			});
		 cancelar2.addActionListener((e) -> {
			 this.dispose();
			});
		 
		 layoutelec= new GroupLayout(paneleleccion);
		 paneleleccion.setLayout(layoutelec);
		 
		 layoutelec.setHorizontalGroup(
				 layoutelec.createSequentialGroup()
				
				 	
					.addComponent(seleccionopcion)
					.addGap(10)	
					.addComponent(eleccion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 80)
		);
		 layoutelec.setVerticalGroup(
				 layoutelec.createSequentialGroup()
				 	.addGroup(layoutelec.createParallelGroup(GroupLayout.Alignment.LEADING)
				 			.addGap(30)
				 			.addComponent(seleccionopcion)
				 			.addComponent(eleccion,GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
		);
		 
		 layout = new GroupLayout(paneldatos);
		 paneldatos.setLayout(layout);
		    layout.setHorizontalGroup(
		        layout.createSequentialGroup()
	
		        	.addGap(38)
	        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				        	.addComponent(dni)	
				        	.addComponent(nombre)
			        		.addComponent(puesto)		        		
			        		.addComponent(contraseña)
			        		.addComponent(confircontrase))
	        		
	        		.addGap(60)
	        		
		        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)

			        		.addGroup(layout.createSequentialGroup()
					            .addComponent(aceptar,125,125,125)
					            .addGap(38)
					            .addComponent(cancelar,125,125,125))    
	
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					        	.addComponent(dnitxt,200,200,200)
					        	.addComponent(nombretxt,200,200,200)		        			
					        	.addComponent(puestotxt,200,200,200)
					        	.addComponent(contraseñatxt,200,200,200)
		        				.addComponent(confircontrasetxt,200,200,200)))
		        			.addGroup(layout.createSequentialGroup()
		        				.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		        				.addComponent(mostrar1)
			        			.addComponent(mostrar2)))
		        	.addGap(20)
		        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		        			
		        			.addComponent(dniinvalido)
		        			.addComponent(campoobligatorio1)
		        			.addComponent(campoobligatorio2)
		        			.addComponent(campoobligatorio3)
		        			.addComponent(campoobligatorio4)
		        			.addComponent(campoobligatorio5)
		        	)
		        	.addGap(20)
		    		);
		 
		    layout.setVerticalGroup(
		        layout.createParallelGroup(GroupLayout.Alignment.LEADING)
		        	.addGroup(layout.createSequentialGroup()
		        			
			        	
			        	.addGap(30)
			        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addComponent(dni)
					        .addComponent(dnitxt)
				        	.addComponent(dniinvalido)
				        	.addComponent(campoobligatorio1))
				        .addGap(20)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addComponent(nombre)
					        .addComponent(nombretxt)
					        .addComponent(campoobligatorio2))
				        .addGap(20)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addComponent(puesto)
					        .addComponent(puestotxt)
					        .addComponent(campoobligatorio3))
				        .addGap(20)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addComponent(contraseña)
					        .addComponent(contraseñatxt)
					        .addComponent(mostrar1)
					        .addComponent(campoobligatorio4))
				        .addGap(20)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
					        .addComponent(confircontrase)
					        .addComponent(confircontrasetxt)
					        .addComponent(mostrar2)
			        		.addComponent(campoobligatorio5))	        
				        .addGap(30)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(aceptar,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE)
				            .addComponent(cancelar,GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE))
		        		.addGap(50))
		    		);
		
		    alta = new JLabel("     - Alta: añadir un usuario rellenando los campos que aparecen");
			baja = new JLabel("     - Baja: borrar el usuario seleccionado en la tabla ");
			modificar = new JLabel("     - Modificar: modificar los atributos del usuario seleccionado en la tabla             ");
			
		auxPanelInstrucBoton.add(cancelar2);
		auxPanelOpciones.add(paneleleccion);
		
		layoutinstruc= new BoxLayout(instrucciones, BoxLayout.Y_AXIS);
		instrucciones.setLayout(layoutinstruc);
		
		layoutinstruc2= new BoxLayout(instructexto, BoxLayout.Y_AXIS);
		instructexto.setLayout(layoutinstruc2);
			
		
		instructexto.add(Box.createVerticalStrut(20));
		instructexto.add(alta);
		instructexto.add(Box.createVerticalStrut(40));
		instructexto.add(baja);
		instructexto.add(Box.createVerticalStrut(40));
		instructexto.add(modificar);
		instructexto.add(Box.createVerticalStrut(20));
		
		
		instrucciones.add(instructexto);
		instrucciones.add(Box.createVerticalStrut(40));
		instrucciones.add(auxPanelInstrucBoton);
		instrucciones.add(Box.createVerticalStrut(50));
		instrucciones.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 60));
		
		
		layoutmain= new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layoutmain);
		panel.add(Box.createVerticalStrut(40));
		panel.add(auxPanelOpciones);
		panel.add(paneldatos);
		panel.add(instrucciones);
		
		paneldatos.setVisible(false);
		
		setContentPane(panel);
		
		pack();
		this.setResizable(false);
        setVisible(true);
	}

	
	private void configuracionInstrucciones() {
		paneldatos.setVisible(false);
		instrucciones.setVisible(true);
	}
	
	private void configuracionAlta() {
		campoObligatoriofalse();
		System.out.println("alta");
		
		paneldatos.setVisible(true);
		instrucciones.setVisible(false);
		nombretxt.setText(null);
		dnitxt.setText(null);
		puestotxt.setSelectedIndex(0);
		contraseñatxt.setText(null);
		confircontrasetxt.setText(null);
		
		nombre.setVisible(true);
		puesto.setVisible(true);
		contraseña.setVisible(true);
		dnitxt.setEnabled(true);
		nombretxt.setVisible(true);
		contraseñatxt.setVisible(true);
		puestotxt.setVisible(true);
		dniinvalido.setVisible(false);
		confircontrase.setVisible(true);
		confircontrasetxt.setVisible(true);
		mostrar1.setVisible(true);
		mostrar2.setVisible(true);
	}
	private void configuracionBaja() {
		campoObligatoriofalse();
		System.out.println("baja");
		
		dnitxt.setText(usuario.getDNI());
		
		if(ctlr.buscarUsuario(usuario.getDNI())==null){
			dniinvalido.setVisible(true);
		}
		
		paneldatos.setVisible(true);
		instrucciones.setVisible(false);
		nombre.setVisible(false);
		puesto.setVisible(false);
		contraseña.setVisible(false);
		dnitxt.setEnabled(false);
		dnitxt.setDisabledTextColor(Color.BLACK);
		nombretxt.setVisible(false);
		contraseñatxt.setVisible(false);
		puestotxt.setVisible(false);
		confircontrase.setVisible(false);
		confircontrasetxt.setVisible(false);
		mostrar1.setVisible(false);
		mostrar2.setVisible(false);
		
	}
	private void configuracionModificacion() {
		System.out.println("modi");
		campoObligatoriofalse();
	
		nombretxt.setText(usuario.getNombre());
		dnitxt.setText(usuario.getDNI());
		puestotxt.setSelectedItem(usuario.getPuesto());
		contraseñatxt.setText(usuario.getContraseña());
		
		if(ctlr.buscarUsuario(usuario.getDNI())==null){
			dniinvalido.setVisible(true);
		}
	
		paneldatos.setVisible(true);
		instrucciones.setVisible(false);
		nombre.setVisible(true);
		puesto.setVisible(true);
		contraseña.setVisible(true);
		dnitxt.setEnabled(false);
		dnitxt.setDisabledTextColor(Color.BLACK);
		nombretxt.setVisible(true);
		contraseñatxt.setVisible(true);
		puestotxt.setVisible(true);
		confircontrase.setVisible(false);
		confircontrasetxt.setVisible(false);
		mostrar1.setVisible(true);
		mostrar2.setVisible(false);
	}	
	
	private void campoObligatoriofalse() {
		campoobligatorio1.setVisible(false);
		campoobligatorio2.setVisible(false);
		campoobligatorio3.setVisible(false);
		campoobligatorio4.setVisible(false);
		campoobligatorio5.setVisible(false);

	}
	
	private void controlcamposfont(JLabel label) {
		label.setForeground(Color.RED);
		label.setFont(fontCursiva);
		label.setVisible(false);
	}
	
	private boolean validarDNI(String DNI) {
		
		return DNI.matches("\\d{8}[A-HJ-NP-TV-Z]");
	}
	

}
