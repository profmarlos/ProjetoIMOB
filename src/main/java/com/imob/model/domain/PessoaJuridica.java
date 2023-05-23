
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class PessoaJuridica extends Pessoa {
    
    
    //criando os atributos
    private int id_PessoaPJ;    
    private String razao_Social;
    private String nome_Fantasia;
    private String cnpj;
    private String inscricao_Estadual;
    private String isento_Inscricao_estadual;
    private String atividade_Principal;
    private String atividades_Secundarias;
    private Date data_Abertura;
    private String anotacoes;
    private String status_Cadastro;
    
    
    
    //get e set

    public int getId_PessoaPJ() {
        return id_PessoaPJ;
    }

    public void setId_PessoaPJ(int id_PessoaPJ) {
        this.id_PessoaPJ = id_PessoaPJ;
    }

    public String getRazao_Social() {
        return razao_Social;
    }

    public void setRazao_Social(String razao_Social) {
        this.razao_Social = razao_Social;
    }

    public String getNome_Fantasia() {
        return nome_Fantasia;
    }

    public void setNome_Fantasia(String nome_Fantasia) {
        this.nome_Fantasia = nome_Fantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricao_Estadual() {
        return inscricao_Estadual;
    }

    public void setInscricao_Estadual(String inscricao_Estadual) {
        this.inscricao_Estadual = inscricao_Estadual;
    }

    public String getIsento_Inscricao_estadual() {
        return isento_Inscricao_estadual;
    }

    public void setIsento_Inscricao_estadual(String isento_Inscricao_estadual) {
        this.isento_Inscricao_estadual = isento_Inscricao_estadual;
    }

    public String getAtividade_Principal() {
        return atividade_Principal;
    }

    public void setAtividade_Principal(String atividade_Principal) {
        this.atividade_Principal = atividade_Principal;
    }

    public String getAtividades_Secundarias() {
        return atividades_Secundarias;
    }

    public void setAtividades_Secundarias(String atividades_Secundarias) {
        this.atividades_Secundarias = atividades_Secundarias;
    }

    public Date getData_Abertura() {
        return data_Abertura;
    }

    public void setData_Abertura(Date data_Abertura) {
        this.data_Abertura = data_Abertura;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }

    public String getStatus_Cadastro() {
        return status_Cadastro;
    }

    public void setStatus_Cadastro(String status_Cadastro) {
        this.status_Cadastro = status_Cadastro;
    }
    
  
    
    
    
    
}
