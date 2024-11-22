package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Register3 extends JFrame implements ActionListener{
    
    JCheckBox atm,internet,mobile,email,check,ES,declare;
    JRadioButton saving,current,fixed,recurring;
    JButton submit,cancel;
    String formno;
    Register3(String formno){
        this.formno=formno;
        setLayout(null);
        

        setTitle("Registration Form");
        
        ImageIcon im =new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image im2=im.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel label=new JLabel(im3);
        label.setBounds(70,8,100,100);
        add(label);
        
        JLabel Accountdetails=new JLabel("Page 3: Account Details");
        Accountdetails.setFont(new Font("Bookman Old Style",Font.BOLD,27));
        Accountdetails.setBounds(280,40,400,40);
        add(Accountdetails);
        
        JLabel account=new JLabel("Account Type:");
        account.setFont(new Font("Arial",Font.BOLD,18));
        account.setBounds(130,130,300,30);
        account.setBackground(Color.white);
        add(account);
        
        current=new JRadioButton("Current Account");
        current.setFont(new Font("Arial",Font.BOLD,13));
        current.setBounds(200,170,150,30);
        current.setBackground(Color.WHITE);
        add(current);
        
        saving=new JRadioButton("Saving Account");
        saving.setFont(new Font("Arial",Font.BOLD,13));
        saving.setBounds(200,210,150,30);
        saving.setBackground(Color.WHITE);
        add(saving);
        
        fixed=new JRadioButton("Fixed Deposit account");
        fixed.setFont(new Font("Arial",Font.BOLD,13));
        fixed.setBounds(440,170,250,30);
        fixed.setBackground(Color.WHITE);
        add(fixed);
        
        recurring=new JRadioButton("Recurring Account");
        recurring.setFont(new Font("Arial",Font.BOLD,13));
        recurring.setBounds(440,210,150,30);
        recurring.setBackground(Color.WHITE);
        add(recurring);
        
        ButtonGroup accountgroup=new ButtonGroup();
        accountgroup.add(current);
        accountgroup.add(saving);
        accountgroup.add(fixed);
        accountgroup.add(recurring);

        JLabel card=new JLabel("Card Nmber:");
        card.setFont(new Font("Arial",Font.BOLD,17));
        card.setBounds(130,280,150,30);
        add(card);
        
        JLabel message=new JLabel("(Your 16 digits domi card number)");
        message.setFont(new Font("Arial",Font.BOLD,10));
        message.setBounds(130,300,200,30);
        add(message);
        
        JLabel number=new JLabel("XXXX-XXXX-XXXX-5673");
        number.setFont(new Font("Arial",Font.BOLD,16));
        number.setBounds(330,280,300,30);
        add(number);
        
        

        JLabel pin=new JLabel("PIN Number:");
        pin.setFont(new Font("Arial",Font.BOLD,17));
        pin.setBounds(130,340,300,30);
        add(pin);
        
        JLabel message2=new JLabel("(4 Digit PIN Number)");
        message2.setFont(new Font("Arial",Font.BOLD,10));
        message2.setBounds(130,360,300,30);
        add(message2);
        
        JLabel pnumber=new JLabel("XXXX");
        pnumber.setFont(new Font("Arial",Font.BOLD,16));
        pnumber.setBounds(330,340,300,30);
        add(pnumber);
        
        JLabel service=new JLabel("Services Required:");
        service.setFont(new Font("Arial",Font.BOLD,17));
        service.setBounds(130,410,300,30);
        add(service);
        
        atm=new JCheckBox("ATM Card");
        atm.setFont(new Font("Arial",Font.BOLD,13));
        atm.setBackground(Color.WHITE);
        atm.setBounds(200,450,200,30);
        add(atm);  
        
        internet=new JCheckBox("Internet Banking");
        internet.setFont(new Font("Arial",Font.BOLD,13));
        internet.setBackground(Color.WHITE);
        internet.setBounds(440,450,200,30);
        add(internet);
        
        mobile=new JCheckBox("Mobile Banking");
        mobile.setFont(new Font("Arial",Font.BOLD,13));
        mobile.setBackground(Color.WHITE);
        mobile.setBounds(200,490,200,30);
        add(mobile);
        
        email=new JCheckBox("Email Alerts");
        email.setFont(new Font("Arial",Font.BOLD,13));
        email.setBackground(Color.WHITE);
        email.setBounds(440,490,200,30);
        add(email);
        
        check=new JCheckBox("Cheque Book");
        check.setFont(new Font("Arial",Font.BOLD,13));
        check.setBackground(Color.WHITE);
        check.setBounds(200,530,200,30);
        add(check);
        
        ES=new JCheckBox("E-Statement");
        ES.setFont(new Font("Arial",Font.BOLD,13));
        ES.setBackground(Color.WHITE);
        ES.setBounds(440,530,200,30);
        add(ES);
        
        declare=new JCheckBox("I Hereby declares that the above entereed details are correct to the best my knowledge");
        declare.setFont(new Font("Arial",Font.BOLD,10));
        declare.setBackground(Color.WHITE);
        declare.setBounds(100,600,600,30);
        add(declare);
        
        
        submit=new JButton("SUBMIT");
        submit.setFont(new Font("Arial",Font.BOLD,15));
        submit.setForeground(Color.WHITE);
        submit.setBounds(700,700,120,30);
        submit.setBackground(Color.BLUE);
        submit.addActionListener(this);
        add(submit);
        
        cancel=new JButton("CANCEL");
        cancel.setFont(new Font("Arial",Font.BOLD,15));
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(550,700,120,30);
        cancel.setBackground(Color.BLUE);
        cancel.addActionListener(this);
        add(cancel);
         
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(350,5);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if (ae.getSource()==submit){
            String accounttype="";
            if(current.isSelected()){
                accounttype="Current Account";
            }else if (saving.isSelected()){
                accounttype="Saving Account";
            }else if (fixed.isSelected()){
                accounttype="Fixed Depisite Account";
            }else if (recurring.isSelected()){
                accounttype="Recurring Account";
            }
            
            Random rand=new Random();
            String Cardnumber=""+Math.abs((rand.nextLong()%9000000L))+504096310L;
            
            String Pinnumber=""+Math.abs((rand.nextLong()%9000L)+10000L);
            
            String required="";
            if(atm.isSelected()){
                required=required+" ATM Card";
            }else if(internet.isSelected()){
                required=required+" Intenet Banking";
            }else if(mobile.isSelected()){
                required=required+" Mobile Banking";
            }else if(email.isSelected()){
                required=required+" Email Alert";
            }else if(check.isSelected()){
                required=required+" Cheque Book";
            }else if(ES.isSelected()){
                required=required+" E-Statement";
            }
            
            String de="";
            if(declare.isSelected())
                de="Selected";
            
             try{
            if(accounttype.equals("")){
                JOptionPane.showMessageDialog(null, "Error:Please select your account type");
            }else if(required.equals("")){
                JOptionPane.showMessageDialog(null, "Error:Please select atleast one sevices");
            }else if(de.equals("")){
                JOptionPane.showMessageDialog(null, "Error:Please select the Declarition box");
            }
            else{
                Conect c=new Conect();
                String query1="insert into signupthree values('"+formno+"','"+accounttype+"','"+Cardnumber+"','"+Pinnumber+"','"+required+"')";
                String query2="insert into login values('"+formno+"','"+Cardnumber+"','"+Pinnumber+"')";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);

                JOptionPane.showMessageDialog(null,"Card Number: "+Cardnumber+"\n"+"PIN Number: "+Pinnumber);
                
                setVisible(false);
                new Deposit(Pinnumber).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
            
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
        
    }
    public static void main(String[]args){
        new Register3("");
    }
}
