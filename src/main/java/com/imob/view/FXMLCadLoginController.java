package com.imob.view;

import com.imob.model.dao.LoginSenhaDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.LoginSenha;
import com.imob.model.domain.Permissoes;
import com.imob.model.util.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FXMLCadLoginController implements Initializable {

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final LoginSenhaDAO loginSenhaDAO = new LoginSenhaDAO();

    @FXML
    TextField textLogin;

    @FXML
    TextField textIdPessoa;

    @FXML
    TextField textIdPessoaPF;

    @FXML
    PasswordField textSenha;

    @FXML
    ComboBox<Permissoes> comboBoxPermissoes;
    ObservableList<Permissoes> obsListRole;

    @FXML
    Button btnSave;

    @FXML
    Button btnCancel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginSenhaDAO.setConnection(connection);

        List<Permissoes> roleList = new ArrayList<>();
        roleList.add(Permissoes.ADMIN);
        roleList.add(Permissoes.USUARIO);
        obsListRole = FXCollections.observableArrayList(roleList);
        comboBoxPermissoes.setItems(obsListRole);

        //List<PessoaFisica> listaPessoa = PessoaFisicaDAO.lista();
        //obsListPessoaFisica = FXCollections.observableArrayList(listaPessoa);
    }

    @FXML
    public void save(ActionEvent event) {
        String login = textLogin.getText();
        String idPessoaStr = textIdPessoa.getText();
        String idPessoaPFStr = textIdPessoaPF.getText();
        String password = textSenha.getText();
        Permissoes permissao = comboBoxPermissoes.getSelectionModel().getSelectedItem();

        if(login.isBlank() || password.isBlank() || permissao == null){
            Alerts.showAlert("Campos Nao Preenchidos", null, "Campos Obrigatorio Nao Preenchidos!", Alert.AlertType.ERROR);
            return;
        }

        try {
            LoginSenha loginSenha = loginSenhaDAO.buscarPeloLogin(login);
            if(loginSenha != null){
                String loginUsuario = loginSenha.getUsuario_Login();
                if(loginUsuario.equals(login)){
                    Alerts.showAlert("Usuario ja Cadastrado", null, "Login ja cadastrado, tente outro!", Alert.AlertType.ERROR);
                    return;
                }
                return;
            }

            int idPessoa = 0;
            if(idPessoaStr != null && !idPessoaStr.equals("") && (idPessoaStr.matches("[0-9]*"))){
                idPessoa = Integer.parseInt(idPessoaStr);
            }

            int idPessoaPf = 0;
            if(idPessoaPFStr != null && !idPessoaPFStr.equals("") && (idPessoaPFStr.matches("[0-9]*"))){
                idPessoa = Integer.parseInt(idPessoaPFStr);
            }

            loginSenha = new LoginSenha();
            loginSenha.setUsuario_Login(login);
            loginSenha.setSenha_Login(password);
            loginSenha.setPermissao(permissao.name());
            loginSenha.setId_Pessoa(idPessoa);
            loginSenha.setId_PessoaPF(idPessoaPf);

            loginSenhaDAO.inserir(loginSenha);
            Alerts.showAlert("Login salvo", null, "Novo login salvo com sucesso!", Alert.AlertType.CONFIRMATION);
            FXMLLogiListController.instantiationLoginList.updateTableView();
        } catch (SQLException throwables) {
            Alerts.showAlert("Erro inesperado", "Erro ao tentar salvar usuario", throwables.getCause().getMessage(), Alert.AlertType.ERROR);
            throwables.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
            Alerts.showAlert("Erro inesperado", "Erro ao tentar salvar usuario", e.getCause().getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    public void cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
