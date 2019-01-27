package ru.test.hib;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import javax.persistence.Query;
import java.util.List;
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


        //Create simple object
        MyDepartment dep1 = new MyDepartment();
        dep1.setIdentifier(UUID.randomUUID().toString());
        dep1.setFullAddress("Yaroslavl, Braghino");
        dep1.setName("Beerka");
        dep1.setStuffVolume(100);



        //retrieve session-factory by singletone (see SF.java)
        Session sess = SF.getInstance().openSession();
        //begin transaction
        Transaction tx = sess.beginTransaction();

        //persist object into DB
        sess.save(dep1);

        //final tracsaction
        tx.commit();
        sess.close();



        //run at once!
        /*MyDepartment dep2  = new MyDepartment();
        dep2.setIdentifier("AAA1111");
        dep2.setFullAddress("Moscow, Krasnaya sq.");
        dep2.setName("Voodka & Bear");
        dep2.setStuffVolume(55);

        sess = SF.getInstance().openSession();
        tx = sess.beginTransaction();
        sess.save(dep2);
        tx.commit();
        sess.close();*/


        sess = SF.getInstance().openSession();
        MyDepartment dep3 = sess.byId(MyDepartment.class).load("AAA1111");
        tx = sess.beginTransaction();
        dep3.setName("New name");
        dep3.setStuffVolume(1000);
        sess.update(dep3);
        sess.delete(dep3);
        tx.commit();
        sess.close();

        System.out.println(dep3);



        sess = SF.getInstance().openSession();
        NativeQuery nq = sess.createSQLQuery("" +
                "SELECT ID as\"IDF\", NAME as \"Name\", EMPCOUNT as \"Cnt\" " +
                "FROM DEPARTMENT WHERE ID LIKE '%8%'");

        List list =  nq.getResultList();

        for(Object o : list){
            //System.out.println(o.getClass().getCanonicalName());
            Object[] row = (Object[])o;
            System.out.println("\n");
            for(Object col : row){
                System.out.println(col + " " + col.getClass().getCanonicalName());
            }
        }

        sess.close();
        sess = SF.getInstance().openSession();
        List<MyDepartment> list2 = (List<MyDepartment>)sess.createQuery("from MyDepartment where stuffVolume >= 100").list();

        for(MyDepartment d : list2){
            System.out.println(d.getName());
        }


        sess.close();

    }
}
