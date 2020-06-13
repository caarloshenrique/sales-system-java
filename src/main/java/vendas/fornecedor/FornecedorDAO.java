package vendas.fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO {
        private Connection con;

    public FornecedorDAO(Connection con) {
        this.con = con;
    }
    
    public Fornecedor buscarPorId(int id) throws SQLException {
        String SQL = "SELECT id, nome, email, ativo, observacoes "
                + "FROM fornecedor WHERE id = ?";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            
            if(rs.next()) {
                Fornecedor fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getBoolean("ativo"),
                        rs.getString("observacoes")
                );
                
                return fornecedor;
            } else {
                return null;
            }
        }
    }
    
    public List<Fornecedor> buscarTodos() throws SQLException {
        String SQL = "SELECT id, nome, email, ativo, observacoes FROM fornecedor";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            ResultSet rs = st.executeQuery();
            List<Fornecedor> listaFornecedores = new ArrayList<>(); 
            
            while(rs.next()) {
                Fornecedor fornecedor = new Fornecedor(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("email"),
                        rs.getBoolean("ativo"),
                        rs.getString("observacoes")
                );
                
                listaFornecedores.add(fornecedor);
            }
            
            return listaFornecedores;
        }
    }
    
    public void inserir(Fornecedor fornecedor) throws SQLException {
        String SQL = "INSERT INTO fornecedor(nome, email, ativo, observacoes) "
                + "VALUES (?, ?, ?, ?) RETURNING id";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setString(1, fornecedor.getNome());
            st.setString(2, fornecedor.getEmail());
            st.setBoolean(3, fornecedor.isAtivo());
            st.setString(4, fornecedor.getObservacoes());
            
            ResultSet rs = st.executeQuery();
            rs.next();
            fornecedor.setId(rs.getInt("id"));
        }
    }
    
    public void editar(Fornecedor fornecedor) throws SQLException {
        String SQL = "UPDATE fornecedor SET nome = ?, email = ?, ativo = ?, "
                + "observacoes = ? WHERE id = ?";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setString(1, fornecedor.getNome());
            st.setString(2, fornecedor.getEmail());
            st.setBoolean(3, fornecedor.isAtivo());
            st.setString(4, fornecedor.getObservacoes());
            st.setInt(5, fornecedor.getId());
            st.executeUpdate();
        }
    }
    
    public void remover(Fornecedor fornecedor) throws SQLException {
        String SQL = "DELETE FROM fornecedor WHERE id = ?";
        
        try(PreparedStatement st = con.prepareStatement(SQL)) {
            st.setInt(1, fornecedor.getId());
            st.executeUpdate();
        }
    }
}
