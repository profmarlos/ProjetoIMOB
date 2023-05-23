
package com.imob.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import com.imob.model.domain.ClientePessoaFisica;
/**
 *
 * @author
 */
public class ClasseBaseDAO {
    
    
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
    public boolean inserir(ClientePessoaFisica clientepessoafisica)
    {
        String sql = "INSERT INTO nome_tabela () VALUES (?)";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "");
            
            stmt.execute();
            
            return true;
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível conectar do banco: " + ex);
            return false;  
        }
        
    }
    
    //método para alterar
    public boolean alterar(ClientePessoaFisica clientepessoafisica)
    {
        String sql = "UPDATE nome_tabela SET nome_campo = ? WHERE id_ = ?";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "");
            
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
    public boolean remover(ClientePessoaFisica clientepessoafisica)
    {
        String sql = "DELETE FROM nome_tabela WHERE id_ = ?";
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "");
            
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
    public List<ClientePessoaFisica> lista()
    {
        String sql = "SELECT * FROM nome_tabela";
        
        List<ClientePessoaFisica> retorno = new ArrayList<>();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultado = stmt.executeQuery();
            
            while(resultado.next())
            {
                ClientePessoaFisica clpf = new ClientePessoaFisica();
                clpf.setNome(resultado.getString("nome"));
                
                //vamos adicionando a liss retorno
                retorno.add(clpf);
            }        
                      
           
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível listar do banco: " + ex);
              
        }
        
        return retorno;
        
    }
    
    //método para buscar
    public ClientePessoaFisica buscar(ClientePessoaFisica pf)
    {
        String sql = "SELECT * FROM nome_tabela WHERE id = ?";
        
        ClientePessoaFisica retorno = new ClientePessoaFisica();
        
        try
        {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, "id_que_vai_ser_selecionado");
            
            ResultSet resultado = stmt.executeQuery();
            
            if(resultado.next())
            {
                pf.setNome(resultado.getString("nome"));
                retorno = pf;
            }
            
        }
        catch(SQLException ex)
        { 
            JOptionPane.showMessageDialog(null, "Não foi possível buscar do banco: " + ex);
             
        }
        
        return retorno;
    }
}
