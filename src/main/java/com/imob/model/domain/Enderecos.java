
package com.imob.model.domain;

/**
 *
 * @author
 */
public class Enderecos extends Bairro {
    
    //atributos
    private int id_Endereco;
    private String tipo_Logradouro;
    private String logradouro;
    private String numero_logradouro;
    private String numero_apartamento;
    private String andar_apartamento;
    private String bloco_apartamento;
    private String complemento;
    private String cep;
    private String latitude;
    private String longitude;
    //get e set
    public int getId_Endereco() {
        return id_Endereco;
    }

    public void setId_Endereco(int id_Endereco) {
        this.id_Endereco = id_Endereco;
    }

    public String getTipo_Logradouro() {
        return tipo_Logradouro;
    }

    public void setTipo_Logradouro(String tipo_Logradouro) {
        this.tipo_Logradouro = tipo_Logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero_logradouro() {
        return numero_logradouro;
    }

    public void setNumero_logradouro(String numero_logradouro) {
        this.numero_logradouro = numero_logradouro;
    }

    public String getNumero_apartamento() {
        return numero_apartamento;
    }

    public void setNumero_apartamento(String numero_apartamento) {
        this.numero_apartamento = numero_apartamento;
    }

    public String getAndar_apartamento() {
        return andar_apartamento;
    }

    public void setAndar_apartamento(String andar_apartamento) {
        this.andar_apartamento = andar_apartamento;
    }

    public String getBloco_apartamento() {
        return bloco_apartamento;
    }

    public void setBloco_apartamento(String bloco_apartamento) {
        this.bloco_apartamento = bloco_apartamento;
    }
    
    

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    //Construtor com erro(sem motivo para ter)
 /*     public Enderecos(int id_Cidades, String nome_Cidades, int id_Estado) {
        super(id_Cidades, nome_Cidades, id_Estado);
        }

        public Enderecos() {
            super();
        }*/
    }
