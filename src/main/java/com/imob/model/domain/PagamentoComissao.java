
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class PagamentoComissao extends Pagamentos{
    
    //atributos
    private int id_Pag_Comissao;
    private int id_Codigo_Pagamento_Comissao;
    private Date data_Pagamento_Comissao;
    private int codigo_Corretor_Imobiliaria;
    private int codigo_Pagador_Comissao;
    private String condicoes_Pagamento;
    private String anotacoes_Pagamento_Comissao;
    private String status_Pagamento_Comissao;
    private String numero_Nota_Recibo;
    private String documentaocao_Venda_Locacao;
    
    //set e get

    public int getId_Pag_Comissao() {
        return id_Pag_Comissao;
    }

    public void setId_Pag_Comissao(int id_Pag_Comissao) {
        this.id_Pag_Comissao = id_Pag_Comissao;
    }

    public int getId_Codigo_Pagamento_Comissao() {
        return id_Codigo_Pagamento_Comissao;
    }

    public void setId_Codigo_Pagamento_Comissao(int id_Codigo_Pagamento_Comissao) {
        this.id_Codigo_Pagamento_Comissao = id_Codigo_Pagamento_Comissao;
    }

    public Date getData_Pagamento_Comissao() {
        return data_Pagamento_Comissao;
    }

    public void setData_Pagamento_Comissao(Date data_Pagamento_Comissao) {
        this.data_Pagamento_Comissao = data_Pagamento_Comissao;
    }

    public int getCodigo_Corretor_Imobiliaria() {
        return codigo_Corretor_Imobiliaria;
    }

    public void setCodigo_Corretor_Imobiliaria(int codigo_Corretor_Imobiliaria) {
        this.codigo_Corretor_Imobiliaria = codigo_Corretor_Imobiliaria;
    }

    public int getCodigo_Pagador_Comissao() {
        return codigo_Pagador_Comissao;
    }

    public void setCodigo_Pagador_Comissao(int codigo_Pagador_Comissao) {
        this.codigo_Pagador_Comissao = codigo_Pagador_Comissao;
    }

    public String getCondicoes_Pagamento() {
        return condicoes_Pagamento;
    }

    public void setCondicoes_Pagamento(String condicoes_Pagamento) {
        this.condicoes_Pagamento = condicoes_Pagamento;
    }

    public String getAnotacoes_Pagamento_Comissao() {
        return anotacoes_Pagamento_Comissao;
    }

    public void setAnotacoes_Pagamento_Comissao(String anotacoes_Pagamento_Comissao) {
        this.anotacoes_Pagamento_Comissao = anotacoes_Pagamento_Comissao;
    }

    public String getStatus_Pagamento_Comissao() {
        return status_Pagamento_Comissao;
    }

    public void setStatus_Pagamento_Comissao(String status_Pagamento_Comissao) {
        this.status_Pagamento_Comissao = status_Pagamento_Comissao;
    }

    public String getNumero_Nota_Recibo() {
        return numero_Nota_Recibo;
    }

    public void setNumero_Nota_Recibo(String numero_Nota_Recibo) {
        this.numero_Nota_Recibo = numero_Nota_Recibo;
    }

    public String getDocumentaocao_Venda_Locacao() {
        return documentaocao_Venda_Locacao;
    }

    public void setDocumentaocao_Venda_Locacao(String documentaocao_Venda_Locacao) {
        this.documentaocao_Venda_Locacao = documentaocao_Venda_Locacao;
    }
    
}
