
package com.imob.model.dao;

import com.imob.model.domain.LoginSenha;
import com.imob.model.domain.LoginSenhaFilter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginSenhaDAO {

    private Connection connection;
    
    //get e set da conexao
    public Connection getConnection()
    {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    
    //método inserir
    public void inserir(LoginSenha login) throws SQLException {
        String sql = "insert into tb_login (usuario_Login, senha_Login, permissao, data_login, time_login, " +
                "tb_pessoa_fisica_id_PessoaPF, tb_pessoa_fisica_tb_pessoa_id_Pessoa) " +
                "values (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, login.getUsuario_Login());
        stmt.setString(2, login.getSenha_Login());
        stmt.setString(3, login.getPermissao());
        stmt.setDate(4, login.getData_login());
        stmt.setTime(5, login.getTime_login());
        stmt.setInt(6, login.getId_PessoaPF());
        stmt.setInt(7, login.getId_Pessoa());

        stmt.execute();
    }
    
    //método para alterar
    public void alterar(LoginSenha login) throws SQLException {
        String sql = "UPDATE bd_imob.tb_login SET usuario_Login = ?, senha_Login = ?, " +
                "permissao = ?, data_login = ?, time_login = ? where id_Login = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, login.getUsuario_Login());
        stmt.setString(2, login.getSenha_Login());
        stmt.setString(3, login.getPermissao());
        stmt.setDate(4, login.getData_login());
        stmt.setTime(5, login.getTime_login());
        stmt.setInt(6, login.getId_Login());

        stmt.execute();
    }
    
    //método para remover
    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM tb_login WHERE id_Login = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        stmt.execute();
    }
    
    //método para listar
    public List<LoginSenha> listaTodos() throws SQLException {
        String sql = "SELECT * FROM tb_login";

        List<LoginSenha> retorno = new ArrayList<>();

        PreparedStatement stmt = connection.prepareStatement(sql);
        ResultSet resultado = stmt.executeQuery();

        while (resultado.next()) {
            LoginSenha login = new LoginSenha();
            login.setId_Login(resultado.getInt("id_login"));
            login.setUsuario_Login(resultado.getString("usuario_Login"));
            login.setSenha_Login(resultado.getString("senha_Login"));
            login.setPermissao(resultado.getString("permissao"));
            login.setData_login(resultado.getDate("data_login"));
            login.setTime_login(resultado.getTime("time_login"));
            login.setId_PessoaPF(resultado.getInt("tb_pessoa_fisica_id_PessoaPF"));
            login.setId_Pessoa(resultado.getInt("tb_pessoa_fisica_tb_pessoa_id_Pessoa"));

            //vamos adicionando a lista retorno
            retorno.add(login);
        }

        
        return retorno;
        
    }
    
    
    //método para buscar
    public LoginSenha buscarPeloId(int id) throws SQLException {
        String sql = "SELECT * FROM tb_login WHERE id_login = ?";

        LoginSenha retorno = null;

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, id);

        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            LoginSenha login = new LoginSenha();
            login.setId_Login(resultado.getInt("id_login"));
            login.setUsuario_Login(resultado.getString("usuario_Login"));
            login.setSenha_Login(resultado.getString("senha_Login"));
            login.setPermissao(resultado.getString("permissao"));
            login.setData_login(resultado.getDate("data_login"));
            login.setTime_login(resultado.getTime("time_login"));
            login.setId_PessoaPF(resultado.getInt("tb_pessoa_fisica_id_PessoaPF"));
            login.setId_Pessoa(resultado.getInt("tb_pessoa_fisica_tb_pessoa_id_Pessoa"));

            retorno = login;
        }

        return retorno;
    }

    public LoginSenha buscarPeloLogin(String login) throws SQLException {
        String sql = "SELECT * FROM tb_login WHERE usuario_Login = ?";

        LoginSenha retorno = null;

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, login);

        ResultSet resultado = stmt.executeQuery();

        if (resultado.next()) {
            LoginSenha loginSenha = new LoginSenha();
            loginSenha.setId_Login(resultado.getInt("id_login"));
            loginSenha.setUsuario_Login(resultado.getString("usuario_Login"));
            loginSenha.setSenha_Login(resultado.getString("senha_Login"));
            loginSenha.setPermissao(resultado.getString("permissao"));
            loginSenha.setData_login(resultado.getDate("data_login"));
            loginSenha.setTime_login(resultado.getTime("time_login"));
            loginSenha.setId_PessoaPF(resultado.getInt("tb_pessoa_fisica_id_PessoaPF"));
            loginSenha.setId_Pessoa(resultado.getInt("tb_pessoa_fisica_tb_pessoa_id_Pessoa"));

            retorno = loginSenha;
        }

        return retorno;
    }

    public List<LoginSenha> buscarPeloFiltro(LoginSenhaFilter filter) throws SQLException {
        ResultSet resultado;
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from tb_login where 1=1 ");
        Integer idLogin = filter.getId_Login();
        Integer idPessoaPF = filter.getId_PessoaPF();
        Integer idPessoa = filter.getId_Pessoa();
        String usuarioLogin = filter.getUsuario_Login();
        String permissao = filter.getPermissao();
        List<Object> params = new ArrayList<Object>();

        if(idLogin != null){
            sql.append(" and id_login = ? ");
            params.add(idLogin);
        }

        if(idPessoaPF != null){
            sql.append(" and tb_pessoa_fisica_id_PessoaPF = ? ");
            params.add(idPessoaPF);
        }

        if(idPessoa != null){
            sql.append(" and tb_pessoa_fisica_tb_pessoa_id_Pessoa = ? ");
            params.add(idPessoa);
        }

        if(!usuarioLogin.isBlank()){
            sql.append(" and lower(usuario_Login) like ? ");
            params.add("%" + usuarioLogin + "%");
        }

        if(!permissao.isBlank()){
            sql.append(" and lower(permissao) like ? ");
            params.add("%" + permissao + "%");
        }

        PreparedStatement stmt = connection.prepareStatement(sql.toString());
        for (int i = 0; i < params.size(); i++) {
            Object object = params.get(i);
            if(object instanceof String){
                stmt.setString(i+1, (String) object);
            }
            if(object instanceof Integer){
                stmt.setInt(i+1, (Integer) object);
            }
        }

        resultado = stmt.executeQuery();
        ArrayList<LoginSenha> listLogins = new ArrayList<>();
        //Pegar os itens do resultset e inserir na lista
        while(resultado.next()){
            LoginSenha loginSenha = new LoginSenha();
            loginSenha.setId_Login(resultado.getInt("id_login"));
            loginSenha.setUsuario_Login(resultado.getString("usuario_Login"));
            loginSenha.setSenha_Login(resultado.getString("senha_Login"));
            loginSenha.setPermissao(resultado.getString("permissao"));
            loginSenha.setData_login(resultado.getDate("data_login"));
            loginSenha.setTime_login(resultado.getTime("time_login"));
            loginSenha.setId_PessoaPF(resultado.getInt("tb_pessoa_fisica_id_PessoaPF"));
            loginSenha.setId_Pessoa(resultado.getInt("tb_pessoa_fisica_tb_pessoa_id_Pessoa"));

            listLogins.add(loginSenha);
        }
        resultado.close();
        return listLogins;
    }
}
