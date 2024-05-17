
import java.io.PrintStream;

public class Rezept {

	Einheit letzteEinheit;

	public Rezept(Einheit letzteEinheit) {
		this.letzteEinheit = letzteEinheit;
	}

	public void linearisiere(PrintStream output) {
		// TODO
		int a = 1;
		Einheit e = this.letzteEinheit;
		recursion(e, output, a);
	}
	
	public void recursion (Einheit e, PrintStream output, int a) {
		if (e.vorbedingungen.isEmpty()) {
			output.println(a);
			for (String s : e.schritte) {
				output.println(s);
			}
		}
		else {
			while (!e.vorbedingungen.isEmpty()) {
			recursion (e.vorbedingungen.remove(e.vorbedingungen.size()-1), output, a++);
		}
			output.println(a);
			for (String s : e.schritte) {
				output.println(s);
			}
	}
	}

	public void vereinfache() {
		// TODO
	}
}
