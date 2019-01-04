import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class period {
static long diffDays;
static Date d1 ;
static Date d2;
static Date dd;
static String s1;
public static long diff()
{
	Connection con=Dao.con();
	try {
		PreparedStatement ps=con.prepareStatement("select * from ward where id='"+s1+"'");
		ResultSet rs=ps.executeQuery();
		rs.next();
		dd=rs.getDate(8);
		Date d=new SimpleDateFormat("dd-mm-yyyy").parse(rs.getString(8));
		//System.out.println(dd);
	} catch (SQLException | ParseException e1) {
		e1.printStackTrace();
	}
	

	d1 = dd;

	try {
		LocalDateTime  date=LocalDateTime.now();
		LocalDate c=date.toLocalDate();
		Date date1= Date.from(c.atStartOfDay(ZoneId.systemDefault()).toInstant());
		d2=date1;
		//in milliseconds
		long diff = d2.getTime() - d1.getTime();
		diffDays = diff / (24 * 60 * 60 * 1000);
		Descharge.diffDays=diffDays;
		//System.out.print(diffDays + " days, ");

	} catch (Exception e) {
		e.printStackTrace();
	}

	
	return diffDays;
	
}
}
