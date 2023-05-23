
package com.imob.model.domain;

/**
 *
 * @author
 */
public class Telefones {
    
    
    //atributos
    private int id_Telefone;
    private int id_Codigo_Telefone;
    private String tipo_Telefone;
    private String numero_Telefone;
    
    //get e set

    public int getId_Telefone() {
        return id_Telefone;
    }

    public void setId_Telefone(int id_Telefone) {
        this.id_Telefone = id_Telefone;
    }

    public int getId_Codigo_Telefone() {
        return id_Codigo_Telefone;
    }

    public void setId_Codigo_Telefone(int id_Codigo_Telefone) {
        this.id_Codigo_Telefone = id_Codigo_Telefone;
    }

    public String getTipo_Telefone() {
        return tipo_Telefone;
    }

    public void setTipo_Telefone(String tipo_Telefone) {
        this.tipo_Telefone = tipo_Telefone;
    }

    public String getNumero_Telefone() {
        return numero_Telefone;
    }

    public void setNumero_Telefone(String numero_Telefone) {
        this.numero_Telefone = numero_Telefone;
    }
            
}
