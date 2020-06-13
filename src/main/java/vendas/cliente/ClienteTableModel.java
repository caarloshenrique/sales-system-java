package vendas.cliente;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ClienteTableModel extends AbstractTableModel {
    
    private List<Cliente> data;
    
    public ClienteTableModel() {
        data = new ArrayList<>();
    }

    public void setData(List<Cliente> data) {
        this.data = data;
        fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        Cliente c = data.get(linha);
        
        switch(coluna) {
            case 0:
                return c.getId();
            case 1:
                return c.getNome();
            case 2:
                return c.getEmail();
            case 3:
                return c.getTelefone();
            case 4:
                return c.getEndereco();
            default:
                throw new IllegalArgumentException("Coluna inválida");
        }
    }

    @Override
    public String getColumnName(int coluna) {
        switch(coluna) {
            case 0:
                return "ID";
            case 1:
                return "Nome";
            case 2:
                return "E-mail";
            case 3:
                return "Telefone";
            case 4:
                return "Endereço";
            default:
                throw new IllegalArgumentException("Coluna inválida");
        }
    }
    
}

