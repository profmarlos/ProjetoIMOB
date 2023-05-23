package com.imob.model.domain;

/**
 *
 * @author
 */
public class ClientePessoaFisica extends PessoaFisica {
    
    //atributos
    private int id_ClientePF;
    private int id_codigo_clientePF;
    private String status_Comprador;
    private String status_Locador;
    private String status_Locatario;
    private String status_Vendedor;
    
    //criamos o construtor
   
    
    //get e set

    public int getId_ClientePF() {
        return id_ClientePF;
    }

    public void setId_ClientePF(int id_ClientePF) {
        this.id_ClientePF = id_ClientePF;
    }

    public int getId_codigo_clientePF() {
        return id_codigo_clientePF;
    }

    public void setId_codigo_clientePF(int id_codigo_clientePF) {
        this.id_codigo_clientePF = id_codigo_clientePF;
    }

    public String getStatus_Comprador() {
        return status_Comprador;
    }

    public void setStatus_Comprador(String status_Comprador) {
        this.status_Comprador = status_Comprador;
    }

    public String getStatus_Locador() {
        return status_Locador;
    }

    public void setStatus_Locador(String status_Locador) {
        this.status_Locador = status_Locador;
    }

    public String getStatus_Locatario() {
        return status_Locatario;
    }

    public void setStatus_Locatario(String status_Locatario) {
        this.status_Locatario = status_Locatario;
    }

    public String getStatus_Vendedor() {
        return status_Vendedor;
    }

    public void setStatus_Vendedor(String status_Vendedor) {
        this.status_Vendedor = status_Vendedor;
    }
    
}
