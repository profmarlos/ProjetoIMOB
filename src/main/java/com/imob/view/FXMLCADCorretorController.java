package com.imob.view;

import com.imob.model.dao.CorretorDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Corretor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

class FXMLCadCorretorController implements Initializable {

    @FXML
    private TextField textIdCorretor;

    @FXML
    private TextField textCodigoCorretor;

    @FXML
    private TextField textNumeroCreci;

    @FXML
    private TableView<Corretor> tbCorretores;

    @FXML
    private TableColumn<Corretor, Integer> colunaIdCorretor;

    @FXML
    private TableColumn<Corretor, Integer> colunaCodigoCorretor;

    @FXML
    private TableColumn<Corretor, Integer> colunaNumeroCreci;

    private List<Corretor> listCorretores;

    private ObservableList<Corretor> observableCorretores;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final CorretorDAO corretorDAO = new CorretorDAO();

    public void initialize(URL url, ResourceBundle rb) {
        corretorDAO.setConnection(connection);

        carregarCorretoresNaTableView();
        System.out.println("Controlador inicializado");
    }

    public void carregarCorretoresNaTableView() {

        colunaIdCorretor.setCellValueFactory(new PropertyValueFactory<>("idCorretor"));
        colunaCodigoCorretor.setCellValueFactory(new PropertyValueFactory<>("codigoCorretor"));
        colunaNumeroCreci.setCellValueFactory(new PropertyValueFactory<>("numeroCreci"));

        listCorretores = corretorDAO.listar();

        observableCorretores = FXCollections.observableArrayList(listCorretores);

        tbCorretores.setItems(observableCorretores);
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {

            //textIdCorretor.setCache(String.valueOf(colunaIdCorretor.getSelectionModel().getSelectedItem().getId_Corretor()));
            //textCodigoCorretor.setText(String.valueOf(colunaCodigoCorretor.getSelectionModel().getSelectedItem().getCodigo_Corretor()));
            //textNumeroCreci.setText(String.valueOf(colunaNumeroCreci.getSelectionModel().getSelectedItem().getNumero_Creci()));
        }


    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        Corretor corretor = new Corretor();
        corretor.setId_Corretor(Integer.parseInt(textIdCorretor.getText()));
        corretor.setId_Codigo_Corretor(Integer.parseInt(textCodigoCorretor.getText()));
        corretor.setNumero_Creci(Integer.parseInt(textNumeroCreci.getText()));

        corretorDAO.inserir(corretor);

        limparCampos();
        carregarCorretoresNaTableView();
    }

    @FXML
    private void deletarInformacoesNoBanco(ActionEvent event) {
        Corretor corretor = new Corretor();

        corretor.setId_Corretor(Integer.parseInt(textIdCorretor.getText()));

            corretorDAO.remover(corretor);
            limparCampos();
            carregarCorretoresNaTableView();
        }


    @FXML
    private void atualizarInformacoesNoBanco(ActionEvent event) {
        Corretor corretor = new Corretor();

        corretor.setId_Corretor(Integer.parseInt(textIdCorretor.getText()));
        corretor.setId_Codigo_Corretor(Integer.parseInt(textCodigoCorretor.getText()));
        corretor.setNumero_Creci(Integer.parseInt(textNumeroCreci.getText()));

            corretorDAO.atualizar(corretor);

            limparCampos();
            carregarCorretoresNaTableView();
        }


    private void limparCampos() {
        textIdCorretor.clear();
        textCodigoCorretor.clear();
        textNumeroCreci.clear();
    }

    @FXML
    private void fecharTela(ActionEvent event) {
        Stage stage = (Stage) textIdCorretor.getScene().getWindow();
        stage.close();
    }
}
