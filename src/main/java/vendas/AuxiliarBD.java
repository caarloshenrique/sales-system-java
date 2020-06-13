package vendas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AuxiliarBD {
    public static final String URL = "jdbc:postgresql:vendas";
    public static final String USUARIO = "postgres";
    public static final String SENHA = "root";
    
    public static Connection criarConexao() throws SQLException {
        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
