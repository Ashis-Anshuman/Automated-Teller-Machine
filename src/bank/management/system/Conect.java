package bank.management.system;
import java.sql.*;
public class Conect {
    Connection c;
    Statement s;
    public Conect(){
        try{
            c=DriverManager.getConnection("jdbc:mysql:///BankManegmentSystem","root","Ashis@(2004)");
            s=c.createStatement();
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
