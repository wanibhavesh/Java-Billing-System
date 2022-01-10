import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.applet.*;
import java.util.Calendar;
import java.util.Date;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;  
import java.util.Date;  

public class Bill extends JFrame implements ActionListener  
{
	JLabel cust=new JLabel(" Customer name ");
	TextField custl = new TextField();
	JLabel dat = new JLabel(" Date ");
	JTextField datl = new JTextField(6);
	JLabel ut = new JLabel("Units Left");
	JTextField utl =new JTextField();
	JLabel itm = new JLabel("Items");
	String items[]={"","Laptop","Mouse","Moniter"};
	JComboBox si = new JComboBox(items);
	JLabel price = new JLabel("Price");
	JTextField pricel = new JTextField(6);
	JLabel units = new JLabel("Units");
	JTextField unitsl = new JTextField(5); 	
	JButton additem = new JButton("ADD");
	JLabel tax = new JLabel("Tax");
	JTextField taxl= new JTextField(3);
	JButton chkstk = new JButton("Generate Bill");
	JLabel total = new JLabel("Total");
	JTextField totall = new JTextField(5);
	JTextField billno = new JTextField();
	JButton logut = new JButton("Logout");
	FileInputStream rd = null;
    FileOutputStream wt = null;

	
	double p,t,u,tl,taxs,ftl;
	double s;
	double totalp[] =new double [100];
	double sum;
	int count=0;
	static int cb;
	static int c;
	static int bnn;
	String bn;
	static int flag=1;
	Bill()
	{
		try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("frameback1.jpg")))));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		setSize(800,750); 
		setLocation(400,90);
		setTitle(" Bill ");
		setLayout(null);
		cust.setBounds(50,50,100,30);
		add(cust);
		custl.setBounds(180,50,200,30);
		custl.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent t) {
                char caracter = t.getKeyChar();
                if (!((caracter < '0') || (caracter > '9'))) {
                    	t.consume();
                	}
            		}
        	});
		
		
		
		getContentPane().add(custl);
		dat.setBounds(500,50,100,30);
		add(dat);
		datl.setBounds(550,50,200,30);
		
		Date date = new Date();
  	 	//System.out.println(dateFormat.format(date));
   		datl.setText(DateFormat.format(date));
		getContentPane().add(datl);
		
		itm.setBounds(55,120,200,30);
		add(itm);
		si.setBounds(180,120,200,30);
		getContentPane().add(si);
		price.setBounds(500,120,200,30);
		add(price);
		pricel.setBounds(550,120,200,30);
		getContentPane().add(pricel);
		pricel.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent q) {
                char caracter = q.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    	q.consume();
                	}
            		}
        	});
		
		
		units.setBounds(55,190,100,30);
		add(units);
		unitsl.setBounds(180,190,100,30);
		getContentPane().add(unitsl);
		unitsl.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent w) {
                char caracter = w.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    	w.consume();
                	}
            		}
        	});
		
		tax.setBounds(350,190,60,30);
		add(tax);
		taxl.setBounds(420,190,100,30);
		getContentPane().add(taxl);
		taxl.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent r) {
                char caracter = r.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    	r.consume();
                	}
            		}
        	});
        	
        	billno.setBounds(5,5,50,30);
        	billno.setEditable(false);
		getContentPane().add(billno);
		billno.addKeyListener(new KeyAdapter() {
		public void keyTyped(KeyEvent o) {
                char caracter = o.getKeyChar();
                if (((caracter < '0') || (caracter > '9')) && (caracter != '\b')) {
                    	o.consume();
                	}
            		}
        	});
        	
        	
        	

        	
        	
		//static int c;
      		try {
            FileReader fileReader = new FileReader("Billno.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            c =bufferedReader.read();
            c=c-48;
            cb=c;
            billno.setText(Integer.toString(c));
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
                         
        }
        catch(IOException ex) {
            
        }
        
       /* try{ 
        	String custmer="";
	      
	      custmer=custl.getText();
	     String bn= billno.getText();
	     File file = new File(bn+".txt");	
	     FileWriter filewrite = new FileWriter(file, true);
	      filewrite.write(custmer+"\n");
              filewrite.close();
              }
              catch(Exception qqqq)
              {
              }*/
   
        	
       	
		Font font1 = new Font("SansSerif", Font.BOLD, 18);

		JTable table = new JTable();
		Object [] colomns={" Product ","Units"," Tax "," Price "};
 		DefaultTableModel model= new DefaultTableModel();
 		model.setColumnIdentifiers(colomns);
  		table.setFont(new Font("SansSerif", Font.BOLD, 20));
  		table.setBackground(Color.decode("#058dc7"));
  		table.setRowHeight(50);
  		table.setModel(model);
  		
  		
  		JScrollPane scrollPane = new JScrollPane(table);
 		scrollPane.setBounds(50, 250, 650, 300);
 		getContentPane().add(scrollPane);
  
  		bn= billno.getText();
  		bnn=Integer.parseInt(bn);
  		
	  	  
  
  
 		JButton btnAdd = new JButton("Add");
 	 	btnAdd.setFont(font1);
  		Object [] row = new Object[4];
  		btnAdd.addActionListener(new ActionListener() {
   		public void actionPerformed(ActionEvent arg0) {
   		if((custl.getText().equals(""))||(unitsl.getText().equals(""))||(taxl.getText().equals("")))
   		{
   			JOptionPane.showMessageDialog(btnAdd,"Please Enter all the infromation");
   		}
   		else{
    		row[0]=si.getItemAt(si.getSelectedIndex());  
    		row[1]=unitsl.getText();
    		row[2]=taxl.getText();
    		row[3]=pricel.getText();
    		model.addRow(row);
    		
    		
 		p=Double.parseDouble(pricel.getText());
		t=Double.parseDouble(taxl.getText());
		u=Double.parseDouble(unitsl.getText());
		tl=(p*u);
		s = t/100;
		taxs=s*tl;
		
		ftl=taxs + tl;
		totalp[count] = ftl;
		sum=sum+totalp[count];
		count++;
		
		
		totall.setText(Double.toString(sum));
		
		
		
		
		
		
	      
	     try{ 
	     //String bn= billno.getText();
	     File file = new File(bn+".txt");	
	     FileWriter filewrite = new FileWriter(file, true);
	     
	     if(flag==1)
	     {
	     		String aa="Product";
	     		String bb="Units";
	     		String cc="Tax";
	     		String dd="Price";
	     		filewrite.write(aa+"\t"+bb+"\t"+cc+"\t"+dd+"\n");
	     		flag=0;
	     		//filewrite.close();
	     }
	     
	     
	     String pric = " ";
	      String produc = " ";
	      String ta =" ";
	      String un =" ";
	      
	      pric=pricel.getText();
	      produc=si.getSelectedItem().toString();
	      ta=taxl.getText();
	      un=unitsl.getText();
	     
	      filewrite.write("\n"+produc+"\t"+un+"\t"+ta+"\t"+pric+"\n");
              filewrite.close();
              }
              catch(Exception qqqq)
              {
              }
	}
		
    		
   		}
 	 	});
  		btnAdd.setBounds(630,190,100,30);
  		getContentPane().add(btnAdd);
  		
  		chkstk.setBounds(50,600,200,30);
  		add(chkstk);
  		chkstk.addActionListener( new ActionListener()
  		{
  			
  			public void actionPerformed(ActionEvent e)
  				{
  					
  					//new BankForm().setVisible(true);
  					//setVisible(false);
  					 cb=cb+49;
  					 
  					 try {
            				FileWriter fileWriter = new FileWriter("Billno.txt");
            				BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            				bufferedWriter.write(cb);
	            bufferedWriter.close();         
	        }
	        catch(FileNotFoundException ex) {	
                         
	        }
	        catch(IOException ex) {
	            
	        }
	  			
	  			try {
	            FileReader fileReader1 = new FileReader("Billno.txt");
	            BufferedReader bufferedReader1 = new BufferedReader(fileReader1);	

	            c =bufferedReader1.read();	
	            c=c-48;
	            cb=c;
	            billno.setText(Integer.toString(c));
	            bufferedReader1.close();         
	        }
	        catch(FileNotFoundException ex) {
	                         
	        }
	        catch(IOException ex) {
	            
	        }		 
  					
  				
  		String ttl= totall.getText();
  		String custmer="";
	      
	      	custmer=custl.getText();		
  				
  		try{ 
	     File file = new File(bn+".txt");	
	     FileWriter filewrite = new FileWriter(file, true);
	     
	     String ee="Total";
	     String ff="Customer Name";	
	     
	      filewrite.write("\n"+ee+"\t"+ttl+"\n"+ff+"\t"+custmer+"\n");
              filewrite.close();
              }
              catch(Exception qqqq)
              {
              }	
              bnn++;
              bn= Integer.toString(bnn);
              
              
              				custl.setText("");
  					pricel.setText("");
  					taxl.setText("");
  					unitsl.setText("");
  					totall.setText("");
  					//DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.setRowCount(0);
					flag=1;
              	}
              	
  				
  			});
  		total.setBounds(500,600,60,30);
  		add(total);
  		totall.setBounds(600,600,100,30);
  		add(totall);
  		totall.setEditable(false);
  		logut.setBounds(300,600,100,30);
  		add(logut);
  		logut.addActionListener(new ActionListener()
  			{
  				public void actionPerformed(ActionEvent ec)
  				{
  					Loginemployee le = new Loginemployee();
  					le.setVisible(true);
  					dispose();
  				}
  			});
  
	
		}
		
	public void actionPerformed(ActionEvent e) 
	{
		
    	}

	public static void main(String args[])
	{
		Bill b = new Bill();
		b.setDefaultCloseOperation(3);
		b.setVisible(true);
		
	}

}	
