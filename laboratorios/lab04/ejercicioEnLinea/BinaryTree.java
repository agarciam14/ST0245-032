public class BinaryTree {
    Node raiz;  
    public BinaryTree(){
        raiz = null; 
    } 

    public Node getNode(){
        return raiz;
    }

    public void insertar(int numero){
        raiz = insertarAux(raiz, numero);
    }

    public Node insertarAux(Node raiz, int numero) {
        if (raiz == null){
            raiz = new Node(numero);
            return raiz;
        }
        if (numero < raiz.numero){
            raiz.izquierda = insertarAux(raiz.izquierda, numero);
        } else if (numero > raiz.numero) {
            raiz.derecha = insertarAux(raiz.derecha, numero);
        }
        return raiz;
    }

    public void printPO(Node raiz) {
        if(raiz != null){
            printPO(raiz.izquierda);
            printPO(raiz.derecha);
            System.out.println(raiz.numero);
        }
    }

    public static void main(String[] args) {
        BinaryTree arbol = new BinaryTree();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(24);
        arbol.insertar(5);
        arbol.insertar(28);
        arbol.insertar(45);
        arbol.insertar(98);
        arbol.insertar(52);
        arbol.insertar(60);
        arbol.printPO(arbol.getNode());
    }
}
