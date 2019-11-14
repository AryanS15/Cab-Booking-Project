import javax.swing.*;


public class Details {
	JFrame f;
	JLabel l1,l2,l3,l4;
	JButton pay,rate;
	
	

	public Details(float fare,float wallet) {
		try {
		f = new JFrame("Details of the trip");
		l1=new JLabel("You have reached your destination");
		l1.setBounds(300,50,300,30);
		l2=new JLabel("Fare : "+fare);
		
		l2.setBounds(350,100,300,30);
//		pay=JButton
//				l3=new JLabel("Amount of Rs."+fare+" has been deducted from your wallet");
//		l3.setBounds(250,150,400,30);
//wallet=fare;
		//feed to database
		
		rate=jButton
				//feed to database
				//joption "Thank You for riding with us"
		
		l4=new JLabel("Rate Your Trip");
		l4.setBounds(100,0,100,30);
		JRadioButton r1=new JRadioButton("1/10");JRadioButton r2=new JRadioButton("2/10");JRadioButton r3=new JRadioButton("3/10");JRadioButton r4=new JRadioButton("4/10");JRadioButton r5=new JRadioButton("5/10");    
		JRadioButton r6=new JRadioButton("6/10");JRadioButton r7=new JRadioButton("7/10");JRadioButton r8=new JRadioButton("8/10");JRadioButton r9=new JRadioButton("9/10");JRadioButton r10=new JRadioButton("10/10");    
		r1.setBounds(100,25,100,30);r2.setBounds(100,50,100,30);r3.setBounds(100,75,100,30);r4.setBounds(100,100,100,30);r5.setBounds(100,125,100,30);   
		r6.setBounds(100,150,100,30);r7.setBounds(100,175,100,30); r8.setBounds(100,200,100,30);r9.setBounds(100,225,100,30);r10.setBounds(100,250,100,30);
		ButtonGroup bg=new ButtonGroup();    
		bg.add(r1);bg.add(r2);bg.add(r3);bg.add(r4);bg.add(r5);bg.add(r6);bg.add(r7);bg.add(r8);bg.add(r9);bg.add(r10);        
		f.add(r1);f.add(r2);f.add(r3);f.add(r4);f.add(r5);f.add(r6);f.add(r7);f.add(r8);f.add(r9);f.add(r10);
	    
		
		
	    f.add(l1);f.add(l2);f.add(l3);f.add(l4);
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);
		}
		catch(Exception e)
		{
			
		}
		
		
	}
	
	public static void main(String args[])
	{
		new Details(1000,2000);
	}

}
