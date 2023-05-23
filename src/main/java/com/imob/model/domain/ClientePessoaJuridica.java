
package com.imob.model.domain;

/**
 *
 * @author
 */
public class ClientePessoaJuridica extends PessoaJuridica{
    
    //atributos
    private int id_ClientePJ;
    private int Codigo_ClientePJ;
    private String status_Comprador;
    private String status_Locatario;
    private String status_Locador;
    private String status_Vendedor;
    
    //set e get

    public int getId_ClientePJ() {
        return id_ClientePJ;
    }

    public void setId_ClientePJ(int id_ClientePJ) {
        this.id_ClientePJ = id_ClientePJ;
    }

    public int getCodigo_ClientePJ() {
        return Codigo_ClientePJ;
    }

    public void setCodigo_ClientePJ(int Codigo_ClientePJ) {
        this.Codigo_ClientePJ = Codigo_ClientePJ;
    }

    public String getStatus_Comprador() {
        return status_Comprador;
    }

    public void setStatus_Comprador(String status_Comprador) {
        this.status_Comprador = status_Comprador;
    }

    public String getStatus_Locatario() {
        return status_Locatario;
    }

    public void setStatus_Locatario(String status_Locatario) {
        this.status_Locatario = status_Locatario;
    }

    public String getStatus_Locador() {
        return status_Locador;
    }

    public void setStatus_Locador(String status_Locador) {
        this.status_Locador = status_Locador;
    }

    public String getStatus_Vendedor() {
        return status_Vendedor;
    }

    public void setStatus_Vendedor(String status_Vendedor) {
        this.status_Vendedor = status_Vendedor;
    }
    
}
