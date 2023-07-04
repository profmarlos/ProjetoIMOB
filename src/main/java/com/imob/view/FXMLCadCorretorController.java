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

public class FXMLCadCorretorController implements Initializable {

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
    @FXML
    private TableColumn<Corretor, Integer> colunaTb_pessoa_fisica_id_PessoaPF;

    @FXML
    private TableColumn<Corretor, Integer> colunaTb_pessoa_fisica_tb_pessoa_id_Pessoa;

    @FXML
    private TableColumn<Corretor, Integer> colunaTb_pagamento_comissao_id_Pag_Comissao;
    private List<Corretor> listCorretores;

    private ObservableList<Corretor> observableCorretores;

    @FXML
    private TextField Tb_pessoa_fisica_id_PessoaPF;

    @FXML
    private TextField Tb_pessoa_fisica_tb_pessoa_id_Pessoa;

    @FXML
    private TextField Tb_pagamento_comissao_id_Pag_Comissao;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final CorretorDAO corretorDAO = new CorretorDAO();

    public void initialize(URL url, ResourceBundle rb) {
        corretorDAO.setConnection(connection);

        carregarCorretoresNaTableView();
        System.out.println("Controlador inicializado");
    }

    public void carregarCorretoresNaTableView() {

        colunaIdCorretor.setCellValueFactory(new PropertyValueFactory<>("id_Corretor"));
        colunaCodigoCorretor.setCellValueFactory(new PropertyValueFactory<>("codigo_Corretor"));
        colunaNumeroCreci.setCellValueFactory(new PropertyValueFactory<>("numero_Creci"));
        colunaTb_pessoa_fisica_id_PessoaPF.setCellValueFactory(new PropertyValueFactory<>("tb_pessoa_fisica_id_PessoaPF"));
        colunaTb_pessoa_fisica_tb_pessoa_id_Pessoa.setCellValueFactory(new PropertyValueFactory<>("tb_pessoa_fisica_tb_pessoa_id_Pessoa"));
        colunaTb_pagamento_comissao_id_Pag_Comissao.setCellValueFactory(new PropertyValueFactory<>("tb_pagamento_comissao_id_Pag_Comissao"));



        listCorretores = corretorDAO.listar();

        observableCorretores = FXCollections.observableArrayList(listCorretores);

        tbCorretores.setItems(observableCorretores);
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event){
        // Verifica se o item selecionado não é nulo
        if (tbCorretores.getSelectionModel().getSelectedItem() != null) {
            textIdCorretor.setText(String.valueOf(tbCorretores.getSelectionModel().getSelectedItem().getId_Corretor()));
            textCodigoCorretor.setText(String.valueOf(tbCorretores.getSelectionModel().getSelectedItem().getId_Codigo_Corretor()));
            textNumeroCreci.setText(String.valueOf(tbCorretores.getSelectionModel().getSelectedItem().getNumero_Creci()));
            Tb_pessoa_fisica_id_PessoaPF.setText(String.valueOf(tbCorretores.getSelectionModel().getSelectedItem().getTb_pessoa_fisica_id_PessoaPF()));
            Tb_pessoa_fisica_tb_pessoa_id_Pessoa.setText(String.valueOf(tbCorretores.getSelectionModel().getSelectedItem().getTb_pessoa_fisica_tb_pessoa_id_Pessoa()));
            Tb_pagamento_comissao_id_Pag_Comissao.setText(String.valueOf(tbCorretores.getSelectionModel().getSelectedItem().getTb_pagamento_comissao_id_Pag_Comissao()));
        }
    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        Corretor corretor = new Corretor();

        corretor.setId_Corretor(Integer.parseInt(textIdCorretor.getText()));
        corretor.setId_Codigo_Corretor(Integer.parseInt(textCodigoCorretor.getText()));
        corretor.setNumero_Creci(Integer.parseInt(textNumeroCreci.getText()));

        corretor.setTb_pessoa_fisica_id_PessoaPF(Integer.parseInt(Tb_pessoa_fisica_id_PessoaPF.getText()));
        corretor.setTb_pessoa_fisica_tb_pessoa_id_Pessoa(Integer.parseInt(Tb_pessoa_fisica_tb_pessoa_id_Pessoa.getText()));
        corretor.setTb_pagamento_comissao_id_Pag_Comissao(Integer.parseInt(Tb_pagamento_comissao_id_Pag_Comissao.getText()));



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

        corretor.setTb_pessoa_fisica_id_PessoaPF(Integer.parseInt(Tb_pessoa_fisica_id_PessoaPF.getText()));
        corretor.setTb_pessoa_fisica_tb_pessoa_id_Pessoa(Integer.parseInt(Tb_pessoa_fisica_tb_pessoa_id_Pessoa.getText()));
        corretor.setTb_pagamento_comissao_id_Pag_Comissao(Integer.parseInt(Tb_pagamento_comissao_id_Pag_Comissao.getText()));

        corretorDAO.atualizar(corretor);

        limparCampos();
        carregarCorretoresNaTableView();
    }

    private void limparCampos() {
        textIdCorretor.clear();
        textCodigoCorretor.clear();
        textNumeroCreci.clear();
        Tb_pessoa_fisica_id_PessoaPF.clear();
        Tb_pessoa_fisica_tb_pessoa_id_Pessoa.clear();
        Tb_pagamento_comissao_id_Pag_Comissao.clear();

    }

    @FXML
    private void fecharTela(ActionEvent event) {
        Stage stage = (Stage) textIdCorretor.getScene().getWindow();
        stage.close();
    }
}
