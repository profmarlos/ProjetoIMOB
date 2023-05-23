package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class PesquisaCadastral extends Emails {
    
    //atributos
    private int id_Pesquisa;
    private int id_Codigo_Pesquisa_Cadastral;
    private int codigo_Cliente;
    private Date data_pesquisa;
    private String situacao_Cadastral;
    private Date data_Proxima_Pesquisa;
    
    //criando o construtor    
    
    //get e set

    public int getId_Pesquisa() {
        return id_Pesquisa;
    }

    public void setId_Pesquisa(int id_Pesquisa) {
        this.id_Pesquisa = id_Pesquisa;
    }

    public int getId_Codigo_Pesquisa_Cadastral() {
        return id_Codigo_Pesquisa_Cadastral;
    }

    public void setId_Codigo_Pesquisa_Cadastral(int id_Codigo_Pesquisa_Cadastral) {
        this.id_Codigo_Pesquisa_Cadastral = id_Codigo_Pesquisa_Cadastral;
    }

    public int getCodigo_Cliente() {
        return codigo_Cliente;
    }

    public void setCodigo_Cliente(int codigo_Cliente) {
        this.codigo_Cliente = codigo_Cliente;
    }

    public Date getData_pesquisa() {
        return data_pesquisa;
    }

    public void setData_pesquisa(Date data_pesquisa) {
        this.data_pesquisa = data_pesquisa;
    }

    public String getSituacao_Cadastral() {
        return situacao_Cadastral;
    }

    public void setSituacao_Cadastral(String situacao_Cadastral) {
        this.situacao_Cadastral = situacao_Cadastral;
    }

    public Date getData_Proxima_Pesquisa() {
        return data_Proxima_Pesquisa;
    }

    public void setData_Proxima_Pesquisa(Date data_Proxima_Pesquisa) {
        this.data_Proxima_Pesquisa = data_Proxima_Pesquisa;
    }
    
    
}
