package ru.test.ws;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "BookStore")
@XmlAccessorType(XmlAccessType.FIELD)
public class Library {

    public Library(){
        store = new ArrayList<Book>();
    }

    @XmlElement(name = "Caption")
    private String description;

    @XmlElementWrapper(name = "BookList")
    private List<Book> store;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getStore() {
        return store;
    }

    public void setStore(List<Book> store) {
        this.store = store;
    }
}
