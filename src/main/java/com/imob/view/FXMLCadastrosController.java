package com.imob.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author
 */
public class FXMLCadastrosController implements Initializable {

    @FXML
    private Button btnCadCliPF;
    @FXML
    private Button btnCadImoUr;
    @FXML
    private Button btnCadCliPJ;
    @FXML
    private Button btnCadImovRu;
    @FXML
    private Button btnCadCorretor;
    @FXML
    private Button btnCadImobiliaria;
    @FXML
    private Button btnCadFuncionairo;
    @FXML
    private Button btnCadPrestServ;
    @FXML
    private Button btnCadLogin;
    @FXML
    private Button btnCadLog;
    @FXML
    private Button btnCadBairro;
    @FXML
    private Button btnCadCidade;
    @FXML
    private Button btnCadEstado;
    @FXML
    private Button btnTeste;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML//método para abrir o FXMLCadPF
    private void abrirFXMLCadPF(ActionEvent event)
    {
        try
        {
            Stage stage = new Stage();

            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadPessoaFisica.fxml"));

            Scene scene = new Scene(root);
            
            //para retirar todos os botões de minimizar, maximizar e fechar
            stage.initStyle(StageStyle.UNDECORATED);

            stage.setScene(scene);

            stage.show();//abria a stage

        } 
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

    @FXML
    private void abrirFXMLCadEstados(ActionEvent event) {
        
         try
        {
            Stage stageCadEstados = new Stage();

            Parent rootCadEstados = FXMLLoader.load(getClass().getResource("FXMLCadEstados.fxml"));

            Scene sceneCadEstados = new Scene(rootCadEstados);
            
            //para retirar todos os botões de minimizar, maximizar e fechar
            stageCadEstados.initStyle(StageStyle.UNDECORATED);

            stageCadEstados.setScene(sceneCadEstados);

            stageCadEstados.show();//abria a stage

        } 
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirFXMLCadLogin(ActionEvent event) {

        try {
            Stage stageCadLogin = new Stage();

            Parent rootCadLogin = FXMLLoader.load(getClass().getResource("FXMLLoginList.fxml"));

            Scene sceneCadLogin = new Scene(rootCadLogin);

            //para retirar todos os botões de minimizar, maximizar e fechar
            stageCadLogin.initStyle(StageStyle.UNDECORATED);

            stageCadLogin.setScene(sceneCadLogin);

            stageCadLogin.show();//abria a stage

        }
        catch (IOException ex) {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirFXMLCadCidades(ActionEvent event) {
        
         try
        {
            Stage stageCadCidades = new Stage();

            Parent rootCadCidades = FXMLLoader.load(getClass().getResource("FXMLCidades.fxml"));

            Scene sceneCadCidades = new Scene(rootCadCidades);
            
            //para retirar todos os botões de minimizar, maximizar e fechar
            stageCadCidades.initStyle(StageStyle.UNDECORATED);

            stageCadCidades.setScene(sceneCadCidades);

            stageCadCidades.show();//abria a stage

        } 
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirFXMLCadLogradouros(ActionEvent event) {

        try
        {
            Stage stageCadLogradouros = new Stage();

            Parent rootCadLogradouros = FXMLLoader.load(getClass().getResource("FXMLEnderecos.fxml"));

            Scene sceneCadLogradouros = new Scene(rootCadLogradouros);

            //para retirar todos os botões de minimizar, maximizar e fechar
            stageCadLogradouros.initStyle(StageStyle.UNDECORATED);

            stageCadLogradouros.setScene(sceneCadLogradouros);

            stageCadLogradouros.show();//abria a stage

        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirFXMLImoveisRurais(ActionEvent event){
        try
        {

            Stage stageCadImoveisRu = new Stage();

            Parent rootCadImoveisRu = FXMLLoader.load(getClass().getResource("FXMLCadImoveisRurais.fxml"));

            Scene sceneCadImoveisRu = new Scene(rootCadImoveisRu);

            //para retirar todos os botões de minimizar, maximizar e fechar
            stageCadImoveisRu.initStyle(StageStyle.UNDECORATED);

            stageCadImoveisRu.setScene(sceneCadImoveisRu);

            stageCadImoveisRu.show();//abria a stage
        }catch (IOException ex){
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void abrirFXMLImoveisUrbanos(ActionEvent event){
        try
        {

            Stage stageCadImoveisUrbanos = new Stage();

            Parent rootCadImoveisUrbanos = FXMLLoader.load(getClass().getResource("FXMLCadImoveisUrbanos.fxml"));

            Scene sceneCadImoveisUrbanos = new Scene(rootCadImoveisUrbanos);

            //para retirar todos os botões de minimizar, maximizar e fechar
            stageCadImoveisUrbanos.initStyle(StageStyle.UNDECORATED);

            stageCadImoveisUrbanos.setScene(sceneCadImoveisUrbanos);

            stageCadImoveisUrbanos.show();//abria a stage
        }catch (IOException ex){
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//
    @FXML
    private void abrirFXMLTeste(ActionEvent event){
        try
        {
            Stage stageCadCidades = new Stage();

            Parent rootCadCidades = FXMLLoader.load(getClass().getResource("FXMLTeste.fxml"));

            Scene sceneCadCidades = new Scene(rootCadCidades);

            //para retirar todos os botões de minimizar, maximizar e fechar
            stageCadCidades.initStyle(StageStyle.UNDECORATED);

            stageCadCidades.setScene(sceneCadCidades);

            stageCadCidades.show();//abria a stage
        }catch (IOException ex){
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void abrirFXMLImobiliaria(ActionEvent event) {
        try {
            Stage stageImobiliaria = new Stage();
            Parent rootImobiliaria = FXMLLoader.load(getClass().getResource("FXMLImobiliariaController.fxml"));
            Scene sceneImobiliaria = new Scene(rootImobiliaria);

            // Para remover todos os botões de minimizar, maximizar e fechar
            stageImobiliaria.initStyle(StageStyle.UNDECORATED);

            stageImobiliaria.setScene(sceneImobiliaria);
            stageImobiliaria.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLCadastrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    private void abrirFXMLCorretor(ActionEvent event) {
        try {
            Stage stageCorretor = new Stage();
            Parent rootCorretor = FXMLLoader.load(getClass().getResource("FXMLCadCorretorController.fxml"));
            Scene sceneCorretor = new Scene(rootCorretor);

            // Para remover todos os botões de minimizar, maximizar e fechar
            stageCorretor.initStyle(StageStyle.UNDECORATED);

            stageCorretor.setScene(sceneCorretor);
            stageCorretor.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMLCadastrosController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}