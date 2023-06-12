package com.imob.view;

import com.imob.model.dao.EstadosDAO;
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

import java.net.URL;
import java.sql.Connection;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLCadImoveisRuraisController {

    @FXML
    private TextField txtNumeroITRtxtNumeroITR;

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
    private final EstadosDAO estadosDAO = new EstadosDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //conexão com o banco de dados
        estadosDAO.setConnection(connection);

        carregaEstadosNaTableView();
    }

    public void carregaEstadosNaTableView()
    {
        colunaNumeroITR.setCellValueFactory(new PropertyValueFactory<>("numeto_Itr"));
        colunaNumeroIncra.setCellValueFactory(new PropertyValueFactory<>("numero_Incra"));

        //listImoveisRurais = estadosDAO.lista();

        observableImoveisRurais = FXCollections.observableArrayList(listImoveisRurais);
        tbImoveisRurais.setItems(observableImoveisRurais);
    }

}
