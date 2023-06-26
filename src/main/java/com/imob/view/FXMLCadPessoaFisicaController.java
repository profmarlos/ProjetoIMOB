package com.imob.view;

import com.imob.model.dao.PessoaFisicaDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;

import java.text.ParseException;

import com.imob.model.domain.PessoaFisica;
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


public class FXMLCadPessoaFisicaController implements Initializable {
    @FXML
    private AnchorPane apPessoaFisica;
    @FXML
    private TextField txtID;
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtCPF;
    @FXML
    private TextField txtRG;
    @FXML
    private DatePicker txtData;
    @FXML
    private TextField txtSexo;
    @FXML
    private TextField txtECivil;
    @FXML
    private TextField txtNaturalidade;
    @FXML
    private TextField txtEstado;
    @FXML
    private TextField txtEscolaridade;
    @FXML
    private TextField txtProfissao;
    @FXML
    private TextField txtPai;
    @FXML
    private TextField txtMae;
    @FXML
    private TextField txtDia;

    @FXML
    private TableColumn<PessoaFisica, String> colunaID;
    @FXML
    private TableColumn<PessoaFisica, String> colunaNome;
    @FXML
    private TableColumn<PessoaFisica, String> colunaCPF;
    @FXML
    private TableColumn<PessoaFisica, String> colunaRG;
    @FXML
    private TableColumn<PessoaFisica, Date> colunaData;
    @FXML
    private TableColumn<PessoaFisica, String> colunaSexo;
    @FXML
    private TableColumn<PessoaFisica, String> colunaCivil;
    @FXML
    private TableColumn<PessoaFisica, String> colunaNaturalidade;
    @FXML
    private TableColumn<PessoaFisica, String> colunaEstado;
    @FXML
    private TableColumn<PessoaFisica, String> colunaEscolaridade;
    @FXML
    private TableColumn<PessoaFisica, String> colunaProfissao;
    @FXML
    private TableColumn<PessoaFisica, String> colunaPai;
    @FXML
    private TableColumn<PessoaFisica, String> colunaMae;
    @FXML
    private TableColumn<PessoaFisica, String> colunaDia;

    @FXML
    private Label lblFecharTeste;
    @FXML
    private TableView<PessoaFisica> tbPessoaFisica;
    private List<PessoaFisica> listPessoaFisica;
    private ObservableList<PessoaFisica> observablePessoaFisica;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final PessoaFisicaDAO pessoaFisicaDAO = new PessoaFisicaDAO();

    public void initialize(URL url, ResourceBundle rb) {

        //conexão com o banco de dados
        pessoaFisicaDAO.setConnection(connection);

        carregaPessoaFisicaNaTableView();
        System.out.println("Controlador inicializado");

    }

