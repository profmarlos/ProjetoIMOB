package com.imob.view;

import com.imob.model.dao.ImoveisRuraisDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Estados;
import com.imob.model.domain.ImovelRural;
import eu.hansolo.toolbox.unit.Converter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLCadImoveisRuraisController implements Initializable {

    @FXML
    private TextField txtNumeroITR;

    @FXML
    private TextField txtNumeroIncra;

    @FXML
    private TextField txtImovelGeralIdImovel;
    @FXML
    private TextField txtIdImovel;

    @FXML
    private TableColumn<ImovelRural, String> colunaNumeroITR;
    @FXML
    private TableColumn<ImovelRural, String> colunaNumeroIncra;

    @FXML
    private TableColumn<ImovelRural, String> colunaImovelGeralIDImovel;
    @FXML
    private TableColumn<ImovelRural, String> colunaIdImovel;

    @FXML
    private TableView<ImovelRural> tbImoveisRurais;

    private List<ImovelRural> listImoveisRurais;

    private ObservableList<ImovelRural> observableImoveisRurais;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ImoveisRuraisDAO imoveisRuraisDAO = new ImoveisRuraisDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //conexão com o banco de dados
        imoveisRuraisDAO.setConnection(connection);

        carregaImoveisRuraisNaTableView();
        System.out.println("Controlador inicializado");
    }

    public void carregaImoveisRuraisNaTableView() {
        colunaNumeroITR.setCellValueFactory(new PropertyValueFactory<>("numeto_Itr"));
        colunaNumeroIncra.setCellValueFactory(new PropertyValueFactory<>("numero_Incra"));
        colunaImovelGeralIDImovel.setCellValueFactory(new PropertyValueFactory<>("id_imovel_geral"));
        colunaIdImovel.setCellValueFactory(new PropertyValueFactory<>("id_Imovel_R"));


        listImoveisRurais = imoveisRuraisDAO.lista();

        observableImoveisRurais = FXCollections.observableArrayList(listImoveisRurais);

        tbImoveisRurais.setItems(observableImoveisRurais);
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {

        txtNumeroITR.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getNumeto_Itr()));
        txtNumeroIncra.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getNumero_Incra()));
        txtImovelGeralIdImovel.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getId_imovel_geral()));
        txtIdImovel.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getId_Imovel_R()));

        //txtCodigoEstado.setText(String.valueOf(tbEstados.getSelectionModel().getSelectedItem().getId_Estado()));
        //txtNomeEstado.setText(tbEstados.getSelectionModel().getSelectedItem().getNome_Estado());
        //txtSiglaEstado.setText(tbEstados.getSelectionModel().getSelectedItem().getSigla_Estado());
    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        ImovelRural imovelRural = new ImovelRural();

        imovelRural.setNumeto_Itr(txtNumeroITR.getText());
        imovelRural.setNumero_Incra((txtNumeroIncra.getText()));
        imovelRural.setId_Imovel_R(Integer.parseInt(txtImovelGeralIdImovel.getText()));

        imoveisRuraisDAO.inserir(imovelRural);

        limparCampos();
        carregaImoveisRuraisNaTableView();
    }

    @FXML
    private void deletarInformacoesNoBanco(ActionEvent event) {
        ImovelRural imovelRural = new ImovelRural();

        imovelRural.setId_Imovel_R(Integer.parseInt(txtIdImovel.getText()));

        imoveisRuraisDAO.remover(imovelRural);


        limparCampos();

        carregaImoveisRuraisNaTableView();
    }

    @FXML
    private void atualizarDadosNoBanco(ActionEvent event) {

        ImovelRural imovelRural = new ImovelRural();

        imovelRural.setId_Imovel_R(Integer.parseInt(txtIdImovel.getText()));
        imovelRural.setNumeto_Itr(txtNumeroITR.getText());
        imovelRural.setNumero_Incra(txtNumeroIncra.getText());

        imoveisRuraisDAO.alterar(imovelRural);

        limparCampos();

        carregaImoveisRuraisNaTableView();
    }

    public void limparCampos() {
        txtNumeroITR.setText("");
        txtNumeroIncra.setText("");
        txtImovelGeralIdImovel.setText("");
        txtIdImovel.setText("");

    }


}

