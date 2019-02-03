package re.test.jsfdemo;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "mybean")
@RequestScoped
public class AddBean {


    public String doAdd(){

        System.out.println("in do add with " + this.serialNo + ",  " + this.name + ", " + this.quantity);

        Position pos = new Position();
        pos.setArticul(serialNo);
        pos.setName(name);
        pos.setQnty(quantity);

        Store.getInstance().getData().add(pos);

        return "list";
    }

    private String serialNo;
    private String name;
    private Double quantity;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }
}
