package ru.test.hib;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class MyDepartment {

    @Override
    public String toString() {
        return "{{ID = "+ identifier + ", NAME = " + name + ", adr = " + fullAddress + "}}";
    }

    @Id
    @Column(name = "ID")
    private String identifier;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESS")
    private String fullAddress;

    @Column(name = "PARENTID")
    private String parentIdentifier;

    @Column(name = "EMPCOUNT")
    private int stuffVolume;

    //private int trash;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getParentIdentifier() {
        return parentIdentifier;
    }

    public void setParentIdentifier(String parentIdentifier) {
        this.parentIdentifier = parentIdentifier;
    }

    public int getStuffVolume() {
        return stuffVolume;
    }

    public void setStuffVolume(int stuffVolume) {
        this.stuffVolume = stuffVolume;
    }

    //public int getTrash() {
     //   return trash;
    //}

    //public void setTrash(int trash) {
    //    this.trash = trash;
    //}
}
