
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class AVista extends Pagamentos{
    
    //atributos
    private int id_Avista;
    private int id_Codigo_AVista;
    private int id_Cliente;
    
    
    //get e set

    public int getId_Avista() {
        return id_Avista;
    }

    public void setId_Avista(int id_Avista) {
        this.id_Avista = id_Avista;
    }

    public int getId_Codigo_AVista() {
        return id_Codigo_AVista;
    }

    public void setId_Codigo_AVista(int id_Codigo_AVista) {
        this.id_Codigo_AVista = id_Codigo_AVista;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }
    
}
