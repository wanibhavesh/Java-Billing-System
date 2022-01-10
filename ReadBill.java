import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ReadBill extends JFrame  {
  JButton generate;
  JTextField billnot;
  JTextField cnamet;
  JTextField totlt;
  JButton bck;
  JLabel billno;
  JLabel cname;
  JLabel totl;
  
  JTextArea t11;
  

  public ReadBill(){
    
    generate = new JButton("Generate");
    billnot = new JTextField();
    billno = new JLabel("Bill NO: ");
    cname = new JLabel("Customer Name:");
    cnamet = new JTextField();
    totl=new JLabel("Total");
    totlt =new JTextField();
    bck =new JButton("Back");
    
    t11 = new JTextArea();
    
    setSize(750,680);
    setLocation(400,160);
    this.getContentPane().setBackground(new Color(238,130,238));
    setLocation(500,280);
    setLayout (null); 
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);  


    billno.setBounds(100,50,100,40);
    add(billno);
    billnot.setBounds(200,50,100,40);
    add(billnot);
    generate.setBounds(420,50,200,40);
    add(generate);
    //generate.addActionListener(this);
    
    t11.setBounds(150,150,450,400);
    add(t11);
    t11.setEditable(false);
    
    bck.setBounds(270,590,100,40);
    add(bck);
	bck.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Oadmin oa =new Oadmin();
				oa.setVisible(true);
				dispose();
				//setVisible(false);
			}
		});
    
    	generate.addActionListener(new ActionListener()
	{
    
    		public void actionPerformed(ActionEvent eq)
		{
			try{
				String bno=billnot.getText();
			
				File file = new File(bno+".txt");
				FileInputStream fis = new FileInputStream(file);
				byte[] data = new byte[(int) file.length()];
				fis.read(data);
				fis.close();

				String str = new String(data, "UTF-8");
				
				t11.setText(str);
			}
			catch(Exception qq)
			{
			}	
		}
	});
    
    
    
    
    
    
    
  }
	public static void main(String args[])
	{
		 new ReadBill();
		 
	}
	
}
