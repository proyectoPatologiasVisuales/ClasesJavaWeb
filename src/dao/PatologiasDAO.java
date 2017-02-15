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
		
		int id_patologia = rs.getInt(1);
		String nombre_patologia = rs.getString(2);
		String descripcion_patologia = rs.getString(3);
		String tratamiento_patologia = rs.getString(4);
		String causa_patologia = rs.getString(5);
		
		patologia_dto = new PatologiasDTO(id_patologia,nombre_patologia,descripcion_patologia,tratamiento_patologia,causa_patologia);
		
		return patologia_dto;
	}
	
	public GenericDTO buscarPatologiaPorID(int id){
		PatologiasDTO patologia = new PatologiasDTO();
		List<GenericDTO> lista_sintomas = null;
		
		String id_St = String.valueOf(id);
		String nombre_patologia = null;
			try {
				patologia = (PatologiasDTO) ejecutarConsultaSimple(Consultas.CONSULTA_PATOLOGIAS_POR_ID, id_St);
				
				nombre_patologia = patologia.getNombre_patologia();
				
				//lista_sintomas = ejecutarConsultaMultiple(Consultas.CONSULTA_SINTOMAS_POR_PATOLOGIA, nombre_patologia);
				
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