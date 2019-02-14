/**
 *La clase Taller4 tiene como objetivo dar solución al taller4
 *
 *@autor Anthony García, Daniel Hincapié
 *@version 1
 */

import java.util.concurrent.TimeUnit;
public class Taller4{

    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return la suma de todos los numeros sumados.
     */
    public static void main(String[] args){
        for(int i = 1; i <= 20; i++)
            arraySum(new int[i]);
        for(int i = 1; i <= 20; i++){
            
        }
        System.out.println("Punto 3");
        for(int i = 18; i <= 38; i++){
            long start = System.currentTimeMillis();
            fibonacci(i);
            long tiempo =  System.currentTimeMillis() - start;
            System.out.println(tiempo);
        }
    }
    public static int suma(int [] a){
        int acum=0;
        for(int i=0;i<=a.length;i++){
            acum+=a[i];
        }
        return acum;
    }
    
    // Operaciones que realiza T(n) = cn + c1
    private static int arraySum(int[] a,int i){  
        try{
            TimeUnit.SECONDS.sleep(1);
        }
        catch (Exception e){
        }
        if (i == a.length) // C1
            return 0;  // C2
        else
            return a[i] + arraySum(a, i+1); // C3 + T(n-1) 
    }

    public static int arraySum(int[] a){
        long start = System.currentTimeMillis();
        int s = arraySum(a,0);
        long tiempo =  System.currentTimeMillis() - start;
        System.out.println(tiempo);
        return s;
    }

    /**
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param array es un arreglo de numeros enteros, representan volumen
     * @param target es la meta, el numero que debe alacanzar la suma 
     *
     * en este método se busca hacer la suma de los volumnes posibles
     * de modo que se acomode de tal forma que se alcance el valor target
     * pista: la clave esta en el numero de elementos y que no siempre se toman
     * los elementos, en ocaciones pasan por ejemplo en un conjuntos [5,6,7,8] para un
     * target 12 se toman el 5 y el 7 pasando por 6 sin cogerlo.
     *
     *
     * @return verdadero si hay una combinación que suponga el valor target, falso de lo contrario
     */
     public static boolean groupSum(int start, int[] nums, int target) {
        if(start >= nums.length) //C1
            return target == 0; //C2
        return groupSum(start + 1, nums, target - nums[start]) || groupSum(start + 1, nums, target);
    }

    /**
     * @param n numero entero, hasta que numero se hace la serie
     *
     * el metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @see <a href="https://es.wikipedia.org/wiki/Sucesi%C3%B3n_de_Fibonacci"> fibonnaci <a/>
     * @return el valor encontrado en long dada la posible cantidad de bits
     */
    public static int fibonacci(int n){
        return n <= 1 ? n : fibonacci(n-1)+fibonacci(n-2);
    }
}
