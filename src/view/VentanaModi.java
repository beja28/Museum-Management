package view;


import java.awt.*;
import javax.swing.*;

import control.Controller;
import model.Usuario;

public class VentanaModi extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	static Controller ctlr;
	private JPanel paneldatos,paneleleccion,panel,instrucciones;
	private GroupLayout layout,layoutelec;
	private BoxLayout layoutmain,layoutinstruc; 
	private JLabel nombre,dni,puesto,contraseña,dniinvalido,alta,baja,modificar;
	private JTextField nombretxt,dnitxt,contraseñatxt;
	private JButton aceptar;
	private JButton cancelar;
	private JComboBox<String> eleccion,puestotxt;
	private Usuario usuario;
	
	private Font fontCursiva ;
	
	public VentanaModi() {}
	
	public VentanaModi(Controller ctlr) {
		this.ctlr = ctlr;
        initComponents();
        
	}
	
    public VentanaModi(Controller ctlr,Usuario usuario) {
    	this.ctlr = ctlr;
    	this.usuario = usuario;
        initComponents();
    }

	private void initComponents() {
		
		
		setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Modificacion de Empleados");
		
		paneldatos = new JPanel();
		paneleleccion= new JPanel();
		panel=new JPanel();
		instrucciones= new JPanel();
		
		
		nombre= new JLabel("Nombre");
		dni= new JLabel("Dni");
		puesto= new JLabel("Puesto");
        contraseña= new JLabel("Contraseña");
        dniinvalido= new JLabel("El Dni no existe");
        
        fontCursiva = new Font(dniinvalido.getFont().getName(), Font.ITALIC, dniinvalido.getFont().getSize());
		
        dniinvalido.setForeground(Color.RED);
        dniinvalido.setFont(fontCursiva);
        dniinvalido.setVisible(false);
        
        nombretxt= new JTextField();
		dnitxt= new JTextField();
		contraseñatxt= new JTextField();
		
		aceptar= new JButton("OK");
		cancelar= new JButton("Cancelar");
		
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
		
		nombretxt.setPreferredSize(new Dimension(200, 30));
		dnitxt.setPreferredSize(new Dimension(200, 30));
		puestotxt.setPreferredSize(new Dimension(200, 30));
		contraseñatxt.setPreferredSize(new Dimension(200, 30));
		
		
		
		nombre.setSize(100, 20);
		dni.setSize(100, 20);
		puesto.setSize(100, 20);
		contraseña.setSize(100, 20);
		eleccion.setSize(40, 20);
		aceptar.setSize(150, 40);
		cancelar.setSize(150,40);
		
		eleccion.addActionListener((e) -> {
			String aux= (String) eleccion.getSelectedItem();
			
			if(aux=="") {
				configuracionInstrucciones();
			}
			if(aux=="Alta") {
				configuracionAlta();
			}
			else if(aux=="Baja") {
				configuracionBaja();
				
			}
			else if(aux=="Modificacion") {
				
				configuracionModificacion();
			}
			paneldatos.revalidate();
			pack();
			//panelBotones.repaint();
		});
		
		aceptar.addActionListener((e) -> {
			
			String aux= (String) eleccion.getSelectedItem();
			if(aux=="Alta") {
				if(dnitxt.getText()!=null) {
					usuario= new  Usuario(nombretxt.getText(),dnitxt.getText(),(String) puestotxt.getSelectedItem(),contraseñatxt.getText());
					ctlr.altaUsuario(usuario);
					JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
					eleccion.setSelectedIndex(0);
				}
			}
			else if(aux=="Baja") {
				if(dnitxt.getText().equalsIgnoreCase("")) {
					Utils.showErrorMsg("No ha seleccionado ningun DNI");
				}else {
					if(dniinvalido.isVisible()==false) {
					ctlr.bajaUsuario(dnitxt.getText());
					JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
					eleccion.setSelectedIndex(0);

					}
					else {
						Utils.showErrorMsg("El dni seleccionado no corresponde con el de ningun usuario");
					}
				}
			}
			else if(aux=="Modificacion") {
				if(dnitxt.getText().equalsIgnoreCase("")) {
					Utils.showErrorMsg("No ha seleccionado ningun DNI");
				}else {
					if(dniinvalido.isVisible()==false) {
						usuario= new  Usuario(nombretxt.getText(),dnitxt.getText(),(String) puestotxt.getSelectedItem(),contraseñatxt.getText());
						ctlr.modificarUsuario(usuario);
						JOptionPane.showMessageDialog(null, "La operacion se ha realizado correctamente", "Operacion realizada con exito", JOptionPane.PLAIN_MESSAGE);
						eleccion.setSelectedIndex(0);
					}
					else {
						Utils.showErrorMsg("El dni seleccionado no corresponde con el de ningun usuario");
					}
				}
			}
			
		
		});
		 cancelar.addActionListener((e) -> {
			 this.dispose();
			});
		 
		 layoutelec= new GroupLayout(paneleleccion);
		 paneldatos.setLayout(layoutelec);
		 
		 layoutelec.setHorizontalGroup(
				 layoutelec.createParallelGroup(GroupLayout.Alignment.CENTER)
			.addComponent(eleccion, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, 80)
		);
		 layoutelec.setVerticalGroup(
				 layoutelec.createParallelGroup(GroupLayout.Alignment.LEADING)
				 	.addGroup(layoutelec.createSequentialGroup()
				 			.addGap(30)
				 			.addComponent(eleccion,GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
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
			        		.addComponent(contraseña))
	        		
	        		.addGap(60)
	        		
		        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)

			        		.addGroup(layout.createSequentialGroup()
					            .addComponent(aceptar,100,100,100)
					            .addGap(38)
					            .addComponent(cancelar, 100,100,100))    
	
			        		.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
					        	.addComponent(dnitxt,200,200,200)
					        	.addComponent(nombretxt,200,200,200)		        			
					        	.addComponent(puestotxt,200,200,200)
					        	.addComponent(contraseñatxt,200,200,200)))
		        		
		        	.addGap(20)
		        	.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
		        			.addComponent(dniinvalido)
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
			        	.addComponent(dniinvalido))
				        .addGap(20)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(nombre)
				        .addComponent(nombretxt))
				        .addGap(20)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(puesto)
				        .addComponent(puestotxt))
				        .addGap(20)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				        .addComponent(contraseña)
				        .addComponent(contraseñatxt))
				        .addGap(30)
				        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				            .addComponent(aceptar, GroupLayout.PREFERRED_SIZE,40,GroupLayout.PREFERRED_SIZE)
				            .addComponent(cancelar, GroupLayout.PREFERRED_SIZE,40, GroupLayout.PREFERRED_SIZE))
		        		.addGap(50))
		    		);
		
		    alta = new JLabel("     - Alta: añadir un usuario rellenando los campos que aparecen");
			baja = new JLabel("     - Baja: borrar el usuario seleccionado en la tabla ");
			modificar = new JLabel("     - Modificar: modificar los atributos del usuario seleccionado en la tabla             ");
			
		layoutinstruc= new BoxLayout(instrucciones, BoxLayout.Y_AXIS);
		instrucciones.setLayout(layoutinstruc);
		instrucciones.add(Box.createVerticalStrut(100));
		instrucciones.add(alta);
		instrucciones.add(Box.createVerticalStrut(40));
		instrucciones.add(baja);
		instrucciones.add(Box.createVerticalStrut(40));
		instrucciones.add(modificar);
		instrucciones.add(Box.createVerticalStrut(100));
		
		layoutmain= new BoxLayout(panel, BoxLayout.Y_AXIS);
		panel.setLayout(layoutmain);
		panel.add(Box.createVerticalStrut(40));
		panel.add(paneleleccion);
		panel.add(paneldatos);
		panel.add(instrucciones);
		
		paneldatos.setVisible(false);
		
		setContentPane(panel);
		
		pack();
		
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
	}

	
	private void configuracionInstrucciones() {
		paneldatos.setVisible(false);
		instrucciones.setVisible(true);
	}
	
	private void configuracionAlta() {
		System.out.println("alta");
		
		paneldatos.setVisible(true);
		instrucciones.setVisible(false);
		nombretxt.setText(null);
		dnitxt.setText(null);
		puestotxt.setSelectedIndex(0);
		contraseñatxt.setText(null);
		
		nombre.setVisible(true);
		puesto.setVisible(true);
		contraseña.setVisible(true);
		dnitxt.setEnabled(true);
		nombretxt.setVisible(true);
		contraseñatxt.setVisible(true);
		puestotxt.setVisible(true);
		dniinvalido.setVisible(false);
	}
	private void configuracionBaja() {
		System.out.println("baja");
		if(usuario!=null) {
			dnitxt.setText(usuario.getDNI());
			if(ctlr.buscarUsuario(usuario.getDNI())==null){
				dniinvalido.setVisible(true);
			}
		}else {
			dnitxt.setText(null);
		}
		paneldatos.setVisible(true);
		instrucciones.setVisible(false);
		nombre.setVisible(false);
		puesto.setVisible(false);
		contraseña.setVisible(false);
		dnitxt.setEnabled(false);
		nombretxt.setVisible(false);
		contraseñatxt.setVisible(false);
		puestotxt.setVisible(false);
		//dniinvalido.setVisible(true);
		
	}
	private void configuracionModificacion() {
		System.out.println("modi");
		if(usuario!=null) {
			nombretxt.setText(usuario.getNombre());
    		dnitxt.setText(usuario.getDNI());
    		puestotxt.setSelectedItem(usuario.getPuesto());
    		contraseñatxt.setText(usuario.getContraseña());
    		if(ctlr.buscarUsuario(usuario.getDNI())==null){
				dniinvalido.setVisible(true);
			}
		}else {
			nombretxt.setText(null);
			dnitxt.setText(null);
			puestotxt.setSelectedItem("");
			contraseñatxt.setText(null);
		}
		paneldatos.setVisible(true);
		instrucciones.setVisible(false);
		nombre.setVisible(true);
		puesto.setVisible(true);
		contraseña.setVisible(true);
		dnitxt.setEnabled(false);
		nombretxt.setVisible(true);
		contraseñatxt.setVisible(true);
		puestotxt.setVisible(true);
	}	
	
	
	

}
