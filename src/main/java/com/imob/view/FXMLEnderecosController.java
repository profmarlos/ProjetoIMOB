package com.imob.view;

import com.imob.model.dao.LogradourosDAO;
import com.imob.model.domain.Enderecos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;

public class FXMLEnderecosController  implements Initializable {

    @FXML
    private Label lbfecharlogradouro;
    @FXML
    private TextField txfid;
    @FXML
    private TextField txftipo;
    @FXML
    private TextField txflogradouro;
    @FXML
    private TextField txfnumero_log;
    @FXML
    private TextField Txfnumeri_ap;
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
    private Button btninserir;
    @FXML
    private Button btndeletar;
    @FXML
    private Button btnalterar;

    @FXML
    private TableColumn<Enderecos, Integer> colunacodigocasa ;
    @FXML
    private TableColumn<Enderecos, Integer> colunacodigoap;
    private Connection connection;


    public void initialize(URL url, ResourceBundle rb) {

        //conexão com o banco de dados
        LogradourosDAO.setConnection(connection);

        carregaLogradouroNaTableView();
        System.out.println("Controlador inicializado");

    }
    @FXML
    private void setLbfecharlogradouro(MouseEvent event){

    }

    private void carregaLogradouroNaTableView() {

    }

    public void limparCampos(){

    }

    @FXML
    private void deletarDadosSelecionados(ActionEvent event){

    }

    @FXML
    private void atualizarDadosSelecionados(ActionEvent event){

    }
    @FXML
    private void selecionarLinhaViewTable(MouseEvent event){

    }
}
