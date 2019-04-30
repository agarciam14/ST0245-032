import java.util.*;
public class Main 
{
    
    public boolean punto1(Digraph g, int origen, int destino){
        boolean[] visitados=new boolean[g.size];
        return punto1Aux(g,origen,destino, visitados);
    }

    private boolean punto1Aux(Digraph g, int origen, int destino, boolean[]visitados){
        ArrayList<Integer>vecinos=g.getSuccessors(origen);
        visitados[origen]=true;
        boolean respuesta=false;
        for(Integer vecino:vecinos){
            if(visitados[vecino]!=false){
            respuesta=respuesta||punto1Aux(g,vecino,destino,visitados);
            }
            
        }
        return respuesta;
    }
    
    public  boolean punto2(Digraph g, int origen, int destino){
        boolean[] visitados=new boolean[g.size];
        return punto1Aux(g,origen,destino, visitados);
    }
    
    public  boolean punto2Aux(Digraph g, int origen, int destino){
    ArrayList<Integer>hijos=g.getSuccessors(origen);
    LinkedList <Integer> h= new LinkedList<>();
    boolean respuesta=false;
    h.add(origen);
    for(int i=0;i<hijos.size();i++){
        
    if(hijos.get(i)==destino){
        return true;
    }
    else{
    h.add(hijos.get(i));
    }
    }
    h.remove();
    return respuesta||punto2Aux(g,h.peek(),destino);
    }
}
