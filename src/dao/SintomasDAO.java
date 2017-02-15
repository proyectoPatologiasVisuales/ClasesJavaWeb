package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import consulta.Consultas;
import dto.GenericDTO;
import dto.SintomasDTO;

public class SintomasDAO extends GenericDAO {

	
	@Override
	public GenericDTO componerObjeto (ResultSet rs) throws SQLException	{
		SintomasDTO sintomasDTO = null;
		
		int id_sintoma = rs.getInt("id_sint");
		String descripcion_sintoma = rs.getString("des_sint");
		
		sintomasDTO = new SintomasDTO (id_sintoma,descripcion_sintoma);
		
		return sintomasDTO;
	}

	public List<GenericDTO> seleccionarTodosSintomas() throws Throwable{
		
		List<GenericDTO> lista_sintomas = null;
		
			lista_sintomas = ejecutarConsultaMultiple(Consultas.CONSULTA_LISTAR_PATOLOGIAS,null );
		
		return lista_sintomas;
	}
	
	public List<GenericDTO> seleccionarSintomasPorPatologia(List<GenericDTO> sintomas,String nombre_patologia) throws Throwable{
		List<GenericDTO> lista_sintomas = null;
		
			lista_sintomas = ejecutarConsultaMultiple(Consultas.CONSULTA_SINTOMAS_POR_PATOLOGIA,nombre_patologia );
		
		return lista_sintomas;
	}
}