package ru.test.hib;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SF {
    //private static SF ourInstance;// = new SF();
    private static SessionFactory sf;

    static {

        try {
            Class.forName("org.h2.Driver");
        } catch (Exception x){
            System.err.println("No def h2Driver in classpath!");
        }


        Configuration cfg = new Configuration()
                .addAnnotatedClass(MyDepartment.class);

        ///.addAnnotatedClass...

        cfg.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/tstbd");
        cfg.setProperty("hibernate.connection.username", "sa");
        cfg.setProperty("hibernate.connection.password", "");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());

        sf = cfg.buildSessionFactory(builder.build());
    }

    public static SessionFactory getInstance() {
        return sf;
    }

    private SF() {
    }
}
