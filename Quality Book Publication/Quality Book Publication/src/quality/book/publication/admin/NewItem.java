package quality.book.publication.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

import quality.book.publication.home.Login;

public class NewItem extends JFrame
{

	public NewItem(String name)
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
		  left.add(customer_sales);
		  left.add(customer);
		  left.add(account);
		  left.add(sales);
		  left.add(changeuser);
		  left.add(exit);
		 
		  
		  
		  
		  
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
		  
		  JLabel itemheader=new JLabel("Item Information");
		  Font fon=new Font(Font.SERIF,Font.BOLD,30);
		  itemheader.setFont(fon);
		  itemheader.setBounds(375,30,220,30);
		  
		  JLabel itemcode=new JLabel("Item Code:");
		  itemcode.setBounds(330,103,70,20);
		  JTextField itemcode_textbox=new JTextField();
		  itemcode_textbox.setBounds(410,100,225,25);
		  itemcode_textbox.setBorder(loweredbevel);
		  itemcode_textbox.addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent e)
				{
					itemcode_textbox.setBackground(Color.WHITE);
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}
				  
			  });
		  
		  
		  JLabel itemname=new JLabel("Item Name:");
		  itemname.setBounds(330,143,70,20);
		  JTextField itemname_textbox=new JTextField();
		  itemname_textbox.setBounds(410,140,225,25);
		  itemname_textbox.setBorder(loweredbevel);
		  itemname_textbox.addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent e) 
				{
					itemname_textbox.setBackground(Color.white);
					
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}
				  
			  });
		  
		  
		  JLabel category=new JLabel("Category:");
		  category.setBounds(335,183,70,20);
		  String nam[]={"Select Any","Biscuits","Noodles","Oil","Copy","Pen","masu"};
		  
		  JComboBox category_textbox=new JComboBox(nam);
		  category_textbox.setBounds(410,180,225,25);
		  category_textbox.setBorder(loweredbevel);
		  category_textbox.addFocusListener(new FocusListener()
		  {

			@Override
			public void focusGained(FocusEvent e)
			{
				category_textbox.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  
		  JLabel descriptionval=new JLabel("Description:");
		  descriptionval.setBounds(330,223,70,20);
		  JTextField descriptionval_textbox=new JTextField();
		  descriptionval_textbox.setBounds(410,220,225,25);
		  descriptionval_textbox.setBorder(loweredbevel);
		  descriptionval_textbox.addFocusListener(new FocusListener()
		  {

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				descriptionval_textbox.setBackground(Color.WHITE);
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			  
		  });
		  
		  JLabel price=new JLabel("Price:");
		  price.setBounds(345,263,70,20);
		  JTextField price_textbox=new JTextField();
		  price_textbox.setBounds(410,260,225,25);
		  price_textbox.setBorder(loweredbevel);
		  price_textbox.addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					price_textbox.setBackground(Color.white);
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}
				  
			  });
		  
		  JLabel stocks=new JLabel("Stocks:");
		  stocks.setBounds(340,303,70,20);
		  JTextField stocks_textbox=new JTextField();
		  stocks_textbox.setBounds(410,300,225,25);
		  stocks_textbox.setBorder(loweredbevel);
		  stocks_textbox.addFocusListener(new FocusListener(){

				@Override
				public void focusGained(FocusEvent e) {
					// TODO Auto-generated method stub
					stocks_textbox.setBackground(Color.white);
				}

				@Override
				public void focusLost(FocusEvent e) {
					// TODO Auto-generated method stub
					
				}
				  
			  });
		  
		  JButton clear=new JButton("Clear");
		  clear.setBounds(430,360,70,30);
		  clear.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				itemcode_textbox.setText("");
				itemname_textbox.setText("");
				category_textbox.setSelectedIndex(0);
				descriptionval_textbox.setText("");
				price_textbox.setText("");
				stocks_textbox.setText("");
				
			}
			  
		  });
		  JButton add=new JButton("Add");
		  add.setBounds(540,360,70,30);
		  add.addActionListener(new ActionListener()
		  {

			@Override
			public void actionPerformed(ActionEvent e)
			{
				
				
				if(itemcode_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Item Code Field can't be empty");
					itemcode_textbox.setBackground(Color.RED);
				}
				else if(itemname_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Item Name Field can't be empty");
					itemname_textbox.setBackground(Color.RED);
				}
				else if(category_textbox.getSelectedItem().equals("Select Any"))
				{
					JOptionPane.showMessageDialog(null, "Category Field can't be empty");
					category_textbox.setBackground(Color.RED);
				}
				else if(descriptionval_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Description Field can't be empty");
					descriptionval_textbox.setBackground(Color.red);
				}
				else if(price_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Price Field can't be empty");
					price_textbox.setBackground(Color.RED);
				}
				else if(stocks_textbox.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Stock Field can't be empty");
					stocks_textbox.setBackground(Color.RED);
				}
				else
				{
					if(itemcode_textbox.getText().length()>10)
					{
						JOptionPane.showMessageDialog(null, "Item Code must have maximum 10 characters");
						itemcode_textbox.setBackground(Color.yellow);
					}
					else if(itemname_textbox.getText().length()>25)
					{
						JOptionPane.showMessageDialog(null, "Item Name must have maximum 25 characters");
						itemname_textbox.setBackground(Color.yellow);
					}
					else if(category_textbox.getSelectedItem().toString().length()>25)
					{
						JOptionPane.showMessageDialog(null, "Category Field  must have maximum 25 characters");
						category_textbox.setBackground(Color.yellow);
					}
					else if(descriptionval_textbox.getText().length()>25)
					{
						JOptionPane.showMessageDialog(null, "Description Field  must have maximum 25 characters");
						descriptionval_textbox.setBackground(Color.yellow);
					}
					else if(price_textbox.getText().length()>10)
					{
						JOptionPane.showMessageDialog(null, "Price Field  must have maximum 10 characters");
						price_textbox.setBackground(Color.yellow);
					}
					else if(stocks_textbox.getText().length()>10)
					{
						JOptionPane.showMessageDialog(null, "Stock Field  must have maximum 10 characters");
						stocks_textbox.setBackground(Color.yellow);
					}
					else
					{
					int z=0,y=0;
					int item_code=Integer.parseInt(itemcode_textbox.getText());
					String item_name=itemname_textbox.getText();
					String category=category_textbox.getSelectedItem().toString();
					String description=descriptionval_textbox.getText();
					int price=Integer.parseInt(price_textbox.getText());
					int stock=Integer.parseInt(stocks_textbox.getText());
					
					java.util.Calendar cal = Calendar.getInstance();
					java.util.Date utilDate = new java.util.Date(); // your util date
					cal.setTime(utilDate);    
					java.sql.Date sqlDate = new java.sql.Date(cal.getTime().getTime());
					
					try
					{
						Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","sys as sysdba","mahesh");
						PreparedStatement pst=con.prepareStatement("insert into item_info values(?,?,?,?,?,?)");
						PreparedStatement pstv=con.prepareStatement("insert into inventory_log_data values(?,?,?)");
						pst.setInt(1, item_code);
						pst.setString(2, item_name);
						pst.setString(3, category);
						pst.setString(4, description);
						pst.setInt(5, price);
						pst.setInt(6, stock);
						
						pstv.setDate(1, sqlDate);
						pstv.setString(2, name);
						pstv.setString(3, " "+name+" added "+item_name);
						
						z=pst.executeUpdate();
						y=pstv.executeUpdate();
						if(z>0 && y>0)
							{
								JOptionPane.showMessageDialog(null, "Data are successfully inserted to the database");
								itemcode_textbox.setText("");
								itemname_textbox.setText("");
								category_textbox.setSelectedIndex(0);
								descriptionval_textbox.setText("");
								price_textbox.setText("");
								stocks_textbox.setText("");
								itemcode_textbox.grabFocus();
								
								
							
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
		  
		  middle.add(clear);
		  middle.add(add);
		  middle.add(itemheader);
		  middle.add(itemcode);
		  middle.add(itemcode_textbox);
		  middle.add(itemname);
		  middle.add(itemname_textbox);
		  middle.add(category);
		  middle.add(category_textbox);
		  middle.add(descriptionval);
		  middle.add(descriptionval_textbox);
		  middle.add(price);
		  middle.add(price_textbox);
		  middle.add(stocks);
		  middle.add(stocks_textbox);
		  
		  itemcode_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       itemname_textbox.requestFocus();
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
		  itemname_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       category_textbox.requestFocus();
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
		  category_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       descriptionval_textbox.requestFocus();
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
		  descriptionval_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       price_textbox.requestFocus();
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
		  price_textbox.addKeyListener(new KeyListener()
		  {

			@Override
			public void keyPressed(KeyEvent e) 
			{
				 int key = e.getKeyCode();
			     if (key == KeyEvent.VK_ENTER) 
			     {
			       stocks_textbox.requestFocus();
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
