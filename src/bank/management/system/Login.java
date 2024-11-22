package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,register;
    JTextField cnfield;
    JPasswordField pnfield;
    Login(){
        setTitle("Login page");
        setLayout(null);
        ImageIcon im =new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image im2=im.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel label=new JLabel(im3);
        label.setBounds(70,10,100,100);
        add(label);
        
        JLabel text=new JLabel("Welcome to our Bank");
        text.setFont(new Font("Bodoni MT",Font.BOLD,37));
        text.setBounds(220,40,400,40); 
        add(text);
        
        JLabel Cardno=new JLabel("Enter your Card Number");
        Cardno.setFont(new Font("Aptos Narrow",Font.BOLD,20));
        Cardno.setBounds(105,110,400,40);
        add(Cardno);
        
        cnfield=new JTextField();
        cnfield.setBounds(350,115,250,30);
        cnfield.setFont(new Font("Arial",Font.PLAIN,15));
        add(cnfield);
        
        JLabel Pin=new JLabel("Enter your Pin Numeber");
        Pin.setFont(new Font("Aptos Narrow",Font.BOLD,20));
        Pin.setBounds(105,150,400,40);
        add(Pin);
        
        pnfield=new JPasswordField();
        pnfield.setBounds(350,155,250,30);
        pnfield.setFont(new Font("Arial",Font.PLAIN,15));
        add(pnfield);
        
        login=new JButton("SIGN IN");
        login.setBounds(250,220,100,20);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(370,220,100,20);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        register=new JButton("SIGN UP");
        register.setBounds(260,260,200,20);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,400);
        setVisible(true);
        setLocation(300,200);
    }
    public void actionPerformed (ActionEvent ae){
        if(ae.getSource()==clear){
            cnfield.setText("");
            pnfield.setText("");
        }else if (ae.getSource()==login){
            Conect conn=new Conect();
            String cardnumber=cnfield.getText();
            String pinnumber=pnfield.getText();
            String query="select*from login where Cardnumber='"+cardnumber+"'and PIN='"+pinnumber+"'";
            try{
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            }catch(Exception e){
                System.out.println(e);
            }
//            setVisible(false);
//            new Transaction().setVisible(true);
        }else if (ae.getSource()==register){
            setVisible(false);
            new Register().setVisible(true);
        }
    }
    public static void main(String[]args){
        new Login(); 
    }
}
