
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author fschi
 */
public class Avisos {
    
    //atributos
    private int id_Aviso;
    private int id_Codigo_Aviso;
    private int id_Cliente;
    private Date data_Aviso;
    private String tipo_Aviso;
    private String assunto_Aviso;
    private String mensagem_Aviso;
    private String resposta_Aviso;
    
    //get e set 

    public int getId_Aviso() {
        return id_Aviso;
    }

    public void setId_Aviso(int id_Aviso) {
        this.id_Aviso = id_Aviso;
    }

    public int getId_Codigo_Aviso() {
        return id_Codigo_Aviso;
    }

    public void setId_Codigo_Aviso(int id_Codigo_Aviso) {
        this.id_Codigo_Aviso = id_Codigo_Aviso;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Date getData_Aviso() {
        return data_Aviso;
    }

    public void setData_Aviso(Date data_Aviso) {
        this.data_Aviso = data_Aviso;
    }

    public String getTipo_Aviso() {
        return tipo_Aviso;
    }

    public void setTipo_Aviso(String tipo_Aviso) {
        this.tipo_Aviso = tipo_Aviso;
    }

    public String getAssunto_Aviso() {
        return assunto_Aviso;
    }

    public void setAssunto_Aviso(String assunto_Aviso) {
        this.assunto_Aviso = assunto_Aviso;
    }

    public String getMensagem_Aviso() {
        return mensagem_Aviso;
    }

    public void setMensagem_Aviso(String mensagem_Aviso) {
        this.mensagem_Aviso = mensagem_Aviso;
    }

    public String getResposta_Aviso() {
        return resposta_Aviso;
    }

    public void setResposta_Aviso(String resposta_Aviso) {
        this.resposta_Aviso = resposta_Aviso;
    }
    
    
    
}
