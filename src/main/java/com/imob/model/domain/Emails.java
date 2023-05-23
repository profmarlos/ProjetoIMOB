
package com.imob.model.domain;

/**
 *
 * @author
 */
public class Emails extends Telefones {
    
    //atributos
    private int id_Email;
    private int id_Codigo_email;
    private String tipo_email;
    private String email;
    
    //get e set

    public int getId_Email() {
        return id_Email;
    }

    public void setId_Email(int id_Email) {
        this.id_Email = id_Email;
    }

    public int getId_Codigo_email() {
        return id_Codigo_email;
    }

    public void setId_Codigo_email(int id_Codigo_email) {
        this.id_Codigo_email = id_Codigo_email;
    }

    public String getTipo_email() {
        return tipo_email;
    }

    public void setTipo_email(String tipo_email) {
        this.tipo_email = tipo_email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
            
}
