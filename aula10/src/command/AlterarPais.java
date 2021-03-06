package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Pais;
import service.PaisService;

public class AlterarPais implements Command 
{
	@Override
	public void executar(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
	{
		String pId = request.getParameter("id");
		String pNome = request.getParameter("nome");
		String pPopulacao = request.getParameter("populacao");
		String pArea = request.getParameter("area");
		int id = -1;
		long populacao = -1;
		double area = -1;
		try 
		{
			id = Integer.parseInt(pId);
			populacao = Long.parseLong(pPopulacao);
			area = Double.parseDouble(pArea);
		} catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		
		Pais pais = new Pais(id,pNome,populacao,area);		
		PaisService service = new PaisService();
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		service.atualizar(pais);
		@SuppressWarnings("unchecked")
		ArrayList<Pais> paises = (ArrayList<Pais>) session.getAttribute("paises");
		int pos = busca(pais, paises);
		paises.remove(pos);
		paises.add(pos, pais);
		session.setAttribute("paises", paises);
		request.setAttribute("pais", pais);
		view = request.getRequestDispatcher("VisualizarPais.jsp");
		view.forward(request, response);
	}

	public int busca(Pais pais, ArrayList<Pais> paises) 
	{
		Pais pais1;
		for (int i = 0; i < paises.size(); i++)
		{
			pais1 = paises.get(i);
			if (pais1.getId() == pais.getId())
			{
				return i;
			}
		}
		return -1;
	}
}