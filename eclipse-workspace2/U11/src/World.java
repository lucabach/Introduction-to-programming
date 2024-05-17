import java.util.Arrays;

public class World {

    private int size;
    // TODO: weitere Attribute nach Wahl
    Bio[][] world;
    
    
    
	@Override 
	public String toString() {
    	String str = "";
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
            	str += this.getBiom(x, y).getBiomType();
            }
            str += System.lineSeparator();
        }
        return str;
	}
	
    public World(String [] [] biomGrid) {
        size = biomGrid.length;
        world = new Bio[size][size];

    	if(biomGrid.length < 2) {
    		throw new IllegalArgumentException();
    	}
    	
        for (int i = 0; i < biomGrid.length; i++) {
        	if(biomGrid[i].length != biomGrid.length) {
        		throw new IllegalArgumentException();        		
        	}
        			
        	for(int j = 0; j < biomGrid[i].length; j++) {
        		String biomRepr = biomGrid[i][j];
        		
        		if(biomRepr.equals("W")) {
                    // TODO Element (i,j) ist ein Wasser Biom
        			Bio current = new Bio("W", 15, 0);
        			world[i][j] = current;
        			
        		} else if(biomRepr.equals("F")) {
                    // TODO Element (i,j) ist ein Flachland Biom
        			Bio current = new Bio("F", 12, 3);
        			world[i][j] = current;
        			
        		} else {
        			throw new IllegalArgumentException();
        		}
        	}
        }
    }

    public Biom getBiom(int x, int y) {
        // TODO 
        return world[x][y];
    }

    public void stepDryUp() {
        // TODO
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			Bio current = world[i][j];
    			String type = current.getBiomType();
    			if(type.equals("W")) {
    				int currentflora = current.flora;
    				current.flora = Math.max(currentflora-5, 0);
    			}
    			else {
    				int currentflora = current.flora;
    				current.flora = Math.max(currentflora-3, 0);
    				current.height -=1;
    				if(current.height == 0) {
    					world[i][j] = new Bio("W", current.flora, 0);
    				}
    			}
    		}
    	}
    }
    

    public void stepDistribute(int p) {
        // TODO
    	int[][] oldworld = new int[size][size];
    	String [][] oldworldtype = new String[size][size];
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			oldworld[i][j]=world[i][j].flora;
    			oldworldtype[i][j] = world[i][j].type;
    		}
    	}
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			Bio current = world[i][j];
    			String type = current.getBiomType();
    			
    				int newflora = 0;
    				int count = 0;
    				
    				for(int k=1; k<=p; k++) {
    					try {
    						newflora += oldworld[i+k][j];
    						System.out.println("1: " +newflora);
    						if(oldworldtype[i+k][j].equals("F")) {
    							count++;
    						}
    					}
    					catch(Exception e) {}
    	
						try {
							newflora += oldworld[i-k][j];
							System.out.println("2: " +newflora);
							if(oldworldtype[i-k][j].equals("F")) {
    							count++;
    						}
						}
						catch(Exception e) {}
						
						try {
							newflora += oldworld[i][j+k];
							System.out.println("3: " +newflora);
							if(oldworldtype[i][j+k].equals("F")) {
    							count++;
    						}
						}
						catch(Exception e) {}
						
						try {
							newflora += oldworld[i][j-k];
							System.out.println("4: " +newflora);
							if(oldworldtype[i][j-k].equals("F")) {
    							count++;
    						}
						}
						catch(Exception e) {}
    				}
    				System.out.println();
    				
    				current.flora = newflora;
    
    				
    				if(type.equals("F")) {
    					current.height =current.height + count;
    				}
    			}
    }
    
}
}

