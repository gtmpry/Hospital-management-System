import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class P_profile extends JFrame implements ActionListener, MouseListener
{

	private static final long serialVersionUID = 1L;
	String a,g1="Female",g2="Male";
	JLabel l;
	JTextField t,id,name,gender,dob,mobile;
	JButton ok,update,back;
	JTextArea ta,address;
	static Connection con;
	static String s1;
	ResultSet rs;
	PreparedStatement ps;
	P_Update rg;
	String className="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	public P_profile() {
		
		setTitle("Patient Profile");
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
		
		
		l=new JLabel("Patient Profile");
		l.setBounds(540,100,150,30);
		l.setFont(new Font("Sitka Subheading", Font.BOLD|Font.PLAIN, 21));
		l.setForeground(Color.BLUE);
		add(l);
		
		
		l=new JLabel("ID");
		l.setFont(new Font("Sitka Subheading", Font.BOLD|Font.PLAIN, 17));
		l.setForeground(Color.BLUE);
		l.setBounds(450,150,100,40);
		add(l);
		
		id=new JTextField();
		id.setBounds(560, 150, 270, 40);
		add(id);
		
		l=new JLabel("Name");
		l.setForeground(Color.BLUE);
		l.setFont(new Font("Sitka Subheading", Font.BOLD|Font.PLAIN, 17));
		l.setBounds(450, 200, 100, 40);
		add(l);
		
		name=new JTextField();
		name.setBounds(560, 200, 270, 40);
		name.setEditable(false);
		add(name);
		
		l=new JLabel("Gender");
		l.setForeground(Color.BLUE);
		l.setFont(new Font("Sitka Subheading", Font.BOLD|Font.PLAIN, 17));
		l.setBounds(450, 250, 100, 40);
		add(l);
		
		gender=new JTextField();
		gender.setBounds(560, 250, 270, 40);
		gender.setEditable(false);
		add(gender);
		
		l=new JLabel("DOB");
		l.setForeground(Color.BLUE);
		l.setFont(new Font("Sitka Subheading", Font.BOLD|Font.PLAIN, 17));
		l.setBounds(450, 300, 100, 40);
		add(l);
		
		dob=new JTextField();
		dob.setBounds(560, 300, 270, 40);
		dob.setEditable(false);
		add(dob);
		
		l=new JLabel("Mobile No.");
		l.setForeground(Color.BLUE);
		l.setFont(new Font("Sitka Subheading", Font.BOLD|Font.PLAIN, 17));
		l.setBounds(450, 350, 100, 40);
		add(l);
		
		mobile=new JTextField();
		mobile.setBounds(560, 350, 270, 40);
		mobile.setEditable(false);
		add(mobile);
		
		
		l=new JLabel("Address");
		l.setForeground(Color.BLUE);
		l.setFont(new Font("Sitka Subheading", Font.BOLD|Font.PLAIN, 17));
		l.setBounds(450, 400, 100, 40);
		add(l);
		
		address=new JTextArea();
		address.setEditable(false);
		address.setBounds(560, 400, 270, 100);
		add(address);	
		
		ok=new JButton("Ok");
		ok.setBounds(600,520,70,40);
		ok.setForeground(Color.DARK_GRAY);
		add(ok);
		
		back=new JButton("Back");
		back.setBounds(510,520,70,40);
		add(back);
		back.addActionListener(this);
		
		update=new JButton("Update");

		update.setForeground(Color.DARK_GRAY);
		update.setBounds(690,520,100,40);
		add(update);
		
		//ok.addActionListener(this);
		update.addActionListener(this);
		ok.addMouseListener(this);
					
		JLabel label1 = new JLabel(" ");
		label1.setIcon(new ImageIcon("F:\\Logo\\patient_profile.jpg"));
		label1.setBounds(400, 90,480, 480);
		add(label1);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("F:\\Logo\\Login.jpg"));
		label.setBounds(0, 0,1382, 782);
		add(label);
		
		
	}
	public static void main(String[] args) {
		new P_profile();
	}
	@SuppressWarnings("static-access")
	@Override
	public void actionPerformed(ActionEvent e) {
		 s1=id.getText();

		if(e.getSource()==update)
		{
			new  P_Update();
			
			try {
				 //Class.forName(className);
				 //Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Priya","Gautam");
				con=Dao.con();
				ps=con.prepareStatement("select * from  patient where id='"+s1+"'");
				rs=ps.executeQuery();
				boolean b=rs.next();
				if(b)
				{
					
				rg.lName.setText(rs.getString(3));
				rg.lName.setEnabled(false);
				rg.fName.setText(rs.getString(2));
				rg.fName.setEnabled(false);
				rg.id.setText(rs.getString(1));
				rg.id.setEditable(false);
				String datevalue=rs.getString(5);
				java.util.Date date=new SimpleDateFormat("dd-mm-yyyy").parse(datevalue);
				rg.date.setEnabled(false);
				rg.date.setDate(date);
				rg.mobile.setText(rs.getString(6));
				rg.sAddress.setText(rs.getString(8));
				rg.city.setText(rs.getString(9));
				rg.state.setText(rs.getString(10));
				rg.pin.setText(rs.getString(11));
				a=rs.getString(4);
				if(a.equals("Male"))
				{
			        rg.gender1.setSelected(true);;
				}
				if(a.equals("Female"))
				{
					rg.gender2.setSelected(true);;
				}
				String mstatus=rs.getString(7);
				if(mstatus.equals("Single"))
				{
					rg.mStatus.setSelectedIndex(1);
				}else
				{
					rg.mStatus.setSelectedIndex(2);
				}
				if(rs.getString(13).equalsIgnoreCase("Animia"))
				{
					rg.mHistory.setSelectedIndex(1);
				}
				if(rs.getString(13).equalsIgnoreCase("chickenpox"))
				{
					rg.mHistory.setSelectedIndex(2);
				}
				
				
				
				
				}
			} catch (SQLException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			dispose();
			
		}
		if(e.getSource()==back)
		{
			new Home();
			dispose();
		}
		
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==1)
		{
			int s=Integer.parseInt(id.getText());
				try {
				con=Dao.con();
				 ps=con.prepareStatement("select * from  patient where id="+s+"");
				 rs=ps.executeQuery();
				 boolean b=rs.next();
				 if(b)
				 {
					 
					 name.setText(rs.getString(2).concat("  ").concat(rs.getString(3)));
					 gender.setText(rs.getString(4));
					 dob.setText(rs.getString(5));
					 mobile.setText(rs.getString(6));
					 address.setText(rs.getString(8).concat("\n").concat(rs.getString(9).concat("\n").concat(rs.getString(10)).concat("\n").concat(rs.getString(11))));
					 
				 }
				 else {
					JOptionPane.showMessageDialog(id, "Data not Found");
				}
				
				 } catch (SQLException e1) {
						e1.printStackTrace();
					}

		}
		else
		{
			dispose();
			new Home();
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
}
