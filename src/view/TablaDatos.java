package view;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.VisitaGuiada;

@SuppressWarnings("serial")
public class TablaDatos extends AbstractTableModel{
	
	Controller ctrl;
	ArrayList<VisitaGuiada> visitas;
	String[] _header = { "Id", "Fecha", "Tematica", "Duracion" };

	public TablaDatos(Controller ctrl) {
		this.ctrl = ctrl;
		visitas = ctrl.consultarVisitas();
	}
	
	public String getColumnName(int col) {
		return _header[col];
	}
	
	@Override
	public int getRowCount() {
		return visitas == null ? 0 : visitas.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object s = null;
		switch (columnIndex) {
		case 0:
			s = visitas.get(rowIndex).getId();
			break;
		case 1:
			s = visitas.get(rowIndex).getFecha();
			break;
		case 2:
			s = visitas.get(rowIndex).getTematica();
			break;
		case 3:
			s = visitas.get(rowIndex).getDuracion();
			break;
		}
		return s;
	}

}
