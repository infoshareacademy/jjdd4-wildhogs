package dao;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class UserSessionBean implements Serializable {

    private Boolean logged = false;
    private Long userId;

    public Boolean getLogged() {
        return logged;
    }

    public void setLogged(Boolean logged) {
        this.logged = logged;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}