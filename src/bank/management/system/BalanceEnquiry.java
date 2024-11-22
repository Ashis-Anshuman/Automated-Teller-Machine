package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.*;

class BalanceEnquiry extends JFrame implements ActionListener {

    JTextField t1, t2;
    JButton back, b2, b3;
    JLabel l1, l2, l3;
    String pinnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 890, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 890);
        add(image);

        

        back = new JButton("BACK");
        back.setBounds(355,520,150,25);
        back.addActionListener(this);
        image.add(back);
        


        int balance = 0;
        try{
            Conect conn = new Conect();
            ResultSet rs = conn.s.executeQuery("select * from Bank where pin = '"+pinnumber+"'");
            while (rs.next()) {
                if (rs.getString("Type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("Amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("Amount"));
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        l1 = new JLabel("Your Current Account Balance is Rs "+balance);
        l1.setForeground(Color.GREEN);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(170,350,400,20);
        image.add(l1);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transaction(pinnumber).setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }
}