package HibernateUtil;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


import com.revature.models.Information;
import com.revature.models.Jobs;

import com.revature.models.User;

public class HibernateUtil {

	/*
	 * Hiberante has some important objects and interfaces 
	 * 
	 * Configuration : 
	 * 		This will parse our configuration file into a java object 
	 * 
	 * SessionFactory: 
	 * 		This is a resource intensive object to create, but once created 
	 * 		can produce sessions for our SQL commands 
	 * 
	 * Session: 
	 * 		ABstractions of our connections. Sessions will manage the the connection to our database 
	 * 			and allows us to do CRUD operations. 
	 * 
	 * Transction ACID
	 * 
	 */
	
	
	private static SessionFactory sf;
	
	//Global session object
	private static Session session;
	
	public static Session getSession() {
		
		configure();
		
		if(session == null) {
			return sf.openSession();
		}else {
			return session;
		}
		
	}
	
	private static void configure() {
		
		
		if(sf == null) {
			Map<String, String> settings = new HashMap<>();
			
			settings.put("hibernate.connection.url", "jdbc:postgresql://localhost/postgres");
			settings.put("hibernate.connection.username", "postgres");
			settings.put("hibernate.connection.password", "jabdulla");
			settings.put("hibernate.connection.driver_class","org.postgresql.Driver");
			settings.put("hibernate.connection.dialect", "org.hibernate.dialect.PostgreSQLDialect");
			settings.put("hibernate.show_sql", "false");
			settings.put("hibernate.hbm2ddl.auto", "create");
			
			StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
					.applySettings(settings).build();
			
			Metadata metadata = new MetadataSources(standardRegistry)
									.addAnnotatedClass(User.class)
									.addAnnotatedClass(Information.class)
									.addAnnotatedClass(Jobs.class)
									.getMetadataBuilder()
									.build();	
			
			sf = metadata.getSessionFactoryBuilder().build();
		}

	}
	
	public static void closeSession() {
		session.close();
	}
	
}