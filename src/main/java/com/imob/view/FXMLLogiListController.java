package com.imob.view;

import com.imob.model.dao.LoginSenhaDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.LoginSenha;
import com.imob.model.domain.LoginSenhaFilter;
import com.imob.model.domain.Permissoes;
import com.imob.model.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLLogiListController implements Initializable {

    @FXML
    TextField textLogin;
    @FXML
    TextField textPermissao;
    @FXML
    TextField textID;
    @FXML
    TextField textIDPF;
    @FXML
    TextField textIDPessoa;
    @FXML
    TableView<LoginSenha> tableViewUser;
    @FXML
    TableColumn<LoginSenha, String> columnLogin;
    @FXML
    TableColumn<LoginSenha, Permissoes> columnPermissao;
    @FXML
    TableColumn<LoginSenha, Integer> columnID;
    @FXML
    TableColumn<LoginSenha, Integer> columnIDPF;
    @FXML
    TableColumn<LoginSenha, Integer> columnIDPessoa;

    public static FXMLLogiListController instantiationLoginList;
    public static LoginSenha loginSelect;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final LoginSenhaDAO loginSenhaDAO = new LoginSenhaDAO();

    @FXML
    public void onSearch(ActionEvent event) throws SQLException {
        String idStr = textID.getText();
        String login = textLogin.getText();
        String permissao = textPermissao.getText();
        String idPfStr = textIDPF.getText();
        String idPessoaStr = textIDPessoa.getText();

        if(idStr.isBlank()){
            idStr = null;
        }
        if(idStr != null && (!idStr.matches("[0-9]*"))){
            Alerts.showAlert("Id", null, "O id ser um numero inteiro!", Alert.AlertType.ERROR);
            return;
        }
        Integer idlLogin = idStr == null ? null : Integer.parseInt(idStr);

        if(idPfStr.isBlank()){
            idPfStr = null;
        }
        if(idPfStr != null && (!idPfStr.matches("[0-9]*"))){
            Alerts.showAlert("ID Pessoa PF", null, "O id da pessoa PF precisa ser um numero inteiro!", Alert.AlertType.ERROR);
            return;
        }
        Integer idPessoaPF = idPfStr == null ? null : Integer.parseInt(idPfStr);

        if(idPessoaStr.isBlank()){
            idPessoaStr = null;
        }
        if(idPessoaStr != null && (!idPessoaStr.matches("[0-9]*"))){
            Alerts.showAlert("ID Pessoa", null, "O id da pessoa precisa ser um numero inteiro!", Alert.AlertType.ERROR);
            return;
        }
        Integer idPessoa = idPessoaStr == null ? null : Integer.parseInt(idPessoaStr);

        LoginSenhaFilter filter = new LoginSenhaFilter(idlLogin, idPessoaPF, idPessoa, login, permissao);
        List<LoginSenha> users = loginSenhaDAO.buscarPeloFiltro(filter);
        updateTableView(users);
    }

    @FXML
    public void onCreate(ActionEvent event){
        try {
            instantiationLoginList = this;
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadLogin.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Novo Login");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onDelete(ActionEvent event){
        try {
            loginSelect = tableViewUser.getSelectionModel().getSelectedItem();
            if(loginSelect == null){
                Alerts.showAlert("Exclusão Login", "Falha ao excluir login", "Nenhum login selecionado", Alert.AlertType.WARNING);
                return;
            }

            int id = loginSelect.getId_Login();
            loginSenhaDAO.remover(id);
            Alerts.showAlert("Exclusão Login", null, "Login excluido com sucesso!", Alert.AlertType.CONFIRMATION);
            updateTableView();
        } catch (SQLException e) {
            e.printStackTrace();
            Alerts.showAlert("Exclusão Login", "Falha ao excluir login", e.getCause().getMessage(), Alert.AlertType.ERROR);
            throw new RuntimeException(e);
        }

    }

    @FXML
    public void onUpdate(ActionEvent event){
        loginSelect = tableViewUser.getSelectionModel().getSelectedItem();
        if(loginSelect == null){
            Alerts.showAlert("Atualizar Login", "Falha ao atualizar login", "Nenhum login selecionado", Alert.AlertType.WARNING);
            return;
        }

        try {
            instantiationLoginList = this;
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("FormAtualizaLogin.fxml"));
            stage.setScene(new Scene(root));
            stage.setTitle("Atualizar Login");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node) event.getSource()).getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            loginSenhaDAO.setConnection(connection);
            initializeNodes();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private void initializeNodes() throws SQLException {
        columnID.setCellValueFactory(new PropertyValueFactory<>("id_Login"));
        columnLogin.setCellValueFactory(new PropertyValueFactory<>("usuario_Login"));
        columnPermissao.setCellValueFactory(new PropertyValueFactory<>("permissao"));
        columnIDPF.setCellValueFactory(new PropertyValueFactory<>("id_PessoaPF"));
        columnIDPessoa.setCellValueFactory(new PropertyValueFactory<>("id_Pessoa"));
        updateTableView();
    }

    public void updateTableView() throws SQLException {
        updateTableView(null);
    }

    public void updateTableView(List<LoginSenha> logins) throws SQLException {
        if(logins == null){
            logins = loginSenhaDAO.listaTodos();
        }
        ObservableList<LoginSenha> loginsObs = FXCollections.observableArrayList(logins);
        tableViewUser.setItems(loginsObs);
    }
}
