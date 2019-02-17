package ru.itpark.graduate.pb.ws.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PHONEBOOK")
public class PhoneBookRecordEntity {

    /*
CREATE TABLE PHONEBOOK(
  RECGUID VARCHAR(50) NOT NULL,
  LOGIN VARCHAR(255) NOT NULL,
  PASSWORD VARCHAR(511) NOT NULL,
  FIRSTNAME VARCHAR(255) NULL,
  LASTNAME VARCHAR(255) NULL,
  MIDDLENAME VARCHAR(255) NULL,
  BIRTHDATE DATE NULL,
  EMAIL VARCHAR(255) NULL,
  PHONE VARCHAR(255) NULL
);
CREATE UNIQUE INDEX PK_PHONEBOOK ON PHONEBOOK(RECGUID);
CREATE UNIQUE INDEX IDX01_PHONEBOOK ON PHONEBOOK(LOGIN);
     */

    @Id
    @Column(name = "RECGUID")
    private String recGUID;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "MIDDLENAME")
    private String middlename;

    @Column(name = "BIRTHDATE")
    private Date birthDate;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phone;


    public String getRecGUID() {
        return recGUID;
    }

    public void setRecGUID(String recGUID) {
        this.recGUID = recGUID;
    }

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

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
