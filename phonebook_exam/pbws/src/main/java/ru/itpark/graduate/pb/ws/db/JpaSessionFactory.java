package ru.itpark.graduate.pb.ws.db;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.itpark.graduate.pb.commons.Config;
import ru.itpark.graduate.pb.commons.Constants;
import ru.itpark.graduate.pb.ws.db.entity.PhoneBookRecordEntity;


public class JpaSessionFactory {
    private static SessionFactory sf;

    static {

        try {
            Class.forName("org.h2.Driver");
        } catch (Exception x){
            System.err.println("No def h2Driver in classpath!");
        }


        Configuration cfg = new Configuration()
                .addAnnotatedClass(PhoneBookRecordEntity.class);

        Config conf = Config.getConfig(Constants.CFG_PBWS_NAME);
        cfg.setProperty("hibernate.connection.url", conf.getParam(Config.AK_DB_URL));
        cfg.setProperty("hibernate.connection.username", conf.getParam(Config.AK_DB_USER));
        cfg.setProperty("hibernate.connection.password", conf.getParam(Config.AK_DB_PASSWORD));

        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(cfg.getProperties());

        sf = cfg.buildSessionFactory(builder.build());
    }

    public static SessionFactory getInstance() {
        return sf;
    }

    public static void kill(){
        if(sf != null) {
            sf.close();
        }
    }

    private JpaSessionFactory() {
    }
}
