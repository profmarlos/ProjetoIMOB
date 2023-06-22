package com.imob.model.dao;

import com.imob.model.domain.Cidades;
import com.imob.model.domain.Estados;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class CidadesDAO extends Estados
    {

        private Connection connection;

        public Connection getConnection() {
            return connection;
        }

        public void setConnection(Connection connection) {
            this.connection = connection;
        }


        // Método para inserir uma nova cidade no banco de dados
        public boolean inserirCidades(Cidades cidade){
            String sql = "INSERT INTO tb_cidades (nome_Cidades, tb_estados_id_Estados) VALUES (?, ?)";

            try
            {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, cidade.getNome_Cidades());
                stmt.setInt(2, cidade.getId_Estado());

                stmt.execute();
                return true;

            }
            catch (SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
                return false;
            }
        }

        // Método para atualizar uma cidade existente no banco de dados
        public boolean atualizarCidades(Cidades cidade) {
            String sql = "UPDATE tb_cidades SET nome_Cidades = ?, tb_estados_id_Estados = ? WHERE id_Cidades = ?";

            try
            {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, cidade.getNome_Cidades());
                stmt.setInt(2, cidade.getId_Estado());
                stmt.setInt(3, cidade.getId_Cidades());

                stmt.execute();

                return true;
            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
                return false;
            }
        }

        // Método para excluir uma cidade do banco de dados
        public boolean excluirCidade(Cidades cidade) {
            String sql = "DELETE FROM tb_cidades WHERE id_Cidades = ?";

            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, cidade.getId_Cidades());


                stmt.execute();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + ex);
                return false;
            }

        }

        // Método para buscar todas as cidades do banco de dados
        public List<Cidades> buscarTodasCidades() {
            String sql = "SELECT * FROM tb_cidades";

            List<Cidades> retorno = new ArrayList<>();

            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();

                while (resultado.next()) {
                    Cidades cidade = new Cidades();
                    cidade.setId_Cidades(resultado.getInt("id_Cidades"));
                    cidade.setNome_Cidades(resultado.getString("nome_Cidades"));
                    cidade.setId_Estado(resultado.getInt("tb_estados_id_Estados"));

                    //vamos adicionando a lista retorno
                    retorno.add(cidade);
                }


            } catch (
                    SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

            }
            return retorno;
        }

        //método para listar
        public List<Cidades> listarNomeCidades()
        {
            String sql = "SELECT * FROM tb_cidades";

            List<Cidades> retorno = new ArrayList<>();

            try
            {
                PreparedStatement stmt = connection.prepareStatement(sql);
                ResultSet resultado = stmt.executeQuery();

                while(resultado.next())
                {
                    Cidades cidades = new Cidades();

                    cidades.setNome_Cidades(resultado.getString("nome_Cidades"));


                    //vamos adicionando a liss retorno
                    retorno.add(cidades);
                }


            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

            }

            return retorno;

        }


        //método para buscar
        public Cidades buscarCidades(Cidades cidades)
        {
            String sql = "SELECT * FROM tb_cidades WHERE id_Cidades = ?";

            Cidades retorno = new Cidades();

            try
            {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, cidades.getId_Cidades());
                stmt.setString(2, cidades.getNome_Cidades());
                stmt.setInt(3, cidades.getId_Estado());


                ResultSet resultado = stmt.executeQuery();

                if(resultado.next())
                {
                    cidades.setId_Cidades(resultado.getInt("id_Cidades"));
                    cidades.setNome_Cidades(resultado.getString("nome_Cidades"));
                    cidades.setId_Estado(resultado.getInt("tb_estados_id_Estados"));
                    retorno = cidades;
                }

            }
            catch(SQLException ex)
            {
                JOptionPane.showMessageDialog(null, "Não foi possível buscar do banco: " + ex);

            }

            return retorno;
        }

    }

