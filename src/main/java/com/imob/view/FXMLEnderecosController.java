package com.imob.view;

import com.imob.model.dao.LogradourosDAO;
import com.imob.model.dao.CidadesDAO;
import com.imob.model.domain.Enderecos;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLEnderecosController implements Initializable {

    @FXML
    private Label lbfecharlogradouro;
    @FXML
    private TextField txfid;
    @FXML
    private ComboBox cbTipo;
    @FXML
    private TextField txflogradouro;
    @FXML
    private TextField txfnumero_log;
    @FXML
    private TextField txfnumero_ap;
    @FXML
    private TextField txfandar_ap;
    @FXML
    private TextField txfbloco_ap;
    @FXML
    private TextField txfcomplemento;
    @FXML
    private TextField txfcep;
    @FXML
    private TextField txflatitute;
    @FXML
    private TextField txflongitute;
    @FXML
    private TextField txfreferencia;
    @FXML
    private Button btninserir;
    @FXML
    private Button btndeletar;
    @FXML
    private Button btnalterar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnlimpar;
    @FXML
    private TableView<Enderecos> IdLogradouro;
    @FXML
    private TableColumn<Enderecos, Integer> colunaID;
    @FXML
    private TableColumn<Enderecos, String> colunaTipo;
    @FXML
    private TableColumn<Enderecos, String> colunaLogradouro;
    @FXML
    private TableColumn<Enderecos, Integer> colunaNumeroLog;
    @FXML
    private TableColumn<Enderecos, String> colunaNumeroAp;
    @FXML
    private TableColumn<Enderecos, String> colunaAndarAp;
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private List<Enderecos> listLogradouros;
    private ObservableList<Enderecos> observableLogradouros;
    private final LogradourosDAO logradourosDAO = new LogradourosDAO();
    private final CidadesDAO cidadesDAO = new CidadesDAO();

    public void initialize(URL url, ResourceBundle rb) {

        //conexão com o banco de dados
        logradourosDAO.setConnection(connection);

        carregaLogradouroNaTableView();
        cbTipo.getItems().clear();
        cbTipo.getItems().addAll("Casa", "Sobrado", "Apartamento", "Condominio");
        cbTipo.getSelectionModel().select("Casa");


        System.out.println("Controlador inicializado");
    }
    @FXML
    private void lbFecharLogradouro(MouseEvent event)
    {
        Stage st = (Stage) lbfecharlogradouro.getScene().getWindow();  // obtem a janela atual
        st.close();  //fecha a stage
    }
    @FXML
    private void cbTipoModificado(ActionEvent event) {
        if (cbTipo.getSelectionModel().getSelectedItem() == "Apartamento" || cbTipo.getSelectionModel().getSelectedItem() == "Condominio") {
            txfnumero_ap.setDisable(false);
            txfandar_ap.setDisable(false);
            txfbloco_ap.setDisable(false);
        } else {
            txfnumero_ap.setDisable(true);
            txfandar_ap.setDisable(true);
            txfbloco_ap.setDisable(true);
        }
    }

    @FXML
    private void cancelarAlteracao(ActionEvent event)
    {
        cancelarAlter();
    }

    private void cancelarAlter()
    {
        limparCampos();
        btnalterar.setVisible(false);
        btnCancelar.setVisible(false);
        btninserir.setVisible(true);
        btnlimpar.setVisible(true);
        btndeletar.setVisible(false);
    }

    private void carregaLogradouroNaTableView() {
        colunaID.setCellValueFactory(new PropertyValueFactory<>("id_Endereco"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo_Logradouro"));
        colunaLogradouro.setCellValueFactory(new PropertyValueFactory<>("logradouro"));
        colunaNumeroLog.setCellValueFactory(new PropertyValueFactory<>("numero_logradouro"));
        colunaNumeroAp.setCellValueFactory(new PropertyValueFactory<>("numero_apartamento"));
        colunaAndarAp.setCellValueFactory(new PropertyValueFactory<>("andar_apartamento"));

        listLogradouros = logradourosDAO.listaLogradouros();

        observableLogradouros = FXCollections.observableArrayList(listLogradouros);
        IdLogradouro.setItems(observableLogradouros);
    }

    public void limparCampos(){
        txfid.setText("");
        cbTipo.getSelectionModel().select("Casa");;
        txflogradouro.setText("");
        txfnumero_log.setText("");
        txfnumero_ap.setText("");
        txfandar_ap.setText("");
        txfbloco_ap.setText("");
        txfcomplemento.setText("");
        txfcep.setText("");
        txflatitute.setText("");
        txflongitute.setText("");
        txfreferencia.setText("");
    }

    @FXML
    private void adicionarDadosSelecionados(ActionEvent event){
        Enderecos logradouros = new Enderecos();
        //logradouros.setId_Endereco(Integer.parseInt(txfid.getText()));
        logradouros.setTipo_Logradouro(cbTipo.getSelectionModel().getSelectedItem().toString());
        logradouros.setLogradouro(txflogradouro.getText());
        logradouros.setNumero_logradouro(txfnumero_log.getText());

        if (cbTipo.getSelectionModel().getSelectedItem() == "Apartamento" || cbTipo.getSelectionModel().getSelectedItem() == "Condominio")
        {
            logradouros.setNumero_apartamento(txfnumero_ap.getText());
            logradouros.setAndar_apartamento(txfandar_ap.getText());
            logradouros.setBloco_apartamento(txfbloco_ap.getText());
        }
        else
        {
            logradouros.setNumero_apartamento("None");
            logradouros.setAndar_apartamento("None");
            logradouros.setBloco_apartamento("None");
        }

        logradouros.setComplemento(txfcomplemento.getText());
        logradouros.setCep(txfcep.getText());
        logradouros.setLatitude(txflatitute.getText());
        logradouros.setLongitude(txflongitute.getText());

        logradouros.setReferencias_endereco(txfreferencia.getText());
        logradouros.setIdBairros(0);
        logradouros.setBairrosIdCidades(0);
        logradouros.setBairrosIdEstados(0);
        logradouros.setIdCidades(0);
        logradouros.setCidadesIdEstados(0);
        logradouros.setIdPessoa(0);


        logradourosDAO.inserirLogradouro(logradouros);
        limparCampos();
        carregaLogradouroNaTableView();
    }

    @FXML
    private void deletarDadosSelecionados(ActionEvent event){
        Enderecos logradouro = new Enderecos();
        logradouro.setId_Endereco(Integer.parseInt(txfid.getText()));
        logradourosDAO.removerLogradouro(logradouro);
        cancelarAlter();
        carregaLogradouroNaTableView();
    }

    @FXML
    private void atualizarDadosSelecionados(ActionEvent event){
        Enderecos logradouros = new Enderecos();
        logradouros.setId_Endereco(Integer.parseInt(txfid.getText()));
        logradouros.setTipo_Logradouro(cbTipo.getSelectionModel().getSelectedItem().toString());
        logradouros.setLogradouro(txflogradouro.getText());
        logradouros.setNumero_logradouro(txfnumero_log.getText());
        if (cbTipo.getSelectionModel().getSelectedItem() == "Apartamento" || cbTipo.getSelectionModel().getSelectedItem() == "Condominio")
        {
            logradouros.setNumero_apartamento(txfnumero_ap.getText());
            logradouros.setAndar_apartamento(txfandar_ap.getText());
            logradouros.setBloco_apartamento(txfbloco_ap.getText());
        }
        else
        {
            logradouros.setNumero_apartamento("None");
            logradouros.setAndar_apartamento("None");
            logradouros.setBloco_apartamento("None");
        }

        logradouros.setComplemento(txfcomplemento.getText());
        logradouros.setCep(txfcep.getText());
        logradouros.setLatitude(txflatitute.getText());
        logradouros.setLongitude(txflongitute.getText());

        logradouros.setReferencias_endereco(txfreferencia.getText());
        logradouros.setIdBairros(0);
        logradouros.setBairrosIdCidades(0);
        logradouros.setBairrosIdEstados(0);
        logradouros.setIdCidades(0);
        logradouros.setCidadesIdEstados(0);
        logradouros.setIdPessoa(0);

        logradourosDAO.alterarLogradouro(logradouros);
        cancelarAlter();
        carregaLogradouroNaTableView();
    }
    @FXML
    private void selecionarLinhaViewTable(MouseEvent event){
        txfid.setText(String.valueOf(IdLogradouro.getSelectionModel().getSelectedItem().getId_Endereco()));
        cbTipo.getSelectionModel().select((IdLogradouro.getSelectionModel().getSelectedItem().getTipo_Logradouro()));
        txflogradouro.setText(String.valueOf(IdLogradouro.getSelectionModel().getSelectedItem().getLogradouro()));
        txfnumero_log.setText(IdLogradouro.getSelectionModel().getSelectedItem().getNumero_logradouro());
        txfnumero_ap.setText(IdLogradouro.getSelectionModel().getSelectedItem().getNumero_apartamento());
        txfandar_ap.setText(IdLogradouro.getSelectionModel().getSelectedItem().getAndar_apartamento());
        txfbloco_ap.setText(IdLogradouro.getSelectionModel().getSelectedItem().getBloco_apartamento());
        txfcomplemento.setText(IdLogradouro.getSelectionModel().getSelectedItem().getComplemento());
        txfcep.setText(IdLogradouro.getSelectionModel().getSelectedItem().getCep());
        txflatitute.setText(IdLogradouro.getSelectionModel().getSelectedItem().getLatitude());
        txflongitute.setText(IdLogradouro.getSelectionModel().getSelectedItem().getLongitude());
        txfreferencia.setText(IdLogradouro.getSelectionModel().getSelectedItem().getReferencias_endereco());

        btninserir.setVisible(false);
        btnlimpar.setVisible(false);
        btndeletar.setVisible(true);
        btnalterar.setVisible(true);
        btnCancelar.setVisible(true);
    }
}
