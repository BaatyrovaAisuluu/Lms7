package peaksoft.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
   //  реализуйте настройку соеденения с БД
    private final static  String url="jdbc:postgresql://localhost:5432/postgres";
    private final static  String login="postgres";
    private final static String password="1234";

    public   static Connection connection(){
        Connection connection=null;

        try{
              connection= DriverManager.getConnection(url,login,password);
            System.out.println("Иштеди");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println();
        }
        return connection;

    }


    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        Properties prop = new Properties();

        prop.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
        prop.setProperty("hibernate.connection.username", "postgres");
        prop.setProperty("hibernate.connection.password", "1234");
        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        prop.setProperty("hibernate.show_sql", "true");
        prop.setProperty("hibernate.hbm2ddl.auto", "create");
        Configuration cfg = new Configuration();
        cfg.addAnnotatedClass(peaksoft.model.User.class);
        cfg.setProperties(prop);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
        System.out.println("Connected to hibernate");
        return cfg.buildSessionFactory(serviceRegistry);
    }
    public static SessionFactory getSession() {
        return sessionFactory;
    }
    public static void shutDown() {
        getSession().close();
    }




//    private static final SessionFactory sessionFactory = buildSessionFactory();
//    private static SessionFactory buildSessionFactory() {
//        Properties prop = new Properties();
//
//
//        prop.setProperty("connection.driver_class", "com.postgresql.Driver");
//        prop.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/postgres");
//        prop.setProperty("hibernate.connection.username", "postgres");
//        prop.setProperty("hibernate.connection.password", "1234");
//        prop.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgresSQLDialect");
//        prop.setProperty("hibernate.show_sql", "true");
//        prop.setProperty("hibernate.hbm2ddl.auto", "validate");
//        Configuration cfg=new Configuration();
//        cfg.addAnnotatedClass(peaksoft.model.User.class);
//       // cfg.addAnnotatedClass(peaksoft.model.User.class);
//        cfg.setProperties(prop);
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
//                applySettings(cfg.getProperties()).build();
//        System.out.println("Connected to hibernate");
//        return cfg.buildSessionFactory(serviceRegistry);
////        Configuration configuration = new Configuration().configure();
////        serviceRegistry = new ServiceRegistryBuilder().applySettings(
////                configuration.getProperties()).buildServiceRegistry();
////        return configuration.buildSessionFactory(serviceRegistry);
//    }
//
//
//    public static SessionFactory getSession() {
//        return sessionFactory;
//    }
//    public static void shutDown() {
//        getSession().close();
//
//    }





//    private static final SessionFactory session=builSessionFactory();
//
//    private static SessionFactory builSessionFactory(){
//        try {
//            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
//        }catch (Throwable ex){
//            System.out.println("session not created:+"+ex);
//            throw new ExceptionInInitializerError(ex);
//
//        }
//    }
//    public static SessionFactory getSession(){
//        return session;
//    }
//    public static void shutDown(){
//        getSession().close();
//    }


}
