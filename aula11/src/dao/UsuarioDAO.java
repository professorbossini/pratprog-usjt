package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConnectionFactory;
import model.Usuario;

public class UsuarioDAO 
{
	public boolean validar(Usuario usuario) 
	{
		String sqlSelect = "SELECT username, password FROM usuario WHERE username = ? and password = ?";
		try(Connection conn = ConnectionFactory.conexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) 
		{
			stm.setString(1, usuario.getUsername());
			stm.setString(2, usuario.getPassword());
			try (ResultSet rs = stm.executeQuery();) 
			{
				if(rs.next()) 
				{
					return true;
				} else 
				{
					return false;
				}
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} catch (SQLException e1) 
		{
			e1.printStackTrace();
		}
		return false;
	}
}
