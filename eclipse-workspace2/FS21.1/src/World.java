import java.util.Arrays;

public class World {

    private int size;
    public Biom[][] biom;
    
    public World() {}
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
        biom = new Biom[size][size];

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
        			WaterBiom w = new WaterBiom(this, i, j);
        			biom[i][j]=w;
        			
        		} else if(biomRepr.equals("F")) {
                    // TODO Element (i,j) ist ein Flachland Biom
        			FlachLandBiom f = new FlachLandBiom(this, i, j);
        			biom[i][j]=f;
        			
        		} else {
        			throw new IllegalArgumentException();
        		}
        	}
        }
    }

    public Biom getBiom(int x, int y) {
        // TODO 
        return biom[x][y];
    }

    public void stepDryUp() {
        // TODO
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			biom[i][j].stepDryUp();
    		}
    	}
    }

    public void stepDistribute(int p) {
        // TODO
    	Biom[][] oldworld = new Biom[size][size];
    	World w = new World();
    	
    /*	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			Biom b = biom[i][j];
    			if(b.getBiomType().equals("W")) {
    				oldworld[i][j]= new WaterBiom(w, i, j);
    		    }
    			else {
    				oldworld[i][j]= new FlachLandBiom(w, i, j);
    			}
    	}
    	}
    	*/
    	
    	for(int i=0; i<size; i++) {
    		for(int j=0; j<size; j++) {
    			biom[i][j].stepDistribute(p, oldworld);
    		}
    	}
    }
    
}

