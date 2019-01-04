

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

import net.proteanit.sql.DbUtils;

public class P_details extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = -1011466160146204704L;
	private JButton b1,b2;
	JLabel l;
	Object c1[][]= {};
	JTable tb;
	JTextField t1,t2,t3;
	static Connection con;
	String driverName = "oracle.jdbc.driver.OracleDriver";
	public void fun()
	{
		l.setFont(new Font("Sitka Subheading", Font.PLAIN, 17));
		l.setForeground(Color.white);
	}
		public P_details() {
	     setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
		
		l= new JLabel();
		l.setBackground(Color.WHITE);
		l.setHorizontalAlignment(SwingConstants.CENTER);
		//l.setEnabled(false);
		//l.setFocusable(false);
		l.setFont(new Font("Tahoma", Font.BOLD, 25));
		l.setForeground(Color.CYAN);
		l.setText("Patient Details");
		l.setBounds(0, 20, 1382, 40);
		add(l);
		
		l = new JLabel("Search Patient By ID");
		l.setBounds(15,85,160,40);
		fun();
		add(l);
		
		t1= new JTextField();
		t1.setBounds(200, 85, 160, 40);
		t1.setFont(new Font("Tahoma", Font.BOLD, 17));
		t1.setForeground(Color.blue);
		add(t1);
		
		b1= new JButton("Search");
		b1.setBounds(375, 85, 160, 40);
		add(b1);
		
		b2= new JButton("Back");
		b2.setBounds(542, 85, 160, 40);
		add(b2);
		
		l= new JLabel("Name");
		l.setBounds(710, 85, 136, 40);
		fun();
		add(l);
		
		t2= new JTextField();
		t2.setBounds(840, 85, 146, 40);
		t2.setFont(new Font("Tahoma", Font.BOLD, 17));
		t2.setForeground(Color.blue);
		t2.setEditable(false);
		add(t2);
		
		l= new JLabel("Status");
		l.setBounds(1050, 85, 136, 40);
		fun();
		add(l);
		
		t3= new JTextField();
		t3.setBounds(1130, 85, 146, 40);
		t3.setFont(new Font("Tahoma", Font.BOLD, 17));
		t3.setForeground(Color.blue);
		t3.setEditable(false);
		add(t3);
		
		try {
			tb=new JTable();
			//Class.forName(driverName);
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Priya","Gautam");
			con=Dao.con();
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=st.executeQuery("select * from patient where status='Addmit'");
			tb.setModel(DbUtils.resultSetToTableModel(rs));
		        JScrollPane sp=new JScrollPane(tb);
				sp.setBounds(5,170,1360,515);
				add(sp);			
		} catch (Exception e) {
			e.printStackTrace();
		}
			tb.addMouseListener(new MouseAdapter() {
			@Override
			public void  mouseClicked(MouseEvent e){
	            int i=tb.getSelectedRow();
	            t1.setText(tb.getModel().getValueAt(i, 0).toString());
	            t2.setText(tb.getModel().getValueAt(i,1).toString());
	            t3.setText(tb.getModel().getValueAt(i, 13).toString());
			}});
			
		JLabel l1=new JLabel();
		l1.setBounds(0, 0, 1382, 782);
		l1.setIcon(new ImageIcon("F:\\Logo\\details.jpg"));
		add(l1);
		b1.addActionListener(this);
		b2.addActionListener(this);
		}
	@Override
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource()==b1){
			if(t1.getText().equals(""))
			{
				JOptionPane.showMessageDialog(t1, "Enter Patient ID");
				return ;
			}
		 String s1=t1.getText();
		 try {
			//Class.forName(driverName);		
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Priya","Gautam");
			PreparedStatement ps=con.prepareStatement("select * from  patient where id=?");
			ps.setString(1, s1);
			ResultSet rs=ps.executeQuery();
			boolean b=rs.next();
			if(b)
		 {
			 t2.setText(rs.getString(2));
			 t3.setText(rs.getString(14));
		 }
		 else {
			JOptionPane.showMessageDialog(t1, "Data not Found");
		}
		
		 } catch (SQLException e1) {
				e1.printStackTrace();
		}
		}
		else
		{
			new Home();
			dispose();
		}
		
}}