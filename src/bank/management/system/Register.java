package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class Register extends JFrame implements ActionListener{
    
    long random;
    JTextField nfield,Ffield,Mfield,PNfield,EAfield,adressfield,statefield,Cfield,PINfield;
    JDateChooser date;
    JRadioButton male,female,other,maried,unmaried;
    JButton next;
    Register(){
        
        setLayout(null);
        ImageIcon im =new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image im2=im.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel label=new JLabel(im3);
        label.setBounds(70,8,100,100);
        add(label);
        
        Random rand=new Random();
        random=Math.abs((rand.nextLong()%9000L)+1000L);
        
        JLabel formno=new JLabel("Appliction form no."+random);
        formno.setFont(new Font("Arial",Font.BOLD,40));
        formno.setBounds(190,10,600,60);
        add(formno);
        setTitle("Registration Form ");
        
        JLabel Details=new JLabel("Page 1: Personal Details");
        Details.setFont(new Font("Arial",Font.BOLD,25));
        Details.setBounds(250,70,400,40);
        add(Details);
        
        JLabel Name=new JLabel("Name:");
        Name.setFont(new Font("Arial",Font.BOLD,17));
        Name.setBounds(130,140,100,30);
        add(Name);
        
        nfield=new JTextField();
        nfield.setFont(new Font("Arial",Font.PLAIN,15));
        nfield.setBounds(300,140,300,25);
        add(nfield);
        
        JLabel Father=new JLabel("Father's Name:");
        Father.setFont(new Font("Arial",Font.BOLD,17));
        Father.setBounds(130,190,150,30);
        add(Father);
        
        Ffield=new JTextField();
        Ffield.setFont(new Font("Arial",Font.PLAIN,15));
        Ffield.setBounds(300,190,300,25);
        add(Ffield);
        
        JLabel Mother=new JLabel("Mother's Name:");
        Mother.setFont(new Font("Arial",Font.BOLD,17));
        Mother.setBounds(130,240,150,30);
        add(Mother);
        
        Mfield=new JTextField();
        Mfield.setFont(new Font("Arial",Font.PLAIN,15));
        Mfield.setBounds(300,240,300,25);
        add(Mfield);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Arial",Font.BOLD,17));
        dob.setBounds(130,290,150,30);
        add(dob);
        
        date=new JDateChooser();
        date.setFont(new Font("Arial",Font.BOLD,15));
        date.setBounds(300,290,300,25);
        add(date);
        
        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Arial",Font.BOLD,17));
        gender.setBounds(130,340,150,30);
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(300,340,60,30);
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(390,340,70,30);
        female.setBackground(Color.WHITE);
        add(female);
        
        other=new JRadioButton("Other");
        other.setBounds(500,340,60,30);
        other.setBackground(Color.WHITE);
        add(other);
        
        ButtonGroup gendergroup= new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel Email=new JLabel("E-Mail Address:");
        Email.setFont(new Font("Arial",Font.BOLD,17));
        Email.setBounds(130,390,150,30);
        add(Email);
        
        EAfield=new JTextField();
        EAfield.setFont(new Font("Arial",Font.PLAIN,15));
        EAfield.setBounds(300,390,300,25);
        add(EAfield);
        
        JLabel Phone=new JLabel("Phone Number:");
        Phone.setFont(new Font("Arial",Font.BOLD,17));
        Phone.setBounds(130,440,150,30);
        add(Phone);
        
        PNfield=new JTextField();
        PNfield.setFont(new Font("Arial",Font.PLAIN,15));
        PNfield.setBounds(300,440,300,25);
        add(PNfield);
        
        JLabel mari=new JLabel("Marital Status:");
        mari.setFont(new Font("Arial",Font.BOLD,17));
        mari.setBounds(130,490,150,30);
        add(mari);
        
        maried=new JRadioButton("Maried");
        maried.setBounds(300,490,70,30);
        maried.setBackground(Color.WHITE);
        add(maried);
        
        unmaried=new JRadioButton("Unmaried");
        unmaried.setBounds(390,490,90,30);
        unmaried.setBackground(Color.WHITE);
        add(unmaried);
        
        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(maried);
        maritalgroup.add(unmaried); 
        
        JLabel adress=new JLabel("Adress:");
        adress.setFont(new Font("Arial",Font.BOLD,17));
        adress.setBounds(130,540,150,30);
        add(adress);
        
        adressfield=new JTextField();
        adressfield.setFont(new Font("Arial",Font.PLAIN,15));
        adressfield.setBounds(300,540,300,25);
        add(adressfield);
        
        JLabel state=new JLabel("State:");
        state.setFont(new Font("Arial",Font.BOLD,17));
        state.setBounds(130,590,150,30);
        add(state);
        
        statefield=new JTextField();
        statefield.setFont(new Font("Arial",Font.PLAIN,15));
        statefield.setBounds(300,590,300,25);
        add(statefield);
        
        JLabel city=new JLabel("City/Village Name:");
        city.setFont(new Font("Arial",Font.BOLD,17));
        city.setBounds(130,640,150,30);
        add(city);
        
        Cfield=new JTextField();
        Cfield.setFont(new Font("Arial",Font.PLAIN,15));
        Cfield.setBounds(300,640,300,25);
        add(Cfield);
        
        JLabel pin=new JLabel("PIN Code:");
        pin.setFont(new Font("Arial",Font.BOLD,17));
        pin.setBounds(130,690,150,30);
        add(pin);
        
        PINfield=new JTextField();
        PINfield.setFont(new Font("Arial",Font.PLAIN,15));
        PINfield.setBounds(300,690,300,25);
        add(PINfield);
        
        next=new JButton("NEXT");
        next.setFont(new Font("Arial",Font.BOLD,15));
        next.setForeground(Color.WHITE);
        next.setBounds(700,730,90,30);
        next.setBackground(Color.BLUE);
        next.addActionListener(this);
        add(next);
         
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,830);
        setLocation(350,5);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String formno=""+random;
        String name=nfield.getText();
        String fname=Ffield.getText();
        String mname=Mfield.getText();
        String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
        String gender="";
        if(male.isSelected()){
            gender="Male";
        }else if (female.isSelected()){
            gender="Female";
        }else if (other.isSelected()){
            gender="Other";
        }
        String email=EAfield.getText();
        String phone=PNfield.getText();
        String marital="";
        if(maried.isSelected()){
            marital="Maried";
        }else if (unmaried.isSelected()){
            marital="Unmaried";
        }
        String adress=adressfield.getText();
        String state=statefield.getText();
        String cv=Cfield.getText();
        String pin=PINfield.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(fname.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(mname.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(dob.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(gender.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(email.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(phone.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(marital.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(adress.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(state.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(cv.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(pin.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else{
                Conect c=new Conect();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+mname+"','"+dob+"','"+gender+"','"+email+"','"+phone+"','"+marital+"','"+adress+"','"+state+"','"+cv+"','"+pin+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Register2(formno).setVisible(true);
                
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String[]args){
        new Register();
    }
}
