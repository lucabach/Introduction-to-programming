package HS18;

public class Nesting {

    public static boolean isCorrectlyNested(String s) {
        int c1Open = 0;
        int c1Closed = 0;
        int c2Open = 0;
        int c2Closed = 0;
        int c3Open =0;
        int c3Closed = 0;
        int n = s.length();
        int i = 0;
        while(i<n) {
        	if (s.charAt(i) == ')') {
        		c1Open++;
        	}
        	if (s.charAt(i)=='[') {
        		c2Open++;
        	}
        	if (s.charAt(i)=='<') {
        		c3Open++;
        	}
        	if (s.charAt(i)== ')') {
        		c1Closed++;
        	}
        	if (s.charAt(i)== ']') {
        		c2Closed++;
        	}
        	if (s.charAt(i)== '>') {
        		c3Closed++;
        	}	
        	i++;
        }
        if (c1Open != c1Closed || c2Open!= c2Closed || c3Open != c3Closed) {
        	return false;
        }
        
        if (s.contains("(]") || s.contains("[)")|| s.contains("<)") || s.contains("(>") || s.contains("<]")|| s.contains("[>")) {
        	return false;
        }
        return true;
    }
}
