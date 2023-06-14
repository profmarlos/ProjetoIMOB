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
        String sql = "INSERT INTO tb_imovel_rural (numeto_Itr, numero_Incra, tb_imovel_geral_id_Imovel) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, imoveisRurais.getNumeto_Itr());
            stmt.setString(2, imoveisRurais.getNumero_Incra());
            stmt.setInt(3, imoveisRurais.getId_Imovel_R());

            stmt.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }

    }

    public void alterar(ImovelRural imoveisRurais) {
        {
            String sql = "UPDATE tb_imovel_rural (numeto_Itr, numero_Incra) VALUES (?, ?)";

            try {

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, imoveisRurais.getNumeto_Itr());

                stmt.execute();

                connection.close();
            } catch (SQLException e) {
                System.err.println("Erro ao atualizar dados no banco de dados: " + e.getMessage());
            }

        }
    }

    public void remover(ImovelRural imoveisRurais) {
        String sql = "DELETE tb_imovel_rural (numeto_Itr, numero_Incra) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, imoveisRurais.getNumeto_Itr());
            stmt.setString(2, imoveisRurais.getNumero_Incra());
            stmt.execute();

            connection.close();
        } catch (SQLException e) {
            System.err.println("Erro ao remover dados do banco de dados: " + e.getMessage());
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
                imovelRural.setId_Imovel_R(resultado.getInt("tb_imovel_geral_id_Imovel"));

                //vamos adicionando a lista retorno
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
