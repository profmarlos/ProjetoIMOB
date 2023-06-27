
package com.imob.model.domain;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author
 */
public class LoginSenha extends PessoaFisica {
   
    //atributos
    private int id_Login;
    private String usuario_Login;
    private String senha_Login;
    private String permissao;
    private Date data_login;
    private Time time_login;

    //get e set

    public int getId_Login() {
        return id_Login;
    }

    public void setId_Login(int id_Login) {
        this.id_Login = id_Login;
    }

    public String getUsuario_Login() {
        return usuario_Login;
    }

    public void setUsuario_Login(String usuario_Login) {
        this.usuario_Login = usuario_Login;
    }

    public String getSenha_Login() {
        return senha_Login;
    }

    public void setSenha_Login(String senha_Login) {
        this.senha_Login = senha_Login;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }

    public Date getData_login() {
        return data_login;
    }

    public void setData_login(Date data_login) {
        this.data_login = data_login;
    }

    public Time getTime_login() {
        return time_login;
    }

    public void setTime_login(Time time_login) {
        this.time_login = time_login;
    }
    
    
}
