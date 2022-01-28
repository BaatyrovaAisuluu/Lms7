package peaksoft.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import peaksoft.model.User;
import peaksoft.util.Util;
//import sun.tools.jconsole.Worker;

import java.util.List;

import static peaksoft.util.Util.getSession;

//import static peaksoft.util.Util.getSession;
//import static peaksoft.util.Util.getSessionFactory;

public class UserDaoHibernateImpl implements UserDao {

    public UserDaoHibernateImpl() {

    }

    @Override
    public void createUsersTable() {
        try {
            Session session = getSession().openSession();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE IF NOT EXISTS users " +
                            "(id serial Primary key," +
                            "name VARCHAR not null," +
                            "lastName VARCHAR NOT NULL, " +
                            "age int not null );").addEntity(User.class).executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("ok");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }


    @Override
    public void dropUsersTable() {
        try {
            Session session =Util.getSession().openSession();
            session.beginTransaction();
             session.createSQLQuery("drop table users").executeUpdate();
            session.getTransaction().commit();
             session.close();
            System.out.println("drop table successfully");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        User user=new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setAge(age);
        try {
              Session session =Util.getSession().openSession();
              session.beginTransaction();
              session.save(user);
              session.getTransaction().commit();
              session.close();
          }catch (Exception e){
              System.out.println(e.getMessage());
          }

    }

    @Override
    public void removeUserById(long id) {
        try {
            Session session = getSession().openSession();
            session.beginTransaction();
            User user = session.get(User.class,id);
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {

        Session session= getSession().openSession();
        session.beginTransaction();
         List<User> list=session.createQuery("from User").list();
        session.getTransaction().commit();
        session.close();

        return list;

    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = getSession().openSession();
            session.beginTransaction();
            session.createSQLQuery("delete from users").executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("ok");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
