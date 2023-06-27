package com.imob.model.dao;

import com.imob.model.domain.Estados;
import com.imob.model.domain.ImovelUrbano;
import javafx.scene.control.TableView;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImoveisUrbanosDAO {

    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public boolean inserir(ImovelUrbano imoveisUrbano) {
        String sql = "INSERT INTO tb_imovel_urbano (id_Imovel_U, numero_Iptu, area_Construida, quant_Banheiros, quant_Dormitorios, quant_Salas, tem_Garagem, quant_Vagas_Carro, tem_Edicula, tem_Churrasqueira, tb_imovel_geral_id_Imovel) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, imoveisUrbano.getId_Imovel_U());
            stmt.setString(2, imoveisUrbano.getNumero_Iptu());
            stmt.setInt(3, imoveisUrbano.getArea_Construida());
            stmt.setInt(4, imoveisUrbano.getQuant_Banheiros());
            stmt.setInt(5, imoveisUrbano.getQuant_Dormitorios());
            stmt.setInt(6, imoveisUrbano.getQuant_Salas());
            stmt.setString(7, imoveisUrbano.getTem_Garagem());
            stmt.setInt(8, imoveisUrbano.getQuant_Vagas_Carro());
            stmt.setString(9, imoveisUrbano.getTem_Edicula());
            stmt.setString(10, imoveisUrbano.getTem_Churrasqueira());
            stmt.setInt(11, imoveisUrbano.getId_imovel_geral());

            stmt.execute();

            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;
        }

    }

    public boolean alterar(ImovelUrbano imoveisUrbano) {
        {
            String sql = "UPDATE tb_imovel_urbano SET numero_Iptu = ?, area_Construida = ?, quant_Banheiros = ?, quant_Dormitorios = ?, quant_Salas = ?, tem_Garagem = ?, quant_Vagas_Carro = ?, tem_Edicula = ?, tem_Churrasqueira = ? WHERE id_Imovel_U = ?";

            try {

                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, imoveisUrbano.getNumero_Iptu());
                stmt.setInt(2, imoveisUrbano.getArea_Construida());
                stmt.setInt(3, imoveisUrbano.getQuant_Banheiros());
                stmt.setInt(4, imoveisUrbano.getQuant_Dormitorios());
                stmt.setInt(5, imoveisUrbano.getQuant_Salas());
                stmt.setString(6, imoveisUrbano.getTem_Garagem());
                stmt.setInt(7, imoveisUrbano.getQuant_Vagas_Carro());
                stmt.setString(8, imoveisUrbano.getTem_Edicula());
                stmt.setString(9, imoveisUrbano.getTem_Churrasqueira());
                stmt.setInt(10, imoveisUrbano.getId_Imovel_U());

                System.out.println("UPDATE ID: " + imoveisUrbano.getId_Imovel_U());

                stmt.execute();

                return true;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados no banco de dados: " + e.getMessage());
                return false;
            }

        }
    }

    public boolean remover(ImovelUrbano imoveisUrbanos) {
        String sql = "DELETE FROM tb_imovel_urbano WHERE id_Imovel_U = ?";

        try {
            System.out.println("DELETE ID: " + imoveisUrbanos.getId_Imovel_U());
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, imoveisUrbanos.getId_Imovel_U());

            stmt.execute();

            return true;

        } catch (SQLException e) {
            //System.err.println("Erro ao remover dados do banco de dados: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + e.getMessage());
            return false;
        }
    }

    public List<ImovelUrbano> lista()
    {
        String sql = "SELECT * FROM tb_imovel_urbano";

        List<ImovelUrbano> retorno = new ArrayList<>();

        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();

            while(resultado.next())
            {
                ImovelUrbano imovelUrbano = new ImovelUrbano();
                imovelUrbano.setId_Imovel_U(resultado.getInt("id_Imovel_U"));
                imovelUrbano.setNumero_Iptu(resultado.getString("numero_Iptu"));
                imovelUrbano.setArea_Construida(resultado.getInt("area_Construida"));
                imovelUrbano.setQuant_Banheiros(resultado.getInt("quant_Banheiros"));
                imovelUrbano.setQuant_Dormitorios(resultado.getInt("quant_Dormitorios"));
                imovelUrbano.setQuant_Salas(resultado.getInt("quant_Salas"));
                imovelUrbano.setTem_Garagem(resultado.getString("tem_Garagem"));
                imovelUrbano.setQuant_Vagas_Carro(resultado.getInt("quant_Vagas_Carro"));
                imovelUrbano.setTem_Edicula(resultado.getString("tem_Edicula"));
                imovelUrbano.setTem_Churrasqueira(resultado.getString("tem_Churrasqueira"));
                imovelUrbano.setId_imovel_geral(resultado.getInt("tb_imovel_geral_id_Imovel"));

                retorno.add(imovelUrbano);
            }

        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

        }

        return retorno;

    }


}
