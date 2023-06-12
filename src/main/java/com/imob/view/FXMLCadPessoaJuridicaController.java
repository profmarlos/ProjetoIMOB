//package com.imob.view;
//
//import com.imob.model.dao.EstadosDAO;
//import com.imob.model.database.Database;
//import com.imob.model.database.DatabaseFactory;
//import com.imob.model.domain.Estados;
//import com.imob.model.domain.Pessoa;
//import com.imob.model.domain.PessoaJuridica;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.control.Button;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.layout.AnchorPane;
//import javafx.stage.Stage;
//
//import java.net.URL;
//import java.sql.Connection;
//import java.util.List;
//import java.util.ResourceBundle;
//
//public class FXMLCadPessoaJuridicaController implements Initializable {
//
//    @FXML
//    AnchorPane apPessoaJuridica;
//
//    @FXML
//    private TextField txtRazSocial;
//
//    @FXML
//    private TextField txtNomeFantasia;
//
//    @FXML
//    private TextField txtCnpj;
//
//    @FXML
//    private TextField txtInscEstadual;
//
//    @FXML
//    private TextField txtIsentoInscEstadual;
//
//    @FXML
//    private TextField txtAtividadePrincipal;
//
//    @FXML
//    private TextField txtAtividadeSecundaria;
//
//    @FXML
//    private TextField txtDataAbertura;
//
//    @FXML
//    private TextField txtObservacao;
//
//    @FXML
//    private TextField txtStatusCadastro;
//
//    @FXML
//    private Button btnInserir;
//
//    @FXML
//    private Button btnDeletar;
//
//    @FXML
//    TableView <PessoaJuridica> tbPessoaJuridica;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunarazaoSocial;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunanomeFantasia;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunacnpj;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunainscEstadual;
//    @FXML
//    private TableColumn<PessoaJuridica, String>  colunaisentoInscEstadual;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunaatividadePrincipal;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunaatividadeSecundaria;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunadataAbertura;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunaobservacao;
//    @FXML
//    private TableColumn<PessoaJuridica, String> colunastatusCadastro;
//
//
//
//    private List<PessoaJuridica> listPessoaJuridica;
//    private ObservableList<PessoaJuridica> observablePessoaJuridica;
//
//    private final Database database = DatabaseFactory.getDatabase("mysql");
//    private final Connection connection = database.conectar();
//    private final PessoaJuridicaDAO pessoajuridicaDAO = new PessoaJuridicaDAO();
//
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//
//        pessoajuridicaDAO.setConnection(connection);
//
//        carregaPJNaTableView();
//    }
//
//    public void carregaPJNaTableView()
//    {
//        colunarazaoSocial.setCellValueFactory(new PropertyValueFactory<>("razao_social"));
//        colunanomeFantasia.setCellValueFactory(new PropertyValueFactory<>("nome_Fantasia"));
//        colunacnpj.setCellValueFactory(new PropertyValueFactory<>("cnpj"));
//        colunainscEstadual.setCellValueFactory(new PropertyValueFactory<>("inscricao_Estadual"));
//        colunaisentoInscEstadual.setCellValueFactory(new PropertyValueFactory<>("isento_Inscricao_estadual"));
//        colunaatividadePrincipal.setCellValueFactory(new PropertyValueFactory<>("atividade_Principal"));
//        colunaatividadeSecundaria.setCellValueFactory(new PropertyValueFactory<>("atividades_Secundarias"));
//        colunadataAbertura.setCellValueFactory(new PropertyValueFactory<>("data_Abertura"));
//        colunaobservacao.setCellValueFactory(new PropertyValueFactory<>("anotacoes"));
//        colunastatusCadastro.setCellValueFactory(new PropertyValueFactory<>("status_Cadastro"));
//
//        listPessoaJuridica = PessoaJuridicaDAO.lista();
//
//        observablePessoaJuridica = FXCollections.observableArrayList(listPessoaJuridica);
//        tbPessoaJuridica.setItems(observablePessoaJuridica);
//    }
//
//    @FXML
//    private void inserirDadosNoBancoDados(ActionEvent event) {
//        PessoaJuridica pessoaJuridica = new PessoaJuridica();
//
//        pessoaJuridica.setRazaoSocial_PJ(txtRazSocial.getText());
//        pessoaJuridica.setNomeFantasia_PJ(txtNomeFantasia.getText());
//        pessoaJuridica.setCnpj_PJ(txtCnpj.getText());
//        pessoaJuridica.setInscricaoEstadual_PJ(txtInscEstadual.getText());
//        pessoaJuridica.setIsentoInscEstadual_PJ(txtIsentoInscEstadual.getText());
//        pessoaJuridica.setSiglaAtividadePrincipal_PJ(txtAtividadePrincipal.getText());
//        pessoaJuridica.setAtividadesSecundarias_PJ(txtAtividadeSecundaria.getText());
//        pessoaJuridica.setData_PJ(txtDataAbertura.getText());   /// No banco o campo está como DATE, como fazer a conversão para salvar banco?
//        pessoaJuridica.setAnotacoes_PJ(txtObservacao.getText());
//        pessoaJuridica.setStatusCadastro_PJ(txtStatusCadastro.getText());
//
//        PessoaJuridicaDAO.inserir(pessoaJuridica);
//
//        limparCampos();
//
//        carregaPJNaTableView();
//    }
//
//    public void limparCampos()
//    {
//        txtRazSocial.setText("");
//        txtNomeFantasia.setText("");
//        txtCnpj.setText("");
//        txtInscEstadual.setText("");
//        txtIsentoInscEstadual.setText("");
//        txtAtividadePrincipal.setText("");
//        txtAtividadeSecundaria.setText("");
//        txtDataAbertura.setText("");
//        txtObservacao.setText("");
//        txtStatusCadastro.setText("");
//    }
//
//    @FXML
//    private void selecionarLinhaViewTable(MouseEvent event) {
//
//        txtRazSocial.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getRazao_Social());
//        txtNomeFantasia.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getNome_Fantasia());
//        txtCnpj.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getCnpj());
//        txtInscEstadual.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getInscricao_Estadual());
//        txtIsentoInscEstadual.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getInscricao_Estadual());
//        txtAtividadePrincipal.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getAtividade_Principal());
//        txtAtividadeSecundaria.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getAtividades_Secundarias());
//        txtDataAbertura.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getData_Abertura());
//        txtObservacao.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getAnotacoes());
//        txtStatusCadastro.setText(tbPessoaJuridica.getSelectionModel().getSelectedItem().getStatus_Cadastro());
//    }
//
//}
