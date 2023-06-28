package com.imob.model.dao;

import com.imob.model.domain.Imobiliaria;
import javafx.scene.control.TableView;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImobiliariaDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }


    public boolean inserir(Imobiliaria imobiliarias) {

        String sql = "INSERT INTO tb_imobiliaria (id_Codigo_imobiliaria, numero_Creci, id_Imobiliaria, tb_pessoa_juridica_id_PessoaPJ, tb_pessoa_juridica_tb_pessoa_id_Pessoa, tb_pagamento_comissao_id_Pag_Comissao) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, imobiliarias.getId_Codigo_imobiliaria());
            stmt.setInt(2, imobiliarias.getNumero_Creci());
            stmt.setInt(3, imobiliarias.getId_Imobiliaria());
            stmt.setInt(4, imobiliarias.getTb_pessoa_juridica_id_PessoaPJ());
            stmt.setInt(5, imobiliarias.getTb_pessoa_juridica_tb_pessoa_id_Pessoa());
            stmt.setInt(6, imobiliarias.getTb_pagamento_comissao_id_Pag_Comissao());
            stmt.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }
    }

    public boolean alterar(Imobiliaria imobiliarias) {

        String sql = "UPDATE tb_imobiliaria SET id_Codigo_imobiliaria = ?, numero_Creci = ?, tb_pessoa_juridica_id_PessoaPJ = ?, tb_pessoa_juridica_tb_pessoa_id_Pessoa = ?, tb_pagamento_comissao_id_Pag_Comissao = ? WHERE id_Imobiliaria = ?";

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, imobiliarias.getId_Codigo_imobiliaria());
            stmt.setInt(2, imobiliarias.getNumero_Creci());
            stmt.setInt(3, imobiliarias.getTb_pessoa_juridica_id_PessoaPJ());
            stmt.setInt(4, imobiliarias.getTb_pessoa_juridica_tb_pessoa_id_Pessoa());
            stmt.setInt(5, imobiliarias.getTb_pagamento_comissao_id_Pag_Comissao());
            stmt.setInt(6, imobiliarias.getId_Imobiliaria());
            System.out.println("UPDATE ID: " + imobiliarias.getId_Imobiliaria());


            stmt.execute();

            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage());
            return false;
        }
    }


    public boolean remover(Imobiliaria imobiliarias) {
        String sql = "DELETE FROM tb_imobiliaria WHERE id_Imobiliaria = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            System.out.println("DELETE ID: " + imobiliarias.getId_Imobiliaria());
            stmt.setInt(1, imobiliarias.getId_Imobiliaria());

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + e.getMessage());
            return false;
        }
    }

    public List<Imobiliaria> lista() {
        String sql = "SELECT * FROM tb_imobiliaria";

        List<Imobiliaria> retorno = new ArrayList<>();

        try {

            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next())
            {
                Imobiliaria imobiliarias = new Imobiliaria();
                imobiliarias.setId_Imobiliaria(rs.getInt("id_Codigo_imobiliaria"));
                imobiliarias.setNumero_Creci(rs.getInt("numero_Creci"));
                imobiliarias.setId_Imobiliaria(rs.getInt("id_Imobiliaria"));
                imobiliarias.setTb_pessoa_juridica_id_PessoaPJ(rs.getInt("tb_pessoa_juridica_id_PessoaPJ"));
                imobiliarias.setTb_pessoa_juridica_tb_pessoa_id_Pessoa(rs.getInt("tb_pessoa_juridica_tb_pessoa_id_Pessoa"));
                imobiliarias.setTb_pagamento_comissao_id_Pag_Comissao(rs.getInt("tb_pagamento_comissao_id_Pag_Comissao"));

                retorno.add(imobiliarias);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

        }

        return retorno;
    }
}