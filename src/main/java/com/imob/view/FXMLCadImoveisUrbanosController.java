package com.imob.view;
import com.imob.model.dao.ImoveisUrbanosDAO;
import com.imob.model.database.Database;
import com.imob.model.database.DatabaseFactory;
import com.imob.model.domain.ImovelRural;
import com.imob.model.domain.ImovelUrbano;
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

public class FXMLCadImoveisUrbanosController implements Initializable {

    ObservableList<String> choiceList = FXCollections.observableArrayList("Sim", "Não");

    @FXML
    private TextField textiptu;

    @FXML
    private TextField textarea;

    @FXML
    private TextField textbanheiro;

    @FXML
    private TextField textvagas;

    @FXML
    private  TextField textsala;

    @FXML
    private  TextField textdormitorios;

    @FXML
    private  TextField textidimovel;
    @FXML
    private TextField textidimovelgeral;
    @FXML
    private ChoiceBox choChurras;

    @FXML
    private ChoiceBox choGaragem;

    @FXML
    private ChoiceBox choEdicula;
    @FXML
    private Label lblFecharCadImoveisUrbanos;


    @FXML
    private TableColumn<ImovelUrbano, String> colunaid;

    @FXML
    private TableColumn<ImovelUrbano, String> colunaNumeroIPTU;

    @FXML
    private TableColumn<ImovelUrbano, String> colunaArea;

    @FXML
    private TableColumn<ImovelUrbano, String> colunaBanheiros;

    @FXML
    private TableColumn<ImovelUrbano, String> colunaDormitorios;

    @FXML
    private TableColumn<ImovelUrbano, String> colunaSalas;

    @FXML
    private TableColumn<ImovelUrbano, String> colunaTemGaragem;
    @FXML
    private TableColumn<ImovelUrbano, String> colunaVagas;

    @FXML
    private TableColumn<ImovelUrbano, String> colunaTemEdicula;
    @FXML
    private TableColumn<ImovelUrbano, String> colunaTemChurras;
    @FXML
    private TableColumn<ImovelRural, String> colunaidgeral;
    @FXML
    private TableView<ImovelUrbano> tbImoveisUrbanos;

    private List<ImovelUrbano> listImovelUrbanos;

    private ObservableList<ImovelUrbano> observableImoveisUrbanos;

    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ImoveisUrbanosDAO imoveisUrbanosDAO = new ImoveisUrbanosDAO();

    public void initialize(URL url, ResourceBundle rb) {

        imoveisUrbanosDAO.setConnection(connection);

        choChurras.setItems(choiceList);
        choGaragem.setItems(choiceList);
        choEdicula.setItems(choiceList);

        carregaImoveisUrbanosNaTableView();
        System.out.println("Controlador inicializado");
    }

    public void carregaImoveisUrbanosNaTableView() {
        colunaid.setCellValueFactory(new PropertyValueFactory<>("id_Imovel_U"));
        colunaNumeroIPTU.setCellValueFactory(new PropertyValueFactory<>("numero_Iptu"));
        colunaArea.setCellValueFactory(new PropertyValueFactory<>("area_Construida"));
        colunaBanheiros.setCellValueFactory(new PropertyValueFactory<>("quant_Banheiros"));
        colunaDormitorios.setCellValueFactory(new PropertyValueFactory<>("quant_Dormitorios"));
        colunaSalas.setCellValueFactory(new PropertyValueFactory<>("quant_Salas"));
        colunaVagas.setCellValueFactory(new PropertyValueFactory<>("quant_Vagas_Carro"));
        colunaidgeral.setCellValueFactory(new PropertyValueFactory<>("id_imovel_geral"));

        colunaTemGaragem.setCellValueFactory(new PropertyValueFactory<>("tem_Garagem"));
        colunaTemEdicula.setCellValueFactory(new PropertyValueFactory<>("tem_Edicula"));
        colunaTemChurras.setCellValueFactory(new PropertyValueFactory<>("tem_Churrasqueira"));

        listImovelUrbanos = imoveisUrbanosDAO.lista();

        observableImoveisUrbanos = FXCollections.observableArrayList(listImovelUrbanos);

        tbImoveisUrbanos.setItems(observableImoveisUrbanos);
    }

