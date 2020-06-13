package vendas.cliente;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ClienteReports {
    public static void mostrarRelatorioGeral(List<Cliente> clientes) throws Exception {
        // obtêm o relatório
        InputStream template = ClienteReports.class.getResourceAsStream("/cliente.jrxml");
        JasperReport relatorio = JasperCompileManager.compileReport(template);

        // parâmetros para geração (vazio)
        Map<String, Object> parametros = new HashMap<>();

        // conteúdo
        JRBeanCollectionDataSource dados = new JRBeanCollectionDataSource(clientes);
        System.out.println(dados);
        // preenche o relatório com os dados
        JasperPrint preenchido = JasperFillManager.fillReport(relatorio, parametros, dados);
        

        // mostra o relatório preenchido na tela
        JasperViewer visualizador = new JasperViewer(preenchido, false);
        visualizador.setVisible(true);
    }
}
