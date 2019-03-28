import java.util.*;

public class ejercicioEnLinea {
  
  public  static void Teclado(String texto) {
        LinkedList lista = new LinkedList();
        char[] texto1 = texto.toCharArray();
        boolean inicio = false;
        boolean Final = false;
        String temp = "";
        String temp2 = "";
        for(int i = 0; i < texto1.length; i++){
            if(inicio == true && i == texto1.length - 1
            || inicio == true && texto1[i] == ']'  
            || inicio == true && texto1[i] == '['){
                lista.add(temp2);
                lista.addFirst(temp);
                temp = "";
                temp2 = "";
                inicio = false;
            }

            else if(Final == true  && i == texto1.length - 1
            || Final == true && texto1[i] == '['
            ||inicio == true && texto1[i] == ']'){
                lista.add(temp2);
                lista.addLast(temp);
                temp2 = "";
                temp = "";
                Final = false;
            }

            if(texto1[i] == '['){
                inicio = true;
                temp2 = temp;
                temp = "";
            } 

            if(texto1[i] == ']'){
                Final = true;
                temp2 = temp;
                temp = "";
            } 

            if (texto1[i]!='[' && texto1[i]!=']'){
                temp += texto1[i];
            }
        }

        for(int i = 0; i < lista.size(); i++){
            System.out.print(lista.get(i));
        }
    }
    
    
public class Punto2{
	public static Stack<Integer>[] bloques;
	
	public static void main(String[] args){
		String[] instrucciones={
			"10",
			"move 9 onto 1",
			"move 8 over 1",
			"move 7 over 1",
			"move 6 over 1",
			"pile 8 over 6",
			"pile 8 over 5",
			"move 2 over 1",
			"move 4 over 9",
			"quit"		};
		lector(instrucciones);
	}
	
	private static void lector(String[] ins){
		String[] x;
		for(int i=0;i<ins.length;i++){
			x=ins[i].split(" ");
			if(x.length==1){
				try{
					int n= Integer.parseInt(ins[i]);
					number(n);
				}catch(NumberFormatException nfe){
					quit();
				}
			}else{
				int a= Integer.parseInt(x[1]);
				int b= Integer.parseInt(x[3]);
				if(x[0].equals("move")){
					if(x[2].equals("onto")){
						moveOnto(a,b);
					}else{
						moveOver(a,b);
					}
				}else{
					if(x[2].equals("onto")){
						pileOnto(a,b);
					}else{
						pileOver(a,b);
					}
				}
			}
		}
	}
	
	private static void number(int l){
		bloques= new Stack[l];
		for(int i=0;i<l;i++){
			bloques[i]= new Stack<Integer>();
			bloques[i].push(i);
		}
	}
	
	private static int search(int x){
		int v=-1;
		for(int i=0;i<bloques.length&&v==-1;i++){
			Stack<Integer> temp= new Stack<Integer>();
			temp=bloques[i];
			v=temp.search(x);
      if(v!=-1){
        return i;
      }
		}
		return v;
	}
	
	private static void moveOnto(int a, int b){
		int ap= search(a);
		int bp= search(b);
		while(bloques[ap].peek()!=a){
			int t= bloques[ap].pop();
			bloques[t].push(t);
		}
		while(bloques[bp].peek()!=b){
			int t= bloques[bp].pop();
			bloques[t].push(t);
		}
		bloques[bp].push(bloques[ap].pop());
	}
	
	private static void moveOver(int a, int b){
		int ap= search(a);
		int bp= search(b);
		while(bloques[ap].peek()!=a){
			int t= bloques[ap].pop();
			bloques[t].push(t);
		}
		bloques[bp].push(bloques[ap].pop());
	}
	
	private static void pileOnto(int a, int b){
		int ap= search(a);
		int bp= search(b);
		while(bloques[bp].peek()!=b){
			int t= bloques[bp].pop();
			bloques[t].push(t);
		}
		Stack<Integer> temp= new Stack<Integer>();
		while(bloques[ap].peek()!=a){
			temp.push(bloques[ap].pop());
		}
		bloques[bp].push(bloques[ap].pop());
		while(!temp.empty()){
			bloques[bp].push(temp.pop());
		}
	}
	
	private static void pileOver(int a, int b){
		int ap= search(a);
		int bp= search(b);
		Stack<Integer> temp= new Stack<Integer>();
		while(bloques[ap].peek()!=a){
			temp.push(bloques[ap].pop());
		}
		bloques[bp].push(bloques[ap].pop());
		while(!temp.empty()){
			bloques[bp].push(temp.pop());
		}
	}
	
	private static void quit(){
		for(int i=0;i<bloques.length;i++){
			System.out.print(i+":");
			Stack<Integer> temp= new Stack<Integer>();
			while(!bloques[i].empty()){
				temp.push(bloques[i].pop());
			}
			while(!temp.empty()){
				System.out.print(" "+temp.pop());
			}
			System.out.println();
		}
	}
}
}
