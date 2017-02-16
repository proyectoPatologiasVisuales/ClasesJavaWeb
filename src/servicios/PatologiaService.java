package servicios;

import java.util.List;

import dao.PatologiasDAO;
import dto.*;

public class PatologiaService {
	
	public PatologiasDTO obtenerPatologiaPorID(int id){
		PatologiasDTO patoDTO = null;
		
		//VERSI�N 1 .- Accediendo a la base de datos cada vez
			/*PatologiaDAO pdao = new PatologiaDAO();
			patoDTO = pdao.buscarPorId(id);
		
			System.out.println(patoDTO.toString());*/
		//FIN VERSI�N 1 .- Accediendo a la base de datos cada vez
			
		//VERSI�N 2 .- Accediendo al Mapa precargado con Todas las patlog�as
			
			patoDTO = MapaPatologias.getPatologia (id);
			
		//FIN VERSI�N 2 .- Accediendo al Mapa precargado con Todas las patlog�as
			
		return patoDTO;
	}
}
