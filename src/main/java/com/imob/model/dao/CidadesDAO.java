package com.imob.model.dao;

import com.imob.model.domain.Cidades;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class CidadesDAO {

        private Connection connection;

        public CidadesDAO(Connection connection) {
                this.connection = this.connection;
        }

        public Connection getConnection() {
            return connection;
        }

        public void setConnection(Connection connection) {
            this.connection = connection;
        }



        // Construtor


        // Método para inserir uma nova cidade no banco de dados
        public boolean inserirCidades(Cidades cidade) throws SQLException {
            String sql = "INSERT INTO tb_cidades (id_Cidades, nome_Cidades, id_Estado) VALUES (?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, cidade.getId_Cidades());
                statement.setString(2, cidade.getNome_Cidades());
                statement.setInt(3, cidade.getId_Estado());

                statement.executeUpdate();
                return true;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
                return false;
            }
        }
        // Método para atualizar uma cidade existente no banco de dados
        public void atualizarCidades(Cidades cidade) throws SQLException {
            String sql = "UPDATE cidade SET nome_Cidades = ?, id_Estado = ? WHERE id_Cidades = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, cidade.getNome_Cidades());
                statement.setInt(2, cidade.getId_Estado());
                statement.setInt(3, cidade.getId_Cidades());

                statement.executeUpdate();
            }
        }

        // Método para excluir uma cidade do banco de dados
        public void excluirCidade(TextField id_Cidades) throws SQLException {
            String sql = "DELETE FROM cidade WHERE id_Cidades = ?";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, id_Cidades);
                statement.executeUpdate();
            }
        }

        // Método para buscar todas as cidades do banco de dados
        public List<Cidades> buscarTodasCidades() throws SQLException {
            List<Cidades> cidades = new ArrayList<>();
            String sql = "SELECT * FROM cidade";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    int id_Cidades = resultSet.getInt("id_Cidades");
                    String nome_Cidades = resultSet.getString("nome_Cidades");
                    int id_Estado = resultSet.getInt("id_Estado");

                    Cidades cidade = new Cidades(id_Cidades, nome_Cidades, id_Estado);
                    cidades.add(cidade);
                }
            }

            return cidades;
        }
    }

