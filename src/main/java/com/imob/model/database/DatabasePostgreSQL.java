
package com.imob.model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author
 */
public class DatabasePostgreSQL {
    
     private Connection connection;
    
    public Connection conectar()
    {
        try
        {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection("jdbc:postgresql://", "usuario", "senha");
            return this.connection;
            
        }
        catch(SQLException | ClassNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível conectar ao banco MySql: " + ex);
            return null;
        }
    }
    
    public Connection desconectar(Connection connection)
    {
        try
        {
            connection.close();
            
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Não foi possível desconectar do banco MySql: " + ex);
            return null;
        }
        return null;
    }
    
}
