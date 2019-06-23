package modelo;

import modelo.dao.*;
import modelo.vo.*;

public class Logica {
	private ClienteDao clienteDao;
	private FarmaceuticoDao farmaceuticoDao;
	private DispensaDao dispensaDao;
	private MedicamentoDao medicamentoDao;
	private RecetaDao recetaDao;

	public Logica() {
		clienteDao = new ClienteDao();
		farmaceuticoDao = new FarmaceuticoDao();
		dispensaDao = new DispensaDao();
		medicamentoDao = new MedicamentoDao();
		recetaDao = new RecetaDao();
	}

}
