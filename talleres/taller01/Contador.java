/**
 * The class Contador represents a counter.
 *
 * @author Anthony García, Daniel Hincapié
 * @version 1
 */

public class Contador {

    private int cuenta;
    private final String id;


    /**
     * Start the global variables. The builder method can't have null values or 0s.
     */
    public Contador(String id) {
        this.id=id;
        cuenta=0;
    }

    /**
     * The increment method increases the counter by one unit.
     *
     *(optional: you could pass a parameter "quantity" to increase that number of units).
     */
    public void incrementar() {
        cuenta++;
    }

    /*
    You could implement a decrease method to do the inverse operation increase method does.
    */

    /**
     * The increase method shows the actual count's value.
     * @return the actual count's value
     */
    public int incrementos() {
        return cuenta;
    }


    /**
     * toString will convert the counter into a string.
     * for its later visualization.
     * It must show the counter's status and id.
     *
     * @return a string which contains the counter's id an count.
     */
    public String toString() {
        return id+": "+cuenta;
    }
}
