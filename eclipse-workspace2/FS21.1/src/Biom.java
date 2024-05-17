interface Biom {

	public String getBiomType();
    /*
     *       "W" fuer Wasser
     *       "F" fuer Flachland
     */

	public int getFlora();
	
	public int getHeight();
	
	public void stepDryUp();
	
	public void stepDistribute(int p, Biom[][] oldworld);
}