import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class Loginowner extends JFrame implements ActionListener
{
	Label title = new Label("BILL SYSTEM");
	JLabel usid = new JLabel("User ID: ");
	JTextField usidt =new JTextField();
	JLabel pass = new JLabel("Password: ");
	TextField passt=new TextField();
	
	JButton logine=new JButton("Login");
	JButton cancel=new JButton("Back");
	
	Loginowner()
	{
		setSize(750,680);
		setLocation(400,160);
		setTitle("Bill");
		setLayout(null);
		this.getContentPane().setBackground(new Color(238,130,238));
		
		title.setBounds(200,50,380,40);
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		add(title);
		
		
		usid.setBounds(200,190,200,50);
		add(usid);
		usidt.setBounds(400,190,200,50);
		add(usidt);
		
		pass.setBounds(200,250,200,50);
		add(pass);
		
		passt.setEchoChar('*');
		passt.setBounds(400,250,200,50);
		add(passt);


		logine.setBounds(210,400,100,50);
		add(logine);
		logine.addActionListener(this);

		cancel.setBounds(400,400,100,50);
		add(cancel);
		cancel.addActionListener(this);

	
	
	}
	public void actionPerformed(ActionEvent e)
	{
		String s1=usidt.getText();
		String s2=passt.getText();
		
		if(e.getActionCommand()=="Login")
		{
			if(s1.equals("admin") && s2.equals("admin"))
			{
				//Bill B=new Bill();
				//B.setVisible(true);
				//Loginemployee lee= new Loginemployee();
				Oadmin oa =new Oadmin();
				oa.setVisible(true);
				dispose();
				//setVisible(false);
			
			}
				   
		}
		if(e.getActionCommand()=="Back")
		{
			Starting s= new Starting();
			s.setVisible(true);
			dispose();
			//Loginemployee lee= new Loginemployee();
			//setVisible(false);
		}
	}
	public static void main(String args[])
	{
		Loginowner le = new Loginowner();
		le.setDefaultCloseOperation(3);
		le.setVisible(true);
		
	}
}
