package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.PatologiasDTO;
import servicios.PatologiaService;

/**
 * Servlet implementation class ObtenerPatologiaPorId
 */
@WebServlet("/BuscarPatologia")
public class BuscarPatologia extends HttpServlet {
	private PatologiaService service_patologia;
	private PatologiasDTO patologia;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPatologia() {
        super();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String valorid = request.getParameter("id");
		int id = Integer.valueOf(valorid);

		patologia = service_patologia.obtenerPatologiaPorID(id);
		
		request.setAttribute("patologia", patologia);
		
		switch (id) {
		case 1:
			request.getRequestDispatcher(".//html//queratocono.jsp").forward(request, response);
			break;
		case 2:
			request.getRequestDispatcher(".//html//glaucoma.jsp").forward(request, response);
			break;
		case 3:
			request.getRequestDispatcher(".//html//glaucoma.jsp").forward(request, response);
			break;
		case 4:
			request.getRequestDispatcher(".//html//catarata.jsp").forward(request, response);
			break;
		case 5:
			request.getRequestDispatcher(".//html//conjuntivitis.jsp").forward(request, response);
			break;
		case 6:
			request.getRequestDispatcher(".//html//desprendimiento.jsp").forward(request, response);
			break;
		case 7:
			request.getRequestDispatcher(".//html//acromotopsia.jsp").forward(request, response);
			break;
		case 8:
			request.getRequestDispatcher(".//html//estrabismo.jsp").forward(request, response);
			break;
		case 9:
			request.getRequestDispatcher(".//html//presbicia.jsp").forward(request, response);
			break;
		default:
			break;
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request,response);
	}
	
	@Override
	public void init() throws ServletException {
		service_patologia = new PatologiaService();
		patologia = new PatologiasDTO();
		super.init();
	}

}
