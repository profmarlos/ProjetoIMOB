
package com.imob.model.domain;

/**
 *
 * @author
 */
public class Pessoa extends PesquisaCadastral {
    
    //atributos
    private int id_Pessoa;
    private int id_Codigo_Pessoa;
    
    //get  e set

    public int getId_Pessoa() {
        return id_Pessoa;
    }

    public void setId_Pessoa(int id_Pessoa) {
        this.id_Pessoa = id_Pessoa;
    }

    public int getId_Codigo_Pessoa() {
        return id_Codigo_Pessoa;
    }

    public void setId_Codigo_Pessoa(int id_Codigo_Pessoa) {
        this.id_Codigo_Pessoa = id_Codigo_Pessoa;
    }
    
    
}
