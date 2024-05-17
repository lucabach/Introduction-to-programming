
public class FlachLandBiom implements Biom {
	
	int flora;
	int height;
	World world;
	int x; int y;

	
	public FlachLandBiom(World world, int x, int y) {
		this.flora = 12;
		this.height = 3;
		this.world = world;
		this.x=x;
		this.y=y;
	}
	
	
	public String getBiomType() {
		return "F";
	}

	public int getFlora() {
		return flora;
	}
	
	public int getHeight() {
		return height;
	}
	
	public void stepDryUp() {
		flora = Math.max(flora-3, 0);
		int newheight = height-1;
		if(newheight==0) {
			WaterBiom w = new WaterBiom(world, x, y);
			w.flora = this.flora;
			world.biom[x][y]=w;
		}
		else {
			height = newheight;
		}
	}
	
	public void stepDistribute(int p, Biom[][] oldworld) {
		int sum = 0;
		int fneighbors = 0;
		for(int i=1; i<=p; i++) {
			
			try {
				if(oldworld[x-i][y].getBiomType().equals("F")){
					fneighbors++;
				}
				sum+=oldworld[x-i][y].getFlora();
			} catch (Exception e) {}
			
			
			try {
				if(oldworld[x+i][y].getBiomType().equals("F")){
					fneighbors++;
				}
				sum+=oldworld[x+i][y].getFlora();
			} catch (Exception e) {}
			
			
			try {
				if(oldworld[x][y-i].getBiomType().equals("F")){
					fneighbors++;
				}
				sum+=oldworld[x][y-i].getFlora();
			} catch (Exception e) {}
			
			
			try {
				if(oldworld[x][y+i].getBiomType().equals("F")){
					fneighbors++;
				}
				sum+=oldworld[x][y+i].getFlora();
			} catch (Exception e) {}
		}
		flora = sum;
		height = height + fneighbors;
	}
}
