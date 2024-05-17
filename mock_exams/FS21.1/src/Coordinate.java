import java.util.*;

public class Coordinate implements Comparable<Coordinate>{
	
  private double x;
  private double y;
  public int freq;
  public List<Coordinate> samefreq;
  public Integer conflicting;

  public Coordinate(double x, double y) {
    this.x = x;
    this.y = y;
    samefreq = new ArrayList<Coordinate>();
    samefreq.add(this);
  }
  
  
  @Override
  public int compareTo(Coordinate a) {
	  return a.conflicting-conflicting;
  }

  public double getX() {
    return this.x;
  }
  
  public double getY() {
    return this.y;
  }
  
  public double distance(Coordinate c) {
    return Math.sqrt( Math.pow(this.x-c.getX(), 2) + Math.pow(this.y-c.getY(), 2) );
  }
  
  public String toString(){//overriding the toString() method  
	  return "("+this.getX()+", "+this.getY()+")";  
  }
  
}