package controlador;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Circulo;

import java.io.IOException;

/**
 * Servlet implementation class CirculoControllerServlet
 */
public class CirculoControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CirculoControllerServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String operacion = request.getParameter("operacion");
		String diametroStr = request.getParameter("diametro");
		
		double diametro = Double.parseDouble(diametroStr);
		
		Circulo circulo = new Circulo(diametro);
		
		if(operacion.equalsIgnoreCase("area")) {
			double area = circulo.calcularAreaC();
			request.setAttribute("resultado", area);
			request.setAttribute("operacion", "area");
		}else {
			Double perimetro = circulo.calcularPerimetro();
			request.setAttribute("resultado",perimetro);
			request.setAttribute("operacion", "perimetro");
		}
		
		String rutaJSPC = "WEB-INF/jsp/view/circulo.jsp";
		
		request.getRequestDispatcher(rutaJSPC).forward(request,response);
			
		}


}