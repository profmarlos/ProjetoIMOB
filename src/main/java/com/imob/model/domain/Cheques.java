
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class Cheques extends Pagamentos {
 
    //atributos
    private int id_Cheque;
    private int id_Codigo_Cheque;
    private String banco;
    private int id_Cliente;
    private String numero_Cheque;
    private String referente_a_pagamento_de;
    private String anotacoes;
    private String a_Vista;
    private String parcelado;
    private String qunatidade_vezes;
    private String compensado;
    private Date data_Cheque;
    private Date data_Recibimento;
    private Date data_Abertura_Conta;
    
    //get e set

    public int getId_Cheque() {
        return id_Cheque;
    }

    public void setId_Cheque(int id_Cheque) {
        this.id_Cheque = id_Cheque;
    }

    public int getId_Codigo_Cheque() {
        return id_Codigo_Cheque;
    }

    public void setId_Codigo_Cheque(int id_Codigo_Cheque) {
        this.id_Codigo_Cheque = id_Codigo_Cheque;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public int getId_Cliente() {
        return id_Cliente;
    }

    public void setId_Cliente(int id_Cliente) {
        this.id_Cliente = id_Cliente;
    }

    public String getNumero_Cheque() {
        return numero_Cheque;
    }

    public void setNumero_Cheque(String numero_Cheque) {
        this.numero_Cheque = numero_Cheque;
    }

    public String getReferente_a_pagamento_de() {
        return referente_a_pagamento_de;
    }

    public void setReferente_a_pagamento_de(String referente_a_pagamento_de) {
        this.referente_a_pagamento_de = referente_a_pagamento_de;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getA_Vista() {
        return a_Vista;
    }

    public void setA_Vista(String a_Vista) {
        this.a_Vista = a_Vista;
    }

    public String getParcelado() {
        return parcelado;
    }

    public void setParcelado(String parcelado) {
        this.parcelado = parcelado;
    }

    public String getQunatidade_vezes() {
        return qunatidade_vezes;
    }

    public void setQunatidade_vezes(String qunatidade_vezes) {
        this.qunatidade_vezes = qunatidade_vezes;
    }

    public String getCompensado() {
        return compensado;
    }

    public void setCompensado(String compensado) {
        this.compensado = compensado;
    }

    public Date getData_Cheque() {
        return data_Cheque;
    }

    public void setData_Cheque(Date data_Cheque) {
        this.data_Cheque = data_Cheque;
    }

    public Date getData_Recibimento() {
        return data_Recibimento;
    }

    public void setData_Recibimento(Date data_Recibimento) {
        this.data_Recibimento = data_Recibimento;
    }

    public Date getData_Abertura_Conta() {
        return data_Abertura_Conta;
    }

    public void setData_Abertura_Conta(Date data_Abertura_Conta) {
        this.data_Abertura_Conta = data_Abertura_Conta;
    }
    
    
    
}
