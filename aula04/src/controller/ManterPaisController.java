package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Pais;
import service.PaisService;

/**
 * Servlet implementation class ManterPaisController
 */
@WebServlet("/ManterPais.do")
public class ManterPaisController extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String pNome = request.getParameter("nome");
			long pPopulacao = Long.parseLong(request.getParameter("populacao"));
			double pArea = Double.parseDouble(request.getParameter("area"));
			
			Pais pais = new Pais();
			pais.setNome(pNome);
			pais.setPopulacao(pPopulacao);
			pais.setArea(pArea);
			
			PaisService service = new PaisService();
			pais.setId(service.inserir(pais));
			Pais novo = service.carregar(pais.getId());
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Pais Cadastrado</title></head><body>");
			out.println("id: "+novo.getId()+"<br>");
			out.println("nome: "+novo.getNome()+"<br>");
			out.println("populacao: "+novo.getPopulacao()+"<br>");
			out.println("area: "+novo.getArea()+"<br>");
			out.println("</body></html>");
	}
}
