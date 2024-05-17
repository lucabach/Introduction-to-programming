package FS18;

public class Kombinationen {
	
	public static String generate(String input) {
		return gen(input,"");
	}

	public static String gen(String s, String current) {
		if(s.isEmpty()) {
			return "\"" + current + "\"";
		}else {
			return gen(s.substring(1),current) + " " + gen(s.substring(1),current+s.charAt(0));
		}
	}
	
	public static void main (String[] args) {
		String s = "ABC";
		System.out.println(s.substring(1));
		System.out.println(generate(s));
	}
}
