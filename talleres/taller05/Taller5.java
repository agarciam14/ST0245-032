
/**
 * La clase Taller5 tiene la intención de resolver el taller número 4.
 *
 * @author Anthony García, Daniel Hincapié
 * @version 1
 */

public class Taller5 {  
    public static void main(String[]args){
        int[]arr=new int[30];
        for(int i=0; i<20; i++){
            arr[i]=(int)(Math.random()*100);
        }
        insertionSort(arr);
        for(int i=0; i<20; i++){
            System.out.println(arr[i]);
        }
    }
    
    /**
     * @param array es una arreglo de numeros enteros.
     * El método suma tiene la intención de hacer el proceso de suma
     * mediante una funcion cíclica (while/for/...)
     * @return la suma de todos los numeros sumados.
     */
    public static int suma (int[]array){
        int sum=0; //c1
        for (int i=0; i<array.length;i++){ //c2*n
            sum+=array[i]; //c3*n
        }
        return sum; //c4
        //T(n)= c1+c2*n+c3*n+c4
        //T(n)= O(n)
    }

    /**
     * @param num es el numero el cual se utiliza para ser multiplicado.
     * El método mul tiene la intención de hacer la multiplicación
     * de 1 a n por el numero mul
     * mediante una funcion cíclica (while/for/...)
     * 
     */
    public static void mul (int num){
        //...
    }

    /**
     * @param array es un arreglo de números desordenados
     * El método insertionSort tiene la intención ordenar los números
     * del arreglo array por el método insertion:
     * @see <a href="https://www.youtube.com/watch?v=OGzPmgsI-pQ"> Insertion Sort <a/>
     * mediante la anidación de funciones cíclicas (while/for/...)
     * 
     */
    public static int[] insertionSort (int[] array){
        for(int i=0;i<array.length-1;i++){ //c0*n
            int menor=array[i]; //c1*n
            int id=i; //c2*n
            for(int j=i; j<array.length;j++){ //c3*(n^2)
                if(array[j]<menor){ //c4*(n^2)
                    menor= array[j]; //c5*(n^2)
                    id=j; //c6*(n^2)
                }
            }
            int a=array[i]; //c7*n
            array[i]=array[id]; //c8*n
            array[id]=a; //c9*n
        }
        return array; // c10
    }    
}