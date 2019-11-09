import javax.swing.*;    
public class Option {    
JFrame f;    
Option(){    
    f=new JFrame("ComboBox Example");    
    String point[]={"BPHC","Secunderabad Railway Station","Thumkunta","Airport","Parade Ground"};        
    JLabel l1,l2;
    l1=new JLabel("From : ");
    l1.setBounds(50,25,250,20);
	
	JComboBox<Object> cb= new JComboBox<Object>(point);    
    cb.setBounds(50, 50,250,20);  
    
    l2=new JLabel("To : ");
    l2.setBounds(350,25,250,20);
    
	JComboBox<Object> ed= new JComboBox<Object>(point);    
    ed.setBounds(350, 50,250,20);
    
    JButton b= new JButton("Proceed");
    b.setBounds(275,100,95,30);
    f.add(cb);f.add(ed);
    f.add(l1);f.add(l2);
    f.add(b);
    
    f.setLayout(null);    
    f.setSize(800,800);    
    f.setVisible(true);    
    
    //code for point != point condition
}    
public static void main(String[] args) {    
    new Option();         
}    
} 