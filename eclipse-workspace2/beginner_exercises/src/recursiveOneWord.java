
public class recursiveOneWord {

	public static String split(String s) {
			return recursion (s, "");
	}
	
	public static String recursion(String s, String current) {
		if(s.length() == 0) {
			return "\"" +current+ "\"";
		}
		else {
			return recursion(s.substring(1), current)+ " " + recursion(s.substring(1), current+s.charAt(0));
		}
	}
	
	public static void main(String[] args) {
		String a = splitTwo("12", "ab");
		System.out.print(a);
	}
	
	public static String splitTwo(String a, String b) {
		return recursion(a, b, "");
	}
	
	public static String recursion(String a, String b, String current) {
		if (a.length() == 0 || b.length() == 0) {
			return current+a+b;
		}
		else {
			return recursion(a.substring(1), b, current+a.charAt(0)) + " " + recursion(a, b.substring(1), current+b.charAt(0));
			
		}
	}
}
