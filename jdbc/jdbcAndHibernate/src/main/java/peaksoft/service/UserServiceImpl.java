package peaksoft.service;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
   UserDao userDao=new UserDaoJdbcImpl();
    public void createUsersTable() {

        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
             userDao.saveUser(name,lastName,age);
    }

    public void removeUserById(long id) {
         userDao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();

    }
    public void print(){
        System.out.println(" 1 таблица тузунуз ");
        System.out.println(" 2 таблицага маалымат кошунуз");
        System.out.println(" 3 Баардык Userлерди алуу");
        System.out.println(" 4 id менен очурунуз");
        System.out.println(" 5 Таблицанын ичин тазалоо");
        System.out.println(" 6 Таблицаны очуруу");
        System.out.println();

    }
}
