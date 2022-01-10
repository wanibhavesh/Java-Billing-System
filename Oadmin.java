import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Oadmin extends JFrame
{
  JButton chkbill;
  JButton newUSer;
  JButton bck;

  public Oadmin(){

    chkbill = new JButton("Check Bill");
    newUSer = new JButton("New User?");
    bck = new JButton("Back");
    
    setSize(750,680);
    setLocation(400,160);
    this.getContentPane().setBackground(new Color(238,130,238));
    setLocation(500,280);
    setLayout (null); 
	chkbill.setBounds(250,150,200,50);
	add(chkbill);
	newUSer.setBounds(250,250,200,50);
	add(newUSer);
	bck.setBounds(250,350,200,50);
	add(bck);
	
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    chkbill.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            ReadBill rb = new ReadBill();
            rb.setVisible(true);
            dispose();
        }
    });
    newUSer.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent ex)
        {
            NewUser nu = new NewUser();
            nu.setVisible(true);
            dispose();
        }
    });
    bck.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent exx)
        {
            Loginowner lo =new Loginowner();
            lo.setVisible(true);
            dispose();
        }
    });

    }
   /* public void actionPerformed(ActionEvent ex)
    {
    	if(ex.getActionCommand()=="Check Bill");
    	{
    		ReadBill rb = new ReadBill();
    		rb.setVisible(true);
    		dispose();
    		//setVisible(false);
    	} 
    	if(ex.getActionCommand()=="New User?")
    	{
    		NewUser nu = new NewUser();
    		nu.setVisible(true);
    		dispose();
    		//setVisible(false);
    	}
    	if(ex.getActionCommand()=="Back")
    	{
    		Loginowner lo =new Loginowner();
    		lo.setVisible(true);
    		dispose();
    		//setVisible(false);
    	}
    }*/
    		




    
	public static void main(String args[])
    {
		 new Oadmin();
	}
	
}
