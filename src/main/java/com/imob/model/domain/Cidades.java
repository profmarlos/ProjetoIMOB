
package com.imob.model.domain;

import javafx.scene.control.TextField;

/**
 *
 * @author
 */
public class Cidades extends Estados {
   
    //atributos
    private int id_Cidades;
    private String nome_Cidades;
    private int id_Estado;
    // Getters e Setters
    public int getId_Cidades() {

        return id_Cidades;
    }

    public void setId_Cidades(int id_Cidades) {

        this.id_Cidades = id_Cidades;
    }

    public String getNome_Cidades() {

        return nome_Cidades;
    }

    public void setNome_Cidades(String nome_Cidades) {

        this.nome_Cidades = nome_Cidades;
    }

    public int getId_Estado() {

        return id_Estado;
    }

    public void setId_Estado(int id_Estado) {

        this.id_Estado = id_Estado;
    }

    //Construtor com erro(Sem motivo para existir)
   /* public Cidades(int id_Cidades, String nome_Cidades, int id_Estado) {
        this.id_Cidades = id_Cidades;
        this.nome_Cidades = nome_Cidades;
        this.id_Estado = id_Estado;
    }

    public Cidades(TextField idCodCidade, TextField idCidade, TextField idEstado) {

    }

    public Cidades() {

    }*/


}
