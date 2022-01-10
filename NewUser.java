import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class NewUser extends JFrame {
  JButton create;
  JPanel newUserPanel;
  JTextField txuserer;
  JTextField passer;
  JLabel usrid;
  JLabel pass;


  public NewUser(){
    super("Registration");

    create = new JButton("Create");
    newUserPanel = new JPanel();
    txuserer = new JTextField(15);
    passer = new JPasswordField(15);
    usrid=new JLabel("New User ID:");
    pass = new JLabel("Password");
    


    setSize(750,680);
    setLocation(400,160);
    newUserPanel.setLayout (null); 
    Font font1 = new Font("Verdana",Font.BOLD,20);

    txuserer.setBounds(350,150,180,50);
    txuserer.setFont(font1);
    passer.setBounds(350,250,180,50);
    passer.setFont(font1);
    usrid.setBounds(150,150,180,50);
    usrid.setFont(font1);
    pass.setBounds(150,250,180,50);
    pass.setFont(font1);
    create.setBounds(250,350,180,40);
    create.setFont(font1);
    

    newUserPanel.add(create);
    newUserPanel.add(txuserer);
    newUserPanel.add(passer);
    newUserPanel.add(pass);
    newUserPanel.add(usrid);
    newUserPanel.setBackground( new Color(210,105,30));


    getContentPane().add(newUserPanel);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    Writer writer = null;
    File check = new File("userPass.txt");
    if(check.exists()){

      //Checks if the file exists. will not add anything if the file does exist.
    }else{
      try{
        File texting = new File("userPass.txt");
        writer = new BufferedWriter(new FileWriter(texting));
        writer.write("message");
      }catch(IOException e){
        e.printStackTrace();
      }
    }




    create.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
    File file = new File("userPass.txt");
    Scanner scan = new Scanner(file);;

      FileWriter filewrite = new FileWriter(file, true);

      String usertxter = " ";
      String passtxter = " ";
      String punamer = txuserer.getText();
      String ppaswder = passer.getText();
      while (scan.hasNext()) {
        usertxter = scan.nextLine();
        passtxter = scan.nextLine();
      }

        if(punamer.equals(usertxter) && ppaswder.equals(passtxter)) {
           JOptionPane.showMessageDialog(null,"Username is already in use");
          txuserer.setText("");
          passer.setText("");
          txuserer.requestFocus();

        } 
        else if(punamer.equals("") && ppaswder.equals("")){
        JOptionPane.showMessageDialog(null,"Please insert Username and Password");
        }
        else {
        filewrite.write(punamer+"\r\n" +ppaswder+ "\r\n");
        filewrite.close();
        JOptionPane.showMessageDialog(null,"Account has been created.");
        dispose();
        //Login log = new Login();
        Oadmin oa =new Oadmin();
        oa.setVisible(true);
        dispose();
        //setVisible(false);



        }
        } catch (IOException d) {
      d.printStackTrace();
    }

      }
    });
  } 
  public static void main(String[] args) {
        new NewUser();
  }

}
