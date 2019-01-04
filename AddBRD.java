import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddBRD extends JFrame implements ActionListener{
	JLabel l;
	JComboBox bedNo;
	JLabel rate;
	JButton add,back;
	static String bed,rs;
	Ward_type b;
	Connection con;
	ResultSet r,r1;
	PreparedStatement ps,ps1;
	String labels[] = { "0","1", "2", "3"};
	static String c;	
	public AddBRD() throws SQLException, ClassNotFoundException {
			
		setSize(300,300);
		setVisible(true);
		setLayout(null);
		
		l=new JLabel("Bed No.");
		l.setBounds(30,80,80,30);
		add(l);
		
		bedNo=new JComboBox<>();
		bedNo.setBounds(110, 80, 130, 30);
		add(bedNo);
		
		final DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<Object>(labels);
		bedNo.setModel(model);
		
		l=new JLabel("Rate/Day");
		l.setBounds(30, 120, 80, 30);
		add(l);
		
		rate=new JLabel();
		rate.setBounds(110, 120, 130, 30);
		add(rate);
		
		add=new JButton("Add");
		add.setBounds(40,170,60,40);
		add(add);
		
		back=new JButton("Back");
		back.setBounds(110,170,70,40);
		add(back);
		
		JLabel label = new JLabel(" ");
		label.setIcon(new ImageIcon("F:\\Logo\\AddBed2.jpg"));
		label.setBounds(0, 0,1382, 782);
		add(label);	
		
		
		add.addActionListener(this);
		back.addActionListener(this);
		bedNo.addActionListener(this);
		
	}


	@Override
	public void actionPerformed(ActionEvent a) {
		if(a.getSource()==bedNo)
		{
			
		try {
			con=Dao.con();
			ps=con.prepareStatement("select rate from view_ward where ward_id='"+c+"'");
			r=ps.executeQuery();
			boolean b=r.next();	
			ps1=con.prepareStatement("select * from view_ward where ward_id='"+c+"'");			
			r1=ps1.executeQuery();
			r1.next();
			String s=r1.getString("total_bed");
			String s1=r1.getString("Available_bed");
			int a2=Integer.parseInt(s1);
			String s2=(String) bedNo.getSelectedItem();
			int a3=Integer.parseInt(s2);
			if(a2>=a3)
			{
				String s3=r.getString("rate");
				int a4=Integer.parseInt(s3);
				int a5=a3*a4;
				String s4=String.valueOf(a5);
				rate.setText(s4);
				rs=s4;
				bed=s2;
				Ward_type.bed=a3;
				
			}
			else
			{
				rate.setText("");
				JOptionPane.showMessageDialog(bedNo, "Not Available !");
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(rate, "Cann't Find data");
			return;
		}
		
		}
		if(a.getSource()==add)
		{
			if(valid())
			{
			
			Ward_type.remove.setEnabled(true);
			Ward_type.S.setEnabled(true);
			Ward_type.s6=bed;
			Ward_type.s7=rs;
			setVisible(false);
			
			}
		}
		
		if(a.getSource()==back)
		{
			dispose();
			Ward_type.remove.setEnabled(false);
			Ward_type.S.setEnabled(false);
		}
		
		
		
	}


	private boolean valid() {
		
		if(bedNo.equals("0"))
		{
			JOptionPane.showMessageDialog(bedNo, "Select a bed");
			return false;
		}

		
		return true;
	}

	}
