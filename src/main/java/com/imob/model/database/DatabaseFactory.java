
package com.imob.model.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class DatabaseFactory {

    //método para escolher o tipo de banco de dados
    //neste caso poderá optar por mySql ou postgreSql
    public static Database getDatabase(String nome)
    {
        if(nome.equals("postgresql"))
        {
            return (Database) new DatabasePostgreSQL();
        }
        else if (nome.equals("mysql"))
        {
            return (Database) new DatabaseMySQL() {
                @Override
                public void desconectar(Connection conn) {
                    try {
                        connection.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DatabaseFactory.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            };
        }

        return null;
    }

}