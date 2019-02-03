package re.test.jsfdemo;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static Store ourInstance = new Store();

    public static Store getInstance() {
        return ourInstance;
    }

    private Store() {
    }

    private List<Position> data = new ArrayList<Position>();

    public List<Position>  getData(){
        return data;
    }
}
