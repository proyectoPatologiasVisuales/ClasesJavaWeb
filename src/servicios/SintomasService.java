package servicios;

import java.util.ArrayList;
import java.util.List;

import dto.ListadoSintomas;
import dto.SintomasDTO;

public class SintomasService {

	public List<String> buscarSintomaPorInicial(String inicial){
		List<String> lista_descripcion = new ArrayList<String>();
		List<SintomasDTO> lista_sintomas = ListadoSintomas.listaSintomasCompleta();
		String sintoma_descripcion = null;
		
		inicial = inicial.toLowerCase();
		
		for (SintomasDTO sintoma:lista_sintomas)
		{
			sintoma_descripcion = sintoma.getDescripcion();
	        
	        if(sintoma_descripcion.startsWith(inicial)) 
	        {
	        	lista_descripcion.add(sintoma_descripcion);
	        }
			
		}
		
		imprimirLista(lista_descripcion);
		
		return lista_descripcion;
	}
	
	
	
	public static void imprimirLista(List<String> lista_descripcion)
	{
		for(String descripcion:lista_descripcion)
		{
			System.out.println(descripcion);
		}
	}
}
