import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice
// Una lista simplemente enlazada
public class LinkedListMauricio {
private Node first;
private int size;
public LinkedListMauricio(){
	size = 0;
	first = null;	
}

	/**
	 * Returns the node at the specified position in this list.
	 * @param index - index of the node to return
	 * @return the node at the specified position in this list
	 * @throws IndexOutOfBoundsException
	 */
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

	/**
	 * Returns the element at the specified position in this list.
	 * @param index - index of the element to return
	 * @return the element at the specified position in this list
         * @throws IndexOutOfBoundsException
	 */
	public int get(int index) throws IndexOutOfBoundsException {
		temp = getNode(index);
		return temp.data;
	}

// Retorna el tamaño actual de la lista
<<<<<<< HEAD
public int size(){
=======
public int size()
{
>>>>>>> cb28804c7ed55e33b129fcde79dab0b28cc97082
	return size;
}

// Inserta un dato en la posición index
<<<<<<< HEAD
public void insert(int data, int index) throws IndexOutOfBoundsException {
	if(index==0){
    Node temp=first;
    Node a= new Node(data);
    a.next=temp;
    first=a;
    size++;
  }
  if(index>size){
    throw new IndexOutOfBoundsException();
  }else{
    Node anterior= getNode(index-1);
    Node temp= new Node(data);
    temp.next=anterior.next;
    anterior.next=temp;
    size++;
  }
    
  }
}

// Borra el dato en la posición index
public void remove(int index){
   if (index == 0){
     first = first.next;
   }else{
	 	Node anterior = getNode(index-1);
   	anterior.next = anterior.next.next;
	 }
}

private boolean containsAux(int ElDato, Node nodo){
     if (nodo == null) // Condicion de parada
        return false;
     else
        if (nodo.data == ElDato) // Otra condicion de parada
          return true;
        else  // Caso inductivo T(n) = T(n-1) + C = O(n)
          return containsAux(ElDato, nodo.next);
  }
=======
public void insert(int data, int index)
{
	if(index==0){
		Node a= first;
	}
}

// Borra el dato en la posición index
public void remove(int index)
{
   if (index == 0){
     first = first.next;
   }
   else{
	 Nodo anterior = get(index-1);
   	 anterior.next = anterior.next.next;
   }
}
	
>>>>>>> cb28804c7ed55e33b129fcde79dab0b28cc97082
// Verifica si está un dato en la lista
public boolean contains(int data){
   // Si el dato está a partir del primero
	 return containsAux(data, first); 
}
<<<<<<< HEAD
  
public int search(int data){
  
}

}

public class Node {
    public int data;
    public Node next;
  
    public Node(int data){
        next = null;
        this.data = data;
    }
        
}
=======
	
private boolean containsAux(int ElDato, Node nodo){
     if (nodo == null) // Condicion de parada
        return false;
     else
        if (nodo.data == ElDato) // Otra condicion de parada
          return true;
        else  // Caso inductivo T(n) = T(n-1) + C = O(n)
          return containsAux(ElDato, nodo.next);
}

}
>>>>>>> cb28804c7ed55e33b129fcde79dab0b28cc97082
