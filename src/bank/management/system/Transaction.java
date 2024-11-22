package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transaction extends JFrame implements ActionListener{
    
    JButton deposite,withdraw,mini,balance,exit,fast,pin;
    String pinnumber;
    Transaction(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);
        
        ImageIcon im =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image im2=im.getImage().getScaledInstance(900,890,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel image=new JLabel(im3);
        image.setBounds(0,0,900,890);
        add(image);
        
        JLabel text=new JLabel("Pleaase select your Transation");
        text.setBounds(235,300,700,35);
        text.setForeground(Color.GREEN);
        text.setFont(new Font("Arial",Font.BOLD,13));
        image.add(text);
        
        deposite=new JButton("Deposite");
        deposite.setBounds(160,415,150,25);
        deposite.addActionListener(this);
        image.add(deposite);
        
        fast=new JButton("Fast Cash");
        fast.setBounds(160,450,150,25);
        fast.addActionListener(this);
        image.add(fast);
        
        mini=new JButton("Mini Statement");
        mini.setBounds(160,485,150,25);
        mini.addActionListener(this);
        image.add(mini);
        
        withdraw=new JButton("Withdraw");
        withdraw.setBounds(355,415,150,25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        balance=new JButton("Balance Enqury");
        balance.setBounds(355,450,150,25);
        balance.addActionListener(this);
        image.add(balance);
        
        pin=new JButton("PIN Change");
        pin.setBounds(355,485,150,25);
        pin.addActionListener(this);
        image.add(pin);
        
        exit=new JButton("Exit");
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
            System.exit(0);
        }else if(ae.getSource()==deposite){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==pin){
            setVisible(false);
            new Pinchange(pinnumber).setVisible(true);
        }else if(ae.getSource()==mini){
            setVisible(false);
            new Mini(pinnumber).setVisible(true);
        }else if(ae.getSource()==fast){
            setVisible(false);
            new Fastcash(pinnumber).setVisible(true);
        }
    }
    
    
    public static void main(String[]args){
        new Transaction("");
    }
}
