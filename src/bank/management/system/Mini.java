package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Mini extends JFrame implements ActionListener{
 
    JButton b1, b2;
    String pinnumber;
    
    Mini(String pinnumber){
        super("Mini Statement");
        setLayout(null);
        
        setTitle("Mini Statement");
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel mini = new JLabel();
        add(mini);
        
        JLabel name = new JLabel("Indian Bank");
        name.setBounds(150, 20, 100, 20);
        add(name);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel total = new JLabel();
        total.setBounds(20, 400, 300, 20);
        add(total);
        
        try{
            Conect conn = new Conect();
            ResultSet rs = conn.s.executeQuery("select * from login where PIN = '"+pinnumber+"'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("Cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("Cardnumber").substring(12));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        	 
        try{
            int balance = 0;
            Conect conn2  = new Conect();
            ResultSet rs1 = conn2.s.executeQuery("SELECT * FROM Bank where pin = '"+pinnumber+"'");
            while(rs1.next()){
                mini.setText(mini.getText() + "<html>"+rs1.getString("Date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("Type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs1.getString("Amount") + "<br><br><html>");
                if(rs1.getString("Type").equals("Deposit")){
                    balance += Integer.parseInt(rs1.getString("Amount"));
                }else{
                    balance -= Integer.parseInt(rs1.getString("Amount"));
                }
            }
            total.setText("Your total Balance is Rs "+balance);
        }catch(Exception e){
            System.out.println(e);
        }
        
        b1 = new JButton("Exit");  
        b1.setBounds(20, 500, 100, 25);
        b1.addActionListener(this);
        add(b1);
        
        mini.setBounds(20, 140, 400, 200);
        
        
        setSize(400,600);
        setLocation(20,20);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        this.setVisible(false);
    }
    
    public static void main(String[] args){
        new Mini("");
    }
    
}