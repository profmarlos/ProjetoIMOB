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

    public char[] getIdCorretor() {
        return String.valueOf(id_Corretor).toCharArray();
    }

    public char[] getCodigoCorretor() {
        return String.valueOf(id_Codigo_Corretor).toCharArray();
    }

    public char[] getNumeroCreci() {
        return String.valueOf(numero_Creci).toCharArray();
    }

    public void setTb_pessoa_fisica_id_PessoaPF(int parseInt) {
    }

    public void setTb_pessoa_fisica_tb_pessoa_id_Pessoa(int parseInt) {
    }

    public void setTb_pagamento_comissao_id_Pag_Comissao(int parseInt) {
    }

    public int getTb_pessoa_fisica_id_PessoaPF() {
        return 0;
    }

    public int getTb_pessoa_fisica_tb_pessoa_id_Pessoa() {
        return 0;
    }

    public int getTb_pagamento_comissao_id_Pag_Comissao() {
        return 0;
    }
}
