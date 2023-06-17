package com.imob.model.dao;

import com.imob.model.domain.Cidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    /**
     *
     * @author
     */

    public class CidadesDAO {
        private Connection connection;

        // Construtor
        public CidadesDAO(Connection connection) {
            this.connection = connection;
        }

        // Método para inserir uma nova cidade no banco de dados
        public void inserirCidades(Cidades cidade) throws SQLException {
            String sql = "INSERT INTO cidade (id_Cidades, nome_Cidades, id_Estado) VALUES (?, ?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, cidade.getId_Cidades());
                statement.setString(2, cidade.getNome_Cidades());
                statement.setInt(3, cidade.getId_Estado());

                statement.executeUpdate();
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
        public void excluirCidade(int id_Cidades) throws SQLException {
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

