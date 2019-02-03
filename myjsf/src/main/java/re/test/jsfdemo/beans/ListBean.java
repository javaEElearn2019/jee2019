package re.test.jsfdemo.beans;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.query.Query;
import re.test.jsfdemo.DataBase;
import re.test.jsfdemo.entity.Position;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "listbean")
@RequestScoped
@Data
public class ListBean {

    private List<Position> positionList = new ArrayList<Position>();

    @PostConstruct
    public void init(){
        System.out.println("init position list");
        Session session = DataBase.getSession();
        Query<Position> positionQuery = session.createQuery("from Position order by id", Position.class);
        positionList = positionQuery.list();
    }
}
