import java.util.HashMap;
import java.util.Map;

public class U11Map {

	public static Map<String, Integer> arrayToMap(String[] A) {
		// TODO
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(int i=0; i<A.length; i++) {
			m.put(A[i], 0);
		}
		return m;
	}
	
	public static Map<String, Integer> arrayToMapOne(String[] A) {
		// TODO
		Map<String, Integer> m = new HashMap<String, Integer>();
		for(int i=0; i<A.length; i++) {
			if(m.containsKey(A[i])){
				m.put(A[i], 1);
			}
			else {
				m.put(A[i], 0);
			}
		}
		return m;
	}
}
