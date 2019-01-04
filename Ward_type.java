import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ward_type extends JFrame implements ActionListener {

	private static final long serialVersionUID = -4382074988410950271L;
	private JTextArea ta;
	private JLabel l;
	@SuppressWarnings("rawtypes")
	static JComboBox  wId,wardNo,departmentId,departmentName;
	JTextField id;
	JTextField searchtextfield;
	static String s6,s7;
	static JButton add,remove,S,cancle,search;
	String sql="select * from ward";
	String forname="oracle.jdbc.driver.OracleDriver";
	static Connection con;
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	static int bed;
	String username="Priya";
	String password="Gautam";
	String s1,s2,s3,s4,s5,s8,s9,s10;
	Statement smt;
	PreparedStatement ps,ps1,ps2;
	ResultSet rs,rs1;
	int col;
		public void fun()
		{
			l.setFont(new Font("Segoe UI", Font.BOLD|Font.CENTER_BASELINE, 14));
		}
		
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Ward_type() throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setLayout(null);
		

		LocalDateTime currentdate=LocalDateTime.now();
		LocalDate date=currentdate.toLocalDate();
		 s8=date.toString();
		
		
		l= new JLabel("          Search Patient By ward ID");
		l.setFont(new Font("Segoe UI", Font.BOLD|Font.CENTER_BASELINE, 15));
		l.setBounds(277, 35, 240, 28);
		add(l);
		
		searchtextfield= new JTextField();
		searchtextfield.setBounds(550, 35, 220, 30);
		add(searchtextfield);
		
		search= new JButton("Search");
		search.setFont(new Font("Tahoma", Font.BOLD, 14));
		search.setBounds(790, 35, 97,40 );
		add(search);
		
		
		
		l= new JLabel("Ward InFormation");		
		l.setFont(new Font("Tahoma", Font.BOLD, 16));
		l.setBounds(350,100 , 348, 23);
		add(l);
			
		
		l=new JLabel("ID   :");
		fun();
		l.setBounds(277, 164, 220, 30);
		add(l);
		
		id=new JTextField();
		id.setBounds(500,164,220,30);
		add(id);
		
		l= new JLabel("Department Name:");
		fun();
		l.setBounds(277, 203, 220, 24);
		add(l);
		
		departmentName= new JComboBox();
		departmentName.setBounds(500, 204, 220, 25);
		add(departmentName);
		
		
		
		l= new JLabel("Department ID :");
		fun();
		l.setBounds(277, 248, 122, 24);
		add(l);
		
		departmentId= new JComboBox();
		departmentId.setBounds(500,251 , 220, 25);
		add(departmentId);
		
		
		l= new JLabel(" ward Name :");
		fun();
		l.setBounds(277, 294, 122, 14);
		add(l);
		
		wardNo= new JComboBox();
		wardNo.setBounds(500, 287, 220, 25);
		add(wardNo);
				
		l= new JLabel("Ward ID:");
		fun();
		l.setBounds(277, 333, 132, 14);
		add(l);
		
		wId= new JComboBox();
		wId.setBounds(500, 335, 220, 30);
		add(wId);
		
		
		l= new JLabel("Additional note :");
		fun();
		l.setBounds(277, 365, 122, 14);
		add(l);
		
		ta= new JTextArea();
		ta.setBounds(500, 370, 220, 61);
		add(ta);
		
		
		add=new JButton("Add Bed");
	    add.setBounds(290,480,100,50);
	    add(add);
		
		remove=new JButton("Add");
		remove.setBounds(430,480,100,50);
		remove.setEnabled(false);
		add(remove);
		
		S=new JButton("Update");
		S.setBounds(570,480,100,50);
		S.setEnabled(false);
		add(S);
		
		cancle=new JButton("Cancle");
		cancle.setBounds(710,480,100,50);
		add(cancle);
					
		/*
	//	JTable w_detals=new JTable();
		DefaultTableModel w_model=new DefaultTableModel();
		try {
			Class.forName(forname);
			con=DriverManager.getConnection(url,username,password);
			smt=con.createStatement();
			ResultSet rs=smt.executeQuery(sql);
			ResultSetMetaData rsmt=rs.getMetaData();
			col=rsmt.getColumnCount();
			String c[]=new String[col];
			for(int i=0;i<col;i++){
	            c[i]=rsmt.getColumnName(i+1);
	            w_model.addColumn(c[i]);
			}
			
			Object row[]=new Object[col];
			 while(rs.next()){
	             for(int i=0;i<col;i++){
	                    row[i]=rs.getString(i+1);
	                }
	            w_model.addRow(row);
	        }
			
			 
			// w_detals.setModel(w_model);
		//	 JScrollPane scroll=new JScrollPane(w_detals);
		//	 scroll.setBounds(505,150,800,300);
		//	 scroll.createVerticalScrollBar();
		//	 add(scroll);
		
			*
			
		} catch (SQLException | ClassNotFoundException e) {
		
			e.printStackTrace();
		}*/
		
		
		
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("F:\\Logo\\ward.jpg"));
		label.setBounds(0, 0,1382, 782);
		add(label);
		
		cancle.addActionListener(this);
		add.addActionListener(this);
		remove.addActionListener(this);
		S.addActionListener(this);
		search.addActionListener(this);
		
		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","priya","Gautam");
			
				ps1=con.prepareStatement("select * from VIEW_WARD ");
				rs=ps1.executeQuery();
		
				while(rs.next())
				{
				departmentName.addItem(rs.getString("Department_name"));
				
				}
				departmentName.addActionListener(this);
				departmentId.addActionListener(this);
				wardNo.addActionListener(this);
				wId.addActionListener(this);
		
				}


	@SuppressWarnings("unchecked")
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==add)
		{
			String s=(String) wId.getSelectedItem();
			if(s != null)
			{
				try {
				ps=con.prepareStatement("select * from view_ward where ward_id='"+s+"'");
				rs=ps.executeQuery();
				if(rs.next())
				{
					AddBRD.c=rs.getString("ward_id");
				}
				} catch (SQLException e1)
				{
					e1.printStackTrace();
				}
				
}
			try {
				new AddBRD();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==remove)
		{
			boolean b=valid();
			if(b)
			{
			s1=id.getText();
			s2=wId.getSelectedItem().toString();
			s3=wardNo.getSelectedItem().toString();
			s4=departmentId.getSelectedItem().toString();
			s5=departmentName.getSelectedItem().toString();
			s9=ta.getText();
			s10="Admit";
			try {
				ps=con.prepareStatement("select * from ward where id='"+s1+"' and status='"+s10+"'");
				rs=ps.executeQuery();
				//boolean b=rs.next();
				if(rs.next())
				{
					
					JOptionPane.showMessageDialog(id, "Alread Admitted !");
					return;
				}
				else
				{
				try {
					
					ps=con.prepareStatement("insert into ward values(?,?,?,?,?,?,?,?,?,?)");
					ps2=con.prepareStatement("update view_ward set Available_bed=? where ward_no=? && Department_name=? ");
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
					ps.executeQuery();
					PreparedStatement ps3=con.prepareStatement("select * from view_ward where ward_id='"+s2+"'");
					rs=ps3.executeQuery();
					rs.next();
					int a=rs.getInt(7);
					int k=a-bed;
					String s=String.valueOf(k);
					ps3=con.prepareStatement("update view_ward set available_bed='"+s+"'");
					ps3.executeQuery();
					JOptionPane.showMessageDialog(remove, "Success");
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(remove, "Data not Found");
					return;
				}
			}
				
			} catch (SQLException e2) {
				
				
				
				e2.printStackTrace();
				
			}}
			
			}
		
		
		if(e.getSource()==departmentName)
		{
				String s=(String) departmentName.getSelectedItem();
				if(s != null)
				{
					try {
					ps=con.prepareStatement("select Department_id from view_ward where Department_name='"+s+"'");
					rs=ps.executeQuery();
					while(rs.next())
					{
						departmentId.addItem(rs.getString("Department_id"));
					}
					departmentName.setEnabled(false);
					} catch (SQLException e1)
					{
						e1.printStackTrace();
					}
					
					}
				}
		
						if(e.getSource()==departmentId)
						{
							String s=(String) departmentId.getSelectedItem();
							if(s != null)
							{
								try {
								ps=con.prepareStatement("select ward_no from view_ward where Department_id='"+s+"'");
								rs=ps.executeQuery();
								while(rs.next())
								{
									wardNo.addItem(rs.getString("ward_no"));
								}
								} catch (SQLException e1)
								{
									e1.printStackTrace();
								}
								
								}
						
						}
						if(e.getSource()==wardNo)
						{
							String s=(String) wardNo.getSelectedItem();
							if(s != null)
							{
								try {
								ps=con.prepareStatement("select ward_id from view_ward where ward_no='"+s+"'");
								rs=ps.executeQuery();
								while(rs.next())
								{
									wId.addItem(rs.getString("ward_id"));
								}
								} catch (SQLException e1)
								{
									e1.printStackTrace();
								}
								
						}
						}
						if(e.getSource()==S)
						{
							boolean b=valid();
							if(b)
							{
							s1=id.getText();
							s2=wId.getSelectedItem().toString();
							s3=wardNo.getSelectedItem().toString();
							s4=departmentId.getSelectedItem().toString();
							s5=departmentName.getSelectedItem().toString();
							s9=ta.getText();
							s10="Admit";
							try {
								ps=con.prepareStatement("update ward set Department_name=?,Department_id=?,ward_no=?,ward_id=?,Bed_no=?,rate=?,Additional_note=?,status=? where id='"+s1+"'");
								ps.setString(1, s5);
								ps.setString(2, s4);
								ps.setString(3, s3);
								ps.setString(4, s2);
								ps.setString(5, s6);
								ps.setString(6, s7);
								ps.setString(7, ta.getText());
								ps.setString(8, "Admit");
								ps.executeQuery();
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
						}
							
							
							
						}
						}

	private boolean valid() {
		
		if(id.getText().equals(""))
		{
			JOptionPane.showMessageDialog(id, "Enter patient ID");
			return false;
		}
	return true;
	}
}

	
	


