package com.br.securitytoken.securitytoken.api.dto.Responses;


public class UserResponse {
    
    private String name;
    
    private String lastname;
    
    private String numberPhone;
    
    private String login;

    public UserResponse() {
    }

    public UserResponse(String name, String lastname, String numberPhone, String login) {
        this.name = name;
        this.lastname = lastname;
        this.numberPhone = numberPhone;
        this.login = login;
    }

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

    
    
}
