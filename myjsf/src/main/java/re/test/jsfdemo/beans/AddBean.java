package re.test.jsfdemo.beans;


import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import re.test.jsfdemo.DataBase;
import re.test.jsfdemo.entity.Position;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "mybean")
@RequestScoped
@Data
public class AddBean {


    public String doAdd(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        HttpSession httpSession = (HttpSession) facesContext.getExternalContext().getSession(true);


        System.out.println(this);
        Position pos = new Position();
        pos.setArticle(serialNo);
        pos.setName(name);
        pos.setQuantity(quantity);
        pos.setSessionId(httpSession.getId());

        Session session = null;
        try {
            session = DataBase.getSession();
            session.getTransaction().begin();
            session.save(pos);
            session.getTransaction().commit();
        } catch (HibernateException ex){
            if (session != null){
                session.getTransaction().rollback();
            }
            System.err.println(ex.getLocalizedMessage());
        } finally {
            if (session != null){
                session.close();

            }
        }
        return "list?faces-redirect=true";
    }

    private String serialNo;
    private String sessionId;
    private String name;
    private Double quantity;

}
