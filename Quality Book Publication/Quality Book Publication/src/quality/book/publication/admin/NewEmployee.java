package quality.book.publication.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.awt.event.WindowListener;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import quality.book.publication.home.Login;

public class NewEmployee extends JFrame 
{
	private static java.sql.Date getDate(int x,int y,int z) 
	{
	    java.util.Date today = new java.util.Date(x,y,z);
	    return new java.sql.Date(today.getTime());
	}
	
	protected String filepath;
   public NewEmployee(String name)
   {
	   Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
		  Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		  Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		  
		  JPanel menu=new JPanel();
		  menu.setBounds(5,5,200,80);
		  menu.setBorder(raisedbevel);
		  menu.setLayout(null);
		  
		  JLabel leftheader=new JLabel("MAIN MENU");
		  Font font=new Font(Font.SANS_SERIF,Font.PLAIN,20);
		  leftheader.setBounds(44,32,112,15);
		  leftheader.setFont(font);
		  menu.add(leftheader);
		  
		  
		  JPanel left=new JPanel();
		  left.setBounds(5,100,200,565);
		  left.setBorder(raisedetched);
		  left.setLayout(null);
		  
		  
		  
		  JButton inventory=new JButton("Inventory");
	   	  inventory.setBounds(20,30,160,40);
	   	  inventory.addActionListener(new ActionListener()
	   	  {

	   		@Override
	   		public void actionPerformed(ActionEvent arg0)
	   		{
	   			AdminPanel panel=new AdminPanel(name);
	   			dispose();
	   		}
	   		  
	   	  });
	   	  JButton customer=new JButton("Customer");
	   	  customer.setBounds(20, 90, 160, 40);
	   	  customer.addActionListener(new ActionListener()
	   	  {

	   		@Override
	   		public void actionPerformed(ActionEvent e)
	   		{
	   			CustomerPanel panel=new CustomerPanel(name);
	   			dispose();
	   		}
	   		  
	   	  });
	   	  JButton account=new JButton("Account");
	   	  account.setBounds(20,150,160,40);
	   	  account.addActionListener(new ActionListener()
	   	  {

	   		@Override
	   		public void actionPerformed(ActionEvent e) 
	   		{
	   			AccountPanel panel=new AccountPanel(name);
	   			dispose();
	   		}
	   		  
	   	  });
	   	  JButton sales=new JButton("Sales");
	   	  sales.setBounds(20,210,160,40);
	   	  sales.addActionListener(new ActionListener(){

	   		@Override
	   		public void actionPerformed(ActionEvent e)
	   		{
	   			SalesReport panel=new SalesReport(name);
	   			
	   		}
	   		  
	   	  });
	   	  
	   	  JButton customer_sales=new JButton("Customer Sales");
	   	  customer_sales.setBounds(20,270,160,40);
	   	  customer_sales.addActionListener(new ActionListener()
	   	  {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				CustomerSalesPanel panel=new CustomerSalesPanel(name);
			}
	   		  
	   	  });
	   	  JButton changeuser=new JButton("Change User");
	   	  changeuser.setBounds(20, 330, 160, 40);
	   	  changeuser.addActionListener(new ActionListener()
	   	  {

	   		@Override
	   		public void actionPerformed(ActionEvent e) 
	   		{
	   			java.util.Calendar cal = Calendar.getInstance();
				java.util.Date utilDate = new java.util.Date(); // your util date
				cal.setTime(utilDate);    
				java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=conn.prepareStatement("insert into system_log_data values(?,?,?)");
					pst.setDate(1, sqlDate);
					pst.setString(2, name);
					pst.setString(3, "Admin "+name+" logged out");
					pst.executeUpdate();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
	   			Login login=new Login();
	   			dispose();
	   			
	   		}
	   		  
	   	  });
	   	  JButton exit=new JButton("Exit");
	   	  exit.setBounds(20,390,160,40);
	   	  exit.addActionListener(new ActionListener()
	   	  {

	   		@Override
	   		public void actionPerformed(ActionEvent e)
	   		{
	   			java.util.Calendar cal = Calendar.getInstance();
				java.util.Date utilDate = new java.util.Date(); // your util date
				cal.setTime(utilDate);    
				java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
				try
				{
					Class.forName("oracle.jdbc.driver.OracleDriver");
					Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
					PreparedStatement pst=conn.prepareStatement("insert into system_log_data values(?,?,?)");
					pst.setDate(1, sqlDate);
					pst.setString(2, name);
					pst.setString(3, "Admin "+name+" logged out");
					pst.executeUpdate();
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
	   			System.exit(0);
	   		}
	   		  
	   	  });
		  JPanel pannel=new JPanel();
		  pannel.setLayout(null);
		  pannel.setBorder(raisedbevel);
		  pannel.setBounds(20,460,160,80);
		  
		  JLabel Title=new JLabel("Logged In User Info");
		  Title.setBounds(25,20,140,20);
		  JLabel title_value=new JLabel();
		  title_value.setBounds(50,40,60,20);
		  title_value.setText(name);
		  pannel.add(title_value);
		  pannel.add(Title);
		  
		  left.add(pannel);
		  left.add(inventory);
		  left.add(customer);
		  left.add(account);
		  left.add(sales);
		  left.add(changeuser);
		  left.add(exit);
		  left.add(customer_sales);
		 
		  
		  
		  
		  
		  JPanel top=new JPanel();
		  top.setBounds(210,0,970,140);
		  top.setBackground(Color.black);
		  top.setBorder(loweredbevel);
		  top.setLayout(null);
		  
		  JButton newitem = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//add item.jpg")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
		  newitem.setBounds(80,10,140,120);
		  newitem.setText("New Item");
		  newitem.setHorizontalTextPosition(AbstractButton.CENTER);
		  newitem.setVerticalTextPosition(AbstractButton.BOTTOM);
		  newitem.addActionListener(new ActionListener()
		  {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				NewItem item=new NewItem(name);
				dispose();
				
			}
			  
		  });
		  
