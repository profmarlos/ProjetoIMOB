package com.imob.model.dao;

import com.imob.model.domain.PrestadoresServicos;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrestadoresDAO {
    private static Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static boolean inserir(PrestadoresServicos prestadores) {
        String sql = "INSERT INTO tb-prestador_servicos (id_Prestador, id_Codigo_Prestador, id_Codigo_Serviço,tipo_servico_prestado, data_Inicial, data_Final, anotacoes) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, prestadores.getId_Prestador());
            stmt.setInt(2, prestadores.getId_Codigo_Prestador());
            stmt.setInt(3, prestadores.getId_Codigo_Servico());
            stmt.setString(4, prestadores.getTipo_servico_prestado());
            stmt.setDate(5, prestadores.getData_Inicial());
            stmt.setDate(6, prestadores.getData_Final());
            stmt.setString(7, prestadores.getAnotacoes());



            stmt.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }

    }


    //método para listar
    public static List<PrestadoresServicos> lista()
    {
        String sql = "SELECT * FROM tb_Pessoa_Fisica";

        List<PrestadoresServicos> retorno = new ArrayList<>();

        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while(resultado.next())
            {
                PrestadoresServicos prestadores = new PrestadoresServicos();
                prestadores.setId_Prestador(resultado.getInt("id_Prestador"));
                prestadores.setId_Codigo_Prestador(resultado.getInt("id_Codigo_Prestador"));
                prestadores.setId_Codigo_Servico(resultado.getInt("codigo_Serviço"));
                prestadores.setTipo_servico_prestado(resultado.getString("tipo_servico_prestado"));
                prestadores.setData_Inicial(resultado.getDate(("data_Inicial")));
                prestadores.setData_Final(resultado.getDate("data_Final"));
                prestadores.setAnotacoes(resultado.getString("anotacoes"));


                //vamos adicionando a lista retorno
                retorno.add(prestadores);
            }

// Gabriel Trevisan de Oliveira
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

        }

        return retorno;

    }

    public static boolean remover(PrestadoresServicos prestadores) {
        String sql = "DELETE FROM tb_pessoa_fisica WHERE id_PessoaPF = ?";

        try {
            System.out.println("DELETE ID: " + prestadores.getId_Prestador());
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, prestadores.getId_Prestador());

            stmt.execute();

            return true;

        } catch (SQLException e) {
            //System.err.println("Erro ao remover dados do banco de dados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + e.getMessage());
            return false;
        }
    }
    public static boolean alterar(PrestadoresServicos prestadores) {
        {
            String sql = "UPDATE tb-prestadores-servicos SET id_Prestador =?, id_Codigo_Prestador=?, id_Codigo_Serviço=?,tipo_servico_prestado=?, data_Inicial=?, data_Final=?, anotacoes=? WHERE id_Prestador = ?";

            try {

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setInt(1, prestadores.getId_Prestador());
                stmt.setInt(2, prestadores.getId_Codigo_Prestador());
                stmt.setInt(3, prestadores.getId_Codigo_Servico());
                stmt.setString(4, prestadores.getTipo_servico_prestado());
                stmt.setDate(5, prestadores.getData_Inicial());
                stmt.setDate(6, prestadores.getData_Final());
                stmt.setString(7, prestadores.getAnotacoes());

                System.out.println("UPDATE ID: " + prestadores.getId_Prestador());

                stmt.execute();

                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage());
                return false;
            }

        }
    }

}
