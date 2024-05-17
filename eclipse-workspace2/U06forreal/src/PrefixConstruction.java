import static org.junit.Assert.assertTrue;

public class PrefixConstruction {
	
	public static void main(String[] args) {
		boolean bool = PrefixConstruction.isPrefixConstruction("abababc", "ababc", 2);
		System.out.println(bool);
	}

	public static boolean isPrefixConstruction(String s, String t, int n) {
		// TODO: Implementieren Sie die Methode
		int i=0;
		return isPrefixConstructionRecursive(s, t, n, i);
	}
		
		public static boolean isPrefixConstructionRecursive(String s, String t, int n, int i) {
			if(s == null || t == null) {
				return false;
			}
			if(t.equals("") && s.length()>=1) {
				return false;
			}
			if(s.equals("") && t.equals("")) {
				return true;
			}
			if(s.equals("") && n>=0) {
				return true;
			}
			else if((s.length()>0 && n==0) || n<0) {
				return false;
			}
			
			else {
				if(i<t.length()) {
					if(s.charAt(0) == t.charAt(i) && s.charAt(0)==t.charAt(0) && i!=t.length()-1) {
						return isPrefixConstructionRecursive(s.substring(1, s.length()), t, n, ++i) ||
								isPrefixConstructionRecursive(s.substring(1, s.length()), t, --n, 1);
					}
					if(s.charAt(0) == t.charAt(i) && i!=t.length()-1) {
						i++;
						return(isPrefixConstructionRecursive(s.substring(1, s.length()), t, n, i));
				}
				}
				
				if(s.charAt(0) == t.charAt(i)) {
					n--;
					i=0;
					return isPrefixConstructionRecursive(s.substring(1, s.length()), t, n, i);
				}
				if(s.charAt(0) == t.charAt(0)) {
					n--;
					i=1;
					return isPrefixConstructionRecursive(s.substring(1, s.length()), t, n, i);
				}
				return false;
			}
		}
}
