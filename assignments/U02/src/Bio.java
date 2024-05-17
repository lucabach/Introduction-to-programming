
public class Bio implements Biom {
	
	public String type;
	public int flora;
	public int height;

	
		
	Bio(String type, int flora, int height){
		this.type = type;
		this.flora = flora;
		this.height = height;
	}
	
	public String getBiomType(){
		return this.type;
	}
    /*
     *       "W" fuer Wasser
     *       "F" fuer Flachland
     */

	public int getFlora(){
		return this.flora;
	}
	
	public int getHeight(){
		return this.height;
}
}