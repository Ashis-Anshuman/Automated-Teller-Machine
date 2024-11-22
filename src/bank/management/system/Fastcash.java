package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    
    JButton exit,rupee1,rupee2,rupee3,rupee6,rupee4,rupee5;
    String pinnumber;
    Fastcash(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon im =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2=im.getImage().getScaledInstance(900,890,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel image=new JLabel(im3);
        image.setBounds(0,0,900,890);
        add(image);
        
        JLabel text=new JLabel("Select Withdraw Amount");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Arial",Font.BOLD,13));
        image.add(text);
        
        rupee1=new JButton("Rs 100");
        rupee1.setBounds(160,415,150,25);
        rupee1.addActionListener(this);
        image.add(rupee1);
        
        rupee2=new JButton("Rs 500");
        rupee2.setBounds(160,450,150,25);
        rupee2.addActionListener(this);
        image.add(rupee2);
        
        rupee3=new JButton("Rs 1000");
        rupee3.setBounds(160,485,150,25);
        rupee3.addActionListener(this);
        image.add(rupee3);
        
        rupee4=new JButton("Rs 2000");
        rupee4.setBounds(355,415,150,25);
        rupee4.addActionListener(this);
        image.add(rupee4);
        
        rupee5=new JButton("Rs 5000");
        rupee5.setBounds(355,450,150,25);
        rupee5.addActionListener(this);
        image.add(rupee5);
        
        rupee6=new JButton("Rs 10000");
        rupee6.setBounds(355,485,150,25);
        rupee6.addActionListener(this);
        image.add(rupee6);
        
        exit=new JButton("BACK");
        exit.setBounds(355,520,150,25);
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else {
            String amount=((JButton)ae.getSource()).getText().substring(3);
            Conect conn = new Conect();
            int balance = 0;
            try{
                ResultSet rs = conn.s.executeQuery("select * from Bank where pin = '"+pinnumber+"'");
                while (rs.next()) {
                    if (rs.getString("Type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("Amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("Amount"));
                    }
                }
                
                if(balance>Integer.parseInt(amount)){
                    Date date=new Date();
                    String query1="insert into Bank values('"+pinnumber+"','"+date+"','Withdraw','"+amount+"')";
                    conn.s.executeQuery(query1);
                    JOptionPane.showMessageDialog(null, "Rs "+amount+" Deposited Successfully");

                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Insufficent Balance");
                    return;
                }
                
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    public static void main(String[]args){
        new Fastcash("");
    }
}
