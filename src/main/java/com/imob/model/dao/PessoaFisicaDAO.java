package com.imob.model.dao;

import com.imob.model.domain.PessoaFisica;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaFisicaDAO {
    private static Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static boolean inserir(PessoaFisica pfisica) {
        String sql = "INSERT INTO tb_Pessoa_Fisica (id_PessoaPF, nome, cpf, rg, data_Nascimento, sexo, estado_Civil, naturalidade, estado_Naturalidade, escolaridade, profissao, nome_Pai, nome_Mae, tb_pessoa_id_Pessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,? ,? ,? ,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pfisica.getId_PessoaPF());
            stmt.setString(2, pfisica.getNome());
            stmt.setString(3, pfisica.getCpf());
            stmt.setString(4, pfisica.getRg());
            stmt.setDate(5, pfisica.getData_nascimento());
            stmt.setString(6, pfisica.getSexo());
            stmt.setString(7, pfisica.getEstado_Civil());
            stmt.setString(8, pfisica.getNaturalidade());
            stmt.setString(9, pfisica.getEstado_Naturalidade());
            stmt.setString(10, pfisica.getEscolaridade());
            stmt.setString(11, pfisica.getProfissao());
            stmt.setString(12, pfisica.getNome_Pai());
            stmt.setString(13, pfisica.getNome_Mae());
            stmt.setString(14, pfisica.getDia());


            stmt.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }

    }


    //método para listar
    public static List<PessoaFisica> lista()
    {
        String sql = "SELECT * FROM tb_Pessoa_Fisica";

        List<PessoaFisica> retorno = new ArrayList<>();

        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while(resultado.next())
            {
                PessoaFisica pfisica = new PessoaFisica();
                pfisica.setId_PessoaPF(resultado.getInt("Id_PessoaPF"));
                pfisica.setNome(resultado.getString("nome"));
                pfisica.setCpf(resultado.getString("cpf"));
                pfisica.setRg(resultado.getString("rg"));
                pfisica.setData_nascimento(resultado.getDate(("data_nascimento")));
                pfisica.setSexo(resultado.getString("sexo"));
                pfisica.setEstado_Civil(resultado.getString("estado_Civil"));
                pfisica.setNaturalidade(resultado.getString("naturalidade"));
                pfisica.setEstado_Naturalidade(resultado.getString("estado_Naturalidade"));
                pfisica.setEscolaridade(resultado.getString("escolaridade"));
                pfisica.setProfissao(resultado.getString("profissao"));
                pfisica.setNome_Pai(resultado.getString("nome_Pai"));
                pfisica.setNome_Mae(resultado.getString("nome_Mae"));
                pfisica.setDia(resultado.getString("tb_pessoa_id_Pessoa"));



                //vamos adicionando a lista retorno
                retorno.add(pfisica);
            }

// Gabriel Trevisan de Oliveira
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

        }

        return retorno;

    }

    public static boolean remover(PessoaFisica pfisica) {
        String sql = "DELETE FROM tb_pessoa_fisica WHERE id_PessoaPF = ?";

        try {
            System.out.println("DELETE ID: " + pfisica.getId_PessoaPF());
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, pfisica.getId_PessoaPF());

            stmt.execute();

            return true;

        } catch (SQLException e) {
            //System.err.println("Erro ao remover dados do banco de dados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + e.getMessage());
            return false;
        }
    }
    public static boolean alterar(PessoaFisica pfisica) {
        {
            String sql = "UPDATE tb_pessoa_fisica SET nome = ?, cpf = ?, rg = ?, data_nascimento = ?, sexo = ?, estado_Civil = ?, naturalidade = ?, estado_Naturalidade = ?, escolaridade = ?, profissao = ?, nome_Pai = ?, nome_Mae = ?, tb_pessoa_id_Pessoa = ? WHERE id_PessoaPF = ?";

            try {

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, pfisica.getNome());
                stmt.setString(2, pfisica.getCpf());
                stmt.setString(3, pfisica.getRg());
                stmt.setDate(4, pfisica.getData_nascimento());
                stmt.setString(5, pfisica.getSexo());
                stmt.setString(6, pfisica.getEstado_Civil());
                stmt.setString(7, pfisica.getNaturalidade());
                stmt.setString(8, pfisica.getEstado_Naturalidade());
                stmt.setString(9, pfisica.getEscolaridade());
                stmt.setString(10, pfisica.getProfissao());
                stmt.setString(11, pfisica.getNome_Pai());
                stmt.setString(12, pfisica.getNome_Mae());
                stmt.setString(13, pfisica.getDia());
                stmt.setInt(14, pfisica.getId_PessoaPF());

                System.out.println("UPDATE ID: " + pfisica.getId_PessoaPF());

                stmt.execute();

                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage());
                return false;
            }

        }
    }

}
