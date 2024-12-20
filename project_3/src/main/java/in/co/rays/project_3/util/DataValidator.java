package in.co.rays.project_3.util;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * DataValidator class is used to validate the data entered by user
 * 
 * @author Muskan Prajapat
 *
 */
public class DataValidator {

	public static boolean isName(String name) {

		String namereg = "^[^-\\s][\\p{L} .']+$";

		// String sname = name.trim();

		if (isNotNull(name) && name.matches(namereg)) {

			return true;
		} else {
			return false;
		}
	}

	
	public static boolean isstockSymbol(String name) {

		String namereg = "^[^-\\s][\\p{L} .']+$";

		// String sname = name.trim();

		if (isNotNull(name) && name.matches(namereg)) {

			return true;
		} else {
			return false;
		}
	}
	/**
	 * Checks if value of Password is in between 8 and 12 characters
	 * 
	 * @param val
	 * @return
	 */
	public static boolean isPasswordLength(String val) {

		if (isNotNull(val) && val.length() >= 8 && val.length() <= 12) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public static boolean isValidAge(String val) {
	 * 
	 * boolean pass = false; if (isDate(val)) { Date cdate = new Date(); try { Date
	 * userdate = DataUtility.formatter.parse(val); int age =
	 * cdate.getYear()-userdate.getYear(); System.out.println("final age  "+age);
	 * if(age>=18){ pass=true; } } catch (ParseException e) {
	 * 
	 * } }
	 * 
	 * return pass; }
	 */

	public static boolean isPassword(String pass) { // my method created

		System.out.println("validate pass");
		String passreg = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";
		// String passreg="^[0-9a-zA-Z]{5}$";
		// String spass = pass.trim();
		// int checkIndex = spass.indexOf(" ");
		// checkIndex==-1
		if (isNotNull(pass) && pass.matches(passreg)) {
			System.out.println("true");
			return true;
		}

		else {
			return false;
		}
	}

	public static boolean isRollNo(String roll) { // my method created

		String rollreg = "[a-zA-Z]{2}[0-9]{3}";
		// String sroll = roll.trim();

		if (DataValidator.isNotNull(roll)) {

			boolean check = roll.matches(rollreg);
			System.out.println(check);
			return check;
		}

		else {

			return false;
		}
	}

	/**
	 * Ckeck if value is Null
	 * 
	 * @param val :val
	 * @return boolean
	 */

	public static boolean isNull(String val) {
		if (val == null || val.trim().length() == 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * check if value is Not Null
	 * 
	 * @param val :value
	 * @return boolean
	 */

	public static boolean isNotNull(String val) {
		return !isNull(val);
	}

	/**
	 * check if an value is an Integer
	 * 
	 * @param val :value
	 * @return boolean
	 */
	public static boolean isInteger(String val) {
		if (isNotNull(val)) {
			try {
				Integer.parseInt(val);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * check if an value is an Long
	 * 
	 * @param val :value
	 * @return boolean
	 */
	public static boolean isLong(String val) {
		System.out.println("in datavalidator..........." + val);
		if (isNotNull(val)) {
			try {
				long l = Long.parseLong(val);
				return true;
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	public static boolean isValidAge(String val) {

		boolean pass = false;
		if (isDate(val)) {
			Date cdate = new Date();
			try {
				Date userdate = DataUtility.formatter.parse(val);
				int age = cdate.getYear() - userdate.getYear();
				System.out.println("final age  " + age);
				if (age >= 18) {
					pass = true;
				}
			} catch (ParseException e) {

			}
		}

		return pass;
	}

	/**
	 * Check if value is valid EmailId
	 * 
	 * @param val :val
	 * @return boolean
	 */
	public static boolean isEmail(String val) {
		String emailregex = "^[_A-Za-z0-9-]+(.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		if (isNotNull(val)) {
			try {
				return val.matches(emailregex);
			} catch (Exception e) {
				return false;
			}
		} else {
			return false;
		}
	}

	/**
	 * check if value is date
	 * 
	 * @param val :val
	 * @return boolean
	 */
	public static boolean isDate(String val) {
		Date d = null;
//		    String s = val;
//			s = s.replace("-", "/");
		if (isNotNull(val)) {
			d = DataUtility.getDate(val);
		}
		return d != null;
	}

	/**
	 * Checks if value is valid Phone No.
	 * 
	 * @param val :val
	 * @return boolean
	 */
	public static boolean isPhoneNo(String val) {

		String phonereg = "^[6-9][0-9]{9}$";
//			String phonereg = "^[6-9]{10}$";

		if (isNotNull(val)) {
			try {
				return val.matches(phonereg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}
	public static boolean isAccountNo(String val) {

		String phonereg = "^\\d{6,12}$";
//			String phonereg = "^[6-9]{10}$";

		if (isNotNull(val)) {
			try {
				return val.matches(phonereg);
			} catch (NumberFormatException e) {
				return false;
			}

		} else {
			return false;
		}
	}


	/**
	 * Checks if value of Mobile No is 10
	 * 
	 * @param val :value
	 * @return boolean
	 */
	public static boolean isPhoneLength(String val) {

		if (isNotNull(val) && val.length() == 10) {
			return true;
		} else {
			return false;
		}
	}
	 public static boolean isTooLong(String val, int maxLength) {
		    if (isNotNull(val)) {
		        return val.length() > maxLength;
		    } else {
		        return false;
		    }
		}
	 
	 public static boolean isAlphanumeric(String input) {
	        String pattern = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20})";
	        return input.matches(pattern);
	    }
	 public static boolean isPositveNumber(int value) {

			return value > 0;

		}
	 public static boolean validateSalary(String salary, HttpServletRequest request) {
	        if (salary != null && !salary.isEmpty()) {
	            // Check if salary has at least 5 digits
	            if (salary.length() < 5) {
	                request.setAttribute("errorMessage", "Salary must be at least 5 digits.");
	                return false;  // Return false as validation failed
	            }

	            // Check if salary is a valid number
	            try {
	                Double.parseDouble(salary);  // Try converting salary to a number
	            } catch (NumberFormatException e) {
	                request.setAttribute("errorMessage", "Salary must be a valid number.");
	                return false;  // Return false as validation failed
	            }
	        } else {
	            request.setAttribute("errorMessage", "Salary is required.");
	            return false;  // Return false as validation failed
	        }
	        return true;  // Return true if validation passed
	    }


	/**
	 * Test Above Methods
	 * 
	 * @param args :args
	 */
	public static void main(String[] args) {
//	  System.out.println(isNull("ssd"));
//	  System.out.println(isNotNull(""));//dought
//	  System.out.println(isInteger("2147483649"));
//	  System.out.println(isLong("50.5"));
//	  System.out.println(isEmail("rah@g.com"));
//	  System.out.println(isDate("18/11/1989"));
		System.out.println(isName("Ankur Agrawal"));
	}


	

}
