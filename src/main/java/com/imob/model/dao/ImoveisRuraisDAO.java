package com.imob.model.dao;

import com.imob.model.domain.Estados;
import com.imob.model.domain.ImovelRural;
import javafx.scene.control.TableView;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImoveisRuraisDAO {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(ImovelRural imoveisRurais) {
        String sql = "INSERT INTO tb_imovel_rural (numeto_Itr, numero_Incra, tb_imovel_geral_id_Imovel, unidade_area_imovel_rural, area_App, area_Utilizavel, tem_Curral, tem_Casa_sede, tem_Casa_Funcionarios, tem_Represa, tem_Rio, tem_Poco) VALUES (?,?, ?, ?, ?, ?, ?, ?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, imoveisRurais.getNumeto_Itr());
            stmt.setString(2, imoveisRurais.getNumero_Incra());
            stmt.setInt(3, imoveisRurais.getId_imovel_geral());
            stmt.setString(4, imoveisRurais.getUnidade_area_imovel_rural());
            stmt.setString(5, imoveisRurais.getArea_App());
            stmt.setString(6, imoveisRurais.getArea_Utilizavel());
            stmt.setString(7, imoveisRurais.getTem_Curral());
            stmt.setString(8,imoveisRurais.getTem_Casa_sede());
            stmt.setString(9, imoveisRurais.getTem_Casa_Funcionarios());
            stmt.setString(10, imoveisRurais.getTem_Represa());
            stmt.setString(11, imoveisRurais.getTem_Rio());
            stmt.setString(12, imoveisRurais.getTem_Poco());

            stmt.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }

    }

    public boolean alterar(ImovelRural imoveisRurais) {
        {
            String sql = "UPDATE tb_imovel_rural SET numeto_Itr = ?, numero_Incra = ?, unidade_area_imovel_rural = ?, area_App = ?, area_Utilizavel = ?, tem_Curral = ?, tem_Casa_sede = ?, tem_Casa_Funcionarios = ?, tem_Represa = ?, tem_Rio = ?, tem_Poco = ?  WHERE id_Imovel_R = ?";

            try {

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, imoveisRurais.getNumeto_Itr());
                stmt.setString(2, imoveisRurais.getNumero_Incra());
                stmt.setString(3, imoveisRurais.getUnidade_area_imovel_rural());
                stmt.setString(4, imoveisRurais.getArea_App());
                stmt.setString(5, imoveisRurais.getArea_Utilizavel());
                stmt.setString(6, imoveisRurais.getTem_Curral());
                stmt.setString(7,imoveisRurais.getTem_Casa_sede());
                stmt.setString(8, imoveisRurais.getTem_Casa_Funcionarios());
                stmt.setString(9, imoveisRurais.getTem_Represa());
                stmt.setString(10, imoveisRurais.getTem_Rio());
                stmt.setString(11, imoveisRurais.getTem_Poco());
                stmt.setInt(12, imoveisRurais.getId_Imovel_R());


                System.out.println("UPDATE ID: " + imoveisRurais.getId_Imovel_R());

                stmt.execute();

                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage());
                return false;
            }

        }
    }

    public boolean remover(ImovelRural imoveisRurais) {
        String sql = "DELETE FROM tb_imovel_rural WHERE id_Imovel_R = ?";

        try {
            System.out.println("DELETE ID: " + imoveisRurais.getId_Imovel_R());
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, imoveisRurais.getId_Imovel_R());

            stmt.execute();

            return true;

        } catch (SQLException e) {
            //System.err.println("Erro ao remover dados do banco de dados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + e.getMessage());
            return false;
        }
    }

    //método para listar
    public List<ImovelRural> lista()
    {
        String sql = "SELECT * FROM tb_imovel_rural";

        List<ImovelRural> retorno = new ArrayList<>();

        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while(resultado.next())
            {
                ImovelRural imovelRural = new ImovelRural();
                imovelRural.setNumeto_Itr(resultado.getString("numeto_Itr"));
                imovelRural.setNumero_Incra(resultado.getString("numero_Incra"));
                imovelRural.setId_imovel_geral(resultado.getInt("tb_imovel_geral_id_Imovel"));
                imovelRural.setId_Imovel_R(resultado.getInt("id_Imovel_R"));
                imovelRural.setUnidade_area_imovel_rural(resultado.getString("unidade_area_imovel_rural"));
                imovelRural.setArea_App(resultado.getString("area_App"));
                imovelRural.setArea_Utilizavel(resultado.getString("area_Utilizavel"));
                imovelRural.setTem_Curral(resultado.getString("tem_Curral"));
                imovelRural.setTem_Casa_sede(resultado.getString("tem_Casa_sede"));
                imovelRural.setTem_Casa_Funcionarios(resultado.getString("tem_Casa_Funcionarios"));
                imovelRural.setTem_Represa(resultado.getString("tem_Represa"));
                imovelRural.setTem_Rio(resultado.getString("tem_Rio"));
                imovelRural.setTem_Poco(resultado.getString("tem_Poco"));


                retorno.add(imovelRural);
            }

        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

        }

        return retorno;

    }


}
