/**
 * The class Punto represents coordinates in the space and calcualtes their distance.
 *
 * @author Anthony García, Daniel Hincapié
 * @version 1
 */
import java.lang.Math;

public class Punto {

    private double x, y;

    /**
     * Strat the variables. Global variables can't have any null value or 0s.
     */
    public Punto(double x, double y) {
        this.x =x;
        this.y=y;
    }

    /**
     * Gets the global variable x. 
     *
     * @return coordinate axis x.
     */
    public double x() {
        return x;
    }

    /**
     * Gets the the global variable y.
     *
     * @return coordinate axis x.
     */
    public double y() {
        return y;
    }

    /**
     * This method gets the polar radio through the Pythagoras theorem.
     *
     *
     * @return polar radio 
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> see more <a/>
     */

    public double radioPolar() {
        return Math.sqrt(y*y+x*x);
    }


    /**
     * This method gets the polar angle through the reverse tangent.
     *
     *
     * @return polar angle.
     *
     * @see <a href="http://mathworld.wolfram.com/PolarCoordinates.html"> see more <a/>
     */
    public double anguloPolar() {
        return Math.atan(y/x);
    }

    /**
     * Gets the Euclidean distance.
     *
     *
     *
     * @return Euclidean distance
     *
     * @param otro This parameter refers to another Point in the space with which you want to compare the Point from which it was called.
     * @see <a href="http://mathworld.wolfram.com/Distance.html"> see more <a/>
     */

    public double distanciaEuclidiana(Punto otro) {
        return Math.sqrt((x-otro.x)*(x-otro.x)+(y-otro.y)*(y-otro.y));
    }
}
