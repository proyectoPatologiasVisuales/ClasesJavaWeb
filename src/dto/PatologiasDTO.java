package dto;

import java.util.ArrayList;
import java.util.List;

public class PatologiasDTO {

	private int id_patologia;
	private String nombre_patologia;
	private String descripcion_patologia;
	private String tratamiento_patologia;
	private String causa_patologia;
	private String ruta_imagen_patologia;
	private List<SintomasDTO> lista_sintomas;
	
	public PatologiasDTO buscarPatologiaPorID(int id){
		
		return null;
	}
	
	public PatologiasDTO(){		
	}
	
	public PatologiasDTO(int id_patologia, String nombre_patologia,	String descripcion_patologia, 
			String tratamiento_patologia,String causa_patologia,String ruta_imagen_patologia) 
	{
		super();
		this.id_patologia = id_patologia;
		this.nombre_patologia = nombre_patologia;
		this.descripcion_patologia = descripcion_patologia;
		this.tratamiento_patologia = tratamiento_patologia;
		this.causa_patologia = causa_patologia;
		this.ruta_imagen_patologia = ruta_imagen_patologia;
		this.lista_sintomas = new ArrayList<SintomasDTO>();
	}

	public int getId_patologia() {
		return id_patologia;
	}
	public void setId_patologia(int id_patologia) {
		this.id_patologia = id_patologia;
	}
	public String getNombre_patologia() {
		return nombre_patologia;
	}
	public void setNombre_patologia(String nombre_patologia) {
		this.nombre_patologia = nombre_patologia;
	}
	public String getDescripcion_patologia() {
		return descripcion_patologia;
	}
	public void setDescripcion_patologia(String descripcion_patologia) {
		this.descripcion_patologia = descripcion_patologia;
	}
	public String getTratamiento_patologia() {
		return tratamiento_patologia;
	}
	public void setTratamiento_patologia(String tratamiento_patologia) {
		this.tratamiento_patologia = tratamiento_patologia;
	}
	public List<SintomasDTO> getLista_sintomas() {
		return lista_sintomas;
	}
	public void setLista_sintomas(List<SintomasDTO> lista_sintomas2) {
		this.lista_sintomas = lista_sintomas2;
	}
	public String getCausa_patologia() {
		return causa_patologia;
	}
	public void setCausa_patologia(String causa_patologia) {
		this.causa_patologia = causa_patologia;
	}
	public String getRuta_imagen_patologia() {
		return ruta_imagen_patologia;
	}

	public void setRuta_imagen_patologia(String ruta_imagen_patologia) {
		this.ruta_imagen_patologia = ruta_imagen_patologia;
	}

	public void addSintoma (SintomasDTO sintomadto)
	{
		this.lista_sintomas.add(sintomadto);
	}
}