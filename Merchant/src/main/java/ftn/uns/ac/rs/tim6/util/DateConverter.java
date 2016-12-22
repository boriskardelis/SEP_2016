package ftn.uns.ac.rs.tim6.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter {
	
	public static Date convertToJavaDate(Date mySqlDate) {
		try {
			String mySqlString = mySqlDate.toString();
			Date sqlDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(mySqlString);
			return sqlDate;
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}

}
