
package com.imob.model.domain;

/**
 *
 * @author
 */
public class ImovelUrbano extends ImovelGeral {
    
    //atributos
    private int id_Imovel_U;
    private String numero_Iptu;
    private int area_Total_Terreno;
    private int area_Construida;
    private int quant_Banheiros;
    private int quant_Dormitorios;
    private int quant_Salas;
    private String tem_Garagem;
    private int quant_Vagas_Carro;
    private String tem_Edicula;
    private String tem_Churrasqueira;
    
    //get e set

    public int getId_Imovel_U() {
        return id_Imovel_U;
    }

    public void setId_Imovel_U(int id_Imovel_U) {
        this.id_Imovel_U = id_Imovel_U;
    }

    public String getNumero_Iptu() {
        return numero_Iptu;
    }

    public void setNumero_Iptu(String numero_Iptu) {
        this.numero_Iptu = numero_Iptu;
    }

    public int getArea_Total_Terreno() {
        return area_Total_Terreno;
    }

    public void setArea_Total_Terreno(int area_Total_Terreno) {
        this.area_Total_Terreno = area_Total_Terreno;
    }

    public int getArea_Construida() {
        return area_Construida;
    }

    public void setArea_Construida(int area_Construida) {
        this.area_Construida = area_Construida;
    }

    public int getQuant_Banheiros() {
        return quant_Banheiros;
    }

    public void setQuant_Banheiros(int quant_Banheiros) {
        this.quant_Banheiros = quant_Banheiros;
    }

    public int getQuant_Dormitorios() {
        return quant_Dormitorios;
    }

    public void setQuant_Dormitorios(int quant_Dormitorios) {
        this.quant_Dormitorios = quant_Dormitorios;
    }

    public int getQuant_Salas() {
        return quant_Salas;
    }

    public void setQuant_Salas(int quant_Salas) {
        this.quant_Salas = quant_Salas;
    }

    public String getTem_Garagem() {
        return tem_Garagem;
    }

    public void setTem_Garagem(String tem_Garagem) {
        this.tem_Garagem = tem_Garagem;
    }

    public int getQuant_Vagas_Carro() {
        return quant_Vagas_Carro;
    }

    public void setQuant_Vagas_Carro(int quant_Vagas_Carro) {
        this.quant_Vagas_Carro = quant_Vagas_Carro;
    }

    public String getTem_Edicula() {
        return tem_Edicula;
    }

    public void setTem_Edicula(String tem_Edicula) {
        this.tem_Edicula = tem_Edicula;
    }

    public String getTem_Churrasqueira() {
        return tem_Churrasqueira;
    }

    public void setTem_Churrasqueira(String tem_Churrasqueira) {
        this.tem_Churrasqueira = tem_Churrasqueira;
    }
    
}
