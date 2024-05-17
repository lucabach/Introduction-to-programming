package FS19;

public class Matrix {

	public static Position[] findWord(char[][] matrix, String word) {
		if (matrix.length == 0 ||  word.length()== 0 || word.equals("")) {
			return null;
		}
		char [] words = new char[word.length()];
		Position[] positions = new Position[word.length()];
		boolean [] complete = new boolean [word.length()];
		positions[word.length()-1] = new Position(0,0);
		int n = word.length();
		for (int i = 0; i<word.length(); i++) {
			words [i] = word.charAt(i);
		}
		for (int i = 0; i<matrix.length; i++) {
			for (int j = 0; j< matrix[i].length; j++) {
			if (matrix [i][j] == words [0]) {
				positions [0] = new Position (i, j);
				complete[0] = true;
				if (complete[n-1]) {
					return positions;
				}
				int k = j;
				int m = i;
				int l = 0;
				 	
					while (l<words.length) {
					if (matrix [i][k+1] == words[l+1]) {
						positions [l+1] = new Position (i, k+1);
						complete[l+1] = true;
						k++;
						l++;
						
						if (complete [n-1]) {
							return positions;
						}
						
					} else if (matrix [i][k+1] != words[l+1]) {
					{ k=j;
					  l = 0;
					  break;
					}
				 	}
					}
					
					if (complete [n-1]) {
						return positions;
					}
					
					while (l<words.length && m<words.length-1) {
					if (matrix [m+1][j] == words[l+1]) {
						positions [l+1] = new Position (m+1,j);
						complete[l+1] = true;
						m++;
						l++;
						
						if (complete [n-1]) {
							return positions;
						}
						
					} else if (l<words.length && m<words.length-1) {
					{ m=i;
					  l = 0;
					  break;
					}
				 	}
					}
				 	
					if (complete [n-1]) {
						return positions;
					}
					
					
					while (l<words.length) {
					if (matrix[m+1][k+1] == words[l+1]) {
						positions [l+1] = new Position (m+1,k+1);
						complete[l+1] = true;
						m++;
						k++;
						l++;
						
						if (complete [n-1]) {
							return positions;
						}
						
					} else if (matrix[m+1][k+1] == words[l+1]) {
					{ m=i;
					  l = 1;
					  break;
					}
					}
					}
			}
					
		}
		}
		return null;
	}
	
	public static void main (String[] args) {
		char a = 'a';
		char b = 'b';
		char c = 'c';
		char d = 'd';
		char e = 'e';
		char f = 'f';
		char g = 'g';
		char h = 'h';
		char i = 'i';
		char l = 'l';
		char m = 'm';
		char n = 'n';
		char o = 'o';
		char p = 'p';
		char q = 'q';
		char[][] matrix = {{a, b, c, d, e} , {f, g, h, i, l}, {m, n, o, p, q}};
		String word = "afm";
		Position[] pos = findWord (matrix, word);
		for (int z =0; z<pos.length; z++) {
			System.out.println(pos[z].toString());
		}
	
	}
}
