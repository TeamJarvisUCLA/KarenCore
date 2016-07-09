package karen.core.util.validate;

import java.text.SimpleDateFormat;
import java.util.Date;

import karen.core.util.UtilDateTime;

import org.exolab.castor.types.DateTime;

public class UtilValidate {
	
	public final static Integer GREATER_THAN = 1;
	public final static Integer LESS_THAN = 2;

	public static void validateString(String value, String nombre, Integer size) throws Exception {
		validateNullOrEmpty(value, nombre);
		
		if (size == 0) {
			return;
		}
		
		if (value.trim().length() > size) {
			throw new Exception("E: Error Code: 098-El campo <b>" + nombre + "</b> no puede contener más de " + size + " caracteres");
		}
	}
	
	public static void validateString(String value, String nombre) throws Exception {
		validateString(value, nombre, 0);
	}
	
	public static void validateNullOrEmpty(Object value, String nombre) throws Exception {
		if (value == null) {
			throw new Exception("E: Error Code: 099-Debe suministrar el valor del campo <b>" + nombre + "</b>");
		}
		
		if (value instanceof String) {
			String o = (String) value;
			
			if (o.trim().length() == 0) {
				throw new Exception("E: Error Code: 099-Debe suministrar el valor del campo <b>" + nombre + "</b>");
			}
		}
	}
	
	public static void validateInteger(Integer value, String nombre, ValidateOperator validateOperator, Integer valueToCompare) throws Exception {
		validateNullOrEmpty(value, nombre);
		
		if (!validateOperator.compare(value, valueToCompare)) {
			throw new Exception("E: Error Code: 098-El valor del campo <b>" + nombre + "</b> debe ser " + validateOperator.getErrorMessage() + " " + valueToCompare);
		}
	}
	
	/**
	 * 
	 * @param value
	 * @param nombre
	 * @param validateOperator
	 * @param date_8601 yyyy-MM-dd
	 * @param formatToShow
	 * @throws Exception
	 */
	public static void validateDate(Long value, String nombre, ValidateOperator validateOperator, String date_8601, String formatToShow) throws Exception {
		validateNullOrEmpty(value, nombre);
		
		value = UtilDateTime.getLongOfDate(value);
		
		Long longDate_8601 = new DateTime(date_8601 + "T00:00:00-04:00").toLong();
		
		if (!validateOperator.compare(value, longDate_8601)) {
			throw new Exception("E: Error Code: 098-El valor del campo <b>" + nombre + "</b> debe ser " +
					validateOperator.getErrorMessage() + " " + new SimpleDateFormat(formatToShow).format(new Date(longDate_8601)));
		}
	}
	
	public enum ValidateOperator {
		GREATER_THAN, LESS_THAN;
		
		public String getErrorMessage() {
			switch(this.ordinal()) {
				case 0:
					return "mayor que";
				case 1:
					return "menor que";
				default:
					return "";
			}
		}
		
		public Boolean compare(Number value, Number valueToCompare) {
			switch(this.ordinal()) {
				case 0:
					return value.doubleValue() > valueToCompare.doubleValue();
				case 1:
					return value.doubleValue() < valueToCompare.doubleValue();
				default:
					return false;
			}
		}
	}
	
//	DateTime dt = new DateTime( "2010-01-01T12:00:00+01:00" ) ;
	
//	long timeInLong=System.currentTimeMillis();
//	DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mmZ");
//	String fmm = df.format(new java.util.Date(timeInLong));
//	System.out.println(fmm);
}
