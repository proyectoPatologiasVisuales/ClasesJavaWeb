package servicios;

import java.util.List;

import dao.PatologiasDAO;
import dto.*;

public class PatologiaService {
	
	public PatologiasDTO obtenerPatologiaPorID(int id){
		PatologiasDTO patoDTO = null;

			patoDTO = MapaPatologias.getPatologia (id);
			
		return patoDTO;
	}
}
