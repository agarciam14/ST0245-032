package Taller__8;
import java.util.*;

/**
 * La clase Taller8 tiene la intención de
 * enfatizar en el uso de pilas y colas ya 
 * implementadas en java
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Queue.html"> Ver más acerca de colas<a/>
 * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html"> Ver más acerca de pilas <a/> 
 * @author Mauricio Toro, Andrés Páez 
 */
public class Taller8 {
	
    /**
    * @param stack es una pila ya implementada que se crea en el test
    * Este método se encarga de poner la pila stack en orden inverso
    * Nota: recuerde que la funcion pop() no solo expulsa la última 
    * posición de una pila si no que tambien devuelve su valor.
    * @return una pila que haga el inverso de stack
    */
    public static Stack<Integer> inversa (Stack<Integer> stack){
        Stack<Integer> temp= new Stack<Integer>();
      	for(int i=0;!stack.empty();++i){
          temp.push(stack.pop());
        }
      return temp;
    }
    
    
    /**
    * @param queue es una cola ya implementada que se crea en el test
    * Este método se encarga de atender a personas.
    * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
    * existe una función "pull" que hace el trabajo más fácil
    * 
    */
    public static void cola (Queue<String> solicitudes, Stack<String> neveras ){
        for(int i=0;solicitudes.peek()!=null;++i){
            try{
                String x=neveras.pop();
                System.out.println(i+1+") Tienda: "+solicitudes.poll()+" Nevera: "+x);
            }catch(EmptyStackException e){
                System.out.println(i+1+") Tienda: "+solicitudes.poll()+" Neveras agotadas");
            }
        }
    }
    
    
    /**
    * @param string es una cadena de texto que viene de este modo 3 4 5 * + o de esta manera 2 3 * 5 +
    * todo viene separado por espacios por lo que la funcion split.("") vendría muy bien para separarlos
    * Se intenta hacer el calculo por medio del metodo polaco posfijo
    * @return un entero resultado de la operación
    */
    public static double polaca  (String string){
        String[] parts=string.split(" ");
      	Stack <Double> temp= new Stack<Double>();
      	for(int i=0;i<parts.length;++i){
          try{
            double a=Double.parseDouble(parts[i]);
            temp.push(a);
          }catch(NumberFormatException enf){
            switch (parts[i]){
              case '+':
                temp.push(temp.pop()+temp.pop());
              	break;
              case '-':
                int b= temp.pop();
                int a= tem.pop();
                temp.push(a-b);
                break;
              case '*':
                temp.push(temp.pop()*temp.pop());
              	break;
              case '/':
                int b= temp.pop();
                int a= tem.pop();
                temp.push(a/b);
                break;
            }
          }
        }
      return parts.pop();
    }
