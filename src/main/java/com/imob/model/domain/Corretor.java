
package com.imob.model.domain;

/**
 *
 * @author
 */
public class Corretor extends PessoaFisica {
    
    //atributos
    private int id_Corretor;
    private int id_Codigo_Corretor;
    private int numero_Creci;
    
    //get e set

    public int getId_Corretor() {
        return id_Corretor;
    }

    public void setId_Corretor(int id_Corretor) {
        this.id_Corretor = id_Corretor;
    }

    public int getId_Codigo_Corretor() {
        return id_Codigo_Corretor;
    }

    public void setId_Codigo_Corretor(int id_Codigo_Corretor) {
        this.id_Codigo_Corretor = id_Codigo_Corretor;
    }

    public int getNumero_Creci() {
        return numero_Creci;
    }

    public void setNumero_Creci(int numero_Creci) {
        this.numero_Creci = numero_Creci;
    }
            
    
}