    @FXML
    private void selecionarLinhaViewTable(MouseEvent event) {

        textidimovel.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getId_Imovel_U()));
        textiptu.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getNumero_Iptu()));
        textarea.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getArea_Construida()));
        textbanheiro.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getQuant_Banheiros()));
        textdormitorios.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getQuant_Banheiros()));
        textsala.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getQuant_Salas()));
        textvagas.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getQuant_Vagas_Carro()));
        textidimovelgeral.setText(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getId_imovel_geral()));
        choGaragem.setValue(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getTem_Garagem()));
        choEdicula.setValue(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getTem_Edicula()));
        choChurras.setValue(String.valueOf(tbImoveisUrbanos.getSelectionModel().getSelectedItem().getTem_Churrasqueira()));

    }
    @FXML
    private void fecharCadImoveisUrbanos(MouseEvent event) {

        Stage st = (Stage) lblFecharCadImoveisUrbanos.getScene().getWindow();// obtem a janela atual
        st.close();//fecha a stage
    }
    @FXML
    private void inserirDadosNoBancoDados(ActionEvent event) {
        ImovelUrbano imovelUrbano = new ImovelUrbano();

        imovelUrbano.setId_Imovel_U(Integer.parseInt(textidimovel.getText()));
        imovelUrbano.setNumero_Iptu(textiptu.getText());
        imovelUrbano.setArea_Construida(Integer.parseInt(textarea.getText()));
        imovelUrbano.setQuant_Banheiros(Integer.parseInt(textbanheiro.getText()));
        imovelUrbano.setQuant_Dormitorios(Integer.parseInt(textdormitorios.getText()));
        imovelUrbano.setQuant_Salas(Integer.parseInt(textsala.getText()));
        imovelUrbano.setQuant_Vagas_Carro(Integer.parseInt(textvagas.getText()));
        imovelUrbano.setId_imovel_geral(Integer.parseInt(textidimovelgeral.getText()));
        imovelUrbano.setTem_Garagem(choGaragem.getValue().toString());
        imovelUrbano.setTem_Edicula(choEdicula.getValue().toString());
        imovelUrbano.setTem_Churrasqueira(choChurras.getValue().toString());

        String textoBanheiro = textbanheiro.getText();
        if (!isNumeroInteiroValido(textoBanheiro)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no Banheiro!");
            textbanheiro.clear();
            return;
        }

        String textoDormitorio = textdormitorios.getText();
        if (!isNumeroInteiroValido(textoDormitorio)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no Dormitório!");
            textdormitorios.clear();
            return;
        }

        String textoSala = textsala.getText();
        if (!isNumeroInteiroValido(textoSala)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido na Salas!");
            textsala.clear();
            return;
        }

        String textoVagas = textvagas.getText();
        if (!isNumeroInteiroValido(textoVagas)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido na Vagas!");
            textvagas.clear();
            return;
        }

        String textoIDimovel= textidimovel.getText();
        if (!isNumeroInteiroValido(textoIDimovel)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no ID!");
            textidimovel.clear();
            return;
        }

        String textoImovelGeralID= textidimovelgeral.getText();
        if (!isNumeroInteiroValido(textoImovelGeralID)) {
            exibirErro("Erro de validação", "Insira um número inteiro válido no Id Geral!");
            textidimovelgeral.clear();
            return;
        }
        imoveisUrbanosDAO.inserir(imovelUrbano);

        limparCampos();
        carregaImoveisUrbanosNaTableView();
    }

    @FXML
    private void deletarInformacoesNoBanco(ActionEvent event) {
        ImovelUrbano imovelUrbano = new ImovelUrbano();

        imovelUrbano.setId_Imovel_U(Integer.parseInt(textidimovel.getText()));

        imoveisUrbanosDAO.remover(imovelUrbano);


        limparCampos();

        carregaImoveisUrbanosNaTableView();
    }

    @FXML
    private void atualizarDadosNoBanco(ActionEvent event) {

        ImovelUrbano imovelUrbano = new ImovelUrbano();

        imovelUrbano.setId_Imovel_U(Integer.parseInt(textidimovel.getText()));
        imovelUrbano.setNumero_Iptu(textiptu.getText());
        imovelUrbano.setArea_Construida(Integer.parseInt(textarea.getText()));
        imovelUrbano.setQuant_Banheiros(Integer.parseInt(textbanheiro.getText()));
        imovelUrbano.setQuant_Dormitorios(Integer.parseInt(textdormitorios.getText()));
        imovelUrbano.setQuant_Salas(Integer.parseInt(textsala.getText()));
        imovelUrbano.setQuant_Vagas_Carro(Integer.parseInt(textvagas.getText()));
        imovelUrbano.setTem_Garagem(choGaragem.getValue().toString());
        imovelUrbano.setTem_Edicula(choEdicula.getValue().toString());
        imovelUrbano.setTem_Churrasqueira(choChurras.getValue().toString());

        imoveisUrbanosDAO.alterar(imovelUrbano);
        limparCampos();
        carregaImoveisUrbanosNaTableView();

    }

    public void limparCampos() {
        textidimovel.setText("");
        textiptu.setText("");
        textarea.setText("");
        textbanheiro.setText("");
        textdormitorios.setText("");
        textsala.setText("");
        textvagas.setText("");
        textidimovelgeral.setText("");
        choGaragem.setValue("");
        choEdicula.setValue("");
        choChurras.setValue("");
    }

    private boolean isNumeroInteiroValido(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void exibirErro(String titulo, String mensagem) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

}