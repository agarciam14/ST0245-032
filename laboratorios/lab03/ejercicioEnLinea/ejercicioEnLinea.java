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
    
    
}
