import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.border.*;
import com.toedter.calendar.JDateChooser;

public class Registration extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -8524949005292779774L;
	static JTextField fName,lName,email,sq,ans,sAddress,city,state,pin;
	private JButton register,back;
	private JPasswordField p1;
	private JLabel l;
	private String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12;
	private JRadioButton r1,r2;
	private ButtonGroup bg;
	PreparedStatement ps;
	JDateChooser date;
	ResultSet rs;
	String  sql="select * from Employee where Email="+s5+"";
	Connection 	con;
	static JPanel jp;
	static final String pincode="[1-9]{1}+[0-9]{5}";
	static int i;long s16;long s15;
	static final String mail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	Pattern pattern;
	Matcher matcher;

	
public void fun()
	{	
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 16));
	
	}

	public Registration() {
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
			
		Border border=BorderFactory.createLineBorder(Color.BLUE);
		jp=new JPanel();
		jp.setLayout(null);
		jp.setBounds(0, 0, 1382, 782);
		add(jp);
		
		
		l=new JLabel("Employee Registration");
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 22));
		l.setBounds(400, 70, 1085, 140);
		jp.add(l);
		
		l=new JLabel("");
		l.setForeground(Color.blue);
		l.setBounds(130, 40, 1085, 180);
		l.setBorder(border);
		jp.add(l);
		
		
		JLabel label = new JLabel("");
		label.setBounds(130, 240,1085, 300);
		label.setBorder(border);
		jp.add(label);
		
		
		l= new JLabel("First Name");
		l.setBounds(136, 250, 146, 24);
		fun();
		jp.add(l);
		
		fName=new JTextField();
		fName.setBounds(282,250,200,30);
		jp.add(fName);
		
		l= new JLabel("Last Name");
		l.setBounds(136, 300, 146, 24);
		fun();
		jp.add(l);
		
		lName=new JTextField();
		lName.setBounds(282,300,200,30);
		jp.add(lName);
		
		l= new JLabel("Gender");
		l.setBounds(136, 350, 146, 24);		
		fun();
		jp.add(l);
		
		r1=new JRadioButton("Male");
		r1.setSelected(true);
		r2=new JRadioButton("Female");
		r1.setBounds(282,350,100,30);
		r2.setBounds(382,350,100,30);
		jp.add(r1);
		jp.add(r2);
		
		bg=new ButtonGroup();
		bg.add(r1);
		bg.add(r2);
		
		l= new JLabel("DOB");
		l.setBounds(136, 400, 146, 24);
		fun();
		jp.add(l);
		
		date=new JDateChooser();
		date.setBounds(282,400,200,30);
		jp.add(date);
		
		l= new JLabel("Email");
		l.setBounds(500, 250, 146, 24);
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading", Font.BOLD, 16));		
		jp.add(l);
		
		email=new JTextField();
		email.setBounds(650,250,200,30);
		jp.add(email);
		
		
		
		l= new JLabel("Password");
		l.setBounds(500, 300, 146, 24);
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		jp.add(l);
		
		p1=new JPasswordField();
		p1.setBounds(650,300,200,30);
		jp.add(p1);
		
		l= new JLabel("Security Question");
		l.setBounds(500, 350, 146, 24);
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 16));		
		jp.add(l);
		
		sq=new JTextField();
		sq.setBounds(650,350,200,30);
		jp.add(sq);
		
		l= new JLabel("Answer");
		l.setBounds(500,400, 146, 24);
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 16));		
		jp.add(l);
			
		ans=new JTextField();
		ans.setBounds(650,400,200,30);
		jp.add(ans);
		
		l= new JLabel("Street Address");
		l.setBounds(866, 250, 146, 24);
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 16));		
		jp.add(l);
		
		sAddress=new JTextField();
		sAddress.setBounds(1012,250,200,30);
		jp.add(sAddress);
		
		l= new JLabel("City");
		l.setBounds(866, 300, 146, 24);
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 16));		
		jp.add(l);
		
		city=new JTextField();
		city.setBounds(1012,300,200,30);
		jp.add(city);
		
		l= new JLabel("State");
		l.setBounds(866, 350, 146, 24);
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 16));		
		jp.add(l);
		
		state=new JTextField();
		state.setBounds(1012,350,200,30);
		jp.add(state);
		
		l= new JLabel("Pin Code");
		l.setForeground(Color.blue);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD, 16));		
		l.setBounds(866, 400, 146, 24);
		jp.add(l);
		
		pin=new JTextField();
		pin.setBounds(1012,400,200,30);
		jp.add(pin);
		
		register=new JButton("Register");
		register.setBounds(600,470,100,40);
		jp.add(register);		
		
		back=new JButton("Back");
		back.setBounds(730,470,100,40);
		jp.add(back);
		
		l=new JLabel("");
		l.setIcon(new ImageIcon("F:\\Logo\\RegLabel.jpg"));
		l.setBounds(0, 00, 1382, 782);
		jp.add(l);
	
		
		register.addActionListener(this);
		back.addActionListener(this);		
		
	}

		@SuppressWarnings("deprecation")
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(e.getSource()==register)
			{
				if(valid())
				{
				            s1=fName.getText();
							s2=lName.getText();
							if(r1.isSelected())
							{
								s3=r1.getText();
							}
							else
							{
								s3=r2.getText();
							}
							java.util.Date d=date.getDate();
							s4=DateFormat.getDateInstance().format(d);
							s5=email.getText();
							s6=p1.getText();
							s7=sq.getText();
							s8=ans.getText();
							s9=sAddress.getText();
							s10=city.getText();
							s11=state.getText();
							s12=pin.getText();
							
							
							
						
						try {
							Connection cn=Dao.con();
							ps=cn.prepareStatement("select * from Employee where Email=?");
							ps.setString(1, s5);
							ResultSet rs=ps.executeQuery();
							if(rs.next())
							{
								JOptionPane.showMessageDialog(null, "Already Registered");
								return;
							}
							
							else
							{
							ps=cn.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?,?,?,?)");
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
							ps.executeUpdate();
							}
						}catch(Exception e1) {
							JOptionPane.showMessageDialog(lName, "Exception");
							return;
						}
							
		
				}
			}
			else
			{
				new Hospital_Home();
				dispose();
			}
			
		}
		@SuppressWarnings("deprecation")
		public boolean valid()
		{
			LocalDateTime  date1=LocalDateTime.now();
			LocalDate c=date1.toLocalDate();
			Date date2=Date.from(c.atStartOfDay(ZoneId.systemDefault()).toInstant());
			if(fName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(fName, "Enter First Name");
				return false;
			}
			if(lName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(lName, "Enter Last Name");
				return false;
			}
			/* else if(date.getDate().after(date2))
        	 {
        		 JOptionPane.showMessageDialog(date, "You are not able for Employee");
        		 return false;
        	 }*/
			 else if(email.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(email, "Enter Email");
        		 return false;
			 }
			 else if(!isValidEmail())
			 {
				 JOptionPane.showMessageDialog(email, "Invalid Email ");
        		 return false;
			 }
			 else if(p1.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(p1, "create a password");
        		 return false;
			 }
			 else if(sq.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(sq, "Enter Security Question First");
        		 return false;
			 }
			 else if(ans.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(ans, "Enter Security Answer First");
        		 return false;
			 }
			 else if(sAddress.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(sAddress, "Enter Street Address");
        		 return false;
			 }
			 else if(city.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(city, "Enter your City Name");
        		 return false;
			 }
			 else if(state.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(state, "Enter state name");
				 return false;
			 }
			 else if(pin.getText().equals(""))
			 {
				 JOptionPane.showMessageDialog(pin, "Enter your Zip/pin no.");
				 return false;
			 }
			if(!pincode())
			{
				JOptionPane.showMessageDialog(pin, "Enter valid pincode");
				return false;
			}
			return true;
			
		}
		private boolean isValidEmail() {
			pattern=Pattern.compile(mail);
			matcher=pattern.matcher(email.getText().toString());
			return matcher.matches();
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
			//JOptionPane.showConfirmDialog(pin, JOptionPane.ERROR_MESSAGE);
		}
		return true;
			
		}
		
}
