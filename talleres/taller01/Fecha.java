/**
 * The class Fecha represents the abstract datatype fecha.
 * Even though exist some libraries doing this function.
 * @see <a href="http://www.baeldung.com/java-8-date-time-intro"> See documentation Time </a>
 * In this exercise we can have a deeper understanding of its internal functioning.
 *
 * @author Anthony García, Daniel Hincapié
 * @version 1
 */

public class Fecha {


    /*
    varibales with final attribute indicate the variable is 
    a constant type variable, it means it won't allow make changes on the value.
    */

    private final short dia;
    private final short mes;
    private final short anyo;


    /**
     * Start the global variables. The builder method ca't have any null value or 0s.
     */
    public Fecha(short d,short m,short a) {
        dia=d;
        mes=m;
        anyo=a;
    }

    /**
     * This method gets the variable dia..
     *
     * @return el dia
     */
    public short dia() {
        return dia;
    }

    /**
     * Método para obtener la variable global mes.
     *
     * @return el mes
     */
    public short mes() {
        return mes;
    }

    /**
     * This mtehod gets the variable anio.
     *
     * @return el año
     */
    public short anio() {
        return anyo;
    }

    /**
     * @param represents the date it will get compare with.
     *
     * El método comprar se encarga de devolvernos respuesta a tres posibilidades.
     * 1: if the date is less than the other one, returns -1.
     * 2: if the date is  the same , returns 0.
     * 3: if the date is higher than the other one, returns 1.
     *
     * @return -1 if is less; 0 if is the same; 1 if is higher.
     *
     */

    public int comparar(Fecha otra) {
        if(otra.anyo==anyo&&otra.mes==mes&&otra.dia==dia) {
            return 0;
        }else{
            if (otra.anyo > anyo) {
                return -1;
            } else {
                if (otra.anyo < anyo) {
                    return 1;
                } else {
                    if (otra.mes > mes) {
                        return -1;
                    } else{
                        if(otra.mes<mes){
                            return 1;
                        }else{
                            if(otra.dia>dia){
                                return -1;
                            }else{
                                return 1;
                            }
                        }
                    }
                }
            }
        }
    }


    /**
     * toString will turn the date into a string.
     *
     *
     * @return a string which contains the date
     */
    public String toString() {
        return dia+"/"+mes+"/"+anyo;
    }
}
