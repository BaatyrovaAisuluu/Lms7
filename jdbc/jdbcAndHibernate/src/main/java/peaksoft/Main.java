package peaksoft;

import peaksoft.dao.UserDao;
import peaksoft.dao.UserDaoHibernateImpl;
import peaksoft.dao.UserDaoJdbcImpl;
import peaksoft.service.UserService;
import peaksoft.service.UserServiceImpl;

import java.util.Scanner;

public class Main {
    private final static Scanner sc=new Scanner(System.in);
    private final static Scanner SCANNER=new Scanner(System.in);
    private final static Scanner sd =new Scanner(System.in);


    public static void main(String[] args) throws Exception {
        // реализуйте алгоритм здесь
//        UserService userService = new UserServiceImpl();
//
//        while (true) {
//            UserServiceImpl userService1=new UserServiceImpl();
//            System.out.println();
//            userService1.print();
//            int a = sc.nextInt();
//            System.out.println();
//            if (a <= 0 || a >6) {
//                throw new Exception("Мындай тандоо жок");
//            }
//            switch (a){
//                case 1:
//                    userService.createUsersTable();
//                    break;
//                case 2:
//                    System.out.println("Базага кошунуз");
//                    System.out.println("name");
//                    String name=SCANNER.nextLine();
//                    System.out.println("lastName");
//                    String lastName=SCANNER.nextLine();
//                    System.out.println("age");
//                    byte age=sd.nextByte();
//                    System.out.println();
//                    userService.saveUser(name,lastName,age);
//                    break;
//                case 3:
//                    userService.getAllUsers();
//                    break;
//                case 4:
//                    System.out.println("id жазыныз");
//                    long age1=SCANNER.nextLong();
//                    userService.removeUserById(age1);
//                    break;
//                case 5:
//                    userService.cleanUsersTable();
//                    break;
//                case 6:
//                    userService.dropUsersTable();
//                    break;
//                default:
//                    System.out.println();
//            }
//        }


      UserDao userDao=new UserDaoHibernateImpl();
     // userDao.createUsersTable();
       // userDao.dropUsersTable();
       // userDao.saveUser("rahim","kurbanov", (byte) 23);

    }
}
