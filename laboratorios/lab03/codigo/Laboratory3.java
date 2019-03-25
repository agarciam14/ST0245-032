public class Laboratory3 {
  
  public static void Pivote(List<Integer> lista) {
        int ite = lista.size() / 2;
        int pivote = 0;
        boolean boolPiv = true;
        int sumDer = 0;
        int sumIzq = 0;
        
        for (int i = ite + 1; i < lista.size(); i++) {
            sumDer += (int) lista.get(i);
        }
        for (int i = 0; i < ite; i++) {
            sumIzq += (int) lista.get(i);
        }
        if (sumDer == sumIzq) {
            System.out.println("Pivote correcto: " + lista.get(ite)+" posicion: "+ite);
            boolPiv = false;
        }
        else {
            pivote = (int) lista.get(ite);
            int diferencia = Math.abs(sumDer - sumIzq);
            int diferenciaAux = 0;
            while (boolPiv) {
                if (sumDer > sumIzq) {
                    ite += 1;
                    sumDer = 0;
                    sumIzq = 0;
                    for (int i = ite +1; i < lista.size(); i++) {
                        sumDer += (int) lista.get(i);
                    }
                    for (int i = 0; i < ite; i++) {
                        sumIzq += (int) lista.get(i);
                    }
                    diferenciaAux = Math.abs(sumDer - sumIzq);
                    if (diferencia > diferenciaAux) {
                        diferencia = diferenciaAux;
                        pivote = (int) lista.get(ite);

                    }
                    else{
                        boolPiv = false;
                    }
                }
                else{
                    sumDer = 0;
                    sumIzq = 0;
                    ite -= 1;
                    for (int i = ite+1; i < lista.size(); i++) {
                        sumDer += (int) lista.get(i);
                    }
                    for (int i = 0; i < ite; i++) {
                        sumIzq += (int) lista.get(i);
                    }
                    diferenciaAux = Math.abs(sumDer - sumIzq);
                    if (diferencia > diferenciaAux) {
                        diferencia = diferenciaAux;
                        pivote = (int) lista.get(ite);
                    }
                    else{
                        boolPiv = false;
                    }
                }
                if (ite == lista.size() || ite == 0) {
                    boolPiv = false;
                    pivote = (int) lista.get(ite);
                }
            }
            System.out.println("El mejor pivote es: " + pivote + " ubicado en la posición: " + ite);
        }
    }
  
  
  
  
  
  public class LinkedListMauricio {
private Node first;
private int size;
public LinkedListMauricio(){
	size = 0;
	first = null;	
}

	private Node getNode(int index) throws IndexOutOfBoundsException {
		if (index >= 0 && index < size) {
			Node temp = first;
			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return temp;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	public int get(int index) throws IndexOutOfBoundsException {
		Node temp = getNode(index);
		return temp.data;
	}
    
public int size(){
	return size;
}
    
public void insert(int data, int index) throws IndexOutOfBoundsException {
	if(index>size){
    throw new IndexOutOfBoundsException();
  }else{
    if(index==0){
      Node temp=first;
      Node a= new Node(data);
      a.next=temp;
      first=a;
      size++;
    }else{
      Node anterior= getNode(index-1);
      Node temp= new Node(data);
      temp.next=anterior.next;
      anterior.next=temp;
      size++;
    }
  }
}

public void remove(int index) throws IndexOutOfBoundsException{
   if (index>=size){
     throw new IndexOutOfBoundsException();
   }else{
    	if (index == 0){
       first = first.next;
       size--;
     }else{
      Node anterior = getNode(index-1);
      anterior.next = anterior.next.next;
      size--;
     }
   }
}

private boolean containsAux(int ElDato, Node nodo){
     if (nodo == null) 
        return false;
     else
        if (nodo.data == ElDato) 
          return true;
        else  
          return containsAux(ElDato, nodo.next);
  }
public boolean contains(int data){
   
	 return containsAux(data, first); 
}
  
    
    
    
  public static void neveras (Queue<String> solicitudes, Stack<String> neveras ){
        for(int i=0;solicitudes.peek()!=null;++i){
            try{
                String x=neveras.pop();
                System.out.println(i+1+") Tienda: "+solicitudes.poll()+" Nevera: "+x);
            }catch(EmptyStackException e){
                System.out.println(i+1+") Tienda: "+solicitudes.poll()+" Neveras agotadas");
            }
        }
    }
}
