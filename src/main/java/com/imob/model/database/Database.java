
package com.imob.model.database;

import java.sql.Connection;

/**
 *
 * @author
 */
public interface Database {
    //método de conexão
    public Connection conectar();
    //método de desconectar
    public void desconectar(Connection conn);

}
