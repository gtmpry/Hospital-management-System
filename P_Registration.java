import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.*;

import com.toedter.calendar.JDateChooser;
public class P_Registration extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1157618131274903182L;
	static JTextField lName,fName,id,mobile,sAddress,city,state,pin,guardian;
	private JLabel l;
	private JButton register,cancle;
	JRadioButton gender1,gender2;
	static final String mobile1="[6-9]{1}+[0-9]{9}";
	static final String pincode="[1-9]{1}+[0-9]{5}";
	static final String name="[a-zA-Z]*";
	static int i;long s16;long s15;	
	String s1,s2,s3,s5,s6,s7,s8,s14,s13,s12,s9,s10,s11,s4;
	JComboBox<String> mHistory;
	Date d;
	//Connection con;
	JComboBox<String> mStatus;
	Pattern pattern;
	Matcher matcher;
	 static JDateChooser date;
	ButtonGroup bg;
	String s;
	static Connection con=Dao.con();
	Date date2;
	public  void fun()
	{
		l.setFont(new Font("Sitka Subheading", Font.BOLD, 17));
		l.setForeground(Color.BLACK);
	}
	@SuppressWarnings("static-access")
	public P_Registration() {
		setVisible(true);
		setSize(700, 800);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
		
		l= new JLabel("Patient Registration");
		l.setForeground(Color.BLACK);
		l.setFont(new Font("Sitka Subheading", Font.BOLD, 24));
		l.setEnabled(false);
		l.setBounds(600, 80, 230, 40);
		add(l);
		
		l= new JLabel("Patient ID");
		l.setBounds(410, 170, 165, 30);
		fun();
		add(l);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(550, 170, 220, 30);
		add(id);
		
		l= new JLabel("First Name");
		l.setBounds(410, 210, 146, 30);
		fun();
		add(l);
		
		fName= new JTextField();
		fName.setBounds(550, 210, 220, 30);
		add(fName);
		
		l= new JLabel("Last Name");
		l.setBounds(410, 250, 146, 30);
		fun();
		add(l);
		
		lName= new JTextField();
		lName.setBounds(550,250, 220, 30);
		add(lName);
		
		l= new JLabel("Gender");
		l.setBounds(410, 290, 146, 30);
		fun();
		add(l);
		
		gender1=new JRadioButton("Male");
		gender1.setBounds(550,290,80,20);
		gender1.setSelected(true);
		add(gender1);
		
		gender2=new JRadioButton("Female");
		gender2.setBounds(650,290,80,20);
		add(gender2);
		
		bg=new ButtonGroup();
		bg.add(gender1);
		bg.add(gender2);
		
		
		l= new JLabel("DOB");
		l.setBounds(410, 330, 146, 30);
		fun();
		add(l);
		
		l= new JLabel("Mobile");
		l.setBounds(410, 370, 146, 30);
		fun();
		add(l);
		
		mobile= new JTextField();
		mobile.setBounds(550, 370, 220, 30);
		add(mobile);
		
		l= new JLabel("Martial Status");
		l.setBounds(410, 410, 146, 30);
		fun();
		add(l);
		
		mStatus=new JComboBox<String>();
		mStatus.setModel(new DefaultComboBoxModel<>(new String[] {"Select","Single","Marragedd"}));
		mStatus.setBounds(550,410,220,30);
		add(mStatus);
		
		
		l= new JLabel("Street Address");
		l.setBounds(850, 210, 146, 30);
		fun();
		add(l);
		

		sAddress = new JTextField();
		sAddress.setBounds(1050, 210, 220, 30);
		add(sAddress);
		
		l= new JLabel("City");
		l.setBounds(850, 250, 146, 30);
		fun();
		add(l);
		
		city = new JTextField();
		city.setBounds(1050,250, 220, 30);
		add(city);
		
		l= new JLabel("State");
		l.setBounds(850, 290,146, 30);
		fun();
		add(l);
		
		state = new JTextField();
		state.setBounds(1050, 290, 220, 30);
		add(state);
		
		l= new JLabel("Pin Code");
		l.setBounds(850, 330, 146, 30);
		fun();
		add(l);
		
		pin= new JTextField();
		pin.setBounds(1050, 330,220, 30);
		add(pin);
		
		l= new JLabel("Past Medical HIstory");
		l.setBounds(850, 370, 220, 30);
		fun();
		add(l);
		
		mHistory=new JComboBox<String>();
		mHistory.setModel(new DefaultComboBoxModel<>(new String[] {"Select","Animia","Chickenpox"}));
		mHistory.setBounds(1050,370,220,30);
		add(mHistory);
		
		l= new JLabel("Patient/Gaurdian");
		l.setBounds(850, 410, 146, 30);
		fun();
		add(l);
		
		
		guardian = new JTextField();
		guardian.setBounds(1050, 410,220, 30);
		add(guardian);
		
		register=new JButton("Register");
		register.setBounds(600, 480, 100, 40);
		add(register);
		
		cancle=new JButton("Back");
		cancle.setBounds(730,480,100,40);
		add(cancle);
		
		register.addActionListener(this);
		cancle.addActionListener(this);
		
		date=new JDateChooser();
		date.setBounds(550,330,146,30);
		add(date);
		
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("F:\\Logo\\AddBed.jpg"));
		label.setBounds(0, 0,1382, 782);
		add(label);
		
		
		
		try {
			PreparedStatement ps1;
				ps1=con.prepareStatement("select * from patient where id=(select max(id) from patient)");
				ResultSet rs=ps1.executeQuery();
				if(rs.next())
				{
					String id=rs.getString(1);
					Integer n=Integer.parseInt(id);
					n=n+1;
					s1=String.valueOf(n);
					this.id.setText(s1);
					
				}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

	@SuppressWarnings({ })
	@Override
	public void actionPerformed(ActionEvent e) {
			
		if(e.getSource()==register)
		{
			s14="Addmit";
			boolean b=valid();
				if(b)
				{
					if(validt())
					{
					s2=fName.getText();
					s3=lName.getText();
					if(gender1.isSelected())
					{
						s4="Male";
						
					}
					else
					{
						s4="Female";
					}
					//Local current date
					LocalDateTime  date1=LocalDateTime.now();
					LocalDate c=date1.toLocalDate();
					
					 date2=Date.from(c.atStartOfDay(ZoneId.systemDefault()).toInstant());
					String s15=c.toString();
					/*get date from datechooser */
					/* Date dateFromDateChooser = date.getDate();
					    s5= String.format("%1$td-%1$tm-%1$tY", dateFromDateChooser);	*/
					    java.util.Date d=date.getDate();
						s5=DateFormat.getDateInstance().format(d);
						s6=mobile.getText();
						s7=mStatus.getSelectedItem().toString();
						s8=sAddress.getText();
						s9=city.getText();
						s10=state.getText();
						s11=pin.getText();
						s12=mHistory.getSelectedItem().toString();
						s13=guardian.getText();
						
							try {
							//	Class.forName("oracle.jdbc.driver.OracleDriver");
							//  Connection 	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priya","Gautam");
							PreparedStatement ps;
								ps = con.prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
								/*ps1=con.prepareStatement("select * from patient where id=(select max(id) from patient)");
								ResultSet rs=ps1.executeQuery();
								if(rs.next())
								{
									String id=rs.getString(1);
									Integer n=Integer.parseInt(id);
									n=n+1;
									s1=String.valueOf(n);
									this.id.setText(s1);
									
								}*/
								ps.setString(1, s1);
								ps.setString(2, s2);
								ps.setString(3, s3);
								ps.setString(4, s4);
								ps.setString(5, s5);
								ps.setString(6, s6);
								ps.setString(7, s7);
								ps.setString(8, s8);
								ps.setString(9, s9);
								ps.setString(10, s10);
								ps.setString(11, s11);
								ps.setString(12, s12);
								ps.setString(13, s13);
								ps.setString(14, s14);
								ps.setString(15, s15);
								ps.executeUpdate();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}			
							dispose();
							try {
								new Ward_type();
							} catch (ClassNotFoundException | SQLException e1) {
								e1.printStackTrace();
							}
					}
					else
					{

						fName.setText("");
						lName.setText("");
						mobile.setText("");
						sAddress.setText("");
						city.setText("");
						state.setText("");
						pin.setText("");
						mStatus.setSelectedItem("select");
						mHistory.setSelectedItem("select");
						guardian.setText("");	
					}
				}
	     	}
		else
		{
			dispose();
			new Home();
		}
	}

				public boolean valid()
                 {
					LocalDateTime  date1=LocalDateTime.now();
					LocalDate c=date1.toLocalDate();
					//Date date2=Date.from(c.atStartOfDay(ZoneId.systemDefault()).toInstant());
					this.date2=Date.from(c.atStartOfDay(ZoneId.systemDefault()).toInstant());

                	 
                	 if(fName.getText().equals(""))
                	 {
                		 JOptionPane.showMessageDialog(fName, "Insert First Name");
                		 return false;
                	 }
                	 else if(!name())
                	 {
                		 JOptionPane.showMessageDialog(fName, "Enter valid name");
                		 return false;
                	 }
                	 else if(lName.getText().equals(""))
                	 {
						JOptionPane.showMessageDialog(lName, "Enter Last Name");
						return false;
					 }
                	 else if(!name1())
                	 {
                		 JOptionPane.showMessageDialog(lName, "Enter valid name");
                		 return false;
                	 }
                	 else if(date.getDate().after(date2))
                	 {
                		 JOptionPane.showMessageDialog(date, "Invailid Date");
                		 return false;
                	 }
                	 else
                	 if(mobile.getText().equals(""))
                	 {
                		 JOptionPane.showMessageDialog(mobile, "Insert mobile no.");
                		 return false;
                	 }
                	 else if(!validt())
                	 {
                		 JOptionPane.showMessageDialog(mobile, "Enter valid number", "Error", JOptionPane.ERROR_MESSAGE);
                		 return false;
                	 }
                	 else if(mStatus.getSelectedIndex()==0)
                 	{
                 		JOptionPane.showMessageDialog(mStatus, "select Martial Status");
                 		return false;
                 	}

                	 if(sAddress.getText().equals(""))
                	 {
                		 JOptionPane.showMessageDialog(sAddress, "Insert Street Address");
                		 return false;
                	 }
                	 if(city.getText().equals(""))
                	 {
                		 JOptionPane.showMessageDialog(city, "Insert city");
                		 return false;
                	 }
                	 if(state.getText().equals(""))
                	 {
                		 JOptionPane.showMessageDialog(state, "Insert State");
                		 return false;
                	 }
                	 if(pin.getText().equals(""))
                	 {
                		 JOptionPane.showMessageDialog(pin, "Insert Pin code");
                		 return false;
                	 }
                	 if(!pincode())
                	 {
                		 JOptionPane.showMessageDialog(pin, "Invalide pincode");
                		 return false;
                	 }
                	 else if(mHistory.getSelectedIndex()==0)
                  	{
                  		JOptionPane.showMessageDialog(mStatus, "select case");
                  		return false;
                  	}
                	 else
                	 if(guardian.getText().equals(""))
                	 {
                		 JOptionPane.showMessageDialog(guardian, "Insert Gaurdian Name");
                		 return false;
                	 }
                	               	 
					return true;
                 }
				  private boolean validt() {
	                	 try{
	                	    	//ArrayList<Long> ar=new ArrayList<Long>();
	                	    	s15=Long.parseLong(mobile.getText());
	                	    	pattern=Pattern.compile(mobile1);
	                	    	matcher=pattern.matcher(mobile.getText().toString());
	                	    	return matcher.matches();
	                	    }
	                	    catch(Exception e1)
	                	    {
	                	    	JOptionPane.showMessageDialog(mobile, "Invalid number");
	                	       
	                	    }
	                	 return false;
				  }
	private boolean pincode()
	{
	try
		{
	//	ArrayList<Long> ar=new ArrayList<>();
		s16=Long.parseLong(pin.getText());
		pattern=Pattern.compile(pincode);
		matcher=pattern.matcher(pin.getText().toString());
		return matcher.matches();
		}
	catch(Exception e2)
	{
		JOptionPane.showConfirmDialog(pin, JOptionPane.ERROR_MESSAGE);
	}
	return true;
		
	}
	private boolean name()
	{
		try
		{
		pattern=Pattern.compile(name);
		matcher=pattern.matcher(fName.getText().toString());
		return matcher.matches();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fName, JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	private boolean name1()
	{
		try
		{
		pattern=Pattern.compile(name);
		matcher=pattern.matcher(lName.getText().toString());
		return matcher.matches();
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(fName, JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	
	
	}

		