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
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class FXMLTelaPrincipalController implements Initializable {
    @FXML
    private AnchorPane apPrincipal;
    @FXML
    private AnchorPane apMenuEsquerdo;
    @FXML
    private VBox vbMenuDireito;
    @FXML
    private ImageView imgLogotipo;
    @FXML
    private Button btnHome;
    @FXML
    private AnchorPane apMenuDireito;
    @FXML
    private Button btnAtendimentos;
    @FXML
    private Button btnAgendamentos;
    @FXML
    private Button btnCadastros;
    @FXML
    private Button btnPesquisas;
    @FXML
    private Button btnRelatorios;
    @FXML
    private Button btnPagamentos;
    @FXML
    private Button btnSair;



    /**
     * Initializes the controller class. Método de inicialização do FXMLTelaPrincipal
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        abrirComHome();
    }

    @FXML//método vai abrir home ou FXMLHome.fxml dentro do apMenuEsquerdo
    private void abrirHome(ActionEvent event)
    {
        abrirComHome();

    }

    //método para inicializar o FXMLTelaPrincipal com o FXMLHome ativo
    //ou seja, para abrir o programa na tela home
    public void abrirComHome()
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLHome.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            apMenuDireito.getChildren().setAll(a);
            corBotaoSelecionado(" #9a0000", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A");

        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML//método vai abrir home ou FXMLAtendimentos.fxml dentro do apMenuEsquerdo
    private void AbrirAtendimentos(ActionEvent event)
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLAtendimentos.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            apMenuDireito.getChildren().setAll(a);
            corBotaoSelecionado(" #2A2A2A", " #9a0000", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A");

        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML//método vai abrir home ou FXMLAgendamentos.fxml dentro do apMenuEsquerdo
    private void abrirAgendamentos(ActionEvent event)
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLAgendamentos.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            apMenuDireito.getChildren().setAll(a);
            corBotaoSelecionado(" #2A2A2A", " #2A2A2A", " #9a0000", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A");


        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
        btnAgendamentos.getStylesheets().add("-fx-background-color: green");
    }

    @FXML//método vai abrir home ou FXMLCadastros.fxml dentro do apMenuEsquerdo
    private void abrirCadastros(ActionEvent event)
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLCadastros.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            apMenuDireito.getChildren().setAll(a);
            corBotaoSelecionado(" #2A2A2A", " #2A2A2A", " #2A2A2A", " #9a0000", " #2A2A2A", " #2A2A2A", " #2A2A2A");

        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML//método vai abrir home ou FXMLPesquisas.fxml dentro do apMenuEsquerdo
    private void abrirPesquisas(ActionEvent event)
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLPesquisas.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            apMenuDireito.getChildren().setAll(a);
            corBotaoSelecionado(" #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #9a0000", " #2A2A2A", " #2A2A2A");

        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML//método vai abrir home ou FXMLRelatorios.fxml dentro do apMenuEsquerdo
    private void abrirRelatorios(ActionEvent event)
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLRelatorios.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            apMenuDireito.getChildren().setAll(a);
            corBotaoSelecionado(" #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #9a0000", " #2A2A2A");

        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML//método vai abrir home ou FXMLPagamentos.fxml dentro do apMenuEsquerdo
    private void abrirPagamentos(ActionEvent event)
    {
        try
        {
            //colocando no objeto a o FXMLMDI01
            AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("FXMLPagamentos.fxml"));
            //deixar o AnchorPane FXMLMID02 fluido ou ancorado em todos os lados
            AnchorPane.setTopAnchor(a, 0.0);
            AnchorPane.setLeftAnchor(a, 0.0);
            AnchorPane.setRightAnchor(a, 0.0);
            AnchorPane.setBottomAnchor(a, 0.0);
            //chamar dentro do apMenuEsquerdo o FXMLMDI01
            apMenuDireito.getChildren().setAll(a);
            corBotaoSelecionado(" #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #2A2A2A", " #9a0000");


        }
        catch (IOException ex)
        {
            Logger.getLogger(FXMLTelaPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //método para mudar a cor do botão selecionado
    public void corBotaoSelecionado(String btnH, String btnAt, String btnAg, String btnCa, String btnPe,
                                    String btnRe, String btnPa)
    {
        btnHome.setStyle("-fx-background-color:" + btnH + ";");
        btnAtendimentos.setStyle("-fx-background-color:" + btnAt + ";");
        btnAgendamentos.setStyle("-fx-background-color:" + btnAg + ";");
        btnCadastros.setStyle("-fx-background-color:" + btnCa + ";");
        btnPesquisas.setStyle("-fx-background-color:" + btnPe + ";");
        btnRelatorios.setStyle("-fx-background-color:" + btnRe + ";");
        btnPagamentos.setStyle("-fx-background-color:" + btnPa + ";");
    }

    @FXML//botaão que fehcar a aplicação
    private void fecharAplicacao(ActionEvent event)
    {
        System.exit(0);
    }


}
