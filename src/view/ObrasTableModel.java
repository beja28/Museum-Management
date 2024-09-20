package view;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Obra;


public class ObrasTableModel extends AbstractTableModel {

	private List<Obra> listaObras = new ArrayList<Obra>();
	private Controller ctrl;
	String[] header = {"Id", "Titulo", "Autor", "Fecha", "Estado"};
	
	public ObrasTableModel(Controller ctrl) {
		this.ctrl = ctrl;
		listaObras = ctrl.consultaObras();
	}
	
	
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return listaObras.size();	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return header.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Obra obra = listaObras.get(rowIndex);
		switch(columnIndex){
		case 0: return obra.getId();
		case 1: return obra.getTitulo();
		case 2: return obra.getAutor();
		case 3: 
			if(obra.getFecha() < 0) {
				return Math.abs(obra.getFecha()) + " A.C";
			}
			else
			{
				return obra.getFecha();
			}
			
			
		case 4:	
			return obra.getEstado();
			
		default:
			return null;			
		}
	}
	
	@Override
	public String getColumnName(int column) {
		return header[column];
	}

}
