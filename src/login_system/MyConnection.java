package login_system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyConnection {
    
    public static Connection getConnection(){
    
    Connection con =null;
    try
    {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/the_app_users","root","");
    } catch (Exception ex){
    System.out.println(ex.getMessage());
    System.out.println("it didn't work out");
    
}
    return con;
    
}
    
}

