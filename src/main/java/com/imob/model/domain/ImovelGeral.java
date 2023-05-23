
package com.imob.model.domain;

/**
 *
 * @author
 */
public class ImovelGeral {
    
    //atributos
    private int id_Imovel;
    private int id_Codigo_Imovel;
    private String status_Venda;
    private String status_Locacao;
    private String numero_Matricula;
    private String tipo_Imovel;
    private String documentacao_Imovel;
    private String fotos_Imovel;
    private String anotacoes_Imovel;
    private String qualidade_Localizacao;
    private String qualidade_DE_Acesso;
    
    //get e set

    public int getId_Imovel() {
        return id_Imovel;
    }

    public void setId_Imovel(int id_Imovel) {
        this.id_Imovel = id_Imovel;
    }

    public int getId_Codigo_Imovel() {
        return id_Codigo_Imovel;
    }

    public void setId_Codigo_Imovel(int id_Codigo_Imovel) {
        this.id_Codigo_Imovel = id_Codigo_Imovel;
    }

    public String getStatus_Venda() {
        return status_Venda;
    }

    public void setStatus_Venda(String status_Venda) {
        this.status_Venda = status_Venda;
    }

    public String getStatus_Locacao() {
        return status_Locacao;
    }

    public void setStatus_Locacao(String status_Locacao) {
        this.status_Locacao = status_Locacao;
    }

    public String getNumero_Matricula() {
        return numero_Matricula;
    }

    public void setNumero_Matricula(String numero_Matricula) {
        this.numero_Matricula = numero_Matricula;
    }

    public String getTipo_Imovel() {
        return tipo_Imovel;
    }

    public void setTipo_Imovel(String tipo_Imovel) {
        this.tipo_Imovel = tipo_Imovel;
    }

    public String getDocumentacao_Imovel() {
        return documentacao_Imovel;
    }

    public void setDocumentacao_Imovel(String documentacao_Imovel) {
        this.documentacao_Imovel = documentacao_Imovel;
    }

    public String getFotos_Imovel() {
        return fotos_Imovel;
    }

    public void setFotos_Imovel(String fotos_Imovel) {
        this.fotos_Imovel = fotos_Imovel;
    }

    public String getAnotacoes_Imovel() {
        return anotacoes_Imovel;
    }

    public void setAnotacoes_Imovel(String anotacoes_Imovel) {
        this.anotacoes_Imovel = anotacoes_Imovel;
    }

    public String getQualidade_Localizacao() {
        return qualidade_Localizacao;
    }

    public void setQualidade_Localizacao(String qualidade_Localizacao) {
        this.qualidade_Localizacao = qualidade_Localizacao;
    }

    public String getQualidade_DE_Acesso() {
        return qualidade_DE_Acesso;
    }

    public void setQualidade_DE_Acesso(String qualidade_DE_Acesso) {
        this.qualidade_DE_Acesso = qualidade_DE_Acesso;
    }
    
}
