package re.test.jsfdemo;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;

@ManagedBean(name = "listbean")
@RequestScoped
public class ListBean {

    private List<Position> posList = Store.getInstance().getData();

    public List<Position> getPosList() {

        List<Position> hh = posList;

        return hh;
    }

    public void setPosList(List<Position> posList) {
        this.posList = posList;
    }
}
