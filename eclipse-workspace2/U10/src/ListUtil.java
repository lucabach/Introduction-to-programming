
public class ListUtil {
	
	static void addMin(IntList x) {
		// TODO
		int min = Integer.MAX_VALUE;
		for(int i=0; i< x.getSize(); i++) {
			min = Math.min(min,  x.get(i));
		}
		x.addLast(min);
	}
	
	static void addMinImpl(LinkedIntList x) {
		// TODO
		addMin(x);
	}
}
