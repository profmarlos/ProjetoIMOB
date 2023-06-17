package com.imob.view;

import com.imob.model.dao.CidadesDAO;
import com.imob.model.domain.Cidades;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
/**
 * FXML Controller class
 *
 * @author
 */
public class FXMLCidadesController implements Initializable {

    private CidadesDAO cidadeDAO;

    // Construtor
    public FXMLCidadesController() {
        // Configurar conexão com o banco de dados
        String url = "jdbc:mysql://localhost:3306/bd_imob";
        String username = "seu_usuario";
        String password = "sua_senha";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            cidadeDAO = new CidadesDAO(connection);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }

    // Método para adicionar uma nova cidade
    public void adicionarCidades(int id_Cidades, String nome_Cidades, int id_Estado) {
        Cidades cidade = new Cidades(id_Cidades, nome_Cidades, id_Estado);

        try {
            cidadeDAO.inserirCidades(cidade);
            System.out.println("Cidade adicionada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar cidade: " + e.getMessage());
        }
    }

    // Método para atualizar uma cidade existente
    public void atualizarCidades(int id_Cidades, String nome_Cidades, int id_Estado) {
        Cidades cidade = new Cidades(id_Cidades, nome_Cidades, id_Estado);

        try {
            cidadeDAO.atualizarCidades(cidade);
            System.out.println("Cidade atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar cidade: " + e.getMessage());
        }
    }

    // Método para excluir uma cidade
    public void excluirCidades(int id_Cidades) {
        try {
            cidadeDAO.excluirCidade(id_Cidades);
            System.out.println("Cidade excluída com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cidade: " + e.getMessage());
        }
    }

    // Método para buscar todas as cidades
    public List<Cidades> buscarTodasCidades() {
        try {
            return cidadeDAO.buscarTodasCidades();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cidades: " + e.getMessage());
            return null;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
