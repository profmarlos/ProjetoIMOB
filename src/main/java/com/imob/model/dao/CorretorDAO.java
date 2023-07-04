package com.imob.model.dao;

import com.imob.model.domain.Corretor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorretorDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(Corretor corretor) {
        String sql = "INSERT INTO tb_corretor (id_Codigo_Corretor, numero_Creci, id_Corretor) VALUES (?, ?, ?,)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, corretor.getId_Codigo_Corretor());
            stmt.setInt(2, corretor.getNumero_Creci());
            stmt.setInt(2, corretor.getId_Corretor());


            stmt.executeUpdate();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }
    }

    public boolean atualizar(Corretor corretor) {
        String sql = "UPDATE tb_corretor SET id_Codigo_Corretor = ?, numero_Creci = ?, tb_pessoa_fisica_id_PessoaPF = ?, tb_pessoa_fisica_tb_pessoa_id_Pessoa = ?, tb_pagamento_comissao_id_Pag_Comissao = ? WHERE id_Corretor = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, corretor.getId_Codigo_Corretor());
            stmt.setInt(2, corretor.getNumero_Creci());
            stmt.setInt(2, corretor.getId_Corretor());

            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage());
            return false;
        }
    }

    public boolean remover(Corretor corretor) {
        String sql = "DELETE FROM tb_corretor WHERE id_Corretor = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, corretor.getId_Corretor());

            stmt.executeUpdate();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + e.getMessage());
            return false;
        }
    }

    public List<Corretor> listar() {
        String sql = "SELECT * FROM tb_corretor";
        List<Corretor> retorno = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                Corretor corretor = new Corretor();
                corretor.setId_Corretor(resultado.getInt("id_Corretor"));
                corretor.setId_Codigo_Corretor(resultado.getInt("id_Codigo_Corretor"));
                corretor.setNumero_Creci(resultado.getInt("numero_Creci"));

                retorno.add(corretor);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);
        }

        return retorno;
    }
}
