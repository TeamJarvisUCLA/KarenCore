package karen.core.util;

import java.sql.Timestamp;
import java.util.Calendar;

public class UtilDateTime {

	public static Long getLongOfDate(Timestamp timestamp) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTime(timestamp);
		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTimeInMillis();
	}
	
	public static Long getLongOfDate(Long timestamp) {
		Calendar calendar = Calendar.getInstance();
		
		calendar.setTimeInMillis(timestamp);
		
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTimeInMillis();
	}
	
	public static Long getLongOfDate(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		
		return calendar.getTimeInMillis();
	}
}
