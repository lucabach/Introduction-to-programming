

public class PrefixConstruction {

	public static boolean isPrefixConstruction(String s, String t, int n) {
		// TODO: Implementieren Sie die Methode
		int i=0;
		return isPrefixConstructionRecursive(s, t, n, i);
	}
		
		public static boolean isPrefixConstructionRecursive(String s, String t, int n, int i) {
			if(s.equals("") && n>=0) {
				return true;
			}
			else if(n<0) {
				return false;
			}
			else {
	
				if(s.charAt(0) == t.charAt(i)) {
					i++;
					return(isPrefixConstructionRecursive(s.substring(1, s.length()), t, n, i));
				}
				else if(s.charAt(0) == t.charAt(0)) {
					n--;
					i=1;
					return isPrefixConstructionRecursive(s.substring(1, s.length()), t, n, i);
				}
				else {
					return false;
				}
			}
		}
}
