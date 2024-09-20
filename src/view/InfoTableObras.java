package view;


import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

public class InfoTableObras extends JPanel{
	String _title;
	TableModel _tableModel;
	
	InfoTableObras(String title, TableModel tableModel) {
		_title = title;
		_tableModel = tableModel;
		initGUI();
	}
	
	private void initGUI() {
		// TODO cambiar el layout del panel a BorderLayout()
		this.setLayout(new BorderLayout());
		// TODO añadir un borde con título al JPanel, con el texto _title
		this.setBorder(new TitledBorder(_title));
		// TODO añadir un JTable (con barra de desplazamiento vertical) que use
		// _tableModel
		JTable tabla = new JTable(_tableModel);
		JScrollPane scrollpane = new JScrollPane(tabla);
		this.add(scrollpane);
		scrollpane.setViewportView(tabla);
		scrollpane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	}

}
