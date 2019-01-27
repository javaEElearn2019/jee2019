package ru.test.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import java.util.UUID;

public class App {

    public static void main(String[] args){
        /**
         * CREATE TABLE DEPARTMENT(
         *   ID VARCHAR(100) NOT NULL,
         *   NAME VARCHAR(255) NOT NULL,
         *   ADDRESS VARCHAR(255) NULL,
         *   PARENTID VARCHAR(255) NULL,
         *   EMPCOUNT NUMERIC(9,0) NOT NULL
         * );
         */

        MyDepartment dep1 = new MyDepartment();
        dep1.setIdentifier(UUID.randomUUID().toString());
        dep1.setFullAddress("Yaroslavl, Braghino");
        dep1.setName("Beerka");
        dep1.setStuffVolume(100);



        Session sess = SF.getInstance().openSession();
        Transaction tx = sess.beginTransaction();

        sess.save(dep1);

        tx.commit();
        sess.close();

    }
}
