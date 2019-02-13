package ru.itpark.graduate.pb.web.mbeans;

import ru.itpark.graduate.pb.web.facade.PhoneBookFacade;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mainBean")
@SessionScoped
public class MBeanMain {

    private String login;
    private String password;
    private String errorText;
    private boolean auth = false;

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

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    public boolean isAuth() {
        return auth;
    }

    public void setAuth(boolean auth) {
        this.auth = auth;
    }

    public String logOut(){
        this.login = null;
        this.password = null;
        this.auth = false;
        this.errorText = "";
        return "main";
    }

    public String doCheck(){
        if(PhoneBookFacade.isUserAuth(this.login, this.password)){
            this.errorText = "";
            this.auth = true;
            return "list";
        } else {
            this.errorText = "Invalid username or password!";
            this.auth = false;
            return "main";
        }
    }
}
