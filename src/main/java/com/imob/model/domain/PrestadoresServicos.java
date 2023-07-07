
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class PrestadoresServicos{
 
    
    //atributos
    private int id_Prestador;
    private int id_Codigo_Prestador;
    private int id_Codigo_Servico;
    private String tipo_servico_prestado;
    private Date data_Inicial;
    private Date data_Final;
    private String anotacoes;
    
    //get e set

    public int getId_Prestador() {
        return id_Prestador;
    }

    public void setId_Prestador(int id_Prestador) {
        this.id_Prestador = id_Prestador;
    }

    public int getId_Codigo_Prestador() {
        return id_Codigo_Prestador;
    }

    public void setId_Codigo_Prestador(int id_Codigo_Prestador) {
        this.id_Codigo_Prestador = id_Codigo_Prestador;
    }

    public int getId_Codigo_Servico() {
        return id_Codigo_Servico;
    }

    public void setId_Codigo_Servico(int id_Codigo_Servico) {
        this.id_Codigo_Servico = id_Codigo_Servico;
    }

    public String getTipo_servico_prestado() {
        return tipo_servico_prestado;
    }

    public void setTipo_servico_prestado(String tipo_servico_prestado) {
        this.tipo_servico_prestado = tipo_servico_prestado;
    }

    public Date getData_Inicial() {
        return data_Inicial;
    }

    public void setData_Inicial(Date data_Inicial) {
        this.data_Inicial = data_Inicial;
    }

    public Date getData_Final() {
        return data_Final;
    }

    public void setData_Final(Date data_Final) {
        this.data_Final = data_Final;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    
}
