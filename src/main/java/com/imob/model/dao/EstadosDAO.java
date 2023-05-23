
package com.imob.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.imob.model.domain.Estados;

public class EstadosDAO
{
    private Connection connection;
    
    //get e set da conexao
    public Connection getConnection()
    {
        return connection;
    }
    
    public void setConnection(Connection connection)
    {
        this.connection = connection;
    }
    
    //método inserir
    public boolean inserir(Estados estados)
    {
        String sql = "INSERT INTO tb_estados (nome_Estado, sigla_Estado) VALUES (?, ?)";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, estados.getNome_Estado());
            stmt.setString(2, estados.getSigla_Estado());
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível inserir no banco: " + ex);
            return false;  
        }
        
    }
    
    //método para alterar
    public boolean alterar(Estados estados)
    {
        String sql = "UPDATE tb_estados SET nome_Estado = ?, sigla_Estado = ?  WHERE id_Estado = ?";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, estados.getNome_Estado());
            stmt.setString(2, estados.getSigla_Estado());
            stmt.setInt(3, estados.getId_Estado());
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível alterar do banco: " + ex);
            return false;  
        }
    }
    
    //método para remover
    public boolean remover(Estados estados)
    {
        String sql = "DELETE FROM tb_estados WHERE id_Estado = ?";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, estados.getId_Estado());
            
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível remover do banco: " + ex);
            return false;  
        }
    }
    
    //método para listar
    public List<Estados> lista()
    {
        String sql = "SELECT * FROM tb_estados";
        
        List<Estados> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Estados estados = new Estados();
                estados.setId_Estado(resultado.getInt("id_Estado"));
                estados.setNome_Estado(resultado.getString("nome_Estado"));
                estados.setSigla_Estado(resultado.getString("sigla_Estado"));
                
                //vamos adicionando a lista retorno
                retorno.add(estados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        
        return retorno;
        
    }
    
    //método para listar
    public List<Estados> listarNomeEstado()
    {
        String sql = "SELECT * FROM tb_estados";
        
        List<Estados> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                Estados estados = new Estados();
                
                estados.setNome_Estado(resultado.getString("nome_Estado"));
                
                
                //vamos adicionando a liss retorno
                retorno.add(estados);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        
        return retorno;
        
    }
    
    
    //método para buscar
    public Estados buscar(Estados estados)
    {
        String sql = "SELECT * FROM tb_estados WHERE id_Estado = ?";
        
        Estados retorno = new Estados();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, estados.getId_Estado());
            stmt.setString(2, estados.getNome_Estado());
            stmt.setString(3, estados.getSigla_Estado());
            
            
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next())
            {
                estados.setId_Estado(resultado.getInt("id_Estado"));
                estados.setNome_Estado(resultado.getString("nome_Estado"));
                estados.setSigla_Estado(resultado.getString("sigla_Estado"));
                retorno = estados;
            }
            
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível buscar do banco: " + ex);
             
        }
        
        return retorno;
    }
    
}
