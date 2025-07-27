package universityManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");//Register the Driver Class
          //Creating connection String
          c= DriverManager.getConnection("jdbc:mysql://localhost:3306/universitymanagementsystem","root","rubayet");
          s=c.createStatement();//Statement=my sql querys can be execute
      }catch (Exception e){
          e.printStackTrace();
      }
    }
}
