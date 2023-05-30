package com.imob.view;

//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import com.imob.model.dao.EstadosDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Bairro;
import com.imob.model.domain.Estados;

/**
 * FXML Controller class
 *
 * @author
 */
public class FXMLCadEstadosController implements Initializable {

    /*
    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private Label lblFecharCadastro;
    @FXML
    private JFXTextField txtCodigoEstado;
    @FXML
    private JFXTextField txtNomeEstado;
    @FXML
    private JFXTextField txtSiglaEstado;
    @FXML
    private TableView<Estados> tbEstados;
    @FXML
    private JFXButton btnLimpar;
    @FXML
    private JFXButton btnSalvar;
    @FXML
    private TableColumn<Estados, Integer> colunaCodigoEstado;
    @FXML
    private TableColumn<Estados, String> colunaNomeEstado;
    @FXML
    private TableColumn<Estados, String> colunaSiglaEstado;
    @FXML
    private JFXButton btnDeletar;
    @FXML
    private JFXButton btnAtualizar;
    
    //buscar os dados do banco de dados com um List
    private List<Estados> listEstados;
    //jogar  na ViemTable com o ObservableList, é necessário usar
    private ObservableList<Estados> observableEstados;
    */
    //Atributos para manipulação de Banco de Dados
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final EstadosDAO estadosDAO = new EstadosDAO();




    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //conexão com o banco de dados
        estadosDAO.setConnection(connection);
        
        //carregaEstadosNaTableView();
    } 
    /*
    //método para poder trabalhar com os Estados no banco
    public void carregaEstadosNaTableView()
    {
        colunaCodigoEstado.setCellValueFactory(new PropertyValueFactory<>("id_Estado"));
        colunaNomeEstado.setCellValueFactory(new PropertyValueFactory<>("nome_Estado"));
        colunaSiglaEstado.setCellValueFactory(new PropertyValueFactory<>("sigla_Estado"));
        
        listEstados = estadosDAO.lista();
        
        observableEstados = FXCollections.observableArrayList(listEstados);
        tbEstados.setItems(observableEstados);
    }

        @FXML
        private void fecharCadastro(MouseEvent event) {
        
        Stage st = (Stage) lblFecharCadastro.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }

        private void limparCampos(ActionEvent event) {
        limparCampos();
    }

        @FXML
        private void inserirDaddosNoBancoDados(ActionEvent event) {
        Estados estados = new Estados();
        
        estados.setNome_Estado(txtNomeEstado.getText());
        estados.setSigla_Estado(txtSiglaEstado.getText());
        
        estadosDAO.inserir(estados);
        
        
        limparCampos();
        
        carregaEstadosNaTableView();
    }
    
    public void limparCampos()
    {
        txtCodigoEstado.setText("");
        txtNomeEstado.setText("");
        txtSiglaEstado.setText("");
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {
        
        txtCodigoEstado.setText(String.valueOf(tbEstados.getSelectionModel().getSelectedItem().getId_Estado()));
        txtNomeEstado.setText(tbEstados.getSelectionModel().getSelectedItem().getNome_Estado());
        txtSiglaEstado.setText(tbEstados.getSelectionModel().getSelectedItem().getSigla_Estado());
        
    }

    @FXML
    private void deletarDadosSelecionados(ActionEvent event) {
        Estados estados = new Estados();
        
        estados.setId_Estado(Integer.parseInt(txtCodigoEstado.getText()));
        
        
        estadosDAO.remover(estados);
        
        
        limparCampos();
        
        carregaEstadosNaTableView();
    }

    @FXML
    private void atualizarDadosSelecionados(ActionEvent event) {
        
        Estados estados = new Estados();
        
        estados.setNome_Estado(txtNomeEstado.getText());
        estados.setSigla_Estado(txtSiglaEstado.getText());
        estados.setId_Estado(Integer.parseInt(txtCodigoEstado.getText()));
        
        
        estadosDAO.alterar(estados);
        
        
        limparCampos();
        
        carregaEstadosNaTableView();
    }


     */
}
