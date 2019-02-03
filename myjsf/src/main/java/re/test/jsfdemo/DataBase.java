package re.test.jsfdemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import re.test.jsfdemo.entity.Position;

public class DataBase {
    private static SessionFactory sf;

    public static Session getSession(){
        return sf.openSession();
    }

    static {
        init();
    }

    public static void init() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception x){
            System.err.println("No def postgresql Driver in classpath!");
        }

        Configuration cfg = new Configuration()
                .addAnnotatedClass(Position.class);

        cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://db:5432/postgres");
        cfg.setProperty("hibernate.connection.username", "postgres");
        cfg.setProperty("hibernate.connection.password", "qw!");
        cfg.setProperty("hibernate.hbm2ddl.auto", "update");

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());

        sf = cfg.buildSessionFactory(builder.build());
    }
}
