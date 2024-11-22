package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Register2 extends JFrame implements ActionListener{
    
    JTextField PANfield,Adhfield,incomefield;
    JComboBox rel,cata,qual,occ;
    JRadioButton yes,no,yess,noo;
    JButton next;
    String formno;
    Register2(String formno){
        this.formno=formno;
        setLayout(null);
        
        ImageIcon im =new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image im2=im.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon im3=new ImageIcon(im2);
        JLabel label=new JLabel(im3);
        label.setBounds(130,10,100,100);
        add(label);
        
        JLabel forrmno=new JLabel("Appliction form no."+formno);
        forrmno.setFont(new Font("Arial",Font.BOLD,10));
        forrmno.setBounds(650,5,300,60);
        add(forrmno);

        setTitle("Registration Form");
        
        JLabel Additionaldetails=new JLabel("Page 2: Additional Details");
        Additionaldetails.setFont(new Font("Bookman Old Style",Font.BOLD,25));
        Additionaldetails.setBounds(280,40,400,40);
        add(Additionaldetails);
        
        JLabel relgion=new JLabel("Relegion:");
        relgion.setFont(new Font("Arial",Font.BOLD,17));
        relgion.setBounds(130,140,100,30);
        relgion.setBackground(Color.white);
        add(relgion);
        
        String valreligion[]={"Hindu","Muslim","Christian","Sikh","Other"};
        rel=new JComboBox(valreligion);
        rel.setFont(new Font("Arial",Font.PLAIN,15));
        rel.setBounds(300,140,300,25);
        add(rel);
        
        JLabel catagory=new JLabel("Catagory:");
        catagory.setFont(new Font("Arial",Font.BOLD,17));
        catagory.setBounds(130,190,150,30);
        add(catagory);
        
        String valcatagory[]={"General","OBC","ST/SC","Other"};
        cata=new JComboBox(valcatagory);
        cata.setFont(new Font("Arial",Font.PLAIN,15));
        cata.setBounds(300,190,300,25);
        add(cata);
        
        
        JLabel income=new JLabel("Anual Income:");
        income.setFont(new Font("Arial",Font.BOLD,17));
        income.setBounds(130,240,150,30);
        add(income);
        
        incomefield=new JTextField();
        incomefield.setFont(new Font("Arial",Font.PLAIN,15));
        incomefield.setBounds(300,240,300,25);
        add(incomefield);
        
        JLabel qualification=new JLabel("Qualification:");
        qualification.setFont(new Font("Arial",Font.BOLD,17));
        qualification.setBounds(130,290,150,30);
        add(qualification);
        
        String valqualification[]={"Graduate","Non-Graduate","12th class","Below 12th class","None"};
        qual=new JComboBox(valqualification);
        qual.setFont(new Font("Arial",Font.PLAIN,15));
        qual.setBounds(300,290,300,25);
        add(qual);
        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setFont(new Font("Arial",Font.BOLD,17));
        occupation.setBounds(130,340,150,30);
        add(occupation);
        
        String valoccupations[]={"Salaried","Self-Employee","Bussiness","Govt Job","Student","Others"};
        occ=new JComboBox(valoccupations);
        occ.setFont(new Font("Arial",Font.PLAIN,15));
        occ.setBounds(300,340,300,25);
        add(occ);
        
        
        JLabel pan=new JLabel("PAN Number:");
        pan.setFont(new Font("Arial",Font.BOLD,17));
        pan.setBounds(130,390,150,30);
        add(pan);
        
        PANfield=new JTextField();
        PANfield.setFont(new Font("Arial",Font.PLAIN,15));
        PANfield.setBounds(300,390,300,25);
        add(PANfield);
        
        JLabel aadhaar=new JLabel("Aadhaar Number:");
        aadhaar.setFont(new Font("Arial",Font.BOLD,17));
        aadhaar.setBounds(130,440,150,30);
        add(aadhaar);
        
        Adhfield=new JTextField();
        Adhfield.setFont(new Font("Arial",Font.PLAIN,15));
        Adhfield.setBounds(300,440,300,25);
        add(Adhfield);
        
        JLabel senior=new JLabel("Senior Citizen:");
        senior.setFont(new Font("Arial",Font.BOLD,17));
        senior.setBounds(130,490,150,30);
        add(senior);
        
        yes=new JRadioButton("YES");
        yes.setBounds(300,490,50,30);
        yes.setBackground(Color.WHITE);
        add(yes);
        
        no=new JRadioButton("NO");
        no.setBounds(390,490,50,30);
        no.setBackground(Color.WHITE);
        add(no);
        
        ButtonGroup yngroup=new ButtonGroup();
        yngroup.add(yes);
        yngroup.add(no); 
        
        JLabel adress=new JLabel("Existing Account:");
        adress.setFont(new Font("Arial",Font.BOLD,17));
        adress.setBounds(130,540,150,30);
        add(adress);
        
        yess=new JRadioButton("YES");
        yess.setBounds(300,540,70,30);
        yess.setBackground(Color.WHITE);
        add(yess);
        
        noo=new JRadioButton("NO");
        noo.setBounds(390,540,90,30);
        noo.setBackground(Color.WHITE);
        add(noo);
        
        ButtonGroup yn2group=new ButtonGroup();
        yn2group.add(yess);
        yn2group.add(noo);
        
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
//        String formno=;
        String Relegion=(String)rel.getSelectedItem();
        String Scatagory=(String)cata.getSelectedItem();
        String Sincome=incomefield.getText();
        String Squalification=(String)qual.getSelectedItem();
        String Soccupation=(String)occ.getSelectedItem();
        String PAN=PANfield.getText();
        String Adhar=Adhfield.getText();
        String Ssenior="";
        if(yes.isSelected()){
            Ssenior="YES";
        }else if (no.isSelected()){
            Ssenior="NO";
        }
        String acount="";
        if(yess.isSelected()){
            acount="YES";
        }else if (noo.isSelected()){
            acount="NO";
        }
        
        try{
            if(Relegion.equals("")){
                JOptionPane.showMessageDialog(null, "Please Provide your anual income");
            }else if(Scatagory.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(Sincome.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(Squalification.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(Soccupation.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(PAN.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(Adhar.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(Ssenior.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else if(acount.equals("")){
                JOptionPane.showMessageDialog(null, "Please provide all details");
            }else{
                Conect c=new Conect();
                String query="insert into signuptwo values('"+formno+"','"+Relegion+"','"+Scatagory+"','"+Sincome+"','"+Squalification+"','"+Soccupation+"','"+PAN+"','"+Adhar+"','"+Ssenior+"','"+acount+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new Register3(formno).setVisible(true);
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    public static void main(String[]args){
        new Register2("");
    }
}
