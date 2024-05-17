package HS20;

public class Fourinarow {

 	
	 public boolean kannGewinnen(boolean roterSpieler, Spielzustand brett, int n) {
		  if (brett.hatGewonnen(roterSpieler) || brett.hatGewonnen(!roterSpieler)) {
			  throw new IllegalStateException("Jemand hat schon gewonnen");
		  }
		  if (brett.brettVoll()){
			  return false;
		  }
		  if (roterSpieler) {
			  for (int i=0; i<6; i++) {
				  for(int j=0; j<n; j++) {
						  brett.setzeStein(roterSpieler, i);
						  i++;
						  if (brett.hatGewonnen(roterSpieler)) {
							  return true;
					  }
				  }
			  }
		  }
		  else {
			  for (int i=0; i<6; i++) {
				  for(int j=0; j<n; j++) {
						  brett.setzeStein(!roterSpieler, i);
						  i++;
						  if (brett.hatGewonnen(!roterSpieler)) {
							  return true;
						  }
				  }
			  }
		  }
		  return false;
}

	  
	  public boolean unentschieden(boolean roterSpieler, Spielzustand brett) {
		  if (brett.hatGewonnen(roterSpieler) || brett.hatGewonnen(!roterSpieler)) {
			  throw new IllegalStateException("Jemand hat schon gewonnen");
		  }
		  
		  //TODO

		  
		  
		  return true;
	  }
	  
	  public static void main(String[] args) {
		  Fourinarow fia = new Fourinarow();
		  Spielzustand state = new Spielzustand();
		  state.setzeStein(false, 0);
		  state.setzeStein(true, 6);
		  state.setzeStein(false, 1);
		  state.setzeStein(true, 6);
		  state.setzeStein(false, 3);
		  state.setzeStein(true, 5);
		  System.out.println(state);
		  System.out.print("Koennte der gelbe Spieler mit einem Stein gewinnen? ");
		  System.out.println( fia.kannGewinnen(false, state, 1) );
		  System.out.print("Koennte der rote Spieler mit einem Stein gewinnen? ");
		  System.out.println( fia.kannGewinnen(true, state, 1) );
		  System.out.print("Koennte der rote Spieler mit zwei Steinen gewinnen? ");
		  System.out.println( fia.kannGewinnen(true, state, 2) );
	  }
	}
