package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.ResultSet;
public class Withdraw extends JFrame implements ActionListener{
    JButton withdraw,back;
    JTextField amount;
    String pinnumber;
    Withdraw(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,890,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,890);
        add(image);

        JLabel text=new JLabel("Enter the amount in 100 & 500:");
        text.setForeground(Color.GREEN);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(170,300,400,20);
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,485,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);

        back=new JButton("Back");
        back.setBounds(355,520,150,25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdraw){
            String dep=amount.getText();
            Date date=new Date();
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
            if(dep.equals("")){
                JOptionPane.showMessageDialog(null, "Please Enter the ammount!!");
            }else if(Integer.parseInt(dep)%100!=0){
                JOptionPane.showMessageDialog(null, "Please Enter the amount in 100 & 500 ");
            }else if(balance<Integer.parseInt(dep)){
                JOptionPane.showMessageDialog(null, "Insufficent Balance");
            }
            else{
                try{
                    Conect conn=new Conect();
                    String query="insert into Bank values('"+pinnumber+"','"+date+"','withdraw','"+dep+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+dep+" withdraw Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }catch(Exception e){
                    System.out.println(e);
                }
                
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
    public static void main(String[]args){
        new Withdraw("");
    }
}