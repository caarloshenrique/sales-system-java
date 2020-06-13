package vendas;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import vendas.cliente.ClienteUI;

public class Main {
    public static void main(String[] args) throws SQLException {
        try{
            Connection con = AuxiliarBD.criarConexao();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ClienteUI(con).setVisible(true);
                }
            });
        } catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao conectar com o banco de dados",
                    "Erro", JOptionPane.ERROR_MESSAGE);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
