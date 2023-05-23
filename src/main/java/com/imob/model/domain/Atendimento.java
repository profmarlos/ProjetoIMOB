
package com.imob.model.domain;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author
 */
public class Atendimento {
    
    //atributos
    private int id_Atendimento;
    private int id_Codigo_Atendimento;
    private Date data_Atendimento;
    private Time hora_Atendimento;
    private String nome_Atendimento;
    private String telefone_Atendimento;
    private String anotacoes_Atendimento;
    private String status_Atendimento;
    
    
    //get e set

    public int getId_Atendimento() {
        return id_Atendimento;
    }

    public void setId_Atendimento(int id_Atendimento) {
        this.id_Atendimento = id_Atendimento;
    }

    public int getId_Codigo_Atendimento() {
        return id_Codigo_Atendimento;
    }

    public void setId_Codigo_Atendimento(int id_Codigo_Atendimento) {
        this.id_Codigo_Atendimento = id_Codigo_Atendimento;
    }

    public Date getData_Atendimento() {
        return data_Atendimento;
    }

    public void setData_Atendimento(Date data_Atendimento) {
        this.data_Atendimento = data_Atendimento;
    }

    public Time getHora_Atendimento() {
        return hora_Atendimento;
    }

    public void setHora_Atendimento(Time hora_Atendimento) {
        this.hora_Atendimento = hora_Atendimento;
    }

    public String getNome_Atendimento() {
        return nome_Atendimento;
    }

    public void setNome_Atendimento(String nome_Atendimento) {
        this.nome_Atendimento = nome_Atendimento;
    }

    public String getTelefone_Atendimento() {
        return telefone_Atendimento;
    }

    public void setTelefone_Atendimento(String telefone_Atendimento) {
        this.telefone_Atendimento = telefone_Atendimento;
    }

    public String getAnotacoes_Atendimento() {
        return anotacoes_Atendimento;
    }

    public void setAnotacoes_Atendimento(String anotacoes_Atendimento) {
        this.anotacoes_Atendimento = anotacoes_Atendimento;
    }

    public String getStatus_Atendimento() {
        return status_Atendimento;
    }

    public void setStatus_Atendimento(String status_Atendimento) {
        this.status_Atendimento = status_Atendimento;
    }
    
   
    
}
