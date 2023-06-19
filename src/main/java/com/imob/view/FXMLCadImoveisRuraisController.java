package com.imob.view;
import com.imob.model.dao.ImoveisRuraisDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.ImovelRural;
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

public class FXMLCadImoveisRuraisController implements Initializable {

    ObservableList<String> choiceList = FXCollections.observableArrayList("Sim", "Não");

    @FXML
    private TextField txtNumeroITR;

    @FXML
    private TextField txtNumeroIncra;

    @FXML
    private TextField txtImovelGeralIdImovel;

    @FXML
    private TextField txtIdImovel;

    @FXML
    private  TextField txtAreaImovelRural;

    @FXML
    private  TextField txtAreaApp;

    @FXML
    private  TextField txtAreaUtilizavel;

    @FXML
    private ChoiceBox chcTemCurral;

    @FXML
    private ChoiceBox chcTemCasaSede;

    @FXML
    private ChoiceBox chcTemCasaFuncionario;

    @FXML
    private ChoiceBox chcTemRepresa;

    @FXML
    private ChoiceBox chcTemRio;

    @FXML
    private ChoiceBox chcTemPoco;
    @FXML
    private Label lblFecharCadImoveisRurais;

    @FXML
    private TableColumn<ImovelRural, String> colunaNumeroITR;

    @FXML
    private TableColumn<ImovelRural, String> colunaNumeroIncra;

    @FXML
    private TableColumn<ImovelRural, String> colunaImovelGeralIDImovel;

    @FXML
    private TableColumn<ImovelRural, String> colunaIdImovel;

    @FXML
    private TableColumn<ImovelRural, String> colunaAreaImovelRural;

    @FXML
    private TableColumn<ImovelRural, String> colunaAreaApp;

    @FXML
    private TableColumn<ImovelRural, String> colunaAreaUtilizavel;
    @FXML
    private TableColumn<ImovelRural, String> colunaTemCurral;

    @FXML
    private TableColumn<ImovelRural, String> colunaTemCasaSede;
    @FXML
    private TableColumn<ImovelRural, String> colunaTemcasaDosFuncionarios;
    @FXML
    private TableColumn<ImovelRural, String> colunaTemRepresa;
    @FXML
    private TableColumn<ImovelRural, String> colunaTemRio;
    @FXML
    private TableColumn<ImovelRural, String> colunaTemPoco;
    @FXML
    private TableView<ImovelRural> tbImoveisRurais;

    private List<ImovelRural> listImoveisRurais;

    private ObservableList<ImovelRural> observableImoveisRurais;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ImoveisRuraisDAO imoveisRuraisDAO = new ImoveisRuraisDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        imoveisRuraisDAO.setConnection(connection);

        chcTemCurral.setItems(choiceList);
        chcTemCasaSede.setItems(choiceList);
        chcTemCasaFuncionario.setItems(choiceList);
        chcTemRepresa.setItems(choiceList);
        chcTemRio.setItems(choiceList);
        chcTemPoco.setItems(choiceList);

