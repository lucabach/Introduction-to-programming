import java.util.*;

public class Frequencies {
  public double minDistance; //minDistance entspricht dem "d" in der Aufgabenstellung 
  public ArrayList<Coordinate> stations;
  
  public Frequencies(ArrayList<Coordinate> stations, double minDistance) {
    this.stations = stations;
    this.minDistance = minDistance;
  }

  public static void main(String[] args) {
	    ArrayList<Coordinate> stations = new ArrayList<Coordinate>();
	    stations.add(new Coordinate(0.0, 5.0));
	    stations.add(new Coordinate(1.0, 3.0));
	    stations.add(new Coordinate(6.0, 0.5));
	    
	    Frequencies ff = new Frequencies(stations, 7.0);
	    boolean moeglich = ff.assignmentPossible(2);
	    System.out.println(moeglich); // expected output: true
	    int minFrequenzen = ff.minFrequencies();
	    System.out.println(minFrequenzen); // expected output: 2
  }

  
  public boolean assignmentPossible(int N) {
    // TODO
	int count = 1;
	for(int a=0; a<10000; a++) {
		Random r = new Random();
		int c = r.nextInt(stations.size());
		Coordinate first = stations.get(c);
		stations.remove(c);
		stations.add(first);
	
	for(int i=0; i<stations.size(); i++) {
		Coordinate current = stations.get(i);
			if(i==0) {
				current.freq = 1;
			}
			else {
			int j=0;
			for(j=0; j<i; j++) {
					Coordinate possible =stations.get(j);
					boolean ok = true;
					for(int k=0; k<possible.samefreq.size(); k++) {
						if(current.distance(possible.samefreq.get(k)) < minDistance) {
							ok = false;
						}
					}
					if(ok) {
						for(int k=0; k<possible.samefreq.size(); k++) {
							Coordinate cur = possible.samefreq.get(k);
							cur.samefreq.add(current);
						}
						current.freq= possible.freq;
						break;
					}
			}
			if(i==j) {
				current.freq = ++count;
			}
			}
	}
	if(count<=N) {
		return true;
	}
	}
	
    return false;
  }
  
  public int minFrequencies() {
    // TODO 
	int i=1;
	boolean b = false;
	while(true) {
		b =assignmentPossible(i);
		if(b) {
			break;
		}
		i++;
	}
	return i;
  }
  
  public List<Coordinate> mostProblematicStations(int m) {
    // TODO
	 PriorityQueue<Coordinate>p = new PriorityQueue();
	 for(int i=0; i<stations.size(); i++) {
		 int curcount = 0;
		 Coordinate current = stations.get(i);
		 for(int j=0; j<stations.size(); j++) {
			 if(current.distance(stations.get(j))<minDistance) {
				 curcount++;
			 }
		 }
		 current.conflicting=curcount;
		 p.add(current);
  }
	 ArrayList<Coordinate> a = new ArrayList<>();
	 for(int i=0; i<m; i++) {
		 a.add(p.remove());
	 }
	 return a;
  }
}
