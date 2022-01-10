
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Starting extends JFrame implements ActionListener
{
	Label title = new Label("BILL SYSTEM");
	Label title2 =new Label("OWNER");
	Button logino= new Button("LOGIN AS OWNER");
	Button logine= new Button("LOGIN AS EMPLOYEE");
	Button Exist= new Button("EXIT");
	Starting()
	{
		setSize(750,680); 
		setLocation(400,160);
		setTitle("Bill System");
		setContentPane(new JLabel());
		setLayout(null);
		setBackground(Color.GREEN);
		title.setBounds(220,50,280,40);
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		add(title);
		title2.setBounds(300,110,150,40);
		title2.setFont(new Font("Serif", Font.BOLD, 30));
		add(title2);
		
		
		logino.setBounds(250,200,200,60);
		add(logino);
		logino.addActionListener(this);

		logine.setBounds(250,300,200,60);
		add(logine);
		logine.addActionListener(this);

		Exist.setBounds(250,400,200,60);
		add(Exist);
		Exist.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getActionCommand()=="LOGIN AS OWNER")
		{   
			Loginowner lo=new Loginowner();
			lo.setVisible(true);
			dispose();
			//setVisible(false);
		}


		if(e.getActionCommand()=="LOGIN AS EMPLOYEE")
		{
			Loginemployee le=new Loginemployee();
			le.setVisible(true);
			dispose();
			//setVisible(false);
		
		
		}
		if(e.getActionCommand()=="EXIT")
		{
			System.exit(0);
		}
	}

	
	public static void main(String args[])
	{
		Starting s= new Starting();
		s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		s.setVisible(true);
	}
}

