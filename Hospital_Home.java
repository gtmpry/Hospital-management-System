


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class Hospital_Home extends JFrame implements ActionListener  {
	private JTextField uName;
	private JPasswordField p1;
	private JButton Login,cancle,reset;
	private  JLabel l1,l2;
	static final String email="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
	Pattern pattern;
	Matcher matcher;
	Connection con;
	public Hospital_Home() {
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);	
		
		l1= new JLabel("Email ID");
		l1.setBounds(400, 290, 150,30);
		l1.setFont(new Font("SansSerif", Font.ITALIC, 16));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		l1=new JLabel("Login");
		l1.setBounds(550, 240, 100, 40);
		l1.setFont(new Font("SansSerif", Font.BOLD, 18));
		add(l1);
		
		uName=new JTextField();
		uName.setBounds(510,290,220,30);
		add(uName);
		
		
		l2=new JLabel("Password");
		l2.setBounds(400,340,150,30);
		l2.setFont(new Font("sansSerif", Font.ITALIC, 16));
		l2.setForeground(Color.blue);
		add(l2);
		
		p1=new JPasswordField();
		p1.setBounds(510,340,220,30);
		add(p1);
		
		
		Login=new  JButton("Login");
		Login.setBounds(405,390,90,30);
		//reset.setVisible(false);
		add(Login);
		
		
		cancle=new JButton("Cancle");
		cancle.setBounds(630,390,100,30);
		add(cancle);
		
		
		reset=new JButton("Register");
		reset.setBounds(510,390,100,30);
		add(reset);
				
		l2=new JLabel(" ");
		l2.setBounds(380, 230, 370, 210);
		l2.setIcon(new ImageIcon("F:\\Logo\\patient_profile.jpg"));
		add(l2);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("F:\\Logo\\Login.jpg"));
		label.setBounds(0, 0,1382, 782);
		add(label);
		
		Login.addActionListener(this);
		cancle.addActionListener(this);
		reset.addActionListener(this);
		
	}
	public static void main(String[] args) {
		new  Hospital_Home();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		{
			if(e.getSource()==Login)
			{
				String s1=uName.getText();
				  @SuppressWarnings("deprecation")
				String s2=p1.getText();
		
			try 
			   {
				//Class.forName("oracle.jdbc.driver.OracleDriver");
			  // Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Priya", "Gautam");
				con=Dao.con();
				PreparedStatement ps=con.prepareStatement("select * from employee where Email=? and Password=?");
				ps.setString(1,s1);			
				ps.setString(2,s2);
				ResultSet rs=ps.executeQuery();			
				Boolean b=rs.next();
				if(s1.equals(""))
				 {
					 JOptionPane.showMessageDialog(null, "Enter Please UserName");
					 return ;
				 }
				else
				if(!isValidEmail())
				{
					JOptionPane.showMessageDialog(uName, "Enter a valid Email");
					return;
				}else				 
				 if(s2.equals(""))
				 {

					 JOptionPane.showMessageDialog(null, "Enter Please Password");
					 return ;
				 }
				 
				 if(b) {
					 dispose();
					 new Home();
				 }
				 else
				 {
					 JOptionPane.showMessageDialog(cancle, "Login Fail");
					// reset.setVisible(true);
					 return;
				 }
			   }catch(Exception e1)   {
				   System.out.println(e1);
				   
			   }      
			   }
			else if(e.getSource()==reset)
			{
				new Registration();
				dispose();
			}
			else
			{
				dispose();
			}
		}
	}
	private boolean isValidEmail() {
		pattern=Pattern.compile(email);
		matcher=pattern.matcher(uName.getText().toString());
		return matcher.matches();
	}
}
