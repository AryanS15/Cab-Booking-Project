import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;  
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.logging.Logger;
import java.sql.*;

/**
 * Simple demo that uses java.util.Timer to schedule a task 
 * to execute once 5 seconds have passed.
 */

public class MyTimer {
	JFrame f;
    Timer timer;
    public String s;
    
    static JLabel l1,l2;
    JButton b1;
    public int TIME;
    public float FARE,WALLET;
    
	
public void showDetails()
{
	b1=new JButton("View Trip Details");
	b1.setBounds(150,300,300,50);
	
	f.add(b1);
    b1.addActionListener(new ActionListener() {
	
		public void actionPerformed(ActionEvent ae) {
			
			new Details(FARE,WALLET, s);
		}
		});
}

    
    public MyTimer(int seconds) {
        timer = new Timer();
	    timer.schedule(new RemindTask(), seconds*1000);
	}
    
    public MyTimer(int time,float wallet,float fare,String dn)
    {
    	try {
    		
    		TIME=time;
    	f= new JFrame("Trip");
    	 l1=new JLabel("Trip started");
 	    l1.setBounds(250,200,400,50);
    	f.add(l1);
    	FARE=fare;
    	WALLET=wallet;
	    f.setSize(700,700);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    new MyTimer(time);
	    showDetails();
    	}
    	catch(Exception e)
    	{
    		
    	}
    	
    	s=dn;
    }

 
	class RemindTask extends TimerTask {

		public void run(){
		l1.setText("Trip finished !");
		timer.cancel(); //Terminate the timer thread
		
		}
		
		

	
}
			
	 
	

}
//no-static can access static variables
//static variables cannot access non-static members
