

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Descharge extends JFrame implements ActionListener {
	private JLabel l;
	private JButton discharge,cancle,serch;
	private JTextArea ta;
	static JTextField lName,wno,tday,bno,TAmount,id1,Rd,Did,aDate,dDate;
	static String s1,s4,s5,s6;
	static String s3="Discharge";
	public static long diffDays;
	ResultSet rs,r;
	PreparedStatement ps;
	Connection con;
	int a,b,c;
	void Fun()
	{
		l.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		
		l.setForeground(Color.BLUE);
	}
	public Descharge() {
		setVisible(true);
		setExtendedState(MAXIMIZED_BOTH);
		setLayout(null);
		
		l=new JLabel("ID");
		l.setBounds(320,210,146,30);
		Fun();
		add(l);
		
		l=new JLabel("DisCharge");
		l.setFont(new Font("Tahoma", Font.BOLD, 20));
		l.setBackground(Color.DARK_GRAY);
		l.setBorder(new LineBorder(Color.white));
		add(l);
		
		id1=new JTextField();
		id1.setBounds(446,210,120,30);
		add(id1);
		
		serch=new JButton("Search");
		serch.setBounds(568,210,100,30);
		add(serch);
		serch.addActionListener(this);
		
		l= new JLabel("Name");
		Fun();
		l.setBounds(320,250,146,30);
		add(l);
		
		lName=new JTextField();
		lName.setEnabled(false);
		lName.setBounds(446,250,220,30);
		add(lName);
				
		l= new JLabel("Admit Date");
		l.setBounds(320,290,146,30);
		Fun();
		add(l);
		
		aDate=new JTextField();
		aDate.setBounds(446, 290, 220, 30);
		aDate.setEnabled(false);
		add(aDate);
		
		l= new JLabel("Discharge Date");
		l.setBounds(320,330,146,30);
		Fun();
		add(l);
		
		dDate=new JTextField();
		dDate.setBounds(446, 330, 220, 30);
		dDate.setEditable(false);
		add(dDate);
		
		LocalDateTime  date=LocalDateTime.now();
		LocalDate c=date.toLocalDate();
		dDate.setText(c.toString());
			
		l= new JLabel("Medical History");
		l.setBounds(320,370,146,30);
		Fun();
		add(l);
		
		ta=new JTextArea();
		ta.setBounds(446,370,220,50);
		add(ta);
		
		l= new JLabel("ward No.");
		l.setBounds(700,210,146,30);
		Fun();
		add(l);
		
		wno=new JTextField();
		wno.setBounds(846,210,220,30);
		wno.setEnabled(false);
		add(wno);
		
	    l= new JLabel("Bed No.");
	    l.setBounds(700,250,146,30);
	    Fun();
		add(l);
		
		bno=new JTextField();
		bno.setBounds(846,250,220,30);
		bno.setEnabled(false);
		add(bno);
		
		l= new JLabel("Department ID");
		l.setBounds(700,290,146,30);
		Fun();
		add(l);
		
		Did=new JTextField();
		Did.setEnabled(false);
		Did.setBounds(846,290,220,30);
		add(Did);
		
		l= new JLabel("Bed");
		l.setBounds(700,330,146,30);
		Fun();
		add(l);
		
		Rd=new JTextField();
		Rd.setBounds(846,330,220,30);
		Rd.setEnabled(false);
		add(Rd);
		
		l= new JLabel("Total Day");
		Fun();
		l.setBounds(700,370,146,30);
		add(l);
		
		tday=new JTextField();
		tday.setEnabled(false);
		tday.setBounds(846,370,220,30);
		add(tday );
		
		l= new JLabel("Total Amount");
		l.setBounds(700,410,146,30);
		Fun();
		add(l);
		
		TAmount=new JTextField();
		TAmount.setEnabled(false);
		TAmount.setBounds(846,410,220,30);
		add(TAmount);
		
		discharge=new JButton("Discharge");
		cancle=new JButton("Cancel");
		cancle.addActionListener(this);
		discharge.setBounds(400,460,100,40);
		cancle.setBounds(530,460,100,40);
		add(discharge);
		add(cancle);
		
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("F:\\Logo\\dis.jpg"));
		label.setBounds(0, 0,1382, 782);
		add(label);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		discharge.addActionListener(this);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
				if(e.getSource()==serch)
				{			
						s1=id1.getText();
						period.s1=s1;
						try {
							con=Dao.con();
							 ps= con.prepareStatement("select * from patient where id='"+s1+"'");
							 rs=ps.executeQuery();
							if(rs.next())
							{
							String getfirstname=rs.getString(2);
							String getlastname=rs.getString(3);
							String conct=getfirstname.concat(" ").concat(getlastname);
							lName.setText(conct);
							PreparedStatement p=con.prepareStatement("select * from ward where id='"+s1+"'");
							r=p.executeQuery();
							if(r.next())
							{
							wno.setText(r.getString(2));
							bno.setText(r.getString(5));
							Did.setText(r.getString(3));
							Rd.setText(r.getString(6));	
							aDate.setText(r.getString(8));
							long diffrence=period.diff();
							tday.setText(String.valueOf(diffrence));
							a=Integer.parseInt(r.getString(6));
							PreparedStatement ps1=con.prepareStatement("select * from view_ward where ward_id='"+r.getString(2)+"'");
							ResultSet rs1=ps1.executeQuery();
							rs1.next();
							b=rs1.getInt(7);
							c=a+b;
							int d=rs1.getInt(6);
							long f=d*diffrence;
							TAmount.setText(String.valueOf(f));
							}
							}
						} catch (Throwable e1) {
							e1.printStackTrace();
						}
						
	}
				if(e.getSource()==discharge)
				{
					try
					{
					String status="Discharge";
					ps=con.prepareStatement("update patient set status='"+status+"'where id='"+s1+"'");
					ps.executeUpdate();
					PreparedStatement ps3=con.prepareStatement("update ward set status='"+status+"'where id='"+s1+"'");
					ps3.executeUpdate();
					PreparedStatement ps4=con.prepareStatement("update view_ward set available_bed='"+String.valueOf(c)+"'where ward_id='"+r.getString(2)+"'");
					ps4.executeUpdate();					
					JOptionPane.showMessageDialog(discharge, "Success");
					}catch(Exception e1)
					{
						e1.printStackTrace();
					}

				}
				if(e.getSource()==cancle)
				{
					dispose();
					new Home();
				}
				}}
