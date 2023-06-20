
package com.imob.model.domain;

/**
 *
 * @author 
 */
public class Bairro extends Cidades {
    
    //atributos
    private int id_Barros;
    private String nome_Bairros;
    private int id_Cidades;

    public Bairro(int id_Cidades, String nome_Cidades, int id_Estado) {
        super(id_Cidades, nome_Cidades, id_Estado);
    }

    public Bairro() {
        super(IdCodCidade, IdCidade, IdEstado);
    }

    //get e set

    public int getId_Barros() {
        return id_Barros;
    }

    public void setId_Barros(int id_Barros) {
        this.id_Barros = id_Barros;
    }

    public String getNome_Bairros() {
        return nome_Bairros;
    }

    public void setNome_Bairros(String nome_Bairros) {
        this.nome_Bairros = nome_Bairros;
    }

    public int getId_Cidades() {
        return id_Cidades;
    }

    public void setId_Cidades(int id_Cidades) {
        this.id_Cidades = id_Cidades;
    }
    
}
