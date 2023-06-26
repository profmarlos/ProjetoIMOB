
package com.imob.model.domain;

public class LoginSenhaFilter {
   
    //atributos
    private Integer id_Login;
    private Integer id_PessoaPF;
    private Integer id_Pessoa;
    private String usuario_Login;
    private String permissao;

    public LoginSenhaFilter() {
    }

    public LoginSenhaFilter(Integer id_Login, Integer id_PessoaPF, Integer id_Pessoa, String usuario_Login, String permissao) {
        this.id_Login = id_Login;
        this.id_PessoaPF = id_PessoaPF;
        this.id_Pessoa = id_Pessoa;
        this.usuario_Login = usuario_Login;
        this.permissao = permissao;
    }

    public Integer getId_Login() {
        return id_Login;
    }

    public void setId_Login(Integer id_Login) {
        this.id_Login = id_Login;
    }

    public Integer getId_PessoaPF() {
        return id_PessoaPF;
    }

    public void setId_PessoaPF(Integer id_PessoaPF) {
        this.id_PessoaPF = id_PessoaPF;
    }

    public Integer getId_Pessoa() {
        return id_Pessoa;
    }

    public void setId_Pessoa(Integer id_Pessoa) {
        this.id_Pessoa = id_Pessoa;
    }

    public String getUsuario_Login() {
        return usuario_Login;
    }

    public void setUsuario_Login(String usuario_Login) {
        this.usuario_Login = usuario_Login;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
}
