package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import consulta.Consultas;
import dto.GenericDTO;
import dto.PatologiasDTO;
import dto.SintomasDTO;


public class PatologiasDAO extends GenericDAO{

	@Override
	public GenericDTO componerObjeto(ResultSet rs) throws SQLException {
		
		PatologiasDTO patologia_dto = null;
		
		int id_patologia = rs.getInt("id_patol");
		String nombre_patologia = rs.getString("nom_patol");
		String descripcion_patologia = rs.getString("des_patol");
		String tratamiento_patologia = rs.getString("trat_patol");
		String causa_patologia = rs.getString("causa_patol");
		
		patologia_dto = new PatologiasDTO(id_patologia,nombre_patologia,descripcion_patologia,tratamiento_patologia,causa_patologia);
		
		return patologia_dto;
	}
	
	public GenericDTO buscarPatologiaPorID(int id){
		PatologiasDTO patologia = new PatologiasDTO();
		List<GenericDTO> lista_sintomas = null;
		SintomasDAO sintomas_dao = new SintomasDAO();
		
		String id_St = String.valueOf(id);
		String nombre_patologia = "\"";
			try {
				patologia = (PatologiasDTO) ejecutarConsultaSimple(Consultas.CONSULTA_PATOLOGIAS_POR_ID, id_St);
				
				nombre_patologia = nombre_patologia + patologia.getNombre_patologia();
				
				nombre_patologia = nombre_patologia + "\"";
				
				lista_sintomas = sintomas_dao.seleccionarSintomasPorPatologia(lista_sintomas, nombre_patologia);
				
				patologia.setLista_sintomas(lista_sintomas);
				
			} catch (Throwable e) 
			{
				e.printStackTrace();
			}
		
		return patologia;
	}
	
	public ArrayList<GenericDTO> seleccionarTodasPatologias() throws Throwable{
		List<GenericDTO> lista_patologias = null;
		
		String consulta = Consultas.CONSULTA_LISTAR_PATOLOGIAS;
		
		lista_patologias = ejecutarConsultaMultiple(consulta,null);
		
		return (ArrayList<GenericDTO>) lista_patologias;
	}

}