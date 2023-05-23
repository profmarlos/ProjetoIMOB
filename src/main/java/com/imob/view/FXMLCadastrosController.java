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

            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadPF.fxml"));

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
    private void abrirFXMLCadCidades(ActionEvent event) {
        
         try
        {
            Stage stageCadCidades = new Stage();

            Parent rootCadCidades = FXMLLoader.load(getClass().getResource("FXMLCadCidades.fxml"));

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
    
}
