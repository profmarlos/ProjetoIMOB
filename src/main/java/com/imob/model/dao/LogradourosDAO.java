//PACKAGES
package com.imob.model.dao;
//-------------------------DIVISOR-------------------------------

//IMPORTS
import com.imob.model.domain.Enderecos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
//-------------------------DIVISOR-------------------------------

//MAIN CLASS
public class LogradourosDAO {
    private Connection connection;

    //GET E SET DA CONEXÃO --> PROFESSOR MARLON
    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    //-------------------------DIVISOR-------------------------------

    //INSERÇÃO DE LOGRADOURO
    public boolean inserirLogradouro(Enderecos logradouro) {
        String sql = "INSERT INTO tb_endereco (tipo_Logradouro, logradouro, numero_logradouro, numero_apartamento, andar_apartamento, bloco_apartamento, complemento, cep, latitude, longitude, referencias_endereceo, tb_bairros_id_Bairros, tb_bairros_tb_cidades_id_Cidades, tb_bairros_tb_cidades_tb_estados_id_Estados, tb_cidades_id_Cidades, tb_cidades_tb_estados_id_Estados, tb_pessoa_id_Pessoa) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, logradouro.getTipo_Logradouro());
            statement.setString(2, logradouro.getLogradouro());
            statement.setString(3, logradouro.getNumero_logradouro());
            statement.setString(4, logradouro.getNumero_apartamento());
            statement.setString(5, logradouro.getAndar_apartamento());
            statement.setString(6, logradouro.getBloco_apartamento());
            statement.setString(7, logradouro.getComplemento());
            statement.setString(8, logradouro.getCep());
            statement.setString(9, logradouro.getLatitude());
            statement.setString(10, logradouro.getLongitude());
            statement.setString(11, logradouro.getReferencias_endereco());
            statement.setInt(12, logradouro.getIdBairros());
            statement.setInt(13, logradouro.getBairrosIdCidades());
            statement.setInt(14, logradouro.getBairrosIdEstados());
            statement.setInt(15, logradouro.getIdCidades());
            statement.setInt(16, logradouro.getCidadesIdEstados());
            statement.setInt(17, logradouro.getIdPessoa());

            statement.execute();

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    //-------------------------DIVISOR-------------------------------

    //ALTERAR LOGRADOURO
    public boolean alterarLogradouro(Enderecos logradouro)
    {
        String sql = "UPDATE tb_endereco SET tipo_Logradouro = ?, logradouro = ?, numero_logradouro = ?, numero_apartamento = ?, andar_apartamento = ?, bloco_apartamento = ?, complemento = ?, cep = ?, latitude = ?, longitude = ?, referencias_endereceo = ?, tb_bairros_id_Bairros = ?, tb_bairros_tb_cidades_id_Cidades = ?, tb_bairros_tb_cidades_tb_estados_id_Estados = ?, tb_cidades_id_Cidades = ?, tb_cidades_tb_estados_id_Estados = ?, tb_pessoa_id_Pessoa = ?  WHERE id_Endereco = ?";

        try
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, logradouro.getTipo_Logradouro());
            statement.setString(2, logradouro.getLogradouro());
            statement.setString(3, logradouro.getNumero_logradouro());
            statement.setString(4, logradouro.getNumero_apartamento());
            statement.setString(5, logradouro.getAndar_apartamento());
            statement.setString(6, logradouro.getBloco_apartamento());
            statement.setString(7, logradouro.getComplemento());
            statement.setString(8, logradouro.getCep());
            statement.setString(9, logradouro.getLatitude());
            statement.setString(10, logradouro.getLongitude());
            statement.setString(11, logradouro.getReferencias_endereco());
            statement.setInt(12, logradouro.getIdBairros());
            statement.setInt(13, logradouro.getBairrosIdCidades());
            statement.setInt(14, logradouro.getBairrosIdEstados());
            statement.setInt(15, logradouro.getIdCidades());
            statement.setInt(16, logradouro.getCidadesIdEstados());
            statement.setInt(17, logradouro.getIdPessoa());
            statement.setInt(18, logradouro.getId_Endereco());

            statement.execute();

            return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            return false;
        }
    }
    //-------------------------DIVISOR-------------------------------

    //REMOVER LOGRADOURO
    public boolean removerLogradouro(Enderecos logradouro)
    {
        String sql = "DELETE FROM tb_endereco WHERE id_Endereco = ?";

        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, logradouro.getId_Endereco());


            stmt.execute();

            return true;
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;
        }
    }
    //-------------------------DIVISOR-------------------------------

    //LISTAR LOGRADOUROS
    public List<Enderecos> listaLogradouros()
    {
        String sql = "SELECT * FROM tb_endereco";

        List<Enderecos> retorno = new ArrayList<>();

        try
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultado = statement.executeQuery();

            while(resultado.next())
            {
                Enderecos enderecos = new Enderecos();
                enderecos.setId_Endereco(resultado.getInt("id_Endereco"));
                enderecos.setTipo_Logradouro(resultado.getString("tipo_Logradouro"));
                enderecos.setLogradouro(resultado.getString("logradouro"));
                enderecos.setNumero_logradouro(resultado.getString("numero_logradouro"));
                enderecos.setNumero_apartamento(resultado.getString("numero_apartamento"));
                enderecos.setAndar_apartamento(resultado.getString("andar_apartamento"));
                enderecos.setBloco_apartamento(resultado.getString("bloco_apartamento"));
                enderecos.setComplemento(resultado.getString("complemento"));
                enderecos.setCep(resultado.getString("cep"));
                enderecos.setLatitude(resultado.getString("latitude"));
                enderecos.setLongitude(resultado.getString("longitude"));

                enderecos.setReferencias_endereco(resultado.getString("referencias_endereceo"));
                enderecos.setIdBairros(resultado.getInt("tb_bairros_id_Bairros"));
                enderecos.setBairrosIdCidades(resultado.getInt("tb_bairros_tb_cidades_id_Cidades"));
                enderecos.setBairrosIdEstados(resultado.getInt("tb_bairros_tb_cidades_tb_estados_id_Estados"));
                enderecos.setIdCidades(resultado.getInt("tb_cidades_id_Cidades"));
                enderecos.setCidadesIdEstados(resultado.getInt("tb_cidades_tb_estados_id_Estados"));
                enderecos.setIdPessoa(resultado.getInt("tb_pessoa_id_Pessoa"));

                //ADD LOGRADOUROS AO RETORNO (EM LISTA)
                retorno.add(enderecos);
            }


        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);

        }

        return retorno;

    }

    //-------------------------DIVISOR-------------------------------

    //BUSCAR LOGRADOURO
    public Enderecos buscarLogradouros(Enderecos logradouro)
    {
        String sql = "SELECT * FROM tb_endereco WHERE id_Endereco = ?";

        Enderecos retorno = new Enderecos();

        try
        {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, logradouro.getId_Endereco());
            statement.setString(2, logradouro.getTipo_Logradouro());
            statement.setString(3, logradouro.getLogradouro());
            statement.setString(4, logradouro.getNumero_logradouro());
            statement.setString(5, logradouro.getNumero_apartamento());
            statement.setString(6, logradouro.getAndar_apartamento());
            statement.setString(7, logradouro.getBloco_apartamento());
            statement.setString(8, logradouro.getComplemento());
            statement.setString(9, logradouro.getCep());
            statement.setString(10, logradouro.getLatitude());
            statement.setString(11, logradouro.getLongitude());
            statement.setInt(12, logradouro.getIdBairros());
            statement.setInt(13, logradouro.getBairrosIdCidades());
            statement.setInt(14, logradouro.getBairrosIdEstados());
            statement.setInt(15, logradouro.getIdCidades());
            statement.setInt(16, logradouro.getCidadesIdEstados());
            statement.setInt(17, logradouro.getIdPessoa());

            ResultSet resultado = statement.executeQuery();

            if(resultado.next())
            {
                logradouro.setId_Endereco(resultado.getInt("id_Endereco"));
                logradouro.setTipo_Logradouro(resultado.getString("tipo_Logradouro"));
                logradouro.setLogradouro(resultado.getString("logradouro"));
                logradouro.setNumero_logradouro(resultado.getString("numero_logradouro"));
                logradouro.setNumero_apartamento(resultado.getString("numero_apartamento"));
                logradouro.setAndar_apartamento(resultado.getString("andar_apartamento"));
                logradouro.setBloco_apartamento(resultado.getString("bloco_apartamento"));
                logradouro.setComplemento(resultado.getString("complemento"));
                logradouro.setCep(resultado.getString("cep"));
                logradouro.setLatitude(resultado.getString("latitude"));
                logradouro.setLongitude(resultado.getString("longitude"));
                logradouro.setReferencias_endereco(resultado.getString("referencias_endereceo"));
                logradouro.setIdBairros(resultado.getInt("tb_bairros_id_Bairros"));
                logradouro.setBairrosIdCidades(resultado.getInt("tb_bairros_tb_cidades_id_Cidades"));
                logradouro.setBairrosIdEstados(resultado.getInt("tb_bairros_tb_cidades_tb_estados_id_Estados"));
                logradouro.setIdCidades(resultado.getInt("tb_cidades_id_Cidades"));
                logradouro.setCidadesIdEstados(resultado.getInt("tb_cidades_tb_estados_id_Estados"));
                logradouro.setIdPessoa(resultado.getInt("tb_pessoa_id_Pessoa"));

                retorno = logradouro;
            }

        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar do banco: " + ex);

        }

        return retorno;
    }

}


