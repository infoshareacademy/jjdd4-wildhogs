package dao;

import javax.ejb.Stateful;

@Stateful
public class UserSessionBean {

    private Boolean logged = false;
    private String username;
    private String email;

    public Boolean getLogged() {
        return logged;
    }

    public void setLogged(Boolean logged) {
        this.logged = logged;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}