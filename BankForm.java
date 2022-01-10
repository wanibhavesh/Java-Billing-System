import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.applet.*;

public class BankForm extends JFrame implements ActionListener
{
	Label title = new Label("BANK OF JALGAON");	
	Label name= new Label("Name:");
	TextField name1= new TextField();
	Label aadhar= new Label("Aadhar No:");
	TextField aadhar1= new TextField();
	Label address= new Label("Address:");
	TextField address1= new TextField();
	Label city= new Label("City:");
	TextField city1= new TextField();
	Label state= new Label("State:");
	TextField state1= new TextField();
	Label country= new Label("Country:");
	TextField country1= new TextField();
	Label mob= new Label("Mobile No:");
	TextField mob1= new TextField();
	Label email= new Label("Email:");
	TextField email1= new TextField();
	Label password= new Label("Create Password:");
	TextField password1= new TextField();
	Label cpassword= new Label("Confirm Password:");
	TextField cpassword1= new TextField();

	Label info= new Label("The bank name is imaginary, resemblance to any bank functional or non functional is purely coincidental.");

	Button save= new Button("SAVE");
	Button clear= new Button("CLEAR");
	Button cancel= new Button("CANCEL");

	BankForm()
	{
		setSize(1000,700);
		setTitle("Bank Form");
		setContentPane(new JLabel(new ImageIcon("/home/harish/Desktop/abc.jpg")));
		setLayout(null);
		
		title.setBounds(310,50,380,40);
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		add(title);
		name.setBounds(290,120,200,30);
		add(name);
		name1.setBounds(510,120,200,30);
		add(name1);
		aadhar.setBounds(290,160,200,30);
		add(aadhar);
		aadhar1.setBounds(510,160,200,30);
		add(aadhar1);
		address.setBounds(290,200,200,30);
		add(address);
		address1.setBounds(510,200,200,30);
		add(address1);
		city.setBounds(290,240,200,30);
		add(city);
		city1.setBounds(510,240,200,30);
		add(city1);
		state.setBounds(290,280,200,30);
		add(state);
		state1.setBounds(510,280,200,30);
		add(state1);
		country.setBounds(290,320,200,30);
		add(country);
		country1.setBounds(510,320,200,30);
		add(country1);
		email.setBounds(290,360,200,30);
		add(email);
		email1.setBounds(510,360,200,30);
		add(email1);
		password.setBounds(290,400,200,30);
		add(password);
		password1.setEchoChar('*');
		cpassword1.setEchoChar('*');
		password1.setBounds(510,400,200,30);
		add(password1);
		cpassword.setBounds(290,440,200,30);
		cpassword1.setBounds(510,440,200,30);
		add(cpassword1);
		add(cpassword);

		info.setBounds(150,650,700,30);
		info.setAlignment(Label.CENTER);
		info.setFont(new Font("Arial", Font.BOLD, 11));
		add(info);

		save.setBounds(310,520,100,30);
		add(save);
		save.addActionListener(this);
		clear.setBounds(450,520,100,30);
		add(clear);
		clear.addActionListener(this);
		cancel.setBounds(590,520,100,30);
		add(cancel);
		cancel.addActionListener(this);

	}
	
	public void actionPerformed(ActionEvent e)
	{
		String s1= name1.getText();
		String s2= address1.getText();
		String s3= city1.getText();
		String s4= state1.getText();
		String s5= country1.getText();
		String s6= email1.getText();
		String s7= password1.getText();
		String s8= cpassword1.getText();
		boolean valid= false;

		if(e.getActionCommand()=="SAVE")
		{
			if(checked())
			{
				if(s7!=s8)
				{
					JOptionPane.showMessageDialog(save,"Password Does Not Match");
					cpassword1.setText("");
				}
				
			}
			else
			{
				save.setVisible(true);
				JOptionPane.showMessageDialog(save,"Data Saved");
				name1.setText("");
				//aadhar1.setText("");
				address1.setText("");
				city1.setText("");
				state1.setText("");
				country1.setText("");
				email1.setText("");
				password1.setText("");
				cpassword1.setText("");
			}
		}
		else
			JOptionPane.showMessageDialog(save,"Data Not Saved\n Please Enter Correct Data");
		
		if(e.getActionCommand()=="CLEAR")
		{
			name1.setText("");
			//aadhar1.setText("");
			address1.setText("");
			city1.setText("");
			state1.setText("");
			country1.setText("");
			email1.setText("");
			password1.setText("");
			cpassword1.setText("");

		}
		
		if(e.getActionCommand()=="CANCEL")
			System.exit(0);
	}

	public int checkInput(String s)
	{
		int i,flag=1;
		for(i=0;i<s.length();i++)
		{
			if(!Character.isLetter(s.charAt(i)) && !Character.isWhitespace(s.charAt(i)))
			{
				flag=1;
				return(1);
			}
		}
		return(0);
	}
	
	public boolean checked()
	{
		String s1= name1.getText();
		String s2= city1.getText();
		String s3= state1.getText();
		String s4= country1.getText();
		//int s9= aadhar1.getText();

		int n1= checkInput(s1);
		int n2= checkInput(s2);
		int n3= checkInput(s3);
		int n4= checkInput(s4);
		//int n9= checkInput(s9);

		if(n1==1)
		{
			JOptionPane.showMessageDialog(save,"Please Enter Valid Name");
			name1.setText("");
			return(false);
		}

		if(n2==1)
		{
			JOptionPane.showMessageDialog(save,"Please Enter Valid city");
			city1.setText("");
			return(false);
		}

		if(n3==1)
		{
			JOptionPane.showMessageDialog(save,"Please Enter Valid State");
			state1.setText("");
			return(false);
		}

		if(n4==1)
		{
			JOptionPane.showMessageDialog(save,"Please Enter Valid country");
			country1.setText("");
			return(false);
		}
		
			return(false);
	}

	public static void main(String args[])
	{
		BankForm f= new BankForm();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
}

