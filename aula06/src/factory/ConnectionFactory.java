package factory;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory
{
   //conexao com driver jdbc
	static
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e)
		{
			throw new RuntimeException(e);
		}
	}
   //abrir conexao com banco de dados
	public static Connection conexao() throws SQLException
	{
		return DriverManager.getConnection("jdbc:mysql://localhost/aula06?user=alunos&password=alunos");
	}
}