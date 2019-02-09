package re.test.jsfdemo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PositionsItems")
public class Position {
	@Id
	@Column(name="ID")
    private String articul;
	@Column(name="NAME")
    private String name;
	@Column(name="qnty")
    private Double qnty;
    
	public Position() {
		// TODO Auto-generated constructor stub
	}
    public String getArticul() {
        return articul;
    }

    public void setArticul(String articul) {
        this.articul = articul;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getQnty() {
        return qnty;
    }

    public void setQnty(Double qnty) {
        this.qnty = qnty;
    }
}
