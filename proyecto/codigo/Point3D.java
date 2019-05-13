 /**
 * This class creates Bee type objects
 * @author (Anthony García, Daniel Hincapié)
 */

public class Point3D{
    private double x;
    private double y;
    private double z;
  
    /**
     *This method build a Bee
     *@param double x
     *@param double y
     *@param double z
     *@return A new Bee
     */
    public Point3D(double X, double Y, double Z){
      x=X;
      y=Y;
      z=Z;
    }
    public double getX(){
      return x;
    }
    public double getY(){
      return y;
    }
    public double getZ(){
      return z;
    }
}