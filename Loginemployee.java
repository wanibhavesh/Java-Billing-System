import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;


public class Loginemployee extends JFrame implements ActionListener
{
	Label title = new Label("BILL SYSTEM");
	Label title2 = new Label("EMPLOYEE");
	Label uname=new Label("User Name:");
	TextField unamet=new TextField();
	Label password=new Label("Password:");
	TextField passwordl=new TextField();

	Button logine=new Button("Login");
	Button cancel=new Button("Back");

	Loginemployee()			
	{
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setSize(750,680);
		setLocation(400,160);
		setTitle("Bill System");
		setLayout(null);
		this.getContentPane().setBackground(new Color(102,102,225));
		
		Font font1 =new Font("Verdana",Font.BOLD,20);

		title.setBounds(200,50,380,40);
		title.setAlignment(Label.CENTER);
		title.setFont(new Font("Serif", Font.BOLD, 30));
		add(title);
		
		title2.setBounds(300,110,200,40);
		//title2.setAlignment(Label.CENTER);
		title2.setFont(new Font("Serif", Font.BOLD, 30));
		add(title2);
		
		
		uname.setBounds(180,250,200,50);
		uname.setFont(font1);
		add(uname);

		unamet.setBounds(400,250,200,50);
		unamet.setFont(font1);
		add(unamet);
		
		password.setBounds(180,350,200,50);
		password.setFont(font1);
		add(password);
		passwordl.setEchoChar('*');
		passwordl.setBounds(400,350,200,50);
		passwordl.setFont(font1);
		add(passwordl);


		logine.setBounds(200,560,100,30);
		logine.setFont(font1);
		logine.setBackground(new Color(225,0,0));
		add(logine);
		logine.addActionListener(this);

		cancel.setBounds(500,560,100,30);
		cancel.setFont(font1);
		cancel.setBackground(new Color(225,0,0));
		add(cancel);
		cancel.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e)
	{
		
		
	if(e.getActionCommand()=="Login")
	{	
		try {
          File file = new File("userPass.txt");
          Scanner scan = new Scanner(file);;
          String line = null;
          FileWriter filewrite = new FileWriter(file, true);

          String usertxt = " ";
          String passtxt = " ";
          String puname = unamet.getText();
          String ppaswd = passwordl.getText();


          while (scan.hasNext()) {
            usertxt = scan.nextLine();
            passtxt = scan.nextLine();

          }
          
        if(puname.equals(usertxt) && ppaswd.equals(passtxt)) {
           // MainMenu menu =new MainMenu();
           
           Bill b = new Bill();
           b.setVisible(true);
            dispose();
          } 
          else if(puname.equals("") && ppaswd.equals("")){
            JOptionPane.showMessageDialog(null,"Please insert Username and Password");
          }
          else {

            JOptionPane.showMessageDialog(null,"Wrong Username / Password");
            unamet.setText("");
            passwordl.setText("");
            passwordl.requestFocus();
          }
        } 
        catch (IOException d) {
          d.printStackTrace();
        }

        
         } 
          if(e.getActionCommand()=="Back")
		{
			Starting s= new Starting();
			s.setVisible(true);
			//Loginemployee lee= new Loginemployee();
			//lee.setVisible(false);
			dispose();
		}
	}


	public static void main(String args[])
	{
		Loginemployee le= new Loginemployee();
		le.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		le.setVisible(true);
	}
}

