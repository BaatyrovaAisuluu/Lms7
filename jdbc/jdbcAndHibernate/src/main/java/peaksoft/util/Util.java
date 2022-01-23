package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
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


}
