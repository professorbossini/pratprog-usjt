package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService
{
	PaisDAO dao = new PaisDAO();
   //insert
	public int inserir(Pais pais)
	{
		return dao.inserir(pais);
	}
   //delete
	public void excluir(int id)
	{
		dao.excluir(id);
	}
   //update
	public void atualizar(Pais pais)
	{
		dao.atualizar(pais);
	}
   //select
	public Pais carregar(int id)
	{
		return dao.carregar(id);
	}
   //maiorPopulacao
	public Pais maiorPopulacao()
	{
		return dao.maiorPopulacao();
	}
   //menorArea
	public Pais menorArea()
	{
		return dao.menorArea();
	}
   //vetorTresPaises
	public String[] vetorTresPaises()
	{
		return dao.vetorTresPaises();
	}
	//
	public ArrayList<Pais> carregarTodos()
	{
		return dao.carregarTodos();
	}
	//
	public ArrayList<Pais> paises100k()
	{
		return dao.carregarTodos();
	}
}