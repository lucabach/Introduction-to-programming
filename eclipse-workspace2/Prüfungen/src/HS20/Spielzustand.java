package HS20;

import java.util.*;

public class Spielzustand {

	public static final int reihen = 6;
	public static final int spalten = 7;
	
    public boolean[][] gelbeSteine = new boolean[spalten][reihen];
    public boolean[][] roteSteine = new boolean[spalten][reihen];
    public boolean[][] steine = new boolean[spalten][reihen];
   
    private static final String newline = System.getProperty("line.separator");
    
    public boolean freieSpalte;

    public Spielzustand() {
	}

	public Spielzustand(Spielzustand spielzustand) {
		for(int i = 0; i < gelbeSteine.length; i++) {
			this.gelbeSteine[i] = spielzustand.gelbeSteine[i].clone();
			this.roteSteine[i] = spielzustand.roteSteine[i].clone();
		}
	}
	
	boolean freieSpalte(int spalte) {
		if (gelbeSteine[spalte][5]||roteSteine[spalte][5]) {
			return false;
		}
		return true;
	}
	
	public boolean brettVoll() {
		int i = 0;
		int j=0;
		for(i=0; i<6; i++) {
			for (j=0; j<7; j++) {
				if (!steine[i][j]) {
					break;
				}
			}
		}
		if (i==5 && j==6) {
	    	return true;
		}
		return false;
	}
		
	
	
	public String toString() 
    { 
		String representation = "   ";
		for(int i = 0; i < spalten; i++) {
			representation += i + "  ";
		}
		representation += newline;
		for(int i = reihen -1; i >= 0; i--) {
			representation += i + "  ";
			for(int p = 0; p < spalten; p++) {
				String stein = " ";
				if(gelbeSteine[p][i] && roteSteine[p][i])
				{
					stein = "?";
				} else if(roteSteine[p][i]) {
					stein = "R";
				} else if(gelbeSteine[p][i]) {
					stein = "G";
				}
				representation += stein + "  ";
			}
			representation += newline;
		}
		return representation;       
    } 
    
    public boolean hatGewonnen(boolean roterSpieler) {
    	boolean[][] steine = roteSteine;
    	if (!roterSpieler)
    		steine = gelbeSteine;
		for(int row = 0; row<reihen; row++){
			for (int col = 0;col < spalten - 3;col++){
				if (steine[col][row] && steine[col+1][row] && steine[col+2][row] &&	steine[col+3][row]) {
					return true;
				}
			}			
		}
		for(int row = 0; row < reihen - 3; row++){
			for(int col = 0; col < spalten; col++){
				if (steine[col][row] && steine[col][row+1] && steine[col][row+2] && steine[col][row+3]){
					return true;
				}
			}
		}
		for(int row = 3; row < reihen; row++){
			for(int col = 0; col < spalten - 3; col++){
				if (steine[col][row] && steine[col+1][row-1] &&	steine[col+2][row-2] && steine[col+3][row-3]){
					return true;
				}
			}
		}
		for(int row = 0; row < reihen - 3; row++){
			for(int col = 0; col < spalten - 3; col++){
				if (steine[col][row] && steine[col+1][row+1] &&	steine[col+2][row+2] && steine[col+3][row+3]){
					return true;
				}
			}
		}
		return false;
    }
    
    public void setzeStein(boolean roterSpieler, int spalte) {
      //TODO
      int i = 0;
      while (gelbeSteine[spalte][i]||roteSteine[spalte][i]) {
    	 i++;
      }
      if (roterSpieler) {
    	  this.roteSteine[spalte][i]=true;
    	  this.steine[spalte][i]=true;
      }
      else {
    	  this.gelbeSteine[spalte][i]=true;
    	  this.steine[spalte][i]= true;
      }
    }

	public Set<Integer> moeglicheSpalten() {
      //TODO
	Set<Integer> moeglich = new HashSet<>();
	for (int j=0; j<7; j++) {
		if(freieSpalte(j)) {
			moeglich.add(j);
		}
	}
		return moeglich;
	}

 }
