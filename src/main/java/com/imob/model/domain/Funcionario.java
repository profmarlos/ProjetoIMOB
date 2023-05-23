
package com.imob.model.domain;

import java.sql.Date;

/**
 *
 * @author
 */
public class Funcionario extends PessoaFisica {
 
    //atributos 
    private int id_Funcionario;
    private int id_Codigo_Funcionario;
    private String cargo;
    private Date data_admissao;
    private Date data_demissao;
    private double salario_inicial;
    private double salario_atual;
    private double comissao;
    private String anotacoes;
    
    //get e set

    public int getId_Funcionario() {
        return id_Funcionario;
    }

    public void setId_Funcionario(int id_Funcionario) {
        this.id_Funcionario = id_Funcionario;
    }

    public int getId_Codigo_Funcionario() {
        return id_Codigo_Funcionario;
    }

    public void setId_Codigo_Funcionario(int id_Codigo_Funcionario) {
        this.id_Codigo_Funcionario = id_Codigo_Funcionario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getData_admissao() {
        return data_admissao;
    }

    public void setData_admissao(Date data_admissao) {
        this.data_admissao = data_admissao;
    }

    public Date getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(Date data_demissao) {
        this.data_demissao = data_demissao;
    }

    public double getSalario_inicial() {
        return salario_inicial;
    }

    public void setSalario_inicial(double salario_inicial) {
        this.salario_inicial = salario_inicial;
    }

    public double getSalario_atual() {
        return salario_atual;
    }

    public void setSalario_atual(double salario_atual) {
        this.salario_atual = salario_atual;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public String getAnotacoes() {
        return anotacoes;
    }

    public void setAnotacoes(String anotacoes) {
        this.anotacoes = anotacoes;
    }
    
    
}
