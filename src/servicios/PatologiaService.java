package servicios;

import java.util.List;

import dao.PatologiasDAO;
import dto.*;

public class PatologiaService {
	
	public PatologiasDTO obtenerPatologiaPorID(int id){
		PatologiasDTO patologiaBuscada = new PatologiasDTO();
		PatologiasDAO patologiasDao = new PatologiasDAO();

			patologiaBuscada = (PatologiasDTO) patologiasDao.buscarPatologiaPorID(id);
		
		return patologiaBuscada;
	}
}
