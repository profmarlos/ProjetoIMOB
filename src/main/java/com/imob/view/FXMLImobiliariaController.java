package com.imob.view;

import com.imob.model.dao.ImobiliariaDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.Imobiliaria;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLImobiliariaController implements Initializable {

    @FXML
    private TextField tfCodigoCreci;

    @FXML
    private TextField tfIdImobiliaria;

    @FXML
    private TextField tfPessoaPj;

    @FXML
    private TextField tfPessoaId;

    @FXML
    private TextField tfPagcomissao;

    @FXML
    private TextField tfCodigoImobiliaria;
    @FXML
    private Label lblCadFecharImobiliaria;

    @FXML
    private TableColumn<Imobiliaria, Integer> tbCreci;

    @FXML
    private TableColumn<Imobiliaria, Integer> tbIdImobiliaria;

    @FXML
    private TableColumn<Imobiliaria, Integer> tbCodigoImobiliaria;

    @FXML
    private TableColumn<Imobiliaria, Integer> tbPessoaPJ;

    @FXML
    private TableColumn<Imobiliaria, Integer> tbPessoaIdPessoa;

    @FXML
    private TableColumn<Imobiliaria, Integer> tbPagComissao;

    @FXML
    private TableView<Imobiliaria> tableViewImobiliaria;

    private List<Imobiliaria> listImobiliaria;
    private ObservableList<Imobiliaria> observableImobiliaria;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ImobiliariaDAO imobiliariaDAO = new ImobiliariaDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        imobiliariaDAO.setConnection(connection);


        carregaImobiliariaNaTableView();
        System.out.println("Imobiliária foi iniciada");
        }

    public void carregaImobiliariaNaTableView(){
        tbCreci.setCellValueFactory(new PropertyValueFactory<>("numero_Creci"));
        tbIdImobiliaria.setCellValueFactory(new PropertyValueFactory<>("id_Imobiliaria"));
        tbCodigoImobiliaria.setCellValueFactory(new PropertyValueFactory<>("id_Codigo_imobiliaria"));
        tbPessoaPJ.setCellValueFactory(new PropertyValueFactory<>("tb_pessoa_juridica_id_PessoaPJ"));
        tbPessoaIdPessoa.setCellValueFactory(new PropertyValueFactory<>("tb_pessoa_juridica_tb_pessoa_id_Pessoa"));
        tbPagComissao.setCellValueFactory(new PropertyValueFactory<>("tb_pagamento_comissao_id_Pag_Comissao"));

        listImobiliaria = imobiliariaDAO.lista();

        observableImobiliaria = FXCollections.observableArrayList(listImobiliaria);

        tableViewImobiliaria.setItems(observableImobiliaria);
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {

        tfCodigoCreci.setText(String.valueOf(tableViewImobiliaria.getSelectionModel().getSelectedItem().getNumero_Creci()));
        tfIdImobiliaria.setText(String.valueOf(tableViewImobiliaria.getSelectionModel().getSelectedItem().getId_Imobiliaria()));
        tfCodigoImobiliaria.setText(String.valueOf(tableViewImobiliaria.getSelectionModel().getSelectedItem().getId_Codigo_imobiliaria()));
        tfPessoaPj.setText(String.valueOf(tableViewImobiliaria.getSelectionModel().getSelectedItem().getTb_pessoa_juridica_id_PessoaPJ()));
        tfPessoaId.setText(String.valueOf(tableViewImobiliaria.getSelectionModel().getSelectedItem().getTb_pessoa_juridica_tb_pessoa_id_Pessoa()));
        tfPagcomissao.setText(String.valueOf(tableViewImobiliaria.getSelectionModel().getSelectedItem().getTb_pagamento_comissao_id_Pag_Comissao()));
    }

    @FXML
    private void fecharImobiliaria(MouseEvent event) {
        Stage st = (Stage) lblCadFecharImobiliaria.getScene().getWindow();
        st.close();

    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        Imobiliaria imobiliaria = new Imobiliaria();

        imobiliaria.setId_Codigo_imobiliaria(Integer.parseInt(tfCodigoImobiliaria.getText()));
        imobiliaria.setNumero_Creci(Integer.parseInt(tfCodigoCreci.getText()));
        imobiliaria.setTb_pessoa_juridica_id_PessoaPJ(Integer.parseInt(tfPessoaPj.getText()));
        imobiliaria.setTb_pessoa_juridica_tb_pessoa_id_Pessoa(Integer.parseInt(tfPessoaId.getText()));
        imobiliaria.setTb_pagamento_comissao_id_Pag_Comissao(Integer.parseInt(tfPagcomissao.getText()));

        String CodigoImobiliaria = tfCodigoImobiliaria.getText();
        if (!isNumeroInteiroValido(CodigoImobiliaria)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no Banheiro!");
            tfCodigoImobiliaria.clear();
            return;
        }

        String CodigoCreci = tfCodigoCreci.getText();
        if (!isNumeroInteiroValido(CodigoCreci)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no Dormitório!");
            tfCodigoCreci.clear();
            return;
        }

        String PessoaPj = tfPessoaPj.getText();
        if (!isNumeroInteiroValido(PessoaPj)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido na Vagas!");
            tfPessoaPj.clear();
            return;
        }

        String PessoaId = tfPessoaId.getText();
        if (!isNumeroInteiroValido(PessoaId)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no ID!");
            tfPessoaId.clear();
            return;
        }

        String Pagcomissao = tfPagcomissao.getText();
        if (!isNumeroInteiroValido(Pagcomissao)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no Id Geral!");
            tfPagcomissao.clear();
            return;
        }
        imobiliariaDAO.inserir(imobiliaria);

        limparCampos();
        carregaImobiliariaNaTableView();
    }

    @FXML
    private void deletarInformacoesNoBanco(ActionEvent event){
        Imobiliaria imobiliaria = new Imobiliaria();

        imobiliaria.setId_Imobiliaria(Integer.parseInt(tfIdImobiliaria.getText()));

        imobiliariaDAO.remover(imobiliaria);


        limparCampos();

        carregaImobiliariaNaTableView();
    }

    @FXML
    private void atualizarImobiliaria(ActionEvent event){

        Imobiliaria imobiliaria = new Imobiliaria();

        imobiliaria.setId_Codigo_imobiliaria(Integer.parseInt(tfCodigoImobiliaria.getText()));
        imobiliaria.setNumero_Creci(Integer.parseInt(tfCodigoCreci.getText()));
        imobiliaria.setId_Imobiliaria(Integer.parseInt(tfIdImobiliaria.getText()));
        imobiliaria.setTb_pessoa_juridica_id_PessoaPJ(Integer.parseInt(tfPessoaPj.getText()));
        imobiliaria.setTb_pessoa_juridica_tb_pessoa_id_Pessoa(Integer.parseInt(tfPessoaId.getText()));
        imobiliaria.setTb_pagamento_comissao_id_Pag_Comissao(Integer.parseInt(tfPagcomissao.getText()));

            imobiliariaDAO.alterar(imobiliaria);
            limparCampos();
            carregaImobiliariaNaTableView();
    }


    public void limparCampos(){
        tfIdImobiliaria.setText("");
        tfCodigoCreci.setText("");
        tfCodigoImobiliaria.setText("");
        tfPagcomissao.setText("");
        tfPessoaId.setText("");
        tfPessoaPj.setText("");

    }
    private boolean isNumeroInteiroValido(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void exibirErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}

