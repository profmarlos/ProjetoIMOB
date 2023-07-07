package com.imob.view;


import com.imob.model.dao.PrestadoresDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;

import java.text.ParseException;

import com.imob.model.domain.PrestadoresServicos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;


public class FXMLPrestadoresController implements Initializable {
    @FXML
    private AnchorPane IdArchor;
    @FXML
    private TextField IdCodigo;
    @FXML
    private TextField IdNomePrestador;
    @FXML
    private TextField IdCodigoServico;
    @FXML
    private TextField IdTipoServico;
    @FXML
    private DatePicker IdDataInicial;
    @FXML
    private TextField IdDataFinal;
    @FXML
    private TextField IdAnotacoes;
    @FXML
    private Button BtAdd;
    @FXML
    private Button BtEdit;
    @FXML
    private Button BtLmp;
    @FXML
    private Button BtDel;

    @FXML
    private TableView<PrestadoresServicos> IdTable;

    @FXML
    private TableColumn<PrestadoresServicos, String> Tb_cod;
    @FXML
    private TableColumn<PrestadoresServicos, String> TbNome;
    @FXML
    private TableColumn<PrestadoresServicos, String> TbCodServ;
    @FXML
    private TableColumn<PrestadoresServicos, String> TbTipo;
    @FXML
    private TableColumn<PrestadoresServicos, Date> TbInicial;
    @FXML
    private TableColumn<PrestadoresServicos, String> TbFinal;
    @FXML
    private TableColumn<PrestadoresServicos, String> TbAnotacoes;

    @FXML
   // private TableView<PrestadoresServicos> IdTable;
    private List<PrestadoresDAO> listPrestador;
    private ObservableList<PrestadoresDAO> observablePrestador;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final PrestadoresDAO prestadoresDAO = new PrestadoresDAO();

    public void initialize(URL url, ResourceBundle rb) {

        //conexão com o banco de dados
        prestadoresDAO.setConnection(connection);

        //carregaPrestadorTableView();
        System.out.println("Controlador inicializado");

    }

    public void carregaPrestadorTableView() {
       // Tb_cod.setCellValueFactory(new PropertyValueFactory<>("id_Prestador"));
        TbNome.setCellValueFactory(new PropertyValueFactory<>("id_Codigo_Prestador"));
        //TbCodServ.setCellValueFactory(new PropertyValueFactory<>("id_Codigo_Servico"));
        TbTipo.setCellValueFactory(new PropertyValueFactory<>("tipo_servico_prestado"));
        TbInicial.setCellValueFactory(new PropertyValueFactory<>("data_Inicial"));
        TbFinal.setCellValueFactory(new PropertyValueFactory<>("data_Final"));
        TbAnotacoes.setCellValueFactory(new PropertyValueFactory<>("anotacoes"));



       // listPrestador = PrestadoresServicos.lista();

        observablePrestador = FXCollections.observableArrayList(listPrestador);

       // IdTable.setItems(observablePrestador);
    }

    @FXML
   /* private void inserirDadosNoBanco(ActionEvent event) throws ParseException {
        PrestadoresServicos prestadores = new PrestadoresServicos();

        prestadores.setId_Prestador(resultado.getInt("id_Codigo"));
        prestadores.setId_Codigo_Prestador(resultado.getString("id_Codigo_Prestador"));
        prestadores.setId_Codigo_Servico(resultado.getString("codigo_Serviço"));
        prestadores.setTipo_servico_prestado(resultado.getString("tipo_servico_prestado"));
        prestadores.setData_Inicial(resultado.getDate(("data_Inicial")));
        prestadores.setData_Final(resultado.getString("data_Final"));
        prestadores.setAnotacoes(resultado.getString("anotacoes"));



        PrestadoresDAO.inserir(prestadores);


        carregaPrestadorTableView();
    }
    @FXML
   /* private void selecionarLinhaViewTable(MouseEvent event) {

        id_Prestador.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getId_PessoaPF()));
        id_Codigo_Prestador.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getNome()));
        codigo_Serviço.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getCpf()));
        tipo_servico_prestado.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getRg()));
        data_Inicial.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getData_nascimento()));
        data_Final.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getSexo()));
        anotacoes.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getEstado_Civil()));




    }
    @FXML
    private void deletarNoBanco(ActionEvent event) {
        PrestadoresServicos prestadores = new PrestadoresServicos();
        prestadores.setIdCodigo(Integer.parseInt(IdCodigo.getText()));

        PrestadoresDAO.remover(prestadores);


        limparCampos();

        carregaPrestadorTableView();
    }
    public void limparCampos() {
      //  id_Prestador.setText("");
       // id_Codigo_Prestador.setText("");
        codigo_Serviço.setText("");
        tipo_servico_prestado.setText("");
        data_Inicial.setId("");
        data_Final.setText("");
        anotacoes.setText("");


    }*/
    private void atualizarDadosNoBanco(ActionEvent event) {

        PrestadoresServicos prestadores = new PrestadoresServicos();

        prestadores.setId_Prestador(Integer.parseInt(IdCodigo.getText()));
        //prestadores.setId_Codigo_Prestador(IdNomePrestador.getText());
       // prestadores.setCodigo_Servico(IdCodigoServico.getText());
        prestadores.setTipo_servico_prestado(IdTipoServico.getText());
        prestadores.setData_Inicial(Date.valueOf(IdDataInicial.getId()));
       // prestadores.setData_Final((IdDataFinal.getText()));
        prestadores.setAnotacoes((IdAnotacoes.getText()));


        PrestadoresDAO.alterar(prestadores);

       // limparCampos();

        carregaPrestadorTableView();
    }
}