import java.util.*;

public class Hospital {
	
	List<Pacer> allpagers;
	Map<String, Pacer> activepagers;
	Map<String, Boolean> paused;
		
	public Hospital() {
		// TODO
		allpagers = new ArrayList<Pacer>();
		activepagers = new HashMap<>();
		paused = new HashMap<String, Boolean>();
	}

	public Pager createPager(String role) {
		// TODO
		Pacer pacer = new Pacer(role, this);
		allpagers.add(pacer);
		return pacer;
	}
	
}