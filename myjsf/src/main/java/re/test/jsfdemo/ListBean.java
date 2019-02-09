package re.test.jsfdemo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

@ManagedBean(name = "listbean")
@RequestScoped
public class ListBean {

    private static Position post;

    public List<Position> getPosList() {
        Session ses = Store.getInstance().openSession();
        List<Position> lst = (List<Position>)ses.createQuery("from POSITIONSITEMS").list();
        return lst;
    }

    public static void addPos(Position pos) {
        post = pos;
        Session ses = Store.getInstance().openSession();
        Transaction tx = ses.beginTransaction();
        ses.save(pos);
        tx.commit();
        ses.close();
    }
}
