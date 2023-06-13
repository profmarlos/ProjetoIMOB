package com.imob.view;

import com.imob.model.dao.ImoveisRuraisDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.ImovelRural;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;
/*
public class FXMLCadImoveisRuraisController {

    @FXML
    private TextField txtNumeroITR;

    @FXML
    private TableColumn<ImovelRural, String> colunaNumeroITR;
    @FXML
    private TableColumn<ImovelRural, String> colunaNumeroIncra;

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
    }

    public void carregaImoveisRuraisNaTableView() {
        colunaNumeroITR.setCellValueFactory(new PropertyValueFactory<>("numero_Itr"));
        colunaNumeroIncra.setCellValueFactory(new PropertyValueFactory<>("numero_Incra"));
        observableImoveisRurais = FXCollections.observableArrayList(listImoveisRurais);
        tbImoveisRurais.setItems(observableImoveisRurais);
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {

        txtNumeroITR.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getNumeto_Itr()));
    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        ImovelRural imovelRural = new ImovelRural();

        ImovelRural.setNumeto_Itr(txtNumeroITR.getText());


        imoveisRuraisDAO.inserir(imovelRural);

        limparCampos();
        carregaImoveisRuraisNaTableView();
    }

    @FXML
    private void deletarDadosSelecionados(ActionEvent event) {
        ImovelRural imovelRural = new ImovelRural();

        ImovelRural.setNumeto_Itr(Integer.parseInt(txtNumeroITR.getText()));


        imoveisRuraisDAO.remover(imovelRural);


        limparCampos();

        carregaImoveisRuraisNaTableView();
    }

    @FXML
    private void atualizarDadosSelecionados(ActionEvent event) {

        ImovelRural imovelRural = new ImovelRural();

        ImovelRural.setNumeto_Itr(txtNumeroITR.getText());

        imoveisRuraisDAO.alterar(imovelRural);


        limparCampos();

        carregaImoveisRuraisNaTableView();
    }

    public void limparCampos() {
        txtNumeroITR.setText("");

    }

}
 */
