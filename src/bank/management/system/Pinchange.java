package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Pinchange extends JFrame implements ActionListener{
    
    JPasswordField t1,t2;
    JButton b1,b2;                               
    JLabel change,ne,re;
    String pinnumber;
    Pinchange(String pinnumber){
        this.pinnumber = pinnumber;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900,890, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 890);
        add(image);
        
        change = new JLabel("CHANGE YOUR PIN");
        change.setFont(new Font("System", Font.BOLD, 16));
        change.setForeground(Color.GREEN);
        change.setBounds(250,300,500,20);
        image.add(change);
        
        ne = new JLabel("New PIN:");
        ne.setFont(new Font("System", Font.BOLD, 16));
        ne.setForeground(Color.GREEN);
        ne.setBounds(200,350,150,25);
        image.add(ne);
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 25));
        t1.setBounds(320,350,150,25);
        image.add(t1);
        
        re = new JLabel("Re-Enter New PIN:");
        re.setFont(new Font("System", Font.BOLD, 16));
        re.setForeground(Color.GREEN);
        re.setBounds(175,395,200,35);
        image.add(re);
  
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 25));
        t2.setBounds(320,400,150,25);
        image.add(t2);
        
        b1 = new JButton("CHANGE");
        b1.addActionListener(this);
        b1.setBounds(355,485,150,25);
        image.add(b1);
        
        b2 = new JButton("BACK");
        b2.addActionListener(this);
        b2.setBounds(355,520,150,25);
        image.add(b2);
        
        setLayout(null);
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{        
                String npin = t1.getText();
                String rpin = t2.getText();

                if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                    if (t1.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Enter New PIN");
                    }
                    if (t2.getText().equals("")){
                        JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                    }
                    
                    Conect c1 = new Conect();
                    String q1 = "update Bank set pin = '"+rpin+"' where pin = '"+pinnumber+"' ";
                    String q2 = "update login set PIN = '"+rpin+"' where PIN = '"+pinnumber+"' ";
                    String q3 = "update signupthree set Pin_Number = '"+rpin+"' where Pin_Number = '"+pinnumber+"' ";
    
                    c1.s.executeUpdate(q1);
                    c1.s.executeUpdate(q2);
                    c1.s.executeUpdate(q3);
    
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");
                    setVisible(false);
                    new Transaction(rpin).setVisible(true);   
            }catch(Exception e){
                System.out.println(e);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        
    }

    public static void main(String[] args){
        new Pinchange("");
    }
}