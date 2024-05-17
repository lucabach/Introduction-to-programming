package HS17;
import java.util.HashSet;
import java.util.Set;
import java.math.*;

public class Verzahnungen {

		
		/**
		 * Gibt ein Set mit allen Verzahnungen der beiden Strings s und t zurück.
		 */
		public static Set<String> verzahnung(String s, String t) {
			Set<String> verzahnung = new HashSet<String>();
			recursion(s, t, "", verzahnung);
			return verzahnung;
		}
		
		public static void recursion (String s, String t, String current, Set<String> verzahnung) {
			if (s.length()==0||t.length()==0) {
				verzahnung.add(current+s+t);
			} else {
				recursion (s.substring(1), t, current+s.substring(0,1), verzahnung);
				recursion(s, t.substring(1), current+t.substring(0,1), verzahnung);
			}
		}
		
		public static void main (String[] args) {
			String s = "12";
			String t = "ab";
			Set<String> verzahnung = verzahnung(s, t);
			System.out.println(verzahnung);
		}
	}


