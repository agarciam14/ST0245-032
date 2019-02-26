public class MiArrayList {
    private int size;
    private static final int DEFAULT_CAPACITY =10;
    private int elements[]; 
    
    /**
    * El metodo constructor se utiliza para incializar
    * variables a valores neutros como 0 o null.
    * El contructor no lleva parámetros en este caso.
    */
    public MiArrayList() {
        size = 0;
        elements = new int[DEFAULT_CAPACITY];
    }     

    
    /**
    * Tiene la intención de retornar la longitud del objeto
    * @return longitud del objeto
    *
    * El size esta influenciado por las funciones add y del
    */
    public int size() {
        return size;
    }   
    
    /** 
    * @param e el elemento a guardar
    * Agrega un elemento e a la última posición de la lista
    *
    */
    public void add(int e) {
        if(size==elements.length){ //C1
          int[] a= new int[elements.length+10]; //C2
          for(int i=0; i<elements.length;i++){  //C3*n
            a[i]=elements[i];  //C4*n
          }
          a[size]=e;//C5
          elements=a;//C6
          size++;//C7
        }else{
          elements[size]=e;//C8
          size++;//C9
        }
    }
    /* T(n)= C8+C9, si size!=tamaño del arreglo -> O(1)
       T(n)= C3*n, para el peor de los casos -> O(n)
    */
    
    
    /** 
    * @param i es un íncide donde se encuentra el elemento posicionado
    * Retorna el elemento que se encuentra en la posición i de la lista.
    *
    */
    public int get(int i) throws ArrayIndexOutOfBoundsException {
        if (i < 0 || i >= size)
           throw new ArrayIndexOutOfBoundsException("perdon usuario, pero i= " + i + " ,pero size = " + size);
        else
           return elements[i];
    }
    
    
    /**
    * @param index es la posicion en la cual se va agregar el elemento
    * @param e el elemento a guardar
    * Agrega un elemento e en la posición index de la lista
    *
    */
    public void add(int index, int e) throws ArrayIndexOutOfBoundsException {
        if(index<=size){
          if(size==elements.length){
              int[] a= new int[elements.length+10];
              for(int i=0; i<index;i++){
                a[i]=elements[i];
              }
              a[index]=e;
              for(int i=index;i<elements.length;i++){
                a[i+1]=elements[i];
              }
              elements=a;
              size++;
          }else{
            for(int i=size; i>index;i--){
              elements[i]=elements[i-1];
            }
            elements[index]= e;
            size++;
          }
        }else{
          throw new ArrayIndexOutOfBoundsException();
        }
    } 

    /**
    * @param index es la posicion en la cual se va agregar el elemento
    *
    * ELimina el elemento  en la posición index de la lista
    *
    */
    public void del(int index)throws ArrayIndexOutOfBoundsException{
        if(index>=size)
          throw new ArrayIndexOutOfBoundsException();
      	for(int i=index;i<size-1;i++){
          elements[i]=elements[i+1];
        }
      	elements[size-1]=0;
      	size--;
    }
}
