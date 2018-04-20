package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
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


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException 
	{		
			PaisService service = new PaisService();
			if(request.getParameter("acao").equals("Criar"))
			{
				String pNome = request.getParameter("nome");
				long pPopulacao = Long.parseLong(request.getParameter("populacao"));
				double pArea = Double.parseDouble(request.getParameter("area"));
				
				Pais pais = new Pais();
				pais.setNome(pNome);
				pais.setPopulacao(pPopulacao);
				pais.setArea(pArea);
				
				
				pais.setId(service.inserir(pais));
				pais = service.carregar(pais.getId());
				
				//enviar para o jsp
				request.setAttribute("pais", pais);
		        
		        RequestDispatcher view = 
		        request.getRequestDispatcher("Pais.jsp");
		        view.forward(request, response);
			}else if(request.getParameter("acao").equals("Listar"))
			{
				ArrayList<Pais> paises = service.carregarTodos();
				Pais pais = new Pais();
				request.setAttribute("pais", pais);
				request.setAttribute("paises", paises);
				
				RequestDispatcher view = 
				request.getRequestDispatcher("Lista.jsp");
		 		view.forward(request, response);
			}else if(request.getParameter("acao").equals("100k"))
			{
				ArrayList<Pais> paises = service.carregarTodos();
				Pais pais = new Pais();
				request.setAttribute("pais", pais);
				request.setAttribute("paises", paises);
				
				RequestDispatcher view = 
				request.getRequestDispatcher("Paises100k.jsp");
		 		view.forward(request, response);
			}else if(request.getParameter("acao").equals("excluir"))
			{
				int id = Integer.parseInt(request.getParameter("idPais"));
				service.excluir(id);
				//
				RequestDispatcher view = 
				request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			}else if(request.getParameter("acao").equals("alterar"))
			{
				int pId = Integer.parseInt(request.getParameter("idAlterar"));
				String pNome = request.getParameter("nomeAlterar");
				long pPopulacao = Long.parseLong(request.getParameter("populacaoAlterar"));
				double pArea = Double.parseDouble(request.getParameter("areaAlterar"));
				
				Pais paisAlterar = new Pais(pId,pNome,pPopulacao,pArea);
				service.atualizar(paisAlterar);
				RequestDispatcher view = 
				request.getRequestDispatcher("index.jsp");
				view.forward(request, response);
			}
	}
}
