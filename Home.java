

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Home extends JFrame implements ActionListener {
	JLabel l;
	//private static final long serialVersionUID = -4388439332936754711L;
	static JButton home,patient_details,search,status,ward_details,signup,
	login,patient_registration,about,descharge;
	public void fun()
	{
		l.setForeground(Color.black);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD|Font.ITALIC, 17));
		add(l);

	}
	public Home() {
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setLayout(null);
		home=new JButton();
		patient_details=new JButton();
		patient_details.setIcon(new ImageIcon("F:\\Logo\\profile.png"));
		search=new JButton();
		search.setIcon(new ImageIcon("F:\\Logo\\Search1.jpg"));
		ward_details=new JButton();
		ward_details.setIcon(new ImageIcon("F:\\Logo\\ward1.jpg"));
		patient_registration=new JButton();
		patient_registration.setIcon(new ImageIcon("F:\\Logo\\registration.jpg"));
		descharge=new JButton();
		descharge.setIcon(new ImageIcon("F:\\Logo\\descharge.jpg"));
		login=new JButton();
		login.setIcon(new ImageIcon("F:\\Logo\\logout.jpg"));
		about=new JButton();
		about.setIcon(new ImageIcon("F:\\Logo\\about.jpg"));
		status=new JButton();
		status.setIcon(new ImageIcon("F:\\Logo\\status.png"));
		
		
		l=new  JLabel("Hompage");
		l.setBounds(500,60,500,80);
		l.setForeground(Color.black);
		l.setFont(new Font("Sitka Subheading",  Font.BOLD|Font.ITALIC, 45));
		add(l);
		
		
		//home.setBounds(80, 200, 100, 40);
		search.setBounds(80, 180, 150, 100);
		l=new JLabel("Search");
		l.setBounds(80, 290, 100, 30);
		fun();
		patient_registration.setBounds(260,180,150,100);
		l=new JLabel("Registration");
		l.setBounds(260,290,100,30);
		fun();
		patient_details.setBounds(440,180,150,100);
		l=new JLabel("Patient");
		l.setBounds(440,290,100,30);
		fun();
		descharge.setBounds(620,180,150,100);
		l=new  JLabel("Discharge");
		l.setBounds(620,290,100,30);
		fun();
		ward_details.setBounds(800,180,150,100);
		l=new JLabel("Ward");
		l.setBounds(800,290,100,30);
		fun();
		status.setBounds(980,180,150,100);
		l=new JLabel("Status");
		l.setBounds(980,290,100,30);
		fun();
		about.setBounds(1160,180,150,100);
		l=new JLabel("About");
		l.setBounds(1160,290,100,30);
		fun();
		login.setBounds(80, 350, 150, 100);
		l=new JLabel("Logout");
		l.setBounds(80,460,100,30);
		fun();
		add(status);
		
		
		//add(home);
		add(patient_details);
		add(search);
		add(ward_details);
		add(patient_registration);
		add(descharge);
		add(login);
		add(about);
	//	home.setEnabled(false);
		
		l=new JLabel("");
		l.setIcon(new ImageIcon("F:\\Logo\\Homepage.jpg"));
		l.setBounds(0, 00, 1382, 782);
		 add(l);
		
		 patient_details.addActionListener(this);
		 search.addActionListener(this);
		 ward_details.addActionListener(this);
		 login.addActionListener(this);
		 patient_registration.addActionListener(this);
		 about.addActionListener(this);
		 descharge.addActionListener(this);
		 status.addActionListener(this);
		
		
	}
	public static void main(String[] args) {
		new Home();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==status)
		{	
			//home.setEnabled(true);
			status.setEnabled(false);
			dispose();
			new P_details();
		}else if(e.getSource()==descharge)
		{
			//home.setEnabled(true);
			descharge.setEnabled(false);
			dispose();
			new  Descharge();
		}
		else if(e.getSource()==login)
		{
			dispose();
			new Hospital_Home();
		}
		else if (e.getSource()==ward_details) {
			dispose();
			new viewWard();
			
		}
		else if(e.getSource()==patient_details)
		{
			dispose();
			new P_profile();
		}
		else if(e.getSource()==search)
		{
			dispose();
			new Search1();
		}
		else if(e.getSource()==patient_registration)
		{
			dispose();
		new P_Registration();
		
		}
		else 
		{
			dispose();
			new About();
		}
		
		
	
		
	}
}
