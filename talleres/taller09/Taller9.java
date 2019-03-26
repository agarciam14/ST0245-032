import java.util.HashMap;

/**
 * Dar solucion taller numero 9
 * Se recomienda hacer una clase o metodo main que instancie esta clase de manera que sirva como test
 * y desarrolle las actividades y cuestiones presentadas en el taller.
 * En esta clase se hará uso total de la clase HashMap:
 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html">HashMap API</a>
 * @version 1
 * @author Anthony García, Daniel Hincapié
 */
public class Taller9{
	
    public static void main(String[] args){
		//Punto 2
		HashMap companies2 = new HashMap();
		agregar(companies2,"Google","Estados Unidos");
		agregar(companies2,"La locura","Colombia");
		agregar(companies2,"Nokia","Finlandia");
		agregar(companies2,"Sony","Japón");
		
		
		//Punto 3
		System.out.println(buscar(companies2,"Google"));
		System.out.println(buscar(companies2,"Motorola"));
		
		//Punto 4
		System.out.println(contieneValue(companies2,"India"));
		System.out.println(contieneValue(companies2,"Estados Unidos"));
	}
    
    /** 
    * pedrito 2
    * @param empresas es el hashmap ya creado donde se guardaran los valores 
    * @param key es la llave en el conjunto
    * @param value es el valor asociado a la llave key
    * El metodo agregara un nuevo valor a empresas con los atributos key y value.
    */
    public static void agregar(HashMap empresas,String key, String value){
        empresas.put(key, value);
    }
    
    /** 
    * pedrito 3
    * @param empresas es el hashmap ya creado donde se guardaran los valores 
    * @param key es la llave en el conjunto
    * 
    * El metodo buscara el valor asociado a la llave key
    * @return true, si lo encuentra, false de lo contrario.
    */
    public static boolean buscar(HashMap empresas,String key){
        if(empresas.containsKey(key)){
			System.out.println("  -> "+empresas.get(key));
		}
        return empresas.containsKey(key);
    }

    /** 
    * pedrito 4
    * @param empresas es el hashmap ya creado donde se guardaran los valores 
    * @param value es el valor asociado a la llave key
    * El metodo nos dira si hay una llave asociado al valor value.
    * @return true, si lo encuentra, false de lo contrario.
    */
    public static boolean contieneValue(HashMap empresas,String value){
        return empresas.containsValue(value);
    } 
}
