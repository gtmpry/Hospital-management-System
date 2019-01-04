import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class Search extends JFrame implements ActionListener 

{
	private static final long serialVersionUID = -402330400671699300L;
	JButton b1;
	JLabel name,id,wname,did,dname,sts,adate,l;
	static String s;
	String s1,s2,s3,s4,s5,s6,s7,s8;
	Ward_type w;
	static Connection con=Dao.con();
	public void fun()
	{
		l.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		l.setForeground(Color.blue);
	}
	
	public Search() {
		setSize(550,500);
		setVisible(true);
		setResizable(false);
		setLayout(null);
		
		l=new JLabel("Search Result");
		l.setBounds(0,60,450,40);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		fun();
		l.setFont(new Font("Sitka Subheading", Font.ITALIC, 18));
		add(l);
		
		
		l=new JLabel("ID");
		l.setBounds(80,100,80,30);
		fun();
		add(l);
		
		id=new JLabel();
		id.setBounds(300, 100, 150, 30);
		fun();
		add(id);
		
		
		l=new JLabel("Name");
		l.setBounds(80,140,120,30);
		fun();
		add(l);
		
		name=new JLabel();
		name.setBounds(300, 140, 150, 30);
		fun();
		add(name);
		
		
		
		l=new JLabel("Ward Number");
		l.setBounds(80,180,120,30);
		fun();
		add(l);
		
		wname=new JLabel();
		wname.setBounds(300, 180, 150, 30);
		fun();
		add(wname);
		
		
		l=new JLabel("Department ID");
		l.setBounds(80,220,120,30);
		fun();
		add(l);
		
		did=new JLabel();
		did.setBounds(300, 220, 150, 30);
		add(did);

		
		l=new JLabel("Department Name");
		l.setBounds(80,260,140,30);
		fun();
		add(l);
		
		dname=new JLabel();
		dname.setBounds(300, 260, 150, 30);
		add(dname);
		
		
		l=new JLabel("Admitted Date");
		l.setBounds(80,300,120,30);
		fun();
		add(l);
		
		adate=new JLabel();
		adate.setBounds(300, 300, 150, 30);
		add(adate);
		
		
		l=new JLabel("Status");
		l.setBounds(80,340,80,30);
		fun();
		add(l);
		sts=new JLabel();
		sts.setBounds(300, 340, 150, 30);
		add(sts);
		
		b1=new JButton("Ok");
		b1.setBounds(225,390,80,40);
		add(b1);
		b1.addActionListener(this);
		
		try {
			//Class.forName("jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priya","Gautam");
			PreparedStatement ps=con.prepareStatement("select * from patient  where id='"+s+"'");
			PreparedStatement ps2=con.prepareStatement("select * from ward where Id='"+s+"'");
			ResultSet rs=ps.executeQuery();
			ResultSet rs2=ps2.executeQuery();
			rs.next();
			rs2.next();
			
		String f=rs.getString(2);
		String g=f.concat("");
		s1=g.concat(rs.getString(3));
		name.setText(s1);
		id.setText(rs.getString(1));
		wname.setText(rs2.getString(3));
		did.setText(rs2.getString(4));
		dname.setText(rs2.getString(5));
		adate.setText(rs2.getString(8));
		sts.setText(rs.getString(14));
					
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(sts, "Data not Found");
			return;
			
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Ward_type.departmentName.setSelectedIndex(1);
		dispose();
		
		
	}
	
	

}
