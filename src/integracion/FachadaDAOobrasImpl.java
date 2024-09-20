package integracion;

import java.io.InputStream;
import java.util.List;

import org.json.JSONObject;

import model.Obra;

public class FachadaDAOobrasImpl implements FachadaDAOobras{

	private DAOobras dao;
	
	public FachadaDAOobrasImpl() {
		 dao = new DAOobrasImpl();
		 loadData();
	}
	@Override
	public boolean addObra(Obra obra) {
		return dao.addObra(obra);
	}

	@Override
	public Obra buscaObra(String id) {
		return dao.buscaObra(id);
	}

	@Override
	public boolean eliminarObra(String id) {
		return dao.eliminarObra(id);
	}

	@Override
	public JSONObject getState() {
		return dao.getState();
	}

	@Override
	public List<Obra> consultaLista() {
		return dao.consultaLista();
	}

	@Override
	public void loadData() {
		dao.loadData();
	}

	@Override
	public void uploadData() {
		dao.uploadData();
	}

}