    public void carregaPessoaFisicaNaTableView() {
        colunaID.setCellValueFactory(new PropertyValueFactory<>("id_PessoaPF"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        colunaRG.setCellValueFactory(new PropertyValueFactory<>("rg"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data_nascimento"));
        colunaSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colunaCivil.setCellValueFactory(new PropertyValueFactory<>("estado_Civil"));
        colunaNaturalidade.setCellValueFactory(new PropertyValueFactory<>("naturalidade"));
        colunaEstado.setCellValueFactory(new PropertyValueFactory<>("estado_Naturalidade"));
        colunaEscolaridade.setCellValueFactory(new PropertyValueFactory<>("escolaridade"));
        colunaProfissao.setCellValueFactory(new PropertyValueFactory<>("profissao"));
        colunaPai.setCellValueFactory(new PropertyValueFactory<>("nome_Pai"));
        colunaMae.setCellValueFactory(new PropertyValueFactory<>("nome_Mae"));
        colunaDia.setCellValueFactory(new PropertyValueFactory<>("Dia"));


        listPessoaFisica = PessoaFisicaDAO.lista();

        observablePessoaFisica = FXCollections.observableArrayList(listPessoaFisica);

        tbPessoaFisica.setItems(observablePessoaFisica);
    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) throws ParseException {
        PessoaFisica pFisica = new PessoaFisica();


        pFisica.setId_PessoaPF(Integer.parseInt(txtID.getText()));
        pFisica.setNome(txtNome.getText());
        pFisica.setCpf((txtCPF.getText()));
        pFisica.setRg((txtRG.getText()));
        pFisica.setData_nascimento(Date.valueOf((txtData.getValue())));
        pFisica.setSexo((txtSexo.getText()));
        pFisica.setEstado_Civil((txtECivil.getText()));
        pFisica.setNaturalidade((txtNaturalidade.getText()));
        pFisica.setEstado_Naturalidade((txtEstado.getText()));
        pFisica.setEscolaridade((txtEscolaridade.getText()));
        pFisica.setProfissao((txtProfissao.getText()));
        pFisica.setNome_Pai((txtPai.getText()));
        pFisica.setNome_Mae((txtMae.getText()));
        pFisica.setDia((txtDia.getText()));


        PessoaFisicaDAO.inserir(pFisica);


        carregaPessoaFisicaNaTableView();
    }
    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {

        txtID.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getId_PessoaPF()));
        txtNome.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getNome()));
        txtCPF.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getCpf()));
        txtRG.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getRg()));
        txtData.setId(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getData_nascimento()));
        txtSexo.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getSexo()));
        txtECivil.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getEstado_Civil()));
        txtNaturalidade.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getNaturalidade()));
        txtEstado.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getEstado_Naturalidade()));
        txtEscolaridade.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getEscolaridade()));
        txtProfissao.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getProfissao()));
        txtPai.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getNome_Pai()));
        txtMae.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getNome_Mae()));
        txtDia.setText(String.valueOf(tbPessoaFisica.getSelectionModel().getSelectedItem().getDia()));



    }
    @FXML
    private void deletarInformacoesNoBanco(ActionEvent event) {
        PessoaFisica pfisica = new PessoaFisica();
        pfisica.setId_PessoaPF(Integer.parseInt(txtID.getText()));

        PessoaFisicaDAO.remover(pfisica);


        limparCampos();

        carregaPessoaFisicaNaTableView();
    }
    public void limparCampos() {
        txtID.setText("");
        txtNome.setText("");
        txtCPF.setText("");
        txtRG.setText("");
        txtData.setId("");
        txtSexo.setText("");
        txtECivil.setText("");
        txtNaturalidade.setText("");
        txtEstado.setText("");
        txtEscolaridade.setText("");
        txtProfissao.setText("");
        txtPai.setText("");
        txtMae.setText("");
        txtDia.setText("");

    }
    @FXML
    private void atualizarDadosNoBanco(ActionEvent event) {

        PessoaFisica pfisica = new PessoaFisica();

        pfisica.setId_PessoaPF(Integer.parseInt(txtID.getText()));
        pfisica.setNome(txtNome.getText());
        pfisica.setCpf(txtCPF.getText());
        pfisica.setRg(txtRG.getText());
        pfisica.setData_nascimento(Date.valueOf(txtData.getId()));
        pfisica.setSexo((txtSexo.getText()));
        pfisica.setEstado_Civil((txtECivil.getText()));
        pfisica.setNaturalidade((txtNaturalidade.getText()));
        pfisica.setEstado_Naturalidade((txtEstado.getText()));
        pfisica.setEscolaridade((txtEscolaridade.getText()));
        pfisica.setProfissao((txtProfissao.getText()));
        pfisica.setNome_Pai((txtPai.getText()));
        pfisica.setNome_Mae((txtMae.getText()));
        pfisica.setDia((txtDia.getText()));

        PessoaFisicaDAO.alterar(pfisica);

        limparCampos();

        carregaPessoaFisicaNaTableView();
    }
    @FXML
    private void fecharTeste(MouseEvent event) {

        Stage st = (Stage) lblFecharTeste.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }
}