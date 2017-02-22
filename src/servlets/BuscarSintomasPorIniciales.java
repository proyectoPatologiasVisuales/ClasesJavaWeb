package servlets;

import java.awt.List;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import servicios.SintomasService;

/**
 * Servlet implementation class BuscarSintomas
 */
@WebServlet("/BuscarSintomasPorIniciales")
public class BuscarSintomasPorIniciales extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarSintomasPorIniciales() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SintomasService sintomas_service = new SintomasService();
		ArrayList<String> lista_sintomas = new ArrayList<String>();
		
		String valorSintoma = request.getParameter("sintomaBuscado");
		
		lista_sintomas = (ArrayList<String>) sintomas_service.buscarSintomaPorInicial(valorSintoma);
		
		SintomasService.imprimirLista(lista_sintomas);
		
		
		Gson gson = new Gson();
		Type tipoListaSintomas = new TypeToken<List>(){}.getType();
		String s = gson.toJson(lista_sintomas, tipoListaSintomas);
		System.out.println(s);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
