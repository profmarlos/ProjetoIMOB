package com.imob.model.dao;

import com.imob.model.domain.ImovelRural;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ImoveisRuraisDAO {
    private Connection connection;

    public Connection getConnection()
    {
        return connection;
    }

    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }

    public boolean inserir(ImovelRural imoveisRurais)
    {
        String sql = "INSERT INTO tb_imovel_rural (numeto_Itr, numero_Incra) VALUES (?, ?)";

        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, imoveisRurais.getNumeto_Itr());
            stmt.setString(2, imoveisRurais.getNumero_Incra());

            stmt.execute();

            return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }

    }
}
