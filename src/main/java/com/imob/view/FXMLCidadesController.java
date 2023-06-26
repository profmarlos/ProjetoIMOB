package com.imob.view;

import com.imob.model.dao.CidadesDAO;
import com.imob.model.dao.EstadosDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Cidades;
import com.imob.model.domain.Estados;
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

import javax.swing.event.AncestorEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author
 */
public class FXMLCidadesController implements Initializable {

    @FXML
    private ComboBox<Estados> comboBoxEstados;
    @FXML
    private Estados lista;
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
    private List<Estados> estadosLista = new ArrayList<Estados>();
    private List<Cidades> listCidades;
    private ObservableList<Cidades> observableCidades;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final CidadesDAO cidadesDAO = new CidadesDAO();
    private final EstadosDAO estadoDAO = new EstadosDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cidadesDAO.setConnection(connection);
        carregaCidadesNaTableView();
        estadoDAO.setConnection(connection);
        listaEstados();
    }
    public void carregaCidadesNaTableView()
    {

        TableCodCidade.setCellValueFactory(new PropertyValueFactory<>("id_Cidades"));
        Tablecidade.setCellValueFactory(new PropertyValueFactory<>("nome_Cidades"));
        colunaSiglaEstado.setCellValueFactory(new PropertyValueFactory<>("id_Estado"));

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
        cidades.setId_Estado(lista.getId_Estado());
        cidadesDAO.inserirCidades(cidades);
        limparCampos();
        carregaCidadesNaTableView();
    }
    @FXML
    public void limparCampos()
    {
        IdCodCidade.setText("");
        IdCidade.setText("");
        listaEstados();
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {
        IdCodCidade.setText(String.valueOf(IdTabela.getSelectionModel().getSelectedItem().getId_Cidades()));
        IdCidade.setText(IdTabela.getSelectionModel().getSelectedItem().getNome_Cidades());
        int temp = Integer.valueOf(IdTabela.getSelectionModel().getSelectedItem().getId_Estado());
        Estados estados = null;
        for (int i = 0; i < estadosLista.size(); i++) {
            if (temp == estadosLista.get(i).getId_Estado()) {
                estados = estadosLista.get(i);
            }
        }
        //SingleSelectionModel<Estados> galinha;
        comboBoxEstados.getSelectionModel().select(estados);
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
        cidade.setId_Estado(lista.getId_Estado());
        cidade.setId_Cidades(Integer.parseInt(IdCodCidade.getText()));
        cidadesDAO.atualizarCidades(cidade);
        limparCampos();
        carregaCidadesNaTableView();
    }

    @FXML
    protected void listaEstadosCb( ActionEvent event ) {
        //System.out.println("output");
        lista = comboBoxEstados.getValue();
        // System.out.println(lista);
    }

    @FXML
    private void listaEstados() {
        estadosLista = estadoDAO.listarNomeEstado();
        comboBoxEstados.getItems().clear();

        for (Estados e : estadosLista) {
            comboBoxEstados.getItems().add(e);
        }
    }

}
