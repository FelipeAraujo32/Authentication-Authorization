package com.br.securitytoken.securitytoken.api.dto.Requests;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class RegisterRequest {
    
    @NotEmpty
    private String name;
    @NotEmpty
    private String lastname;
    @NotNull
    private String numberPhone;
    @NotNull
    private String login;
    @NotNull
    private String password;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getNumberPhone() {
        return numberPhone;
    }
    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    

}
