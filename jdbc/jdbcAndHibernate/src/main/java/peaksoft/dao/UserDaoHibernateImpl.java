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
            session.getTransaction().commit();
            session.close();
            System.out.println("ok");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Override
    public void dropUsersTable() {
        try {
            Session session =Util.getSession().openSession();
            session.beginTransaction();
             session.createQuery("from User").executeUpdate();
            session.getTransaction().commit();
             session.close();
            System.out.println("drop table successfully");

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
          try {
              Session session =Util.getSession().openSession();
              session.beginTransaction();
              User user=new User();
              user.setName(name);
              user.setLastName(lastName);
              user.setAge(age);
              session.save(user);
              session.getTransaction().commit();
              session.close();
          }catch (Exception e){
              e.printStackTrace();
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
         List list=session.createQuery("from User").getResultList();
        session.getTransaction().commit();
        session.close();

        return list;

    }

    @Override
    public void cleanUsersTable() {
        try {
            Session session = getSession().openSession();
            session.beginTransaction();
            Query query = session.createQuery("DELETE User");
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();
            System.out.println("ok");
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
