import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class About extends JFrame implements ActionListener{
	
	JLabel l;
	JPanel p;
	JButton b;
	@SuppressWarnings("deprecation")
	public About() {
		
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		setLayout(null);
		
		l=new JLabel("About");
		l.setBounds(80,120,1240,30);
		l.setHorizontalAlignment(DEFAULT_CURSOR);
		l.setFont(new Font("Sitka Subheading", Font.PLAIN|Font.CENTER_BASELINE, 23));
		l.setForeground(Color.blue);
		add(l);
		
		JTextArea t1=new JTextArea();
		t1.setText("A hospital is a health care institution providing patient treatment with  "+"\n"+
				 "specialized medical and nursing staff and medical equipment. The best-known type"
				+"\n"+ " of hospital is the general hospital, which typically has an emergency "
				+"\n"+ "department to treat urgent health problems ranging from fire and accident victims "
				+"\n"+ " to a heart attack. A district hospital typically is the major health care facility in"
				+"\n"+" its region, with a large number of beds for intensive care and additional beds for "
				+"\n"+ " patients who need long-term care. Specialized hospitals include trauma centers,"
				+"\n"+ " rehabilitation hospitals, children's hospitals, seniors' hospitals, and hospitals"
				+"\n"+ " for dealing  with specific medical needs such as psychiatric treatment and certain"
				+"\n"+ " disease categories. Specialized hospitals can help reduce health care costs compared "
				+"\n"+ "to general hospitals. Hospitals are classified as general, specialty, or government"
				+"\n"+ " depending on the sources of income received.");
		t1.setBounds(300, 180,800, 400);
		t1.setBackground(getBackground());
		t1.setFont(new Font("Sitka Subheading", Font.PLAIN|Font.CENTER_BASELINE, 17));
		t1.setEditable(false);
		add(t1);
		
		b=new JButton("OK");
		b.setBounds(400,340,60,40);
		b.setVisible(true);
		t1.add(b);
		b.addActionListener(this);
				
		
		l=new JLabel("");
		l.setIcon(new ImageIcon("F:\\Logo\\Homepage.jpg"));
		l.setBounds(0, 00, 1382, 782);
		 add(l);
	}
	
	public static void main(String[] args) {
		new About();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
		new Home();
		
		
	}

}