		  JButton newcustomer = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//new customer.png")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
		  newcustomer.setBounds(249,10,140,120);
		  newcustomer.setText("New Customer");
		  newcustomer.setHorizontalTextPosition(AbstractButton.CENTER);
		  newcustomer.setVerticalTextPosition(AbstractButton.BOTTOM);
		  newcustomer.addActionListener(new ActionListener()
		  {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				NewCustomer customer=new NewCustomer(name);
				dispose();
			}
			  
		  });
		
		  JButton newemployee = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//new employee.png")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
		  newemployee.setBounds(418,10,140,120);
		  newemployee.setText("New Employee");
		  newemployee.setHorizontalTextPosition(AbstractButton.CENTER);
		  newemployee.setVerticalTextPosition(AbstractButton.BOTTOM);
		  newemployee.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				NewEmployee emp=new NewEmployee(name);
				dispose();
			}
			  
		  });

		  JButton logs = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//logs.jpg")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
		  logs.setBounds(587,10,140,120);
		  logs.setText("Logs");
		  logs.setHorizontalTextPosition(AbstractButton.CENTER);
		  logs.setVerticalTextPosition(AbstractButton.BOTTOM);
		  logs.addActionListener(new ActionListener()
		  {

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Logs log=new Logs(name);
				
			}
			  
		  });
		
		  JButton help = new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//logo//help.png")).getImage()).getScaledInstance(140, 90, java.awt.Image.SCALE_SMOOTH)));
		  help.setBounds(756,10,140,120);
		  help.setText("Help");
		  help.setHorizontalTextPosition(AbstractButton.CENTER);
		  help.setVerticalTextPosition(AbstractButton.BOTTOM);
		  help.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				Help help=new Help(name);
				dispose();
			}
			  
		  });

		  top.add(newitem);
		  top.add(newcustomer);
		  top.add(newemployee);
		  top.add(logs);
		  top.add(help);
		  
		  
		  
		  JPanel middle=new JPanel();
		  middle.setBounds(210,150,970,515);
		  middle.setBorder(raisedbevel);
		  middle.setLayout(null);
		  
		  JLabel accountinformation=new JLabel("Account Information");
		  accountinformation.setBounds(300,45,180,15);
		  Font accfont=new Font(Font.SERIF,Font.BOLD,20);
		  accountinformation.setFont(accfont);
		  
		  JLabel accountname=new JLabel("Account Name:");
		  accountname.setBounds(330,73,90,20);
		  
		  JTextField accountname_textbox=new JTextField();
		  accountname_textbox.addFocusListener(new FocusListener()
		  {

			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				accountname_textbox.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  accountname_textbox.setBounds(430,70,200,25);
		  accountname_textbox.setBorder(loweredbevel);
		  
		  
		  JLabel password=new JLabel("password:");
		  password.setBounds(342,97,90,30);
		  
		  JTextField password_textbox=new JTextField();
		  password_textbox.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				password_textbox.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  password_textbox.setBounds(430,100,200,25);
		  password_textbox.setBorder(loweredbevel);
		  JLabel email=new JLabel("Email:");
		  email.setBounds(353,132,90,20);
		  JTextField email_textbox=new JTextField();
		  email_textbox.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) 
			{
				// TODO Auto-generated method stub
				email_textbox.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  email_textbox.setBounds(430,130,200,25);
		  email_textbox.setBorder(loweredbevel);
		  JLabel phonenumber=new JLabel("Phone Number:");
		  phonenumber.setBounds(330,163,90,20);
		  JTextField phonenumber_textbox=new JTextField();
		  phonenumber_textbox.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				phonenumber_textbox.setBackground(Color.white);
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  phonenumber_textbox.setBounds(430,160,200,25);
		  phonenumber_textbox.setBorder(loweredbevel);
		  JLabel position=new JLabel("Position:");
		  position.setBounds(345,192,90,20);
		  String data[]={"Select Any","Cashier","Admin"};
		  JComboBox  position_textbox=new JComboBox(data);
		  position_textbox.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				position_textbox.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  position_textbox.setBounds(430,190,200,25);
		  position_textbox.setBorder(loweredbevel);
		  JLabel personalinformation=new JLabel("Personal Information");
		  personalinformation.setBounds(300,220,180,15);
		  Font accfont1=new Font(Font.SERIF,Font.BOLD,20);
		  personalinformation.setFont(accfont);
		  
		 
		  JLabel imagename=new JLabel();
		  imagename.setBounds(680,310,300,30);
		  JButton imagebutton=new JButton(new ImageIcon(((new ImageIcon("C://Users//Mahesh Lamichhane//Desktop//desktop app//Pos and Inventory System//image//download.jpg")).getImage()).getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH)));
		  imagebutton.setBounds(680,70,190,190);
		  JButton chooseafile=new JButton("Choose a File");
		  chooseafile.setBounds(680,270,120,30);
		  chooseafile.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				 JFileChooser fc=new JFileChooser();    
				 int i=fc.showOpenDialog(null); 
				 File f=fc.getSelectedFile();    
			        filepath=f.getPath(); 
			        imagename.setText(f.getName());
                    ImageIcon con=new ImageIcon(new ImageIcon(filepath).getImage().getScaledInstance(190, 190, java.awt.Image.SCALE_SMOOTH));
			        imagebutton.setIcon(con);
			        
			        
			}
			  
		  });
		  
		  JLabel firstname=new JLabel("First Name:");
		  firstname.setBounds(340,247,90,20);
		  
		  JTextField firstname_textbox=new JTextField();
		  firstname_textbox.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				firstname_textbox.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  firstname_textbox.setBounds(430,245,200,25);
		  firstname_textbox.setBorder(loweredbevel);
		  JLabel lastname=new JLabel("Last Name:");
		  lastname.setBounds(340,280,90,20);
		  JTextField lastname_textbox=new JTextField();
		  lastname_textbox.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				lastname_textbox.setBackground(Color.white);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  lastname_textbox.setBounds(430,275,200,25);
		  lastname_textbox.setBorder(loweredbevel);
		  JLabel gender=new JLabel("Gender:");
		  gender.setBounds(350,305,90,20);
		  JRadioButton male=new JRadioButton("Male:");
		  male.setBounds(430,305,100,20);
		  male.setActionCommand("Male");
		  JRadioButton female=new JRadioButton("Female:");
		  female.setBounds(540,305,100,20);
		  female.setActionCommand("Female");
		  ButtonGroup group=new ButtonGroup();
		  group.add(male);
		  group.add(female);
		  JLabel dateofbirth=new JLabel("Date Of Birth:");
		  dateofbirth.setBounds(335,332,90,20);
		  String month[]={"Month","Jan","Feb","Mar","April","May","June","July","August","Sept","Oct","Nov","Dec"};
		  JComboBox monthvalue_combo=new JComboBox(month);
		  monthvalue_combo.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e) 
			{
				// TODO Auto-generated method stub
				monthvalue_combo.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  monthvalue_combo.setBounds(430,330,70,25);
		  monthvalue_combo.setBorder(loweredbevel);
		  JTextField dayvalue=new JTextField("Day");
		  dayvalue.addFocusListener(new FocusListener()
		  {

			@Override
			public void focusGained(FocusEvent e)
			{
				// TODO Auto-generated method stub
				dayvalue.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  dayvalue.setBorder(loweredbevel);
		  dayvalue.setBounds(505,330,60,25);
		  JTextField yearvalue=new JTextField();
		  yearvalue.addFocusListener(new FocusListener(){

			@Override
			public void focusGained(FocusEvent e)
			{
				yearvalue.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  yearvalue.setBounds(570,330,60,25);
		  yearvalue.setBorder(loweredbevel);
		  yearvalue.setText("YYYY");
		  
		  JButton clear=new JButton("Clear");
		  clear.setBounds(340,400,80,30);
		  clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				// TODO Auto-generated method stub
				accountname_textbox.setText("");
				male.setSelected(false);
				female.setSelected(false);
				password_textbox.setText("");
				email_textbox.setText("");
				phonenumber_textbox.setText("");
				position_textbox.setSelectedIndex(0);
				firstname_textbox.setText("");
			    lastname_textbox.setText("");
			    male.setSelected(false);
			    female.setSelected(false);
			    monthvalue_combo.setSelectedIndex(0);
			    dayvalue.setText("Day");
			    yearvalue.setText("YYYY");
				
			}
			  
		  });
		  JButton save=new JButton("Save");
		  save.setBounds(442,400,80,30);
		  save.addActionListener(new ActionListener()
		  {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				
				if(accountname_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Account Name Field can't be empty");
					accountname_textbox.setBackground(Color.RED);
				}
				else if(password_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Password Field must be selected");
					password_textbox.setBackground(Color.RED);
				}
				else if(email_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Email Field can't be empty");
					email_textbox.setBackground(Color.RED);
				}
				else if(phonenumber_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Phone Number Field can't be empty");
					phonenumber_textbox.setBackground(Color.red);
				}
				else if(position_textbox.getSelectedItem().toString().equals("Select Any"))
				{
					JOptionPane.showMessageDialog(null, "Position Field can't be empty");
			        position_textbox.setBackground(Color.red);
				}
				
				else if(position_textbox.getSelectedItem().equals("Select Any"))
				{
					JOptionPane.showMessageDialog(null, "Position Field can't be empty");
					position_textbox.setBackground(Color.RED);
				}
				else if(firstname_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "First Name Field can't be empty");
					firstname_textbox.setBackground(Color.RED);
				}
				else if(lastname_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Last Name Field can't be empty");
					lastname_textbox.setBackground(Color.RED);
				}
				else if(!male.isSelected()&& !female.isSelected())
				{
					JOptionPane.showMessageDialog(null, "Gender Field can't be empty");
				}
				else if(monthvalue_combo.getSelectedItem().equals("Month"))
				{
					JOptionPane.showMessageDialog(null, "Month Value Field can't be empty");
					monthvalue_combo.setBackground(Color.RED);
				}
				else if(dayvalue.getText().equals("Day"))
				{
					JOptionPane.showMessageDialog(null, "Day Value Field can't be empty");
					dayvalue.setBackground(Color.RED);
				}
				else if(yearvalue.getText().equals("YYYY"))
				{
					JOptionPane.showMessageDialog(null, "Year Value Field can't be empty");
					yearvalue.setBackground(Color.RED);
				}
				
				
				else
				{
					if(accountname_textbox.getText().length()>30)
					{
						JOptionPane.showMessageDialog(null, "Account Name must have maximum 30 characters");
						accountname_textbox.setBackground(Color.yellow);
					}
					else if(password_textbox.getText().length()>10)
					{
						JOptionPane.showMessageDialog(null, "Password must have maximum 10 characters");
						password_textbox.setBackground(Color.yellow);
					}
					else if(email_textbox.getText().length()>30)
					{
						JOptionPane.showMessageDialog(null, "Email must have maximum 30 characters");
						email_textbox.setBackground(Color.yellow);
					}
					else if(phonenumber_textbox.getText().length()>10)
					{
						JOptionPane.showMessageDialog(null, "Phone Number  must have maximum 10 characters");
						phonenumber_textbox.setBackground(Color.yellow);
					}
					else if(firstname_textbox.getText().length()>25)
					{
						JOptionPane.showMessageDialog(null, "First Name  must have maximum 25 characters");
						firstname_textbox.setBackground(Color.yellow);
					}
					else if(lastname_textbox.getText().length()>25)
					{
						JOptionPane.showMessageDialog(null, "Last Name must have maximum 25 characters");
						lastname_textbox.setBackground(Color.yellow);
					}
					else if(Integer.parseInt(dayvalue.getText())>32)
					{
						JOptionPane.showMessageDialog(null, "Day Field  must have maximum 32 as value");
						dayvalue.setBackground(Color.yellow);
					}
					else if(Integer.parseInt(yearvalue.getText())<1975)
					{
						JOptionPane.showMessageDialog(null, "Year Field  must have greater than 1975 as value");
						yearvalue.setBackground(Color.yellow);
					}
					else
					{
					int z,x=0;
					String account_name=accountname_textbox.getText();
					String password=password_textbox.getText();
					String email=email_textbox.getText();
					int phone_number=Integer.parseInt(phonenumber_textbox.getText());
					String position=position_textbox.getSelectedItem().toString();
					String firstname=firstname_textbox.getText();
					String lastname=lastname_textbox.getText();
					String gender=group.getSelection().getActionCommand();
					int monthvalue=monthvalue_combo.getSelectedIndex();
					int day=Integer.parseInt(dayvalue.getText());
					int year=Integer.parseInt(yearvalue.getText());
					
					
				    
					
					try
					{
						int u=0;
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						
						PreparedStatement pst1=con.prepareStatement("insert into employee_information values(?,?,?,?,?,?,?,?,?,?)");
						pst1.setString(1, account_name);
						pst1.setString(2, password);
						pst1.setString(3, email);
						pst1.setInt(4, phone_number);
						pst1.setString(5, position);
						pst1.setString(6,firstname);
						pst1.setString(7,lastname);
						pst1.setString(8, gender);
						pst1.setDate(9, getDate(year,monthvalue,day));
						FileInputStream fin=new FileInputStream(filepath);  
						pst1.setBinaryStream(10,fin,fin.available()); 
						int z1=pst1.executeUpdate();
						if(position.equals("Admin"))
						{
							PreparedStatement pst=con.prepareStatement("insert into admin values(?,?)");
							pst.setString(1, account_name);
							pst.setString(2, password);
						    u=pst.executeUpdate();
						}
						if(position.equals("Cashier"))
						{
							PreparedStatement pst=con.prepareStatement("insert into employee values(?,?)");
							pst.setString(1, account_name);
							pst.setString(2, password);
						    u=pst.executeUpdate();
						}
						
						if(z1>0 )
							{
								JOptionPane.showMessageDialog(null, "Data are successfully inserted to the database");
								accountname_textbox.setText("");
								male.setSelected(false);
								female.setSelected(false);
								password_textbox.setText("");
								email_textbox.setText("");
								phonenumber_textbox.setText("");
								position_textbox.setSelectedIndex(0);
								firstname_textbox.setText("");
							    lastname_textbox.setText("");
							    male.setSelected(false);
							    female.setSelected(false);
							    monthvalue_combo.setSelectedIndex(0);
							    dayvalue.setText("");
							    yearvalue.setText("");
							    
				            }
						else
							{
								JOptionPane.showMessageDialog(null, "Sorry Proble Occured");
							}
					}
					catch(Exception eo)
					{
						eo.printStackTrace();
					}
				}
			}
			}
				
			  
		  });
		  
		  JButton cancel=new JButton("Cancel");
		  cancel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			  
		  });
		  cancel.setBounds(542,400,80,30);
		  
		
		  
	 	  accountname_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       password_textbox.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
	 	  password_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       email_textbox.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
	 	  email_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       phonenumber_textbox.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
	 	  phonenumber_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       position_textbox.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
	 	  position_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       firstname_textbox.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
	 	  firstname_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       lastname_textbox.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
	 	  lastname_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       monthvalue_combo.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
	 	  monthvalue_combo.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       dayvalue.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
	 	  dayvalue.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       yearvalue.requestFocus();
			     }
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  }); 
		  
		  
		  middle.add(accountinformation);
		  middle.add(accountname);
		  middle.add(accountname_textbox);
		  middle.add(password);
		  middle.add(password_textbox);
		  middle.add(email);
		  middle.add(email_textbox);
		  middle.add(phonenumber);
		  middle.add(phonenumber_textbox);
		  middle.add(position);
		  middle.add(position_textbox);
		  middle.add(personalinformation);
		  middle.add(firstname);
		  middle.add(firstname_textbox);
		  middle.add(lastname);
		  middle.add(lastname_textbox);
		  middle.add(gender);
		  middle.add(male);
		  middle.add(female);
		  middle.add(dateofbirth);
		  middle.add(monthvalue_combo);
		  middle.add(dayvalue);
		  middle.add(yearvalue);
		  middle.add(cancel);
		  middle.add(clear);
		  middle.add(save);
		  middle.add(chooseafile);
		  middle.add(imagename);
		  middle.add(imagebutton);
		  
		  
		  
		  setBounds(20,20,1192,700);
		  setTitle("Lamichhane Inventory Management");
		  setVisible(true);
		  setDefaultCloseOperation(EXIT_ON_CLOSE);
		  setVisible(true);
		  setLayout(null);
		  setResizable(false);
		  this.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
			
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  add(menu);
		  add(left);
		  add(top);
		  add(middle);
		 
   }
 

 
  
}
