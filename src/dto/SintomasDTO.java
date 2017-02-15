package dto;

import java.util.List;

public class SintomasDTO extends GenericDTO{
	
	private int id_sintoma;
	private String descripcion_sintoma;
	
	public SintomasDTO(int id_sintoma, String nombre_sintoma)
	{
		super();
		this.id_sintoma = id_sintoma;
		this.descripcion_sintoma = nombre_sintoma;
	}

	public SintomasDTO(){
		
	}
	
	public SintomasDTO(String nombre_sintoma) {
		this.descripcion_sintoma = nombre_sintoma;
	}

	public int getId_sintoma() {
		return id_sintoma;
	}
	public void setId_sintoma(int id_sintoma) {
		this.id_sintoma = id_sintoma;
	}
	public String getNombre_sintoma() {
		return descripcion_sintoma;
	}
	public void setNombre_sintoma(String nombre_sintoma) {
		this.descripcion_sintoma = nombre_sintoma;
	}
	
}
