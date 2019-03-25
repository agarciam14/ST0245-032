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
}
