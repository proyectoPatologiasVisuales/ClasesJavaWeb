package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import dto.GenericDTO;

public abstract class  GenericDAO {

	protected Connection conexion;
	protected Statement stmt;
	protected ResultSet rset;
	
	private final static String cadena_conexion = "jdbc:mysql://localhost:3307/femxa";
	private final static String user = "adminGXjlxzG";
	private final static String password = "QBShkFDW_69e";
	

	public GenericDTO ejecutarConsultaSimple(String consulta,String argumentos) throws Throwable	{
			GenericDTO dtoAux = null;
			
			if(argumentos != null)
			{
				consulta = consulta + argumentos;
			}
			
			try
				{
					Pool pool = null;
					pool = Pool.getInstance();
					conexion  = Pool.getConnection();
					stmt = conexion.createStatement();
					stmt.execute(consulta);
					rset = stmt.getResultSet();
					if (rset != null)
					{
						if (rset.next())
						{
							dtoAux = this.componerObjeto(rset);					
						}
					}
			}
			finally
			{
				liberarRecursos(conexion, stmt, rset);
				//conexionssh.desconectate_D_SSH();
			}
			return dtoAux;
	}

	public List<GenericDTO> ejecutarSentencia(Connection conn,String instruccion){
		return null;
	}
	
	/**
	 * Mediante una consulta de sql devuelve una lista de objetos de GenericDTO
	 * @param consulta - Consulta que es introducida cuando se invoca el metodo
	 * @return
	 * @throws Throwable 
	 */
	public List<GenericDTO> ejecutarConsultaMultiple(String consulta,String argumentos) throws Throwable{
		
		List<GenericDTO> listadev = new ArrayList<GenericDTO>();
		GenericDTO dtoAux = null;
		
		if(argumentos != null)
		{
			consulta = consulta + argumentos;
			consulta = consulta + "))";
			System.out.println(consulta);
		}
		
		try
		{
			Pool pool = null;
			pool = Pool.getInstance();
			conexion  = Pool.getConnection();
			stmt = conexion.createStatement();
			stmt.execute(consulta);
			rset = stmt.getResultSet();
		
			while (rset.next())
			{
				dtoAux = this.componerObjeto(rset);
				listadev.add(dtoAux);
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			liberarRecursos(conexion, stmt, rset);
			//conexionssh.desconectate_D_SSH();
		}
		return listadev;
	}

	/**
	 * Metodo que compone el objeto GenericDTO dado un ResulSet
	 * @param rs
	 * @return
	 * @throws SQLException
	 */
	
	public abstract GenericDTO componerObjeto (ResultSet rs) throws SQLException;
	 
	/**
	 * Dado un string "sentencia" se cambia una ' de ese string y se sustituye por un String "argumento"
	 * Tendra que contar los "(" para añadir al final la misma cantidad de ")"
	 * @param sentencia
	 * @param argumento
	 * @return
	 * @throws Exception
	 */
	public String sustituirArgumentos (String sentencia, String argumento) throws Exception
	{
		String sentenciatraducida = "";
		
		return sentenciatraducida;
	}

	private static void liberarRecursos (Connection conn,Statement st, ResultSet rs){
		
			if (rs != null) 	{ try { rs.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (st != null)	{ try {	st.close(); } catch (Exception e2) { e2.printStackTrace(); }}
			if (conn != null) 	{ try { conn.close(); } catch (Exception e3) { e3.printStackTrace(); }}
		  
	}
	
}

