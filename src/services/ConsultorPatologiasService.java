package services;

import java.util.ArrayList;
import java.util.List;
import dto.*;

public class ConsultorPatologiasService {

	/**
	 * Primero de todo una pagina web enviar� un resultado dada la primera pregunta del test
	 * (que ser� siempre la misma) en funcion del resultado se llamara a patologiasConSintoma
	 * o a patologiasSinSintoma mediante el metodo controlDeTest
	 * Cuando devuelva la lista de patologias se llamar� a sintomaAPreguntar para poder
	 * realizar la siguiente pregunta del test
	 */
	
	/**
	 * Se encarga de llamar a patologiasConSintoma o a patologiasSinSintoma en funcion de la respuesta
	 * del usuario y devuelve la lista de patologias resultante
	 */
	public List<PatologiasDTO> controlDeTest (List<PatologiasDTO> listaPatologias,SintomasDTO sintoma,boolean respuestaDelUsuario){
		
		return listaPatologias;
	}
	
	/**
	 *	Devuelve una lista de patologias que SI tengan el sintoma introducido
	 */
	public List<PatologiasDTO> patologiasConSintoma(List<PatologiasDTO> listaPatologias,SintomasDTO sintoma_incluido){
		List <PatologiasDTO> lista_devuelta = new ArrayList<PatologiasDTO>();
		ConsultorPatologiasService consultor = new ConsultorPatologiasService();
		
		for(PatologiasDTO patologia:listaPatologias)
		{
			if(consultor.comprobarSintomaEnPatologia(patologia, sintoma_incluido))
			{
				lista_devuelta.add(patologia);
			}
		}
		
		return lista_devuelta;
	}
	
	/**
	 *	Devuelve una lista de patologias que NO tengan el sintoma introducido
	 */
	public List<PatologiasDTO> patologiasSinSintoma(List<PatologiasDTO> listaPatologias,SintomasDTO sintoma_excluido){
		List <PatologiasDTO> lista_devuelta = new ArrayList<PatologiasDTO>();
		ConsultorPatologiasService consultor = new ConsultorPatologiasService();
		
		for(PatologiasDTO patologia:listaPatologias)
		{
			if(!consultor.comprobarSintomaEnPatologia(patologia, sintoma_excluido))
			{
				lista_devuelta.add(patologia);
			}
		}
		
		return lista_devuelta;
	}
	
	/**
	 * Devuelve un true o false si la patologia tiene el sintoma introducido
	 */
	public boolean comprobarSintomaEnPatologia(PatologiasDTO patologia,SintomasDTO sintoma_buscado){
		boolean encontrado = false;
		List<SintomasDTO> lista_sintomas = patologia.getLista_sintomas();
		SintomasDTO sintoma_auxiliar = new SintomasDTO();
		String nombre_sintoma = null;
		String nombre_sintoma_buscado = sintoma_buscado.getNombre_sintoma();
		int contador = 0;
		
			while(!encontrado && contador<lista_sintomas.size())
			{
				sintoma_auxiliar = lista_sintomas.get(contador);
				nombre_sintoma = sintoma_auxiliar.getNombre_sintoma();
				
				if(nombre_sintoma.equals(nombre_sintoma_buscado))
				{
					encontrado=true;
				}
			}
		
		return encontrado;
	}
	
	/**
	 * Dada una lista de Patologias se devuelve el sintoma mas comun de ellas
	 */
	public SintomasDTO sintomaAPreguntar(List<PatologiasDTO> lista_patologias){
		SintomasDTO sintoma_pregunta = null;
		
		return sintoma_pregunta;
	}
}