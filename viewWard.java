import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class viewWard extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel l,wNo,Bedno,DName,ABed,Avp;
	JTextField t;
	JButton b,b1;
	JTable table;
	static Connection con=Dao.con();
	ResultSet rs;
	Statement smt;

	viewWard() {
		
		setTitle("View Avilable Ward & Bed");
		setBackground(Color.darkGray);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setLayout(null);
		
		
		t=new JTextField();
		t.setFocusable(true);
		t.setBounds(80, 100, 300, 40);
		add(t);
		
		
		
		b=new JButton("Search");
		b.setBounds(400,100,100,40);
		add(b);
		
		l=new JLabel("Avilable Ward_Details");
		l.setBounds(750, 100, 300, 40);
		l.setFont(new Font("Sitka Subheading", Font.PLAIN, 22));
		l.setForeground(Color.blue);
		add(l);
		
		
		l=new JLabel("Ward No.");
		l.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		l.setBounds(80,160,140,40);
		add(l);
		
		wNo=new JLabel();
		wNo.setBounds(230, 160, 200, 40);
		add(wNo);
		
		
		l=new JLabel("Department Name");
		l.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		l.setBounds(80, 220, 140, 40);
		add(l);
		
		DName=new JLabel();
		DName.setBounds(230, 220, 200, 40);
		add(DName);
		
		
		l=new JLabel("Available Bed ");
		l.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		l.setBounds(80, 280, 140, 40);
		add(l);
		
		
		
		ABed=new JLabel();
		ABed.setBounds(230,280,200,40);
		add(ABed);
		
		
		l=new JLabel("Available Patient ");
		l.setFont(new Font("Sitka Subheading", Font.PLAIN, 16));
		l.setBounds(80, 340, 200, 40);
		add(l);
		
		Avp=new  JLabel();
		Avp.setBounds(230, 340, 200, 40);
		add(Avp);
		
		b1=new JButton("Ok");
		b1.setBounds(230,390,80,40);
		add(b1);
		
		
table=new JTable();
		
		
		
		try {
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection 	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priya","Gautam");
			smt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs=smt.executeQuery("select * from view_ward");
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		
	/*	*/	
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void  mouseClicked(MouseEvent e){
	            int i=table.getSelectedRow();
	            
	            wNo.setText(table.getModel().getValueAt(i, 2).toString());
	            DName.setText(table.getModel().getValueAt(i,3).toString());
	            ABed.setText(table.getModel().getValueAt(i, 6).toString());
	            String s=table.getModel().getValueAt(i,4).toString();
	            String ss=table.getModel().getValueAt(i,6).toString();
	            int a=Integer.parseInt(s);
	            int a1=Integer.parseInt(ss);
	            int b=a-a1;	 
	            String b1=String.valueOf(b);
	            Avp.setText(b1);
	           
	            
	           
	            
	           
	         
	        }
		});
		
	JScrollPane jp=new JScrollPane(table);
	//jp.setHorizontalScrollBarPolicy(JScrollBar.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
	jp.setBounds(500,160,850,330);
	add(jp);
	
	JLabel l1=new JLabel();
	l1.setBounds(0, 0, 1382, 782);
	l1.setIcon(new ImageIcon("F:\\Logo\\ward.jpg"));
	add(l1);
	
	b.addActionListener(this);
	b1.addActionListener(this);
	
	}
	public static void main(String[] args) {
		new viewWard();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String s=t.getText();
		if(e.getSource()==b)
		{
			try {
			//	Class.forName("oracle.jdbc.driver.OracleDriver");
			//	Connection 	con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priya","Gautam");
				smt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				rs=smt.executeQuery("select * from view_ward where department_id='"+s+"'");
				table.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e1) {
		
				JOptionPane.showMessageDialog(table, "Data not found");
			}
		}
		else
		{
			new Home();
			dispose();
		}
	
		
	}
}