        carregaImoveisRuraisNaTableView();
        System.out.println("Controlador inicializado");
    }

    public void carregaImoveisRuraisNaTableView() {
        colunaNumeroITR.setCellValueFactory(new PropertyValueFactory<>("numeto_Itr"));
        colunaNumeroIncra.setCellValueFactory(new PropertyValueFactory<>("numero_Incra"));
        colunaImovelGeralIDImovel.setCellValueFactory(new PropertyValueFactory<>("id_imovel_geral"));
        colunaIdImovel.setCellValueFactory(new PropertyValueFactory<>("id_Imovel_R"));
        colunaAreaImovelRural.setCellValueFactory(new PropertyValueFactory<>("unidade_area_imovel_rural"));
        colunaAreaApp.setCellValueFactory(new PropertyValueFactory<>("area_App"));
        colunaAreaUtilizavel.setCellValueFactory(new PropertyValueFactory<>("area_Utilizavel"));
        colunaTemCurral.setCellValueFactory(new PropertyValueFactory<>("tem_Curral"));

        colunaTemCasaSede.setCellValueFactory(new PropertyValueFactory<>("tem_Casa_sede"));
        colunaTemcasaDosFuncionarios.setCellValueFactory(new PropertyValueFactory<>("tem_Casa_Funcionarios"));
        colunaTemRepresa.setCellValueFactory(new PropertyValueFactory<>("tem_Represa"));
        colunaTemRio.setCellValueFactory(new PropertyValueFactory<>("tem_Rio"));
        colunaTemPoco.setCellValueFactory(new PropertyValueFactory<>("tem_Poco"));

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
        txtAreaImovelRural.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getUnidade_area_imovel_rural()));
        txtAreaUtilizavel.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getArea_Utilizavel()));
        txtAreaApp.setText(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getArea_App()));
        chcTemCurral.setValue(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getTem_Curral()));

        chcTemCasaSede.setValue(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getTem_Casa_sede()));
        chcTemCasaFuncionario.setValue(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getTem_Casa_Funcionarios()));
        chcTemRepresa.setValue(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getTem_Represa()));
        chcTemRio.setValue(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getTem_Rio()));
        chcTemPoco.setValue(String.valueOf(tbImoveisRurais.getSelectionModel().getSelectedItem().getTem_Poco()));


    }

    @FXML
    private void fecharCadImoveisRurais(MouseEvent event) {

        Stage st = (Stage) lblFecharCadImoveisRurais.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }

    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        ImovelRural imovelRural = new ImovelRural();

        imovelRural.setNumeto_Itr(txtNumeroITR.getText());
        imovelRural.setNumero_Incra(txtNumeroIncra.getText());
        imovelRural.setId_Imovel_R(Integer.parseInt(txtImovelGeralIdImovel.getText()));
        imovelRural.setUnidade_area_imovel_rural(txtAreaImovelRural.getText());
        imovelRural.setArea_App(txtAreaApp.getText());
        imovelRural.setArea_Utilizavel(txtAreaUtilizavel.getText());
        imovelRural.setTem_Curral(chcTemCurral.getValue().toString());
        imovelRural.setTem_Casa_sede(chcTemCasaSede.getValue().toString());
        imovelRural.setTem_Casa_Funcionarios(chcTemCasaFuncionario.getValue().toString());
        imovelRural.setTem_Represa(chcTemRepresa.getValue().toString());
        imovelRural.setTem_Rio(chcTemRio.getValue().toString());
        imovelRural.setTem_Poco(chcTemPoco.getValue().toString());

        String textoAreaApp = txtAreaApp.getText();
        if (!isNumeroInteiroValido(textoAreaApp)) {
            exibirMensagemErro("Erro de validação", "Insira um número inteiro válido no campo Área APP.");
            txtAreaApp.clear();
            return; // Interrompe a execução do método aqui
        }

        String textoAreaUtilizavel= txtAreaUtilizavel.getText();
        if (!isNumeroInteiroValido(textoAreaUtilizavel)) {
            exibirMensagemErro("Erro de validação", "Insira um número inteiro válido no campo Área Utilizável.");
            txtAreaUtilizavel.clear();
            return; // Interrompe a execução do método aqui
        }

        String textoImovelGeralID= txtImovelGeralIdImovel.getText();
        if (!isNumeroInteiroValido(textoImovelGeralID)) {
            exibirMensagemErro("Erro de validação", "Insira um número inteiro válido no Campo Id Imovel Geral.");
            txtImovelGeralIdImovel.clear();
            return; // Interrompe a execução do método aqui
        }

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
        imovelRural.setUnidade_area_imovel_rural((txtAreaImovelRural.getText()));;
        imovelRural.setArea_App((txtAreaApp.getText()));
        imovelRural.setArea_Utilizavel((txtAreaUtilizavel.getText()));
        imovelRural.setTem_Curral(chcTemCurral.getValue().toString());
        imovelRural.setTem_Casa_sede(chcTemCasaSede.getValue().toString());
        imovelRural.setTem_Casa_Funcionarios(chcTemCasaFuncionario.getValue().toString());
        imovelRural.setTem_Represa(chcTemRepresa.getValue().toString());
        imovelRural.setTem_Rio(chcTemRio.getValue().toString());
        imovelRural.setTem_Poco(chcTemPoco.getValue().toString());

        String textoAreaApp = txtAreaApp.getText();
        if (!isNumeroInteiroValido(textoAreaApp)) {
            exibirMensagemErro("Erro de validação", "Insira um número inteiro válido no campo Área APP.");
            txtAreaApp.clear();
            return; // Interrompe a execução do método aqui
        }

        String textoAreaUtilizavel= txtAreaUtilizavel.getText();
        if (!isNumeroInteiroValido(textoAreaUtilizavel)) {
            exibirMensagemErro("Erro de validação", "Insira um número inteiro válido no campo Área Utilizável.");
            txtAreaUtilizavel.clear();
            return; // Interrompe a execução do método aqui
        }

        if (!txtImovelGeralIdImovel.getText().isEmpty() || !txtIdImovel.getText().isEmpty()) {
            exibirMensagemErro("Erro de validação", "Esse campo NÃO pode ser alterado.");
            return;
        }




        imoveisRuraisDAO.alterar(imovelRural);
        limparCampos();
        carregaImoveisRuraisNaTableView();


    }

    public void limparCampos() {
        txtNumeroITR.setText("");
        txtNumeroIncra.setText("");
        txtImovelGeralIdImovel.setText("");
        txtIdImovel.setText("");
        txtAreaImovelRural.setText("");
        txtAreaApp.setText("");
        txtAreaUtilizavel.setText("");
        chcTemCurral.setValue("");
        chcTemCasaSede.setValue("");
        chcTemCasaFuncionario.setValue("");
        chcTemRepresa.setValue("");
        chcTemRio.setValue("");
        chcTemPoco.setValue("");
    }

    private boolean isNumeroInteiroValido(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void exibirMensagemErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}