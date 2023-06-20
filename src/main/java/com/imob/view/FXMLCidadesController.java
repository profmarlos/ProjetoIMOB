package com.imob.view;

import com.imob.model.dao.CidadesDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Cidades;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author
 */
public class FXMLCidadesController implements Initializable {

    @FXML
    private Label lblFecharCidades;
    @FXML
    private TextField IdCodCidade;
    @FXML
    private TextField IdCidade;
    @FXML
    private TextField IdSigla;
    @FXML
    private TableView<Cidades> IdTabela;
    @FXML
    private TableColumn<Cidades, Integer> TableCodCidade;
    @FXML
    private TableColumn<Cidades, String> Tablecidade;
    @FXML
    private TableColumn<Cidades, Integer> colunaSiglaEstado;
    @FXML
    private Button B_Insert;
    @FXML
    private Button BAtualizar;
    @FXML
    private Button BLimpar;
    @FXML
    private Button BDeletar;
    @FXML
    private AnchorPane Anc_cidades;

    private List<Cidades> listCidades;
    //jogar  na ViemTable com o ObservableList, é necessário usar
    private ObservableList<Cidades> observableCidades;

    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    //private final CidadesDAO cidadeDAO = new CidadesDAO;
    private final CidadesDAO cidadesDAO = new CidadesDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cidadesDAO.setConnection(connection);

        carregaCidadesNaTableView();
    }
    public void carregaCidadesNaTableView()
    {

        TableCodCidade.setCellValueFactory(new PropertyValueFactory<>("id_Cidades"));
        Tablecidade.setCellValueFactory(new PropertyValueFactory<>("nome_Cidades"));
        colunaSiglaEstado.setCellValueFactory(new PropertyValueFactory<>("tb_estados_id_Estados"));

        listCidades = cidadesDAO.buscarTodasCidades();

        observableCidades = FXCollections.observableArrayList(listCidades);
        IdTabela.setItems(observableCidades);
    }


    @FXML
    private void fecharCidade(MouseEvent event) {

        Stage st = (Stage) lblFecharCidades.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event){
        Cidades cidades = new Cidades();
        cidades.setNome_Cidades(IdCidade.getText());
        cidades.setId_Cidades(Integer.parseInt(IdCodCidade.getText()));
        cidades.setId_Estado(Integer.parseInt(IdSigla.getText()));
        cidadesDAO.inserirCidades(cidades);
        limparCampos();
        carregaCidadesNaTableView();
    }
    @FXML
    public void limparCampos()
    {
        IdCodCidade.setText("");
        IdCidade.setText("");
        IdSigla.setText("");
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {
        IdCodCidade.setText(String.valueOf(IdTabela.getSelectionModel().getSelectedItem().getId_Cidades()));
        IdCidade.setText(IdTabela.getSelectionModel().getSelectedItem().getNome_Cidades());
        IdSigla.setText(String.valueOf(IdTabela.getSelectionModel().getSelectedItem().getId_Estado()));
    }
    @FXML
    private void deletarDadosSelecionados(ActionEvent event){
        Cidades cidade = new Cidades();
        cidade.setId_Cidades(Integer.parseInt(IdCodCidade.getText()));
        cidadesDAO.excluirCidade(cidade);
        limparCampos();
        carregaCidadesNaTableView();
    }
    @FXML
    private void atualizarDadosSelecionados(ActionEvent event){
        Cidades cidade = new Cidades();
        cidade.setNome_Cidades(IdCidade.getText());
        cidade.setId_Estado(Integer.parseInt(IdSigla.getText()));
        cidade.setId_Cidades(Integer.parseInt(IdCodCidade.getText()));
        cidadesDAO.atualizarCidades(cidade);
        limparCampos();
        carregaCidadesNaTableView();
    }

}


    /*
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    @FXML
    private Label lblFecharcidade;
    private CidadesDAO cidadeDAO = new CidadesDAO(connection);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cidadeDAO.setConnection(connection);
    }

    @FXML
    private void fecharCidade(MouseEvent event) {

        Stage st = (Stage) lblFecharcidade.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }



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
    @FXML
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
    @FXML
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
    @FXML
    // Método para excluir uma cidade
    public void excluirCidades(int id_Cidades) {
        try {
            cidadeDAO.excluirCidade(id_Cidades);
            System.out.println("Cidade excluída com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao excluir cidade: " + e.getMessage());
        }
    }
    @FXML
    // Método para buscar todas as cidades
    public List<Cidades> buscarTodasCidades() {
        try {
            return cidadeDAO.buscarTodasCidades();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar cidades: " + e.getMessage());
            return null;
        }
    }

}*/
