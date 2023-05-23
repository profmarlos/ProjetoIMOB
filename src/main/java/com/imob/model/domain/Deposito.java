
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class Deposito extends Pagamentos{
    
    //atributos
    private int id_Deposito;
    private int id_Codigo_Deposito;
    private int id_Cliente;
    private Date data_Deposito;
    private String codigo_Identificacao;
    private double valor_Depositado;
    private String tipo_Deposito;
    private String anotacoes;
    private String confirmacao_deposito;
    private String deposito_realizado;
    
    //get e set

    public int getId_Deposito() {
        return id_Deposito;
    }

    public void setId_Deposito(int id_Deposito) {
        this.id_Deposito = id_Deposito;
    }

    public int getId_Codigo_Deposito() {
        return id_Codigo_Deposito;
    }

    public void setId_Codigo_Deposito(int id_Codigo_Deposito) {
        this.id_Codigo_Deposito = id_Codigo_Deposito;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public Date getData_Deposito() {
        return data_Deposito;
    }

    public void setData_Deposito(Date data_Deposito) {
        this.data_Deposito = data_Deposito;
    }

    public String getCodigo_Identificacao() {
        return codigo_Identificacao;
    }

    public void setCodigo_Identificacao(String codigo_Identificacao) {
        this.codigo_Identificacao = codigo_Identificacao;
    }

    public double getValor_Depositado() {
        return valor_Depositado;
    }

    public void setValor_Depositado(double valor_Depositado) {
        this.valor_Depositado = valor_Depositado;
    }

    public String getTipo_Deposito() {
        return tipo_Deposito;
    }

    public void setTipo_Deposito(String tipo_Deposito) {
        this.tipo_Deposito = tipo_Deposito;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getConfirmacao_deposito() {
        return confirmacao_deposito;
    }

    public void setConfirmacao_deposito(String confirmacao_deposito) {
        this.confirmacao_deposito = confirmacao_deposito;
    }

    public String getDeposito_realizado() {
        return deposito_realizado;
    }

    public void setDeposito_realizado(String deposito_realizado) {
        this.deposito_realizado = deposito_realizado;
    }
    
            
            
}
