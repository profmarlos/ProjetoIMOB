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

public class FXMLAtualizaLoginController implements Initializable {
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final LoginSenhaDAO loginSenhaDAO = new LoginSenhaDAO();

    @FXML
    TextField textLogin;

    @FXML
    PasswordField textSenha;

    @FXML
    TextField textIdPessoa;

    @FXML
    TextField textIdPessoaPF;


    @FXML
    ComboBox<Permissoes> comboBoxPermissoes;
    ObservableList<Permissoes> obsListRole;

    @FXML
    Button btnSave;

    @FXML
    Button btnCancel;

    private LoginSenha loginUpdate;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        loginSenhaDAO.setConnection(connection);

        List<Permissoes> permissoesList = new ArrayList<>();
        permissoesList.add(Permissoes.ADMIN);
        permissoesList.add(Permissoes.USUARIO);
        obsListRole = FXCollections.observableArrayList(permissoesList);
        comboBoxPermissoes.setItems(obsListRole);

        loginUpdate = FXMLLogiListController.loginSelect;
        String login = loginUpdate.getUsuario_Login();
        String password = loginUpdate.getSenha_Login();
        String permissao = loginUpdate.getPermissao();
        int id_pessoa = loginUpdate.getId_Pessoa();
        int id_pessoaPF = loginUpdate.getId_PessoaPF();
        textLogin.setText(login);
        textSenha.setText(password);
        textIdPessoa.setText(String.valueOf(id_pessoa));
        textIdPessoaPF.setText(String.valueOf(id_pessoaPF));
        comboBoxPermissoes.setPromptText(permissao);
    }

    @FXML
    public void save(ActionEvent event) {
        String login = textLogin.getText();
        String password = textSenha.getText();
        String idPessoaStr = textIdPessoa.getText();
        String idPessoaPFStr = textIdPessoaPF.getText();
        Permissoes permissao = comboBoxPermissoes.getSelectionModel().getSelectedItem();
        permissao = permissao == null ? Permissoes.valueOf(loginUpdate.getPermissao()) : permissao;

        int idPessoa = 0;
        if(idPessoaStr != null && !idPessoaStr.equals("") && (idPessoaStr.matches("[0-9]*"))){
            idPessoa = Integer.parseInt(idPessoaStr);
        }

        int idPessoaPf = 0;
        if(idPessoaPFStr != null && !idPessoaPFStr.equals("") && (idPessoaPFStr.matches("[0-9]*"))){
            idPessoa = Integer.parseInt(idPessoaPFStr);
        }

        if(login.isBlank() || password.isBlank() || permissao == null){
            Alerts.showAlert("Campos Nao Preenchidos", null, "Campos Obrigatorio Nao Preenchidos!", Alert.AlertType.ERROR);
            return;
        }

        try {
            int id = loginUpdate.getId_Login();
            LoginSenha loginSenha = loginSenhaDAO.buscarPeloId(id);
            if(loginSenha == null){
                Alerts.showAlert("Login nao encontrado", null, "Login nao encontrado!", Alert.AlertType.ERROR);
                return;
            }

            if(!loginSenha.getUsuario_Login().equals(login)){
                LoginSenha loginCadastrado = loginSenhaDAO.buscarPeloLogin(login);
                if(loginCadastrado != null){
                    Alerts.showAlert("Usuario já Cadastrado", null, "Login já cadastrado, tente outro!", Alert.AlertType.ERROR);
                    return;
                }
            }


            loginSenha.setUsuario_Login(login);
            loginSenha.setSenha_Login(password);
            loginSenha.setPermissao(permissao.name());
            loginSenha.setId_Pessoa(idPessoa);
            loginSenha.setId_PessoaPF(idPessoaPf);

            loginSenhaDAO.alterar(loginSenha);
            Alerts.showAlert("Login atualizado", null, "Login atualizado com sucesso!", Alert.AlertType.CONFIRMATION);
            FXMLLogiListController.instantiationLoginList.updateTableView();
            Stage st = (Stage) btnSave.getScene().getWindow();
            st.close();
        } catch (SQLException throwables) {
            Alerts.showAlert("Erro inesperado", "Erro ao tentar salvar usuario", throwables.getCause().getMessage(), Alert.AlertType.ERROR);
            throwables.printStackTrace();
        } catch (Exception e){
            Alerts.showAlert("Erro inesperado", "Erro ao tentar salvar usuario", e.getCause().getMessage(), Alert.AlertType.ERROR);
            throw e;
        }
    }

    @FXML
    public void cancel(){
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }
}
