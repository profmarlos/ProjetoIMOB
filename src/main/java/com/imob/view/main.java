package com.imob.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main extends Application {
    public void start(Stage stage) throws IOException {
        conectar();
        FXMLLoader fxmlLoader = new FXMLLoader(main.class.getResource("FXMLTelaPrincipal.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();

    }

    private Connection connection;

    public Connection conectar()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_imob","root","123456");
            return this.connection;

        }
        catch(SQLException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco MySql: " + ex);
            return null;
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
