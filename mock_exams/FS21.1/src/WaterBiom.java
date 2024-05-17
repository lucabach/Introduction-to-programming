
public class WaterBiom implements Biom {
	
	int flora;
	int height;
	World world;
	int x; int y;
	
	public WaterBiom(World world, int x, int y) {
		this.flora = 15;
		this.height = 0;
		this.world = world;
		this.x = x; 
		this.y = y;
	}
	
	public String getBiomType() {
		return "W";
	}
    /*
     *       "W" fuer Wasser
     *       "F" fuer Flachland
     */

	public int getFlora() {
		return flora;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void stepDryUp() {
		flora = Math.max(flora-5, 0);
	}
	
	
	public void stepDistribute(int p, Biom[][] oldworld) {
		int sum = 0;
		for(int i=1; i<=p; i++) {
			
			try {
				sum+=oldworld[x-i][y].getFlora();
			} catch (Exception e) {}
			
			
			try {
				sum+=oldworld[x+i][y].getFlora();
			} catch (Exception e) {}
			
			
			try {
				sum+=oldworld[x][y-i].getFlora();
			} catch (Exception e) {}
			
			
			try {
				sum+=oldworld[x][y+i].getFlora();
			} catch (Exception e) {}
		}
		flora = sum;
	}
	
}
