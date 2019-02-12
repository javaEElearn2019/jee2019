package ru.itpark.graduate.pb.web.mbeans;

import ru.itpark.graduate.pb.web.clnt.genapi.PbWsService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "mainBean")
@SessionScoped
public class MBeanMain {
    /*static{
        //stub -- see what load from config
        PbWsService s = new PbWsService();
    }*/

    //private String stub = "boo";

    /*public String getStub() {
        return stub;
    }

    public void setStub(String stub) {
        this.stub = stub;
    }*/





    private String login;
    private String password;

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

    public String doAction(){
        return "main";
    }
}
