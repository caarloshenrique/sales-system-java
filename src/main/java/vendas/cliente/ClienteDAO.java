package vendas.cliente;

import vendas.cliente.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    private Connection con;

    public ClienteDAO(Connection con) {
        this.con = con;
    }
    
    public Cliente buscarPorId(int id) throws SQLException {
        String SQL = "SELECT id, nome, email, endereco, telefone "
                + "FROM cliente WHERE id = ?";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                );
                
                return cliente;
            } else {
                return null;
            }
        }
    }
    
    public List<Cliente> buscarTodos() throws SQLException {
        String SQL = "SELECT id, nome, email, endereco, telefone FROM cliente";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            ResultSet rs = st.executeQuery();
            List<Cliente> listaClientes = new ArrayList<>(); 
            
            while(rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getString("telefone"),
                        rs.getString("endereco")
                );
                
                listaClientes.add(cliente);
            }
            
            return listaClientes;
        }
    }
    
    public void inserir(Cliente cliente) throws SQLException {
        String SQL = "INSERT INTO cliente(nome, email, telefone, endereco) "
                + "VALUES (?, ?, ?, ?) RETURNING id";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getEmail());
            st.setString(3, cliente.getTelefone());
            st.setString(4, cliente.getEndereco());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            cliente.setId(rs.getInt("id"));
        }
    }
    
    public void editar(Cliente cliente) throws SQLException {
        String SQL = "UPDATE cliente SET nome = ?, email = ?, telefone = ?, "
                + "endereco = ? WHERE id = ?";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setString(1, cliente.getNome());
            st.setString(2, cliente.getEmail());
            st.setString(3, cliente.getTelefone());
            st.setString(4, cliente.getEndereco());
            st.setInt(5, cliente.getId());
            st.executeUpdate();
        }
    }
    
    public void remover(Cliente cliente) throws SQLException {
        String SQL = "DELETE FROM cliente WHERE id = ?";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setInt(1, cliente.getId());
            st.executeUpdate();
        }
    }
}
