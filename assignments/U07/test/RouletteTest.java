import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RouletteTest {
	
	@Test
	public void testBasic1() {
		RPlayer alice = new RPlayer(200);
		RPlayer bob = new RPlayer(100);
		
		Roulette r1 = new Roulette();
		r1.register(alice);
		
		// Eine Runde Roulette wird gespielt wobei 12 ausgewaehlt wird
		r1.force(12);
		
		// Alice hatte noch keine Wette gesetzt
		assertEquals(200, alice.getBalance());
		assertEquals(100, bob.getBalance());
		
		r1.register(bob);
		
		// Alice und Bob setzen Wetten
		alice.setNumber(9, 10);
		assertEquals(190, alice.getBalance());
		
		bob.setNumber(4, 20);
		assertEquals(80, bob.getBalance());
		
		// Eine Runde Roulette wird gespielt wobei 9 ausgewaehlt wird
		r1.force(9);
		
		// Alice hat 369 gewonnen und Bob hat nichts gewonnen
		assertEquals(550, alice.getBalance());
		assertEquals(80, bob.getBalance());
		
		// Bob setzt eine neue Wette (Alice setzt keine Wette)
		bob.setOdd(80);
		assertEquals(0, bob.getBalance());
			
		// Eine Runde Roulette wird gespielt wobei 9 ausgewaehlt wird
		r1.force(9);
				
		// Bob 160 gewonnen und Alice hatte keine Wette bestaetigt
		assertEquals(550, alice.getBalance());
		assertEquals(160, bob.getBalance());
	}
	
	@Test
	public void testBasic2() {
		RPlayer alice = new RPlayer(200);
		RPlayer bob = new RPlayer(100);
		RPlayer clown = new RPlayer(300);
		
		Roulette r1 = new Roulette();
		r1.register(alice);
		r1.register(bob);
		r1.register(clown);
		
		// Alle setzen Wetten
		alice.setEven(50);
		bob.setNumber(12, 30);
		clown.setNumber(12, 30);
		
		// Clown setzt eine neue Wette, welche die alte Wette invalidiert
		clown.setNumber(5, 200);
		
		// Eine Runde Roulette wird gespielt wobei 12 ausgewaehlt wird
		r1.force(12);
		
		// Alice und Bob haben gewonnen und Clown hat verloren
		assertEquals(250, alice.getBalance());
		assertEquals(1150, bob.getBalance());
		assertEquals(70, clown.getBalance());
	}
	
}
