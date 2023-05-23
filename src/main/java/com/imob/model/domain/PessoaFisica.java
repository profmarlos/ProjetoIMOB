package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class PessoaFisica extends Pessoa {
    
    //criando os atributos
    private int id_PessoaPF;
    
    private String nome;
    private String sobrenome;
    private String cpf;
    private String rg;
    private Date data_nascimento;
    private String sexo;
    private String estado_Civil;
    private String regime_Bens;
    private String naturalidade;
    private String estado_Naturalidade;
    private String escolaridade;
    private String profissao;
    private String anotacoes;
    private String nome_Pai;
    private String nome_Mae;
    private String status_Cadastro;
    
    //criando o construtor com todos os atributos
    
        
    //set e get

    public int getId_PessoaPF() {
        return id_PessoaPF;
    }

    public void setId_PessoaPF(int id_PessoaPF) {
        this.id_PessoaPF = id_PessoaPF;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_Civil() {
        return estado_Civil;
    }

    public void setEstado_Civil(String estado_Civil) {
        this.estado_Civil = estado_Civil;
    }

    public String getRegime_Bens() {
        return regime_Bens;
    }

    public void setRegime_Bens(String regime_Bens) {
        this.regime_Bens = regime_Bens;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getEstado_Naturalidade() {
        return estado_Naturalidade;
    }

    public void setEstado_Naturalidade(String estado_Naturalidade) {
        this.estado_Naturalidade = estado_Naturalidade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getNome_Pai() {
        return nome_Pai;
    }

    public void setNome_Pai(String nome_Pai) {
        this.nome_Pai = nome_Pai;
    }

    public String getNome_Mae() {
        return nome_Mae;
    }

    public void setNome_Mae(String nome_Mae) {
        this.nome_Mae = nome_Mae;
    }

    public String getStatus_Cadastro() {
        return status_Cadastro;
    }

    public void setStatus_Cadastro(String status_Cadastro) {
        this.status_Cadastro = status_Cadastro;
    }
    
    
    
}
