package dao;

import model.Pais;
import factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PaisDAO
{
   //insert
	public int inserir(Pais pais)
	{
		String sqlInsert = "insert into pais(nome, populacao, area) values(?,?,?)";
		String sqlQuery = "select last_insert_id()";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);)
		{
			stm.setString(1,pais.getNome());
			stm.setLong(2,pais.getPopulacao());
			stm.setDouble(3,pais.getArea());
			stm.execute();
         try(PreparedStatement stm2 = conn.prepareStatement(sqlQuery);
            ResultSet rs = stm2.executeQuery();)
         {
            if(rs.next())
            {
               pais.setId(rs.getInt(1));
            }
         }catch(Exception e)
         {
            e.printStackTrace();
         }
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
      return pais.getId();
	}
   //delete
	public void excluir(int id)
	{
		String sqlDelete = "delete from pais where id = ?";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlDelete);)
		{
			stm.setInt(1,id);
			stm.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
   //update
	public void atualizar(Pais pais)
	{
		String sqlUpdate = "update pais set nome = ?, populacao = ?, area = ? where id = ?";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);)
		{
			stm.setString(1,pais.getNome());
			stm.setLong(2,pais.getPopulacao());
			stm.setDouble(3,pais.getArea());
			stm.setInt(4,pais.getId());
			stm.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
   //select
	public Pais carregar(int id)
	{
      Pais pais = new Pais(id);
		String sqlSelect = "select nome, populacao, area from pais where id = ?";
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
         stm.setInt(1,pais.getId());
			try(ResultSet rs = stm.executeQuery();)
			{
				if(rs.next())
				{
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				}else
				{
					pais.setId(-1);
					pais.setNome(null);
					pais.setPopulacao(-1);
					pais.setArea(-1);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
      return pais;
	}
   //maiorPopulacao
   public Pais maiorPopulacao()
	{
		String sqlSelect = "select * from pais where populacao = (select max(populacao) from pais)";
		Pais pais = new Pais();
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			try(ResultSet rs = stm.executeQuery())
			{
				if(rs.next())
				{
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
		return pais;
	}
   //menorArea
	public Pais menorArea()
	{
		String sqlSelect = "select * from pais where area = (select min(area) from pais)";
		Pais pais = new Pais();
		try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
			try(ResultSet rs = stm.executeQuery())
			{
				if(rs.next())
				{
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
		return pais;
	}
   //vetorTresPaises
	public String[] vetorTresPaises()
	{
	    String[] vetor = new String[3];
       int i = 0;
	    String sqlSelect = "select * from pais";
	    try(Connection conn = ConnectionFactory.conexao();
	     		PreparedStatement stm = conn.prepareStatement(sqlSelect);)
	    {
	        try(ResultSet rs = stm.executeQuery();)
	        {
         	  while(rs.next() && i < vetor.length)
        		  {  
					  Pais pais = new Pais();
        			  pais.setId(rs.getInt("id"));
           	  	  pais.setNome(rs.getString("nome"));
           		  pais.setPopulacao(rs.getLong("populacao"));
           		  pais.setArea(rs.getDouble("area"));
           	     vetor[i] = pais.toString();
                 i++;
           	  }
            }catch(SQLException e)
              {
                 e.printStackTrace();
              }
        }catch(SQLException e1)
        {
           System.out.println(e1.getStackTrace());
        }              
     return vetor;
	}
	public ArrayList<Pais> carregarTodos()
	{
      ArrayList<Pais> paises = new ArrayList<>();
      String sqlSelect = "select * from pais";
      try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
         stm.execute();
			try(ResultSet rs = stm.executeQuery();)
			{
				while(rs.next())
				{
					Pais pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					paises.add(pais);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
      return paises;
	}
	public ArrayList<Pais> paises100k()
	{
      ArrayList<Pais> paises = new ArrayList<>();
      String sqlSelect = "select * from pais where populacao > 100000";
      try(Connection conn = ConnectionFactory.conexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);)
		{
         stm.execute();
			try(ResultSet rs = stm.executeQuery();)
			{
				while(rs.next())
				{
					Pais pais = new Pais();
					pais.setId(rs.getInt("id"));
					pais.setNome(rs.getString("nome"));
					pais.setPopulacao(rs.getLong("populacao"));
					pais.setArea(rs.getDouble("area"));
					paises.add(pais);
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}catch(SQLException e1)
		{
			System.out.println(e1.getStackTrace());
		}
      return paises;
	}
}