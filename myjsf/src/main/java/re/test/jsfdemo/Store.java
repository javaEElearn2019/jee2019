package re.test.jsfdemo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class Store {
	private static SessionFactory sessionFactory;
	private static String driverName = "org.postgresql.Driver";
	static {
		try {
			Class.forName(driverName);
		}
			catch (Exception e) {System.err.println("Can't find database driver - " + driverName);
		}
		Configuration cfg = new Configuration().addAnnotatedClass(Position.class);
		cfg.setProperty("hibernate.connection.url", "jdbc:postgresql://127.0.0.1:5432/Positions");
		cfg.setProperty("hibernate.connection.username", "postgres");
		cfg.setProperty("hibernate.connection.password", "postgres");
		
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		builder.applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(builder.build());
		
	}
	
	public static SessionFactory getInstance() {
		return sessionFactory;
	}
	
	private Store() {
		// TODO Auto-generated constructor stub
	}
	
}
